package edu.corvinus.geptermizh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class IndexController
{

    //interneten talált megoldások összeollózása
    //https://dirask.com/posts/Spring-Boot-get-client-IP-address-from-request-HttpServletRequest-pBv9Bp
    //https://stackoverflow.com/questions/29910074/how-to-get-client-ip-address-in-java-httpservletrequest

    @GetMapping("/")
    public String getClientIPAddress(HttpServletRequest request, Model model)
    {
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
        {
            ip = request.getRemoteAddr();
        }

        if (ip.startsWith("146.110"))
        {
            model.addAttribute("egyetem", "Ön a Budapesti Corvinus Egyetem egyik gépéről látogatta meg az oldalt.");
            model.addAttribute("serverTime", new Date());
        }

        return "result";
    }
}
