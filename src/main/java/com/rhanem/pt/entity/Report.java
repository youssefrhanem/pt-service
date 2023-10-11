package com.rhanem.pt.entity;

import com.rhanem.pt.entity.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String reason;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private User reportingUser;

    @ManyToOne
    private User reportedUser;

    @ManyToOne
    private Listing reportedListing;


}
