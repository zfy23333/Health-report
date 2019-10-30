package com.example.zfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    private Button mBtnBack;
    private Button mBtnTest;
    private EditText mEtsex;
    private EditText mEtage;
    private EditText mEtheight;
    private EditText mEtweihgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mBtnBack = (Button) this.findViewById(R.id.btn_back);
        mBtnTest = (Button) this.findViewById(R.id.btn_test);
        mEtsex = (EditText) findViewById(R.id.et_sex);
        mEtage = (EditText) findViewById(R.id.et_age);
        mEtheight = (EditText) findViewById(R.id.et_height);
        mEtweihgt = (EditText) findViewById(R.id.et_weight);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,FinalActivity.class);
                Integer sex = Integer.parseInt(mEtsex.getText().toString());
                Integer age = Integer.parseInt(mEtage.getText().toString());
                Double height = Double.parseDouble(mEtheight.getText().toString());
                Double weight = Double.parseDouble(mEtweihgt.getText().toString());
                if (0 <= sex && sex <= 1 && 16 <= age && age < 100 && 130 <= height && height <= 200 && 40 <= weight && weight <= 110){
                    intent.putExtra("sexdata", sex);
                    intent.putExtra("agedata",age);
                    intent.putExtra("heightdata",height);
                    intent.putExtra("weightdata",weight);
                    startActivity(intent);
                }
                else {
                        Toast.makeText(getApplicationContext(),"输入错误，请输入正确信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
