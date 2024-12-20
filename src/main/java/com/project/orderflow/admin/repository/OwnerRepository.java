package com.project.orderflow.admin.repository;

import com.project.orderflow.admin.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    //Owner findByEmail(String email);

    Optional<Owner> findByEmail(String email);
}
