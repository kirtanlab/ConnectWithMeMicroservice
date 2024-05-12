package com.ConnectWithMe.Domain.ports.input.service;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.output.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userrepo;

    public UserService (UserRepository userrepo){
        this.userrepo = userrepo;
    }

    public String RegisterCountry(createCountry countryName) {
        System.out.println("countryName "+countryName);
        userrepo.saveCountry(countryName);
        return "Done";
    }

    public String RegisterState(createState createstate) {
        System.out.println("createstate "+createstate.getStateName());
        System.out.println("createstate "+createstate.getCountryID());
        userrepo.saveState(createstate);
        return "Done";
    }

    public String RegisterCity(createCity createcity) {
        System.out.println("createcity "+createcity.getCityName());
        System.out.println("createcity "+createcity.getStateID());
        userrepo.saveCity(createcity);
        return "Done";
    }

    public String RegisterCollegeInfo(createCollegeInfo createcollegeinfo) {
        System.out.println("createcollegeinfo "+createcollegeinfo.getStateID());
        System.out.println("createcollegeinfo "+createcollegeinfo.getCityID());
        userrepo.saveCollegeInfo(createcollegeinfo);
        return "Done";
    }

    public String RegisterSkill(createSkill createskill) {
        System.out.println("createskill "+createskill.getSkillName());
        userrepo.saveSkill(createskill);
        return "Done";
    }

    public createUserResponse RegisterUser(createUser createuser){
        System.out.println("createuser"+createuser.getEmail());
        Integer userID = userrepo.saveUser(createuser);
        if(userID == null){
            return new createUserResponse(null,"Email already exists");
        }
        return new createUserResponse(userID,"done");
    }
}
