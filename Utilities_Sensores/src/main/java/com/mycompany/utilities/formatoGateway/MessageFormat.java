/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utilities.formatoGateway;

import java.util.List;

/**
 *
 * @author Daniel
 */
@lombok.Data
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MessageFormat {

    private String serie;
    private String date;
    private List<Data> data;
    private int interval;
    private String gateway;

    public MessageFormat(String serie, String date, List<Data> data, int interval) {
        this.serie = serie;
        this.date = date;
        this.data = data;
        this.interval = interval;
    }

}
