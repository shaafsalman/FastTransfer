package com.example.fasttransfer.Helper;

import android.text.TextUtils;
import android.widget.EditText;

public class InputValidator {

    public static boolean isEmpty(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    public static boolean isValidEmail(EditText editText) {
        CharSequence email = editText.getText().toString().trim();
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(EditText editText) {
        String phone = editText.getText().toString().trim();
        return !TextUtils.isEmpty(phone) && phone.length() >= 10;
    }
}
