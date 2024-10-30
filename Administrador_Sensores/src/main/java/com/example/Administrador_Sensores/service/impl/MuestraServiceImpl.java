package com.example.Administrador_Sensores.service.impl;

import com.example.Administrador_Sensores.entity.Muestra;
import com.example.Administrador_Sensores.mapper.MuestraMapper;
import com.example.Administrador_Sensores.repository.MuestraRepository;
import com.mycompany.utilities.dto.MuestraDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Administrador_Sensores.service.MuestraService;

@Service
public class MuestraServiceImpl implements MuestraService {

    @Autowired
    private MuestraRepository muestraRepository;

    @Autowired
    private MuestraMapper muestraMapper;

    @Override
    public MuestraDto createMuestra(MuestraDto muestraDto) {
        Muestra muestra = muestraMapper.mapperToMuestra(muestraDto);
        muestra = muestraRepository.save(muestra);
        return muestraMapper.mapperToMuestraDto(muestra);
    }

    @Override
    public List<MuestraDto> readAllMuestra() {
        List<Muestra> muestras = muestraRepository.findAll();
        List<MuestraDto> muestrasDto = new ArrayList<>();
        for (Muestra muestra : muestras) {
            muestrasDto.add(muestraMapper.mapperToMuestraDto(muestra));
        }
        return muestrasDto;
    }

}
