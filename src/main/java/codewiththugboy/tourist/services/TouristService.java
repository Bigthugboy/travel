package codewiththugboy.tourist.services;

import codewiththugboy.tourist.dto.Response.LoginResponse;
import codewiththugboy.tourist.dto.Response.RegisterResponse;
import codewiththugboy.tourist.dto.request.LoginRequest;
import codewiththugboy.tourist.dto.request.RegisterRequest;
import codewiththugboy.tourist.exceptions.DuplicateEmailException;

public interface TouristService {
    RegisterResponse registerTourist(RegisterRequest request) throws DuplicateEmailException;
    LoginResponse loginTourist (LoginRequest request);

}
