package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button1);

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), "Short Click Press", Toast.LENGTH_LONG).show();
                Intent i = new Intent(v.getContext(), ShortClick.class);
                startActivity(i);
            }
        });

        bt1.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Toast.makeText(v.getContext(), "Long Click Press", Toast.LENGTH_LONG).show();
                Intent i = new Intent(v.getContext(), LongClick.class);
                startActivity(i);

                return true;
            }
        });
    }
}