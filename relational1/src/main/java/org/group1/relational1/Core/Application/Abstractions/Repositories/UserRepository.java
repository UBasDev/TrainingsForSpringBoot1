package org.group1.relational1.Core.Application.Abstractions.Repositories;

import org.group1.relational1.Core.Domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserWithScreensOfUserAndUserRoleById(Long id);
}

