/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utilities.formatGateway;

/**
 *
 * @author daniel
 */
public class Data {

    private String type;
    private String magnitude;
    private float value;

    public Data() {
    }

    public Data(String type, String magnitude, float value) {
        this.type = type;
        this.magnitude = magnitude;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" + "type=" + type + ", magnitude=" + magnitude + ", value=" + value + '}';
    }

}
