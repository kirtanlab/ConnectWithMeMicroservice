package com.ConnectWithMe.Domain.ports.input.service;

import com.ConnectWithMe.Domain.User;
import com.ConnectWithMe.Domain.config.AuthServiceConfigData;
import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.output.Repository.UserRepository;
import com.ConnectWithMe.Domain.ports.output.message.publisher.userSignUpRequestMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.ConnectWithMe.Domain.outbox.model.*;
@Service
public class UserService {

    private final UserRepository userrepo;
    private final jwtService jwtservice;

    @Autowired
    private userSignUpRequestMessagePublisher usersignUpRequestMessagePublisher;

    @Autowired
    private  AuthServiceConfigData authServiceConfigData;

    public UserService (UserRepository userrepo , jwtService jwtservice){
        this.userrepo = userrepo;
        this.jwtservice = jwtservice;
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
        try {
            System.out.println("createuser"+createuser.getEmail());
            Map<String, Object> user  = userrepo.saveUser(createuser);
            if(user == null){
                return new createUserResponse(null , null,"Email already exists");
            }
            System.out.println("userName class: " + user.get("userName").getClass().getName());
            System.out.println("userID class: " + user.get("userID").getClass().getName());
            String userIDStr = String.valueOf((Integer) user.get("userID"));

            String acessstoken = jwtservice.generateAccessToken((String) user.get("userName"), userIDStr);
            System.out.println("token");
            UserDetails userResponse = new UserDetails("Nothing");
            System.out.println("useresponse");

            Integer userID = (Integer) user.get("userID");
            List<Integer> skillIDs = createuser.getSkills();
//        List<Integer> projectIDs = userrepo.ProjectIDsByUserID(userID);
//        System.out.println(projectIDs);
//        List<Integer> projectSkillIDs = Collections.emptyList();
            Integer educationIDs = createuser.getCollegesInfo();
//        Integer cityID = createuser.get
//        Integer countryID = createuser.getCountry();
//        Integer stateID = createuser.getState();

            // Create the event object
            UserSignUpEventPayload signUpEvent = new UserSignUpEventPayload(userID, skillIDs, educationIDs);

            // Publish the event (You need to implement the event publishing mechanism)
            usersignUpRequestMessagePublisher.publish(authServiceConfigData.getUserSignUpRequestTopicName(), "User SignUp" , signUpEvent);
            System.out.println("userservice publish");
            return new createUserResponse(userResponse , acessstoken , "Successfully Registered");
        }catch (ClassCastException e){
            System.out.println(e);
            return new createUserResponse(null,null,"Exception");
        }

    }

    public Integer createProject(createProject createproject, Principal principal){
        System.out.println("createproject "+createproject.getProjectTitle() + " user code "+principal.getName());
        return userrepo.saveProject(createproject,principal);
    }
}
