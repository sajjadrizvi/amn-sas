/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amn;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 *
 * @author sr250039
 */
public class Store {

//    private static final String dataStore = "SAS_DATA_STORE";
//    private static final String indexStore = "SAS_INDEX_STORE";
    private RecordStore dataStore;
    private RecordStore indexStore;
    private Index index;
    private DataRecord data;

//    public Store(String storeName){
//        this.storeName = storeName;
//    }
//    public boolean createNewStore(String storeName){
//        return false;
//    }
    public Store() {
    }

    public void closeStore() throws RecordStoreException {
        dataStore.closeRecordStore();
        indexStore.closeRecordStore();
    }

    public void openStore() throws RecordStoreNotFoundException, RecordStoreFullException, RecordStoreException {
//        deleteAll();
        dataStore = RecordStore.openRecordStore("SAS_DATA_STORE", true);
        indexStore = RecordStore.openRecordStore("SAS_INDEX_STORE", true);
        data = new DataRecord();
        index = new Index();
    }

    public void addRecord(boolean dat[], Date d) throws RecordStoreFullException, RecordStoreException, IOException {
        //printDataStore();
        data.setData(dat);
        byte dt[] = data.toByteArray();        
        int nextID = indexStore.getNextRecordID();
        //byte last[] = null;
        int indx = findIndex(d);
        
//        try{
//            last = indexStore.getRecord(nextID - 1);
//        }catch(InvalidRecordIDException e){
//            e.printStackTrace();
//        }

        //if (last != null) {
        if (indx != -1) {
            //index.fromByteArray(last);
            Calendar now = Calendar.getInstance();
            now.setTime(d);
            //if(index.equals((byte)now.get(Calendar.DATE), (byte)now.get(Calendar.MONTH), (short)now.get(Calendar.YEAR))){
                //nextID = index.getID();
                //dataStore.setRecord(nextID, dt, 0, dt.length);
            dataStore.setRecord(indx, dt, 0, dt.length);
                System.out.println("Updating record");
//                printDataStore();
                return;
            //}
        } 

        System.out.println("Adding new record");
        nextID = dataStore.addRecord(dt, 0, dt.length);
        index.setValues(nextID, d);
        dt = index.toByteArray();
        indexStore.addRecord(dt, 0, dt.length);
//        printDataStore();
    }

    public DataRecord getRecord(int id) throws RecordStoreException, IOException {
        byte[] dat = dataStore.getRecord(id);
        data.fromByteArray(dat);
        return data;
    }

    public void printDataStore() {

        try {
            int lastID = indexStore.getNextRecordID();
            int numRecords = indexStore.getNumRecords();
            int count = 0;

            for (int id = 1;
                    id < lastID && count < numRecords;
                    ++id) {
                byte[] dt = indexStore.getRecord(id);
                index.fromByteArray(dt);
                index.print();
                ++count;
            }
        } catch (InvalidRecordIDException e) {
            e.printStackTrace();
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
        } catch (RecordStoreException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAll() throws RecordStoreNotFoundException, RecordStoreException{
        RecordStore.deleteRecordStore("SAS_DATA_STORE");
        RecordStore.deleteRecordStore("SAS_INDEX_STORE");
    }

    public int findIndex(Date dat){
        try {
             Calendar date = Calendar.getInstance();
             date.setTime(dat);
            int lastID = indexStore.getNextRecordID();
            int numRecords = indexStore.getNumRecords();
            int count = 0;
            byte[] dt = null;
            for (int id = 1; id < lastID && count < numRecords; ++id) {
                try{
                    dt = indexStore.getRecord(id);
                }catch(InvalidRecordIDException e){
                    continue;
                }
                index.fromByteArray(dt);
                if(index.equals((byte)date.get(Calendar.DATE),
                        (byte)date.get(Calendar.MONTH),
                        (short)date.get(Calendar.YEAR))){
                    return index.getID();
                }
                ++count;
            }
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
            return -1;
        } catch (RecordStoreException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    public boolean[] findRecord(Date dat) {
         try {
             Calendar date = Calendar.getInstance();
             date.setTime(dat);
            int lastID = indexStore.getNextRecordID();
            int numRecords = indexStore.getNumRecords();
            int count = 0;
            byte[] dt = null;
            for (int id = 1; id < lastID && count < numRecords; ++id) {
                try{
                    dt = indexStore.getRecord(id);
                }catch(InvalidRecordIDException e){
                    continue;
                }
                index.fromByteArray(dt);
                if(index.equals((byte)date.get(Calendar.DATE), 
                        (byte)date.get(Calendar.MONTH), 
                        (short)date.get(Calendar.YEAR))){
                    byte[] dataBytes = dataStore.getRecord(index.getID());
                   return data.fromByteArray(dataBytes);
                }
                ++count;
            }
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
            return null;
        } catch (RecordStoreException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean delete() {
        return false;
    }

    public byte getReportScore(Date d1, Date d2) {
        short score = 0;
        short totalDays = 0;
//        byte totalPoints = 0; // Max points = 26

        try {

            Calendar date = Calendar.getInstance();
            date.setTime(d1);

            if (date.after(d2)) {
                Date d = d1;
                d1 = d2;
                d2 = d;
            }

//            date = Calendar.getInstance();
//            date.setTime(d1);

            int lastID = indexStore.getNextRecordID();
            int numRecords = indexStore.getNumRecords();
            int count = 0;
            
            byte[] dt = null;
            for (int id = 1; id < lastID && count < numRecords; ++id) {
                try {
                    dt = indexStore.getRecord(id);
                } catch (InvalidRecordIDException e) {
                    continue;
                }
                index.fromByteArray(dt);

                if (index.between(d1, d2)){
                    totalDays++;
                    boolean[] b = data.fromByteArray(dataStore.getRecord(index.getID()));
//                    totalPoints += 26;
                    for(int i=0; i<b.length; i++){
                        if (b[i]){
                            score++;
                        }
                    }

                    System.out.println(index.day + " - " + totalDays + " - " + score);
                }

                ++count;
            }
        } catch (RecordStoreNotOpenException e) {
            e.printStackTrace();
            return -1;
        } catch (RecordStoreException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        if(totalDays == 0){
            return 0;
        }

        return (byte)((score * 100) / (totalDays * 26));
    }
//    public void finally(){
//        //dataStore.closeRecordStore();
//        //indexStore.closeRecordStore();
//    }
//    public void printAllRecords(){
//        RecordStore store = RecordStore.openRecordStore("AR", true);
//    }
//    public DataRecord lookupRecord(int recordId){
//        DataRecord record = new DataRecord();
//    }
//    public int lookupIndex(byte day, byte month, byte year){
//    }
}
