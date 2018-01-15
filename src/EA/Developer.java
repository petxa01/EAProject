package EA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static EA.Tools.returnObjectList;
import static EA.Tools.sqlStmt;

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

    public static void insertDevelopers(String table){
        String idCard=Read.String("Enter the ID Card");
        String name=Read.String("Enter the name");
        String surname=Read.String("Enter the surname");
        float salary = Read.Float("Enter the salary");
        String job = Read.String("Enter the job");
        String country =Read.String("Enter the country");


        sqlStmt("Insert into "+ table +" (IdCard, Name,Surname,Salary,Job,Country) VALUES ("+idCard+","+name+","+surname+","+salary+","+job+","+country+")", false);
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

    public static ArrayList<Object> selectDevelopers(ResultSet res, boolean exist) {
        ArrayList<Object> objectList = new ArrayList();
        try {

            while (res.next()) {
                exist = true;
                Developer developer = new Developer(
                        Integer.parseInt(res.getString(1)),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        Float.parseFloat(res.getString(5)),
                        res.getString(6),
                        res.getString(7)
                );
                objectList.add(developer);

            }
            res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        return returnObjectList(objectList, exist);
    }
}
