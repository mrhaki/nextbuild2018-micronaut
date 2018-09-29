package nextbuild;

import org.bson.types.ObjectId;

public class Conference {

    private ObjectId id;
    private String name;

    public Conference() {
    }

    public Conference(final String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id='" + id.toHexString() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
