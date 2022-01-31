import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        model = new Model();
        view = new View();
        JFrame frame = new JFrame("Encryptor");
        frame.setContentPane(view.getPanel1());
        frame.setJMenuBar(view.getMenuBar());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        view.getMenuItem1().addActionListener(new NewAL());
        view.getMenuItem().addActionListener(new SaveAL());
        view.getMenuItem2().addActionListener(new SaveAsAL());
        view.getMenuItem3().addActionListener(new OpenAL());
        view.getMenuItem4().addActionListener(new ExitAL());
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
    }
    private class NewAL implements ActionListener { //New file
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getTextArea1().setText("");
            view.setFilename("");
        }
    }
    private class SaveAL implements ActionListener { //Save file
        @Override
        public void actionPerformed(ActionEvent e) {
            String result = view.getFilename();
            if (!result.equals("")) {
                model.save(model.encrypt(view.getTextArea1().getText(),'('), result);
            }
        }
    }
    private class SaveAsAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String result = view.getNewFilename();
            if (!result.equals("")) {
                model.save(model.encrypt(view.getTextArea1().getText(),'('), result);
            }
        }
    }
    private class OpenAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String result = view.getNewFilename();
            if (!result.equals("")) {
                view.getTextArea1().setText(model.decrypt(model.load(result),'('));
            }
        }
    }
    private class ExitAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }
}
