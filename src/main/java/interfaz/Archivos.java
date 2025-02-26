package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

final class Archivos implements ActionListener {
	private Interfaz.Lamina lamina; // Referencia a la clase Lamina

	// Constructor que recibe la referencia de Lamina
	public Archivos(Interfaz.Lamina lamina) {
		this.lamina = lamina;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("Escribir")) {
			escribirTexto();
		} else if (comando.equals("Borrar")) {
			borrarTexto();
		} else if (comando.equals("Leer")) {
			leerTexto();
		}
	}

	private void escribirTexto() {
		try (FileWriter documento = new FileWriter(ruta)) {
			String texto = lamina.getArea().getText();
			documento.write(texto);
			System.out.println("Texto escrito en " + ruta);
		} catch (IOException e) {
			System.err.println("Error al escribir el archivo: " + e.getMessage());
		}
	}

	private void borrarTexto() {
		lamina.getArea().setText(""); // Limpiar el JTextArea
	}

	private void leerTexto() {

		try (FileReader entrada = new FileReader(ruta)) {
			int caracter;
			while ((caracter = entrada.read()) != -1) {
				System.out.print((char) caracter);
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			e.printStackTrace();
		}
	}

	private String ruta = System.getProperty("user.home") + "/Documentos/archivo.txt";
}
