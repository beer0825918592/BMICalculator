package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity { // 2 implements  View.OnClickListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String message = "Andriod";

        Toast t2 = Toast.makeText(this,message, Toast.LENGTH_SHORT);
        t2.show();

        final Button startButton=findViewById(R.id.start_button);
       startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             /*  Toast t = Toast.makeText(SplashActivity.this,"Hello", Toast.LENGTH_SHORT);
               t.show();*/

           /* MyListener listener = new MyListener(); //1
            startButton.setOnClickListener(listener);*/

          // startButton.setOnClickListener(this);    2
               startButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i =new Intent(SplashActivity.this,MainActivity.class);
                       startActivity(i);
                   }
               });   //3
           }
       });
       Button exitButton=findViewById(R.id.exit_button);
       exitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             /*  Toast t = Toast.makeText(SplashActivity.this,"Exit", Toast.LENGTH_SHORT);
               t.show();*/
             finish();
           }
       });







    }

    /*@Override
    public void onClick(View v) {
        Log.d("bmi","Hello Android");
    }*/ //2

  /*  private class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Log.e("bmi","ok");
        }
    }*/ //1

}
