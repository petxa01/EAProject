package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1


import EA.Read;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static EAHibernate.HibernateTools.getSessionFactory;

/**
 * Franchises generated by hbm2java
 */
public class Franchises  implements java.io.Serializable {


     private Integer id;
     private Studios studios;
     private String name;
     private Set<Games> gameses = new HashSet<Games>(0);

    public Franchises() {
    }
    public Franchises(int id){
        this.id = id;
    }

	
    public Franchises(String name) {
        this.name = name;
    }
    public Franchises(Studios studios, String name, Set<Games> gameses) {
       this.studios = studios;
       this.name = name;
       this.gameses = gameses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Studios getStudios() {
        return this.studios;
    }
    
    public void setStudios(Studios studios) {
        this.studios = studios;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Games> getGameses() {
        return this.gameses;
    }
    
    public void setGameses(Set<Games> gameses) {
        this.gameses = gameses;
    }


    //Methods
    public static void insertFranchise() {

        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Franchises f = new Franchises();
        f.setId(1);
        f.setName(Read.String("Name: "));
        f.setStudios(new Studios(Read.Int("Studio ID: ")));
        s.save(f);
        t.commit();
        s.close();


    }

    public static void printFranchises() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Franchises ");
        List results = q.list();
        Iterator iterator = results.iterator();
        System.out.println("NAME\t|\t STUDIO\t\t |");
        System.out.println("-------------------------------------------------");
        while (iterator.hasNext()) {
            Franchises f = (Franchises) iterator.next();
            System.out.println(f.getName() + "\t\t" + f.getStudios().getName());
            System.out.println("----");

        }
        s.close();
    }

    public static void updateFranchises() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();


        Franchises f = new Franchises();
        f.setId(Read.Int("Franchise ID:"));
        f.setName(Read.String("Name: "));
        f.setStudios(new Studios(Read.Int("Studio ID: ")));
        s.update(f);
        t.commit();
        s.close();
    }

    public static void deleteFranchises() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        int id = Read.Int("Type the ID of the franchise to be deleted: ");
        Query q = s.createQuery("from Franchises where id =" +id);
        List results = q.list();
        Iterator iterator = results.iterator();
        Franchises f = (Franchises) iterator.next();
        s.delete(f);
        t.commit();
        s.close();
    }

}


