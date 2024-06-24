package com.uz.ustudy.ui.courses.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.uz.ustudy.ui.courses.CourseOptionFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val pages = listOf(
        CourseOptionFragment.newInstance("English"),
        CourseOptionFragment.newInstance("Math"),
        CourseOptionFragment.newInstance("Marketing")
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "English"
            1 -> "Math"
            2 -> "Marketing"
            else -> null
        }
    }
}
