package com.rhanem.pt.repository;

import com.rhanem.pt.utils.enums.AuthorityCode;

import java.util.Optional;

public interface AuthorityRepository <Authority ,Long>{

    Optional<Authority> findOneByCodeAuthority(AuthorityCode code);
}
