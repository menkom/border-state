package info.mastera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String regNum;

    @Enumerated(EnumType.STRING)
    Status status;

    Integer orderId;

    LocalDateTime registrationDate;

    LocalDateTime changedDate;

    @ManyToOne(targetEntity = Checkpoint.class)
    @JoinColumn(name = "checkpoint_id", referencedColumnName = "name", nullable = false)
    Checkpoint checkpoint;

    @Enumerated(EnumType.STRING)
    QueueType queueType;
}
