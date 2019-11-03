package matyja.projects.controller;

import matyja.projects.model.TodoData;
import matyja.projects.service.TodoItemService;
import matyja.projects.service.TodoItemServiceImpl;
import matyja.projects.util.Mappings;
import matyja.projects.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.SecureRandom;

@Controller
public class TodoItemController {

    //== fields ==
   private final TodoItemService todoItemService;

   // == constructor ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }


    //== Model Atribute Section ==

    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    //== handler methods ==

    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
