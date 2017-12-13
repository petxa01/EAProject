package EA;

public class Developer {
    private int id;
    private String idCard;
    private String name;
    private String surname;
    private float salary;
    private String job;//Cambiar en la base de datos Position por Job
    private String country;

    public Developer() {
    }

    public Developer(int id, String idCard, String name, String surname, float salary, String job, String country) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.job = job;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
