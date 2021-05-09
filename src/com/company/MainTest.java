package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    SortedLinkedList list  = new SortedLinkedList();
    @Test
    void addProduct() throws SortedADT.NotUniqueException {
       list.insert(new Product("123","lead",20));
        Assertions.assertFalse(list.isEmpty());
    }



    @Test
    void removeProduct() throws SortedADT.NotUniqueException, SortedADT.NotFoundException {
        list.insert(new Product("123","lead",20));
        list.remove(new Product("123","lead",20));
        Assertions.assertTrue(list.isEmpty());


    }

    @Test
    void removePetType() throws SortedADT.NotUniqueException, SortedADT.NotFoundException{
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new Pet("Dog"));
        tree.remove(new Pet("Dog"));
        Assertions.assertEquals(tree.getTraversals(),"tree is empty");

    }
}