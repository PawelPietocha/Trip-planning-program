package Weather;

public class Voivodship {
    String name;
    String temp;

    public Voivodship() {
    }

    public Voivodship(String name, String temp) {
        this.name = name;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Voivodship{" +
                "name='" + name + '\'' +
                ", temp=" + temp +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
