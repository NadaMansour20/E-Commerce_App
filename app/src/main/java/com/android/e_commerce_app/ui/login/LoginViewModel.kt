package com.android.e_commerce_app.ui.login

import android.content.Context
import android.provider.Settings.Secure.getString
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import com.android.e_commerce_app.R
import com.android.e_commerce_app.base.BaseViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel:BaseViewModel() {


    var Email= ObservableField<String>()
    var EmailError=ObservableField<String>()


    var Pass= ObservableField<String>()
    var PassError=ObservableField<String>()



    var auth=Firebase.auth
    fun register(){
        if(validate()){
            AddAccount()

        }
    }


    fun AddAccount(){

        auth.createUserWithEmailAndPassword(Email.get()!!,Pass.get()!!).addOnCompleteListener {task->

            if(task.isSuccessful){
                Log.e("firebase","successfully")


                //send in gmail to verify email
                val user=auth.currentUser
                user?.sendEmailVerification()?.addOnCompleteListener {verifyTask->

                    if(verifyTask.isSuccessful)
                    {
                        // massage send successfully in gemail

                    } else {

                        //error send

                    }
                }

            }
            else{

                Log.e("errrrorr",task.exception!!.localizedMessage)
            }
        }
    }


    fun validate():Boolean{

        var valid=true

        if(Email.get().isNullOrBlank()){

            valid=false
            EmailError.set("Please enter email")
        }
        else{
            EmailError.set(null)
        }

        if(Pass.get().isNullOrBlank()){

            valid=false
            PassError.set("Please enter password")
        }
        else{
            PassError.set(null)
        }

        return valid
    }


}