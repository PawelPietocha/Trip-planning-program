package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Weather")
@ToString
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter @Setter
    private int id;

    @Column(name = "City")
    @Getter @Setter
    private String city;

    @Column(name = "Temperature")
    @Getter @Setter
    private String temperature;

    @Column(name = "Humidity")
    @Getter @Setter
    private int humidity;

    @Column(name = "Clouds")
    @Getter @Setter
    private int Clouds;

    @Column(name = "Pressure")
    @Getter @Setter
    private int pressure;

    @Column(name = "Description")
    @Getter @Setter
    private String description;

    @Column(name = "Date")
    @Getter @Setter
    private Date date;



    public Weather(){

    }

    public Weather(String city, String temperature, int humidity, int clouds, int pressure, String description, Date date) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        Clouds = clouds;
        this.pressure = pressure;
        this.description = description;
        this.date = date;
    }

}
