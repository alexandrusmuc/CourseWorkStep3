package com.company;

import java.util.LinkedList;

public class Pet implements Comparable{
    private String petType;
    private SortedLinkedList products = new SortedLinkedList();

    public Pet(String petType) {
        this.petType = petType;
    }

    public String getPetType() {
        return petType;
    }

    @Override
    public int compareTo(Object o) {
        return this.getPetType().compareToIgnoreCase(((Pet)o).getPetType());
    }

    public SortedLinkedList getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Pet type: " + this.petType + "\n" + "Products:\n" +  this.products;
    }


}
