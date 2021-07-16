package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Random;

public class GenerateToken extends AppCompatActivity {

    private Spinner spinner1;
    private TextView tv_resultado;

    String option1 = "Token Name 1";
    String option2 = "Token Name 2";
    String option3 = "Token Name 3";
    String option4 = "Token Name 4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_token);

        spinner1 = findViewById(R.id.spinner);
        tv_resultado = findViewById(R.id.tv_result);

        String[] options = {"Select a Token Name", option1, option2, option3, option4};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        spinner1.setAdapter(adapter);

    }
    // Creamos un objeto de tipo Random para generar el token
    Random random = new Random();

    //Método para el botón Generate New Token
    @SuppressLint("SetTextI18n")
    public void generateNewToken(View view) {
        String selection = spinner1.getSelectedItem().toString();
        CharSequence text0 = "";
        CharSequence text1 = "Generated Token:\n" + "<" + new BigInteger(320, random).toString(32) + ">";
        CharSequence text2 = "Generated Token:\n" + "<" + new BigInteger(320, random).toString(32) + ">";
        CharSequence text3 = "Generated Token:\n" + "<" + new BigInteger(320, random).toString(32) + ">";
        CharSequence text4 = "Generated Token:\n" + "<" + new BigInteger(320, random).toString(32) + ">";

        // Un BigInteger, de 320 bits (64 caracteres * 5 bits por caracter)
        tv_resultado.setText(new BigInteger(320, random).toString(32));

        switch (selection) {
            case "Select a Token Name":
                Toast.makeText(this, "Please, select an option", Toast.LENGTH_LONG).show();
                tv_resultado.setText(text0);
                break;
            case "Token Name 1":
                tv_resultado.setText(text1);
                break;
            case "Token Name 2":
                tv_resultado.setText(text2);
                break;
            case "Token Name 3":
                tv_resultado.setText(text3);
                break;
            case "Token Name 4":
                tv_resultado.setText(text4);
                break;
            default:
                Toast.makeText(this, "Please, select an option", Toast.LENGTH_LONG).show();
        }
    }
}