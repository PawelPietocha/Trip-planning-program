package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Distance")
@ToString
public class Distance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter
    @Setter
    private int id;

    @Column(name = "City1")
    @Getter @Setter
    private String city1;

    @Column(name = "City2")
    @Getter @Setter
    private String city2;

    @Column(name = "Distance")
    @Getter @Setter
    private double distance;

    public Distance() {
    }

    public Distance(String city1, String city2, double distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }
}
