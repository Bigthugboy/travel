package codewiththugboy.tourist.controller;

import codewiththugboy.tourist.dto.Response.LoginResponse;
import codewiththugboy.tourist.dto.Response.RegisterResponse;
import codewiththugboy.tourist.dto.request.LoginRequest;
import codewiththugboy.tourist.dto.request.RegisterRequest;
import codewiththugboy.tourist.exceptions.DuplicateEmailException;
import codewiththugboy.tourist.services.TouristServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tourist")

public class TouristController {
    private TouristServiceImpl touristService;


    @PostMapping("/register")
    public RegisterResponse signUp(@RequestBody RegisterRequest request) throws DuplicateEmailException {
        return touristService.registerTourist(request);
    }
    @GetMapping(path = "/confirm/{token}")
    public boolean confirm(@PathVariable String token){
        System.out.println("this is the token " + token);
        return touristService.enableAppUser(token);
    }
    @GetMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return touristService.loginTourist(request);
    }

}
