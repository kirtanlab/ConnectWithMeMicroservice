package com.ConnectWithMe.Controllers;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.input.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "Auth/v1/api/")
public class AuthController {

    private final UserService userservice;

    public AuthController(UserService userservice){
        this.userservice = userservice;
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
        return  ResponseEntity.ok(createUserResponse);
    }

}