package co.simplon.aliment.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Aliment {

    @Id
    @SequenceGenerator(name = "aliment_id_seq", sequenceName = "aliment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aliment_id_seq")
    private Long id;

    private String name;

    @ManyToOne
    private AlimentClass alimentClass;

    @Column(precision = 5, scale = 2)
    private BigDecimal energy;

    @Column(precision = 5, scale = 2)
    private BigDecimal water;

    @Column(precision = 5, scale = 2)
    private BigDecimal proteins;

    @Column(precision = 5, scale = 2)
    private BigDecimal lipids;

    @Column(precision = 5, scale = 2)
    private BigDecimal carbs;

    @Column(precision = 5, scale = 2)
    private BigDecimal sugars;

    @Column(precision = 5, scale = 2)
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
