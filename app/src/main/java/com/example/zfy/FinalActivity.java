package com.example.zfy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FinalActivity extends AppCompatActivity {
    private Button mBtnRetry;
    private Button mBtnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent intent = getIntent();
        int sex = intent.getIntExtra("sexdata",0);
        int age = intent.getIntExtra("agedata",0);
        TextView HeightTv = (TextView) findViewById(R.id.tv_height) ;
        double height = intent.getDoubleExtra("heightdata",0.0);
        String heightdata = String.valueOf(height);
        HeightTv.setText(heightdata);
        TextView WeightTv = (TextView) findViewById(R.id.tv_weight);
        double weight = intent.getDoubleExtra("weightdata",0.0);
        String weightdata = String.valueOf(weight);
        WeightTv.setText(weightdata);
        double bmi = (weight * 10000) / (height * height);
        double fat,water,muscle,sclerotin,metabolism,all,standardweight;
        int bmigrade,fatgrade,watergrade,musclegrade,sclerotingrade,metabolismgrade;
        String heighttext,weighttext,bmitext,fattext,muscletext,watertext,sclerotintext,metabolismtext,alltext;
        if (sex == 1) {
            fat = (1.2 * bmi + 0.23 * age - 5.4 - 10.8) / 100;
            muscle = 78 /(2 * weight);
            water = 1.2 * muscle;
            sclerotin = (weight - age) * 0.2;
            metabolism = 13.7 * weight + 5.0 * height - 6.8 * age + 66;
            if (height < 160)
                heighttext = "偏低";
            else if (160 <= height && height <= 200)
                heighttext = "标准";
            else heighttext = "无法定义";
            TextView HeightTextTv = (TextView) findViewById(R.id.tv_heighttext);
            HeightTextTv.setText(heighttext);
            standardweight = (height - 80) * 0.7;
            if (0.9 * standardweight < weight && weight < 1.1 * standardweight)
                weighttext = "正常";
            else if (0.8 * standardweight < weight && weight < 0.9 * standardweight)
                weighttext = "偏轻";
            else if (1.1 * standardweight < weight && weight < 1.2 * standardweight)
                weighttext = "偏重";
            else if (weight < 0.8 * standardweight)
                weighttext = "营养不良";
            else if (weight > 1.2 * standardweight)
                weighttext = "肥胖";
            else weighttext = "无法定义";
            TextView WeightTextTv = (TextView) findViewById(R.id.tv_weighttext);
            WeightTextTv.setText(weighttext);
            if (10 <= bmi && bmi <= 18.5) {
                bmitext = "过轻";
                bmigrade = 75;
            }
            else if (18.5 < bmi && bmi <= 24) {
                bmitext = "正常";
                bmigrade = 100;
            }
            else if (24 < bmi && bmi <= 28) {
                bmitext = "超重";
                bmigrade = 80;
            }
            else if (28 < bmi && bmi <= 35) {
                bmitext = "肥胖";
                bmigrade = 60;
            }
            else {
                bmitext = "无法定义";
                bmigrade = 0;
            }
            if (0.08 < fat && fat <= 0.15) {
                fattext = "过瘦";
                fatgrade =70;
            }
            else if (0.15 < fat && fat <= 0.25) {
                fattext = "正常";
                fatgrade =100;
            }
            else if (0.25 < fat && fat <= 0.35) {
                fattext = "超重";
                fatgrade =70;
            }
            else {
                fattext = "无法定义";
                fatgrade = 0;
            }
            if (muscle <= 0.6) {
                muscletext = "偏低";
                musclegrade = 60;
            }
            else if (0.6 <= muscle && muscle <= 0.65) {
                muscletext = "正常";
                musclegrade = 80;
            }
            else if (0.65 <= muscle && muscle <= 0.7) {
                muscletext = "优秀";
                musclegrade = 100;
            }
            else {
                muscletext = "无法定义";
                musclegrade = 0;
            }
            if (water < 0.7){
                watertext = "偏低";
                watergrade = 70;
            }
            else if (0.7 <= water && water <= 0.8){
                watertext = "正常";
                watergrade = 100;
            }
            else if (water > 0.8){
                watertext = "偏高";
                watergrade = 70;
            }
            else {
                watertext = "无法定义";
                watergrade = 0;
            }
            if (sclerotin < -4){
                sclerotintext = "风险高";
                sclerotingrade = 50;
            }
            else if (-4 <= sclerotin && sclerotin < -1){
                sclerotintext = "中度风险";
                sclerotingrade = 70;
            }
            else if (sclerotin > -1){
                sclerotintext = "风险低";
                sclerotingrade = 100;
            }
            else {
                sclerotintext = "无法定义";
                sclerotingrade = 0;
            }
            if (metabolism < 1300){
                metabolismtext = "偏低";
                metabolismgrade = 70;
            }
            else if (1300 <= metabolism && metabolism <= 1900){
                metabolismtext = "正常";
                metabolismgrade = 100;
            }
            else if (metabolism > 1900){
                metabolismtext = "偏高";
                metabolismgrade = 70;
            }
            else {
                metabolismtext = "无法定义";
                metabolismgrade = 70;
            }
            all = bmigrade * 0.5 + fatgrade * 0.1 + musclegrade * 0.1 + watergrade * 0.1 + sclerotingrade * 0.1 + metabolismgrade * 0.1;
            if (all < 70)
                alltext = "较差";
            else if (70 <= all && all < 85)
                alltext = "良好";
            else if (85 <= all && all < 100)
                alltext = "优秀";
            else alltext = "???";
            DecimalFormat dfone = new DecimalFormat("#.0");
            DecimalFormat dfthree = new DecimalFormat("#.000");
            NumberFormat nf = NumberFormat.getPercentInstance();
            TextView BmiTv = (TextView) findViewById(R.id.tv_bmi);
            String bmidata = dfone.format(bmi);
            BmiTv.setText(bmidata);
            TextView BmiTextTv = (TextView) findViewById(R.id.tv_bmitext);
            BmiTextTv.setText(bmitext);
            TextView FatTv = (TextView) findViewById(R.id.tv_fat);
            String fatdata1 = dfthree.format(fat);
            Double fatdata2 = Double.valueOf(fatdata1);
            String fatdata = nf .format(fatdata2);
            FatTv.setText(fatdata);
            TextView FatTextTv = (TextView) findViewById(R.id.tv_fattext);
            FatTextTv.setText(fattext);
            TextView MuscleTv = (TextView) findViewById(R.id.tv_muscle);
            String muscledata1 = dfthree.format(muscle);
            Double muscledata2 = Double.valueOf(muscledata1);
            String muscledata = nf .format(muscledata2);
            MuscleTv.setText(muscledata);
            TextView MuscleTextTv = (TextView) findViewById(R.id.tv_muscletext);
            MuscleTextTv.setText(muscletext);
            TextView WaterTv = (TextView) findViewById(R.id.tv_water);
            String waterdata1 = dfthree.format(water);
            Double waterdata2 = Double.valueOf(waterdata1);
            String waterdata = nf .format(waterdata2);
            WaterTv.setText(waterdata);
            TextView WaterTextTv = (TextView) findViewById(R.id.tv_watertext);
            WaterTextTv.setText(watertext);
            TextView SclerotinTv = (TextView) findViewById(R.id.tv_sclerotin);
            String sclerotindata = dfone.format(sclerotin);
            SclerotinTv.setText(sclerotindata);
            TextView SclerotinTextTv = (TextView) findViewById(R.id.tv_sclerotintext);
            SclerotinTextTv.setText(sclerotintext);
            TextView MetabolismTv = (TextView) findViewById(R.id.tv_metabolism);
            String metabolismdata = dfone.format(metabolism);
            MetabolismTv.setText(metabolismdata);
            TextView MetabolismTextTv = (TextView) findViewById(R.id.tv_metabolismtext);
            MetabolismTextTv.setText(metabolismtext);
            TextView AllTv = (TextView) findViewById(R.id.tv_all);
            String alldata = dfone.format(all);
            AllTv.setText(alldata);
            TextView AlltexttTv = (TextView) findViewById(R.id.tv_alltext);
            AlltexttTv.setText(alltext);
        }
        else if (sex == 0) {
            fat = (1.2 * bmi + 0.23 * age - 5.4) / 100;
            muscle =56 / (2 * weight);
            water = 1.3 * muscle;
            metabolism = 9.6 * weight + 1.8 * height - 4.7 * age + 66 + 655;
            sclerotin = (weight - age) * 0.2;
            if (height < 150)
                heighttext = "偏低";
            else if (150 <= height && height <= 200)
                heighttext = "标准";
            else heighttext = "无法定义";
            TextView HeightTextTv = (TextView) findViewById(R.id.tv_heighttext);
            HeightTextTv.setText(heighttext);
            standardweight = (height - 70) * 0.6;
            if (0.9 * standardweight < weight && weight < 1.1 * standardweight)
                weighttext = "正常";
            else if (0.8 * standardweight < weight && weight < 0.9 * standardweight)
                weighttext = "偏轻";
            else if (1.1 * standardweight < weight && weight < 1.2 * standardweight)
                weighttext = "偏重";
            else if (weight < 0.8 * standardweight)
                weighttext = "营养不良";
            else if (weight > 1.2 * standardweight)
                weighttext = "肥胖";
            else weighttext = "无法定义";
            TextView WeightTextTv = (TextView) findViewById(R.id.tv_weighttext);
            WeightTextTv.setText(weighttext);
            if (10 <= bmi && bmi <= 18.5) {
                bmitext = "过轻";
                bmigrade = 75;
            }
            else if (18.5 < bmi && bmi <= 24) {
                bmitext = "正常";
                bmigrade = 100;
            }
            else if (24 < bmi && bmi <= 28) {
                bmitext = "超重";
                bmigrade = 80;
            }
            else if (28 < bmi && bmi <= 35) {
                bmitext = "肥胖";
                bmigrade = 60;
            }
            else {
                bmitext = "无法定义";
                bmigrade = 0;
            }
            if (0.1 < fat && fat <= 0.2) {
                fattext = "过瘦";
                fatgrade =70;
            }
            else if (0.2 < fat && fat <= 0.3) {
                fattext = "正常";
                fatgrade =100;
            }
            else if (0.3 < fat && fat <= 0.45) {
                fattext = "超重";
                fatgrade =70;
            }
            else {
                fattext = "无法定义";
                fatgrade = 0;
            }
            if (muscle <= 0.55) {
                muscletext = "偏低";
                musclegrade = 60;
            }
            else if (0.55 <= muscle && muscle <= 0.6) {
                muscletext = "正常";
                musclegrade = 80;
            }
            else if (0.6 <= muscle && muscle <= 0.65) {
                muscletext = "优秀";
                musclegrade = 100;
            }
            else {
                muscletext = "无法定义";
                musclegrade = 0;
            }
            if (water < 0.7){
                watertext = "偏低";
                watergrade = 70;
            }
            else if (0.7 <= water && water <= 0.8){
                watertext = "正常";
                watergrade = 100;
            }
            else if (water > 0.8){
                watertext = "偏高";
                watergrade = 70;
            }
            else {
                watertext = "无法定义";
                watergrade = 0;
            }
            if (sclerotin < -4){
                sclerotintext = "风险高";
                sclerotingrade = 50;
            }
            else if (-4 <= sclerotin && sclerotin < -1){
                sclerotintext = "中度风险";
                sclerotingrade = 70;
            }
            else if (sclerotin > -1){
                sclerotintext = "风险低";
                sclerotingrade = 100;
            }
            else {
                sclerotintext = "无法定义";
                sclerotingrade = 0;
            }
            if (metabolism < 1100){
                metabolismtext = "偏低";
                metabolismgrade = 70;
            }
            else if (1100 <= metabolism && metabolism <= 1500){
                metabolismtext = "正常";
                metabolismgrade = 100;
            }
            else if (metabolism > 1500){
                metabolismtext = "偏高";
                metabolismgrade = 70;
            }
            else {
                metabolismtext = "无法定义";
                metabolismgrade = 70;
            }
            all = bmigrade * 0.5 + fatgrade * 0.1 + musclegrade * 0.1 + watergrade * 0.1 + sclerotingrade * 0.1 + metabolismgrade * 0.1;
            if (all < 70)
                alltext = "较差";
            else if (70 <= all && all < 85)
                alltext = "良好";
            else if (85 <= all && all < 100)
                alltext = "优秀";
            else alltext = "???";
            DecimalFormat dfone = new DecimalFormat("#.0");
            DecimalFormat dfthree = new DecimalFormat("#.000");
            NumberFormat nf = NumberFormat.getPercentInstance();
            TextView BmiTv = (TextView) findViewById(R.id.tv_bmi);
            String bmidata = dfone.format(bmi);
            BmiTv.setText(bmidata);
            TextView BmiTextTv = (TextView) findViewById(R.id.tv_bmitext);
            BmiTextTv.setText(bmitext);
            TextView FatTv = (TextView) findViewById(R.id.tv_fat);
            String fatdata1 = dfthree.format(fat);
            Double fatdata2 = Double.valueOf(fatdata1);
            String fatdata = nf .format(fatdata2);
            FatTv.setText(fatdata);
            TextView FatTextTv = (TextView) findViewById(R.id.tv_fattext);
            FatTextTv.setText(fattext);
            TextView MuscleTv = (TextView) findViewById(R.id.tv_muscle);
            String muscledata1 = dfthree.format(muscle);
            Double muscledata2 = Double.valueOf(muscledata1);
            String muscledata = nf .format(muscledata2);
            MuscleTv.setText(muscledata);
            TextView MuscleTextTv = (TextView) findViewById(R.id.tv_muscletext);
            MuscleTextTv.setText(muscletext);
            TextView WaterTv = (TextView) findViewById(R.id.tv_water);
            String waterdata1 = dfthree.format(water);
            Double waterdata2 = Double.valueOf(waterdata1);
            String waterdata = nf .format(waterdata2);
            WaterTv.setText(waterdata);
            TextView WaterTextTv = (TextView) findViewById(R.id.tv_watertext);
            WaterTextTv.setText(watertext);
            TextView SclerotinTv = (TextView) findViewById(R.id.tv_sclerotin);
            String sclerotindata = dfone.format(sclerotin);
            SclerotinTv.setText(sclerotindata);
            TextView SclerotinTextTv = (TextView) findViewById(R.id.tv_sclerotintext);
            SclerotinTextTv.setText(sclerotintext);
            TextView MetabolismTv = (TextView) findViewById(R.id.tv_metabolism);
            String metabolismdata = dfone.format(metabolism);
            MetabolismTv.setText(metabolismdata);
            TextView MetabolismTextTv = (TextView) findViewById(R.id.tv_metabolismtext);
            MetabolismTextTv.setText(metabolismtext);
            TextView AllTv = (TextView) findViewById(R.id.tv_all);
            String alldata = dfone.format(all);
            AllTv.setText(alldata);
            TextView AlltexttTv = (TextView) findViewById(R.id.tv_alltext);
            AlltexttTv.setText(alltext);
        }

        mBtnRetry = (Button) findViewById(R.id.btn_retry);
        mBtnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        mBtnHome = (Button) findViewById(R.id.btn_home);
        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
