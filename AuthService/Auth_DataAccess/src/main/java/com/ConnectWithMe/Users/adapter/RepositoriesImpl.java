package com.ConnectWithMe.Users.adapter;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.output.Repository.UserRepository;
import com.ConnectWithMe.Users.JpaRepository.*;
import com.ConnectWithMe.Users.entity.*;
import com.ConnectWithMe.Users.mapper.UserAccessDataMapper;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static com.ConnectWithMe.Users.mapper.UserAccessDataMapper.convertToCountryEntity;

@Component
public class RepositoriesImpl implements UserRepository {

    private final CountryJpaRepository countryjparepo;
    private final StateJpaRepository statejparepo;
    private final CityJpaRepository cityjparepo;
    private final UserAccessDataMapper usermapper;
    private final CollegeInfoJpaRepository collegeinfojparepo;
    private final SkillJpaRepository skilljparepo;
    private final AuthJpaRepository authjparepo;

    private final EducationJpaRepository educationjparepo;
    private final UserSkillJpaRepository userskilljparepo;
    private final UserProjectsJpaRepository userprojectjparepo;
    private final ProjectSkillsJpaRepository projectskilljparepo;
    public RepositoriesImpl(CountryJpaRepository countryjparepo ,
                            StateJpaRepository statejparepo ,
                            UserAccessDataMapper usermapper,
                            CityJpaRepository cityjparepo,
                            CollegeInfoJpaRepository collegeinfojparepo,
                            SkillJpaRepository skilljparepo,
                            AuthJpaRepository authjparepo,
                            EducationJpaRepository educationjparepo,
                            UserSkillJpaRepository userskilljparepo,
                            UserProjectsJpaRepository userprojectjparepo,
                            ProjectSkillsJpaRepository projectskilljparepo){
        this.countryjparepo = countryjparepo;
        this.statejparepo = statejparepo;
        this.usermapper = usermapper;
        this.cityjparepo = cityjparepo;
        this.collegeinfojparepo = collegeinfojparepo;
        this.skilljparepo = skilljparepo;
        this.authjparepo = authjparepo;
        this.educationjparepo = educationjparepo;
        this.userskilljparepo  = userskilljparepo;
        this.userprojectjparepo = userprojectjparepo;
        this.projectskilljparepo = projectskilljparepo;
    }

    public void saveCountry(createCountry country){
        CountryEntity countryEntity = convertToCountryEntity(country);
        System.out.println(countryEntity);
        countryjparepo.save(countryEntity);
    }

    public void saveState(createState state){
        System.out.println("in repo impl "+state.getStateName());
        System.out.println("in repo impl "+state.getCountryID());
        StateEntity stateEntity = usermapper.convertToStateEntity(state);
        System.out.println("stateEntity "+stateEntity);
        statejparepo.save(stateEntity);
    }

    public void saveCity(createCity city){
        System.out.println("in repo impl "+city.getCityName());
        System.out.println("in repo impl "+city.getCityName());
        CityEntity cityEntity = usermapper.convertToCityEntity(city);
        System.out.println("cityEntity "+cityEntity);
        cityjparepo.save(cityEntity);
    }

    public void saveCollegeInfo(createCollegeInfo createcollegeinfo){
        System.out.println("in repo impl "+createcollegeinfo.getCollegeName());
        System.out.println("in repo impl "+createcollegeinfo.getCountryID());
        CollegesInfoEntity collegeInfoEntity = usermapper.convertToCollegeInfoEntity(createcollegeinfo);
        System.out.println("collegeInfoEntity "+collegeInfoEntity);
        collegeinfojparepo.save(collegeInfoEntity);
    }

    public void saveSkill(createSkill createskill){
        System.out.println("in repo impl "+createskill.getSkillName());
        SkillsEntity skillEntity = usermapper.convertToSkillEntity(createskill);
        System.out.println("skillEntity "+skillEntity);
        skilljparepo.save(skillEntity);
    }

