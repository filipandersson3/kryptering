public class Model {
    public void encrypt(String message, char key) {
        String encrypted = "";
        String encryptedchar;
        for (int i = 0; i < message.length(); i++) {
            encryptedchar = Integer.toBinaryString(message.charAt(i) ^ key);
            while (encryptedchar.length() < 16) {
                encryptedchar = "0" + encryptedchar;
            }
            encrypted += encryptedchar;
        }
        System.out.println(encrypted);
        int stringpos = 0;
        for (int i = 0; i < 16; i++) {

            stringpos++;
        }
        System.out.println(Integer.parseInt("0000000001100000",2));
    }

}
