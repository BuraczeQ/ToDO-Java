package matyja.projects.controller;

import lombok.extern.slf4j.Slf4j;
import matyja.projects.model.TodoData;
import matyja.projects.model.TodoItem;
import matyja.projects.service.TodoItemService;
import matyja.projects.util.AttributeNames;
import matyja.projects.util.Mappings;
import matyja.projects.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1")
                                          int id, Model model){
        log.info("edditing id  = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null){
        todoItem = new TodoItem("","", LocalDate.now());
              }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
    log.info("todo Item from form = {}", todoItem );

    if(todoItem.getId()==0){
        todoItemService.addItem(todoItem);
    }else {
        todoItemService.updateItem(todoItem);
    }

    return "redirect:/"+Mappings.ITEMS;

}
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoItemService.removeItem(id);
        return "redirect:/"+Mappings.ITEMS;

    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;

    }

}


