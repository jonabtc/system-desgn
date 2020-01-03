package usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class Principal extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JButton actualizarBtn;
	private JButton editCreador;
	private JButton editInvitado;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabelnombre;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTextArea areaReuniones;
	private JTextArea areaInvitados;
	private JTextField textNumeroReunion;
	private JTextField textNumeroInvitado;

	Empleado empleado;

	public Principal() {
		initComponents();
	}

	public void iniciar(String nombre, String ip) throws IOException, FileNotFoundException, ClassNotFoundException {
		empleado = new Empleado(nombre, 8896, new ServidorCentral(ip, 8989));
		this.jLabelnombre.setText(nombre);
	}

	private void initComponents() {

		jLabel1 = new JLabel();
		jLabelnombre = new JLabel();
		jButton1 = new JButton();
		editCreador = new JButton();
		jScrollPane1 = new JScrollPane();
		areaReuniones = new JTextArea();
		jScrollPane2 = new JScrollPane();
		areaInvitados = new JTextArea();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		actualizarBtn = new JButton();
		editInvitado = new JButton();
		textNumeroReunion = new JTextField();
		textNumeroInvitado = new JTextField();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Nombre");

		jButton1.setText("Agendar una reunion");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		editCreador.setText("Editar reunion");
		editCreador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				editCreadorActionPerformed(evt);
			}
		});

		areaReuniones.setEditable(false);
		areaReuniones.setColumns(20);
		areaReuniones.setRows(5);
		jScrollPane1.setViewportView(areaReuniones);

		areaInvitados.setEditable(false);
		areaInvitados.setColumns(20);
		areaInvitados.setRows(5);
		jScrollPane2.setViewportView(areaInvitados);

		jLabel2.setText("Creadas");

		jLabel3.setText("Invitado");

		actualizarBtn.setText("Actualizar");
		actualizarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				actualizarBtnActionPerformed(evt);
			}
		});

		editInvitado.setText("Editar Reunion");
		editInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				editInvitadoActionPerformed(evt);
			}
		});

		textNumeroReunion.setText("1");

		textNumeroInvitado.setText("1");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(editCreador)
												.addGap(18, 18, 18).addComponent(textNumeroReunion,
														GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel2)))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
												.addGap(18, 18, 18).addComponent(jLabelnombre,
														GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(10, 10,
														10)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
																		279, GroupLayout.PREFERRED_SIZE)
																.addGap(32, 32, 32)
																.addGroup(layout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel3)
																		.addComponent(jScrollPane2,
																				GroupLayout.PREFERRED_SIZE, 286,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(editInvitado)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(textNumeroInvitado,
																						GroupLayout.PREFERRED_SIZE, 21,
																						GroupLayout.PREFERRED_SIZE))))
														.addGroup(layout.createSequentialGroup().addComponent(jButton1)
																.addGap(32, 32, 32)
																.addComponent(actualizarBtn)))))))
				.addContainerGap(22, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(jLabelnombre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButton1)
								.addComponent(actualizarBtn))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
								.addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(editCreador).addComponent(editInvitado).addComponent(
										textNumeroReunion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textNumeroInvitado, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 216,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 216,
												GroupLayout.PREFERRED_SIZE))
						.addGap(21, 21, 21)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		ReunionUI cr = new ReunionUI();
		cr.setEmpleado(empleado, 1);
		cr.setVisible(true);
	}

	private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {
		int contador = 1;
		for (Reunion reunion : empleado.getReunionesCreadas()) {
			this.areaReuniones.append(contador + ".-\n");
			this.areaReuniones.append("Tema: " + reunion.getTema() + "\n");
			this.areaReuniones.append("Lugar: " + reunion.getLugar() + "\n");
			this.areaReuniones
					.append("Inicio: " + reunion.getFecha_inicio() + " " + reunion.getHora_inicio() + "\n");
			this.areaReuniones.append("Fin: " + reunion.getFecha_fin() + " " + reunion.getHora_fin() + "\n");
			contador = contador + 1;
		}
		for (Reunion reunion : empleado.getReunionesInvitado()) {
			this.areaInvitados.append(contador + ".-\n");
			this.areaInvitados.append("Tema: " + reunion.getTema() + "\n");
			this.areaInvitados.append("Lugar: " + reunion.getLugar() + "\n");
			this.areaInvitados
					.append("Inicio: " + reunion.getFecha_inicio() + " " + reunion.getHora_inicio() + "\n");
			this.areaInvitados.append("Fin: " + reunion.getFecha_fin() + " " + reunion.getHora_fin() + "\n");
			contador = contador + 1;
		}

	}

	private void editInvitadoActionPerformed(java.awt.event.ActionEvent evt) {
		Reunion reunion = empleado.getReunionesInvitado()
				.get(Integer.parseInt(this.textNumeroInvitado.getText()) - 1);
		ReunionUI cr = new ReunionUI();
		cr.setEmpleado(empleado, 2);
		cr.cargar(reunion);
		cr.setVisible(true);
	}

	private void editCreadorActionPerformed(java.awt.event.ActionEvent evt) {
		Reunion reunion = empleado.getReunionesCreadas()
				.get(Integer.parseInt(this.textNumeroReunion.getText()) - 1);
		ReunionUI cr = new ReunionUI();
		cr.setEmpleado(empleado, 2);
		cr.cargar(reunion);
		cr.setVisible(true);

	}

}
