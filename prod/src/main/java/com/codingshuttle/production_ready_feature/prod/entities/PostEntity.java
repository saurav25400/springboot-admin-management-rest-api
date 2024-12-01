package com.codingshuttle.production_ready_feature.prod.entities;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.envers.Audited;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_data")
@Audited
public class PostEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String description;

    @PrePersist
    void beforeCreate(){

    }
    @PreUpdate
    void  beforeUpdate(){

    }

    @PreRemove
    void beforeDelete(){

    }


}
