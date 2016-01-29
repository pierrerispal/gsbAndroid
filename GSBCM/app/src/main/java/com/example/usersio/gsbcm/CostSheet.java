package com.example.usersio.gsbcm;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by usersio on 02/12/2015.
 */
public class CostSheet{
    //attributs
    private int justification_number;
    private double valid_amount=2;
    private Date modification_date;
    private ArrayList<PackageLine> packageLines;
    private ArrayList<OutPackageLine> outPackageLines;
    private double total;

    CostSheet(){
        super();
        this.valid_amount=2;
        packageLines = new ArrayList<PackageLine>();
        outPackageLines = new ArrayList<OutPackageLine>();
    }
    public String[] showCostSheet(){
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        /*for(PackageLine pl: this.packageLines)
        {

        }
        for(OutPackageLine ol: this.outPackageLines)
        {

        }*/
        return values;
    }

    public ArrayList<HashMap<String, String>> getOutPackageLines(){
        ArrayList<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
        for(OutPackageLine ol: this.outPackageLines)
        {
            liste.add(ol.donneLine());
        }
        return liste;
    }
    public void addOutPackageLine(OutPackageLine outPackageLine){
        //Log.i("outPackageLine",outPackageLine.getLabel());
        this.outPackageLines.add(outPackageLine);
    }
    public double getValidAmount(){
        return this.valid_amount;
    }
}
