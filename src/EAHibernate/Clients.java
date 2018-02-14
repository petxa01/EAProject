package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1


import EA.Client;

import java.util.HashSet;
import java.util.Set;

/**
 * Clients generated by hbm2java
 */
public class Clients  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String category;
     private String idCard;
     private Set<Sales> saleses = new HashSet<Sales>(0);

    public Clients() {
    }
    public Clients(Integer id){
        this.id=id;
    }

	
    public Clients(String name, String category, String idCard) {
        this.name = name;
        this.category = category;
        this.idCard = idCard;
    }
    public Clients(String name, String category, String idCard, Set<Sales> saleses) {
       this.name = name;
       this.category = category;
       this.idCard = idCard;
       this.saleses = saleses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getIdCard() {
        return this.idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public Set<Sales> getSaleses() {
        return this.saleses;
    }
    
    public void setSaleses(Set<Sales> saleses) {
        this.saleses = saleses;
    }




}


