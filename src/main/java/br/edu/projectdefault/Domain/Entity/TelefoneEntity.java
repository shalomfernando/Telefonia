package br.edu.projectdefault.Domain.Entity;

import br.edu.projectdefault.Domain.Commands.TelefoneCommand.Inputs.SalvarTelefoneCommand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@Entity(name = "TEL_GT")
public class TelefoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numero;
    private String DD;
    private Calendar horario;

    //@Column(name = "TEL_ID")
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Tel_dddEntity tel_dddEntity;


    public TelefoneEntity(long id, String numero, String DD, Calendar horario) {
        this.id = id;
        this.numero = numero;
        this.DD = DD;
        this.horario = horario;
    }

    public TelefoneEntity(SalvarTelefoneCommand command) {
        this.numero = command.getNumero();
        this.DD = command.getNumero().length() == 10 ? getNumero().substring(0,2):
                command.getNumero().length() == 15 ? getNumero().substring(6,7): "**";
        this.horario = Calendar.getInstance();
    }

}
