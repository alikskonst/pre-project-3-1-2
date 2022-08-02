package edu.kata.task312.service.impl;

import edu.kata.task312.entity.User;
import edu.kata.task312.repository.UserRepository;
import edu.kata.task312.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found by id: " + id)
        );
    }

    @Override
    public User findOne(String login) {
        return userRepository.findOneByLogin(login).orElseThrow(
                () -> new EntityNotFoundException("User not found by login: " + login)
        );
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setLogin(user.getName() + "@localhost");
        user.setPassword(passwordEncoder.encode(user.getName()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
