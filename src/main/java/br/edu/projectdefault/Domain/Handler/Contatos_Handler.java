package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.ContatosCommand.Outputs.ContatoTO;
import br.edu.projectdefault.Infrastructure.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Contatos_Handler {

    private final  ContatosRepository _repository;

    @Autowired
    public Contatos_Handler(ContatosRepository repository) {
        this._repository = repository;
    }
    public List<ContatoTO> handler(){
        return ContatoTO.connverter(_repository.findAll());
    }

}
