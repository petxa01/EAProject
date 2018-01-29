package EAHibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Clients {
    private int id;
    private String name;
    private String category;
    private String idCard;
    private Collection<Sales> salesById;

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
    @Column(name = "Category", nullable = false, length = 45)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "IdCard", nullable = false, length = 45)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return id == clients.id &&
                Objects.equals(name, clients.name) &&
                Objects.equals(category, clients.category) &&
                Objects.equals(idCard, clients.idCard);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, category, idCard);
    }

    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Sales> getSalesById() {
        return salesById;
    }

    public void setSalesById(Collection<Sales> salesById) {
        this.salesById = salesById;
    }

}
