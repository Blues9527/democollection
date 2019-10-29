package com.example.spdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private lateinit var ctx: Context
    private lateinit var saveStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        ctx = this
        //etInput tvShow btnSave btnGet

        etInput.addTextChangedListener(this)
        btnSave.setOnClickListener(this)
        btnGet.setOnClickListener(this)


    }


    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        saveStr = etInput.text.toString().trim()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> saveStr(ctx, "test", saveStr)
            R.id.btnGet -> tvShow.text = getStr(ctx, "test", "这里没有值")
        }
    }


    private fun saveStr(ctx: Context, key: String, value: String) {
        val sp = ctx.getSharedPreferences("blues", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun getStr(ctx: Context, key: String, defaultValue: String): String? {
        val sp = ctx.getSharedPreferences("blues", Context.MODE_PRIVATE)
        return sp.getString(key, defaultValue)
    }
}
