package org.group1.relational1.Presentation.Controllers;

import org.group1.relational1.Core.Application.Abstractions.Repositories.ProfileRepository;
import org.group1.relational1.Core.Application.Abstractions.Repositories.UserRepository;
import org.group1.relational1.Core.Application.DTO.Profile.CreateSingleProfileDto;
import org.group1.relational1.Core.Domain.Entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "profiles")
public class ProfileController {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileController(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping("create-single-profile")
    public void createSingleProfile() {
        var createSingleProfileDto = new CreateSingleProfileDto(1, "ImagePath1", "Adress1", 1);
        var userToAssign = this.userRepository.findById((long) 17);
        var profileToCreate = Profile.ProfileBuilder().setLevel(createSingleProfileDto.getLevel()).setImagePath(createSingleProfileDto.getImagePath()).setAdress(createSingleProfileDto.getAdress()).setAge(createSingleProfileDto.getAge()).buildEnd();
        profileToCreate.setUserProfile(userToAssign.get());
        this.profileRepository.save(profileToCreate);
    }
}
