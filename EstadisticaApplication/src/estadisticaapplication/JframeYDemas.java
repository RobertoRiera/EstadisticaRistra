package estadisticaapplication;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JframeYDemas extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton button1, button2;
    private JLabel label;

    public JframeYDemas() {
        setLayout(null);
        label = new JLabel();
        textArea = new JTextArea();
        button1 = new JButton("Rábano");
        button2 = new JButton("Caca");
        textArea.setBounds(10, 10, 350, 200);
        button1.setBounds(10, 225, 70, 20);
        button2.setBounds(110, 225, 70, 20);
//        label.setBounds(200, 225, 70, 20);
        label.setLocation(200, 225);
        label.setSize(1100, 200);
        label.setText("Esto es:");
        button1.addActionListener(this);
        button2.addActionListener(this);
        add(textArea);
        add(button1);
        add(button2);
        add(label);

        setTitle("El pene de Platón no era de cartón");
        setBounds(100, 100, 390, 290);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1){
            label.setText(textArea.getText());
        }else{
            label.setText(textArea.getText());
        }
    }

}
