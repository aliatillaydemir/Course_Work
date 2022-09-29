package com.ayd.signinsignup.view.loading

import android.app.Activity
import android.app.AlertDialog
import com.ayd.signinsignup.R

class LoadingDialog(val mActivity: Activity) {

    private lateinit var isDialog: AlertDialog

    fun startLoading(){
        //for View
        val inflater = mActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading,null)

        //set Dialog
        val builder = AlertDialog.Builder(mActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isDialog = builder.create()
        isDialog.show()
    }
    fun isDissmiss(){
        isDialog.dismiss()
    }

    }