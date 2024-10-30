package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AlarmaDto implements Serializable {

    private Long id_alarma;
    private TipoAlarmaEnum tipoAlarmaEnum;
    private LocalDateTime fechaHora;
    private Float valor_excedido;
    private Long id_sensor;

    public AlarmaDto() {
    }

    public AlarmaDto(TipoAlarmaEnum tipoAlarmaEnum, LocalDateTime fechaHora, Float valor_excedido) {
        this.tipoAlarmaEnum = tipoAlarmaEnum;
        this.fechaHora = fechaHora;
        this.valor_excedido = valor_excedido;
    }

    public AlarmaDto(Long id_alarma, TipoAlarmaEnum tipoAlarmaEnum,
            LocalDateTime fechaHora, Float valor_excedido, Long id_sensor) {
        this.id_alarma = id_alarma;
        this.tipoAlarmaEnum = tipoAlarmaEnum;
        this.fechaHora = fechaHora;
        this.valor_excedido = valor_excedido;
        this.id_sensor = id_sensor;
    }

    public Long getId_alarma() {
        return id_alarma;
    }

    public void setId_alarma(Long id_alarma) {
        this.id_alarma = id_alarma;
    }

    public TipoAlarmaEnum getTipoAlarmaEnum() {
        return tipoAlarmaEnum;
    }

    public void setTipoAlarmaEnum(TipoAlarmaEnum tipoAlarmaEnum) {
        this.tipoAlarmaEnum = tipoAlarmaEnum;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Float getValor_excedido() {
        return valor_excedido;
    }

    public void setValor_excedido(Float valor_excedido) {
        this.valor_excedido = valor_excedido;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    @Override
    public String toString() {
        return "AlarmaDto{" + "id_alarma=" + id_alarma + ", tipoAlarmaEnum=" + tipoAlarmaEnum + ", fechaHora=" + fechaHora + ", valor_excedido=" + valor_excedido + ", id_sensor=" + id_sensor + '}';
    }

}
