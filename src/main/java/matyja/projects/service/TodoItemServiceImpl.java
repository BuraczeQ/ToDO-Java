package matyja.projects.service;

import lombok.Getter;
import matyja.projects.model.TodoData;
import matyja.projects.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    @Getter
    private final TodoData data = new TodoData();



    @Override
    public void addItem(TodoItem todoItem1) {
        data.addItem(todoItem1);
    }

    @Override
    public void removeItem(int i) {
        data.removeItem(i);
    }

    @Override
    public TodoItem getItem(int i) {
      return   data.getItem(i);

    }

    @Override
    public void updateItem(TodoItem todoItem1) {
        data.updateItem(todoItem1);

    }

}
