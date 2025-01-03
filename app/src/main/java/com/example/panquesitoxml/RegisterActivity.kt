package com.example.panquesitoxml
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.google.android.material.textfield.TextInputEditText


class RegisterActivity:AppCompatActivity() {


    private lateinit var checkCaptcha:CheckBox
    private lateinit var registerButton: Button
    private lateinit var fullName: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        window.statusBarColor = Color.WHITE
        window.navigationBarColor = Color.WHITE

        checkCaptcha = findViewById(R.id.cb_captcha)
        registerButton = findViewById(R.id.btn_sign_up)
        fullName = findViewById(R.id.full_name_edt)
        email = findViewById(R.id.email_tv)
        password = findViewById(R.id.password)
        
        registerButton.setOnClickListener {
            val captcha = checkCaptchaFn(checkCaptcha)
            val checkName = checkName(fullName.text.toString())
            val checkEmail = checkEmail(email.text.toString())
            val checkPassword = checkPassword(password.text.toString())

            if(checkName && checkEmail && checkPassword && captcha){
                Toast.makeText(this, "Credenciales Correctas", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkCaptchaFn(captcha:CheckBox):Boolean{
        if(captcha.isChecked){
            Toast.makeText(this, "CAPTCHA CORRECTO", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(this, "CAPTCHA SIN MARCAR", Toast.LENGTH_SHORT).show()
            return false
        }
    }

    private fun checkName(name: String):Boolean{
        val checkName = name.trim().lowercase()
        return checkName.isNotEmpty() && checkName.matches(Regex("^[a-zA-Z]*$"))

    }
    private fun checkEmail(email: String):Boolean{
        val cleanEmail = email.trim().lowercase()
        return Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() && cleanEmail == "cabreracarlo772@gmail.com"
    }

    private fun checkPassword(password: String):Boolean{
        val passwordCheck = password.trim().lowercase()
        return passwordCheck.isNotEmpty() && passwordCheck == "123456"

    }

}