package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TaskQueue {
    @Id
    @GeneratedValue
    private int id;

    @Basic(optional = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @Singular
    List<Task> task;
}
