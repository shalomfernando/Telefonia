package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.ContatosCommand.Outputs.ContatoTO;
import br.edu.projectdefault.Domain.Handler.Contatos_Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Contatos")
public class ContatosController {


    private Contatos_Handler _handler;

    public ContatosController( Contatos_Handler _handler){
       this._handler = _handler;
    }


    @GetMapping("/get")
    public List<ContatoTO> get(){
        return  _handler.handler();
    }
}
