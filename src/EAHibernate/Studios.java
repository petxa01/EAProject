package EAHibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Studios {
    private int id;
    private String name;
    private String country;
    private Integer divisionId;
    private Collection<Franchises> franchisesById;
    private Divisions divisionsByDivisionId;

    public Studios(){

    }

    public Studios(int id){
        this.id=id;
    }

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
    @Column(name = "Country", nullable = false, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "DivisionId", nullable = true)
    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studios studios = (Studios) o;
        return id == studios.id &&
                Objects.equals(name, studios.name) &&
                Objects.equals(country, studios.country) &&
                Objects.equals(divisionId, studios.divisionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, country, divisionId);
    }

    @OneToMany(mappedBy = "studiosByStudioId")
    public Collection<Franchises> getFranchisesById() {
        return franchisesById;
    }

    public void setFranchisesById(Collection<Franchises> franchisesById) {
        this.franchisesById = franchisesById;
    }

    @ManyToOne
    @JoinColumn(name = "DivisionId", referencedColumnName = "Id")
    public Divisions getDivisionsByDivisionId() {
        return divisionsByDivisionId;
    }

    public void setDivisionsByDivisionId(Divisions divisionsByDivisionId) {
        this.divisionsByDivisionId = divisionsByDivisionId;
    }
}
