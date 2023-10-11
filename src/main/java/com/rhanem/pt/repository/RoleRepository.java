package com.rhanem.pt.repository;

import com.rhanem.pt.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    boolean existsByCode(String code);
    Optional<Role> findOneByCode(String code);
}
