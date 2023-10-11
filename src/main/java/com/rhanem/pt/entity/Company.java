package com.rhanem.pt.entity;


import com.rhanem.pt.entity.auth.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "eid_commerce")
    private String eid;
    @Column(name = "registre_commerce")
    private String rc;
    @Column(name = "social_reason")
    private String rs;
    @Column(name = "nom")
    private String nom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "fax")
    private String fax;
    @Column(name = "code_company")
    private String code;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "web_site",length = 80)
    private String siteweb;
    @Column(name = "company_license",length = 50)
    private String patente;
    @Column(name = "company_ice",length = 50)
    private String ice;
    @Column(name = "company_ifu",length = 50)
    private String ifu;

    @EqualsAndHashCode.Exclude  @ToString.Exclude
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();


    @EqualsAndHashCode.Exclude  @ToString.Exclude
    @OneToOne(mappedBy = "company")
    private User user;

}
