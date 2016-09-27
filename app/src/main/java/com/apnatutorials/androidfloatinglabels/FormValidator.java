package com.apnatutorials.androidfloatinglabels;

import android.text.TextUtils;

/**
 * Created by Angel on 9/27/2016.
 */
public class FormValidator {

    public static boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public static boolean isValidPassword(String password){
       return  !TextUtils.isEmpty(password) && password.trim().length()==8 ;
    }
}
