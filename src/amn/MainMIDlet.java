/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amn;

import java.io.IOException;
import java.util.Date;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import org.netbeans.microedition.lcdui.SplashScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author sr250039
 */
public class MainMIDlet extends MIDlet implements CommandListener, ItemCommandListener {

    private boolean midletPaused = false;
    private Store store;
    private byte score = 0;

    public boolean showReport(Date d1, Date d2){
        score = store.getReportScore(d1, d2);
        return true;
    }
    
    public boolean saveData(){
        try {
            boolean[] choices = new boolean[assessChoices.size()];
            assessChoices.getSelectedFlags(choices);
            store.addRecord(choices, date_assess.getDate());
        } catch (RecordStoreFullException ex) {
            ex.printStackTrace();
            return false;
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private void initializeStore(){
        try {
            store = new Store();
            store.openStore();
        } catch (RecordStoreNotFoundException ex) {
            ex.printStackTrace();
        } catch (RecordStoreFullException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command ok_toMainMenu;
    private Command ok_login;
    private Command exit_login;
    private Command exit_exitApp;
    private Command ok_AssessDate;
    private Command ok_history;
    private Command ok_report;
    private Command ok_save;
    private Command back_mainMenu;
    private Command ok_AssessToday;
    private Command ok_reportView;
    private Command ok_historyView;
    private Command back_history;
    private Command back_report;
    private Form welcomeScreen;
    private StringItem welcomeMsgTxt;
    private Form loginScreen;
    private TextField passwordFld;
    private Form MainMenu;
    private StringItem todayStr;
    private StringItem reportStr;
    private StringItem historyStr;
    private Form History;
    private DateField historyDate;
    private Form Report;
    private DateField date1;
    private DateField date2;
    private Form AssessToday;
    private ChoiceGroup assessChoices;
    private SplashScreen splashScreen;
    private Form HistoryView;
    private ChoiceGroup historyChoices;
    private Form ReportView;
    private StringItem totalScoreStr;
    private Form AssessDate;
    private DateField date_assess;
    private SimpleCancellableTask task;
    private Font font1;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The MainMIDlet constructor.
     */
    public MainMIDlet() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        initializeStore();
        switchDisplayable(null, getWelcomeScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|









    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|26-getter|1|26-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|26-getter|1|26-execute
                    // write task-execution user code here
                }//GEN-BEGIN:|26-getter|2|26-postInit
            });//GEN-END:|26-getter|2|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|26-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: welcomeScreen ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of welcomeScreen component.
     * @return the initialized component instance
     */
    public Form getWelcomeScreen() {
        if (welcomeScreen == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            welcomeScreen = new Form("", new Item[] { getWelcomeMsgTxt() });//GEN-BEGIN:|30-getter|1|30-postInit
            welcomeScreen.addCommand(getOk_toMainMenu());
            welcomeScreen.setCommandListener(this);//GEN-END:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return welcomeScreen;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: welcomeMsgTxt ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of welcomeMsgTxt component.
     * @return the initialized component instance
     */
    public StringItem getWelcomeMsgTxt() {
        if (welcomeMsgTxt == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            welcomeMsgTxt = new StringItem("", "\u0628\u0633\u0645 \u0627\u0644\u0644\u06C1 \u0627\u0644\u0631\u062D\u0645\u0670\u0646 \u0627\u0644\u0631\u062D\u06CC\u0645 \n\u0642\u0627\u0644 \u0631\u0633\u0648\u0644 \u0627\u0644\u0644\u06C1 \u0635\u0644\u06CC \u0627\u0644\u0644\u06C1 \u0639\u0644\u06CC\u06C1 \u0648 \u0627\u0653\u0644\u06C1 \u0648\u0633\u0644\u0645: \u062D\u0627\u0633\u0628\u0648\u0627 \u0627\u0646\u0641\u0633\u06A9\u0645 \u0642\u0628\u0644 \u0627\u0646 \u062A\u062D\u0627\u0633\u0628\u0648\u0627\n\u0627\u067E\u0646\u0627 \u0645\u062D\u0627\u0633\u0628\u06C1 \u062E\u0648\u062F \u06A9\u0631\u0648\u060C \u0642\u0628\u0644 \u0627\u0633 \u06A9\u06D2 \u06A9\u06C1 \u062A\u0645\u06C1\u0627\u0631\u0627 \u0645\u062D\u0627\u0633\u0628\u06C1 \u06A9\u06CC\u0627 \u062C\u0627\u06D2\n(\u0645\u06CC\u0632\u0627\u0646 \u0627\u0644\u062D\u06A9\u0645\u062A,  \u062D\u062F\u06CC\u062B:  \u06F3\u06F8\u06F3\u06F8)\n\nSelf Assessment Software\nBy\nAssociation of Mushtaqan-e-Noor(a.s)\nwww.amnoor.org", Item.PLAIN);//GEN-BEGIN:|32-getter|1|32-postInit
            welcomeMsgTxt.setLayout(ImageItem.LAYOUT_CENTER | Item.LAYOUT_VEXPAND);
            welcomeMsgTxt.setFont(getFont1());//GEN-END:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return welcomeMsgTxt;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == AssessDate) {//GEN-BEGIN:|7-commandAction|1|186-preAction
            if (command == ok_AssessToday) {//GEN-END:|7-commandAction|1|186-preAction
                // write pre-action user code here
                boolean data[] = store.findRecord(getDate_assess().getDate());
                if(data == null){
                    data = new boolean[getAssessChoices().size()];
                }

                getAssessChoices().setSelectedFlags(data);

                switchDisplayable(null, getAssessToday());//GEN-LINE:|7-commandAction|2|186-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|103-preAction
        } else if (displayable == AssessToday) {
            if (command == back_mainMenu) {//GEN-END:|7-commandAction|3|103-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|4|103-postAction
                // write post-action user code here
            } else if (command == ok_save) {//GEN-LINE:|7-commandAction|5|129-preAction
                // write pre-action user code here
                if(saveData()){
                    getSplashScreen().setText("Data saved");
                    getSplashScreen().setTimeout(1);
                }else{
                    getSplashScreen().setText("Unable to save data");
                    getSplashScreen().setTimeout(2000);
                }
                switchDisplayable(null, getSplashScreen());//GEN-LINE:|7-commandAction|6|129-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|138-preAction
        } else if (displayable == History) {
            if (command == back_mainMenu) {//GEN-END:|7-commandAction|7|138-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|8|138-postAction
                // write post-action user code here
            } else if (command == ok_historyView) {//GEN-LINE:|7-commandAction|9|180-preAction
                // write pre-action user code here
                boolean data[] = store.findRecord(getHistoryDate().getDate());
                if(data == null){
                    data = new boolean[getHistoryChoices().size()];
                }

                getHistoryChoices().setSelectedFlags(data);
                switchDisplayable(null, getHistoryView());//GEN-LINE:|7-commandAction|10|180-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|177-preAction
        } else if (displayable == HistoryView) {
            if (command == back_history) {//GEN-END:|7-commandAction|11|177-preAction
                // write pre-action user code here
                switchDisplayable(null, getHistory());//GEN-LINE:|7-commandAction|12|177-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|60-preAction
        } else if (displayable == MainMenu) {
            if (command == exit_exitApp) {//GEN-END:|7-commandAction|13|60-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|14|60-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|137-preAction
        } else if (displayable == Report) {
            if (command == back_mainMenu) {//GEN-END:|7-commandAction|15|137-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|16|137-postAction
                // write post-action user code here
            } else if (command == ok_reportView) {//GEN-LINE:|7-commandAction|17|192-preAction
                // write pre-action user code here
                showReport(date1.getDate(), date2.getDate());
                switchDisplayable(null, getReportView());//GEN-LINE:|7-commandAction|18|192-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|196-preAction
        } else if (displayable == ReportView) {
            if (command == back_report) {//GEN-END:|7-commandAction|19|196-preAction
                // write pre-action user code here
                switchDisplayable(null, getReport());//GEN-LINE:|7-commandAction|20|196-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|42-preAction
        } else if (displayable == loginScreen) {
            if (command == exit_login) {//GEN-END:|7-commandAction|21|42-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|42-postAction
                // write post-action user code here
            } else if (command == ok_login) {//GEN-LINE:|7-commandAction|23|44-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|24|44-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|128-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|25|128-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|26|128-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|27|34-preAction
        } else if (displayable == welcomeScreen) {
            if (command == ok_toMainMenu) {//GEN-END:|7-commandAction|27|34-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainMenu());//GEN-LINE:|7-commandAction|28|34-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|7-postCommandAction
        }//GEN-END:|7-commandAction|29|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|30|
    //</editor-fold>//GEN-END:|7-commandAction|30|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_toMainMenu ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of ok_toMainMenu component.
     * @return the initialized component instance
     */
    public Command getOk_toMainMenu() {
        if (ok_toMainMenu == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            ok_toMainMenu = new Command("Continue", Command.OK, 0);//GEN-LINE:|33-getter|1|33-postInit
            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return ok_toMainMenu;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: font1 ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of font1 component.
     * @return the initialized component instance
     */
    public Font getFont1() {
        if (font1 == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            font1 = Font.getDefaultFont();//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return font1;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: loginScreen ">//GEN-BEGIN:|37-getter|0|37-preInit
    /**
     * Returns an initiliazed instance of loginScreen component.
     * @return the initialized component instance
     */
    public Form getLoginScreen() {
        if (loginScreen == null) {//GEN-END:|37-getter|0|37-preInit
            // write pre-init user code here
            loginScreen = new Form("", new Item[] { getPasswordFld() });//GEN-BEGIN:|37-getter|1|37-postInit
            loginScreen.addCommand(getExit_login());
            loginScreen.addCommand(getOk_login());
            loginScreen.setCommandListener(this);//GEN-END:|37-getter|1|37-postInit
            // write post-init user code here
        }//GEN-BEGIN:|37-getter|2|
        return loginScreen;
    }
    //</editor-fold>//GEN-END:|37-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exit_login ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of exit_login component.
     * @return the initialized component instance
     */
    public Command getExit_login() {
        if (exit_login == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            exit_login = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return exit_login;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_login ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of ok_login component.
     * @return the initialized component instance
     */
    public Command getOk_login() {
        if (ok_login == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            ok_login = new Command("Continue", Command.OK, 0);//GEN-LINE:|43-getter|1|43-postInit
            // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return ok_login;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: passwordFld ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of passwordFld component.
     * @return the initialized component instance
     */
    public TextField getPasswordFld() {
        if (passwordFld == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            passwordFld = new TextField("Password:", null, 32, TextField.ANY);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return passwordFld;
    }
    //</editor-fold>//GEN-END:|47-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: MainMenu ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of MainMenu component.
     * @return the initialized component instance
     */
    public Form getMainMenu() {
        if (MainMenu == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            MainMenu = new Form("", new Item[] { getTodayStr(), getHistoryStr(), getReportStr() });//GEN-BEGIN:|56-getter|1|56-postInit
            MainMenu.addCommand(getExit_exitApp());
            MainMenu.setCommandListener(this);//GEN-END:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return MainMenu;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: todayStr ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of todayStr component.
     * @return the initialized component instance
     */
    public StringItem getTodayStr() {
        if (todayStr == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            todayStr = new StringItem("Assess Today", "");//GEN-BEGIN:|57-getter|1|57-postInit
            todayStr.addCommand(getOk_AssessDate());
            todayStr.setItemCommandListener(this);//GEN-END:|57-getter|1|57-postInit
            // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return todayStr;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exit_exitApp ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of exit_exitApp component.
     * @return the initialized component instance
     */
    public Command getExit_exitApp() {
        if (exit_exitApp == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            exit_exitApp = new Command("Exit", Command.EXIT, 2);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return exit_exitApp;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Items ">//GEN-BEGIN:|17-itemCommandAction|0|17-preItemCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular item.
     * @param command the Command that was invoked
     * @param displayable the Item where the command was invoked
     */
    public void commandAction(Command command, Item item) {//GEN-END:|17-itemCommandAction|0|17-preItemCommandAction
        // write pre-action user code here
        if (item == historyStr) {//GEN-BEGIN:|17-itemCommandAction|1|80-preAction
            if (command == ok_history) {//GEN-END:|17-itemCommandAction|1|80-preAction
                // write pre-action user code here
                switchDisplayable(null, getHistory());//GEN-LINE:|17-itemCommandAction|2|80-postAction
                // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|3|82-preAction
        } else if (item == reportStr) {
            if (command == ok_report) {//GEN-END:|17-itemCommandAction|3|82-preAction
                // write pre-action user code here
                switchDisplayable(null, getReport());//GEN-LINE:|17-itemCommandAction|4|82-postAction
                // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|5|65-preAction
        } else if (item == todayStr) {
            if (command == ok_AssessDate) {//GEN-END:|17-itemCommandAction|5|65-preAction
                // write pre-action user code here
                switchDisplayable(null, getAssessDate());//GEN-LINE:|17-itemCommandAction|6|65-postAction
                // write post-action user code here
            }//GEN-BEGIN:|17-itemCommandAction|7|17-postItemCommandAction
        }//GEN-END:|17-itemCommandAction|7|17-postItemCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|17-itemCommandAction|8|
    //</editor-fold>//GEN-END:|17-itemCommandAction|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_AssessDate ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of ok_AssessDate component.
     * @return the initialized component instance
     */
    public Command getOk_AssessDate() {
        if (ok_AssessDate == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            ok_AssessDate = new Command("Next", Command.OK, 1);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return ok_AssessDate;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: historyStr ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of historyStr component.
     * @return the initialized component instance
     */
    public StringItem getHistoryStr() {
        if (historyStr == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            historyStr = new StringItem("History", "");//GEN-BEGIN:|62-getter|1|62-postInit
            historyStr.addCommand(getOk_history());
            historyStr.setItemCommandListener(this);//GEN-END:|62-getter|1|62-postInit
            // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return historyStr;
    }
    //</editor-fold>//GEN-END:|62-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: reportStr ">//GEN-BEGIN:|63-getter|0|63-preInit
    /**
     * Returns an initiliazed instance of reportStr component.
     * @return the initialized component instance
     */
    public StringItem getReportStr() {
        if (reportStr == null) {//GEN-END:|63-getter|0|63-preInit
            // write pre-init user code here
            reportStr = new StringItem("Report", "");//GEN-BEGIN:|63-getter|1|63-postInit
            reportStr.addCommand(getOk_report());
            reportStr.setItemCommandListener(this);//GEN-END:|63-getter|1|63-postInit
            // write post-init user code here
        }//GEN-BEGIN:|63-getter|2|
        return reportStr;
    }
    //</editor-fold>//GEN-END:|63-getter|2|











    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_history ">//GEN-BEGIN:|79-getter|0|79-preInit
    /**
     * Returns an initiliazed instance of ok_history component.
     * @return the initialized component instance
     */
    public Command getOk_history() {
        if (ok_history == null) {//GEN-END:|79-getter|0|79-preInit
            // write pre-init user code here
            ok_history = new Command("Next", Command.OK, 1);//GEN-LINE:|79-getter|1|79-postInit
            // write post-init user code here
        }//GEN-BEGIN:|79-getter|2|
        return ok_history;
    }
    //</editor-fold>//GEN-END:|79-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_report ">//GEN-BEGIN:|81-getter|0|81-preInit
    /**
     * Returns an initiliazed instance of ok_report component.
     * @return the initialized component instance
     */
    public Command getOk_report() {
        if (ok_report == null) {//GEN-END:|81-getter|0|81-preInit
            // write pre-init user code here
            ok_report = new Command("Next", Command.OK, 1);//GEN-LINE:|81-getter|1|81-postInit
            // write post-init user code here
        }//GEN-BEGIN:|81-getter|2|
        return ok_report;
    }
    //</editor-fold>//GEN-END:|81-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: History ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initiliazed instance of History component.
     * @return the initialized component instance
     */
    public Form getHistory() {
        if (History == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            History = new Form("", new Item[] { getHistoryDate() });//GEN-BEGIN:|71-getter|1|71-postInit
            History.addCommand(getBack_mainMenu());
            History.addCommand(getOk_historyView());
            History.setCommandListener(this);//GEN-END:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return History;
    }
    //</editor-fold>//GEN-END:|71-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Report ">//GEN-BEGIN:|72-getter|0|72-preInit
    /**
     * Returns an initiliazed instance of Report component.
     * @return the initialized component instance
     */
    public Form getReport() {
        if (Report == null) {//GEN-END:|72-getter|0|72-preInit
            // write pre-init user code here
            Report = new Form("", new Item[] { getDate1(), getDate2() });//GEN-BEGIN:|72-getter|1|72-postInit
            Report.addCommand(getBack_mainMenu());
            Report.addCommand(getOk_reportView());
            Report.setCommandListener(this);//GEN-END:|72-getter|1|72-postInit
            // write post-init user code here
        }//GEN-BEGIN:|72-getter|2|
        return Report;
    }
    //</editor-fold>//GEN-END:|72-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: back_mainMenu ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initiliazed instance of back_mainMenu component.
     * @return the initialized component instance
     */
    public Command getBack_mainMenu() {
        if (back_mainMenu == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            back_mainMenu = new Command("Back", "Back", Command.BACK, 0);//GEN-LINE:|91-getter|1|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|2|
        return back_mainMenu;
    }
    //</editor-fold>//GEN-END:|91-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_save ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of ok_save component.
     * @return the initialized component instance
     */
    public Command getOk_save() {
        if (ok_save == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            ok_save = new Command("Save", "Save", Command.OK, 0);//GEN-LINE:|93-getter|1|93-postInit
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|2|
        return ok_save;
    }
    //</editor-fold>//GEN-END:|93-getter|2|







    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AssessToday ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of AssessToday component.
     * @return the initialized component instance
     */
    public Form getAssessToday() {
        if (AssessToday == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            AssessToday = new Form("", new Item[] { getAssessChoices() });//GEN-BEGIN:|100-getter|1|100-postInit
            AssessToday.addCommand(getOk_save());
            AssessToday.addCommand(getBack_mainMenu());
            AssessToday.setCommandListener(this);//GEN-END:|100-getter|1|100-postInit
            // write post-init user code here
        }//GEN-BEGIN:|100-getter|2|
        return AssessToday;
    }
    //</editor-fold>//GEN-END:|100-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: assessChoices ">//GEN-BEGIN:|101-getter|0|101-preInit
    /**
     * Returns an initiliazed instance of assessChoices component.
     * @return the initialized component instance
     */
    public ChoiceGroup getAssessChoices() {
        if (assessChoices == null) {//GEN-END:|101-getter|0|101-preInit
            // write pre-init user code here
            assessChoices = new ChoiceGroup("Select", Choice.MULTIPLE);//GEN-BEGIN:|101-getter|1|101-postInit
            assessChoices.append("\u0646\u0645\u0627\u0632 \u0634\u0628", null);
            assessChoices.append("\u0646\u0645\u0627\u0632 \u0635\u0628\u062D \u0648 \u0633\u062D\u0631 \u062E\u06CC\u0632\u06CC", null);
            assessChoices.append("\u0642\u0631\u0627\u0646 \u0648 \u062F\u0639\u0627", null);
            assessChoices.append("\u0648\u0631\u0632\u0634", null);
            assessChoices.append("\u0646\u0638\u0645 \u0648 \u0679\u0627\u06CC\u0645 \u0679\u06CC\u0628\u0644", null);
            assessChoices.append("\u063A\u0648\u0631 \u0648 \u0641\u06A9\u0631", null);
            assessChoices.append("\u0627\u0648\u0644 \u0648\u0642\u062A \u0646\u0645\u0627\u0632", null);
            assessChoices.append("\u0645\u0637\u0627\u0644\u0639\u06C1 \u0648 \u062D\u0635\u0648\u0644 \u0639\u0644\u0645", null);
            assessChoices.append("\u062A\u0639\u0644\u06CC\u0645 \u0627\u06C1\u0644 \u062E\u0627\u0646\u06C1 \u0648 \u0645\u0648\u0645\u0646\u06CC\u0646", null);
            assessChoices.append("\u0635\u062F\u0642\u06C1 (\u0633\u0644\u0627\u0645\u062A\u06CC \u0627\u0645\u0627\u0645 \u0632\u0645\u0627\u0646\u06C1 \u0639 ) \u06D4", null);
            assessChoices.append("\u0645\u0639\u0631\u0641\u062A \u0627\u0645\u0627\u0645 \u0632\u0645\u0627\u0646\u06C1 \u0639\u0644\u06CC\u06C1 \u0627\u0644\u0633\u0644\u0627\u0645", null);
            assessChoices.append("\u062A\u0639\u0627\u0631\u0641 \u0627\u0645\u0627\u0645 \u0639\u0644\u06CC\u06C1 \u0627\u0644\u0633\u0644\u0627\u0645 \u0645\u06CC\u06BA \u0633\u0639\u06CC", null);
            assessChoices.append("\u0627\u062D\u0633\u0627\u0646 \u0628\u06C1 \u0648\u0627\u0644\u062F\u06CC\u0646 \u06D4 \u0635\u0644\u06C1 \u0631\u062D\u0645\u06CC", null);
            assessChoices.append("\u0627\u0645\u062F\u0627\u062F \u0645\u0648\u0645\u0646\u06CC\u0646", null);
            assessChoices.append("\u0627\u06CC\u0641\u0627\u06D2 \u0639\u06C1\u062F", null);
            assessChoices.append("\u0627\u0645\u0631 \u0628\u06C1 \u0645\u0639\u0631\u0648\u0641 \u0648 \u0646\u06C1\u06CC \u0627\u0632 \u0645\u0646\u06A9\u0631", null);
            assessChoices.append("\u0645\u0633\u062A\u062D\u0628 \u0631\u0648\u0632\u06C1", null);
            assessChoices.append("\u0646\u0627 \u0645\u062D\u0631\u0645 \u067E\u0631 \u0646\u06AF\u0627\u06C1 \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            assessChoices.append("\u063A\u06CC\u0628\u062A \u0648 \u062A\u06C1\u0645\u062A \u0633\u06D2 \u062F\u0648\u0631\u06CC", null);
            assessChoices.append("\u062C\u06BE\u0648\u0679 \u0648 \u0646\u0641\u0627\u0642 \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            assessChoices.append("\u0628\u062F \u0627\u062E\u0644\u0627\u0642\u06CC \u0648 \u0641\u062D\u0634 \u06AF\u0648\u0621\u06CC \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            assessChoices.append("\u0644\u06C1\u0648 \u0648 \u0644\u0639\u0628 \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            assessChoices.append("\u063A\u0636\u0628 \u0648 \u063A\u0635\u06C1 \u0633\u06D2 \u062F\u0648\u0631\u06CC", null);
            assessChoices.append("\u0631\u06CC\u0627\u06A9\u0627\u0631\u06CC \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            assessChoices.append("\u062D\u0633\u062F \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            assessChoices.append("\u0633\u0648\u0646\u06D2 \u0633\u06D2 \u0642\u0628\u0644 \u06A9\u06D2 \u0627\u0639\u0645\u0627\u0644", null);
            assessChoices.setFitPolicy(Choice.TEXT_WRAP_ON);
            assessChoices.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false });
            assessChoices.setFont(0, null);
            assessChoices.setFont(1, null);
            assessChoices.setFont(2, null);
            assessChoices.setFont(3, null);
            assessChoices.setFont(4, null);
            assessChoices.setFont(5, null);
            assessChoices.setFont(6, null);
            assessChoices.setFont(7, null);
            assessChoices.setFont(8, null);
            assessChoices.setFont(9, null);
            assessChoices.setFont(10, null);
            assessChoices.setFont(11, null);
            assessChoices.setFont(12, null);
            assessChoices.setFont(13, null);
            assessChoices.setFont(14, null);
            assessChoices.setFont(15, null);
            assessChoices.setFont(16, null);
            assessChoices.setFont(17, null);
            assessChoices.setFont(18, null);
            assessChoices.setFont(19, null);
            assessChoices.setFont(20, null);
            assessChoices.setFont(21, null);
            assessChoices.setFont(22, null);
            assessChoices.setFont(23, null);
            assessChoices.setFont(24, null);
            assessChoices.setFont(25, null);//GEN-END:|101-getter|1|101-postInit
            // write post-init user code here
        }//GEN-BEGIN:|101-getter|2|
        return assessChoices;
    }
    //</editor-fold>//GEN-END:|101-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|127-getter|0|127-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|127-getter|0|127-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|127-getter|1|127-postInit
            splashScreen.setTitle("");
            splashScreen.setCommandListener(this);
            splashScreen.setText("Unable to save data");
            splashScreen.setTimeout(1500);//GEN-END:|127-getter|1|127-postInit
            // write post-init user code here
        }//GEN-BEGIN:|127-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|127-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: historyDate ">//GEN-BEGIN:|147-getter|0|147-preInit
    /**
     * Returns an initiliazed instance of historyDate component.
     * @return the initialized component instance
     */
    public DateField getHistoryDate() {
        if (historyDate == null) {//GEN-END:|147-getter|0|147-preInit
            // write pre-init user code here
            historyDate = new DateField("Select Date", DateField.DATE);//GEN-BEGIN:|147-getter|1|147-postInit
            historyDate.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|147-getter|1|147-postInit
            // write post-init user code here
        }//GEN-BEGIN:|147-getter|2|
        return historyDate;
    }
    //</editor-fold>//GEN-END:|147-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: HistoryView ">//GEN-BEGIN:|148-getter|0|148-preInit
    /**
     * Returns an initiliazed instance of HistoryView component.
     * @return the initialized component instance
     */
    public Form getHistoryView() {
        if (HistoryView == null) {//GEN-END:|148-getter|0|148-preInit
            // write pre-init user code here
            HistoryView = new Form("", new Item[] { getHistoryChoices() });//GEN-BEGIN:|148-getter|1|148-postInit
            HistoryView.addCommand(getBack_history());
            HistoryView.setCommandListener(this);//GEN-END:|148-getter|1|148-postInit
            // write post-init user code here
        }//GEN-BEGIN:|148-getter|2|
        return HistoryView;
    }
    //</editor-fold>//GEN-END:|148-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: historyChoices ">//GEN-BEGIN:|149-getter|0|149-preInit
    /**
     * Returns an initiliazed instance of historyChoices component.
     * @return the initialized component instance
     */
    public ChoiceGroup getHistoryChoices() {
        if (historyChoices == null) {//GEN-END:|149-getter|0|149-preInit
            // write pre-init user code here
            historyChoices = new ChoiceGroup("choiceGroup", Choice.MULTIPLE);//GEN-BEGIN:|149-getter|1|149-postInit
            historyChoices.append("\u0646\u0645\u0627\u0632 \u0634\u0628", null);
            historyChoices.append("\u0646\u0645\u0627\u0632 \u0635\u0628\u062D \u0648 \u0633\u062D\u0631 \u062E\u06CC\u0632\u06CC", null);
            historyChoices.append("\u0642\u0631\u0627\u0646 \u0648 \u062F\u0639\u0627", null);
            historyChoices.append("\u0648\u0631\u0632\u0634", null);
            historyChoices.append("\u0646\u0638\u0645 \u0648 \u0679\u0627\u06CC\u0645 \u0679\u06CC\u0628\u0644", null);
            historyChoices.append("\u063A\u0648\u0631 \u0648 \u0641\u06A9\u0631", null);
            historyChoices.append("\u0627\u0648\u0644 \u0648\u0642\u062A \u0646\u0645\u0627\u0632", null);
            historyChoices.append("\u0645\u0637\u0627\u0644\u0639\u06C1 \u062D\u0635\u0648\u0644 \u0639\u0644\u0645", null);
            historyChoices.append("\u062A\u0639\u0644\u06CC\u0645 \u0627\u06C1\u0644 \u062E\u0627\u0646\u06C1 \u0648 \u0645\u0648\u0645\u0646\u06CC\u0646", null);
            historyChoices.append("\u0635\u062F\u0642\u06C1 ( \u0633\u0644\u0627\u0645\u062A\u06CC \u0627\u0645\u0627\u0645 \u0632\u0645\u0627\u0646\u06C1 \u0639 )\u06D4", null);
            historyChoices.append("\u0645\u0639\u0631\u0641\u062A \u0627\u0645\u0627\u0645 \u0632\u0645\u0627\u0646\u06C1 \u0639\u0644\u06CC\u06C1 \u0627\u0644\u0633\u0644\u0627\u0645", null);
            historyChoices.append("\u062A\u0639\u0627\u0631\u0641 \u0627\u0645\u0627\u0645 \u0639\u0644\u06CC\u06C1 \u0627\u0644\u0633\u0644\u0627\u0645 \u0645\u06CC\u06BA \u0633\u0639\u06CC", null);
            historyChoices.append("\u0627\u062D\u0633\u0627\u0646 \u0628\u06C1 \u0648\u0644\u062F\u06CC\u0646 \u06D4 \u0635\u0644\u06C1 \u0631\u062D\u0645\u06CC", null);
            historyChoices.append("\u0627\u0645\u062F\u0627\u062F \u0645\u0648\u0645\u0646\u06CC\u0646", null);
            historyChoices.append("\u0627\u06CC\u0641\u0627\u06D2 \u0639\u06C1\u062F", null);
            historyChoices.append("\u0627\u0645\u0631 \u0628\u06C1 \u0645\u0639\u0631\u0648\u0641 \u0648 \u0646\u06BE\u06CC \u0627\u0632 \u0645\u0646\u06A9\u0631", null);
            historyChoices.append("\u0645\u0633\u062A\u062D\u0628 \u0631\u0648\u0632\u06C1", null);
            historyChoices.append("\u0646\u0627 \u0645\u062D\u0631\u0645 \u067E\u0631 \u0646\u06AF\u0627\u06C1 \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            historyChoices.append("\u063A\u06CC\u0628\u062A \u0648 \u062A\u06C1\u0645\u062A \u0633\u06D2 \u062F\u0648\u0631\u06CC", null);
            historyChoices.append("\u062C\u06BE\u0648\u0679 \u0648 \u0646\u0641\u0627\u0642 \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            historyChoices.append("\u0628\u062F \u0627\u062E\u0644\u0627\u0642\u06CC \u0648 \u0641\u062D\u0634 \u06AF\u0648\u06CC \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            historyChoices.append("\u0644\u06C1\u0648 \u0648 \u0644\u0639\u0628 \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            historyChoices.append("\u063A\u0636\u0628 \u0648 \u0636\u0635\u06C1 \u0633\u06D2 \u062F\u0648\u0631\u06CC", null);
            historyChoices.append("\u0631\u06CC\u0627\u06A9\u0627\u0631\u06CC \u0633\u06D2 \u0627\u062C\u062A\u0646\u0627\u0628", null);
            historyChoices.append("\u062D\u0633\u062F \u0633\u06D2 \u067E\u0631\u06C1\u06CC\u0632", null);
            historyChoices.append("\u0633\u0648\u0646\u06D2 \u0633\u06D2 \u0642\u0628\u0644 \u06A9\u06D2 \u0627\u0639\u0645\u0627\u0644", null);
            historyChoices.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);
            historyChoices.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false });
            historyChoices.setFont(0, null);
            historyChoices.setFont(1, null);
            historyChoices.setFont(2, null);
            historyChoices.setFont(3, null);
            historyChoices.setFont(4, null);
            historyChoices.setFont(5, null);
            historyChoices.setFont(6, null);
            historyChoices.setFont(7, null);
            historyChoices.setFont(8, null);
            historyChoices.setFont(9, null);
            historyChoices.setFont(10, null);
            historyChoices.setFont(11, null);
            historyChoices.setFont(12, null);
            historyChoices.setFont(13, null);
            historyChoices.setFont(14, null);
            historyChoices.setFont(15, null);
            historyChoices.setFont(16, null);
            historyChoices.setFont(17, null);
            historyChoices.setFont(18, null);
            historyChoices.setFont(19, null);
            historyChoices.setFont(20, null);
            historyChoices.setFont(21, null);
            historyChoices.setFont(22, null);
            historyChoices.setFont(23, null);
            historyChoices.setFont(24, null);
            historyChoices.setFont(25, null);//GEN-END:|149-getter|1|149-postInit
            // write post-init user code here
        }//GEN-BEGIN:|149-getter|2|
        return historyChoices;
    }
    //</editor-fold>//GEN-END:|149-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: back_history ">//GEN-BEGIN:|176-getter|0|176-preInit
    /**
     * Returns an initiliazed instance of back_history component.
     * @return the initialized component instance
     */
    public Command getBack_history() {
        if (back_history == null) {//GEN-END:|176-getter|0|176-preInit
            // write pre-init user code here
            back_history = new Command("Back", Command.BACK, 0);//GEN-LINE:|176-getter|1|176-postInit
            // write post-init user code here
        }//GEN-BEGIN:|176-getter|2|
        return back_history;
    }
    //</editor-fold>//GEN-END:|176-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_historyView ">//GEN-BEGIN:|179-getter|0|179-preInit
    /**
     * Returns an initiliazed instance of ok_historyView component.
     * @return the initialized component instance
     */
    public Command getOk_historyView() {
        if (ok_historyView == null) {//GEN-END:|179-getter|0|179-preInit
            // write pre-init user code here
            ok_historyView = new Command("Ok", Command.OK, 0);//GEN-LINE:|179-getter|1|179-postInit
            // write post-init user code here
        }//GEN-BEGIN:|179-getter|2|
        return ok_historyView;
    }
    //</editor-fold>//GEN-END:|179-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_AssessToday ">//GEN-BEGIN:|185-getter|0|185-preInit
    /**
     * Returns an initiliazed instance of ok_AssessToday component.
     * @return the initialized component instance
     */
    public Command getOk_AssessToday() {
        if (ok_AssessToday == null) {//GEN-END:|185-getter|0|185-preInit
            // write pre-init user code here
            ok_AssessToday = new Command("Ok", Command.OK, 0);//GEN-LINE:|185-getter|1|185-postInit
            // write post-init user code here
        }//GEN-BEGIN:|185-getter|2|
        return ok_AssessToday;
    }
    //</editor-fold>//GEN-END:|185-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AssessDate ">//GEN-BEGIN:|183-getter|0|183-preInit
    /**
     * Returns an initiliazed instance of AssessDate component.
     * @return the initialized component instance
     */
    public Form getAssessDate() {
        if (AssessDate == null) {//GEN-END:|183-getter|0|183-preInit
            // write pre-init user code here
            AssessDate = new Form("", new Item[] { getDate_assess() });//GEN-BEGIN:|183-getter|1|183-postInit
            AssessDate.addCommand(getOk_AssessToday());
            AssessDate.setCommandListener(this);//GEN-END:|183-getter|1|183-postInit
            // write post-init user code here
        }//GEN-BEGIN:|183-getter|2|
        return AssessDate;
    }
    //</editor-fold>//GEN-END:|183-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: date_assess ">//GEN-BEGIN:|184-getter|0|184-preInit
    /**
     * Returns an initiliazed instance of date_assess component.
     * @return the initialized component instance
     */
    public DateField getDate_assess() {
        if (date_assess == null) {//GEN-END:|184-getter|0|184-preInit
            // write pre-init user code here
            date_assess = new DateField("Select date", DateField.DATE);//GEN-BEGIN:|184-getter|1|184-postInit
            date_assess.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|184-getter|1|184-postInit
            // write post-init user code here
        }//GEN-BEGIN:|184-getter|2|
        return date_assess;
    }
    //</editor-fold>//GEN-END:|184-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ok_reportView ">//GEN-BEGIN:|191-getter|0|191-preInit
    /**
     * Returns an initiliazed instance of ok_reportView component.
     * @return the initialized component instance
     */
    public Command getOk_reportView() {
        if (ok_reportView == null) {//GEN-END:|191-getter|0|191-preInit
            // write pre-init user code here
            ok_reportView = new Command("Ok", Command.OK, 0);//GEN-LINE:|191-getter|1|191-postInit
            // write post-init user code here
        }//GEN-BEGIN:|191-getter|2|
        return ok_reportView;
    }
    //</editor-fold>//GEN-END:|191-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: date1 ">//GEN-BEGIN:|188-getter|0|188-preInit
    /**
     * Returns an initiliazed instance of date1 component.
     * @return the initialized component instance
     */
    public DateField getDate1() {
        if (date1 == null) {//GEN-END:|188-getter|0|188-preInit
            // write pre-init user code here
            date1 = new DateField("From", DateField.DATE);//GEN-BEGIN:|188-getter|1|188-postInit
            date1.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|188-getter|1|188-postInit
            // write post-init user code here
        }//GEN-BEGIN:|188-getter|2|
        return date1;
    }
    //</editor-fold>//GEN-END:|188-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: date2 ">//GEN-BEGIN:|189-getter|0|189-preInit
    /**
     * Returns an initiliazed instance of date2 component.
     * @return the initialized component instance
     */
    public DateField getDate2() {
        if (date2 == null) {//GEN-END:|189-getter|0|189-preInit
            // write pre-init user code here
            date2 = new DateField("To", DateField.DATE);//GEN-BEGIN:|189-getter|1|189-postInit
            date2.setDate(new java.util.Date(System.currentTimeMillis()));//GEN-END:|189-getter|1|189-postInit
            // write post-init user code here
        }//GEN-BEGIN:|189-getter|2|
        return date2;
    }
    //</editor-fold>//GEN-END:|189-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ReportView ">//GEN-BEGIN:|190-getter|0|190-preInit
    /**
     * Returns an initiliazed instance of ReportView component.
     * @return the initialized component instance
     */
    public Form getReportView() {
        if (ReportView == null) {//GEN-END:|190-getter|0|190-preInit
            // write pre-init user code here
            ReportView = new Form("", new Item[] { getTotalScoreStr() });//GEN-BEGIN:|190-getter|1|190-postInit
            ReportView.addCommand(getBack_report());
            ReportView.setCommandListener(this);//GEN-END:|190-getter|1|190-postInit
            // write post-init user code here
        }//GEN-BEGIN:|190-getter|2|
        return ReportView;
    }
    //</editor-fold>//GEN-END:|190-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: totalScoreStr ">//GEN-BEGIN:|194-getter|0|194-preInit
    /**
     * Returns an initiliazed instance of totalScoreStr component.
     * @return the initialized component instance
     */
    public StringItem getTotalScoreStr() {
        if (totalScoreStr == null) {//GEN-END:|194-getter|0|194-preInit
            // write pre-init user code here
            totalScoreStr = new StringItem("Total", "  "+score + " %");//GEN-LINE:|194-getter|1|194-postInit
            // write post-init user code here
        }//GEN-BEGIN:|194-getter|2|
        return totalScoreStr;
    }
    //</editor-fold>//GEN-END:|194-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: back_report ">//GEN-BEGIN:|195-getter|0|195-preInit
    /**
     * Returns an initiliazed instance of back_report component.
     * @return the initialized component instance
     */
    public Command getBack_report() {
        if (back_report == null) {//GEN-END:|195-getter|0|195-preInit
            // write pre-init user code here
            back_report = new Command("Back", Command.BACK, 0);//GEN-LINE:|195-getter|1|195-postInit
            // write post-init user code here
        }//GEN-BEGIN:|195-getter|2|
        return back_report;
    }
    //</editor-fold>//GEN-END:|195-getter|2|



















    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
        try {
            store.closeStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

}
