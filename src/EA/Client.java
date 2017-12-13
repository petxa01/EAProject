package EA;

public class Client {
    private int id;
    private String name;
    private String category;

    public Client() {

    }

    public Client(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
