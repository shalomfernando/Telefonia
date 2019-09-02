package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Entity.Tel_dddEntity;
import br.edu.projectdefault.Domain.Entity.TelefoneEntity;
import br.edu.projectdefault.Infrastructure.repository.Tel_dddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class Tel_dddHandler {

    @Autowired
    private Tel_dddRepository _repository;

     Boolean existeTelefone(TelefoneEntity entity){
        return  _repository.findByDdd(entity.getDD()) != null ;
    }

    Tel_dddEntity Handler(TelefoneEntity entity){
        if (entity.getNumero().length() == 15 ){ entity.setDD("0"+entity.getDD());}
        String dd = entity.getDD();

        Tel_dddEntity tel_dddEntity = new Tel_dddEntity();
        List<Tel_dddEntity> tel_dddEntity1 = _repository.findAll();
        for (Tel_dddEntity dddEntity : tel_dddEntity1) {
            if (dddEntity.getDdd().equals(dd)) {
                tel_dddEntity = dddEntity;
            }
        }
        return tel_dddEntity ;
    }
}
