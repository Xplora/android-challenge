package com.xplora.challenge.helpers

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.xplora.challenge.helpers.Constants.AUTH_TOKEN
import com.xplora.challenge.helpers.Constants.IS_LOGIN

object MyPreference {

    private var mSharedPref: SharedPreferences? = null

    fun init(context: Context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences("xplora_challange", Activity.MODE_PRIVATE)
    }

    fun setValueString(key: String, value: String?) {
        val prefsPrivateEditor = mSharedPref?.edit()
        prefsPrivateEditor?.putString(key, value)
        prefsPrivateEditor?.apply()
    }

    fun setValueBoolean(key: String, value: Boolean) {
        val prefsPrivateEditor = mSharedPref?.edit()
        prefsPrivateEditor?.putBoolean(key, value)
        prefsPrivateEditor?.apply()
    }

    fun getAuthToken(): String {
        return mSharedPref?.getString(AUTH_TOKEN, "") ?: ""
    }

    fun isLogin(): Boolean {
        return mSharedPref?.getBoolean(IS_LOGIN, false) ?: false
    }
}