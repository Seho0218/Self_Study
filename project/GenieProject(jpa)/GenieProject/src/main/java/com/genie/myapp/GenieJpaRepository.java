package com.genie.myapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface GenieJpaRepository extends JpaRepository<Member, Long> {
}
