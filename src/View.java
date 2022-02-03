import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class View {
    private JPanel panel1;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private String filename = "";
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;


    public View() {
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        menuItem1 = new JMenuItem("New");
        menu1.add(menuItem1);
        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menu1.add(menuItem);
        menuItem2 = new JMenuItem("Save as...");
        menu1.add(menuItem2);
        menuItem3 = new JMenuItem("Open...");
        menu1.add(menuItem3);
        menu1.addSeparator();
        menuItem4 = new JMenuItem("Exit");
        menu1.add(menuItem4);
        menuBar.add(menu1);
    }

    public JMenuItem getMenuItem1() {
        return menuItem1;
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public JMenuItem getMenuItem2() {
        return menuItem2;
    }

    public JMenuItem getMenuItem3() {
        return menuItem3;
    }

    public JMenuItem getMenuItem4() {
        return menuItem4;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public String getFilename() {
        if (filename.equals("")) {
            return getNewFilename();
        } else {
            return filename;
        }
    }
    public String getNewFilename() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result!=JFileChooser.APPROVE_OPTION){
            JOptionPane.showConfirmDialog(null,
                    "No file was chosen", "Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            return "";
        } else {
            filename = fc.getSelectedFile().getAbsolutePath();
            return filename;
        }
    }

    public String getKey() {
        String result = "";
        try {
            while (result.equals("")) {
                result = JOptionPane.showInputDialog(null, "Enter key");
            }
        } catch (NullPointerException e) {
            return null;
        }
        return result;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
