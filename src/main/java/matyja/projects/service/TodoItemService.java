package matyja.projects.service;

import matyja.projects.model.TodoData;
import matyja.projects.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int i);

    TodoItem getItem(int i);

    void updateItem(TodoItem todoItem);

    TodoData getData();

}
