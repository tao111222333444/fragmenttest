package com.csesc.fragmenttest.example1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.csesc.fragmenttest.R

class FragmentFirst:Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_first_layout,container,false)
		return view
	}

	private val viewPager by lazy { requireView().findViewById<ViewPager2>(R.id.viewPager) }
	private lateinit var fragmentList: MutableList<Fragment>

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
	}


	private fun initView() {
		fragmentList = ArrayList()
		fragmentList.add(FragmentSecond())
		viewPager.isSaveEnabled = false
		viewPager.offscreenPageLimit = 2
		viewPager.adapter = activity?.let { MAdapter(it, fragmentList) }
	}
}


/**
 * Home Fragment 适配器
 */
class MAdapter(fragmentActivity: FragmentActivity, private val list: List<Fragment>) :
	FragmentStateAdapter(fragmentActivity) {
	override fun createFragment(position: Int): Fragment {
		return list[position]
	}

	override fun getItemCount(): Int {
		return list.size
	}
}