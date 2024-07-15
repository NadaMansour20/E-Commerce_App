package com.android.e_commerce_app.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityLoginBinding
import com.android.final_app.Base.BaseActivity

class LoginActivity : BaseActivity<LoginViewModel,ActivityLoginBinding>(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.lvm=viewModel


    }

    override fun get_layoutId(): Int {
        return R.layout.activity_login
    }

    override fun get_view_model(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }
}