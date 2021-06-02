package org.example.io;

import org.example.model.AppUser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSerializerManager {


    public AppUser save(AppUser appUser, String path){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(appUser);

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return appUser;
    }


}
