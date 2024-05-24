package com.ConnectWithMe.Domain.ports.output.Repository;

import com.ConnectWithMe.Domain.dto.create.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface UserRepository {

    void saveCountry(createCountry country);
    void saveState(createState createstate);
    void saveCity(createCity createcity);
    void saveCollegeInfo(createCollegeInfo createcollegeinfo);
    void saveSkill(createSkill createskill);
    Map<String, Object> saveUser(createUser createuser);
    Map<String, Object> loginUser(checkUser checkuser);
    Integer saveProject(createProject createproject, Principal principal);
//    List<Integer> ProjectIDsByUserID(createUser user);
}
