package com.example.debouncedlistenerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.debouncedlistenerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.press.setOnCLick(2000L) {
            Log.e("Main Activity","Text Pressed");
            Toast.makeText(applicationContext,"text pressed",Toast.LENGTH_SHORT).show()
        }

        binding.press1.setOnCLick {
            Log.e("Main Activity","hello world Pressed")
            Toast.makeText(applicationContext,"Hello world pressed",Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnCLick {
            Toast.makeText(applicationContext,"button pressed",Toast.LENGTH_SHORT).show()
            Log.e("Main Activity","button Pressed")
        }

        binding.imageButton.setOnCLick(){
            Toast.makeText(applicationContext,"image button pressed",Toast.LENGTH_SHORT).show()
            Log.e("Main Activity","image button Pressed")
        }


    }

    }
