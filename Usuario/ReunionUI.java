package usuario;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReunionUI extends javax.swing.JFrame {

    private Empleado empleado;
    private int modo;
    public ReunionUI() {
        initComponents();
        empleado= null;
    }
    public void setEmpleado(Empleado empleado, int modo){
        this.empleado=empleado;
        this.modo=modo;
    }
    public void cargar(Reunion reunion){
        this.jTextFieldTema.setEditable(false);
        this.jTextFieldTema.setText(reunion.getTema());
        this.jTextField2Lugar.setText(reunion.getLugar());
        this.jTextFieldFechaFin.setText(reunion.getFecha_fin());
        this.jTextFieldHoraFin.setText(reunion.getHora_fin());
        this.jTextFieldFechaInicio.setText(reunion.getFecha_inicio());
        this.jTextFieldHoraInicio.setText(reunion.getHora_inicio());
        for (String invitado : reunion.getInvitados()) {
            this.jTextAreaInvitados.append(invitado+"\n");
        }
    }
                         
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldHoraInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jTextFieldHoraFin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInvitados = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTema = new javax.swing.JTextField();
        jTextField2Lugar = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tema:");

        jLabel2.setText("Lugar:");

        jLabel3.setText("Inicio:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Hora:");

        jLabel6.setText("Hora:");

        jLabel7.setText("Fecha:");

        jLabel8.setText("Fin:");

        jTextFieldFechaInicio.setText("dd/mm/aa");

        jTextFieldHoraInicio.setText("00:00");
        jTextFieldHoraInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoraInicioActionPerformed(evt);
            }
        });

        jTextFieldFechaFin.setText("dd/mm/aa");

        jTextFieldHoraFin.setText("00:00");

        jTextAreaInvitados.setColumns(20);
        jTextAreaInvitados.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInvitados);

        jLabel9.setText("Invitados:");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel4))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7)))
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(51, 51, 51)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldFechaInicio)
                                        .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addComponent(jTextFieldHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTema, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jTextField2Lugar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButtonGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2Lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jTextFieldHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {                                                     
   
    }                                                    

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
      
        this.setVisible(false);
    }                                               

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                               
      
        ArrayList<String> invitados= new ArrayList<String>();
        for (String invitado : this.jTextAreaInvitados.getText().split("\n")) {
                invitados.add(invitado);
            }
        
        if (modo==1){
            Reunion reunion= new Reunion(this.jTextFieldTema.getText(), invitados, empleado.getNombre(), this.jTextField2Lugar.getText(), this.jTextFieldFechaInicio.getText(), this.jTextFieldFechaFin.getText(), this.jTextFieldHoraInicio.getText(),this.jTextFieldHoraFin.getText());
            empleado.crearReunionServidor(reunion);
        }else{
            Reunion reunion= new Reunion(this.jTextFieldTema.getText(), invitados, empleado.getNombre(), this.jTextField2Lugar.getText(), this.jTextFieldFechaInicio.getText(), this.jTextFieldFechaFin.getText(), this.jTextFieldHoraInicio.getText(),this.jTextFieldHoraFin.getText());
            empleado.modificarReunionServidor(reunion);
        }
        this.setVisible(false);
    }                                              
        
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaInvitados;
    private javax.swing.JTextField jTextField2Lugar;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldHoraFin;
    private javax.swing.JTextField jTextFieldHoraInicio;
    private javax.swing.JTextField jTextFieldTema;     
}
