package EAHibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Divisions {
    private int id;
    private String name;
    private Collection<Studios> studiosById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Divisions divisions = (Divisions) o;
        return id == divisions.id &&
                Objects.equals(name, divisions.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "divisionsByDivisionId")
    public Collection<Studios> getStudiosById() {
        return studiosById;
    }

    public void setStudiosById(Collection<Studios> studiosById) {
        this.studiosById = studiosById;
    }
}
