package com.rhanem.pt.entity.auth;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHORITY_MANAGER")
public class AuthorityManager {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_AUTHORITY",length = 80)
    private String nom;

    @Column(name = "CODE",length = 80)
    private String code;

    @Column(name = "ROLE_CODE",length = 60)
    private String tage;

    @Column(name = "DESCRIPTION",length = 200)
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "authoritieManager",fetch = FetchType.EAGER)
    @OrderBy("id ASC")
    private Set<Authority> authorities = new HashSet<>();

}

