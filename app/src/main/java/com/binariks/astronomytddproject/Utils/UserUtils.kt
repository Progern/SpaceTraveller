package com.binariks.astronomytddproject.Utils

import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class UserUtils {
    companion object {

        fun validateEmailAddress(email: String): Boolean {
            if (TextUtils.isEmpty(email)) {
                return false
            } else {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        }

        fun validatePassword(password: String): Boolean {
            return password.length > 6
        }

        fun validatePasswordOrRequestFocus(mainView: View, requestView: EditText, password: String): Boolean {
            if (password.length < 6) {
                Snackbar.make(mainView, "Password's length must be bigger than 6 characters.", Snackbar.LENGTH_SHORT).show()
                YoYo.with(Techniques.Swing)
                        .duration(700)
                        .playOn(requestView)
                requestView.requestFocus()
                return false
            } else {
                return true
            }
        }

        fun validateEmailAdressOrRequestFocus(mainView: View, requestView: EditText, email: String): Boolean {
            if (UserUtils.validateEmailAddress(email)) {
                return true
            } else {
                Snackbar.make(mainView, "Email address is not valid.", Snackbar.LENGTH_SHORT).show()
                YoYo.with(Techniques.Swing)
                        .duration(700)
                        .playOn(requestView)
                requestView.requestFocus()
                return false
            }
        }
    }
}