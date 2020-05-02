package com.ar.sqllitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText edtfn, edtLn;
    Button btnAdd;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edtfn = (EditText) findViewById(R.id.etFirstName);
        edtLn = (EditText) findViewById(R.id.etLastname);
        db = new DatabaseHandler(this);

        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strfn = edtfn.getText().toString();
                String strln = edtLn.getText().toString();

                ContactModel contact = new ContactModel();
                contact.setFirstName(strfn);
                contact.setLastName(strln);
                db.insertRecord(contact);
                edtfn.setText("");
                edtLn.setText("");

                Intent i = new Intent(AddActivity.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }
}
