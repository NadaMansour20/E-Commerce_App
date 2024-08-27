package com.android.e_commerce_app.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.databinding.ActivityRegisterBinding
import com.android.e_commerce_app.ui.login.LoginActivity
import com.android.e_commerce_app.ui.main.MainActivity
import com.android.final_app.Base.BaseActivity

class RegisterActivity :BaseActivity<RegisterViewModel,ActivityRegisterBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.rvm=viewModel

        observe()



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

            Log.e("Userrrrrrrrrrrrrr","user${it}");
        })

        viewModel.flagActivityLogin.observe(this, Observer {
            if(it){
                startActivityLogin()
                Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show()
            }
        })

    }

    fun startActivityLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}