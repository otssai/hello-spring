package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value="hello")
public class HelloController {

//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

    // handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }
        // handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

        // handles get requests at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

        // handles post requests at /hello/form
//    @PostMapping("form")
//    public static String createMessage(@RequestParam String name, @RequestParam String language) {
//        String str = "";
//        if (language.equals("English")) {
//            str = "Hello";
//        } else if (language.equals("French")) {
//            str = "Bonjour";
//        } else if (language.equals("Chinese")) {
//            str = "你好";
//        } else if (language.equals("Spanish")) {
//            str = "Hola";
//        } else if (language.equals("Japanese")) {
//            str = "おはよう";
//        }
//        return str + " " + name + "!";
//    }
}
