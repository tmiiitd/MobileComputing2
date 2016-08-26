package com.example.hp.androidapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tx;
    private EditText edit;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edit = (EditText)findViewById(R.id.editText);

        bt1 = (Button)findViewById(R.id.button);//Correct
        bt2 = (Button)findViewById(R.id.button2);//Incorrect

        bt3 = (Button)findViewById(R.id.button3);//HINT
        bt4 = (Button)findViewById(R.id.button4);//Cheat
        bt5 = (Button)findViewById(R.id.button5);//NEXT

//Correct
        bt1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
              {
                bt3.setEnabled(false);
                bt2.setEnabled(false);
                bt4.setEnabled(false);
                bt5.setEnabled(false);
                if(isPrime())
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);

                }
                bt1.setEnabled(false);

            }

        });
 //Incorrect
        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vw)
            {
                bt3.setEnabled(false);
                bt1.setEnabled(false);
                bt4.setEnabled(false);
                bt5.setEnabled(false);
                if(!isPrime())
                {
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                    bt3.setEnabled(true);
                }
                bt2.setEnabled(false);

            }

        });

        final Random randomGenerator = new Random();
        for(int ind = 1;ind <= 10;++ind)
        {
            int randomInt = randomGenerator.nextInt(100);
        }
        edit.setText(String.valueOf(randomGenerator));
        bt5.setOnClickListener (new View.OnClickListener() {

            public void onClick(View v)
            {
//When next button is clicked then right and wrong will be disabled

                bt4.setEnabled(true);
                bt3.setEnabled(true);
                edit.setText(String.valueOf(randomGenerator));
                bt1.setEnabled(true);
                bt2.setEnabled(true);
                bt5.setEnabled(false);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View vv)
            {
                String r = edit.getText().toString();

                Intent ii = new Intent(MainActivity.this,ThirdActivity.class);
                ii.putExtra("editing",r);
                startActivity(ii);

            }
        });
        bt3.setEnabled(false);
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv)
            {
                Intent i = new Intent(MainActivity.this,SecActivity.class);
                startActivity(i);

            }
        });

    }
    public boolean isPrime()
    {
        int flag = 0;
        String str = edit.getText().toString();
        int number = Integer.parseInt(str);
        for(int i=2;i<=number/2;++i)
        {
            if(number%i == 0)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
        {
            return true;
        }
        return false;
    }
}
