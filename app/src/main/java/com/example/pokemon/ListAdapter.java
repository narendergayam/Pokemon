package com.example.pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context c;
    ArrayList<Pokemon> prols;

    LayoutInflater inflater;

    public ListAdapter(Context c, ArrayList<Pokemon> prols) {
        this.c = c;
        this.prols = prols;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.pokemon_list,parent,false);
        }


        ImageView img = convertView.findViewById(R.id.img_pokemon);
        TextView txtnm = convertView.findViewById(R.id.txt_pokemon);

        txtnm.setText(prols.get(position).getPnm());
        Picasso.get().load(prols.get(position).getPim()).into(img);



        return convertView;
    }
}
