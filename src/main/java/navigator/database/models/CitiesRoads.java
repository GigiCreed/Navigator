package navigator.database.models;

public class CitiesRoads {
    private Long id;
    private Long roads_Id;
    private Long cities_Id;

    public CitiesRoads(){}

    public CitiesRoads(Long id, Long roads_Id, Long cities_Id) {
        this.id = id;
        this.roads_Id = roads_Id;
        this.cities_Id = cities_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoads_Id() {
        return roads_Id;
    }

    public void setRoads_Id(Long roads_Id) {
        this.roads_Id = roads_Id;
    }

    public Long getCities_Id() {
        return cities_Id;
    }

    public void setCities_Id(Long cities_Id) {
        this.cities_Id = cities_Id;
    }
}
