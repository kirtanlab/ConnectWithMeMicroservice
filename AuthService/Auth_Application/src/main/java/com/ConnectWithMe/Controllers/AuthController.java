package com.ConnectWithMe.Controllers;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.input.service.AuthenticationService;
import com.ConnectWithMe.Domain.ports.input.service.UserService;
import com.ConnectWithMe.Domain.ports.input.service.jwtService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "Auth/v1/api/")
public class AuthController {

    private final UserService userservice;
    private final jwtService jwtservice;
    private final AuthenticationService authservice;

    public AuthController(UserService userservice , AuthenticationService authservice , jwtService jwtservice){
        this.userservice = userservice;
        this.authservice = authservice;
        this.jwtservice = jwtservice;
    }

    @PostMapping("Country/")
    public ResponseEntity<?> AddCountry(@RequestBody createCountry createcountry){
        System.out.println("create country  "+createcountry.getCountryName());
        String response  = userservice.RegisterCountry(createcountry);
        return  ResponseEntity.ok(response);
    }

    @PostMapping("State/")
    public ResponseEntity<?> Addstate(@RequestBody createState createstate){
        System.out.println("create state  "+createstate.getCountryID());
        System.out.println("create state  "+createstate.getStateName());
        String response  = userservice.RegisterState(createstate);
        return  ResponseEntity.ok(response);
    }

    @PostMapping("City/")
    public ResponseEntity<?> Addcity(@RequestBody createCity createcity){
        System.out.println("create state  "+createcity.getStateID());
        System.out.println("create state  "+createcity.getCityName());
        String response  = userservice.RegisterCity(createcity);
        return  ResponseEntity.ok(response);
    }

    @PostMapping("CollegeInfo/")
    public ResponseEntity<?> AddcollegeInfo(@RequestBody createCollegeInfo createcollegeinfo){
        System.out.println("createCollegeInfo  "+createcollegeinfo.getCollegeName());
        System.out.println("createCollegeInfo  "+createcollegeinfo.getCountryID());
        String response  = userservice.RegisterCollegeInfo(createcollegeinfo);
        return  ResponseEntity.ok(response);
    }

    @PostMapping("Skill/")
    public ResponseEntity<?> Addskill(@RequestBody createSkill createskill){
        System.out.println("createskill  "+createskill.getSkillName());
        String response  = userservice.RegisterSkill(createskill);
        return  ResponseEntity.ok(response);
    }

    @PostMapping("SignUp/")
    public ResponseEntity<?> RegisterUser(@RequestBody createUser createuser){
        System.out.println("createUser "+createuser.getName());
        createUserResponse createUserResponse = userservice.RegisterUser(createuser);
//        String acessstoken = jwtservice.generateAccessToken((String) user.get("userName"), (String) user.get("userID"));
        return  ResponseEntity.ok(createUserResponse);
    }
    @PostMapping("Login/")
    public ResponseEntity<?> LoginUser(@RequestBody checkUser checkuser){
        System.out.println("checkuser "+checkuser.getEmail());
        LoginUserResponse loginUserResponse = authservice.authenticate(checkuser);
        return  ResponseEntity.ok(loginUserResponse);
    }

    @PostMapping("UserProject/")
//    if exists project
    public ResponseEntity<?> createProject(@RequestBody createProject createproject , Principal principal){
        System.out.println("controller "+principal.getName());
        Integer projectID = userservice.createProject(createproject,principal);
        Map<String, Integer> projectMap = new HashMap<>();
        projectMap.put("ProjectID ", projectID);
        if (projectID == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Project with this title is already there");
        }
        return ResponseEntity.ok(projectMap);
    }
}