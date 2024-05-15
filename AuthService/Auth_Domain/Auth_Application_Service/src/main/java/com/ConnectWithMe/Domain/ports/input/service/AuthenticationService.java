package com.ConnectWithMe.Domain.ports.input.service;

import com.ConnectWithMe.Domain.dto.create.LoginUserResponse;
import com.ConnectWithMe.Domain.dto.create.checkUser;
import com.ConnectWithMe.Domain.dto.create.createUserResponse;
import com.ConnectWithMe.Domain.ports.output.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {
    @Autowired
    private UserService userservice;
    @Autowired
    private jwtService jwtservice;

    private final UserRepository userrepo;


    private final String SECRET_KEY = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf"; // Change this to your secret key

    public AuthenticationService(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    public LoginUserResponse authenticate(checkUser checkuser) {
//        EmployeeModel employeeDetails = employeeService.getEmployeeDetailsByEmployeeCode(employeeCode, password);
        Map<String, Object> user = userrepo.loginUser(checkuser);
        if (user != null) {
            String acessstoken = jwtservice.generateAccessToken((String) user.get("userName"), (String) user.get("userID"));
//            String refreshtoken = jwtservice.generateRefreshToken(employeeDetails);
            return new LoginUserResponse(acessstoken,"Successfully Login", (String) user.get("userName"));
        } else {
            return null;
        }
    }


}
