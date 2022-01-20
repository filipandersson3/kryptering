public class Controller {
    public static void main(String[] args) {
        char key = '(';
        String message = "HEJ";
        Model model = new Model();
        model.encrypt(message, key);
    }
}
