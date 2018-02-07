package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Studios generated by hbm2java
 */
public class Studios  implements java.io.Serializable {


     private Integer id;
     private Divisions divisions;
     private String name;
     private String country;
     private Set<Franchises> franchiseses = new HashSet<Franchises>(0);

    public Studios() {
    }

	
    public Studios(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public Studios(Divisions divisions, String name, String country, Set<Franchises> franchiseses) {
       this.divisions = divisions;
       this.name = name;
       this.country = country;
       this.franchiseses = franchiseses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Divisions getDivisions() {
        return this.divisions;
    }
    
    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Set<Franchises> getFranchiseses() {
        return this.franchiseses;
    }
    
    public void setFranchiseses(Set<Franchises> franchiseses) {
        this.franchiseses = franchiseses;
    }




}


