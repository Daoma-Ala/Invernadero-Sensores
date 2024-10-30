package com.example.Administrador_Sensores.mapper;

import com.example.Administrador_Sensores.entity.Muestra;
import com.example.Administrador_Sensores.repository.SensorRepository;
import com.mycompany.utilities.dto.MuestraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MuestraMapper {

    @Autowired
    SensorRepository sensorRepository;

    public MuestraDto mapperToMuestraDto(Muestra muestra) {
        return new MuestraDto(
                muestra.getId_muestra(),
                muestra.getTipo(),
                muestra.getMagnitud(),
                muestra.getFechaHora(),
                muestra.getValor(),
                muestra.getSensor().getId_sensor());
    }

    public Muestra mapperToMuestra(MuestraDto muestraDto) {
        return new Muestra(
                muestraDto.getId_muestra(),
                muestraDto.getTipo(),
                muestraDto.getMagnitud(),
                muestraDto.getFechaHora(),
                muestraDto.getValor(),
                sensorRepository.findById(muestraDto.getId_sensor()).orElse(null)
        );
    }

}
