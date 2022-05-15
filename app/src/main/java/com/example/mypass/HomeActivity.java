package com.example.mypass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        // LinearLayout layout = findViewById(R.id.contentLinear);
        ScreenHelp.setStatusBarColor(this, ScreenHelp.chatGray);
        ScreenHelp.setAndroidNativeLightStatusBar(this, true);
        findViewById(R.id.btn_go_out).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(),PassActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.back_to_mypass).setOnClickListener(clickListener);
    }

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ((AppCompatActivity)view.getContext()).finish();
        }
    };
}
