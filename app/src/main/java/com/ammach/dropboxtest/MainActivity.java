package com.ammach.dropboxtest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cloudrail.si.interfaces.CloudStorage;
import com.cloudrail.si.services.Dropbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.img);


    }

    public void testMailing(View view) {
        startActivity(new Intent(this,MailingActivity.class));
    }

    public void uploadImg(View view) {
        final CloudStorage cs = new Dropbox(this, "irnlwbu2f70pi7w","030r284xtlbjp85");
        new Thread() {
            @Override
            public void run() {
                AssetManager assetManager = getAssets();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.amine);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();
                ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
                cs.upload("/jasper/mine.jpg", bs,bitmapdata.length, false);
                String shareLink = cs.createShareLink("/jasper/mine.jpg");
                Log.e("img", shareLink);
            }
        }.start();
    }
}
