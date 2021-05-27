package ro.kronsoft.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private int mark;

    @Column(name = "dateofmark")
    private Date dateOfMark;

    public Mark() {
    }

    public Mark(int id, Courses courses, Person person, int mark, Date dateOfMark) {
        this.id = id;
        this.courses = courses;
        this.person = person;
        this.mark = mark;
        this.dateOfMark = dateOfMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Courses getCourse() {
        return courses;
    }

    public void setCourse(Courses courses) {
        this.courses = courses;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getDateOfMark() {
        return dateOfMark;
    }

    public void setDateOfMark(Date dateOfMark) {
        this.dateOfMark = dateOfMark;
    }
}
