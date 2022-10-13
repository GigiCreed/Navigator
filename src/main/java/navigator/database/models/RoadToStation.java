package navigator.database.models;

public class RoadToStation{
    private Long id;
    private Long roadsId;
    private Long citiesId;

    public RoadToStation(){}

    public RoadToStation(Long roadsId, Long citiesId) {
        this.roadsId = roadsId;
        this.citiesId = citiesId;
    }

    public RoadToStation(Long id, Long roadsId, Long citiesId) {
        this.id = id;
        this.roadsId = roadsId;
        this.citiesId = citiesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoadsId() {
        return roadsId;
    }

    public void setRoadsId(Long roadsId) {
        this.roadsId = roadsId;
    }

    public Long getCitiesId() {
        return citiesId;
    }

    public void setCitiesId(Long citiesId) {
        this.citiesId = citiesId;
    }

    @Override
    public String toString() {
        return "RoadToStation{" +
                "id=" + id +
                ", roadsId=" + roadsId +
                ", citiesId=" + citiesId +
                '}';
    }
}
