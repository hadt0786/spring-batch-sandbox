package org.spring.batch.infrastructure.model;

/**
 * Created by iurii.dziuban on 13.07.2016.
 */
public class Transaction {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
