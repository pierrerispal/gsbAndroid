package com.example.usersio.gsbcm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.support.v7.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.usersio.gsbcm.help_bdd.GestionBD;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //new connection to database
        ConnectionApi connection=new ConnectionApi();

        //Finding the listview we want to interract with
        ListView listLines;
        listLines = (ListView)findViewById(R.id.listLines);

        /*
        *=====================================OPTION 1==============================================
         */
        //Getting all the lines to show
        //String[] values= connection.getCostSheetNow().showCostSheet();

        //setting the adapter to show the list of lines
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
               //android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //listLines.setAdapter(adapter);

        /*
        *=====================================OPTION 2==============================================
         */
        CostSheet cs=connection.getCostSheetNow();
        connection.getToken("visiteur","test");

        ArrayList<HashMap<String,String>> liste = cs.getOutPackageLines();
        SimpleAdapter adapter = new SimpleAdapter(this,liste, R.layout.outpackage_line,
                new String[]{"label","amount"},
                new int[] {R.id.libelle, R.id.montant});
        listLines.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //TODO: vider la bdd et revenir sur l'écran de connexion
        if (id == R.id.action_disconnect) {
            GestionBD gestion = new GestionBD(this);
            gestion.open();
            gestion.supprimeIdentifiants();
            Log.i("deco","deco");
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
            finish();
            return true;
        }
        if (id == R.id.action_addLine) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
