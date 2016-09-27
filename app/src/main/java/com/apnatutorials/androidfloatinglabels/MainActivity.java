package com.apnatutorials.androidfloatinglabels;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextInputEditText tietEmail, tietPassword;
    TextInputLayout tilPasswordLayout, tilEmailLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tietEmail = (TextInputEditText) findViewById(R.id.tietEmail);
        tietPassword = (TextInputEditText) findViewById(R.id.tietPassword);
        tilEmailLayout = (TextInputLayout) findViewById(R.id.tilEmailLayout);
        tilPasswordLayout = (TextInputLayout) findViewById(R.id.tilPasswordLayout);

        tietEmail.addTextChangedListener(new MyTextWatcher(this, tietEmail, tilEmailLayout));
        tietPassword.addTextChangedListener(new MyTextWatcher(this, tietPassword, tilPasswordLayout));
    }

    /**
     * Method called when user click on login button
     *
     * @param view
     */
    public void login(View view) {
        if (FormValidator.isValidEmail(tietEmail.getText().toString()) == false) {
            tilEmailLayout.setError(getString(R.string.email_error_message));
            tietEmail.requestFocus();
        } else if (FormValidator.isValidPassword(tietPassword.getText().toString()) == false) {
            tilPasswordLayout.setError(getString(R.string.password_error_message));
            tietPassword.requestFocus();
        } else {
            Toast.makeText(MainActivity.this, "Validation successful ! Congrats", Toast.LENGTH_SHORT).show();
        }
    }
}
