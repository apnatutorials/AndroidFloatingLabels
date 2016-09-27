package com.apnatutorials.androidfloatinglabels;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by Angel on 9/27/2016.
 */
public class MyTextWatcher implements TextWatcher {
    TextInputEditText view;
    TextInputLayout layout;
    Context ctx;

    public MyTextWatcher(Context context, TextInputEditText view, TextInputLayout layout) {
        this.view = view;
        this.layout = layout;
        this.ctx = context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        switch (this.view.getId()) {
            case R.id.tietEmail:
                if (FormValidator.isValidEmail(view.getText().toString()) == false) {
                    layout.setError(ctx.getString(R.string.email_error_message));
                    view.requestFocus();
                } else {
                    layout.setErrorEnabled(false);
                }
                break;

            case R.id.tietPassword:
                if (FormValidator.isValidPassword(view.getText().toString()) == false) {
                    layout.setError(ctx.getString(R.string.password_error_message));
                    view.requestFocus();
                } else {
                    layout.setErrorEnabled(false);
                }
                break;


        }
    }


}
