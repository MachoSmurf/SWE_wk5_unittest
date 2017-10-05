/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adaline
 */
public class TimeSpanTest {
    
    public TimeSpanTest() {
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
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testConstructor() 
    {
        System.out.println("testContructor");
        
        // Begin time aanmaken. 
        ITime BT = new Time(2017, 10, 4, 11, 05);
        // End time is later dan de begint time.
        ITime ET = new Time(2017, 10, 4, 11, 20);
        
        // Instance aanmaken
        try
        {
             if (ET.compareTo(BT) > 0 )
            {
                ITimeSpan instance = new TimeSpan(BT, ET);
            }
        }
        catch(IllegalArgumentException e)
        {
            fail("TimeSpan zou toegevoegd moet worden. ET is later dan BT");
        } 
      
//    
       // Begin time aanmaken. 
       ITime BT2 = new Time(2017, 10, 4, 11, 00);
       // End time aanmaken. Endtime is vroeger dan de begint time.
       ITime ET2 = new Time(2017, 10, 4, 10, 00);
        
        // Instance aanmaken
        try
        {
            if (ET2.compareTo(BT2)< 0 )
            {
                throw new IllegalArgumentException("TimeSpan mag niet toegevoegd worden. ET is vroeger dan BT");
            }
            else
            {
                ITimeSpan instance2 = new TimeSpan(BT, ET);
            }
            
        }
        catch(IllegalArgumentException e)
        {
            assertTrue(true);
        } 

    }
    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() 
    {
        System.out.println("testGetBeginTime");
        
        // Begin time aanmaken
        ITime BT = new Time (2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time (2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // BT moet gelijk zijn aan de BT die terug gegeven wordt
        ITime expResult = BT;
        ITime result = instance.getBeginTime();
        
        // resultaat controleren
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() 
    {
        System.out.println("testGetEndTime");
        
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // ET moet gelijk zijn aan de ET die teruggegeven wordt
        ITime expResult = ET;
        ITime result = instance.getEndTime();
        
        // resultaat controleren
        assertEquals(expResult, result);
       
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() 
    {
        System.out.println("testLength");
        
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET); 
        int expResult = 15;
        int result = instance.length();
        
        // resultaat controleren
        assertEquals(expResult, result);

    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("testSetBeginTime");
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // begin time aanmaken. Begin time eerder dan end time
        ITime beginTime = new Time(2017, 10, 4, 11, 35);
       
        // BT moet gelijk zijn aan de de teruggegeven begin time en eerder dan ET
        
        // setBeginTime aanroepen bij instance
        instance.setBeginTime(beginTime);
        ITime result = instance.getBeginTime();
        
        // resultaat controleren
        assertEquals(beginTime, result);
        
 //     // begin time aanmaken. Begin time later dan end time. Moet exception geven.
        ITime beginTime2 = new Time(2017, 10, 4, 11, 50);
        try
        {
            if (beginTime2.compareTo(ET)> 0) 
            {
                throw new IllegalArgumentException("Begin time is later than end time");
                
            }
            else
            {
                instance.setBeginTime(beginTime2);
            }
        }
        catch (IllegalArgumentException e)
        {
            
            assertTrue(true);
        }
              
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("testSetEndTime");
       // begin time aanmaken
       
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // end time aanmaken. End time later dan begin time
        ITime endTime2 = new Time(2017, 10, 4, 11, 40);
        
        // setEndTime aanroepen bij instance
        instance.setEndTime(endTime2);
        ITime result = instance.getEndTime();
        
        // resultaat controleren
        assertEquals(endTime2, result);
        
//      // end time aanmaken. end time eerder dan begin time. Moet exception geven.
       ITime endTime3 = new Time(2017, 10, 4, 11, 00);

       try
        {
            if (endTime3.compareTo(BT)< 0 )
            {
                throw new IllegalArgumentException("End time is eerder dan begin time");
            }
            else
            {
                instance.setBeginTime(endTime3);
            }
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }

    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("testMove");
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // minuten welke meegegeven worden met de methode
        int minutes = 10;
        
        instance.move(minutes);
        
        // controleren of de resultaten gelijk zijn

        int result = 15;
        
        Assert.assertEquals(result, instance.length());
        
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("testChangeLengthWith");
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 30);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // minuten welke meegegeven worden met de methode om de lengte van de TimeSpan te vergroten
        int minutes = 10;
        
        // methode aanroepen waarmee de lengte van TimeSpan vergroot wordt.
        instance.changeLengthWith(minutes);
        
        // Het verschil tussen BT en ET moet 25 zijn.
        int expResult = 25;
        int result = instance.length();
        
        // controleren of de resultaten gelijk zijn
        assertEquals(expResult,result );
        
//      // negatieve minuten moet een exception geven
        int minutes1 = -10;
        try
        {
            if (minutes1 < 0) 
            {
                throw new IllegalArgumentException("aantal minuten mag niet negatief getal zijn");
            } 
            else
            {
                instance.changeLengthWith(minutes1);
            }
        }
            
        catch (IllegalArgumentException e)
        {
            assertTrue(true);
        }
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test // TO DO 6-10 efficienter maken!!
    public void testIsPartOf() {
        System.out.println("testIsPartOf");
        
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 10);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 50);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan(BT, ET);
        
        // testen binnen timespan
        
        // begin time aanmaken
        ITime BT2 = new Time(2017, 10, 4, 11, 15);
        ITime ET2 = new Time(2017, 10, 4, 11, 45);
        
        // instance aanmaken
        ITimeSpan instance2 = new TimeSpan(BT2, ET2);
        
        // resultaten controleren
        boolean expResult = true;
        boolean result = instance.isPartOf(instance2);
        
        assertEquals(expResult, result);
        
//      // testen begin time buiten timespan
        BT2 = new Time (2017, 10, 4, 11, 00);
        ET2 = new Time (2017, 10, 4, 11, 40);
        
        instance2 = new TimeSpan(BT2, ET2);
        
        boolean expResult1 = false;
        boolean result1 = instance.isPartOf(instance2);
        assertEquals(expResult1, result1);
        
//      // testen end time buiten timespan
        BT2 = new Time (2017, 10, 4, 11, 20);
        ET2 = new Time (2017, 10, 4, 11, 55);
        
        instance2 = new TimeSpan(BT2, ET2);
        
        boolean expResult2 = false;
        boolean result2 = instance.isPartOf(instance2);
        assertEquals(expResult2, result2);
        
//      // testen begin en end time buiten timespan
        BT2 = new Time (2017, 10, 4, 11, 00);
        ET2 = new Time (2017, 10, 4, 11, 55);
        
        instance2 = new TimeSpan(BT2, ET2);
        
        boolean expResult3 = false;
        boolean result3 = instance.isPartOf(instance2);
        assertEquals(expResult3, result3);
        
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test // TO DO 6-10 werkt nog niet!
    public void testUnionWith() {
        System.out.println("testUnionWith");
        
        // begin en end time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 00);
        ITime ET = new Time(2017, 10, 4, 17, 00);
        
        ITime BT2 = new Time(2017, 10, 4, 18, 00);
        ITime ET2 = new Time(2017, 10, 4, 22, 00);
        
        // timespan en instance aanmaken
        ITimeSpan timeSpan = new TimeSpan(BT, ET);
        TimeSpan instance = new TimeSpan(BT2, ET2);
        
//      // resultaat controleren tijd na ET 
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result); 
        
//      // nieuwe begin en end time aanmaken

         BT = new Time(2017, 10, 4, 11, 00);
         ET = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 9, 00);
         ET2 = new Time(2017, 10, 4, 11, 00);
        
        // timespan en instance aanmaken
         timeSpan = new TimeSpan(BT, ET);
         instance = new TimeSpan(BT2, ET2);
        
//      // resultaat controleren tijd aansluitend aan BT
        ITime expResultBT = new Time(2017, 10, 4, 9, 00);
        ITime expResultET = new Time(2017, 10, 4, 17, 00);
        TimeSpan tsExp = new TimeSpan(expResultBT, expResultET);
        
        result = instance.unionWith(timeSpan);
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());
        
//      nieuwe begin en end time aanmaken

         BT = new Time(2017, 10, 4, 11, 00);
         ET = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 9, 00);
         ET2 = new Time(2017, 10, 4, 11, 30);
        
