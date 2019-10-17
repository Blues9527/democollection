package com.example.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_phone_login.setOnClickListener {
//            Toast.makeText(this, "login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,LoginActivity::class.java)
            val  options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,tv_phone_login,"phonelogin")
            startActivity(intent,options.toBundle())
        }
    }
}
