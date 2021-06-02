package org.example;

import org.example.io.ObjectSerializerManager;
import org.example.model.AppUser;
import org.example.model.TodoItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
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

        List<AppUser> appUserList = Arrays.asList(
                new AppUser(1, "terminator", "hastalavista123", true, "admin", LocalDate.parse("2006-06-11")),
                new AppUser(2, "connor", "connor123", true, "user", LocalDate.parse("1986-06-11"))
        );

        List<TodoItem> todoItems = Arrays.asList(
                new TodoItem(1, "Find Sarah", "Terminate", LocalDateTime.parse("2021-12-31T23:59"), false, appUserList.get(0)),
                new TodoItem(1, "Find Connor", "Terminate", LocalDateTime.parse("2021-12-31T23:59"), false, appUserList.get(0)),
                new TodoItem(1, "Run away", "Survive", LocalDateTime.parse("2021-12-31T23:59"), false, appUserList.get(1))
        );

        manager.saveAppUsersToJSON(appUserList);
        manager.saveTodoItemsToJSON(todoItems);




    }
}
