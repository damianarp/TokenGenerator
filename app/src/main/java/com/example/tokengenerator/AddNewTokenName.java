package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddNewTokenName extends AppCompatActivity {
    private EditText type_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_token_name);

        type_name = (EditText)findViewById(R.id.tv_typeName);
    }

    //Método para el botón Add New Token Name


}