    public Map<String, Object> saveUser(createUser createuser){
        Map<String, Object> userobj = new HashMap<>();
        if (authjparepo.existsByEmail(createuser.getEmail())) {
            // User with the same email already exists
            return null;
        }
        System.out.println("createuser "+createuser.getHeadline());
        UsersEntity userEntity = UsersEntity.builder()
                .ProfilePicture(createuser.getProfilePicture())
                .password(createuser.getPassword())
                .Name(createuser.getName())
                .email(createuser.getEmail())
                .headline(createuser.getHeadline())
                .createdAt(new Date())
                .updatedAt(new Date())
                .status(true)
                .build();
        authjparepo.save(userEntity);
        System.out.println("id "+userEntity.getId());
        Optional<UsersEntity> userOptional = authjparepo.findById(userEntity.getId());
        UsersEntity user = userOptional.orElse(null);

        CollegesInfoEntity collegesInfo = collegeinfojparepo.findById(createuser.getCollegesInfo())
                .orElseThrow(() -> new RuntimeException("College not found"));
        System.out.println(collegesInfo.getCollegeName());

        EducationEntity education = EducationEntity.builder()
                .collegesInfo(collegesInfo)
                .user(user)
                .Degreetitlee(createuser.getDegreetitlee())
                .StartDate(createuser.getStartDate())
                .EndDate(createuser.getEndDate())
                .DegreeName(createuser.getDegreeName())
                .build();
        educationjparepo.save(education);

        List<UserSkillsEntity> userSkillsEntities = createuser.getSkills().stream()
                .map(skillId -> {
                    // Fetch or create SkillsEntity for the given skillId
                    SkillsEntity skillEntity = skilljparepo.findById(skillId)
                            .orElse(SkillsEntity.builder().skillName("New Skill").build());

                    // Create UserSkillsEntity to associate user with skill
                    return UserSkillsEntity.builder()
                            .userId(user)
                            .skillId(skillEntity)
                            .build();
                })
                .collect(Collectors.toList());

        // Save all user skill associations
        userskilljparepo.saveAll(userSkillsEntities);

        userobj.put("userID", userEntity.getId());
        userobj.put("userName", userEntity.getName());
        return userobj;
    }

    public Map<String, Object> loginUser(checkUser checkuser){
        Map<String, Object> userobj = new HashMap<>(); // Instantiate a HashMap
        System.out.println("user ");
        UsersEntity user = authjparepo.findByEmail(checkuser.getEmail());
        System.out.println("user "+user.getId());
        userobj.put("userID", String.valueOf(user.getId()));
        userobj.put("userName", user.getName());
        return userobj;
    }

    public Integer saveProject(createProject createproject, Principal principal){
        if (userprojectjparepo.existsByProjectTitle(createproject.getProjectTitle())) {
            // User with the same email already exists
            return null;
        }
        UsersEntity user = authjparepo.findById(Integer.valueOf(principal.getName()))
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserProjectsEntity userProjects = UserProjectsEntity.builder()
                .projectTitle(createproject.getProjectTitle())
                .user(user)
                .ProjectLink(createproject.getProjectLink())
                .ProjectDescription(createproject.getProjectDescription())
                .createdAt(new Date())
                .UpdatedAt(new Date())
                .build();
        userprojectjparepo.save(userProjects);

        List<Integer> projectSkills = createproject.getProjectSkills();

        // Save project skills
        for (Integer skillId : projectSkills) {
            // Create a new ProjectSkillsEntity for each skill and associate it with the project
            ProjectSkillsEntity projectSkill = ProjectSkillsEntity.builder()
                    .project(userProjects)
                    .skills(skilljparepo.findById(skillId).orElseThrow(() -> new RuntimeException("Skill not found")))
                    .build();
            projectskilljparepo.save(projectSkill);
        }

        return userProjects.getId();
    }

//    public List<Integer> ProjectIDsByUserID(createUser user){
//        return userprojectjparepo.findProjectIDsByuser(user);
//    }
}