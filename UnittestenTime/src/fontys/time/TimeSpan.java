/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Frank Peeters, Nico Kuijpers
 * 
 * LET OP: De klasse TimeSpan bevat enkele fouten.
 * 
 */
public class TimeSpan implements ITimeSpan {

    /* class invariant: 
     * A stretch of time with a begin time and end time.
     * The end time is always later then the begin time; the length of the time span is
     * always positive
     * 
     */
    private ITime bt, et;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param et 
     */
    public TimeSpan(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.et = et;
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return et;
    }

    @Override
    public int length() {
        return et.difference(bt);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (beginTime.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.compareTo(bt) >= 0) {
            throw new IllegalArgumentException("end time "
                    + et + " must be later then begin time " + bt);
        }

        et = endTime;
    }

    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = et.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        
        et = et.plus(minutes);
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
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
