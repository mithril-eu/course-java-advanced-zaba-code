package eu.mithril.invoice_service_boot.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import eu.mithril.invoice_service_boot.model.User;


@Service
public class UserService {

    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();
        return new User(id, randomName); // always finds the user
    }

}
