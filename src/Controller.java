import java.util.Arrays;

public class Controller {
    public static void main(String[] args) {
        char key = '(';
        String message = "HEJ";
        Model model = new Model();
        System.out.println(model.encrypt(message, key));
        model.save(model.encrypt(message, key),"encrypted.bin");
        System.out.println(Arrays.toString(model.load("encrypted.bin")));
        System.out.println(model.decrypt(model.load("encrypted.bin"), key));
    }
}
