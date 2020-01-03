
package usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jTextFieldEmpleado;
	private javax.swing.JTextField jTextFieldIp;

	public Login() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextFieldEmpleado = new javax.swing.JTextField(15);
		jButton1 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jTextFieldIp = new javax.swing.JTextField(15);

		jLabel1.setText("Nombre:");
		
		jLabel2.setText("Servidor:");
		jTextFieldIp.setText("localhost");
		jTextFieldIp.setEditable(false);
		
		jButton1.setText("Ingresar");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Principal principal = new Principal();
				try {
					principal.iniciar(jTextFieldEmpleado.getText(), jTextFieldIp.getText());
				} catch (Exception ex) {
					System.err.println("Error al iniciar" + ex.getCause());
				}
				principal.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel panel1 = new JPanel();

		panel1.setLayout(new java.awt.FlowLayout());
		panel1.add(jLabel1);
		panel1.add(jTextFieldEmpleado);
		panel1.add(jLabel2);
		panel1.add(jTextFieldIp);
		panel1.add(jButton1);
		add(panel1);
	}
	public static void main(String args[]) {
		JFrame frame = new Login();
		frame.setSize(262, 137);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}