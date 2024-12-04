package com.codshooter.porter.utils

import android.content.Context

class LoginManager(val context: Context) {

    private val sharedPreferences by lazy {
        context.getSharedPreferences("NewUser", Context.MODE_PRIVATE)
    }

    fun setLogin(isNewUser: Boolean) {
        sharedPreferences.edit().putBoolean("isNewUser", isNewUser).apply()
    }

    fun getLogin(): Boolean {
        return sharedPreferences.getBoolean("isNewUser", true)
    }


}