package com.project.orderflow.customer.domain;

import com.project.orderflow.customer.domain.enums.SongStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ownerId;

    private String tableNumber;

    private String title;

    private String artist;

    @Enumerated(EnumType.STRING)
    private SongStatus status;  // Enum으로 상태 관리

    private LocalDateTime requestedAt;

    @Builder
    public Song(Long ownerId, String tableNumber, String title, String artist, SongStatus status, LocalDateTime requestedAt) {
        this.ownerId = ownerId;
        this.tableNumber = tableNumber;
        this.title = title;
        this.artist = artist;
        this.status = status;
        this.requestedAt = requestedAt;
    }

    public void changeStatus(SongStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("상태는 비어있을 수 없습니다.");
        }
        this.status = newStatus;
    }
}