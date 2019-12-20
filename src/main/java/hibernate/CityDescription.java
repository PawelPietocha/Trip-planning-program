package hibernate;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CityDescription")
@ToString
public class CityDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private int id;

    @Column(name = "City")
    @Getter @Setter
    private String city;

    @Column(name = "Homepage")
    @Getter @Setter
    private String homepage;

    @Column(name = "Population")
    @Getter @Setter
    private double population;






    public CityDescription() {
    }

    public CityDescription(String city, String homepage, double population) {
        this.city = city;
        this.homepage = homepage;
        this.population = population;



    }
}
