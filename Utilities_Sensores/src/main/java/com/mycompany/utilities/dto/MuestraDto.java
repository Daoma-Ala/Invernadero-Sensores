package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MuestraDto implements Serializable {

    private Long id_muestra;
    private String tipo;
    private String magnitud;
    private LocalDateTime fechaHora;
    private Float valor;
    private Long id_sensor;

    public MuestraDto() {
    }

    public MuestraDto(String tipo, String magnitud, LocalDateTime fechaHora, Float valor, Long id_sensor) {
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.fechaHora = fechaHora;
        this.valor = valor;
        this.id_sensor = id_sensor;
    }

    public MuestraDto(Long id_muestra, String tipo, String magnitud, LocalDateTime fechaHora, Float valor, Long id_sensor) {
        this.id_muestra = id_muestra;
        this.tipo = tipo;
        this.magnitud = magnitud;
        this.fechaHora = fechaHora;
        this.valor = valor;
        this.id_sensor = id_sensor;
    }

    public Long getId_muestra() {
        return id_muestra;
    }

    public void setId_muestra(Long id_muestra) {
        this.id_muestra = id_muestra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    @Override
    public String toString() {
        return "MuestraDto{" + "id_muestra=" + id_muestra + ", tipo=" + tipo + ", magnitud=" + magnitud + ", fechaHora=" + fechaHora + ", valor=" + valor + ", id_sensor=" + id_sensor + '}';
    }

}
