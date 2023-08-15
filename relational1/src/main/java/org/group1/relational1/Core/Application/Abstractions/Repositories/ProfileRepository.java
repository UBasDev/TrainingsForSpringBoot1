package org.group1.relational1.Core.Application.Abstractions.Repositories;

import org.group1.relational1.Core.Domain.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
