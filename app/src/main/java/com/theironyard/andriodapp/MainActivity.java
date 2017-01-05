package com.theironyard.andriodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> contact;
    ListView list;
    EditText name;
    EditText phone;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        addButton = (Button) findViewById(R.id.button);

        contact = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contact);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String item = name.getText().toString() + phone.getText().toString();
        contact.add(item);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String contacts = contact.getItem(position);
        contact.remove(contacts);
        return true;
    }
}
