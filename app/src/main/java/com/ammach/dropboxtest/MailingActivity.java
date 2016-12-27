package com.ammach.dropboxtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.cloudrail.si.services.SendGrid;

import java.util.Arrays;

public class MailingActivity extends AppCompatActivity {


    EditText editMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailing);

        editMsg= (EditText) findViewById(R.id.editMsg);
    }

    public void testMailing(View view) {
        final SendGrid email = new SendGrid(this,"HY5Vy7L2TGmoFtTEIWc9dQ");
        new Thread() {
            @Override
            public void run() {
                try {
                    email.sendEmail("zizomatch10@live.fr", "CloudRail", Arrays.asList("amineammach@hotmail.com", "aminzizods@gmail.com"), "this is the title",editMsg.getText().toString(), null, null, null);
                }catch (Exception e){
                    Log.e("ziiiiiina", e.toString());
                }

            }
        }.start();
    }
}
