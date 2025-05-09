package com.csesc.fragmenttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity:AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_layout)
		initView()
	}

	private var fragmentFirst : FragmentFirst?=null
	private val TAG_FRAGMENT_FIRST = "TAG_FRAGMENT_FIRST"
	private fun initView() {
		supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_FIRST)?.let {
			fragmentFirst = it as FragmentFirst
		}

		if(fragmentFirst == null){
			fragmentFirst = FragmentFirst()
			supportFragmentManager.beginTransaction().add(R.id.fl_content,fragmentFirst!!,TAG_FRAGMENT_FIRST).commit()
		}

	}
}