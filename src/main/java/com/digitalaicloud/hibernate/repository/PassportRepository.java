package com.digitalaicloud.hibernate.repository;

import com.digitalaicloud.hibernate.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport,Long> {
}
