package com.levin.hw1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
   companion object {
       const val myREQUEST = 1

       var mySel: Int = 0

       var myLike1: Int = 0
       var myComment1 = ""
       var myLike2: Int = 0
       var myComment2 = ""
       var myLike3: Int = 0
       var myComment3 = ""
       var myLike4: Int = 0
       var myComment4 = ""
   }
    private   val textViewM1 by lazy {
           findViewById<TextView>(R.id.textView1)
       }
    private   val textViewM2 by lazy {
           findViewById<TextView>(R.id.textView2)
       }
    private   val textViewM3 by lazy {
           findViewById<TextView>(R.id.textView3)
       }
    private   val textViewM4 by lazy {
           findViewById<TextView>(R.id.textView4)
       }
    private   val textViewComment by lazy {
           findViewById<TextView>(R.id.textView5)
       }
    private   val checkLike by lazy {
           findViewById<CheckBox>(R.id.checkbox1)
       }

    private fun launchFilmDetail (myID : Int, isLike : Int, myCom : String){
        Intent (this,FilmDetailActivity::class.java).apply {
            putExtra ("filmID",myID)
            putExtra("isLike", isLike)
            putExtra("myCom", myCom)
            startActivityForResult(this, myREQUEST)
        }
    }

    private fun setLandC(isLike: Int, isCom: String) {
           if (isLike != 0) {
               checkLike.isChecked = true
               checkLike.isVisible = true
           } else {
               checkLike.isVisible = false
           }

           if (isCom != "") {
               textViewComment.text = isCom
               textViewComment.isVisible = true
           } else textViewComment.isVisible = false
       }

    private fun reSelect(newSelected: Int) {
           when (mySel) {
               1 -> {
                   textViewM1.setTextColor(resources.getColor(R.color.purple_700, null))
                   textViewM1.setBackgroundColor(resources.getColor(R.color.white, null))
               }
               2 -> {
                   textViewM2.setTextColor(resources.getColor(R.color.purple_700, null))
                   textViewM2.setBackgroundColor(resources.getColor(R.color.white, null))
               }
               3 -> {
                   textViewM3.setTextColor(resources.getColor(R.color.purple_700, null))
                   textViewM3.setBackgroundColor(resources.getColor(R.color.white, null))
               }
               4 -> {
                   textViewM4.setTextColor(resources.getColor(R.color.purple_700, null))
                   textViewM4.setBackgroundColor(resources.getColor(R.color.white, null))
               }
           }
           when (newSelected) {
               1 -> {
                   textViewM1.setTextColor(resources.getColor(R.color.red, null))
                   textViewM1.setBackgroundColor(resources.getColor(R.color.yellow, null))
                   setLandC(myLike1, myComment1)
               }
               2 -> {
                   textViewM2.setTextColor(resources.getColor(R.color.red, null))
                   textViewM2.setBackgroundColor(resources.getColor(R.color.yellow, null))
                   setLandC(myLike2, myComment2)
               }
               3 -> {
                   textViewM3.setTextColor(resources.getColor(R.color.red, null))
                   textViewM3.setBackgroundColor(resources.getColor(R.color.yellow, null))
                   setLandC(myLike3, myComment3)
               }
               4 -> {
                   textViewM4.setTextColor(resources.getColor(R.color.red, null))
                   textViewM4.setBackgroundColor(resources.getColor(R.color.yellow, null))
                   setLandC(myLike4, myComment4)
               }
           }
           mySel = newSelected
       }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            findViewById<Button>(R.id.button1).setOnClickListener {
                reSelect(1)
//                FilmDetailActivity.launchActivity(this, myREQUEST, 1, myLike1, myComment1)
                launchFilmDetail(1, myLike1, myComment1)
            }
            findViewById<Button>(R.id.button2).setOnClickListener {
                reSelect(2)
//                FilmDetailActivity.launchActivity(this, myREQUEST, 2, myLike2, myComment2)
                launchFilmDetail(2, myLike2, myComment2)
            }
            findViewById<Button>(R.id.button3).setOnClickListener {
                reSelect(3)
//                FilmDetailActivity.launchActivity(this, myREQUEST, 3, myLike3, myComment3)
                launchFilmDetail(3, myLike3, myComment3)
            }
            findViewById<Button>(R.id.button4).setOnClickListener {
                reSelect(4)
//                FilmDetailActivity.launchActivity(this, myREQUEST, 4, myLike4, myComment4)
                launchFilmDetail(4, myLike4, myComment4)
            }
            findViewById<ImageView>(R.id.imageInviteFriend).setOnClickListener {
                Toast.makeText(this, "Приглашаю друга", Toast.LENGTH_SHORT).show()

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Приглашаю друга")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Друг может хочет посмотреть?")
                startActivity(Intent.createChooser(shareIntent, "Отправка всякой хрени"))
            }

            savedInstanceState?.getInt("mySel", mySel)?.let { reSelect(mySel) }
        }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("mySel", mySel)
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == myREQUEST && resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        Log.i(
                            "PHENOMEN 1: ",
                            "isLike : " + data.getIntExtra("isLike", 0).toString()
                        )
                        Toast.makeText(
                            this,
                            "Новый коммент :" + data.getStringExtra("myCom").toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    when (mySel) {
                        1 -> if (data != null) {
                            myLike1 = data.getIntExtra("isLike", 0)
                            myComment1 = data.getStringExtra("myCom").toString()
                        }
                        2 -> if (data != null) {
                            myLike2 = data.getIntExtra("isLike", 0)
                            myComment2 = data.getStringExtra("myCom").toString()
                        }
                        3 -> if (data != null) {
                            myLike3 = data.getIntExtra("isLike", 0)
                            myComment3 = data.getStringExtra("myCom").toString()
                        }
                        4 -> if (data != null) {
                            myLike4 = data.getIntExtra("isLike", 0)
                            myComment4 = data.getStringExtra("myCom").toString()
                        }
                    }
                    reSelect(mySel)
            }
        }
    }

