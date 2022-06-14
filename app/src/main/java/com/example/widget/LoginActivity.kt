package com.example.widget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.widget.databinding.ActivityLoginBinding
import com.example.widget_TaofikSafrudin.ModelLogin

private lateinit var binding: ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val dataLogin = ModelLogin(binding.textUsername.text.toString(),binding.textPassword.text.toString())
            val intent =Intent(this, MainActivity::class.java)
            intent.putExtra("data",dataLogin)
            startActivity(intent)
            finish()
        }
    }
}