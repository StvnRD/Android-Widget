package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

// Ini variable binding
    private lateinit var binding : ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        // Memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        // Button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast",Toast.LENGTH_SHORT).show()
        }

        // Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar",Snackbar.LENGTH_SHORT).show()
        }

        // Button Alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Pesan")
                setMessage("Ini adalah Alert")
                setPositiveButton("OKE"){dialog, _ ->
                    Toast.makeText(applicationContext, "Klik OKE",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("KEMBALI"){dialog, _ ->
                    Toast.makeText(applicationContext, "Klik KEMBALI",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

            }.show()

        }

        // Button Custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)   //Tidak akan menghilangkan windows ketika di klik menu lain
                setContentView(R.layout.custom_dialog) //Memanggil Custom Dialog

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }

        }
    }