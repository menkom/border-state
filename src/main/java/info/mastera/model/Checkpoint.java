package info.mastera.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

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
