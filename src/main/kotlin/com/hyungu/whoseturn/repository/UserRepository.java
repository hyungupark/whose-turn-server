package com.hyungu.whoseturn.repository;

import com.hyungu.whoseturn.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
