package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1



/**
 * Develops generated by hbm2java
 */
public class Develops  implements java.io.Serializable {


     private DevelopsId id;
     private Developers developers;
     private Games games;
     private byte finished;

    public Develops() {
    }

    public Develops(DevelopsId id, Developers developers, Games games, byte finished) {
       this.id = id;
       this.developers = developers;
       this.games = games;
       this.finished = finished;
    }
   
    public DevelopsId getId() {
        return this.id;
    }
    
    public void setId(DevelopsId id) {
        this.id = id;
    }
    public Developers getDevelopers() {
        return this.developers;
    }
    
    public void setDevelopers(Developers developers) {
        this.developers = developers;
    }
    public Games getGames() {
        return this.games;
    }
    
    public void setGames(Games games) {
        this.games = games;
    }
    public byte getFinished() {
        return this.finished;
    }
    
    public void setFinished(byte finished) {
        this.finished = finished;
    }




}


