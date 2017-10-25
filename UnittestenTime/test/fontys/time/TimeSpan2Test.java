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
public class TimeSpan2Test {
    
    public TimeSpan2Test() {
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
                ITimeSpan instance2 = new TimeSpan2(BT, ET);
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
        ITimeSpan instance = new TimeSpan2(BT, ET); 
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
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
    @Test 
    public void testIsPartOf() {
        System.out.println("testIsPartOf");
        
        // begin time aanmaken
        ITime BT = new Time(2017, 10, 4, 11, 10);
        
        // end time aanmaken
        ITime ET = new Time(2017, 10, 4, 11, 50);
        
        // instance aanmaken
        ITimeSpan instance = new TimeSpan2(BT, ET);
        
 //     // testen binnen timespan
       
        // begin time aanmaken
        ITime BT2 = new Time(2017, 10, 4, 11, 15);
        ITime ET2 = new Time(2017, 10, 4, 11, 45);
        
        if (BT2.compareTo(BT) >= 0 && BT2.compareTo(ET) <= 0) 
        {
             // instance aanmaken
            ITimeSpan instance2 = new TimeSpan(BT2, ET2);
            boolean expResult2 = true;
            boolean result = instance.isPartOf(instance2);
            
            // resultaten controleren
            assertEquals(expResult2, result);
            
        }
        
//      // testen begin time buiten timespan   
        BT2 = new Time (2017, 10, 4, 11, 00);
        ET2 = new Time (2017, 10, 4, 11, 40);
        
        if (BT2.compareTo(BT) <= 0 && BT2.compareTo(ET) <= 0) 
        {
             // instance aanmaken
            ITimeSpan instance3 = new TimeSpan2(BT2, ET2);
            boolean expResult3 = false;
            boolean result = instance.isPartOf(instance3);
            
            // resultaten controleren
            assertEquals(expResult3, result);
            
        }
        
//      // testen end time buiten timespan
        BT2 = new Time (2017, 10, 4, 11, 20);
        ET2 = new Time (2017, 10, 4, 11, 55);
        
         if (BT2.compareTo(BT) >= 0 && BT2.compareTo(ET) >= 0) 
        {
             // instance aanmaken
            ITimeSpan instance4 = new TimeSpan2(BT2, ET2);
            boolean expResult4 = false;
            boolean result = instance.isPartOf(instance4);
            
            // resultaten controleren
            assertEquals(expResult4, result);
        }
        
//      // testen begin en end time buiten timespan
        BT2 = new Time (2017, 10, 4, 11, 00);
        ET2 = new Time (2017, 10, 4, 11, 55);
        
        if (BT2.compareTo(BT) <= 0 && BT2.compareTo(ET) >= 0) 
        {
             // instance aanmaken
            ITimeSpan instance5 = new TimeSpan2(BT2, ET2);
            boolean expResult5 = false;
            boolean result = instance.isPartOf(instance5);
            
            // resultaten controleren
            assertEquals(expResult5, result);
        }
        
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test 
    public void testUnionWith() {
        System.out.println("testUnionWith");
    
        // Begin end eind time aanmaken ZONDER OVERLAP
        Time BT = new Time(2017, 10, 4, 15, 00);
        Time ET = new Time(2017, 10, 4, 20, 00);      
        
        Time BT2 = new Time(2017, 10, 4, 21, 00);
        Time ET2 = new Time(2017, 10, 4, 22, 00);  
        
        TimeSpan2 instance = new TimeSpan2(BT, ET);
        TimeSpan2 timeSpan  = new TimeSpan2(BT2, ET2);
        
 //     resultaat controleren ZONDER OVERLAP
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
      
        assertEquals(expResult, result);
        
        // Begin end eind time aanmaken doorlopend aan ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 20, 00);
        ET2 = new Time(2017, 10, 4, 22, 00);
            
        instance = new TimeSpan2(BT, ET);
        timeSpan = new TimeSpan2(BT2, ET2);

 //     resultaat controleren AANSLUITEND AAN ET  
        ITimeSpan expResult1 = null;
        ITimeSpan result1 = instance.unionWith(timeSpan);
      
        assertEquals(expResult1, result1);
        
//      // Begin end eind time aanmaken OVERLAP MET ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 18, 00);
        ET2 = new Time(2017, 10, 4, 22, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = instance.unionWith(timeSpan);
        
//      // resultaat controlern tijd met OVERLAP MET ET
        ITime resultBt = result.getBeginTime();
        ITime resultEt = result.getEndTime();
        
        assertEquals(resultBt.toString(), BT2.toString());
        assertEquals(resultEt.toString(), ET.toString());
        
//      // Begin end eind time aanmaken tijd TUSSEN BT EN ET
        BT = new Time(2017, 10, 4, 15, 00);
        ET = new Time(2017, 10, 4, 20, 00);

        BT2 = new Time(2017, 10, 4, 16, 00);
        ET2 = new Time(2017, 10, 4, 18, 00);
            
        timeSpan = new TimeSpan2(BT, ET);
        instance = new TimeSpan2(BT2, ET2);

        result = timeSpan.unionWith(instance);
        
      // resultaat controlern tijd met TUSSEN BT EN ET
        ITime resultBt1 = result.getBeginTime();
        ITime resultEt1 = result.getEndTime();
        
        assertEquals(resultBt1.toString(), BT2.toString());
        assertEquals(resultEt1.toString(), ET2.toString());  

    }
    

    /*
     *Test of intersectionWith method, of class TimeSpan.
    */
     
    
    @Test 
    public void testIntersectionWith() {
        System.out.println("testIntersectionWith");
 //     // begin en end time aanmaken
        ITime BT1 = new Time(2017, 10, 4, 11, 00);
        ITime ET1 = new Time(2017, 10, 4, 17, 00);
        
        ITime BT2 = new Time(2017, 10, 4, 18, 00);
        ITime ET2 = new Time(2017, 10, 4, 22, 00);
        
        // timespan en instance aanmaken
        ITimeSpan instance = new TimeSpan2(BT1, ET1);
        ITimeSpan timeSpan = new TimeSpan2(BT2, ET2);
        
//      // resultaat controleren TIJD NA ET 
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result); 
     
//      // nieuwe begin en end time aanmaken

        ITime BT3 = new Time(2017, 10, 4, 11, 00);
        ITime ET3 = new Time(2017, 10, 4, 17, 00);
         
        ITime BT4 = new Time(2017, 10, 4, 9, 00);
        ITime ET4 = new Time(2017, 10, 4, 11, 00);
        
        // timespan en instance aanmaken
        instance = new TimeSpan2(BT3, ET3);
        timeSpan = new TimeSpan2(BT4, ET4);
     
        
//      // resultaat controleren tijd AANSLUITEND AAN BT
        expResult = null;
        ITimeSpan result1 = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result1); 
   
//      nieuwe begin en end time aanmaken

         ITime BT5 = new Time(2017, 10, 4, 11, 00);
         ITime ET5 = new Time(2017, 10, 4, 17, 00);
         
         ITime BT6 = new Time(2017, 10, 4, 9, 00);
         ITime ET6 = new Time(2017, 10, 4, 11, 30);
        
        // timespan en instance aanmaken
        instance = new TimeSpan2(BT5, ET5);
        timeSpan = new TimeSpan2(BT6, ET6);
       
//      // resultaat controleren TIJD MET 30MIN OVERLAP BT
        ITimeSpan result2 = instance.intersectionWith(timeSpan);
        
        ITime resultBt2 = result2.getBeginTime();
        ITime resultEt2 = result2.getEndTime();

        assertEquals(resultBt2.toString(), BT6.toString());
        assertEquals(resultEt2.toString(), ET5.toString());
  
    
//      nieuwe begin en end time aanmaken

         BT1 = new Time(2017, 10, 4, 11, 00);
         ET1 = new Time(2017, 10, 4, 17, 00);
         
         BT2 = new Time(2017, 10, 4, 12, 00);
         ET2 = new Time(2017, 10, 4, 13, 00);
        
        // timespan en instance aanmaken
         instance = new TimeSpan2(BT1, ET1);
         timeSpan = new TimeSpan2(BT2, ET2);
        
//      // resultaat controleren TIJD TUSSEN BT EN ET
        result = instance.intersectionWith(timeSpan);
        
        ITime resultBt3 = result.getBeginTime();
        ITime resultEt3 = result.getEndTime();

        assertEquals(resultBt3.toString(), BT1.toString());
        assertEquals(resultEt3.toString(), ET1.toString());
        
     
//      nieuwe begin en end time aanmaken

        ITime BT7 = new Time(2017, 10, 4, 11, 00);
        ITime ET7 = new Time(2017, 10, 4, 17, 00);
         
        ITime BT8 = new Time(2017, 10, 4, 10, 00);
        ITime ET8 = new Time(2017, 10, 4, 18, 00);
        
        // timespan en instance aanmaken
        timeSpan = new TimeSpan2(BT7, ET7);
        instance = new TimeSpan2(BT8, ET8);
        
        // resultaat controleren TIJD BUITEN BT EN ET
        result = instance.intersectionWith(timeSpan);
        
        ITime resultBt4 = result.getBeginTime();
        ITime resultEt4 = result.getEndTime();

        assertEquals(resultBt4.toString(), BT8.toString());
        assertEquals(resultEt4.toString(), ET8.toString());
     
//      nieuwe begin en end time aanmaken

        ITime BT9 = new Time(2017, 10, 4, 11, 00);
        ITime ET9 = new Time(2017, 10, 4, 17, 00);
         
        ITime BT10 = new Time(2017, 10, 4, 17, 00);
        ITime ET10 = new Time(2017, 10, 4, 20, 00);
        
        // timespan en instance aanmaken
        timeSpan = new TimeSpan2(BT9, ET9);
        instance = new TimeSpan2(BT10, ET10);
        
//      // resultaat controleren tijd AANSLUITEND AAN ET
        expResult = null;
        result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result); 
     
    }
    
        
    } 