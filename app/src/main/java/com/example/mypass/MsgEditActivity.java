package com.example.mypass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MsgEditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_msg_edit);
        ScreenHelp.setStatusBarColor(this, ScreenHelp.stateBarColorValueWhite);
        ScreenHelp.setAndroidNativeLightStatusBar(this, true);
        findViewById(R.id.btn_confirm_edit).setOnClickListener(clickListenerConfirm);
        findViewById(R.id.btn_cancel_edit).setOnClickListener(clickListenerCancel);
    }

    private final View.OnClickListener clickListenerConfirm = view -> {
        EditText editTextName = view.getRootView().findViewById(R.id.editTextName);
        EditText editTextNum = view.getRootView().findViewById(R.id.editTextNumber);
        EditText editTextReason = view.getRootView().findViewById(R.id.editTextReason);
        EditText editTextPlace = view.getRootView().findViewById(R.id.editTextPlace);
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();

        if (editTextName != null && editTextPlace != null && editTextReason != null &&
                editTextNum != null) {
            if (editTextName.getText().toString().length() != 0) {
                DataHolder.newInstance().setName(editTextName.getText().toString());
                editor.putString(DataHolder.KEY_NAME,editTextName.getText().toString());
            }
            if (editTextNum.getText().toString().length() != 0) {
                DataHolder.newInstance().setNumber(editTextNum.getText().toString());
                editor.putString(DataHolder.KEY_NUMBER,editTextNum.getText().toString());
            }
            if (editTextReason.getText().toString().length() != 0) {
                DataHolder.newInstance().setReason(editTextReason.getText().toString());
                editor.putString(DataHolder.KEY_REASON,editTextReason.getText().toString());
            }
            if (editTextPlace.getText().toString().length() != 0) {
                DataHolder.newInstance().setPlace(editTextPlace.getText().toString());
                editor.putString(DataHolder.KEY_PLACE,editTextPlace.getText().toString());
            }
            editor.commit();
        }
        Intent intent = new Intent(view.getContext(), MyPassActivity.class);
        startActivity(intent);
        finish();
    };

    private final View.OnClickListener clickListenerCancel = view -> {
        Intent intent = new Intent(view.getContext(), MyPassActivity.class);
        startActivity(intent);
        finish();
    };

}
