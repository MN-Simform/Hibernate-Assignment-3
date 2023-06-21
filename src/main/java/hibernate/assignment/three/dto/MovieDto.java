package hibernate.assignment.three.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDto {

    private Integer id;
    private String movieName;
    private Long movieLength;
    private String movieLang;
    private String ageCertificate;
    private LocalDate releaseDate;
    private Integer director;
}
