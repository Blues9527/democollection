package com.example.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * User : Blues
 * Date : 2019/10/11
 * Time : 15:46
 */

abstract class BaseActivity : AppCompatActivity() {

    private var mContext: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this

        setContentView(setLayoutId())

        setListener()
    }


    abstract fun setLayoutId(): Int

    abstract fun setListener()

}