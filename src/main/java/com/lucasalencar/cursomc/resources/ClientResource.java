package com.lucasalencar.cursomc.resources;

import com.lucasalencar.cursomc.domain.Client;
import com.lucasalencar.cursomc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Client obj = clientService.getClient(id);
        return ResponseEntity.ok().body(obj);

    }

}
