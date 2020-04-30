/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amn;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sr250039
 */
public class Index {
    int id;
    byte day;
    byte month;
    short year;
    
//    private static final byte DATA_SIZE = 8;
    
    public Index(){
    }
    
    public void setValues(int id){
        this.id = id;
        Calendar now = Calendar.getInstance();
        day = (byte)now.get(Calendar.DATE);
        month = (byte)now.get(Calendar.MONTH);
        year = (short)now.get(Calendar.YEAR);
    }

    public void setValues(int id, Date date){
        this.id = id;
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        day = (byte)now.get(Calendar.DATE);
        month = (byte)now.get(Calendar.MONTH);
        year = (short)now.get(Calendar.YEAR);
    }
    
    public int getID(){
        return id;
    }
    
    public byte[] toByteArray() throws IOException{
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        DataOutputStream writer = new DataOutputStream(arrayOut);
        
        writer.writeInt(id);
        writer.writeByte(day);
        writer.writeByte(month);
        writer.writeShort(year);
        writer.flush();
        byte index[] = arrayOut.toByteArray();
        arrayOut.reset();
        arrayOut.close();
        writer.close();
        return index;
    }
    
    public Index fromByteArray(byte dat[]) throws IOException{
        ByteArrayInputStream in = new ByteArrayInputStream(dat);
        DataInputStream reader = new DataInputStream(in);
        
        id = reader.readInt();
        day = reader.readByte();
        month = reader.readByte();
        year = reader.readShort();
        in.close();
        reader.close();
        return this;
    }
    
    public boolean equals(Index ind){
        if(ind.day == this.day && ind.month == this.month && ind.year == this.year){
            return true;
        }
        
        return false;
    }
    
    public boolean equals(Index ind1, Index ind2){
        if(ind1.day == ind2.day && ind1.month == ind2.month && ind1.year == ind2.year){
            return true;
        }
        
        return false;
    }
    
    public boolean equals(byte day, byte month, short year){
        if(day == this.day && month == this.month && year == this.year){
            return true;
        }
        
        return false;
    }

    public boolean between(Date d1, Date d2){
        Calendar c = toCalendar();

//        System.out.println(c.getTime());
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        if (c.after(c1) && c.before(c2)){
            return true;
        } else if (c.equals(c1) || c.equals(c2)) {
            return true;
        }

        return false;
    }


    public Calendar toCalendar(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, this.day);
        c.set(Calendar.MONTH, this.month);
        c.set(Calendar.YEAR, this.year);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c;
    }
    
    public void print(){
        System.out.println(id);
        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
    }
}
