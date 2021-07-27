package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tokengenerator.utilities.Utilities;

public class AddNewTokenName extends AppCompatActivity {
    private EditText newToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_token_name);

        newToken = (EditText)findViewById(R.id.tv_typeName);
    }


    //Método para el botón Add New Token Name
    public void addNewTokenName(View view) {
        try {
            DataBase conn = new DataBase(this, "administration", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();
            String name = newToken.getText().toString();

            if(!name.isEmpty()) {
                ContentValues registration = new ContentValues();
                registration.put(Utilities.NAME_FIELD, name);

                db.insert(Utilities.TOKEN_NAME_TABLE,null, registration);

                newToken.setText("");

                Toast.makeText(this, name + " has been registered successfully!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Please, insert a Token's Name", Toast.LENGTH_SHORT).show();
            }

            db.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}