package interfaz;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interfaz extends JFrame {
	public Interfaz() {
		setTitle("Escribiendo y leyendo archivos");
		setBounds(400, 200, 600, 450);
		Lamina miLamina = new Lamina();
		add(miLamina);
		setVisible(true);
	}

	class Lamina extends JPanel {
		public Lamina() {
			setLayout(new BorderLayout());
			JPanel central = new JPanel();
			JPanel inferior = new JPanel();

			// COMPONENTES CENTRALES
			area = new JTextArea("", 10, 50);
			area.setLineWrap(true);
			JScrollPane deslizarArea = new JScrollPane(area);

			// COMPONENTES INFERIORES
			boton1 = new JButton("Escribir");
			boton1.addActionListener(new Archivos(this));
			boton2 = new JButton("Borrar");
			boton2.addActionListener(new Archivos(this));
			boton3 = new JButton("Leer");
			boton3.addActionListener(new Archivos(this));

			// AÑADIR COMPONENTES
			central.add(deslizarArea);
			add(central, BorderLayout.CENTER);
			inferior.add(boton1);
			inferior.add(boton2);
			inferior.add(boton3);
			add(inferior, BorderLayout.SOUTH);
		}

		public JTextArea getArea() {
			return area;
		}

		public void setArea(JTextArea area) {
			this.area = area;
		}

		public JButton getBoton1() {
			return boton1;
		}

		public void setBoton1(JButton boton1) {
			this.boton1 = boton1;
		}

		public JButton getBoton2() {
			return boton2;
		}

		public void setBoton2(JButton boton2) {
			this.boton2 = boton2;
		}

		public JButton getBoton3() {
			return boton3;
		}

		public void setBoton3(JButton boton3) {
			this.boton3 = boton3;
		}

		private JTextArea area;
		private JButton boton1;
		private JButton boton2;
		private JButton boton3;
	}
}
