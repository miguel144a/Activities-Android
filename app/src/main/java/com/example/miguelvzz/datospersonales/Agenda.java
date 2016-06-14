package com.example.miguelvzz.datospersonales;

/**
 * Created by Miguel Vzz on 13/06/2016.
 */
public class Agenda {
    private String nombre;
    private String fec_nac;
    private String telefono;
    private String email;
    private String descrip;

    public Agenda(String nombre, String fec_nac, String telefono, String email, String descrip) {
        this.nombre = nombre;
        this.fec_nac = fec_nac;
        this.telefono = telefono;
        this.email = email;
        this.descrip = descrip;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFec_nac(String fec_nac) {
        this.fec_nac = fec_nac;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFec_nac() {
        return fec_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDescrip() {
        return descrip;
    }
}
