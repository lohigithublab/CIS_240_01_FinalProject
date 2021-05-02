/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lohir
 */
public class WorkTesterTest {
    
    public WorkTesterTest() {
    }

    @Test
    public void testMain() {
        System.out.println("Orderfulfillment Test Begins");
        String[] args = null;
        Worker aWorker = new Worker();
        WorkTester.main(args);
        aWorker.run();
        System.out.println("Orderfulfillment test ends with success");
    }
    
}
