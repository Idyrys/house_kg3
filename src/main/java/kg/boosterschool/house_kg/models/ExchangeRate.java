package kg.boosterschool.house_kg.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exchange_rate")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    double course;
    LocalDateTime startDate;
    LocalDateTime endDate;
    boolean active;
}
