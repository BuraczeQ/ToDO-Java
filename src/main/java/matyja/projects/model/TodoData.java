package matyja.projects.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {
    //== Fields ==
    private static int idValue =1;

    private final List<TodoItem> items = new ArrayList<>();

    //== constructors ==
    public TodoData(){
        // DUMMY DATA ======================================
        addItem(new TodoItem("First", "details 1st", LocalDate.now()));
        addItem(new TodoItem("Second", "details 2nd", LocalDate.now()));
        addItem(new TodoItem("Third", "details 3rd", LocalDate.now()));
        addItem(new TodoItem("Forth", "details 4th", LocalDate.now()));
        addItem(new TodoItem("Fifth", "details 5th", LocalDate.now()));
    }

    //== Public Methods ==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator  = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if(item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for(TodoItem item: items){
            if(item.getId() == id){
                return item;
            }
        } return null;
    }

    public void updateItem(@NonNull TodoItem itemToUpadte){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();
            if(item.equals(itemToUpadte)){
                itemIterator.set(itemToUpadte);
                break;
            }
        }
    }

}
