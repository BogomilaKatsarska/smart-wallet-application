package app.web;

import app.user.model.User;
import app.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final UserService userService;

    public SubscriptionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUpgradePage(){
        return "upgrade";
    }

    @GetMapping("/history")
    public ModelAndView getUserSubscriptions(){
        User user = userService.getById(UUID.fromString("8af834fa-dbc9-4876-a3eb-c0a39e1d4919"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("user", user);
        mav.setViewName("subscription-history");

        return mav;
    }
}
