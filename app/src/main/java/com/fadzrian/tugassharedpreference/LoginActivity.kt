package com.fadzrian.tugassharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val PREFS_NAME = "BelajarSharedPrefrence"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"
    lateinit var  sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun onLogin(view: View) {
        val email = input_email.text.toString()
        saveEmail(email)
        val password = input_password.text.toString()
        savePassword(password)
        msg()
    }


    private fun saveEmail(email: String) {
        val editor = sharedPref.edit()
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    private fun savePassword(password: String) {
        val editor = sharedPref.edit()
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    private fun msg() {
        val email = input_email.text.toString()
        val password = input_password.text.toString()
        when {
            email == "" -> {
                val msg = Toast.makeText(applicationContext,"Masukan Email", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0,140)
                msg.show()
            }
            password == "" -> {
                val msg = Toast.makeText(applicationContext,"Masukan Password", Toast.LENGTH_LONG)
                msg.setGravity(Gravity.TOP, 0,140)
                msg.show()
            }
            else -> {
                val msg = Toast.makeText(applicationContext,"Berhasil Login", Toast.LENGTH_SHORT)
                msg.setGravity(Gravity.TOP, 0,140)
                msg.show()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }


}
