package navigator.database.models;

public class Road {
  Long id;

  double distance;


  public Road() {
  }

  public Road(Long id, double distance) {
    this.id = id;
    this.distance = distance;
  }

  public Long getid() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return "Road{" +
            "id=" + id +
            ", distance=" + distance +
            '}';
  }
}
