package com.gabriel.finalexercise.DTOs;

import com.gabriel.finalexercise.Models.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private Integer children;

    public ClientDTO(Long id, String name, String cpf, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.children = children;
    }

    public ClientDTO() {
    }

    public ClientDTO(Client listaDTO) {
        this.id = listaDTO.getId();
        this.name = listaDTO.getName();
        this.cpf = listaDTO.getCpf();
        this.children = listaDTO.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
