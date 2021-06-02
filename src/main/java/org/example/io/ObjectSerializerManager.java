package org.example.io;

import org.example.model.AppUser;

import java.io.*;
import java.util.Optional;

public class ObjectSerializerManager {


    public AppUser save(AppUser appUser, String path){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(appUser);

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return appUser;
    }

    public Optional<AppUser> read(String path){
        AppUser appUser = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))){
            appUser = (AppUser) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(appUser);
    }


}
