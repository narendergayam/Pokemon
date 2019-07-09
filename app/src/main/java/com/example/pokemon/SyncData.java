package com.example.pokemon;

import android.os.AsyncTask;

public class SyncData extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        String jurl = strings[0];

        HttpProcessor hp = new HttpProcessor();

        String json = hp.makeService(jurl);

        System.out.println("This is from Syncdata :"+json);

        return json;
    }
}
