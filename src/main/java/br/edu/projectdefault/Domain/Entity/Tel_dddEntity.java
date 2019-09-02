package br.edu.projectdefault.Domain.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "TEL_DDD")
public class Tel_dddEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id ;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "REGIAO")
    private String regiao;
    @Column(name = "DDD")
    private String ddd;


}
