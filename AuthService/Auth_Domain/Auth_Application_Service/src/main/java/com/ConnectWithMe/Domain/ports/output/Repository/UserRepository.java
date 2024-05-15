package com.ConnectWithMe.Domain.ports.output.Repository;

import com.ConnectWithMe.Domain.dto.create.*;

public interface UserRepository {

    void saveCountry(createCountry country);
    void saveState(createState createstate);
    void saveCity(createCity createcity);
    void saveCollegeInfo(createCollegeInfo createcollegeinfo);
    void saveSkill(createSkill createskill);
    Integer saveUser(createUser createuser);
    Integer loginUser(checkUser checkuser);
}
