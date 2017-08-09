package com.binariks.astronomytddproject.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.binariks.astronomytddproject.R
import com.binariks.astronomytddproject.Utils.FullScreenActivityUtils
import com.binariks.astronomytddproject.Utils.UserUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUI()
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

        login_btn.onClick {
            checkCredentialsAndPerformLogin(login_screen_email_field.text.trim().toString(),
                    login_screen_password_field.text.trim().toString())
        }
    }

    private fun checkCredentialsAndPerformLogin(email: String, password: String) {
        if (UserUtils.validateEmailAdressOrRequestFocus(login_main_view, login_screen_email_field, email)
                && UserUtils.validatePasswordOrRequestFocus(login_main_view, login_screen_password_field, password)) {
            // Proceed with login
        }
    }
}
