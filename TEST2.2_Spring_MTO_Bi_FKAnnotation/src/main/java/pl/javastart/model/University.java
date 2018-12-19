package pl.javastart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "UNIVERSITY")
public class University {
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "UNIVERSITY_ID")
    private long id;
 
    @Column(name = "NAME")
    private String name;
 
    @Column(name = "COUNTRY")
    private String country;
 
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Student> students;//poniewaz encja Student jest wlascicielem relacji, przez zastosowanie kaskady
    //encja student bedzie zapisana od razu kiedy zapiszemy encje uniwersytet (nie potrzebujemy StudentDao).
    //cascade zarowno u ownera jak i po stronie inverse
    //orphanRemoval usuwa encje University ktore nie beda powiazane z niczym po usunieciu odpowiedniego studenta
 
    public University() {
 
    }
 
    public University(String name, String country) {
        this.name = name;
        this.country = country;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public List<Student> getStudents() {
        return students;
    }
 
    public void setStudents(List<Student> students) {
        this.students = students;
    }
 
    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + ", country="
                + country + "]";
    }
 
}