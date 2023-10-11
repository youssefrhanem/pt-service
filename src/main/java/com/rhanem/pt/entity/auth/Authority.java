package com.rhanem.pt.entity.auth;


import com.rhanem.pt.utils.enums.AuthorityCode;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHORITY")
public class Authority   implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_AUTHORITY",length = 80)
    private String libelle;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_CODE",length = 40)
    private AuthorityCode codeAuthority;

    @Column(name = "ROLE_DESCRIPTION",length = 200)
    private String roleDescription;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private AuthorityManager authoritieManager;



    @Override
    public String getAuthority() {
        return null;
    }
}
