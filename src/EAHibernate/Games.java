package EAHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;

import java.util.List;
import java.util.Objects;


import org.hibernate.query.Query;
import static EAHibernate.HibernateTools.getSessionFactory;

@Entity
public class Games {
    private int id;
    private String name;
    private String genre;
    private double price;
    private Integer franchiseId;
    private Collection<Develops> developsById;
    private Franchises franchisesByFranchiseId;
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
    @Column(name = "Genre", nullable = false, length = 45)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "FranchiseId", nullable = true)
    public Integer getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Integer franchiseId) {
        this.franchiseId = franchiseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id &&
                Double.compare(games.price, price) == 0 &&
                Objects.equals(name, games.name) &&
                Objects.equals(genre, games.genre) &&
                Objects.equals(franchiseId, games.franchiseId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, genre, price, franchiseId);
    }

    @OneToMany(mappedBy = "gamesByGameId")
    public Collection<Develops> getDevelopsById() {
        return developsById;
    }

    public void setDevelopsById(Collection<Develops> developsById) {
        this.developsById = developsById;
    }

    @ManyToOne
    @JoinColumn(name = "FranchiseId", referencedColumnName = "Id")
    public Franchises getFranchisesByFranchiseId() {
        return franchisesByFranchiseId;
    }

    public void setFranchisesByFranchiseId(Franchises franchisesByFranchiseId) {
        this.franchisesByFranchiseId = franchisesByFranchiseId;
    }

    @OneToMany(mappedBy = "gamesByGameId")
    public Collection<Sales> getSalesById() {
        return salesById;
    }

    public void setSalesById(Collection<Sales> salesById) {

        this.salesById = salesById;
    }

    //Methods
    public static void insertGame(String name, String genre, Float price, int fid){
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Games g = new Games();
        g.setName(name);
        g.setGenre(genre);
        g.setPrice(price);
        g.setFranchiseId(fid);
        s.save(g);
        t.commit();

    }
    public static void printGames(){
        SessionFactory sf = getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Games ");
        List results = q.list();
        Iterator iterator = results.iterator();
        System.out.println("NAME\t|\t GENRE\t|\t PRICE\t|\t FRANCHISE\t\t |");
        while (iterator.hasNext()){
            Games game = (Games) iterator.next();
            System.out.println(game.getName() + "\t\t"+game.getGenre()+"\t\t"+game.franchisesByFranchiseId.getName());

        }
    }
    
}
