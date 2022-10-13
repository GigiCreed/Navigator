package navigator.database.models;

public class Stations {
    private Long id;

    private String name;

    private Long citiesId;


    public Stations() {
    }

    public Stations(String name, Long citiesId) {
        this.name = name;
        this.citiesId = citiesId;
    }

    public Stations(Long id, String name, Long citiesId) {
        this.id = id;
        this.name = name;
        this.citiesId = citiesId;
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

    public Long getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(Long citiesId) {
        this.citiesId = citiesId;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citiesId=" + citiesId +
                '}';
    }
}
