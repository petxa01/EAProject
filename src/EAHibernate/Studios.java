package EAHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static EAHibernate.HibernateTools.getSessionFactory;

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
    //Methods
    public static void insertStudios(String name, String country, int divisionId){
        SessionFactory sf = getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        Studios s = new Studios();
        s.setName(name);
        s.setCountry(country);
        s.setDivisionId(divisionId);
        ss.save(s);
        t.commit();

    }
    public static void printStudios(){
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Games ");
        List results = q.list();
        Iterator iterator = results.iterator();
        System.out.println("NAME\t|\t COUNTRY\t|\t DIVISION\t\t |");
        while (iterator.hasNext()){
            Studios st = (Studios) iterator.next();
            System.out.println(st.getName() + "\t\t"+st.getCountry()+"\t\t"+st.getDivisionsByDivisionId().getName());

        }
    }
    public static void updateStudios(int id, String newName, String newCountry, int newDivision){
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Studios st = new Studios(id);
        st.setName(newName);
        st.setCountry(newCountry);
        st.setDivisionId(newDivision);
        s.update(st);
        t.commit();
        s.close();
        sf.close();
    }
    public static void deleteStudios(int id){
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Studios st = new Studios(id);
        s.delete(st);
        t.commit();
        s.close();
    }
}
