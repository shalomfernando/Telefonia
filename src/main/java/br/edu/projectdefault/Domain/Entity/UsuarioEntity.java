package br.edu.projectdefault.Domain.Entity;

import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.SalvarUsuarioCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "USUARIO")
@NoArgsConstructor
public class UsuarioEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public UsuarioEntity(SalvarUsuarioCommand command) {
        this.name = command.getName();
        this.username = command.getUsername();
        this.password = command.getPassword();
    }



}
