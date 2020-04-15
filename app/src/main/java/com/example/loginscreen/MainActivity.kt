package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
    constructor(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idUsernameInput)
        val txtPassword = findViewById<TextView>(R.id.idPasswordInput)
        val btnLogin = findViewById<Button>(R.id.idLoginButton)

        btnLogin.setOnClickListener {
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errLogin),Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errPassword),Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else ->
                    Toast.makeText(applicationContext, "Success",Toast.LENGTH_LONG).show()
            }
        }

    }


    fun CheckLogin(txtLogin: String, txtPassword: String): MainActivity.LoginSuccess {
        val holdLogin = "Joel"
        val holdPassword = "Password"

        if (holdLogin != txtLogin) {
            return MainActivity.LoginSuccess.login
        }
        return if (holdPassword != txtPassword) {
            LoginSuccess.password
        } else  LoginSuccess.success

    }
}