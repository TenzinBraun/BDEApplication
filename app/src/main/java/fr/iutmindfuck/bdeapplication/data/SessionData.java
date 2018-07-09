package fr.iutmindfuck.bdeapplication.data;

import java.util.ArrayList;
import java.util.HashMap;

public class SessionData {

    private static final SessionData ourInstance = new SessionData();
    public static SessionData getInstance() {
        return ourInstance;
    }

    private SessionData() {}


    /* ************************/
    /* Basic class Attributes */
    /**************************/

    private boolean isMember;
    private String userID;

    /**
     * Used to save the current answer of a user for a specific question
     *
     * Format :
     *   Key   : <MCQ_ID>_<QUESTION_ID>
     *   Value : List of answer index that have been marked as true (with '_' separator)
     */
    private final HashMap<String, ArrayList<Boolean>> mcqUserAnswerSave = new HashMap<>();

    public boolean isMember() {
        return isMember;
    }
    public String getUserID() {
        return userID;
    }


    public static void createNewSession(String userID, boolean isTeacher) {
        ourInstance.userID = userID;
        ourInstance.isMember = isTeacher;
    }

    public static void createNewSession(boolean isMember){
        ourInstance.isMember = isMember;
    }
}
