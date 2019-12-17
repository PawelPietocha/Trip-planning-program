package Weather;

public class PCity {
    private int Id;
    private String city;
    private String province;

    public PCity(int id, String city, String province) {
        Id = id;
        this.city = city;
        this.province = province;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
