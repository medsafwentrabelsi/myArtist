package com.famileo.myartist.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.famileo.myartist.core.InjectedViewModelFactory
import com.famileo.myartist.databinding.FragmentDetailsArtistBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Artist Details fragment: Contain the artist details.
 * */
class ArtistDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: InjectedViewModelFactory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentView: View
        FragmentDetailsArtistBinding.inflate(layoutInflater, container, false).apply {
            fragmentView = root


        }
        return fragmentView

    }
}