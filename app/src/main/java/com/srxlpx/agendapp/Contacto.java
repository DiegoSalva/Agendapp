package com.srxlpx.agendapp;

/**
 * Created by Ed on 20/05/2016.
 */
public class Contacto {
    private String nombre;
    private String fechaNAcimiento;
    private String telefono;
    private String email;
    private String descripcionContacto;

    public Contacto(String nombre, String fechaNAcimiento, String telefono, String email, String descripcionContacto) {
        this.nombre = nombre;
        this.fechaNAcimiento = fechaNAcimiento;
        this.telefono = telefono;
        this.email = email;
        this.descripcionContacto = descripcionContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNAcimiento() {
        return fechaNAcimiento;
    }

    public void setFechaNAcimiento(String fechaNAcimiento) {
        this.fechaNAcimiento = fechaNAcimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcionContacto() {
        return descripcionContacto;
    }

    public void setDescripcionContacto(String descripcionContacto) {
        this.descripcionContacto = descripcionContacto;
    }
}
