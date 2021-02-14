package com.levin.hw1

import android.app.Activity
import android.content.Intent
//import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FilmDetailActivity: AppCompatActivity() {
    companion object {
        var filmID = 0
        var isLiked = 0
        var myCom = ""
/*
        fun launchActivity (activity: Activity, myREQUEST : Int, myID : Int, isLike : Int, myCom : String) {
            Intent (activity,FilmDetailActivity::class.java).apply {
                putExtra ("filmID",myID)
                putExtra("isLike", isLike)
                putExtra("myCom", myCom)
                activity.startActivityForResult(this, myREQUEST)
            }
        }
 */
    }
    private val chkBox by lazy {
        findViewById<CheckBox>(R.id.checkBox)
    }
    private val textViewFilmDesc by lazy {
        findViewById<TextView>(R.id.textView)
    }
    private val imageViewPoster by lazy {
        findViewById<ImageView>(R.id.imageView)
    }
    private val editTextComment by lazy {
        findViewById<EditText>(R.id.editTextTextMultiLine)
    }
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmdetail)
        filmID = intent.getIntExtra("filmID",4)
        isLiked = intent.getIntExtra("isLike",0)
        myCom = intent.getStringExtra("myCom").toString()

        if (isLiked == 1) chkBox.isChecked = true
        myCom = intent.getStringExtra("myCom").toString()
        editTextComment.setText(myCom.toCharArray(),0,myCom.length)


      Log.i ("PHENOMEN 2 isLiked", isLiked.toString())
      Log.i ("PHENOMEN 2 myCom", myCom)


        findViewById<Button>(R.id.buttonCancel).setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        findViewById<Button>(R.id.buttonOK).setOnClickListener  {
            setResult(Activity.RESULT_OK,Intent().apply {
                putExtra("isLike",isLiked)
                putExtra("myCom",editTextComment.text.toString())
            })
            finish()
        }

        chkBox.setOnClickListener{
            if (chkBox.isChecked) {
                chkBox.text= "Мне по приколу все!"
                isLiked = 1
            }
            else {
                chkBox.text= "Ты зануда!!!"
                isLiked = 0
            }
        }

        when (filmID) {
            1 -> {  textViewFilmDesc.text = resources.getString(R.string.descr1)
                imageViewPoster.background = resources.getDrawable(R.drawable.film1,null)
                 }
            2 -> {  textViewFilmDesc.text = resources.getString(R.string.descr2)
                imageViewPoster.background = resources.getDrawable(R.drawable.film2,null)
            }
            3 -> {  textViewFilmDesc.text = resources.getString(R.string.descr3)
                imageViewPoster.background = resources.getDrawable(R.drawable.film3,null)
            }
            4 -> {  textViewFilmDesc.text = resources.getString(R.string.descr4)
                imageViewPoster.background = resources.getDrawable(R.drawable.film4,null)
            }

        }
    }
}