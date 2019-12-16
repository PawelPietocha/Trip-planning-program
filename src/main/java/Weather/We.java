package Weather;

import java.util.Date;

public class We {
    private int id;
    private String city;
    private float temperature;
    private int humidity;
    private int cloudes;
    private int pressure;
    private String description;
    private Date date;

    public We() {
    }

    public We(int id, String city, float temperature, int humidity, int cloudes, int pressure, String description, Date date) {
        this.id = id;
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cloudes = cloudes;
        this.pressure = pressure;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloudes() {
        return cloudes;
    }

    public void setCloudes(int cloudes) {
        this.cloudes = cloudes;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


