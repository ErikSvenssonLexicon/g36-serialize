package org.example;

import org.example.io.ObjectSerializerManager;
import org.example.model.AppUser;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectSerializerManager manager = new ObjectSerializerManager();

        String path = "src/main/resources/serialized_objects/appUser.ser";

        Optional<AppUser> optional = manager.read(path);


        if(optional.isPresent()){
            System.out.println(optional.get());
        }else{
            System.out.println("Could not load object on path " + path);
        }
    }
}
