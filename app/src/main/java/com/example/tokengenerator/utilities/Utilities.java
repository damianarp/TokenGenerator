package com.example.tokengenerator.utilities;

public class Utilities {

    // Constantes campos tabla USER_TOKEN_NAME
    public static final String TOKEN_NAME_TABLE = "USER_TOKEN_NAME"; // Tabla
    public static final String NAME_FIELD = "USER_TOKEN_NAME"; // Campo USER_TOKEN_NAME

    // Constantes campos tabla USER_TOKEN_CODE
    public static final String TOKEN_CODE_TABLE = "USER_TOKEN_CODE"; // Tabla
    public static final String NAME_ID_FIELD = "TOKEN_NAME_ID"; // Campo TOKEN_NAME_ID
    public static final String CODE_FIELD = "USER_TOKEN_CODE"; // Campo USER_TOKEN_CODE

    //Queries para crear las tablas USER_TOKEN_NAME y USER_TOKEN_CODE.
    public static final String USER_TOKEN_NAME = "CREATE TABLE " + TOKEN_NAME_TABLE + "("+ NAME_FIELD +" varchar(30) PRIMARY KEY)";
    public static final String USER_TOKEN_CODE = "CREATE TABLE " + TOKEN_CODE_TABLE + "("+ NAME_ID_FIELD +" varchar(30) PRIMARY KEY, " +
            CODE_FIELD + " varchar(64)";

}
//CREATE TABLE USER_TOKEN_CODE(TOKEN_NAME_ID VARCHAR(30) PRIMARY KEY, TOKEN_CODE VARCHAR(64))