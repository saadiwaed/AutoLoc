package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class ClientService implements IClientService {

    private final ClientRepository client1Repository;


    @Override
    public List<Client> retrieveAllClients() {
        return client1Repository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return client1Repository.save(c);

    }

    @Override
    public Client updateClient(Client c) {
        return client1Repository.save(c);

    }

    @Override
    public Client retrieveClient(Long idClient) {
        return client1Repository.findById(idClient).orElse(null);

    }

    @Override
    public void removeClient(Long idClient) {
         client1Repository.deleteById(idClient);



    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return client1Repository.saveAll(clients);

    }
}
