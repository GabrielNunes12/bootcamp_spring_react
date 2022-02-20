package com.gabriel.finalexercise.Services;

import com.gabriel.finalexercise.DTOs.ClientDTO;
import com.gabriel.finalexercise.Models.Client;
import com.gabriel.finalexercise.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged (PageRequest pageRequest) {
        Page<Client> listDto = clientRepository.findAll(pageRequest);
        return listDto.map((listaDTO) -> new ClientDTO(listaDTO));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id) {
        Optional<Client> list = clientRepository.findById(id);
        Client client = list.orElseThrow(() -> new ExceptionHandler("Id not found"));
        return new ClientDTO(client);
    }
}
