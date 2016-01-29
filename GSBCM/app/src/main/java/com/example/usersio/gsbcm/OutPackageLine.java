package com.example.usersio.gsbcm;

import java.util.HashMap;

/**
 * Created by usersio on 03/12/2015.
 */
public class OutPackageLine {
    private double amount;
    private String label;

    OutPackageLine(){
        super();
        this.amount=3;
        this.label="test";
    }
    public HashMap<String, String> donneLine(){
        HashMap<String, String> ligne = new HashMap<String, String>();
        ligne.put("amount", String.valueOf(amount));
        ligne.put("label", label);
        return ligne;
    }
    public String getLabel(){
        return this.label;
    }
}
