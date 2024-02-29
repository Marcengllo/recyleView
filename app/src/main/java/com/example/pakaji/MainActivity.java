package com.example.pakaji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterLIstMakanan.ItemClickListener{
    RecyclerView rvMakananFav;
    List<ModelMakananFavorit> listDataMakanan;
    AdapterLIstMakanan adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMakananFav = findViewById(R.id.rvMakananFav);
        listDataMakanan = new ArrayList<>();

        ModelMakananFavorit makanan1 = new ModelMakananFavorit();
        makanan1.setNamaMakanan("Nasi goreng");
        makanan1.setDescription("nasi di goreng");
        makanan1.setImageFood(R.drawable.sego);
        listDataMakanan.add(makanan1);

        ModelMakananFavorit makanan2 = new ModelMakananFavorit();
        makanan2.setNamaMakanan("Ayam Goreng");
        makanan2.setDescription("ayam yo di goreng");
        listDataMakanan.add(makanan2);


        // call adapter class
        rvMakananFav.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterLIstMakanan(listDataMakanan, this);
        rvMakananFav.setAdapter(adapter);
        adapter.setClickListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getNamaMakanan() + " on row number " + position, Toast.LENGTH_LONG).show();
    }
}