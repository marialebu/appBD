package logic;

import java.util.Date;

/**
 * Created by Alejandra on 9/12/2016.
 */
public class Patient {

    private int id;
    private String name;
    private int age;
    private Date begin;
    private Date last;
    private boolean man;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }


    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
