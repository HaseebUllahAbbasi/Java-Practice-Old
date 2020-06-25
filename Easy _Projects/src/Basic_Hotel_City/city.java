public class city
{
    String name;
    String country;
    long populaion;
    String longitude,latitude;
    city(String name,String country,String latitude, String longitude,long populaion)
    {
        this.name = name;
        this.country = country;
        this.populaion= populaion;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "city{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", populaion=" + populaion +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulaion() {
        return populaion;
    }

    public void setPopulaion(long populaion) {
        this.populaion = populaion;
    }

}
