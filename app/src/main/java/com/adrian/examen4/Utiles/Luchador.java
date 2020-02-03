package com.adrian.examen4.Utiles;

public class Luchador {
    String nombre, cualidad, pais;
    int imagen;

    public Luchador(String nombre, String cualidad, String pais, int imagen) {
        this.nombre = nombre;
        this.cualidad = cualidad;
        this.pais = pais;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCualidad() {
        return cualidad;
    }

    @Override
    public String toString() {
        return "Luchador{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public void setCualidad(String cualidad) {
        this.cualidad = cualidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
