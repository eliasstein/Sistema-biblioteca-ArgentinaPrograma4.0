
package proyectofinal.vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectofinal.conexiones.PrestamoData;
import proyectofinal.clases.Prestamo;
import proyectofinal.conexiones.EjemplarData;
import proyectofinal.clases.Ejemplar;


public class DevolverPrestamo extends javax.swing.JInternalFrame {
    private DefaultTableModel tabla1 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }//Para que la tabla no sea editable con el doble click
    };
    
    private DefaultTableModel tabla2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }//Para que la tabla no sea editable con el doble click
    };
    
    public DevolverPrestamo() {
        initComponents();
        CargarColumnasTabla1();
        CargarFilasTabla1();
        CargarColumnasTabla2();
        //Desactivar filtros
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jTextField1.setVisible(false);
            jDateChooser1.setVisible(false);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Devolver prestamo");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectofinal/vistas/education_books_library_icon_149685.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Devolucion");

        jLabel2.setText("Prestamos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Devolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtros");

        jLabel7.setText("El prestamo sucedio en esta fecha:");

        jCheckBox1.setText("Por fecha");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Por autor");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel8.setText("El nombre del autor empieza por:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(358, 358, 358))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(315, 315, 315))))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6)
                        .addGap(196, 196, 196)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jCheckBox1))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel8)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        
                
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        /*
        int filaSeleccionada = jTable1.getSelectedRow();
        int idLector=(Integer)tabla1.getValueAt(filaSeleccionada, 0);  //id_Lector
        int idEjemplar=(Integer)(tabla1.getValueAt(filaSeleccionada, 2));  //id_Ejemplar
        CargarFilasTabla2(idLector,idEjemplar);
        */
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Nos retorna 0 si es verdadero 2 si es falso.
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar este registro?","Eliminacion de registro",JOptionPane.OK_CANCEL_OPTION);
        switch(option){ //Si la opcion es afirmativa pasa lo siguiente.
            case 0:
                try{
                int idPrestamo=(Integer)tabla2.getValueAt(jTable2.getSelectedRow(), 4);
                int idEjemplar=(Integer)tabla2.getValueAt(jTable2.getSelectedRow(), 5); //Obtenemos los id para hacer una consulta.
                int idLector=(Integer)tabla1.getValueAt(jTable1.getSelectedRow(), 0);
                if(idPrestamo != -1 && idEjemplar!=-1 && idLector!=-1){                 //Si todos los id son validos.
                    EjemplarData ejemplarData = new EjemplarData();
                    //Modificamos la cantidad de ejemplares.
                    Ejemplar ejeliminado = ejemplarData.buscarEjemplarPorid(idEjemplar);    //Buscamos un ejemplar por su id
                    ejeliminado.setCantidad(ejeliminado.getCantidad()+1);               //Incrementamos su cantidad en 1
                    ejemplarData.modificarEjemplar(ejeliminado);                        //y lo guardamos en la base de datos
                    //Eliminamos el prestamo.
                    PrestamoData prestamoData = new PrestamoData();                     
                    prestamoData.EliminarPrestamo(idPrestamo);                          //Eliminamos un prestamo por su id
                    //Actualizamos las tablas
                    CargarFilasTabla2(idLector, (Integer)(tabla1.getValueAt(jTable1.getSelectedRow(), 2))); //Actualizamos las filas de la tabla 2
                    CargarFilasTabla1();    //Actualizamos las filas de la tabla 1
                }
                else JOptionPane.showMessageDialog(this, "Seleccione al menos una fila en ambas tablas.");
                }
                catch(java.lang.ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(this, "Seleccione al menos una fila en ambas tablas.");
                }
                break;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        //Si se preciona el boton de "por fecha" hace visible el jdatechooser y el label
        if (jCheckBox1.isSelected()){
            jLabel7.setVisible(true);
            jDateChooser1.setVisible(true);
        }
        else{
            jLabel7.setVisible(false);
            jDateChooser1.setVisible(false);
            jDateChooser1.setDate(null);

        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        //Si se preciona el boton de "por autor" hace visible el textbox y el label sino no.
        if (jCheckBox2.isSelected()){
            jLabel8.setVisible(true);
            jTextField1.setVisible(true);
        }
        else{
            jLabel8.setVisible(false);
            jTextField1.setVisible(false);
            jTextField1.setText("");
        }
             
        
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Boton de busqueda el cual cargara las filas de la segunda tabla.
        int filaSeleccionada = jTable1.getSelectedRow();
        int idLector=(Integer)tabla1.getValueAt(filaSeleccionada, 0);  //id_Lector
        int idEjemplar=(Integer)(tabla1.getValueAt(filaSeleccionada, 2));  //id_Ejemplar
        CargarFilasTabla2(idLector,idEjemplar);
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
    private static void LimpiarTabla(JTable jtable, DefaultTableModel table){   //Metodo para limpiar tablas.
        int f = jtable.getRowCount()-1;
        for(int x=f;x>=0;x--){
            table.removeRow(x);
        }
    }
    
    private void CargarColumnasTabla1(){    //Cargamos las columnas de la primera tabla
        tabla1.addColumn("ID Lector");
        tabla1.addColumn("Nombre");
        tabla1.addColumn("ID Ejemplar");
        tabla1.addColumn("Titulo");
        tabla1.addColumn("Estado");
        tabla1.addColumn("Cantidad");
        jTable1.setModel(tabla1);
    }
    private void CargarFilasTabla1(){
        LimpiarTabla(jTable1, tabla1);
        PrestamoData prestamoData = new PrestamoData();
        for (Prestamo p :prestamoData.buscarPrestamos()){   //Cargamos las filas de la primera tabla al iniciar el internal frame
            tabla1.addRow(new Object[]{
                p.getLector().getNmroSocio(),
                p.getLector().getNombre(),
                p.getEjemplar().getCodigo(),
                p.getEjemplar().getLibro().getTitulo(),
                p.getEjemplar().getEstado(),
                p.getCantidad()});
        }
    }
    
    private void CargarColumnasTabla2(){    //Cargamos las columnas de la segunda tabla
        tabla2.addColumn("Titulo");
        tabla2.addColumn("Autor");
        tabla2.addColumn("Fecha inicio");
        tabla2.addColumn("Fecha fin");
        tabla2.addColumn("ID prestamo");
        tabla2.addColumn("ID ejemplar");
        tabla2.addColumn("Caducado");
        jTable2.setModel(tabla2);
    }
    private void CargarFilasTabla2(int idLector, int idEjemplar){
        LimpiarTabla(jTable2, tabla2);//Limpiamos la segunda tabla para no almacenar valores basura
        boolean encontro=false;
        PrestamoData prestamoData = new PrestamoData();
        for (Prestamo p :prestamoData.BuscarPrestamoPorIds(idLector, idEjemplar)){
            if (jCheckBox1.isSelected()){//Si el filtro de fecha esta activo
                try{
                LocalDate date1=jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(!date1.isEqual(p.getFechafin())) //Si la fecha no es igual a la fecha ingresada en el datechooser
                    continue;
                }
                catch(java.lang.NullPointerException ex){
                   JOptionPane.showMessageDialog(this, "Error la fecha no puede estar vacia");
                   return;
                }
            }
            if (jCheckBox2.isSelected()){//Si el filtro de por autor esta activo.
                try{
                String autor=jTextField1.getText();
                if(!p.getEjemplar().getLibro().getAutor().toLowerCase().startsWith(autor.toLowerCase()))//Si el nombre no empieza por los caracteres ingresados en el textobox
                    continue;
                }
                catch(java.lang.NullPointerException ex){
                   JOptionPane.showMessageDialog(this, "Error la fecha no puede estar vacia");
                   return;
                }
            }
            //Cargamos las filas de nuestra segunda tabla.
            tabla2.addRow(new Object[]{
            p.getEjemplar().getLibro().getTitulo(),
            p.getEjemplar().getLibro().getAutor(),
            p.getFechainicio(),
            p.getFechafin(),
            p.getIdPrestamo(),
            p.getEjemplar().getCodigo(),
            LocalDate.now().isAfter(p.getFechafin())});
            encontro=true;
        }
        if (encontro==false)    //Luego de terminar el bucle for revisamos si encontro al menos un valor
            JOptionPane.showMessageDialog(this,"No se encontraron resultados, pruebe cambiando los filtros.");
    }
    

}
