package edu.kata.task312.service;

import edu.kata.task312.entity.User;

public interface UserService extends CommonService<User> {

    User findOneByLogin(String login);
}
