package com.xplora.challenge.helpers

import android.text.TextUtils
import android.util.Patterns

object Validation {

    /**
     * method is used for checking valid email id format.
     *
     * @param email  email address as String
     * @return boolean true for valid false for invalid
     */
    fun isEmailValid(email: String?): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
    }

    /**
     * method is used for checking if string is empty or not.
     *
     * @param mString as String
     * @return boolean true if [mString] is notnull.
     */
    fun isNotNull(mString: String?): Boolean {
        return when {
            mString == null -> false
            mString.equals("", ignoreCase = true) -> false
            mString.equals("N/A", ignoreCase = true) -> false
            mString.equals("[]", ignoreCase = true) -> false
            mString.equals("null", ignoreCase = true) -> false
            else -> !mString.equals("{}", ignoreCase = true)
        }
    }
}
