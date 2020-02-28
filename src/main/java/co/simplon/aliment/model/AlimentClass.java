package co.simplon.aliment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AlimentClass {

    @Id
    @SequenceGenerator(name = "aliment_class_id_seq", sequenceName = "aliment_class_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aliment_class_id_seq")
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "alimentClass")
    private List<Aliment> alimentList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
