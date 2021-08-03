package LibraryFunctions;

public class Hasher {

    public static String hashPassword(String password) {
        return password;
    }

    public static boolean CompareHashed(String databasePassword, String userEnteredPassword) {
        return hashPassword(userEnteredPassword).equals(databasePassword);
    }

}
