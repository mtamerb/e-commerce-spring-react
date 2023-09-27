package com.tamerb.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "basket_user_id", nullable = false)
    private User user;


    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItem> items;


    public Basket(Long userId, User user) {
        this.userId = userId;
        this.user = user;
    }

    public Basket() {

    }
}
