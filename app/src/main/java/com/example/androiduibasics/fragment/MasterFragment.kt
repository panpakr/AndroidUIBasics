package com.example.androiduibasics.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiduibasics.R
import timber.log.Timber
import java.lang.Exception

class MasterFragment  : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.d("onAttach")
        makeSleep()
    }

    //Show if you  attached to root default true ,then it will crash .

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Timber.d("onCreateView")
        makeSleep()
        return inflater.inflate(R.layout.fragment_master,container,false)




    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate")
        makeSleep()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Timber.w("onActivityCreated")
        makeSleep()
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
        Timber.d("onDestroy");
        makeSleep()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("onDestroyView");
        makeSleep()
    }

    override fun onDetach() {
        super.onDetach()

        Timber.d("onDetach");
        makeSleep()
    }


    fun makeSleep(){

        try {
           // Thread.sleep(1000);

        }catch (e: Exception){

            Timber.e(" Thread sleeping Exception");
        }


    }


}