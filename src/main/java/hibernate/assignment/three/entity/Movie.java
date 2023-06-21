package hibernate.assignment.three.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String movieName;
    private Long movieLength;
    private String movieLang;
    private String ageCertificate;
    private LocalDate releaseDate;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "director_id",
            referencedColumnName = "id"
    )
    @JsonBackReference
    private Director director;
}
