package com.android.e_commerce_app.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.e_commerce_app.R
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase
import com.android.e_commerce_app.databinding.ActivityLoginBinding
import com.android.e_commerce_app.ui.main.MainActivity
import com.android.e_commerce_app.ui.register.RegisterActivity
import com.android.final_app.Base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException


class LoginActivity : BaseActivity<LoginViewModel,ActivityLoginBinding>(){




//    lateinit var google_signinOption:GoogleSignInOptions
//    lateinit var goodle_signinClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        dataBinding.lvm=viewModel


       observe_data()
       // sign_in_byGoogle()


        dataBinding.textInputLayoutPassword.setEndIconOnClickListener {
            val isPasswordVisible = dataBinding.password.inputType and InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            if (isPasswordVisible) {
                // Hide password
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
        return R.layout.activity_login
    }

    override fun get_view_model(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    fun observe_data(){

        viewModel.flagActivityRegister.observe(this, Observer {

            if(it) {
                startActivityRegister()
            }
        })

        viewModel.user_data.observe(this, Observer {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", it)
            startActivity(intent)
        })

        viewModel.toast.observe(this, Observer {
            if(it){
                Toast.makeText(this,"Invalidate Login",Toast.LENGTH_LONG).show()
            }
        })
//        viewModel.googleFlag.observe(this, Observer {
//            if(it){
//                //signIn()
//            }
//        })

    }

//    fun storeUserInDatabase(account: GoogleSignInAccount) {
//        val user = Entity1(
//            id=account.id!!.toInt(),
//            email = account.email ?: "",
//            password = account.displayName ?: ""
//        )
//
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("user", user)
//        startActivity(intent)
//
//        MyDataBase.getDataBase().productDao().insert_User(user)
//
//    }

//    fun sign_in_byGoogle(){
//
//        google_signinOption=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
//
//        goodle_signinClient= GoogleSignIn.getClient(this,google_signinOption)
//
//    }

//    fun signIn(){
//
//        val signInIntent:Intent=goodle_signinClient.getSignInIntent()
//        startActivityForResult(signInIntent,1000)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode === 1000) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                 var account=task.getResult(ApiException::class.java)
//                if(account!=null) {
//                    storeUserInDatabase(account)
//                    startActivity()
//                }
//            } catch (e: ApiException) {
//                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
//    }

    fun startActivityRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }





}