package com.adrian.examen4.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adrian.examen4.Adaptadores.AdaptadorRecycler;
import com.adrian.examen4.R;
import com.adrian.examen4.Utiles.Luchador;

import java.util.ArrayList;

public class FragmentLista extends Fragment {
    private RecyclerView recyclerView;
    private AdaptadorRecycler adatadorRecycler;
    private ArrayList<Luchador> luchadores;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        luchadores = new ArrayList();
        luchadores.add(new Luchador("BLANKA","ELECTRICIDAD", "BRASIL", R.drawable.blanka));
        luchadores.add(new Luchador("CHUNLI","TAICHI", "JAPON", R.drawable.chunli));
        luchadores.add(new Luchador("DALSIM","YOGA", "INDIA", R.drawable.dalsim));
        luchadores.add(new Luchador("GUILE","FUERZA", "EEUU", R.drawable.guile));
        luchadores.add(new Luchador("HONDA","SUMO", "JAPON", R.drawable.honda));
        luchadores.add(new Luchador("KEN","ANSATSUKEN", "JAPON", R.drawable.ken));
        luchadores.add(new Luchador("RYU","ANSATSUKEN", "JAPON", R.drawable.ryu));
        luchadores.add(new Luchador("VEGA","NINJUTSU", "JAPON", R.drawable.vega));
        luchadores.add(new Luchador("VISION","PSYCHO", "???", R.drawable.vision));
        luchadores.add(new Luchador("ZANG","LUCHA LIBRE", "URS", R.drawable.zang));
        adatadorRecycler = new AdaptadorRecycler(context, luchadores);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setAdapter(adatadorRecycler);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uno_layout, container, false);
        recyclerView = view.findViewById(R.id.idRecycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, RecyclerView.VERTICAL, false));
        return view;
    }
}
