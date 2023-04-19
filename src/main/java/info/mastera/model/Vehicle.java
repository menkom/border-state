package info.mastera.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
