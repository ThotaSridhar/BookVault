package com.sridhar.BookVault.repository;

import com.sridhar.BookVault.domain.Review;
import com.sridhar.BookVault.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    public Users findByUsername(String name);
}
