package com.levin.hw1

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

        val textViewM1 by lazy {
            findViewById<TextView>(R.id.textView1)
        }
        val textViewM2 by lazy {
            findViewById<TextView>(R.id.textView2)
        }
        val textViewM3 by lazy {
            findViewById<TextView>(R.id.textView3)
        }
        val textViewM4 by lazy {
            findViewById<TextView>(R.id.textView4)
        }

        var mySel : Int = 0

        fun ReSelect (newSelected : Int) {
            when (mySel) {
                1 -> {  textViewM1.setTextColor(getResources().getColor(R.color.purple_700, null))
                    textViewM1.setBackgroundColor(getResources().getColor(R.color.white, null))
                }
                2 -> {  textViewM2.setTextColor(getResources().getColor(R.color.purple_700, null))
                    textViewM2.setBackgroundColor(getResources().getColor(R.color.white, null))
                }
                3 -> {  textViewM3.setTextColor(getResources().getColor(R.color.purple_700, null))
                    textViewM3.setBackgroundColor(getResources().getColor(R.color.white, null))
                }
                4 -> {  textViewM4.setTextColor(getResources().getColor(R.color.purple_700, null))
                    textViewM4.setBackgroundColor(getResources().getColor(R.color.white, null))
                }
            }
            when (newSelected) {
                1 -> {  textViewM1.setTextColor(getResources().getColor(R.color.red, null))
                        textViewM1.setBackgroundColor(getResources().getColor(R.color.yellow, null))
                }
                2 -> {  textViewM2.setTextColor(getResources().getColor(R.color.red, null))
                        textViewM2.setBackgroundColor(getResources().getColor(R.color.yellow, null))
                }
                3 -> {  textViewM3.setTextColor(getResources().getColor(R.color.red, null))
                        textViewM3.setBackgroundColor(getResources().getColor(R.color.yellow, null))
                }
                4 -> {  textViewM4.setTextColor(getResources().getColor(R.color.red, null))
                        textViewM4.setBackgroundColor(getResources().getColor(R.color.yellow, null))
                }
            }
            mySel = newSelected
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            findViewById<Button>(R.id.button1).setOnClickListener {
                ReSelect(1)
                SecondActivity.launchActivity(this,1)

        }
            findViewById<Button>(R.id.button2).setOnClickListener {
                ReSelect(2)
                SecondActivity.launchActivity(this,2)
            }
            findViewById<Button>(R.id.button3).setOnClickListener {
                ReSelect(3)
                SecondActivity.launchActivity(this,3)
            }
            findViewById<Button>(R.id.button4).setOnClickListener {
                ReSelect(4)
                SecondActivity.launchActivity(this,4)
            }
        }
    }

