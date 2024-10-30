package com.mycompany.utilities.dto;

import java.io.Serializable;

public class InvernaderoContactoDto implements Serializable {

    private Long id_invernadero_contacto;
    private InvernaderoDto invernaderoDto;
    private ContactoDto contactoDto;

    public InvernaderoContactoDto() {
    }

    public InvernaderoContactoDto(InvernaderoDto invernaderoDto, ContactoDto contactoDto) {
        this.invernaderoDto = invernaderoDto;
        this.contactoDto = contactoDto;
    }

    public InvernaderoContactoDto(Long id_invernadero_contacto, InvernaderoDto invernaderoDto, ContactoDto contactoDto) {
        this.id_invernadero_contacto = id_invernadero_contacto;
        this.invernaderoDto = invernaderoDto;
        this.contactoDto = contactoDto;
    }

    public Long getId_invernadero_contacto() {
        return id_invernadero_contacto;
    }

    public void setId_invernadero_contacto(Long id_invernadero_contacto) {
        this.id_invernadero_contacto = id_invernadero_contacto;
    }

    public InvernaderoDto getInvernaderoDto() {
        return invernaderoDto;
    }

    public void setInvernaderoDto(InvernaderoDto invernaderoDto) {
        this.invernaderoDto = invernaderoDto;
    }

    public ContactoDto getContactoDto() {
        return contactoDto;
    }

    public void setContactoDto(ContactoDto contactoDto) {
        this.contactoDto = contactoDto;
    }

    @Override
    public String toString() {
        return "InvernaderoContactoDto{" + "id_invernadero_contacto=" + id_invernadero_contacto + ", invernaderoDto=" + invernaderoDto + ", contactoDto=" + contactoDto + '}';
    }

}
