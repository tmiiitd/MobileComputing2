package com.example.hp.androidapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Button btack;
    Intent i = getIntent();
    private TextView tx3;

    String s = i.getStringExtra("edit");
    public void PrimeNum()
    {
        int num=0;
        tx3 = (TextView)findViewById(R.id.textView3);
        int flag = 0;
        num = Integer.parseInt(s);
        for(int j=0;j<=num/2;j++)
        {
            if(j%2==0)
                flag = 1;
        }
        if(flag == 1)
        {
            tx3.setText("is not a prime number");
        }
        else
        {
            tx3.setText("is a prime number");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tx3 = (TextView)findViewById(R.id.textView3);
        btack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"You have cheated",Toast.LENGTH_LONG).show();
                Intent i = getIntent();

            }
        });




    }



}
