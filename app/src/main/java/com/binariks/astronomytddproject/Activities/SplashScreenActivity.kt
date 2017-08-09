package com.binariks.astronomytddproject.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.binariks.astronomytddproject.R
import com.binariks.astronomytddproject.Utils.FullScreenActivityUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast


class SplashScreenActivity : AppCompatActivity() {

    lateinit var mFirebaseAuth: FirebaseAuth
    lateinit var mFirebaseAuthListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initUI()
        initFirebaseAuth()

    }

    override fun onStart() {
        super.onStart()
        mFirebaseAuth.addAuthStateListener(mFirebaseAuthListener)
    }

    override fun onStop() {
        super.onStop()
        mFirebaseAuth.removeAuthStateListener(mFirebaseAuthListener)
    }

    private fun initFirebaseAuth() {
        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseAuthListener = FirebaseAuth.AuthStateListener {
            val user = it.currentUser

            if (user != null) {
                // User is signed in
                // Skip splash Activity after some time
            } else {
                // User is signed out
            }
        }
    }


    private fun initUI() {
        FullScreenActivityUtils.hideActionBar(supportActionBar)
        FullScreenActivityUtils.hideStatusBar(window)

        sign_in_with_facebook.onClick {
            toast("Sign in with Facebook.")
            // Sign in with facebook
        }

        sign_in_with_twitter.onClick {
            toast("Sign in with Twitter.")
            // Sign in with Twitter
        }

        sign_in_with_email.onClick {
            startActivity(intentFor<LoginActivity>())
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        dont_have_account_tv.onClick {
            startActivity(intentFor<RegistrationActivity>())
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }


}
