package com.example.usersio.gsbcm.help_bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class GestionBD {
	private SQLiteDatabase maBase;
	private BdHelper monBdHelper;

	public GestionBD(Context context) {
		monBdHelper = new BdHelper(context, "save", null, 2);
	}
	public void open(){
		maBase = monBdHelper.getWritableDatabase();
	}
	public void close() {
		maBase.close();
	}

	//TODO : stocker token et pas login et mdp
	public void ajouteIdentifiants(String login,String password){
		ContentValues v = new ContentValues();
		v.put("login",login);
		v.put("password", password);
		maBase.insert("user", null, v);
	}
	public void ajouteToken(String token){
		ContentValues v = new ContentValues();
		v.put("token",token);
		maBase.insert("tokens", null, v);
	}
	public void supprimeIdentifiants(){
		maBase.delete("user", null, null);
	}
	public void supprimeToken(){
		maBase.delete("tokens", null, null);
	}
	public ArrayList<String> donneIdentifiants(){
		ArrayList<String> liste = new ArrayList<String>();
		Cursor c = maBase.rawQuery("select login, password from user",null);
		if(c!=null) {
			while (c.moveToNext()) liste.add(c.getString(0) + "/" + c.getString(1));
			return liste;
		}else{
			return null;
		}
	}
	public ArrayList<String> getToken(){
		ArrayList<String> liste = new ArrayList<String>();
		Cursor c = maBase.rawQuery("select token from tokens",null);
		if(c!=null) {
			while (c.moveToNext()) liste.add(c.getString(0));
			return liste;
		}else{
			return null;
		}
	}
}
