package com.android.e_commerce_app.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityRegisterBinding
import com.android.e_commerce_app.ui.main.MainActivity
import com.android.final_app.Base.BaseActivity

class RegisterActivity :BaseActivity<RegisterViewModel,ActivityRegisterBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.rvm=viewModel

        observe()



        // Set the initial state of the password field to be hidden (dots)

        //password
        dataBinding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        dataBinding.textInputLayoutPassword.setEndIconDrawable(R.drawable.closeeye) // Initial icon should be 'closeeye'

        dataBinding.textInputLayoutPassword.setEndIconOnClickListener {
            val isPasswordVisible = dataBinding.password.inputType and InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            if (isPasswordVisible) {
                // Hide password
                dataBinding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                dataBinding.textInputLayoutPassword.setEndIconDrawable(R.drawable.closeeye)
            } else {
                // Show password
                dataBinding.password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                dataBinding.textInputLayoutPassword.setEndIconDrawable(R.drawable.openeye)
            }
            dataBinding.password.setSelection(dataBinding.password.text.length)
        }




    }

    override fun get_layoutId(): Int {
        return R.layout.activity_register
    }

    override fun get_view_model(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    fun observe(){

        viewModel.user_data.observe(this, Observer {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", it)
            startActivity(intent)
        })

        viewModel.flagActivityRegiterToMain.observe(this, Observer {
            if(it){
                startActivityMain()
            }
        })
    }

    fun startActivityMain(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}