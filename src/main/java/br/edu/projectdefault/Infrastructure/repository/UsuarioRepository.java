package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
