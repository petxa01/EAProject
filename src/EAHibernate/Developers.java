package EAHibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Developers {
    private int id;
    private String idCard;
    private String name;
    private String surname;
    private double salary;
    private String job;
    private String country;
    private Collection<Develops> developsById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdCard", nullable = false, length = 45)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
    @Column(name = "Surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Salary", nullable = false, precision = 0)
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "Job", nullable = false, length = 45)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "Country", nullable = false, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developers that = (Developers) o;
        return id == that.id &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(idCard, that.idCard) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(job, that.job) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idCard, name, surname, salary, job, country);
    }

    @OneToMany(mappedBy = "developersByDeveloperId")
    public Collection<Develops> getDevelopsById() {
        return developsById;
    }

    public void setDevelopsById(Collection<Develops> developsById) {
        this.developsById = developsById;
    }
}
