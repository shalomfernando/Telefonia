package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.TelefoneCommand.Inputs.SalvarTelefoneCommand;
import br.edu.projectdefault.Domain.Commands.ValidaCommand.Outputs.Tel_dddTO;
import br.edu.projectdefault.Domain.Handler.TelefoniaHandler;
import br.edu.projectdefault.Domain.Handler.Tel_dddHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/Telefone")
@RestController
public class TelefoniaController {

    @Autowired
    TelefoniaHandler _handler;


    @Autowired
    Tel_dddHandler teldddHandler;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView telefonia(Tel_dddTO dddTO, String message){
        ModelAndView modelAndView =  new ModelAndView("telefone");
        if (dddTO != null) {
            modelAndView.addObject("dddTO", dddTO);
        }
        modelAndView.addObject("message",message);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView Post(SalvarTelefoneCommand telefoneCommand) {
        String message = null;
        Tel_dddTO dddTO = null;
        if (!_handler.verificadorNumero(telefoneCommand)){
            message =  "Numero invalido";
        }
        else {
            message = "Numero OK,";
            //Vai devolver a regiao do número
            dddTO = _handler.Handler(telefoneCommand);

            if (telefoneCommand.getNumero().length() == 15){
                message = message + " Chamada Internacional";
            }
            else{
                message = message + " Chamada local";
            }

        }
        return  telefonia(dddTO, message);
    }
}
