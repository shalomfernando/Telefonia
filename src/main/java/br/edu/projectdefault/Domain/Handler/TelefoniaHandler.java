package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.TelefoneCommand.Inputs.SalvarTelefoneCommand;
import br.edu.projectdefault.Domain.Commands.ValidaCommand.Outputs.Tel_dddTO;
import br.edu.projectdefault.Domain.Entity.Tel_dddEntity;
import br.edu.projectdefault.Domain.Entity.TelefoneEntity;
import br.edu.projectdefault.Infrastructure.repository.TelefoniaRepository;
import br.edu.projectdefault.Infrastructure.repository.Tel_dddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoniaHandler {

    private TelefoniaRepository _repository;
    @Autowired
    private Tel_dddRepository _Tel_dddrepository;

    @Autowired
    Tel_dddHandler tel_dddHandler = new Tel_dddHandler();

    @Autowired
    TelefoniaHandler (TelefoniaRepository repository){

        _repository = repository;
    }

    public Tel_dddTO Handler(SalvarTelefoneCommand telefoneCommand){

        TelefoneEntity entity = new TelefoneEntity(telefoneCommand);

        Tel_dddEntity tel_dddEntity = tel_dddHandler.Handler(entity);
        Tel_dddTO dddTO = new Tel_dddTO(tel_dddEntity);
        entity.setTel_dddEntity(tel_dddEntity);
        _repository.save(entity);

        return dddTO ;
    }

    public boolean verificadorNumero(SalvarTelefoneCommand telefoneCommand){

        TelefoneEntity entity = new TelefoneEntity(telefoneCommand);
        if (telefoneCommand.getNumero().isEmpty()){
            return false;
        }
        if (telefoneCommand.getNumero().length() == 10 ){
              return tel_dddHandler.existeTelefone(entity);
        }
        if ( telefoneCommand.getNumero().length() == 15){

            if (telefoneCommand.getNumero().substring(0,2).equals("00")){
                if (telefoneCommand.getNumero().substring(2,4).equals("15")||
                        telefoneCommand.getNumero().substring(2,4).equals("21")){

                    entity.setDD("0"+entity.getDD());
                    return tel_dddHandler.existeTelefone(entity);
                }
                return false;
            }
        }else{
            return false;
        }

        return true;
    }
}
