import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
    public ArrayList<Byte> encrypt(String message, String key) {
        ArrayList<Byte> encrypted = new ArrayList<Byte>();
        byte[] encryptedchar = null;
        for (int i = 0; key.length() < message.length(); i++) {
            key += key.charAt(i);
        }
        for (int i = 0; i < message.length(); i++) {
            int byteCount = 0;
            encryptedchar = ByteBuffer.allocate(4).putInt(message.charAt(i) ^ key.charAt(i)).array();
            for (byte b : encryptedchar) {
                if (byteCount > 2) {
                    encrypted.add(b);
                    if (byteCount == 4) {
                        byteCount = 0;
                    }
                }
                byteCount++;
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

    public byte[] load(String filename) {
        byte[] encryptedString = new byte[0];
        try {
            encryptedString = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(byte[] load, String key) {
        String decrypted = "";
        for (int i = 0; key.length() < load.length; i++) {
            key += key.charAt(i);
        }
        for (int i = 0; i < load.length; i++) {
            decrypted += (char)(load[i]^key.charAt(i));
        }
        return decrypted;
    }
}
