package com.example.Administrador_Sensores.controller;

import com.example.Administrador_Sensores.facade.IFacade;
import com.mycompany.utilities.dto.SensorDto;
import com.mycompany.utilities.exchange.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("api/sensor")
public class SensorController {

    private IFacade facade;

    @Autowired
    public SensorController(IFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/readSensors")
    public ResponseFormat readAllSensors() {
        return facade.readAllSensores();
    }

    @PostMapping("/createSensor")
    public ResponseFormat createSensor(@RequestBody SensorDto sensorDto) {
        return facade.createSensor(sensorDto);
    }

}
