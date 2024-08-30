package com.example.wcd.Entity;

import jakarta.persistence.*;

@Entity

@Table(name = "indexer")

public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int index_id;
    private String name;
    private String valueMin;
    private String valueMax;

    public int getIndex_id() {
        return index_id;
    }

    public void setIndex_id(int index_id) {
        this.index_id = index_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueMin() {
        return valueMin;
    }

    public void setValueMin(String valueMin) {
        this.valueMin = valueMin;
    }

    public String getValueMax() {
        return valueMax;
    }

    public void setValueMax(String valueMax) {
        this.valueMax = valueMax;
    }

}

