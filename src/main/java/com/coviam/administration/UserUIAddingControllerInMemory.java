package com.coviam.administration;

import com.coviam.administration.model.UserRecord;
import com.coviam.administration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;
/*
UI based user addition and shows the success message
 */

@Controller
public class UserUIAddingControllerInMemory {

    @Autowired
    @Qualifier("com.coviam.administration.service.UserServiceImpl")
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute UserRecord user){
        Random random = new Random();
        user.setId(random.nextLong());
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
