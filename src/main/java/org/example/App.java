package org.example;

import org.example.io.ObjectSerializerManager;
import org.example.model.AppUser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectSerializerManager manager = new ObjectSerializerManager();
        AppUser appUser = new AppUser(
                1,
                "terminator",
                "hastalavista123",
                true,
                "admin"
        );
        String path = "src/main/resources/serialized_objects/appUser.ser";
        appUser = manager.save(appUser, path);
    }
}
