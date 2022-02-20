package com.gabriel.finalexercise.Services;

import com.gabriel.finalexercise.DTOs.ClientDTO;
import com.gabriel.finalexercise.Models.Client;
import com.gabriel.finalexercise.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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

    @Transactional
    public ClientDTO insertClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setCpf(clientDTO.getCpf());
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepository.getOne(id);
            client.setName(clientDTO.getName());
            client.setChildren(clientDTO.getChildren());
            client.setCpf(clientDTO.getCpf());
            client.setIncome(clientDTO.getIncome());
            client.setBirthDate(clientDTO.getBirthDate());
            return new ClientDTO(client);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ExceptionHandler("Id not found" + entityNotFoundException);
        }
    }

    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ExceptionHandler("Id not found" + exception);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new ExceptionHandler("Client not found" + dataIntegrityViolationException);
        }
    }

}
