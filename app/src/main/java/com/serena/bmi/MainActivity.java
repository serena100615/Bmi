package com.serena.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    private EditText edWeight;
    private EditText edHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getResources().getString(R.string.app_name);
        Button bHelp = (Button) findViewById(R.id.b_info);
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("XXX")
                    .setMessage("BMI吧啦吧啦吧啦吧啦")
                    .setPositiveButton("OK",null)
                    .show();
            }
        });
    }
    public void bmi(View view){
//          System.out.println("what???");
        Log.d("MainActivity","testing bmi method");
        findViews();
//        String s = edWeight.getText().toString();
//        float weight = Float.parseFloat(s);
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height*height);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(getString(R.string.bmi_extra),bmi);
        startActivity(intent);

        Log.d("MainActivity","Your BMI is:"+bmi);
        if(height>3){
            new AlertDialog.Builder(this).setMessage("身高單位應為公尺").setPositiveButton(R.string.OK2,null).show();
        }else{
        if(bmi<20){
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is)+bmi+"請多吃點")
                .setTitle(R.string.title)
                .setPositiveButton(R.string.OK,null)
                .show();
                 }else{
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is)+bmi)
                    .setTitle(R.string.title)
                    .setPositiveButton(R.string.OK,null)
                    .show();
        }
        }
    }

    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_height);
    }

        /*Toast.makeText(this,"Your BMI is "+bmi,Toast. LENGTH_SHORT).show();*/

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }
}
