package com.example.login1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        // Use R.id.home_main from your activity_home.xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Get user extra and set welcome message
        val user = intent.getStringExtra("EXTRA_USER")
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = "Alianza contra los emperadores. Bienvenido $user!"

        // 2. Prepare the list of images
        val imageList = listOf(
            R.drawable.luffy, // Make sure you have image1.jpg (or .png) in your drawable folder
            R.drawable.law, // Make sure you have image2.jpg (or .png)
            R.drawable.kidd  // Make sure you have image3.jpg (or .png)
        )

        // 3. Find the ViewPager2 and create an adapter
        val viewPager = findViewById<ViewPager2>(R.id.imageCarouselViewPager)
        val adapter = ImageCarouselAdapter(imageList)

        // 4. Set the adapter on the ViewPager2
        viewPager.adapter = adapter
    }
}
