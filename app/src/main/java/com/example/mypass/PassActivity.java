package com.example.mypass;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PassActivity extends AppCompatActivity {
    private static final long A_DAY_MILLIS = 86400000L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pass);
        ScreenHelp.setStatusBarColor(this, ScreenHelp.chatGray);
        ScreenHelp.setAndroidNativeLightStatusBar(this, true);
        //init();
        TextView textViewStart = findViewById(R.id.start_time);
        TextView textViewEnd = findViewById(R.id.end_time);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 3 * A_DAY_MILLIS);
        textViewStart.setText(simpleDateFormat.format(startDate));
        textViewEnd.setText(simpleDateFormat.format(endDate));
        init();
    }

    public void init() {
        TextView editTextName = findViewById(R.id.user_name);
        TextView editTextNum = findViewById(R.id.user_num);
        TextView editTextReason = findViewById(R.id.user_reason);
        TextView editTextPlace = findViewById(R.id.user_place);
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        if (sharedPreferences.getString(DataHolder.KEY_NAME, "").length() != 0) {
            editTextName.setText(sharedPreferences.getString(DataHolder.KEY_NAME, ""));
        }
        if (sharedPreferences.getString(DataHolder.KEY_NUMBER, "").length() != 0) {
            editTextNum.setText(sharedPreferences.getString(DataHolder.KEY_NUMBER, ""));
        }
        if (sharedPreferences.getString(DataHolder.KEY_REASON, "").length() != 0) {
            editTextReason.setText(sharedPreferences.getString(DataHolder.KEY_REASON, ""));
        }
        if (sharedPreferences.getString(DataHolder.KEY_PLACE, "").length() != 0) {
            editTextPlace.setText(sharedPreferences.getString(DataHolder.KEY_PLACE, ""));
        }
        findViewById(R.id.back_to_home).setOnClickListener(clickListener);
    }

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((AppCompatActivity)view.getContext()).finish();
        }
    };
}
