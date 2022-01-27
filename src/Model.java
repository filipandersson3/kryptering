import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Model {
    public ArrayList<Byte> encrypt(String message, char key) {
        ArrayList<Byte> encrypted = new ArrayList<Byte>();
        byte[] encryptedchar = null;
        for (int i = 0; i < message.length(); i++) {
            encryptedchar = ByteBuffer.allocate(4).putInt(message.charAt(i) ^ key).array();
            for (byte b : encryptedchar) {
                encrypted.add(b);
            }
        }
        return encrypted;
    }

    public void save(ArrayList<Byte> encrypted, String filename) {
        DataOutputStream binOut = null;
        try {
            binOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            for (Byte b:
                 encrypted) {
                binOut.write(b);
            }
            binOut.flush();
            binOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load(String filename) {
        DataInputStream binIn = null;
        try {
            binIn = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        int byteInt;
        String encryptedString = "";
        try {
            while ((byteInt = binIn.readByte()) != -1) {
                encryptedString += binIn.readByte();
            }
        } catch (IOException ignored) {}
        return encryptedString;
    }
}
