package com.android.e_commerce_app.ui.register

import android.util.Log
import androidx.databinding.ObservableField
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase

class RegisterViewModel:BaseViewModel() {


    var Email= ObservableField<String>()
    var EmailError= ObservableField<String>()


    var Pass= ObservableField<String>()
    var PassError= ObservableField<String>()

    var confirmPass= ObservableField<String>()
    var confirmPassError= ObservableField<String>()

    var userName=ObservableField<String>()
    var userNameError=ObservableField<String>()



    val emailPattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$"
    val emailRegex = Regex(emailPattern)

    val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}\$"
    val passwordRegex = Regex(passwordPattern)

    fun isValidPassword(password: String): Boolean {
        return passwordRegex.matches(password)
    }

    fun isValidEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

//    fun signInByGoogle(){
//
//
//        googleFlag.value=true
//    }

    fun register(){

        if(validate()){

            val user= Entity1(0,userName.get().toString(),Email.get().toString(), Pass.get().toString())

                user_data.value=user
                MyDataBase.getDataBase().productDao().insert_User(user)


            flagActivityRegiterToMain.value=true

        }
    }


    fun validate():Boolean{

        var valid=true

        if(Email.get().isNullOrBlank()){

            valid=false
            EmailError.set("Please enter email")
        }
        else if(!isValidEmail(Email.get().toString())){
            valid=false
            EmailError.set("Invalid email format")
        }
        else{
            EmailError.set(null)
        }
        if(userName.get().isNullOrBlank()){
            valid=false
            userNameError.set("Please enter userName")
        }
        else{
            userNameError.set(null)
        }
        if(confirmPass.get().isNullOrBlank()){

            valid=false
            confirmPassError.set("Please enter confirm password")
        }
        if(confirmPass.get().toString()!=Pass.get().toString()){

            valid=false
            confirmPassError.set("not correct")
        }
        else{
            confirmPassError.set(null)
        }
        if(Pass.get().isNullOrBlank()){

            valid=false
            PassError.set("Please enter password")
        }
        else if(!isValidPassword(Pass.get().toString())){
            valid=false
            PassError.set("Password must be at least 6 characters, containing letters and digits")
        }
        else{
            PassError.set(null)
        }

        return valid
    }






}

