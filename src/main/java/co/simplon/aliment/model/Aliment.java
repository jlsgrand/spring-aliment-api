package co.simplon.aliment.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Aliment {

    @Id
    @SequenceGenerator(name = "aliment_id_seq", sequenceName = "aliment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aliment_id_seq")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private AlimentClass alimentClass;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal energy;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal water;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal proteins;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal lipids;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal carbs;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal sugars;

    @NotNull
    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal fibers;

    public Aliment() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AlimentClass getAlimentClass() {
        return alimentClass;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public BigDecimal getWater() {
        return water;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public BigDecimal getLipids() {
        return lipids;
    }

    public BigDecimal getCarbs() {
        return carbs;
    }

    public BigDecimal getSugars() {
        return sugars;
    }

    public BigDecimal getFibers() {
        return fibers;
    }
}
