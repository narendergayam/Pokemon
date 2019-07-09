package com.example.pokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pokemon> lst;
    ListView lstv;

    ListAdapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lst = new ArrayList<>();
        lstv = findViewById(R.id.lst_pokemon);

        String link = getResources().getString(R.string.link);

        try
        {
            String myjson = new SyncData().execute(link).get();

            System.out.println("MainActivity :"+myjson);

            JSONObject mainObj = new JSONObject(myjson);

            JSONArray Pokemon = mainObj.getJSONArray("Pokemon");

            for(int i=0;i<Pokemon.length();i++)
            {
                JSONObject childObj = Pokemon.getJSONObject(i);
                String name = childObj.getString("name");
                String image = childObj.getString("image");
                String type = childObj.getString("type");
                String ability = childObj.getString("ability");
                String height = childObj.getString("height");
                String weight = childObj.getString("weight");
                String desc = childObj.getString("description");


                lst.add(new Pokemon(name,image,type,ability,height,weight,desc));

            }

            System.out.println("Size of Arraylist "+lst.size());

            adapt = new ListAdapter(getApplicationContext(),lst);

            lstv.setAdapter(adapt);



            lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(MainActivity.this,PokemonDesc.class);

                    i.putExtra("data",lst.get(position));
                    startActivity(i);

                }
            });

        }catch (ExecutionException | JSONException e)
        {
            Log.e("MainActivity :",e.getMessage());
        }catch (InterruptedException e)
        {
        Log.e("MainActivity :",e.getMessage());
        }

    }
}
