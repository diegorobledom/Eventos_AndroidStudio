package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShortClick extends AppCompatActivity
{
    ArrayList<String> activities = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_click);

        activities.add("Actividad Principal");
        activities.add("Actividad Long");

        ListView listview1 = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, activities);
        listview1.setAdapter(adapter);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id)
            {
                Toast.makeText(view.getContext(), "Has seleccionado: "+
                        activities.get(index), Toast.LENGTH_LONG).show();
            }});

        listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int index, long arg3) {
                if(index==0) {
                    Toast.makeText(v.getContext(), "Long Click Press",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(v.getContext(), "Long Click Press",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(v.getContext(), LongClick.class);
                    startActivity(i);
                }
                return true;
            }
        });
    }
}