package org.example.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.AppUser;
import org.example.model.TodoItem;

import java.io.*;
import java.util.*;

public class ObjectSerializerManager {

    private static final ObjectSerializerManager INSTANCE = new ObjectSerializerManager();
    public static final String DIRECTORY = "src/main/resources/serialized_objects/";
    public static final String FILE = "app_users.ser";
    public static final String APP_USERS_FILE = "app_users.json";
    public static final String TODO_ITEMS_FILE = "todo_items.json";
    public static final String JSON_DIR = "src/main/resources/json/";

    private ObjectMapper objectMapper;

    public static ObjectSerializerManager getInstance(){
        return INSTANCE;
    }

    private ObjectSerializerManager(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void saveAppUsersToJSON(Collection<AppUser> appUsers){
        File file = new File(JSON_DIR+APP_USERS_FILE);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, appUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTodoItemsToJSON(Collection<TodoItem> todoItems){
        File file = new File(JSON_DIR+TODO_ITEMS_FILE);
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, todoItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
