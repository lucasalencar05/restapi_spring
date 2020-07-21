package com.lucasalencar.cursomc.services;

import com.lucasalencar.cursomc.domain.Client;
import com.lucasalencar.cursomc.exceptions.ObjectNotFoundException;
import com.lucasalencar.cursomc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client getClient(Integer id){

        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "+ Client.class.getName()));

    }

}
