package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import br.edu.projectdefault.Infrastructure.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AtualizaUsuarioCommand {

    private String name;
    private String username;
    private String password;

    public UsuarioEntity Update(Long id, UsuarioRepository _repository) {
        UsuarioEntity entity = _repository.getOne(id);

        entity.setName(this.name);
        entity.setUsername(this.username);
        entity.setPassword(this.password);

        return entity;
    }
}
