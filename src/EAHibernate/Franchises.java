package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

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




}


