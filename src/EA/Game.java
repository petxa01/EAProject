package EA;

public class Game {
    private int id;
    private String name;
    private String genre;
    private float price;//Renombrar Prize a Price
    private int franchieId;
    //Hay que borrar Stock de la base de datos
    public Game() {

    }

    public Game(int id, String name, String genre, float price, int franchieId) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.franchieId = franchieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getFranchieId() {
        return franchieId;
    }

    public void setFranchieId(int franchieId) {
        this.franchieId = franchieId;
    }
}
