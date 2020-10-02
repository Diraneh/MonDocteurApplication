package org.poeiscrumproject.gp2.controller;
import org.poeiscrumproject.gp2.SendEmail;
import org.poeiscrumproject.gp2.model.User;
import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller

@RequestMapping(path="/password")

public class PasswordController {
	
    @Autowired
    UserService service;

   @GetMapping(path="/forgot")
    public ModelAndView showForgotPasswordPage(Model model){
        return new ModelAndView("forgotpassword.html");
    }

    private static String generateSecurityCode(){
        Random random = new Random();
        char[] letters = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
                ,'O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6'
                ,'7','8','9'};
        StringBuilder securityCode= new StringBuilder();
        int index = 0;
        for (int i = 0; i < 8; i++) {
            index = random.nextInt(36);
            securityCode.append(letters[index]);
        }
        return securityCode.toString();
    }

    @PostMapping(path = "/forgot")
    public ModelAndView sendResetPasswordEmail(@RequestParam(name="email") String email, Model model){
        if(!email.isEmpty() && service.getUserByEmail(email)!=null){
            String securityCode = generateSecurityCode();
            User user = service.getUserByEmail(email);
            service.updateUserSecurityCode(user, securityCode);
            String emailBody = "Bonjour, vous avez demandé une réinitialisation du mot de passe. La clé de sécurité est : " + securityCode;
            SendEmail mail=new SendEmail(email,"Réinitialisation du mot de passe", emailBody);
            model.addAttribute("email", email);
            return new ModelAndView("resetpassword.html");
        }
        else {
            return new ModelAndView("forgotpassword.html");
        }
    }

    @PostMapping(path = "/reset")
    public ModelAndView resetPassword(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("confirmpwd") String confirmPwd,
                                      @RequestParam("security-code") String securityCode,
                                      Model model){
        User user = new User();
        try{
            user = service.getUserByUsername(username);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        if(password.equals(confirmPwd) && user.getSecurityCode().equals(securityCode)){
            service.updateUserPassword(user, password);
            return new ModelAndView("index.html");
        }
        else{
            if(!password.equals(confirmPwd)) System.out.println("Mots de passe différents");
            if(!user.getSecurityCode().equals(securityCode)) {
                System.out.println("Code de sécurité incorrect");
                System.out.println("securityCode = " + securityCode);
                System.out.println("actual : "+ user.getSecurityCode());
            }
            return new ModelAndView("resetpassword.html");
        }
    }


}