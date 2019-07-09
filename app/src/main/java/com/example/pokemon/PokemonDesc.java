package com.example.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PokemonDesc extends AppCompatActivity {
    ImageView pim;
    TextView pnm,ptyp,pab,ph,pw,pdesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_desc);

        pim = findViewById(R.id.desc_imag);
        pnm = findViewById(R.id.desc_name);
        ptyp = findViewById(R.id.desc_type);
        pab = findViewById(R.id.desc_ability);
        ph = findViewById(R.id.desc_height);
        pw = findViewById(R.id.desc_weight);
        pdesc = findViewById(R.id.desc_desc);


        Intent i = getIntent();

        Pokemon p = i.getParcelableExtra("data");

        Picasso.get().load(p.getPim()).into(pim);

        pnm.setText(p.getPnm());
        ptyp.setText(p.getPtyp());
        pab.setText(p.getPab());
        ph.setText(p.getPh());
        pw.setText(p.getPw());
        pdesc.setText(p.getPdesc());
    }
}
