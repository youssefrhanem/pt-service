package com.rhanem.pt.repository;

import com.rhanem.pt.entity.auth.User;
import com.rhanem.pt.utils.enums.AuthorityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByUsername(String username);
   // Optional<User> findByUid(String uid);
    boolean existsByUsername(String username);
    boolean existsByUsernameAndRolesAuthoritiesCodeAuthority(String username , AuthorityCode authorityCode);


    // boolean existsByIdAndRolesAuthoritiesCodeAuthorityAndStatus(Long id , AuthorityCode authorityCode, DefaultStatus status);
   // boolean existsByIdAndTypeUserCodeAndStatus(Long id , String typeUserCode, DefaultStatus status);


}
