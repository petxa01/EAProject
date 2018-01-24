package EAHibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Franchises {
    private int id;
    private String name;
    private Integer studioId;
    private Studios studiosByStudioId;
    private Collection<Games> gamesById;

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

    @Basic
    @Column(name = "StudioId", nullable = true)
    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franchises that = (Franchises) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(studioId, that.studioId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, studioId);
    }

    @ManyToOne
    @JoinColumn(name = "StudioId", referencedColumnName = "Id")
    public Studios getStudiosByStudioId() {
        return studiosByStudioId;
    }

    public void setStudiosByStudioId(Studios studiosByStudioId) {
        this.studiosByStudioId = studiosByStudioId;
    }

    @OneToMany(mappedBy = "franchisesByFranchiseId")
    public Collection<Games> getGamesById() {
        return gamesById;
    }

    public void setGamesById(Collection<Games> gamesById) {
        this.gamesById = gamesById;
    }
}
