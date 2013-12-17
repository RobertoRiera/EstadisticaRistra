package estadisticaapplication;
//Importamos las clases necesarias

import estadisticaapplication.EstadisticasRistras;
import javax.swing.*;
import java.awt.event.*;

//Extendemos la clase JFrame para poder crear las
// ventanas y los componentes de esta, también
//implementamos la interfaz ActionListener para
//capturar los eventos de los botones
public class Practica extends JFrame implements ActionListener{
	private JTextArea area;
	private JScrollPane scroll;
	private JButton btOk, btFrecuencia, btPalabrasMasF;
	private JLabel l1,l2;
	private EstadisticasRistras es;
	
	public Practica(){
      //Crea la capa de referencia para lo demás
		setLayout(null);
		//Creamos el área donde metemos el texto, le ponemos scroll
		//las medidas y la posición
		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(10, 10, 505, 300);
		add(scroll);
		//Creamos el botón que procesa
		btOk = new JButton("OK");
		btOk.setBounds(1,375,70,25);
		add(btOk);
		btOk.addActionListener(this);
		//Creamos el botón que calcula la frecuencia de la palabra
		btFrecuencia = new JButton("Frecuencia de una palabra");
		btFrecuencia.setBounds(70,375,250,25);
		add(btFrecuencia);
		btFrecuencia.addActionListener(this);
		//Creamos el botón que calcula la palabra más frecuente
		btPalabrasMasF = new JButton("Palabra mas frecuente");
		btPalabrasMasF.setBounds(320,375,200,25);
		add(btPalabrasMasF);
		btPalabrasMasF.addActionListener(this);
		//Creamos las etiquetas
		l1 = new JLabel("Numero de palabras distintas:");
		l1.setBounds(10, 325, 300, 20);
		add(l1);
		
		l2 = new JLabel("Numero de caracteres disitintos:");
		l2.setBounds(10, 350, 300, 20);
		add(l2);
		//Ponemos el título a la ventana
		setTitle("Estadisticas de texto");
		
	}
	
	public void actionPerformed(ActionEvent e){
	   //Creamos el objeto y procesamos la ristra
		es = new EstadisticasRistras();
		es.procesa(area.getText());
		//Comprobamos que botón fue pulsado y ejecutamos lo correspondiente
		//en cada caso
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