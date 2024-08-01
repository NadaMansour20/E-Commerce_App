package com.android.e_commerce_app.ui.profilefragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseFragment
import com.android.e_commerce_app.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

//    companion object {
//        fun newInstance() = ProfileFragment()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding.pvm = viewModel

    }


    override fun get_layout(): Int {
        return R.layout.fragment_profile
    }

    override fun get_viewModel(): ProfileViewModel {
        return ViewModelProvider(this).get(ProfileViewModel::class.java)
    }



}