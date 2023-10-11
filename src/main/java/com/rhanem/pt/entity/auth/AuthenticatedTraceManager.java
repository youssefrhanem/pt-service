package com.rhanem.pt.entity.auth;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHENTICATED_TRACE_MANAGER")
public class AuthenticatedTraceManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt = new Date();

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "MAC_ADDRESS")
    private String macAddress;

    @Column(name = "NAVIGATOR_NAME")
    private String navigatorName;

    @Column(name = "NAVIGATOR_VERSION")
    private String navigatorVersion;

    @Column(name = "SYSTEM_VERSION")
    private String systemVersion;

    @Column(name = "SYSTEM_TYPE")
    private String systemType;

    @Column(name = "DEVICE_TYPE")
    private String device;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.REFRESH)
    private User user;
}
