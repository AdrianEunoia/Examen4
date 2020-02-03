package com.adrian.examen4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.adrian.examen4.Adaptadores.AdaptadorRecycler;
import com.adrian.examen4.Fragments.FragmentLista;
import com.adrian.examen4.Fragments.FragmentLucha;
import com.adrian.examen4.Utiles.Luchador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerListener {
    // Elementos
    private FragmentTransaction ft;
    Toolbar idToolbar;
    ArrayList<Luchador> listaAlumnos = new ArrayList<Luchador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insancias();
        ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.idEspacioFragments, new FragmentLista());
        ft.commit();
    }
    // Instancias
    private void insancias() {
        idToolbar = findViewById(R.id.idToolbar);
        // Para que identifica la toolbar como la barra de soporte
        setSupportActionBar(idToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getApplicationContext());
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idMenu:
                int contadorLuchadores = 0;
                if (!listaAlumnos.isEmpty()) {
                    for (Luchador a : listaAlumnos) {
                        contadorLuchadores++;
                    }
                }
                if (contadorLuchadores==2){
                    Toast.makeText(this, "Listo para luchar", Toast.LENGTH_SHORT).show();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.replace(R.id.idEspacioFragments, new FragmentLucha());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else{
                    Toast.makeText(this, "No pueden luchar mas de 2 jugadores o únicamente 1", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }

    @Override
    public void onPersonaSelected(Luchador persona) {
        String nombre = persona.getNombre();
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
        if(!listaAlumnos.contains(persona)){
            listaAlumnos.add(persona);
        }else if(listaAlumnos.contains(persona)){
            listaAlumnos.remove(persona);
        }
    }
}
