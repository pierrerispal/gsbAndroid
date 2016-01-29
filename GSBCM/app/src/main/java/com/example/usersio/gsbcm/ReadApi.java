package com.example.usersio.gsbcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.*;
import java.io.*;

import org.json.*;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

public class ReadApi extends AsyncTask<String, Void, Boolean> {

    private List<JSONObject> datas = new ArrayList<JSONObject>();
    public boolean done=false;
    //TODO: utiliser le post cf : http://stackoverflow.com/questions/4543894/android-java-http-post-request
    @Override
    protected Boolean doInBackground(String... urls) {
        try {
            InputStream is = new URL(urls[0]).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonArray = readAll(rd);
            Log.i("json",jsonArray);
            JSONArray array = new JSONArray(jsonArray);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                this.datas.add(object);
            }
            done=true;

            return true;
        } catch (JSONException e) {
            Log.i("Erreur Json", e.toString());
            return false;
        }catch (MalformedURLException e){
            Log.i("Erreur Url", e.toString());
            return false;
        }catch (IOException e){
            Log.i("Erreur IO", e.toString());
            return false;
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public List<JSONObject> getDatas() {
        return datas;
    }

    /*public Connexion connexionData() {
        Connexion connexionData = new Connexion(null,null);
        //try {
            //connexionData = new Connexion(datas.get(0).getString("login"), datas.get(0).getString("password"));
            Log.i("lithttp1",this.datas.toString());
        /*} catch (JSONException e) {
            Log.i("Erreur Json", e.toString());
        }
        return connexionData;
    }*/

}
