package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.Tel_dddEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tel_dddRepository extends JpaRepository<Tel_dddEntity, Long> {

    public Tel_dddEntity findByDdd(String s);
}
