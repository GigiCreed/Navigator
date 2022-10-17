package navigator.database.models;

public class RoadToStation{
    private Long id;
    private Long roadsId;
    private Long stationsId;

    public RoadToStation(){}

    public RoadToStation(Long roadsId, Long stationsId) {
        this.roadsId = roadsId;
        this.stationsId = stationsId;
    }

    public RoadToStation(Long id, Long roadsId, Long stationsId) {
        this.id = id;
        this.roadsId = roadsId;
        this.stationsId = stationsId;
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

    public Long getStationsId() {
        return stationsId;
    }

    public void setStationsId(Long stationsId) {
        this.stationsId = stationsId;
    }

    @Override
    public String toString() {
        return "RoadToStation{" +
                "id=" + id +
                ", roadsId=" + roadsId +
                ", stationsId=" + stationsId +
                '}';
    }
}
