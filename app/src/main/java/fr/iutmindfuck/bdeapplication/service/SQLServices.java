package fr.iutmindfuck.bdeapplication.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.iutmindfuck.bdeapplication.manager.UserSQLManager;

public class SQLServices extends SQLiteOpenHelper{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "BDE-EVENT";

    public SQLServices(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createUserLinkedTables(sqLiteDatabase);
        initializePasswordMember(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void createUserLinkedTables(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserSQLManager.getSQLForUserTableCreation());
    }

    public boolean isResultsMatching(String table, String[] select,
                                     String where, String[] whereValues) {
        Cursor cursor = getData(table, select, where, whereValues);

        boolean isResult = cursor.moveToFirst();
        cursor.close();

        return isResult;
    }

    public Cursor getData(String table, String select[], String where, String whereValues[]) {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.query(table, select,
                where, whereValues,
                null, null, null);
    }

    private void initializePasswordMember(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("INSERT INTO `User` (password) VALUES ('bigg');");
    }
}
