package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioTO {

    private Long id;
    private String name;
    private String username;

    public UsuarioTO(UsuarioEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.username = entity.getUsername();
    }

    public static List<UsuarioTO> converter(List<UsuarioEntity> users) {

        return users.stream().map(UsuarioTO::new).collect(Collectors.toList());
    }
}
