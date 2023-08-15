package org.group1.relational1.Presentation.Controllers;

import org.group1.relational1.Core.Application.Abstractions.Repositories.ScreenRepository;
import org.group1.relational1.Core.Application.DTO.Screen.CreateSingleScreenDto;
import org.group1.relational1.Core.Domain.Entities.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "screens")
public class ScreenControllers {
    private final ScreenRepository screenRepository;

    @Autowired
    public ScreenControllers(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @PostMapping(path = "create-single-screen")
    public void createSingleScreen(@RequestBody CreateSingleScreenDto requestBody) {
        this.screenRepository.save(Screen.buildStart().setName(requestBody.getName()).setValue(requestBody.getValue()).setOrderValue(requestBody.getOrderValue()).buildEnd());
    }
}
