package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.TelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoniaRepository extends JpaRepository< TelefoneEntity,Long> {

}
