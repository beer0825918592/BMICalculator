package com.example.bmicalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

     private static final String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText=findViewById(R.id.heightbutton);
                EditText weightEditText=findViewById(R.id.weightbutton);
                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
               float bmi= calculateBmi(h,w);
               String msg ="ค่า ฺ Bmi เท่ากับ "+String.format(Locale.US,"%.2f",bmi);


               String resultText=null;
               if(bmi <18.5){
                   resultText="ผอมเกินไป";
               }else if(bmi<25){
                   resultText="น้ำหนักปกติ ไม่อ้วนไม่ผอม";
               }else if(bmi<30){
                   resultText="อ้วน";
               }else{
                   resultText="อ้วนมาก";
               }
                String msg_resultText="เนำ้หนักของคุณอยู่ในเกกณฑ์ : "+resultText;
              /* // Toast 1
                Toast t = Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT);
                t.show();*/

                //Toast 2
                Toast.makeText(MainActivity.this,resultText, Toast.LENGTH_SHORT).show();
            /*    // dialog 1
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Result ");
                dialog.setMessage(msg);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // todo: โค๊ดที่ให้ uesr คลิ๊ก ok ใน dialog
                    }
                });
                dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                dialog.show();*/

                //fluent


                // dialog 2
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Result ")
                            .setMessage(msg_resultText) //  msg
                            .setPositiveButton("OK",null)
                            .setNegativeButton("NO",null)
                            .setCancelable(false)
                            .show();

                    // Readability
                 //   Glide.with(context).load(URL).into(imageview);
            }
        });

    }
    private float calculateBmi(int heightInCm,int weightInKg){
        // bmi = kg/m^2
        float height=heightInCm/100f;
        Log.i(TAG,"ความสูงหน่อยเมตร = "+String.valueOf(height));
        return weightInKg/(height*height);

    }
}
