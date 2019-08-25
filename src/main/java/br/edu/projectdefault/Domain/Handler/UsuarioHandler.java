package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.AtualizaUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.SalvarUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs.UsuarioTO;
import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import br.edu.projectdefault.Infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class UsuarioHandler {

    private final UsuarioRepository _respository;

    @Autowired
    public UsuarioHandler(UsuarioRepository respository) {
        _respository = respository;
    }

    //Busca todos
    public List<UsuarioTO> Handler()
    {
        List<UsuarioEntity> users = _respository.findAll();
        return UsuarioTO.converter(users);
    }

    //Salva novo usuario
    public ResponseEntity<UsuarioTO> Handler(SalvarUsuarioCommand command, UriComponentsBuilder builder)
    {
        UsuarioEntity entity = new UsuarioEntity(command);
        _respository.save(entity);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioTO(entity));
    }

    //Atualiza registro de usuario
    public ResponseEntity<UsuarioTO> Handler(Long id, AtualizaUsuarioCommand command)
    {
        UsuarioEntity entity = command.Update(id, _respository);
        return ResponseEntity.ok(new UsuarioTO(entity));
    }

}
