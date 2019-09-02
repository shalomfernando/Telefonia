package br.edu.projectdefault.Domain.Commands.ValidaCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.Tel_dddEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Tel_dddTO {

    private long id ;
    private String descricao;
    private String regiao;
    private String ddd;

    public Tel_dddTO(Tel_dddEntity dddEntity){
        id = dddEntity.getId();
        descricao = dddEntity.getDescricao();
        regiao = dddEntity.getRegiao();
        ddd = dddEntity.getDdd();
    }

    public Tel_dddTO() {
    }

    public static List<Tel_dddTO> converte(List<Tel_dddEntity> validaDDEntity){
        return validaDDEntity.stream().map(Tel_dddTO::new).collect(Collectors.toList());
    }

}
