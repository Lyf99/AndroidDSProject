package com.bwie.kao06;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button send_sao;
    private WebView send_web;
    private final int NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        send_sao = (Button) findViewById(R.id.send_sao);
        send_web = (WebView) findViewById(R.id.send_web);

        send_sao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_sao:
                Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
                startActivityForResult(intent,NUM);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==NUM && resultCode==RESULT_OK){
            if(data!=null){
                String result = data.getStringExtra("result");
                send_web.saveWebArchive(result);
            }
        }
    }
}
