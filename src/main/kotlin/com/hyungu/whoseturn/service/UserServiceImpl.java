package com.hyungu.whoseturn.service;

import com.hyungu.whoseturn.model.UserModel;
import com.hyungu.whoseturn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel saveMember(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllMembers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getMemberById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("UserModel not found"));
    }

    @Override
    public UserModel updateMember(UserModel userModel, Long id) {
        UserModel existingUserModel = getMemberById(id);
        existingUserModel.setId(userModel.getId());
        existingUserModel.setName(userModel.getName());
        return userRepository.save(existingUserModel);
    }

    @Override
    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }

}
