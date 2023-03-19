package info.mastera.model;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

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
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String regNum;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    Status status;

    Integer orderId;

    LocalDateTime registrationDate;

    LocalDateTime changedDate;

    @ManyToOne(targetEntity = Checkpoint.class)
    @JoinColumn(name = "checkpoint_id", referencedColumnName = "name", nullable = false)
    Checkpoint checkpoint;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    QueueType queueType;
}
