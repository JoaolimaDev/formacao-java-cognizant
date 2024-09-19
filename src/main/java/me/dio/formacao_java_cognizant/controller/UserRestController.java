package me.dio.formacao_java_cognizant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.dio.formacao_java_cognizant.domain.model.User;
import me.dio.formacao_java_cognizant.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "APIs related to user management")
public class UserRestController {

    public final UserService userService;

    @Operation(summary = "Retrieve a user by ID", 
               description = "Fetches the user with the given ID from the database.",
               responses = {
                   @ApiResponse(responseCode = "200", description = "User retrieved successfully",
                       content = @Content(mediaType = "application/json",
                       schema = @Schema(implementation = User.class))),
                   @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){

        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }    

    
    @Operation(summary = "Create a new user",
    description = "Creates a new user based on the provided information.",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "UserDto containing user details", 
                               required = true,
                               content = @Content(schema = @Schema(implementation = User.class))),
    responses = {
        @ApiResponse(responseCode = "201", description = "User created successfully",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User createduser = userService.create(user);

        UriComponents location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(createduser.getId());

        return ResponseEntity.created(location.toUri()).body(createduser);
    }
    
}

