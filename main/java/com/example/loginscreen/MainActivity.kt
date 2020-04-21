package com.example.loginscreen

import android.content.Intent
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
            val toastError: Toast? = null
            val isOK: LoginSuccess? = null

            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                MainActivity.LoginSuccess.login -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessageLogin), toastError.LENGTH_SHORT).show()
                    txtLogin.requestFocus()
                }
                MainActivity.LoginSuccess.password -> {
//                    toastError!!.makeText(getApplicationContext(), getString(R.string.errMessagePassword), toastError.LENGTH_SHORT).show()
                    txtPassword.requestFocus()
                }
                else ->
                    startActivity(Intent(this@MainActivity, MainClassList::class.java))
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