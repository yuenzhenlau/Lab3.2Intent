package com.edu.tarc.practicalapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText height = (EditText) findViewById(R.id.secondNumEditText);
                EditText weight = (EditText) findViewById(R.id.firstNumEditText);
                TextView result = (TextView) findViewById(R.id.resultTextView);
                ImageView image = (ImageView) findViewById(R.id.imageResult);

                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                String bmiLabel = "";


                if (heightStr != null && !"".equals(heightStr) && weightStr != null  &&  !"".equals(weightStr)) {

                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);

                    float bmi = weightValue / (heightValue * heightValue);

                    if(Float.compare(bmi,18.5f) <= 0)
                    {
                        image.setImageResource(R.drawable.under);
                        bmiLabel = getString(R.string.underweight);
                    }
                    else if(Float.compare(bmi,18.5f) > 0 && Float.compare(bmi,25f) <= 0)
                    {
                        image.setImageResource(R.drawable.normal);
                        bmiLabel = getString(R.string.normal);
                    }
                    else if(Float.compare(bmi,25f) > 0 )
                    {
                        image.setImageResource(R.drawable.over);
                        bmiLabel = getString(R.string.overweight);
                    }
                    result.setText(bmiLabel);
                }
            }
        });
    }
}
