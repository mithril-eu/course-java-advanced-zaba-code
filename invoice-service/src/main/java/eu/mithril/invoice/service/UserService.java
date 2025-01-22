package eu.mithril.invoice.service;

import java.util.UUID;

import eu.mithril.invoice.model.User;

public class UserService {

    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();
        return new User(id, randomName); // always finds the user
    }

}
