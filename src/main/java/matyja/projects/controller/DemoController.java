package matyja.projects.controller;

import lombok.extern.slf4j.Slf4j;
import matyja.projects.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

   //==Fields ==
    private final DemoService demoService;
    //== My Constructor Injection ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == Request Methods ==

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "This is my new website bijacz";
    }

   // http://localhost:8080/todo-list/welcome
   // http://localhost:8080/todo-list/welcome?user=mati&age=24  ---> NOW WE NEED TO SPECIFY USER
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
     model.addAttribute("helloMessage",demoService.getHelloMessage(user));
     model.addAttribute("age", age);
     log.info("model= {}", model);
        // prefix + page + suffix --> View Resolver Class handles in Web config
        // WEB-INF/view/welcome/jsp
        return "welcome";
    }

    //== Model Atributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessageTEST(){
        log.info("welcome Message called!!");
        return demoService.getWelcomeMessage();
    }


}
