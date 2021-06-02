package org.example;

import org.example.io.ObjectSerializerManager;
import org.example.model.AppUser;
import org.example.model.TodoItem;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectSerializerManager manager = ObjectSerializerManager.getInstance();

        List<TodoItem> todoItems = manager.loadTodoItemsFromJSON();
        System.out.println("TODO ITEMS:");
        todoItems.forEach(System.out::println);
        System.out.println("---");
        System.out.println("ASSIGNEES:");
        todoItems.stream()
                .map(TodoItem::getAssignee)
                .forEach(System.out::println);
        System.out.println("---");
        System.out.println("ALL APP USERS");
        List<AppUser> appUsers = manager.loadAppUsersFromJSON();
        appUsers.forEach(System.out::println);
    }
}
