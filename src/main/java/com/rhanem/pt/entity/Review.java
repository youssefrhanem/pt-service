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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private int rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    private Listing reviewedListing;


}
