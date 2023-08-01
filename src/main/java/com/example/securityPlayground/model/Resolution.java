package com.example.securityPlayground.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Resolution {
    @Id
    @GeneratedValue
    private Long id;

    String note;

    @ManyToOne
    User user;
}
