package br.edu.projectdefault.Domain.Commands.TelefoneCommand.Inputs;

import br.edu.projectdefault.Infrastructure.repository.TelefoniaRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class SalvarTelefoneCommand {

    private String Numero;
}
