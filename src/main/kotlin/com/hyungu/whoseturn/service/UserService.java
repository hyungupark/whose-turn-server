package com.hyungu.whoseturn.service;

import com.hyungu.whoseturn.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel saveMember(UserModel userModel);

    List<UserModel> getAllMembers();

    UserModel getMemberById(Long id);

    UserModel updateMember(UserModel userModel, Long id);

    void deleteMember(Long id);

}
