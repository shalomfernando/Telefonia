package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.ContatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository<ContatosEntity, Long> {


}
