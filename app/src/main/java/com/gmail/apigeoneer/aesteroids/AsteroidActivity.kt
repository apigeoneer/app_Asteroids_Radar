package com.gmail.apigeoneer.aesteroids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gmail.apigeoneer.aesteroids.databinding.ActivityAsteroidBinding

class AsteroidActivity : AppCompatActivity() {

    // data binding
    private lateinit var binding: ActivityAsteroidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_asteroid)
    }
}