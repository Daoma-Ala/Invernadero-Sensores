package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.util.List;

public class InvernaderoDto implements Serializable {

    private Long id_invernadero;
    private String nombre;
    private String localizacion;
    private String descripcion;
    private List<SensorDto> sensores;
    private List<Long> ids_invernadero_contacto;

    public InvernaderoDto(String nombre, String localizacion, String descripcion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
    }

    public InvernaderoDto(Long id_invernadero, String nombre, String localizacion, String descripcion, List<Long> ids_invernadero_contacto) {
        this.id_invernadero = id_invernadero;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    public InvernaderoDto(String nombre, String localizacion, String descripcion, List<SensorDto> sensores, List<Long> ids_invernadero_contacto) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.sensores = sensores;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    public InvernaderoDto(Long id_invernadero, String nombre, String localizacion, String descripcion, List<SensorDto> sensores, List<Long> ids_invernadero_contacto) {
        this.id_invernadero = id_invernadero;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.sensores = sensores;
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    public Long getId_invernadero() {
        return id_invernadero;
    }

    public void setId_invernadero(Long id_invernadero) {
        this.id_invernadero = id_invernadero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SensorDto> getSensores() {
        return sensores;
    }

    public void setSensores(List<SensorDto> sensores) {
        this.sensores = sensores;
    }

    public List<Long> getIds_invernadero_contacto() {
        return ids_invernadero_contacto;
    }

    public void setIds_invernadero_contacto(List<Long> ids_invernadero_contacto) {
        this.ids_invernadero_contacto = ids_invernadero_contacto;
    }

    @Override
    public String toString() {
        return "InvernaderoDto{" + "id_invernadero=" + id_invernadero + ", nombre=" + nombre + ", localizacion=" + localizacion + ", descripcion=" + descripcion + ", sensores=" + sensores + ", ids_invernadero_contacto=" + ids_invernadero_contacto + '}';
    }

}
