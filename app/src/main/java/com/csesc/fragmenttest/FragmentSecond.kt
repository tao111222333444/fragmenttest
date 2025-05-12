package com.csesc.fragmenttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentSecond:Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_second_layout,container,false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
	}

	private var fragmentThree : FragmentThree?=null
	private val TAG_FRAGMENT_THREE  = "TAG_FRAGMENT_THREE"

//	private fun initView() {
//		//崩溃的逻辑
//		if(fragmentThree == null){
//			fragmentThree = FragmentThree()
//			parentFragmentManager.beginTransaction().add(R.id.fl_content_1,fragmentThree!!,TAG_FRAGMENT_THREE).commit()
//		}
//	}

	private fun initView() {
		//修复逻辑 使用正确的 FragmentManager
		childFragmentManager.findFragmentByTag(TAG_FRAGMENT_THREE)?.let {
			fragmentThree = it as FragmentThree
		}
		if(fragmentThree == null){
			fragmentThree = FragmentThree()
			childFragmentManager.beginTransaction().add(R.id.fl_content_1,fragmentThree!!,TAG_FRAGMENT_THREE).commit()
		}
	}
}