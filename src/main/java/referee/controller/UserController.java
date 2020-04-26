package referee.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import referee.model.FootballMatches;
import referee.model.User;
import referee.repository.FootballMatchesRespository;
import referee.repository.TeamsRepository;
import referee.repository.UserRepository;

import referee.service.TeamService;
import referee.service.UserService;
import referee.utilities.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FootballMatchesRespository fbmRepo;

    @Autowired
    private TeamsRepository tmrepo;



    @Autowired
    private TeamService teamService;




    @RequestMapping(value = {"/index/home"}, method = RequestMethod.GET)
    public String home(Model model, User user) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("user", user);

        return "home";
    }

    @RequestMapping(value = "/index/profile")
    public String showUserProfilePage(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUsersByEmail(username);

        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping("/index/changeDate")
    public String findUserID(
            @RequestParam("id") Integer id, Model model)
            throws Exception {
        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        System.out.println(userRepository.findById(id));
        model.addAttribute("user", userRepository.findById(id));
        return "upDate";
    }

    @RequestMapping("/index/upDate")
    public String updateUser(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("phone") Integer phone,
             Model model, User user)
            throws Exception {



        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(address);
        user.setPhone(phone);
        user.setStatus("VERIFIED");

        System.out.println(user);

        userRepository.save(user);

        User namee = userService.findUsersByEmail(user.getEmail());

        model.addAttribute("name", namee);
        return "home";
    }

    @RequestMapping(value = "/index/referees" )
    public String showReferees(Model model) {
        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        model.addAttribute("user", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = {"/index/mymatches"}, method = RequestMethod.GET)
    public String mymatches(Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        return "MyMatches";
    }

    @RequestMapping(value = "/index/addMatch", method = RequestMethod.GET)
    public String  addNewMatch(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        FootballMatches fb = new FootballMatches();

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUsersByEmail(username);

        model.addAttribute("user", user);


        model.addAttribute("fbm", fb);

        //model.addAttribute("FootballMatches", userRepository.findAll());
        return "addMatch";
    }

    @RequestMapping(value = "/index/showMatches")
    public String showMyMatches(Model model) {


        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();

        int userID = userRepository.findByEmail(username).getId();

        String usernamee = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(usernamee);


        model.addAttribute("name", name);
        model.addAttribute("fbm", fbmRepo.findAllByuserID(userID));
        return "showMatches";
    }

    @RequestMapping(value = "/index/match/matchinfo")
    public String showMatchesInfo( @RequestParam("id") Integer id, Model model)
            throws Exception  {

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUsersByEmail(username);

        FootballMatches fbm =  fbmRepo.findById(id).get();

        model.addAttribute("name", user);
        model.addAttribute("fbm", fbm );
        return "matchInfo";
    }

    @RequestMapping(value = "/index/addMatch", method = RequestMethod.POST)
    public ModelAndView addNewMatch(FootballMatches fb, User user, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView();


        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        int userID = userRepository.findByEmail(username).getId();

        System.out.println(userID);

        userService.saveMatch(fb, userID);

        model.addAttribute("name", name);

        modelAndView.addObject("fbm", fbmRepo.findAllByuserID(userID));
        modelAndView.setViewName("showMatches");
        return modelAndView;
    }

    @RequestMapping(value = "/index/match/delete")
    public String deleteMatch(@RequestParam("id") Integer id, Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        userService.deleteMatch(id);

        model.addAttribute("fbm", fbmRepo.findAllByuserID(name.getId()));
        return "showMatches";
    }

    @RequestMapping("/index/match/changeDate")
    public String findMatchId(
            @RequestParam("id") Integer id, Model model)
            throws Exception {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        System.out.println(fbmRepo.findById(id));
        model.addAttribute("fbm", fbmRepo.findById(id));

        return "upDateMatch";
    }

    @RequestMapping("/index/match/upDateMatch")
    public String upDateMatch(
            @RequestParam("id_match") Integer id_match,
            @RequestParam("teamA") String teamA,
            @RequestParam("scrA") String scrA,
            @RequestParam("scrB") String scrB,
            @RequestParam("teamB") String teamB,
            @RequestParam("date") Date date,
            @RequestParam("userID") Integer userID,
            @RequestParam("matchAddress") String  matchAddress,
            @RequestParam("info") String info, Model model)
            throws Exception {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        FootballMatches fbm = new FootballMatches(id_match, teamA, scrA, scrB, teamB, date, userID,matchAddress, info);

        fbmRepo.save(fbm);
        model.addAttribute("fbm", fbmRepo.findAll());

        return "MyMatches";
    }

    @RequestMapping(value = "/index/teams")
    public String TeamsList(Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);
        model.addAttribute("teams", tmrepo.findAll());

        return "teams";
    }

    @RequestMapping(value = "/index/searchUser")
    public String SearchUser(
            @RequestParam("kryterium") String kryterium,
            @RequestParam("value") String value,
            Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        if (value.equals("Imie")) {
            String val = kryterium.substring(0, 1).toUpperCase() + kryterium.substring(1);
            System.out.println(val);
            model.addAttribute("user", userService.findAllUsersByName(val));
        } else if (value.equals("Nazwisko")) {
            model.addAttribute("user", userService.findAllUsersByLastName(kryterium));
        } else if (value.equals("Telefon")) {
            model.addAttribute("user", userService.findAllUsersByPhone(Integer.parseInt(kryterium)));
        }

        return "users";
    }



    @RequestMapping(value = "/index/searchTeam")
    public String SearchTeam(
            @RequestParam("kryterium") String kryterium,
            @RequestParam("value") String value,
            Model model) {

        String username = UserUtilities.getLoggedUser();
        User name = userService.findUsersByEmail(username);

        model.addAttribute("name", name);

        System.out.println(value);
        System.out.println(kryterium);
        if (value.equals("Nazwa Druzyny")) {
            String val = kryterium.substring(0, 1).toUpperCase() + kryterium.substring(1);
            System.out.println(val);
            model.addAttribute("teams", teamService.findAllTeamsByTeamName(val));
        } else if (value.equals("Telefon")) {
            System.out.println(value);
            System.out.println(kryterium);
            model.addAttribute("teams", teamService.findAllTeamsByTphone(Integer.parseInt(kryterium)));
        }

        return "teams";
    }




}