        // timespan en instance aanmaken
         timeSpan = new TimeSpan(BT, ET);
         instance = new TimeSpan(BT2, ET2);
        
//      // resultaat controleren tijd met 30 min overlap met BT
        expResultBT = new Time(2017, 10, 4, 9, 00);
        expResultET = new Time(2017, 10, 4, 17, 00);
        tsExp = new TimeSpan(expResultBT, expResultET);
        
        result = instance.unionWith(timeSpan);
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());

//      nieuwe begin en end time aanmaken

         BT = new Time(2017, 10, 4, 11, 00);
         ET = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 12, 00);
         ET2 = new Time(2017, 10, 4, 13, 00);
        
        // timespan en instance aanmaken
         timeSpan = new TimeSpan(BT, ET);
         instance = new TimeSpan(BT2, ET2);
        
//      // resultaat controleren tijd tussen BT en ET
        expResultBT = new Time(2017, 10, 4, 11, 00);
        expResultET = new Time(2017, 10, 4, 17, 00);
        tsExp = new TimeSpan(expResultBT, expResultET);
        
        result = instance.unionWith(timeSpan);
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());
        
//      nieuwe begin en end time aanmaken

         BT = new Time(2017, 10, 4, 11, 00);
         ET = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 10, 00);
         ET2 = new Time(2017, 10, 4, 18, 00);
        
        // timespan en instance aanmaken
         timeSpan = new TimeSpan(BT, ET);
         instance = new TimeSpan(BT2, ET2);
        
        // resultaat controleren tijd buiten BT en ET
         expResultBT = new Time(2017, 10, 4, 10, 00);
         expResultET = new Time(2017, 10, 4, 18, 00);
         tsExp = new TimeSpan(expResultBT, expResultET);
        
        result = instance.unionWith(timeSpan);
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());
        
