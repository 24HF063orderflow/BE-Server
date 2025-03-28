package com.project.orderflow.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tableNumber;
    @Column(nullable = false, unique = true)
    private String authCode;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String qrUrl;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private Double y;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="table_management_id", nullable = false)
    private TableManagement tableManagement;

    @Builder
    public Seat(String tableNumber, String authCode, TableManagement tableManagement, Boolean isActive, String qrUrl, Double x, Double y){
        this.tableNumber=tableNumber;
        this.authCode=authCode;
        this.tableManagement=tableManagement;
        this.isActive=isActive;
        this.qrUrl=qrUrl;
        this.x = x;
        this.y = y;
    }

    public Boolean activateSeat(String authCode){
        if(this.authCode.equals(authCode)){
            this.isActive=true;
            return true;
        }
        return false;
    }

    public void setTableNumber(String newTableNumber){
        this.tableNumber=newTableNumber;
    }

    public void setTableManagement(TableManagement tableManagement){
        this.tableManagement=tableManagement;
    }
}
