package estadisticaapplication;
//Importamos las clases necesarias

import estadisticaapplication.EstadisticasRistras;
import javax.swing.*;
import java.awt.event.*;

public class Practica extends JFrame implements ActionListener{
	private JTextArea area;
	private JScrollPane scroll;
	private JButton btOk, btFrecuencia, btPalabrasMasF;
	private JLabel l1,l2;
	private EstadisticasRistras es;
	
	public Practica(){
		setLayout(null);
		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(10, 10, 505, 300);
		add(scroll);
		btOk = new JButton("OK");
		btOk.setBounds(1,375,70,25);
		add(btOk);
		btOk.addActionListener(this);
		btFrecuencia = new JButton("Frecuencia de una palabra");
		btFrecuencia.setBounds(70,375,250,25);
		add(btFrecuencia);
		btFrecuencia.addActionListener(this);
		btPalabrasMasF = new JButton("Palabra mas frecuente");
		btPalabrasMasF.setBounds(320,375,200,25);
		add(btPalabrasMasF);
		btPalabrasMasF.addActionListener(this);
		l1 = new JLabel("Numero de palabras distintas:");
		l1.setBounds(10, 325, 300, 20);
		add(l1);
		
		l2 = new JLabel("Numero de caracteres disitintos:");
		l2.setBounds(10, 350, 300, 20);
		add(l2);
		setTitle("Estadisticas de texto");
		
	}
	
	public void actionPerformed(ActionEvent e){
		es = new EstadisticasRistras();
		es.procesa(area.getText());
		if(e.getSource() == btOk){
			l1.setText("Numero de palabras distintas: " + es.númeroPalabras());
			l2.setText("Numero de caracteres disitintos: " + es.númeroCaracteres());
		}else if(e.getSource() == btFrecuencia){
			String s = JOptionPane.showInputDialog(null,"Palabra:","Frecuencia de una palabra",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, es.frecuenciaPalabra(s), "frecuencia de la palabra", JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == btPalabrasMasF){
			JOptionPane.showMessageDialog(null, es.másFrecuentes(100), "Palabras mas frecuente", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args){
            
		Practica ventana = new Practica();
		ventana.setBounds(0,0,526,450);
		ventana.setResizable(false);
		ventana.setVisible(true);

	}
}