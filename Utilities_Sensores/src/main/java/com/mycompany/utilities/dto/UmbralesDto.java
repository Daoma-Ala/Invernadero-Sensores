package com.mycompany.utilities.dto;

import java.io.Serializable;
import java.util.List;

public class UmbralesDto implements Serializable {

    private Long id_umbral;
    private CondicionEnum condicionEnum;
    private Float max;
    private Float min;
    private List<Long> ids_sensor_umbral;

    public UmbralesDto() {
    }

    public UmbralesDto(CondicionEnum condicionEnum, Float max, Float min) {
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
    }

    public UmbralesDto(CondicionEnum condicionEnum, Float max, Float min, List<Long> ids_sensor_umbral) {
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    public UmbralesDto(Long id_umbral, CondicionEnum condicionEnum, Float max, Float min, List<Long> ids_sensor_umbral) {
        this.id_umbral = id_umbral;
        this.condicionEnum = condicionEnum;
        this.max = max;
        this.min = min;
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    public Long getId_umbral() {
        return id_umbral;
    }

    public void setId_umbral(Long id_umbral) {
        this.id_umbral = id_umbral;
    }

    public CondicionEnum getCondicionEnum() {
        return condicionEnum;
    }

    public void setCondicionEnum(CondicionEnum condicionEnum) {
        this.condicionEnum = condicionEnum;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public List<Long> getIds_sensor_umbral() {
        return ids_sensor_umbral;
    }

    public void setIds_sensor_umbral(List<Long> ids_sensor_umbral) {
        this.ids_sensor_umbral = ids_sensor_umbral;
    }

    @Override
    public String toString() {
        return "UmbralesDto{" + "id_umbral=" + id_umbral + ", condicionEnum=" + condicionEnum + ", max=" + max + ", min=" + min + ", ids_sensor_umbral=" + ids_sensor_umbral + '}';
    }

}
