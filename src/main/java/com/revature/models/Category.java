package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
public class Category {
    @Id
    private int id;

    private String name;
}
