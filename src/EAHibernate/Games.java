package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1


import EA.Read;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static EAHibernate.HibernateTools.getSessionFactory;

/**
 * Games generated by hbm2java
 */
public class Games implements java.io.Serializable {


    private Integer id;
    private Franchises franchises;
    private String name;
    private String genre;
    private float price;
    private Set<Develops> developses = new HashSet<Develops>(0);
    private Set<Sales> saleses = new HashSet<Sales>(0);

    public Games() {
    }


    public Games(String name, String genre, float price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Games(Franchises franchises, String name, String genre, float price, Set<Develops> developses, Set<Sales> saleses) {
        this.franchises = franchises;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.developses = developses;
        this.saleses = saleses;
    }

    public Games(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public Games(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Franchises getFranchises() {
        return this.franchises;
    }

    public void setFranchises(Franchises franchises) {
        this.franchises = franchises;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Develops> getDevelopses() {
        return this.developses;
    }

    public void setDevelopses(Set<Develops> developses) {
        this.developses = developses;
    }

    public Set<Sales> getSaleses() {
        return this.saleses;
    }

    public void setSaleses(Set<Sales> saleses) {
        this.saleses = saleses;
    }


    //Methods
    public static void insertGame() {

        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Games g = new Games();
        g.setId(1);
        g.setName(Read.String("Name: "));
        g.setGenre(Read.String("Genre: "));
        g.setPrice(Read.Float("Price: "));
        g.setFranchises(new Franchises(Read.Int("Franchise ID: ")));
        s.save(g);
        t.commit();

    }

    public static void printGames() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Games ");
        List results = q.list();
        Iterator iterator = results.iterator();
        System.out.println("NAME\t|\t GENRE\t|\t PRICE\t|\t FRANCHISE\t\t |");
        System.out.println("-------------------------------------------------");
        while (iterator.hasNext()) {
            Games game = (Games) iterator.next();
            System.out.println(game.getName() + "\t\t" + game.getGenre() + "\t\t" + game.getFranchises().getName());
            System.out.println("----");

        }
    }

    public static void updateGames() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();


        Games g = new Games();
        g.setId(Read.Int("Game ID:"));
        g.setName(Read.String("Name: "));
        g.setGenre(Read.String("Genre: "));
        g.setPrice(Read.Float("Price: "));
        g.setFranchises(new Franchises(Read.Int("Franchise ID: ")));
        s.update(g);
        t.commit();
        s.close();
        sf.close();
    }

    public static void deleteGames() {
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        int id = Read.Int("Type the ID of the game to be deleted: ");
        Query q = s.createQuery("from Games where id =" +id);
        List results = q.list();
        Iterator iterator = results.iterator();
        Games g = (Games) iterator.next();
        s.delete(g);
        t.commit();
        s.close();
    }


}




