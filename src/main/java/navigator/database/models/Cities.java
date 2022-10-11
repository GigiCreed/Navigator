package navigator.database.models;

public class Cities {
    private Long id;

    private String name;

    private  double latitudeX;

    private  double longitudeY;


    public Cities() {
    }

    public Cities(String name, double latitudeX, double longitudeY) {
        this.name = name;
        this.latitudeX = latitudeX;
        this.longitudeY = longitudeY;
    }

    public Cities(Long id, String name, double latitudeX, double longitudeY) {
        this.id = id;
        this.name = name;
        this.latitudeX = latitudeX;
        this.longitudeY = longitudeY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitudeX() {
        return latitudeX;
    }

    public void setLatitudeX(double latitudeX) {
        this.latitudeX = latitudeX;
    }

    public double getLongitudeY() {
        return longitudeY;
    }

    public void setLongitudeY(double longitudeY) {
        this.longitudeY = longitudeY;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitudeX=" + latitudeX +
                ", longitudeY=" + longitudeY +
                '}';
    }
}
