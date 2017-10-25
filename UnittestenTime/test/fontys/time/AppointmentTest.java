/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
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
public class AppointmentTest 
{
    
    ITime bt;
    ITime et;
    ITimeSpan afspraak;
    Appointment appointment;
    Contact Imke;
    Contact Raymond;
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        bt = new Time(2017, 11, 11, 10, 00);
        et = new Time(2017, 11, 11, 11, 00);
        afspraak = new TimeSpan(bt, et);
        appointment = new Appointment("Afspraak",afspraak);
        Imke = new Contact("Imke");
        Raymond = new Contact("Raymond");
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testConstructor() 
    {
        System.out.println("testConstructor");
        
        // Appointment mag toegevoegd worden.
        try
        {
            bt = new Time(2017, 11, 11, 10, 00);
            et = new Time(2017, 11, 11, 11, 00);
            afspraak = new TimeSpan(bt, et);
            appointment = new Appointment("Afspraak 1", afspraak);            
        }
        catch(IllegalArgumentException ex)
        {
            fail("Appointment zou toegevoegd moeten worden.");
        }
        
        // Appointment mag niet toegevoegd worden.
        try
        {
            bt = new Time(2017, 11, 11, 11, 00);
            et = new Time(2017, 11, 11, 10, 00);
            afspraak = new TimeSpan(bt, et);
            appointment = new Appointment("test subject", afspraak);   
            
            throw new IllegalArgumentException("Appointment kan niet toegevoegd worden. et is eerder dan bt.");
        }
        catch(IllegalArgumentException ex)
        {
            assertTrue(true);
        }
    }
        /**
     * Test of getSubject method, of class Appointment.
     */
    
    @Test
    public void testGetSubject()
    {
        System.out.println("testGetSubject");
        
        String expResult = "Afspraak";
        String result = appointment.getSubject();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        System.out.println("getTimeSpan");
        
        // test 1
        ITime expResultBt = afspraak.getBeginTime();
        ITime expResultEt = afspraak.getEndTime();
        
        ITime resultBt = appointment.getTimeSpan().getBeginTime();
        ITime resultEt = appointment.getTimeSpan().getEndTime();
        
        assertEquals(expResultBt, resultBt);
        assertEquals(expResultEt, resultEt);
        
        // test 2
        
        bt = new Time(2017, 11, 20, 17, 00);
        et = new Time(2017, 11, 20, 18, 00);
        afspraak = new TimeSpan(bt, et);
        appointment = new Appointment("Afspraak 2", afspraak);
        
        ITime expResultBt2 = afspraak.getBeginTime();
        ITime expResultEt2 = afspraak.getEndTime();
        
        ITime resultBt2 = appointment.getTimeSpan().getBeginTime();
        ITime resultEt2 = appointment.getTimeSpan().getEndTime();
        
        assertEquals(expResultBt2, resultBt2);
        assertEquals(expResultEt2, resultEt2);
        
        
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees() {
        System.out.println("testInvitees");
        
        // contacten toevoegen
        appointment.addContact(Imke);
        appointment.addContact(Raymond);
        
        //contacten verzamelen
        Iterator<Contact> i = appointment.invitees();
        
        String expResultCI = Imke.getName();
        String expResultCR = Raymond.getName();
        
        String resultCI = i.next().getName();
        String resultCR = i.next().getName();
        
        assertEquals(expResultCI, resultCI);
        assertEquals(expResultCR, resultCR);
        
        
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("testAddContact");
        
        // contact mag toegevoegd worden
        try
        {
            appointment.addContact(Imke);
            appointment.addContact(Raymond);
        }
        catch(IllegalArgumentException ex)
        {
            fail("Contacten zouden toegevoegd mogen worden.");
        }
        
        // contact mag niet toegevoegd worden.
        try
        {
            appointment.addContact(Imke);
            appointment.addContact(Raymond);
            
            throw new IllegalArgumentException("Contacten kunnen niet toegevoegd worden. Deze zijn niet uniek. ");
        }
        catch(IllegalArgumentException ex)
        {
            assertTrue(true);
        }
   
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("testRemoveContact");
        
        appointment.addContact(Imke);
        appointment.addContact(Raymond);
        
        // contact kan verwijdert worden.
        try
        {
            appointment.removeContact(Imke);
        }
        catch(IllegalArgumentException ex)
        {
            fail("Contact zou verwijderd mogen worden.");
        }
        
        // contact kan NIET verwijdert worden.
        try
        {
            appointment.removeContact(Imke);
            throw new IllegalArgumentException ("Contact kan niet verwijderd worden. Contact bestaat niet.");
        }
        catch(IllegalArgumentException ex)
        {
            assertTrue(true);
        }
        
           
        
   
    }

    /**
     * Test of getBeginTime method, of class Appointment.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        Appointment instance = null;
        ITime expResult = null;
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class Appointment.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Appointment instance = null;
        ITime expResult = null;
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Appointment.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Appointment instance = null;
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeginTime method, of class Appointment.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        ITime beginTime = null;
        Appointment instance = null;
        instance.setBeginTime(beginTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndTime method, of class Appointment.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = null;
        Appointment instance = null;
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Appointment.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 0;
        Appointment instance = null;
        instance.move(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLengthWith method, of class Appointment.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 0;
        Appointment instance = null;
        instance.changeLengthWith(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPartOf method, of class Appointment.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        Appointment instance = null;
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unionWith method, of class Appointment.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        Appointment instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionWith method, of class Appointment.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        Appointment instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
