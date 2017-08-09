package com.binariks.astronomytddproject.Activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.binariks.astronomytddproject.R
import com.binariks.astronomytddproject.Utils.FullScreenActivityUtils
import com.binariks.astronomytddproject.Utils.UserUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class RegistrationActivity : AppCompatActivity() {

    lateinit var mFirebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initUI()
        initFirebase()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }
        return true
    }


    private fun initUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        FullScreenActivityUtils.hideStatusBar(window)

        register_new_user_btn.onClick {
            createNewUser(registartion_screen_email_field.text.trim().toString(),
                    registartion_screen_password_field.text.trim().toString())
        }
    }

    private fun initFirebase() {
        mFirebaseAuth = FirebaseAuth.getInstance()
    }

    private fun createNewUser(email: String, password: String) {
        if (UserUtils.validateEmailAdressOrRequestFocus(registration_main_view, registartion_screen_email_field, email)
                && UserUtils.validatePasswordOrRequestFocus(registration_main_view, registartion_screen_password_field, password)) {
            mFirebaseAuth.createUserWithEmailAndPassword(email, password)
            Snackbar.make(registration_main_view, "New user created succesfully.", Snackbar.LENGTH_LONG).show()
        }
    }


}
