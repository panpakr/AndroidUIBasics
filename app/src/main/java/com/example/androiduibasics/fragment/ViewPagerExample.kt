package com.example.androiduibasics.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.androiduibasics.R
import timber.log.Timber

class ViewPagerExample : AppCompatActivity() {

    private lateinit var viewPager: NonSwipableVP

    //1.Show FragmentPagerAdapter usage
    //2.Show how to use Non Swipable View Pager ---First without change in Xml
    //3. Show how to use Non Swipable View Pager ---Showing only One constructor to use Custom layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actitivity_viewpager_example)
        initViews();
        initViewPager()

        Timber.d("onCreate")
    }

    private fun initViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

    }

    private fun initViews() {
        viewPager = findViewById(R.id.view_pager)
    }


}

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(pos: Int): Fragment {


        if (pos == 0)
            return MasterFragment()

        if (pos == 1)
            return SlaveFragment()

        return Fragment()
    }

    override fun getCount(): Int {

        return 3

    }

}