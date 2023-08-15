package org.group1.relational1.Core.Application.Abstractions.Repositories;

import org.group1.relational1.Core.Domain.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
