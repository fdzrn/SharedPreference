package com.fadzrian.tugassharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "BelajarSharedPrefrence"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        textView_email.text = getEmail()
        textView_password.text = getPassword()
    }

    fun onLogout(view: View) {
        clearData()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun clearData() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    private fun getEmail(): String? = sharedPref.getString(KEY_EMAIL, null)
    private fun getPassword(): String? = sharedPref.getString(KEY_PASSWORD, null)

}
