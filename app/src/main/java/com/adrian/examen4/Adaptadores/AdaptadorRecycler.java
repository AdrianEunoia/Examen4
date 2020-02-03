package com.adrian.examen4.Adaptadores;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.adrian.examen4.R;
import com.adrian.examen4.Utiles.Luchador;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdapterPropio> {

    private Context context;
    private ArrayList<Luchador> listaPersonas;
    private OnRecyclerListener listener;

    public AdaptadorRecycler(Context context, ArrayList<Luchador> personas) {
        this.context = context;
        this.listaPersonas = personas;
        try{
            listener = (OnRecyclerListener) context;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public HolderAdapterPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent, false);
        return new HolderAdapterPropio(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull HolderAdapterPropio holder, final int position) {
        final Luchador personaActual = listaPersonas.get(position);
        holder.getImagen().setImageResource(personaActual.getImagen());
        holder.getNombre().setText(personaActual.getNombre());
        holder.getBoton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPersonaSelected(personaActual);
            }
        });
        holder.getCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPersonaSelected(personaActual);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    class HolderAdapterPropio extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre;
        private CardView card;

        public CardView getCard() {
            return card;
        }

        public void setCard(CardView card) {
            this.card = card;
        }

        public Button getBoton() {
            return boton;
        }

        public void setBoton(Button boton) {
            this.boton = boton;
        }

        private Button boton;

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public HolderAdapterPropio(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.idImagen);
            nombre = itemView.findViewById(R.id.idNombre);
            boton = itemView.findViewById(R.id.idCheck);
        }
    }

    public interface OnRecyclerListener{
        void onPersonaSelected(Luchador persona);
    }
}

