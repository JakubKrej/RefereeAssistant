package referee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import referee.model.FootballMatches;
import referee.model.Teams;
import referee.model.User;
import referee.repository.FootballMatchesRespository;
import referee.repository.TeamsRepository;
import referee.repository.UserRepository;
import referee.service.UserService;
import referee.utilities.UserUtilities;

import java.sql.Date;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamsRepository teamsRepository;

    @Autowired
    private FootballMatchesRespository footballMatchesRespository;

    @RequestMapping(value={"/admin/home"}, method=RequestMethod.GET)
    public String home(Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        return "home";
    }

    @RequestMapping(value = "/admin/users")
    public String showUserProfilePage(Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
//        for(User user : userRepository.findAll()){
//            System.out.println(user);
//        }

        model.addAttribute("user", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value="/admin/users/delete")
    public String delete(@RequestParam("id") Integer id, Model model){

        userService.deleteUser(id);

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        model.addAttribute("user", userRepository.findAll());
        return "users";
    }

    @RequestMapping("/admin/users/changeDate")
    public String findID(
            @RequestParam("id") Integer id, Model model)
            throws Exception {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);


        System.out.println(userRepository.findById(id));
        model.addAttribute("user", userRepository.findById(id));
        return "upDate";
    }

    @RequestMapping("/admin/users/upDate")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phone") Integer phone,
            @RequestParam("password") String password,Model model)
        throws Exception {
        User user = new User(id,name,lastName,email,address,phone,password, "VERIFIED");
        System.out.println(user);
        userRepository.save(user);

        String username = UserUtilities.getLoggedUser();
        User name1 = userService.findUsersByEmail(username);

        model.addAttribute("name", name1);


        model.addAttribute("user", userRepository.findAll());

        return "users";
    }

    @RequestMapping(value = "/admin/teams")
    public String TeamsList(Model model){

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("teams", teamsRepository.findAll());
        return "teams";
    }

    @RequestMapping("/admin/team/changeDate")
    public String findTeamId(
            @RequestParam("id") Integer id, Model model)
            throws Exception {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        System.out.println(teamsRepository.findById(id));
        model.addAttribute("teams", teamsRepository.findById(id));
        return "upDateTeam";
    }

    @RequestMapping("/admin/team/upDateTeam")
    public String upDateTeam(
            @RequestParam("id_team") int id_team,
            @RequestParam("teamName") String teamName,
            @RequestParam("teamAddress") String teamAddress,
            @RequestParam("tphone") int teamphone,
            @RequestParam("temail") String teamemail, Model model)
            throws Exception {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        Teams team = new Teams(id_team,teamName,teamAddress,teamphone,teamemail);

        teamsRepository.save(team);
        model.addAttribute("teams", teamsRepository.findAll());

        return "teams";
    }

    @RequestMapping(value="/admin/team/delete")
    public String deleteTeam(@RequestParam("id") Integer id, Model model){

        userService.deleteTeam(id);

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("teams", teamsRepository.findAll());
        return "teams";
    }

    @RequestMapping(value = "/admin/allmatches")
    public String showAllMatches(Model model){

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("fbm", footballMatchesRespository.findAll());

        return "showMatches";
    }

    @RequestMapping(value="/admin/match/delete")
    public String deleteMatch(@RequestParam("id") Integer id, Model model){

        userService.deleteMatch(id);

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("fbm", footballMatchesRespository.findAll());
        return "showMatches";
    }


    @RequestMapping("/admin/match/changeDate")
    public String findMatchId(
            @RequestParam("id") Integer id, Model model)
            throws Exception {

        System.out.println(footballMatchesRespository.findById(id));

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("fbm", footballMatchesRespository.findById(id));
        return "upDateMatch";
    }

    @RequestMapping("/admin/match/upDateMatch")
    public String upDateMatch(
            @RequestParam("id_match") Integer id_match,
            @RequestParam("teamA") String teamA,
            @RequestParam("scrA") String scrA,
            @RequestParam("scrB") String scrB,
            @RequestParam("teamB") String teamB,
            @RequestParam("date") Date date,
            @RequestParam("userID") Integer userID,
            @RequestParam("matchAddress") String matchAddress,
            @RequestParam("info") String info, Model model)
            throws Exception {

        FootballMatches fbm = new FootballMatches(id_match,teamA,scrA,scrB,teamB,date,userID, matchAddress, info);


        footballMatchesRespository.save(fbm);

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("fbm", footballMatchesRespository.findAll());

        return "showMatches";
    }


}
