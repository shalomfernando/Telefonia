package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.TelefoneCommand.Inputs.SalvarTelefoneCommand;
import br.edu.projectdefault.Domain.Commands.ValidaCommand.Outputs.Tel_dddTO;
import br.edu.projectdefault.Domain.Handler.Tel_dddHandler;
import br.edu.projectdefault.Domain.Handler.TelefoniaHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/Telefone")
@RestController
public class TelefoniaController {

    final
    TelefoniaHandler _handler;


    final
    Tel_dddHandler _handlerTel;

    public TelefoniaController(TelefoniaHandler _handler, Tel_dddHandler _handlerTel) {
        this._handler = _handler;
        this._handlerTel = _handlerTel;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView telefonia(Tel_dddTO dddTO, String message) {
        ModelAndView modelAndView = new ModelAndView("telefone");
        if (dddTO != null) {
            modelAndView.addObject("dddTO", dddTO);
        }
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView Post(SalvarTelefoneCommand telefoneCommand) {
        String message = null;
        Tel_dddTO dddTO = null;
        if (!_handler.verificadorNumero(telefoneCommand)) {
            message = "Numero invalido";
        } else {
            message = "Numero OK,";
            //Vai devolver a regiao do número
            dddTO = _handler.Handler(telefoneCommand);

            if (telefoneCommand.getNumero().length() == 15) {
                message = message + " Chamada Internacional";
            } else {
                message = message + " Chamada local";
            }

        }
        return telefonia(dddTO, message);
    }

    @GetMapping("/getDDD")
    public List<Tel_dddTO> Get() {
        return _handlerTel.Handler();
    }

}
