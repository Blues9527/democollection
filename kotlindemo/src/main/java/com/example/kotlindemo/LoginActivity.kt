package com.example.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.transition.AutoTransition
import android.transition.Fade
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

/**
 * User : Blues
 * Date : 2019/10/11
 * Time : 15:14
 */

class LoginActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {

    private var userName: String? = null
    private var passWord: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_username.addTextChangedListener(this)
        et_password.addTextChangedListener(this)
        btn_submit.apply {
            isClickable = false
            setOnClickListener(this@LoginActivity)
        }
//        btn_submit.isClickable = false
//        btn_submit.setOnClickListener(this)
        btn_back.setOnClickListener(this)

        window.enterTransition = AutoTransition()
        window.exitTransition = Fade()
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        userName = et_username.text.toString()
        passWord = et_password.text.toString()
        btn_submit.isClickable = !(TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord))
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_submit -> Toast.makeText(this, "click submit", Toast.LENGTH_SHORT).show()
            R.id.btn_back -> this.finish()
        }
    }
}