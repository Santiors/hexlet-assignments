package exercise;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private User getUserById(String id) {
        List<User> userList = getUsers();

        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;  // User not found
    }

    private List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/users.json");
            userList = objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

}
