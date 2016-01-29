package com.example.usersio.gsbcm;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by usersio on 03/12/2015.
 */
public class ConnectionApi {

    public CostSheet getCostSheetNow() {
        CostSheet c = new CostSheet();
        c.addOutPackageLine(new OutPackageLine());
        return c;
    }

    public String getToken(String login, String mdp) {
        ReadApi readApi = new ReadApi();
        try {
            if (readApi.execute("http://172.21.4.65/gsb_general/ppe_gsb_API_cost_managment/auth/pierre/pierre").get()) {
                Log.i("lecture",readApi.getDatas().get(0).getString("token"));
                return readApi.getDatas().get(0).getString("token");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //json = jsonR.readJsonFromUrl("http://172.21.4.65/gsb_general/ppe_gsb_API_cost_managment/auth/visiteur/test");
            //json = jsonR.doInBackground("http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?");
            //Log.i("json",json.toString());
            //System.out.println(json.get("id"));
        return null;
    }
}
