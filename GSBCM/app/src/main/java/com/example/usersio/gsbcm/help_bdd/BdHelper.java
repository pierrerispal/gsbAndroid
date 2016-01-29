package com.example.usersio.gsbcm.help_bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper {

	public BdHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String req = "create table tokens(id integer primary key autoincrement, token text)";
		db.execSQL(req);

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String req = "create table tokens(id integer primary key autoincrement, token text)";
		db.execSQL(req);
	}
}
