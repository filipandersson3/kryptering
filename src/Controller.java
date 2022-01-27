public class Controller {
    public static void main(String[] args) {
        char key = '(';
        String message = "HEJ";
        Model model = new Model();
        System.out.println(model.encrypt(message, key));
        model.save(model.encrypt(message, key),"encrypted.bin");
        System.out.println(model.load("encrypted.bin"));
    }
}
