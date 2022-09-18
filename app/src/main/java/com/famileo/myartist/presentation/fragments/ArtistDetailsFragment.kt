package com.famileo.myartist.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.famileo.myartist.R
import com.famileo.myartist.core.InjectedViewModelFactory
import com.famileo.myartist.databinding.FragmentDetailsArtistBinding
import com.famileo.myartist.presentation.adapter.DiscographyAdapter
import com.famileo.myartist.presentation.common.FullMarginDecorator
import com.famileo.myartist.presentation.extension.setVerticalLinearLayoutManager
import com.famileo.myartist.presentation.viewmodels.DiscographyViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Artist Details fragment: Contain the artist details.
 * */
class ArtistDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: InjectedViewModelFactory

    /** Fragment arguments. */
    private val args: ArtistDetailsFragmentArgs by navArgs()

    private val viewModel: DiscographyViewModel by viewModels { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView: View
        FragmentDetailsArtistBinding.inflate(layoutInflater, container, false).apply {

            fragmentView = root
            fragmentArtistDiscographyToolbar.setNavigationOnClickListener { findNavController().popBackStack() }

            val discographyAdapter = DiscographyAdapter()
            viewModel.fetchArtistDiscography(artistId = args.artistId)

            fragmentArtistDiscographyRecyclerView.adapter = discographyAdapter
            fragmentArtistDiscographyRecyclerView.setVerticalLinearLayoutManager()
            fragmentArtistDiscographyRecyclerView.addItemDecoration(FullMarginDecorator(R.dimen.margin_large))
            fragmentArtistDiscographyRecyclerView.adapter = discographyAdapter

            viewModel.fetchArtistDiscography(artistId = args.artistId)
            lifecycleScope.launchWhenCreated {
                viewModel.artistsDiscography.collect {
                    discographyAdapter.submitList(it)
                }
            }

        }
        return fragmentView

    }
}