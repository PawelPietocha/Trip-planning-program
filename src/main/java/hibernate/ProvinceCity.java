package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

    @Entity
    @Table(name = "ProvinceCity")
    @ToString
    public class ProvinceCity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        @Getter
        @Setter
        private int id;

        @Column(name = "City")
        @Getter @Setter
        private String city;

        @Column(name = "Province")
        @Getter @Setter
        private String province;

        public ProvinceCity() {
        }

        public ProvinceCity(String city, String province) {
            this.city = city;
            this.province = province;
        }
    }
