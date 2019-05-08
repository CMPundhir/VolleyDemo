package com.cmpundhir.cm.volleydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.JsonArrayRequest;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn1)
    public void onBtn1Clicked(View view){
        Intent intent = new Intent(MainActivity.this,SimpleRequestActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn2)
    public void onBtn2Clicked(View view){
        Intent intent = new Intent(MainActivity.this,JsonObjectRequestActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn3)
    public void onBtn3Clicked(View view){
        Intent intent = new Intent(MainActivity.this, JSONArrayReqActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn4)
    public void onBtn4Clicked(View view){

    }
    @OnClick(R.id.btn5)
    public void onBtn5Clicked(View view){

    }
}
