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

/**
 *
 * @author sr250039
 */
public class DataRecord {
    boolean data[];
    public DataRecord(boolean[] dt){
        data = dt;
    }
    
    public DataRecord(){
    }
    
    public DataRecord(boolean d1, boolean d2, boolean d3,
                boolean d4, boolean d5, boolean d6, boolean d7, boolean d8, boolean d9, boolean d10,
                boolean d11, boolean d12, boolean d13, boolean d14, boolean d15, boolean d16, 
                boolean d17, boolean d18, boolean d19, boolean d20, boolean d21, boolean d22, 
                boolean d23, boolean d24, boolean d25, boolean d26){

        
        data[0] = d1;
        data[1] = d2;
        data[2] = d3;
        data[3] = d4;
        data[4] = d5;
        data[5] = d6;
        data[6] = d7;
        data[7] = d8;
        data[8] = d9;
        data[9] = d10;
        data[10] = d11;
        data[11] = d12;
        data[12] = d13;
        data[13] = d14;
        data[14] = d15;
        data[15] = d16;
        data[16] = d17;
        data[17] = d18;
        data[18] = d19;
        data[19] = d20;
        data[20] = d21;
        data[21] = d22;
        data[22] = d23;
        data[23] = d24;
        data[24] = d25;
        data[25] = d26;
        
    }
    
    public void setData(byte index, boolean value){
        data[index] = value;
    }
    
    public void setData(boolean dat[]){
//        for(byte i=0; i<data.length; i++){
//            data[i] = dat[i];
//        }
        data = dat;
    }
    
    public byte[] toByteArray() throws IOException{        
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        DataOutputStream writer = new DataOutputStream(arrayOut);
        
        for(byte i=0; i<26; i++){
            writer.writeBoolean(data[i]);
        }
        writer.flush();
        byte dat[] = arrayOut.toByteArray();
        arrayOut.reset();
        return dat;
    }
    
    public boolean[] fromByteArray(byte dat[]) throws IOException{
        ByteArrayInputStream in = new ByteArrayInputStream(dat);
        DataInputStream reader = new DataInputStream(in);
        
//        for(byte i=0; i<26; i++){
//            data[i] = reader.readBoolean();
//        }
        
        if(data == null){
            data = new boolean[dat.length];
        }
        
        for(byte i=0; reader.available() > 0; i++){
            data[i] = reader.readBoolean();
        }
        
        in.close();
        reader.close();
        
        return data;
    }
    
    public void print(){
        for(byte i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}
