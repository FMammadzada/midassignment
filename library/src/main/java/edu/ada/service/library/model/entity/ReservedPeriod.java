package edu.ada.service.library.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservedPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private String bookName;

    private String dateTaken;
    private String dateDrop;

    public ReservedPeriod(int id, int userId, String bookName, String dateTaken, String dateDrop) {
        this.id = id;
        this.userId = userId;
        this.bookName = bookName;
        this.dateTaken = dateTaken;
        this.dateDrop = dateDrop;
    }

    public ReservedPeriod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getDateDrop() {
        return dateDrop;
    }

    public void setDateDrop(String dateDrop) {
        this.dateDrop = dateDrop;
    }
}
