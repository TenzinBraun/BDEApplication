package fr.iutmindfuck.bdeapplication.manager;

import fr.iutmindfuck.bdeapplication.service.SQLServices;

public class UserSQLManager {
    private static final String USER_TABLE = "User";
    private static final String USER_PASSWORD = "password";

    private final SQLServices sqlServices;

    public UserSQLManager(SQLServices sqlServices) {
        this.sqlServices = sqlServices;
    }

    public static String getSQLForUserTableCreation() {
        return "CREATE TABLE " + USER_TABLE + "(" +
                USER_PASSWORD + " varchar(64))";

    }

    public boolean isPasswordCorrectFor(String password) {
        return sqlServices.isResultsMatching(USER_TABLE, new String[]{USER_PASSWORD},USER_PASSWORD + " = ? ",new String[]{password});
    }
}
