package com.project.orderflow.admin.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@NoArgsConstructor
@Getter
public class TableManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numberOfSeats;

    @OneToMany(mappedBy = "tableManagement", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Seat> seats=new ArrayList<>();

    @OneToOne
    @JoinColumn(name="owner_id", nullable = false)
    private Owner owner;

    @OneToMany(mappedBy = "tableManagement", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Food> foods=new ArrayList<>();

    @Builder
    public TableManagement(Owner owner){
        this.owner=owner;
        owner.setTableManagement(this);
    }

    public void createSeats(int numberOfSeats){
        for(int i=0; i<numberOfSeats; i++){
            this.numberOfSeats=numberOfSeats;
            String seatCode=generateSeatCode();
            Seat seat=Seat.builder()
                    .tableNumber(String.valueOf(i+1))
                    .authCode(seatCode)
                    .tableManagement(this)
                    .isActive(false)
                    .build();
            seats.add(seat);
        }
    }

    public String generateSeatCode(){
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<6; i++){
            sb.append(r.nextInt(10));
        }

        return sb.toString();
    }

}
