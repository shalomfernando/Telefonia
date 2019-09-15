package br.edu.projectdefault.Domain.Commands.ContatosCommand.Outputs;
import br.edu.projectdefault.Domain.Entity.ContatosEntity;
import lombok.Data;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ContatoTO {

    private String nome;
    private String numero;
    private String ddd;

    public ContatoTO (ContatosEntity contatosEntity){
        this.nome = contatosEntity.getNome();
        this.numero = contatosEntity.getNumero();
        this.ddd = contatosEntity.getDdD();
    }

    public static List<ContatoTO> connverter(List<ContatosEntity> entities){
        return entities.stream().map(ContatoTO::new).collect(Collectors.toList());
    }
}
