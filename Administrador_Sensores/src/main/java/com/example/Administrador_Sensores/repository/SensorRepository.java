package com.example.Administrador_Sensores.repository;

import com.example.Administrador_Sensores.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Sensor findBySerie(String serie);
}
