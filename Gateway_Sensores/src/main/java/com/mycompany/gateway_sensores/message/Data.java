/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gateway_sensores.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author daniel
 */
@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String type;
    private String magnitude;
    private float value;

}
