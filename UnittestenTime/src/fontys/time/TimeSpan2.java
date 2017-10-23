/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author MS-Laptop
 */
public class TimeSpan2 implements ITimeSpan
{

    private ITime bt;
    private ITime et;
    private long duration;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param et 
     */
    public TimeSpan2(ITime bt, ITime et)
    {
        if (bt.compareTo(et) <= 0)
        {
            throw new IllegalArgumentException("bt must be before et");
        }
        
        this.bt = bt;
        this.et = et;
    }

    @Override
    public ITime getBeginTime() {
        return this.bt;
    }

    @Override
    public ITime getEndTime() {
        return this.et;
    }

    @Override
    public int length() {
        return et.difference(bt);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (et.difference(beginTime) <= 0)
        {
            throw new IllegalArgumentException("BT must be before ET");
        }
        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (bt.difference(endTime) >= 0)
        {
            throw new IllegalArgumentException("ET must be after BT");
        }
        et = endTime;
    }

    /**
     * the begin and end time of this time span will be moved up both with [minutes]
     * minutes
     * @param minutes (a negative value is allowed)
     */
    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = et.plus(minutes);
    }

    /**
     * the end time of this time span will be moved up with [minutes] minutes
     * @param minutes  minutes + length of this period must be positive  
     */
    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0)
        {
            throw new IllegalArgumentException("Minutes must be positive");
        }
        et = et.plus(minutes);
    }

    /**
     * 
     * @param timeSpan
     * @return true if all moments within this time span are included within [timeSpan], 
     * otherwise false
     */
    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        ITime tsBeginTime = timeSpan.getBeginTime();
        ITime tsEndTime = timeSpan.getEndTime();
        
        return bt.compareTo(tsBeginTime) < 1 && et.compareTo(tsEndTime) > -1;
    }

    
    /**
     * 
     * @param timeSpan
     * @return if this time span and [timeSpan] are consecutive or possess a
     * common intersection, then the smallest time span ts will be returned, 
     * whereby this time span and [timeSpan] are part of ts, 
     * otherwise null will be returned 
     */
    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        
        ITime tsBt = timeSpan.getBeginTime();
        ITime tsEt = timeSpan.getEndTime();        
                
        if (tsEt.compareTo(bt) >= 0 || tsBt.compareTo(et) <= 0) {
            return null;
        }

        ITime begintime, endtime;
        if (tsBt.compareTo(bt) > 0) {
            begintime = bt;
        } else {
            begintime = tsBt;
        }

        if (tsEt.compareTo(et) < 0) {
            endtime = et;
        } else {
            endtime = tsEt;
        }

        return new TimeSpan(begintime, endtime);
    }

    
    /**
     * 
     * @param timeSpan
     * @return the largest time span which is part of this time span 
     * and [timeSpan] will be returned; if the intersection is empty null will 
     * be returned
     */
    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        ITime tsBt1 = timeSpan.getBeginTime();
        ITime tsEt1 = timeSpan.getEndTime(); 
   
        if (tsEt1.compareTo(bt) >= 0 || tsBt1.compareTo(et) <= 0) {
            return null;
        }

        ITime begintime, endtime;
        if (tsBt1.compareTo(bt) < 0) {
            begintime = bt;
        } else {
            begintime = tsBt1;
        }

        if (tsEt1.compareTo(et) > 0) {
            endtime = et;
        } else {
            endtime = tsEt1;
        }

        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }

        return new TimeSpan(begintime, endtime);
    }
    
}
