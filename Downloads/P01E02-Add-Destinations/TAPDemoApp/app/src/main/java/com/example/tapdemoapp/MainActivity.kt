package com.example.tapdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.tapdemoapp.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "Navigation"

    private val mOnNavigatonItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item->
        when(item.itemId) {
            R.id.navigation_community -> {
                Log.d(TAG,"Community")
                replaceFragment(Community())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_articles -> {
                Log.d(TAG,"Articles")
                replaceFragment(Articles())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_main -> {
                Log.d(TAG,"Main")
                replaceFragment(Main())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_media -> {
                Log.d(TAG,"Media")
                replaceFragment(Media())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notif -> {
                Log.d(TAG,"Notification")
                replaceFragment(Notifications())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(Community())

        nav_view.setOnNavigationItemSelectedListener(mOnNavigatonItemSelectedListener)
    }

    fun loadFragment(f1: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.root,f1)
        ft.commit()
    }

    fun replaceFragment(f1: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.root,f1)
        ft.commit()
    }
}
