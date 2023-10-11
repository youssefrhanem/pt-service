package com.rhanem.pt.entity.auth;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLES")
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,name = "ROLE_NAME")
    private String label;

    @Column(length = 50,name = "ROLE_CODE",unique = true)
    private String code;

    @Column(name = "ROLE_Details",columnDefinition = "text")
    private String description;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    private Set<Authority> authorities;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}

