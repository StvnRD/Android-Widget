package com.example.widget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget.databinding.ActivityMainBinding
import com.example.widget.databinding.ActivityWidgetBinding


//Membuat variable Binding
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        //Explicit intent untuk memanggil Activity di Project yang sama
        binding.btnWidget.setOnClickListener {
            val intent = Intent (this,Widget::class.java)
            startActivity(intent)
        }

        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent(this,ImplicitIntent::class.java)
            startActivity(intent)
        }
    }
}
