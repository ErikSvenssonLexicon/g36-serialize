package org.example.io;

import org.example.model.AppUser;

import java.io.*;
import java.util.*;

public class ObjectSerializerManager {

    private static final ObjectSerializerManager INSTANCE = new ObjectSerializerManager();
    public static final String DIRECTORY = "src/main/resources/serialized_objects/";
    public static final String FILE = "app_users.ser";

    public static ObjectSerializerManager getInstance(){
        return INSTANCE;
    }

    private ObjectSerializerManager(){
    }

    public void save(List<AppUser> appUsers){
        String target = DIRECTORY+FILE;
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(target))){
            out.writeObject(appUsers);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<AppUser> findAll(){
        List<AppUser> appUsers = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(DIRECTORY+FILE))){
            appUsers = (List<AppUser>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return appUsers;
    }

    public Optional<AppUser> findById(int id){
        AppUser appUser = null;
        for(AppUser user : findAll()){
            if(user.getId() == id){
                appUser = user;
                break;
            }
        }
        return Optional.ofNullable(appUser);
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
