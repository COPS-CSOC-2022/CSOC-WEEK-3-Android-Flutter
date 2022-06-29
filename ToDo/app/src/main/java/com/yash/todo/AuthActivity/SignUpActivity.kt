package com.yash.todo.AuthActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.yash.todo.LoginRequest
import com.yash.todo.R
import com.yash.todo.RetrofitClient
import com.yash.todo.models.DefaultResponse
import com.yash.todo.models.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var signupbacktowelcome : ImageView
    private lateinit var textlogin : TextView
    private lateinit var  editEmail: EditText
    private lateinit var  editUsername: EditText
    private lateinit var  editPassword : EditText
    private lateinit var btnsignup : Button
    private lateinit var editname : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setContentView(R.layout.activity_sign_up)
        signupbacktowelcome = findViewById(R.id.signupbacktowelcome)
        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)
        btnsignup = findViewById(R.id.btnsignup)
        textlogin = findViewById(R.id.textlogin)
        editUsername = findViewById(R.id.editUsername)
        editname = findViewById(R.id.editName11)

        btnsignup.setOnClickListener{
            credential_check()
        }






    }
    private fun credential_check() {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        val username = editUsername.text.toString()
        val name = editname.text.toString()
        val emailAddress: String = email.trim()
        if (password.length < 6) {
            editPassword.error = "password minimum contain 6 character"
            editPassword.requestFocus()
        }
        if (password == "") {
            editPassword.error = "please enter password 🤣"
            editPassword.requestFocus()
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            editEmail.error = "please enter valid email address 😑"
            editEmail.requestFocus()
        }
        if (email == "") {
            editEmail.error = "please enter email address 🤣"
            editEmail.requestFocus()
        }
        if (username == "") {
            editUsername.error = "please enter Username 😤"
            editUsername.requestFocus()
        }
        if (emailAddress != "" && password.length >= 6 &&
            password.trim() != "" &&
            Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()
        ) {
            RetrofitClient.instance.register(LoginRequest(name,email,username,password))
                .enqueue(object : Callback <RegisterResponse>{
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        Toast.makeText(applicationContext, "Registered📝 successfully 🤓",Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message , Toast.LENGTH_LONG).show()
                    }

                })


        }
    }
}