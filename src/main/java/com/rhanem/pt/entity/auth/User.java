package com.rhanem.pt.entity.auth;


import com.rhanem.pt.entity.Company;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;


    @Column(name = "FIRST_NAME",length = 50,nullable = false)
    private String nom;

    @Column(name = "LAST_NAME",length = 50,nullable = false)
    private String prenom;

    @Column(name = "CREATED_ON")
    private Date createdAt;

    @Column(name = "UPDATED_ON")
    private Date updatedAt;

    @Column(name = "BLOCKED_ACCOUNTS")
    private boolean enable;

    @Column(name = "FIRST_LOGIN")
    private Boolean firstLogin = Boolean.TRUE;

    @Column(name = "AVATAR")
    private String avatar;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Company company;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private Set<AuthenticatedTraceManager> authenticatedTraceManagers;

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> permissions = new ArrayList<>();
        this.getRoles().forEach(e-> permissions.addAll(e.getAuthorities()));
        return permissions;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
