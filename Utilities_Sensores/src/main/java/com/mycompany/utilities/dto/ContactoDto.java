package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.util.List;

public class ContactoDto implements Serializable {

    private Long id_conacto;
    private String nombre;
    private String numero_telefonico;
    private String email;
    private List<Long> ids_invernadero_contacto;

    public ContactoDto() {
    }

    public ContactoDto(String nombre, String numero_telefonico, String email) {
        this.nombre = nombre;
        this.numero_telefonico = numero_telefonico;
        this.email = email;
    }

    public ContactoDto(String nombre, String numero_telefonico, String email, List<Long> ids_invernadero_contacto) {
        this.nombre = nombre;
        this.numero_telefonico = numero_telefonico;
        this.email = email;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    public ContactoDto(Long id_conacto, String nombre, String numero_telefonico, String email, List<Long> ids_invernadero_contacto) {
        this.id_conacto = id_conacto;
        this.nombre = nombre;
        this.numero_telefonico = numero_telefonico;
        this.email = email;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    public Long getId_conacto() {
        return id_conacto;
    }

    public void setId_conacto(Long id_conacto) {
        this.id_conacto = id_conacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getIds_invernadero_contacto() {
        return ids_invernadero_contacto;
    }

    public void setIds_invernadero_contacto(List<Long> ids_invernadero_contacto) {
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    @Override
    public String toString() {
        return "ContactoDto{" + "id_conacto=" + id_conacto + ", nombre=" + nombre + ", numero_telefonico=" + numero_telefonico + ", email=" + email + ", ids_invernadero_contacto=" + ids_invernadero_contacto + '}';
    }

}
