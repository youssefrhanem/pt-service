package com.rhanem.pt.entity;

import com.rhanem.pt.entity.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime timestamp;


}
