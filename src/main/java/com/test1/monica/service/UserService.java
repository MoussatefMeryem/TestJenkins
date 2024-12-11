package com.test1.monica.service;

import com.test1.monica.bean.User;
import com.test1.monica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Récupérer tous les utilisateurs
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Enregistrer un nouvel utilisateur
    public User save(User user) {
        return userRepository.save(user);
    }

    // Créer un nouvel utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Supprimer un utilisateur par ID
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // Récupérer un utilisateur par ID
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Mettre à jour un utilisateur
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            return userRepository.save(existingUser);
        }
        return null; // ou lancer une exception personnalisée si l'utilisateur n'est pas trouvé
    }

    // Récupérer un utilisateur par email

}
