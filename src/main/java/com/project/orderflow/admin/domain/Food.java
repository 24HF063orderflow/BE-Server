package com.project.orderflow.admin.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "음식의 이름을 작성 해주세요")
    private String name;

    private String description;

    @NotNull
    @Min(0)
    private Integer price;

    @ManyToOne
    @JoinColumn(name="food_management_id", nullable=false)
    private FoodManagement foodManagement;

    @Builder
    public Food(String name, String description, int price, FoodManagement foodManagement) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodManagement = foodManagement;
    }
}
