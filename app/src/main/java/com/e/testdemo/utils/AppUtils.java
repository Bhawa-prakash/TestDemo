package com.e.testdemo.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class AppUtils {


    private static ProgressDialog pDialog;

    public static void showProgressDialog(Context context, String message) {
        if (pDialog != null) {
            pDialog.dismiss();
        }
        pDialog = new ProgressDialog(context);
        pDialog.setMessage(message);
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
    }


    public static void dismissProgressDialog() {
        try {
            if (null != pDialog && pDialog.isShowing()) {
                pDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
