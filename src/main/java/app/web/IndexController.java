package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class IndexController {
    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public ModelAndView getIndexPage() {
//        return new ModelAndView("index");
//    }

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("registerRequest", new RegisterRequest());

        return mav;
    }

//    Binding result captures validation errors if any
    @PostMapping("/register")
    public ModelAndView registerNewUser(@Valid RegisterRequest registerRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("register");
        }
        userService.register(registerRequest);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(){
        User user = userService.getById(UUID.fromString("8af834fa-dbc9-4876-a3eb-c0a39e1d4919"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
