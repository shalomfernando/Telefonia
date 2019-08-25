package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalvarUsuarioCommand {

    private String name;
    private String username;
    private String password;
}
