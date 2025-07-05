import java.security.MessageDigest;
import java.util.Scanner;

public class Hashpassw {
    public static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner s= new Scanner(System.in);
        String password= s.nextLine();
        String hashed = hashPassword(password);
        System.out.println("Hashed Password: " + hashed);
    }
}