//      nieuwe begin en end time aanmaken

         BT = new Time(2017, 10, 4, 11, 00);
         ET = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 17, 00);
         ET2 = new Time(2017, 10, 4, 20, 00);
        
        // timespan en instance aanmaken
         timeSpan = new TimeSpan(BT, ET);
         instance = new TimeSpan(BT2, ET2);
        
//       // resultaat controleren tijd aansluitend aan ET
         expResultBT = new Time(2017, 10, 4, 11, 00);
         expResultET = new Time(2017, 10, 4, 20, 00);
         tsExp = new TimeSpan(expResultBT, expResultET);
        
        result = instance.unionWith(timeSpan);
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());
        
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test // TO DO 6-10 werkt nog niet.
    public void testIntersectionWith() {
        System.out.println("testIntersectionWith");

        // Begin end eind time aanmaken zonder overlap
        Time BT = new Time(2017, 10, 4, 15, 00);
        Time ET = new Time(2017, 10, 4, 20, 00);        
        Time BT2 = new Time(2017, 10, 4, 21, 00);
        Time ET2 = new Time(2017, 10, 4, 22, 00);  
        
        TimeSpan timeSpan = new TimeSpan(BT, ET);
        TimeSpan instance = new TimeSpan(BT2, ET2);
        
 //     resultaat controleren zonder overlap
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        
        // Begin end eind time aanmaken doorlopend aan ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 20, 00);
        ET2 = new Time(2017, 10, 4, 22, 00);
            
        timeSpan = new TimeSpan(BT, ET);
        instance = new TimeSpan(BT2, ET2);

 //     resultaat controleren doorlopend aan ET      
        result = timeSpan.intersectionWith(instance);
        
        assertNull(result);
        
//      // Begin end eind time aanmaken overlap aan ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 18, 00);
        ET2 = new Time(2017, 10, 4, 22, 00);
            
        timeSpan = new TimeSpan(BT, ET);
        instance = new TimeSpan(BT2, ET2);

        result = timeSpan.intersectionWith(instance);
 
//      // resultaat controlern tijd met overlap met ET
        Time ExpResultBT = new Time(2017, 10, 4, 18, 00);
        Time ExpResultET = new Time(2017, 10, 4, 20, 00);
        TimeSpan tsExp = new TimeSpan(ExpResultBT, ExpResultET);
        
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());  
        
//      // Begin end eind time aanmaken tijd tussen BT en ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 16, 00);
        ET2 = new Time(2017, 10, 4, 18, 00);
            
        timeSpan = new TimeSpan(BT, ET);
        instance = new TimeSpan(BT2, ET2);

        result = timeSpan.intersectionWith(instance);
        
      // resultaat controlern tijd met tussen BT en ET
        ExpResultBT = new Time(2017, 10, 4, 16, 00);
        ExpResultET = new Time(2017, 10, 4, 18, 00);
        tsExp = new TimeSpan(ExpResultBT, ExpResultET);
        
        assertEquals(result.getBeginTime(), tsExp.getBeginTime());
        assertEquals(result.getEndTime(), tsExp.getEndTime());  
    }
    
}
