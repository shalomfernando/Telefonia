package br.edu.projectdefault.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "Contatos")
@Data
public class ContatosEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "DDD")
    private String ddD;

}
