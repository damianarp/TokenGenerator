package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método para botón Generate Token
    public void generateToken(View view) {
        Intent generateToken = new Intent(this, GenerateToken.class);
        startActivity(generateToken);
    }

    //Método para botón Add New Token Name
    public void addTokenName(View view) {
        Intent addTokenName = new Intent(this, AddNewTokenName.class);
        startActivity(addTokenName);
    }
}