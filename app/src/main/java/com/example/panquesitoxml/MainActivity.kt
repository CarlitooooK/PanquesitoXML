package com.example.panquesitoxml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        window.statusBarColor = this.resources.getColor(R.color.white)

        val btnViewLogin = findViewById<Button>(R.id.btn_login_activity)
        val btnViewRegister = findViewById<Button>(R.id.btn_register_activity)

        btnViewLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btnViewRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }



    }
}