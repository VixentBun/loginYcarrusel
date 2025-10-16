package com.example.login1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login1.HomeActivity
import com.example.login1.R


class MainActivity : AppCompatActivity() {

    // These should be properties of the class
    private val demoUser = "admin"
    private val demoPass = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Keep this for the UI
        setContentView(R.layout.activity_main) // Set the layout for the activity

        // Setup for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- Start of your login logic ---
        val etUser = findViewById<EditText>(R.id.editTextText)
        val etPass = findViewById<EditText>(R.id.editTextTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLog) // Corrected type to Button

        btnLogin.setOnClickListener {
            val user = etUser.text.toString().trim()
            val pass = etPass.text.toString()

            if (user.isEmpty()) {
                etUser.error = "Ingresa tu usuario"
                etUser.requestFocus()
                return@setOnClickListener
            }

            if (pass.isEmpty()) {
                etPass.error = "Ingresa tu contraseña"
                etPass.requestFocus()
                return@setOnClickListener
            }

            if (authenticate(user, pass)) {
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("EXTRA_USER", user)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun authenticate(user: String, pass: String): Boolean {
        // Correctly placed outside of onCreate
        return (user == demoUser && pass == demoPass)
    }
}

