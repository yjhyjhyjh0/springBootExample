package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberAccountJPA, Long> {
    List<MemberAccountJPA> findAll();

//    List<MemberAccountJPA> findByEmail(String email);
    MemberAccountJPA findByEmail(String email);
}
