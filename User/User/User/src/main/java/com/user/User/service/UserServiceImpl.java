package com.user.User.service;

import com.user.User.entity.User;
import com.user.User.exception.DuplicateEntryInDBException;
import com.user.User.exception.EmptyInputException;
import com.user.User.exception.UserNotFoundException;
import com.user.User.exception.UserWithIdAlreadyExistException;
import com.user.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(Long uid) {
//        Optional<User> user = userRepository.findById(uid);
//        return user.get();
        return userRepository.findById(uid).orElseThrow(()->new UserNotFoundException());
    }

    @Override
    public User addUser(User user) {
//        userRepository.save(user);
//        return user;
        if(user.getU_name().isEmpty() || user.getU_name().length()==0)
            throw new EmptyInputException();

        Optional<User> u = userRepository.findById(user.getUid());
        if (u.isPresent()){
            throw new UserWithIdAlreadyExistException();
        }

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        for(User uu : users){
            if ((uu.getU_name().equals(user.getU_name())) && (uu.getPhone().equals(user.getPhone())) && (uu.getAddress().equals(user.getAddress())) && (uu.getEmail().equals(user.getEmail())))
            {
                throw new DuplicateEntryInDBException();
            }
        }

        userRepository.save(user);
        return user;
    }


    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getUid())){
            userRepository.save(user);
            return user;
        }
       else throw  new UserNotFoundException();

    }

    @Override
    public String deleteUser(Long uid) {
//        Optional<User> user = userRepository.findById(uid);
//        if(user.isPresent()){
//            userRepository.delete(user.get());
//            return "Deleted the User Successfully";
//        }
//        return "User don't exist";
        Optional<User> user = userRepository.findById(uid);
        if (user.isPresent()){
            userRepository.delete(user.get());
            return "Deleted the User Successfully";
        }
        else throw new UserNotFoundException();
    }

    @Override
    public boolean validateUserId(Long uid) {
        if(userRepository.existsById(uid))
            return true;
        return false;
    }
}
