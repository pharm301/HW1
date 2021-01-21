package com.levin.hw1

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
//import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    var filmID : Int = 0

    companion object {

        fun launchActivity (activity: Activity, myID : Int) {
            Intent (activity,SecondActivity::class.java).apply {
                putExtra ("filmID",myID)
                activity.startActivity(this)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)
        filmID = intent.getIntExtra("filmID",4)
        println(filmID)

        when (filmID) {
            1 -> {  findViewById<TextView>(R.id.textView).text = resources.getString(R.string.descr1)
                findViewById<ImageView>(R.id.imageView).background = resources.getDrawable(R.drawable.film1,null)
                 }
            2 -> {  findViewById<TextView>(R.id.textView).text = resources.getString(R.string.descr2)
                    findViewById<ImageView>(R.id.imageView).background = resources.getDrawable(R.drawable.film2,null)
            }
            3 -> {  findViewById<TextView>(R.id.textView).text = resources.getString(R.string.descr3)
                findViewById<ImageView>(R.id.imageView).background = resources.getDrawable(R.drawable.film3,null)
            }
            4 -> {  findViewById<TextView>(R.id.textView).text = resources.getString(R.string.descr4)
                findViewById<ImageView>(R.id.imageView).background = resources.getDrawable(R.drawable.film4,null)
            }

        }
    }
}