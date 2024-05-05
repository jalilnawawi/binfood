package com.example.challenge4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String location;
    private boolean open;
    private boolean deleted;

//    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, targetEntity = Product.class)
//    private List<Product> productList;
}
