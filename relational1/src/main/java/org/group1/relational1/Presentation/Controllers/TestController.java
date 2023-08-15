package org.group1.relational1.Presentation.Controllers;

import jakarta.validation.Valid;
import org.group1.relational1.Core.Application.Abstractions.Repositories.UserRepository;
import org.group1.relational1.Core.Application.DTO.Test.ValidationTestDto;
import org.group1.relational1.Core.Application.Enums.ColorEnum;
import org.group1.relational1.Core.Application.Enums.ExamStatus;
import org.group1.relational1.Core.Application.Helpers.ArrayHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "test")
public class TestController {

    private final UserRepository userRepository;


    @Autowired
    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostMapping()
    public ResponseEntity<String> test1(@RequestBody @Valid ValidationTestDto requestBody) {
        var x1 = requestBody;
        var choosenColor1 = ColorEnum.BLUE;
        return new ResponseEntity<String>(choosenColor1.getHexCode(), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleInvalidArguments1(MethodArgumentNotValidException ex) {
        var array1 = new String[]{};

        for (var error : ex.getBindingResult().getFieldErrors()) {
            array1 = ArrayHelpers.addItemAndReturnNewArray(array1, error.getField());
            array1 = ArrayHelpers.addItemAndReturnNewArray(array1, error.getDefaultMessage());
        }
        return ResponseEntity.status(ex.getStatusCode()).body(array1);
    }
}
