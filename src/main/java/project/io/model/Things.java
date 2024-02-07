package project.io.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "things")
@AllArgsConstructor
public class Things {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int CountId;
    private String name;

    private String img;

    private Double price;

    private String description;

    @Column(name = "secondary_description")
    private String secondaryDescription;

    private Double length;

    private Double height;

    private Double width;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
