package br.edu.projectdefault.Domain.Commands.TelefoneCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.TelefoneEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TelefoniaTO {

    private long id;
    private String Numero;
    private String DD;

    public TelefoniaTO (TelefoneEntity entity){
        id = entity.getId();
        Numero = entity.getNumero();
        DD = entity.getDD();
    }

    public static List<TelefoniaTO> converter(List<TelefoneEntity> telefoneEntityList) {

        return telefoneEntityList.stream().map(TelefoniaTO::new).collect(Collectors.toList());
    }
}
