import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToeApp {

	static class Memento {
		ArrayList<String> listaSelecciones;
		ArrayList<Integer> listaIndicesBotones;
		ArrayList<String> listaSeleccionesRedo;
		ArrayList<Integer> listaIndicesBotonesRedo;
		ArrayList<JButton> cuadros;

		StateHolder states = new StateHolder();

		Memento() {
			listaSelecciones = new ArrayList<>();
			listaIndicesBotones = new ArrayList<>();
			listaSeleccionesRedo = new ArrayList<>();
			listaIndicesBotonesRedo = new ArrayList<>();
		}

		public ArrayList<String> getListaSelecciones() {
			return listaSelecciones;
		}

		public ArrayList<Integer> getListaBotonesDo() {
			return listaIndicesBotones;
		}

		public ArrayList<String> getListaSeleccionesRedo() {
			return listaSeleccionesRedo;
		}

		public ArrayList<Integer> getListaBotonesRedo() {
			return listaIndicesBotonesRedo;
		}

		public void genereraUndo(String str, Integer i) {
			listaSelecciones.add(str);
			listaIndicesBotones.add(i);
		}

		public void genereraRedo(String str, Integer i) {
			listaSeleccionesRedo.add(str);
			listaIndicesBotonesRedo.add(i);
		}

		public void eliminarTodo() {
			listaSelecciones.clear();
			listaIndicesBotones.clear();
			listaSeleccionesRedo.clear();
			listaIndicesBotonesRedo.clear();
		}

		public void generarBackup(ArrayList<JButton> btn) {
			cuadros = btn;
			states.setBackup(this);
		}

		public ArrayList<JButton> getBotones() {
			return cuadros;
		}

		public Memento obtenerBackup() {

			return states.getBackup(states.getSize());
		}

		public int obtenerSize() {
			return states.getSize();
		}
	}

	/**
	 * Application starter.
	 */

	/**
	 * Used for integration into the universal demo application.
	 */
	private int numClicks = 0;
	private String strSymbol;

	public JFrame constructApplicationFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new TicTacToePanel();
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	/**
	 * Simple panel to control the game.
	 */
	private class TicTacToePanel extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;

		JButton clearButton;
		JButton undoBtn;
		JButton redoBtn;
		ArrayList<JButton> squares;

		Memento memento = new Memento();
		JPanel spanel = new JPanel();

		TicTacToePanel() {
			this.setLayout(new BorderLayout());
			JPanel btnsContainer = new JPanel();

			undoBtn = new JButton("Undo");
			btnsContainer.add(undoBtn);

			redoBtn = new JButton("Redo");
			btnsContainer.add(redoBtn);

			clearButton = new JButton("Clear");
			clearButton.addActionListener(this);
			btnsContainer.add(clearButton);

			undoBtn.addActionListener(this);
			redoBtn.addActionListener(this);

			add(btnsContainer, BorderLayout.NORTH);			
			spanel.setLayout(new GridLayout(3, 3));
			add(spanel, BorderLayout.CENTER);
			squares = new ArrayList<>(9);
			Font f = new java.awt.Font(Font.SANS_SERIF, Font.PLAIN, 32);
			for (int i = 0; i < 9; i++) {
				JButton square = new JButton("");
				square.setFont(f);
				square.setBackground(Color.WHITE);
				square.addActionListener(this);
				squares.add(square);
				spanel.add(square);
			}
		}

		public ArrayList<JButton> getSquares() {
			return squares;
		}

		/**
		 * Handles all button events and updates the view.
		 */
		@Override
		public void actionPerformed(ActionEvent ae) {
			JButton btnClicked = (JButton) ae.getSource();
			String btnLabel = btnClicked.getText();

			if (btnClicked == clearButton) {
				String val = "";
				for (int i = 0; i < 9; i++)
					squares.get(i).setText(val);
				numClicks = 0;
				memento.generarBackup(squares);
				memento.eliminarTodo();
			}

			if (btnClicked != undoBtn && btnClicked != redoBtn && btnClicked != clearButton && btnLabel.equals("")) {
				if (++numClicks % 2 == 1) {
					btnClicked.setText("X");

					strSymbol = "X";

					memento.genereraUndo(strSymbol, squares.indexOf(btnClicked));

				} else {
					btnClicked.setText("O");

					strSymbol = "O";

					memento.genereraUndo(strSymbol, squares.indexOf(btnClicked));
				}
			}

			if (btnClicked == undoBtn) {
				if (memento.getListaSelecciones().size() > 0 && memento.getListaBotonesDo().size() > 0) {
					int index = memento.getListaBotonesDo().get(memento.getListaBotonesDo().size() - 1);
					String str = memento.getListaSelecciones().get(memento.getListaSelecciones().size() - 1);

					squares.get(index).setText("");
					strSymbol = "";

					memento.genereraRedo(str, index);
					memento.getListaBotonesDo().remove(memento.getListaBotonesDo().size() - 1);
					memento.getListaSelecciones().remove(memento.getListaSelecciones().size() - 1);

				}
			}
			if (btnClicked == redoBtn) {
				if (memento.getListaSeleccionesRedo().size() > 0 && memento.getListaBotonesRedo().size() > 0
						&& numClicks > 0) {
					int index = memento.getListaBotonesRedo().get(memento.getListaBotonesRedo().size() - 1);
					String str = memento.getListaSeleccionesRedo().get(memento.getListaSeleccionesRedo().size() - 1);

					squares.get(index).setText(str);
					strSymbol = str;

					memento.genereraUndo(str, index);
					memento.getListaBotonesRedo().remove(memento.getListaBotonesRedo().size() - 1);
					memento.getListaSeleccionesRedo().remove(memento.getListaSeleccionesRedo().size() - 1);
				}
				if (numClicks == 0) {
					Memento memento2 = memento.obtenerBackup();
					spanel.removeAll();
					ArrayList<JButton> cuadros = memento2.getBotones();
					for(int i=0; i<9;i++)
						spanel.add(cuadros.get(i));
					repaint();
				}

			}

		}
	}
}
