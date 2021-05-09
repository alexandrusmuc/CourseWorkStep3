package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void compareTo() {
       Product product1 = new Product("123","Lead", 20);
       Product product2 = new Product("123","lead", 70);
       Product product3 = new Product("123", "food", 20);
        Assertions.assertEquals(product1.compareTo( product2),0);
        Assertions.assertNotEquals(product1.compareTo(product3),0);

    }


}