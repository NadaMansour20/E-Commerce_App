package com.android.e_commerce_app.ui.login

import androidx.databinding.ObservableField
import com.android.e_commerce_app.base.BaseViewModel
import com.android.e_commerce_app.database.Entity1
import com.android.e_commerce_app.database.MyDataBase

class LoginViewModel: BaseViewModel() {


    var Email= ObservableField<String>()
    var EmailError=ObservableField<String>()


    var Pass= ObservableField<String>()
    var PassError=ObservableField<String>()



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

    fun signInByGoogle(){


        googleFlag.value=true
    }

    fun register(){

        if(validate()){


            val user= Entity1(0,Email.get().toString(), Pass.get().toString())

            MyDataBase.getDataBase().productDao().insert_User(user)


//            val userWithProducts = MyDataBase.getDataBase().productDao().getUserWithProducts(user.id)
//            val user_data = userWithProducts.user // بيانات المستخدم
//            val products_data = userWithProducts.products // قائمة المنتجات المرتبطة بهذا المستخدم
//
//            Log.e("Userrrrrrrrrrrrrrrrrrr","correct${user}")


            flagActivity.value=true

        }
    }


    fun validate():Boolean{

        var valid=true

        if(Email.get().isNullOrBlank()){

            valid=false
            EmailError.set("Please enter email")
        }
        if(!isValidEmail(Email.get().toString())){
            valid=false
            EmailError.set("Invalid email format")
        }
        else{
            EmailError.set(null)
        }

        if(Pass.get().isNullOrBlank()){

            valid=false
            PassError.set("Please enter password")
        }
        if(!isValidPassword(Pass.get().toString())){
            valid=false
            PassError.set("Password must be at least 6 characters, containing letters and digits")
        }
        else{
            PassError.set(null)
        }

        return valid
    }





}