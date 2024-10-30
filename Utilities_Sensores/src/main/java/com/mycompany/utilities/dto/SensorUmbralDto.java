package com.mycompany.utilities.dto;

import java.io.Serializable;

public class SensorUmbralDto implements Serializable {

    private Long id_sensor_umbral;
    private UmbralesDto umbralesDto;
    private Long id_sensor;

    public SensorUmbralDto() {
    }

    public SensorUmbralDto(UmbralesDto umbralesDto, Long sensorDto) {
        this.umbralesDto = umbralesDto;
        this.id_sensor = sensorDto;
    }

    public SensorUmbralDto(Long id_sensor_umbral, UmbralesDto umbralesDto, Long sensorDto) {
        this.id_sensor_umbral = id_sensor_umbral;
        this.umbralesDto = umbralesDto;
        this.id_sensor = sensorDto;
    }

    public Long getId_sensor_umbral() {
        return id_sensor_umbral;
    }

    public void setId_sensor_umbral(Long id_sensor_umbral) {
        this.id_sensor_umbral = id_sensor_umbral;
    }

    public UmbralesDto getUmbralesDto() {
        return umbralesDto;
    }

    public void setUmbralesDto(UmbralesDto umbralesDto) {
        this.umbralesDto = umbralesDto;
    }

    public Long getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(Long id_sensor) {
        this.id_sensor = id_sensor;
    }

    @Override
    public String toString() {
        return "SensorUmbralDto{" + "id_sensor_umbral=" + id_sensor_umbral + ", umbralesDto=" + umbralesDto + ", id_sensor=" + id_sensor + '}';
    }

}
