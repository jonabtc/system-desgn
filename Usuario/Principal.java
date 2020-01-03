package usuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal extends javax.swing.JFrame {

    
    Empleado empleado;
    public Principal()  {
        initComponents();         
    }
    public void iniciar(String nombre, String ip)throws IOException, FileNotFoundException, ClassNotFoundException{
        empleado= new Empleado(nombre, 8896, new ServidorCentral(ip, 8989));
        this.jLabelnombre.setText(nombre);      
    }
                              
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelnombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonMRCreada = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCreadas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaInvitado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jButtonMRInvitado = new javax.swing.JButton();
        jTextFieldNumeRCreada = new javax.swing.JTextField();
        jTextFieldNumeRInvita = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jButton1.setText("Crear Reunion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonMRCreada.setText("Modificar Reunion");
        jButtonMRCreada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMRCreadaActionPerformed(evt);
            }
        });

        jTextAreaCreadas.setEditable(false);
        jTextAreaCreadas.setColumns(20);
        jTextAreaCreadas.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCreadas);

        jTextAreaInvitado.setEditable(false);
        jTextAreaInvitado.setColumns(20);
        jTextAreaInvitado.setRows(5);
        jScrollPane2.setViewportView(jTextAreaInvitado);

        jLabel2.setText("Creadas");

        jLabel3.setText("Invitado");

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonMRInvitado.setText("Modificar Reunion");
        jButtonMRInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMRInvitadoActionPerformed(evt);
            }
        });

        jTextFieldNumeRCreada.setText("1");

        jTextFieldNumeRInvita.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonMRCreada)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNumeRCreada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonMRInvitado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldNumeRInvita, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(32, 32, 32)
                                        .addComponent(jButtonActualizar)))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonActualizar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMRCreada)
                    .addComponent(jButtonMRInvitado)
                    .addComponent(jTextFieldNumeRCreada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumeRInvita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ReunionUI cr = new ReunionUI();
        cr.setEmpleado(empleado,1);
        cr.setVisible(true);
    }                                        

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int contador=1;
        for (Reunion reunion : empleado.getReunionesCreadas()) {
            this.jTextAreaCreadas.append("********  "+contador+"  ********\n");
            this.jTextAreaCreadas.append("Tema: "+ reunion.getTema()+"\n");
            this.jTextAreaCreadas.append("Lugar: "+reunion.getLugar()+"\n");
            this.jTextAreaCreadas.append("Inicio: "+reunion.getFecha_inicio()+" "+reunion.getHora_inicio()+"\n");
            this.jTextAreaCreadas.append("Fin: "+reunion.getFecha_fin()+" "+reunion.getHora_fin()+"\n");
            contador=contador+1;
        }
        for (Reunion reunion : empleado.getReunionesInvitado()) {
            this.jTextAreaInvitado.append("********  "+contador+"  ********\n");
            this.jTextAreaInvitado.append("Tema: "+ reunion.getTema()+"\n");
            this.jTextAreaInvitado.append("Lugar: "+reunion.getLugar()+"\n");
            this.jTextAreaInvitado.append("Inicio: "+reunion.getFecha_inicio()+" "+reunion.getHora_inicio()+"\n");
            this.jTextAreaInvitado.append("Fin: "+reunion.getFecha_fin()+" "+reunion.getHora_fin()+"\n");
            contador=contador+1;
        }
        
        
    }                                                 

    private void jButtonMRInvitadoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        Reunion reunion= empleado.getReunionesInvitado().get(Integer.parseInt(this.jTextFieldNumeRInvita.getText())-1);
        ReunionUI cr = new ReunionUI();
        cr.setEmpleado(empleado, 2);
        cr.cargar(reunion);
        cr.setVisible(true);
    }                                                 

    private void jButtonMRCreadaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        Reunion reunion= empleado.getReunionesCreadas().get(Integer.parseInt(this.jTextFieldNumeRCreada.getText())-1);
        ReunionUI cr = new ReunionUI();
        cr.setEmpleado(empleado, 2);
        cr.cargar(reunion);
        cr.setVisible(true);
        
        
    }                                               



    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonMRCreada;
    private javax.swing.JButton jButtonMRInvitado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelnombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaCreadas;
    private javax.swing.JTextArea jTextAreaInvitado;
    private javax.swing.JTextField jTextFieldNumeRCreada;
    private javax.swing.JTextField jTextFieldNumeRInvita;
    // End of variables declaration                   
}
