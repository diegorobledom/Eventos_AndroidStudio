package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LongClick extends AppCompatActivity
{
    SwitchCompat sw;
    EditText et1,et2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_click);

        sw = (SwitchCompat) findViewById(R.id.switch1);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        tv1 = (TextView) findViewById(R.id.textView);

        sw.setChecked(true);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    et1.setVisibility(View.VISIBLE);
                } else
                {
                    et1.setVisibility(View.GONE);
                }
            }
        });

        et1.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean hasFocus)
            {
                if (hasFocus)
                {
                    tv1.setText("Foco en EditText1");
                    Toast.makeText(getApplicationContext(), "Foco en EditText", Toast.LENGTH_LONG).show();
                } else
                {
                    tv1.setText("Long Click Activity");
                    Toast.makeText(getApplicationContext(), "Foco Fuera de EditText", Toast.LENGTH_LONG).show();
                }
            }
        });

        et2.setOnKeyListener(new EditText.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (keyCode == KeyEvent.KEYCODE_A)
                {
                    Toast.makeText(getApplicationContext(), "Key A Press", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }
}