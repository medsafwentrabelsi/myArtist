package com.famileo.myartist.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.famileo.myartist.R
import com.famileo.myartist.core.InjectedViewModelFactory
import com.famileo.myartist.databinding.FragmentListArtistBinding
import com.famileo.myartist.presentation.adapter.ArtistAdapter
import com.famileo.myartist.presentation.common.FullMarginDecorator
import com.famileo.myartist.presentation.extension.setVerticalLinearLayoutManager
import com.famileo.myartist.presentation.viewmodels.ArtistsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Artist fragment: Contain the list of artist.
 * */
class ArtistListFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: InjectedViewModelFactory

    private val viewModel: ArtistsViewModel by viewModels { viewModelFactory }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView: View
        FragmentListArtistBinding.inflate(layoutInflater, container, false).apply {
            fragmentView = root
            val artistAdapter = ArtistAdapter()


            fragmentArtistListSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.fetchArtist(it)
                    }
                    return false
                }
            })

            fragmentArtistListRecyclerView.setVerticalLinearLayoutManager()
            fragmentArtistListRecyclerView.addItemDecoration(FullMarginDecorator(R.dimen.margin_large))
            fragmentArtistListRecyclerView.adapter = artistAdapter


            lifecycleScope.launchWhenCreated {
                viewModel.artistsList.collect {
                    artistAdapter.submitList(it)
                }
            }



            artistAdapter.onItemClickListener = {
            }
        }

        return fragmentView
    }


}