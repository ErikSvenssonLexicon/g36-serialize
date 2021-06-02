package org.example.io;

import org.example.model.AppUser;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ObjectSerializerManager {

    private static final ObjectSerializerManager INSTANCE = new ObjectSerializerManager();
    public static final String DIRECTORY = "src/main/resources/serialized_objects/";
    public static final String FILE = "app_users.ser";

    public static ObjectSerializerManager getInstance(){
        return INSTANCE;
    }



    private final Set<AppUser> appUsers;

    private ObjectSerializerManager(){
        appUsers = new HashSet<>();
    }

    public void save(Collection<AppUser> appUsers){
        String target = DIRECTORY+FILE;
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))){
            out.writeObject(appUsers);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


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
