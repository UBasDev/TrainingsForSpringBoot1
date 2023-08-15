package org.group1.relational1.Core.Application.Abstractions.Repositories;

import org.group1.relational1.Core.Domain.Entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
