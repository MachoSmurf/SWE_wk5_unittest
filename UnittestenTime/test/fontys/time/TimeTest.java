/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MS-Laptop
 */
public class TimeTest {
    
    Time testTime;
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        //test monday
        testTime = new Time(2017, 10, 2, 12, 30);
        DayInWeek result = testTime.getDayInWeek();
        DayInWeek expectedResult = DayInWeek.MON;
        assertEquals(expectedResult, result);
                
        //test tuesday
        testTime = new Time(2017, 10, 3, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.TUE;
        assertEquals(expectedResult, result);
        
        //test wednesday
        testTime = new Time(2017, 10, 4, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.WED;
        assertEquals(expectedResult, result);
        
        //test thursday
        testTime = new Time(2017, 10, 5, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.THU;
        assertEquals(expectedResult, result);
        
        //test friday
        testTime = new Time(2017, 10, 6, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.FRI;
        assertEquals(expectedResult, result);
        
        //test saturday
        testTime = new Time(2017, 10, 7, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.SAT;
        assertEquals(expectedResult, result);
        
        //test sunday
        testTime = new Time(2017, 10, 8, 12, 30);
        result = testTime.getDayInWeek();
        expectedResult = DayInWeek.SUN;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        testTime = new Time(2017, 10, 3, 12, 30);
        int result = testTime.getYear();
        int expectedResult = 2017;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        testTime = new Time(2017, 10, 3, 12, 30);
        int result = testTime.getMonth();
        int expectedResult = 10;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        testTime = new Time(2017, 10, 3, 12, 30);
        int result = testTime.getDay();
        int expectedResult = 3;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        testTime = new Time(2017, 10, 3, 12, 30);
        int result = testTime.getHours();
        int expectedResult = 12;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        testTime = new Time(2017, 10, 3, 12, 30);
        int result = testTime.getMinutes();
        int expectedResult = 30;
        assertEquals(expectedResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        //add 1 minute
        int addValue = 1;
        testTime = new Time(2017, 10, 3, 12, 30);
        ITime expectedResult = new Time(2017, 10, 3, 12, 31);
        ITime result = testTime.plus(addValue);
        assertEquals(expectedResult.getMinutes(), result.getMinutes());
        
        //add 0 minute
        addValue = 0;
        testTime = new Time(2017, 10, 3, 12, 30);
        expectedResult = new Time(2017, 10, 3, 12, 30);
        result = testTime.plus(addValue);
        assertEquals(expectedResult.getMinutes(), result.getMinutes());
        
        //add -1 minute
        addValue = -1;
        testTime = new Time(2017, 10, 3, 12, 30);
        expectedResult = new Time(2017, 10, 3, 12, 29);
        result = testTime.plus(addValue);
        assertEquals(expectedResult.getMinutes(), result.getMinutes());
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        //same date
        System.out.println("compareTo");
        ITime t = new Time(2017, 10, 3, 12, 30);
        testTime = new Time(2017, 10, 3, 12, 30);
        int expResult = 0;
        int result = testTime.compareTo(t);
        assertEquals(expResult, result);
        
        //earlier date
        t = new Time(2017, 10, 3, 12, 29);
        testTime = new Time(2017, 10, 3, 12, 30);
        expResult = -1;
        result = testTime.compareTo(t);
        assertEquals(expResult, result);        
        
        //later date
        t = new Time(2017, 10, 3, 12, 31);
        testTime = new Time(2017, 10, 3, 12, 30);
        expResult = 1;
        result = testTime.compareTo(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {      
        System.out.println("difference");
        //normal result
        Time baseTime = new Time(2017, 10, 3, 12, 31);        
        ITime otherTime = new Time(2017, 10, 3, 12, 30);
        int result = baseTime.difference(otherTime);
        int expResult = 1;
        assertEquals(expResult, result);
        
        //reverse result
        baseTime = new Time(2017, 10, 3, 12, 30);        
        otherTime = new Time(2017, 10, 3, 12, 31);
        result = baseTime.difference(otherTime);
        expResult = -1;
        assertEquals(expResult, result);
        
        //no difference
        baseTime = new Time(2017, 10, 3, 12, 30);        
        otherTime = new Time(2017, 10, 3, 12, 30);
        result = baseTime.difference(otherTime);
        expResult = 0;
        assertEquals(expResult, result);
    }
    
}
