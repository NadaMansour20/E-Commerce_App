package com.android.e_commerce_app.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import com.android.e_commerce_app.base.BaseViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel:BaseViewModel() {


    var Email= ObservableField<String>()
    var EmailError=ObservableField<String>()



    var auth=Firebase.auth
    fun register(){
        if(validate()){
            AddAccount()

        }
    }


    fun AddAccount(){

        auth.createUserWithEmailAndPassword(Email.get()!!, null.toString()).addOnCompleteListener {

            if(it.isSuccessful){
                Log.e("firebase","successfully")

            }
            else{
                Log.e("errrrorr",it.exception!!.localizedMessage)
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

        return valid
    }


}