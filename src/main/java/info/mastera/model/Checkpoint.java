package info.mastera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Checkpoint {

    @Id
    String name;

    String id;

    @EqualsAndHashCode.Exclude
    boolean active;
}
