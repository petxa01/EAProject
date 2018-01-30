package EAHibernate;

import EA.Read;
import org.hibernate.*;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.*;

import static EAHibernate.HibernateTools.getSessionFactory;

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

    public static void insertFranchises(int idFranchise, String nombre, int studioId) {
        SessionFactory sf = getSessionFactory();
        Session sesioa = sf.openSession();
        Transaction tx = sesioa.beginTransaction();
        Franchises f = new Franchises();
        f.setId(idFranchise);
        f.setName(nombre);
        f.setStudioId(studioId);
        sesioa.save(f);
        tx.commit();

    }

    public static void selectFranchises() throws ClassNotFoundException, SQLException {
        Session ses;

        try {
            SessionFactory sf = getSessionFactory();
            ses = sf.openSession();
            String e = "from Franchises";
            Query q = ses.createQuery(e);
            List results = q.list();
            Iterator iterator = results.iterator();
            System.out.println("Name\t\t\t\tStudio ID");
            while (iterator.hasNext()) {
                Franchises fr = (Franchises) iterator.next();
                System.out.println(fr.getName() + "\t\t\t\t" + fr.getStudioId());
            }
        } catch (HibernateException ex) {
            System.out.println("Exception ocurred: " + ex.getMessage());
        }

    }
    void updatefranchises(Integer newId, String newName, Integer newStudioId) {
        SessionFactory sf = getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();
        int id= Read.Int("Enter the Id of the franchise you want to update");
        Franchises fr = new Franchises();
        fr.setStudioId(newId);
        fr.setName(newName);
        fr.setStudioId(newStudioId);

        sesion.update(fr);
        tx.commit();
        sesion.close();
        sf.close();

    }
    public static void deleteFranchises(int idPueblos) {
        SessionFactory sf = getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();

        //Pueblos objeto_pueblos = new Pueblos(idPueblos);
        //sesion.delete(objeto_pueblos);//delete egiten du
        System.out.println("Erregistroa ezabatua izan da");

        tx.commit();
        sesion.close();
        //sesionfact.close();
    }
}
