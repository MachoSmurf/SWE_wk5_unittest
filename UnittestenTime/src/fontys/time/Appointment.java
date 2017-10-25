/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;
import java.util.ArrayList;
import java.util.Iterator;



/**
 *
 * @author Adaline
 */
public class Appointment implements ITimeSpan {
    
    private String subject;
    private ITimeSpan timeSpan;
    private ArrayList<Contact> invitees;
    
    /**
     * Constructor
     * @param subject string, mag empty string zijn
     * @param timeSpan ITimespan, moet later zijn dan de huidige datum
     */
        
    
    public Appointment(String subject, ITimeSpan timeSpan) {
        this.subject = subject;
        this.timeSpan = timeSpan;
    }

    /**
     * getSubject
     * Geeft subject terug
     * @return subject String
     */
    public String getSubject()
    {
        return null;
    }
    
    /**
     * getTimeSpan
     * Geeft timeSpan terug
     * @return timeSpan ITimeSpan.
     */
    
    public ITimeSpan getTimeSpan()
    {
        return timeSpan;
    }
    
    /**
     * invitees
     * Geeft het volgende object van invitees.
     * @return het volgende Contact in invitees.
     */
    
    public Iterator<Contact> invitees()
    {
        return null;
    }
    
    /**
     * addContact
     * voegt contact toe aan Appointment. Appointment wordt vervolgens ook toegevoegd aan de Contact omdat het Contact-object ook moet worden bijgewerkt. 
     * @param c Contact. Contact mag niet NULL zijn, of al bestaan. Ook mag deze niet overlappen met Appointments of Contacte
     * @return boolean true als Contact is toegevoegd, anders false.
     */
    
    // LET OP addContact PROTECTED!! ZIE OPRACHT 6!!
    
    public boolean addContact(Contact c)
    {
        return true;
    }
    
    /**
     * removeContact
     * Verwijderd Contact uit Appointment.
     * @param c Contact.
     */
    
       
    public void removeContact(Contact c)
    {
        
    }
    
    
    @Override
    public ITime getBeginTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITime getEndTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int length() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEndTime(ITime endTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeLengthWith(int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
