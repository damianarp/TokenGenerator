package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tokengenerator.entities.User_Token_name;
import com.example.tokengenerator.utilities.Utilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class GenerateToken extends AppCompatActivity {

    private Spinner spinner1;
    private TextView tv_resultado;

    ArrayList<String> listToken;
    ArrayList<User_Token_name> tokenList;

    DataBase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_token);

        conn = new DataBase(this, "administration", null, 1);

        spinner1 = findViewById(R.id.spinner);
        tv_resultado = findViewById(R.id.tv_result);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Selected: " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        consultarListaToken();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listToken);
        spinner1.setAdapter(adapter);
    }

    // Creamos un objeto de tipo Random para generar el token
    Random random = new Random();
    // Un BigInteger, de 320 bits (64 caracteres * 5 bits por caracter)
    String tokenGenerated = new BigInteger(320, random).toString(32);

    //Método para el botón Generate New Token
    @SuppressLint("SetTextI18n")
    public void generateNewToken(View view) {
        String selection = spinner1.getSelectedItem().toString();
        CharSequence text0 = "";
        CharSequence token = "Generated Token:\n" + "<" + new BigInteger(320, random).toString(32) + ">";

        tv_resultado.setText(tokenGenerated);

        if((selection.equals("Select a Token Name"))) {
            Toast.makeText(this, "Please, select an option", Toast.LENGTH_LONG).show();
            tv_resultado.setText(text0);
        } else {
            tv_resultado.setText(token);
        }
    }

    public void consultarListaToken() {
        SQLiteDatabase db = conn.getReadableDatabase();

        User_Token_name token = null;
        tokenList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilities.TOKEN_NAME_TABLE, null);
        while (cursor.moveToNext()) {
            token = new User_Token_name();
            token.setUser_token_name(cursor.getString(0));

            Log.i("Name", token.getUser_token_name());

            tokenList.add(token);
        }
        obtenerLista();

    }

    private void obtenerLista() {
        listToken = new ArrayList<>();
        listToken.add("Select a Token Name");

        for(int i = 0; i<tokenList.size(); i++) {
            listToken.add(tokenList.get(i).getUser_token_name());
        }
    }
}