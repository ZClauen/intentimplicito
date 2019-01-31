package com.example.intentimplicito;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                Intent it1= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(it1);
                break;
            case R.id.btn2:
                Intent itc= new Intent(Intent.ACTION_CALL, Uri.parse("tel:8717683318"));
                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    //TODO: Consider calling
                    //ActivityCompat#requestPermissions
                    //here to request the missing permissions, and then overriding
                    //public void onRequest
                    return;
                }
                startActivity(itc);
                break;
            case R.id.btn3:
                Intent nav= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                startActivity(nav);
                break;
            case R.id.btn4:
                Intent gal= new Intent();
                gal.setAction(Intent.ACTION_VIEW);
                gal.setType("image/*");
                gal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(gal);
                break;
            case R.id.btn5:
                Intent cam = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(cam);
                break;
            case R.id.btn6:
                Intent it4 = new Intent(Intent.ACTION_SEND);
                it4.putExtra("Mensaje","Axel Serna");
                it4.setType("text/plain");
                startActivity(Intent.createChooser(it4,"Choose one aplication"));
                break;
            case R.id.btn7:
                Intent play= new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps"));
                startActivity(play);
                break;


    }



    }
}
