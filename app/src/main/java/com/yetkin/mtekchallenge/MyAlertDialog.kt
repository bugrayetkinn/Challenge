package com.yetkin.mtekchallenge

import android.app.AlertDialog
import android.content.Context
import android.view.View


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class MyAlertDialog(val context: Context) {
    val alertDialog = AlertDialog.Builder(context)
    val dialog = alertDialog.create()

    fun createAlert(view: View) {
        dialog.setView(view)
        dialog.show()
    }

}