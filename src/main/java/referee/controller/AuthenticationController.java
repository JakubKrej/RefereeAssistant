package referee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.ui.Model;
import referee.model.User;
import referee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = { "/login","/" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
         return "redirect:/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerr"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();

        //User userExist = userService.findUsersByEmail(user.getEmail());


        // Check for the validations
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Wypełnij formularz rejestracji prawidłowo!");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        else if(userService.findUsersByEmail(user.getEmail())!=null){
            modelAndView.addObject("successMessage", "Użytkownik o podanym adresie e-mail już istnieje!");
        }
        // we will save the user if, no binding errors
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Rejestracja zakończona powodzeniem!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registerr");
        return modelAndView;
    }

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/template/login.html
        return modelAndView;
    }



    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(Authentication authentication, User user,Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if (authentication != null) {
            System.out.println(authentication.getName());

        } else {
            System.out.println("");
        }

        model.addAttribute("user", user);
        model.addAttribute("authentication",authentication);

        modelAndView.setViewName("index"); // resources/template/index.html
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin"); // resources/template/admin.html
        return modelAndView;
    }


}
