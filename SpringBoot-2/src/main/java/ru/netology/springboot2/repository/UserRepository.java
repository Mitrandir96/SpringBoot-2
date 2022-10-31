package ru.netology.springboot2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot2.authorities.Authorities;
import ru.netology.springboot2.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

    private List<User> users = new CopyOnWriteArrayList<>(new User[]{
            new User("Sergei", "12345678", new ArrayList<>(List.of(new Authorities[]{Authorities.WRITE}))),
            new User("Alex", "99999999", new ArrayList<>(List.of(new Authorities[]{Authorities.READ, Authorities.DELETE}))),
            new User("Vanya", "88888888", new ArrayList<>(List.of(new Authorities[]{Authorities.WRITE, Authorities.READ}))),
    });

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User singleUser : users) {
            if (singleUser.getName().equals(user) && singleUser.getPassword().equals(password)) {
                return singleUser.getAuthorities();
            }
        }
        return new ArrayList<>();
    }

}
