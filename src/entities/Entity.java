package entities;

public class Entity {
    private String name;
    private Long weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Entity(String name, Long weight) {
        this.name = name;
        this.weight = weight;
    }

    public Entity() {
    }
}
