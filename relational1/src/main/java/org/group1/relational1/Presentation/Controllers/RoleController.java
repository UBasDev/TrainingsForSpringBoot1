package org.group1.relational1.Presentation.Controllers;

import org.group1.relational1.Core.Application.Abstractions.Repositories.RoleRepository;
import org.group1.relational1.Core.Application.Abstractions.Repositories.UserRepository;
import org.group1.relational1.Core.Application.DTO.Role.CreateSingleRoleDto;
import org.group1.relational1.Core.Domain.Entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "roles")
public class RoleController {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping("create-single-role")
    public void createSingleRole(@RequestBody CreateSingleRoleDto requestBody) {
        this.roleRepository.save(Role.buildStart().setName("Role1").setCode(1).setValue("Role1").buildEnd());
    }
}
