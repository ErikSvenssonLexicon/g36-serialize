package org.example;

import org.example.io.ObjectSerializerManager;
import org.example.model.AppUser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                new AppUser(1, "terminator", "hastalavista123", true, "admin"),
                new AppUser(2, "connor", "connor123", true, "user")
        );

        manager.save(appUserList);





    }
}
