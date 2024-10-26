/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utilities.formatGateway;

import java.util.List;

/**
 *
 * @author daniel
 */
public class MessageFormat {

    private String serie;
    private String date;
    private List<Data> data;
    private int interval;
    private String gateway;

    public MessageFormat() {
    }

    public MessageFormat(String serie, String date, List<Data> data, int interval) {
        this.serie = serie;
        this.date = date;
        this.data = data;
        this.interval = interval;
    }

    public MessageFormat(String serie, String date, List<Data> data, int interval, String gateway) {
        this.serie = serie;
        this.date = date;
        this.data = data;
        this.interval = interval;
        this.gateway = gateway;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @Override
    public String toString() {
        return "MessageFormat{" + "serie=" + serie + ", date=" + date + ", data=" + data + ", interval=" + interval + ", gateway=" + gateway + '}';
    }

}
