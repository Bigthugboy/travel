package codewiththugboy.tourist.services;

import codewiththugboy.tourist.data.model.Token;
import codewiththugboy.tourist.data.model.Tourist;
import codewiththugboy.tourist.data.repository.TouristRepository;
import codewiththugboy.tourist.dto.Response.LoginResponse;
import codewiththugboy.tourist.dto.Response.RegisterResponse;
import codewiththugboy.tourist.dto.request.LoginRequest;
import codewiththugboy.tourist.dto.request.RegisterRequest;
import codewiththugboy.tourist.exceptions.DuplicateEmailException;

import codewiththugboy.tourist.token.ConfirmationTokenImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TouristServiceImpl implements TouristService{
    private TouristRepository repository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenImpl confirmationTokenImpl;

    @Override
    public RegisterResponse registerTourist(RegisterRequest request) throws DuplicateEmailException {
        if (findByEmail(request.getEmail())) {
            throw new DuplicateEmailException("ACCOUNT ALREADY EXISTED", HttpStatus.BAD_REQUEST);

        }
        if (Objects.equals(request.getPassword(), request.getCheckPassword())) {
            Tourist tourist;
            ModelMapper modelMapper = new ModelMapper();
            tourist = modelMapper.map(request, Tourist.class);

            String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
            tourist.setPassword(encodedPassword);
            repository.save(tourist);

            String encodedCheckPassword = bCryptPasswordEncoder.encode(request.getCheckPassword());
            tourist.setCheckPassword(encodedCheckPassword);
            repository.save(tourist);

            System.out.println("password matches");

            String token = String.valueOf(UUID.randomUUID().getLeastSignificantBits()).substring(1, 5);
            Token confirmationToken = new Token(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
            confirmationTokenImpl.saveConfirmationToken(confirmationToken);
            tourist.setToken(token);


            Tourist savedTourist = repository.save(tourist);
            RegisterResponse response = new RegisterResponse();
            response.setEmail(savedTourist.getEmail());
            response.setFirstName(savedTourist.getFirstName());
            response.setLastName(savedTourist.getLastName());
            response.setPhoneNumber(savedTourist.getPhoneNumber());
            response.setToken(savedTourist.getToken());
            response.setMessage("account successfully created");
            return response;
        } else {
            System.out.println("password does not match");
        }
        RegisterResponse response = new RegisterResponse();
        response.setMessage("invalid details");
        return response;
    }

    @Override
    public LoginResponse loginTourist(LoginRequest request) {
      Optional<Tourist> tourist = repository.findByEmail(request.getEmail());
   
            if(bCryptPasswordEncoder.matches(request.getPassword(), tourist. get().getPassword())){
                LoginResponse response = new LoginResponse();
                response.setFirstName(tourist.get().getFirstName());
                response.setMessage("welcome " + tourist.get().getFirstName());
                return response;
        }
       LoginResponse response = new LoginResponse();
            response.setMessage("invalid details");
        return response;
    }

    private boolean findByEmail(String existByMail){
        Optional<Tourist> tourist = repository.findByEmail(existByMail);
        return tourist.isPresent();
    }

    public boolean enableAppUser(String token) {
        return confirmationTokenImpl.setConfirmedAt(token);
    }

}
