package EAHibernate;
// Generated 07-feb-2018 10:21:04 by Hibernate Tools 4.3.1



/**
 * DevelopsId generated by hbm2java
 */
public class DevelopsId  implements java.io.Serializable {


     private int developerId;
     private int gameId;

    public DevelopsId() {
    }

    public DevelopsId(int developerId, int gameId) {
       this.developerId = developerId;
       this.gameId = gameId;
    }
   
    public int getDeveloperId() {
        return this.developerId;
    }
    
    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }
    public int getGameId() {
        return this.gameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DevelopsId) ) return false;
		 DevelopsId castOther = ( DevelopsId ) other; 
         
		 return (this.getDeveloperId()==castOther.getDeveloperId())
 && (this.getGameId()==castOther.getGameId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDeveloperId();
         result = 37 * result + this.getGameId();
         return result;
   }   


}

