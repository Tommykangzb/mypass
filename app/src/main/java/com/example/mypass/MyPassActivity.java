package com.example.mypass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MyPassActivity extends AppCompatActivity {
    private static final String TAG = "MyPassActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ScreenHelp.setStatusBarColor(this, ScreenHelp.chatGray);
        ScreenHelp.setAndroidNativeLightStatusBar(this, true);
        LinearLayout layout = findViewById(R.id.contentLinear);
        addItem(layout);
    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
//        if (sharedPreferences.getString(DataHolder.KEY_NAME,"").length() == 0){
//            SharedPreferences.Editor
//        }
//    }

    private void addItem(LinearLayout layout) {
        int count = 0;
        for (int i = 0; i < DataGenerator.sCUTData.length; i++) {
            if (DataGenerator.sCUTData[i].length() == 1) {
                addIndex(layout, this, DataGenerator.sCUTData[i]);
                count++;
            } else {
                if (DataGenerator.sCUTData[i].equals(DataGenerator.MYPASS)) {
                    addContent(DataGenerator.sCUTData[i], layout, this, DataGenerator.id[i - count], clickListener);
                } else if (DataGenerator.sCUTData[i].equals(DataGenerator.EDITMSG)) {
                    addContent(DataGenerator.sCUTData[i], layout, this, DataGenerator.id[i - count], msgEditClickListener);
                } else {
                    addContent(DataGenerator.sCUTData[i], layout, this, DataGenerator.id[i - count], view -> Log.e(TAG, "1"));

                }
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void addContent(String str, LinearLayout llContentView, Context context, int id, View.OnClickListener clickListener) {
        // 开始添加控件
        // 1.创建外围LinearLayout控件
        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams lLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置margin
        lLayoutParams.setMargins(10, 0, 0, 0);
        layout.setLayoutParams(lLayoutParams);
        // 设置属性
        layout.setPadding(0, 10, 0, 10);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setOnClickListener(clickListener);
        //layout.setBackground(context.getDrawable(R.drawable.user_center_item));

        // 2.创建图片控件
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams imageParam = new LinearLayout.LayoutParams(
                140, 140);
        //imageParam.weight = 1;
        imageParam.gravity = Gravity.CENTER_VERTICAL;
        imageParam.setMargins(40, 10, 0, 10);
        imageView.setLayoutParams(imageParam);
        // 设置属性
        imageView.setImageResource(id);
        imageView.setPadding(0, 0, 10, 0);
        // 将ImageView放到LinearLayout里
        layout.addView(imageView);

        // 3.创建内部TextText控件
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParam.setMargins(10, 10, 0, 10);
        textParam.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(textParam);
        // 设置属性
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);
        textView.setPadding(10, 0, 0, 0);
        textView.setTextSize(17);
        textView.setText(str);
        textView.setTextColor(Color.BLACK);
        // 将TextView放到LinearLayout里
        layout.addView(textView);

        //添加点击监听事件
        layout.setOnClickListener(clickListener);
        // 4.将layout同它内部的所有控件加到最外围的llContentView容器里
        llContentView.addView(layout);
        addDividingLine(llContentView, context);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void addDividingLine(LinearLayout linearLayout, Context context) {
        //创建分割线
        View line = new View(context);
        LinearLayout.LayoutParams lineParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
        lineParam.setMargins(40, 0, 10, 0);
        line.setLayoutParams(lineParam);
        line.setBackground(context.getDrawable(R.color.chat_gray));
        linearLayout.addView(line);
    }

    private void addIndex(LinearLayout linearLayout, Context context, String str) {
        LinearLayout layout = new LinearLayout(context);
        LinearLayout.LayoutParams lLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置margin
        lLayoutParams.setMargins(10, 0, 0, 0);
        layout.setLayoutParams(lLayoutParams);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setBackground(getDrawable(R.color.chat_gray));
        // textView

        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParam.setMargins(20, 10, 0, 10);
        textParam.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(textParam);
        // 设置属性
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        //textView.setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);
        //textView.setPadding(10, 0, 0, 0);
        textView.setTextSize(14);
        textView.setText(str);
        textView.setTextColor(Color.BLACK);
        // 将TextView放到LinearLayout里
        layout.addView(textView);
        linearLayout.addView(layout);
    }

    private final View.OnClickListener clickListener = view -> {
        Intent intent = new Intent(view.getContext(), HomeActivity.class);
        startActivity(intent);
    };

    private final View.OnClickListener msgEditClickListener = view -> {
        Intent intent = new Intent(view.getContext(), MsgEditActivity.class);
        startActivity(intent);
    };

}
