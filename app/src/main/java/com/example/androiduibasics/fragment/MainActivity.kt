package com.example.androiduibasics.fragment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.androiduibasics.R
import timber.log.Timber
import java.lang.Exception

class MainActivity : AppCompatActivity(){

    //1. ShowLifecycle of Fragment alongwith Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example_main)
        setUpFragment();

        Timber.d("onCreate")
        makeSleep()
    }

    private fun setUpFragment() {

        val fragmentManager = supportFragmentManager;
        val ft = fragmentManager.beginTransaction();
        val masterFragment = MasterFragment();
        ft.add(R.id.fragment_container,masterFragment,"master")




        //show replace and add To back stack
        val slaveFragment = SlaveFragment();
        ft.replace(R.id.fragment_container,slaveFragment,"slave")
        //ft.addToBackStack(null)


        ft.commit()

    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
        makeSleep()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
        makeSleep()

    }


    override fun onPause() {
        super.onPause()
        Timber.d("onPause");
        makeSleep()
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop");
        makeSleep()
    }


    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
        makeSleep()
    }



    fun makeSleep(){

        try {
            //Thread.sleep(1000);

        }catch (e:Exception){

            Timber.e(" Thread sleeping Exception");
        }


    }


}