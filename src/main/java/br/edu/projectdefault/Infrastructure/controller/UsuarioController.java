package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.AtualizaUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.SalvarUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs.UsuarioTO;
import br.edu.projectdefault.Domain.Handler.UsuarioHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/Usuario")
public class UsuarioController {

    private final UsuarioHandler _handler;

    @Autowired
    public UsuarioController(UsuarioHandler handler) {
        _handler = handler;
    }

    @GetMapping
    public List<UsuarioTO> Get() {
        return _handler.Handler();
    }

    @PostMapping
    public ResponseEntity<UsuarioTO> Post(@RequestBody SalvarUsuarioCommand command, UriComponentsBuilder builder) {
        return _handler.Handler(command,builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioTO> Put(@PathVariable Long id, @RequestBody AtualizaUsuarioCommand command) {
        return _handler.Handler(id,command);
    }
}
