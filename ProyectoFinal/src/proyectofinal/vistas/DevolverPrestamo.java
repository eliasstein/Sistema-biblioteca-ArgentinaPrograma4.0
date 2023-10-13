
package proyectofinal.vistas;

import java.time.LocalDate;
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
        }
    };
    
    private DefaultTableModel tabla2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }
    };
    
    public DevolverPrestamo() {
        initComponents();
        CargarColumnasTabla1();
        CargarFilasTabla1();
        CargarColumnasTabla2();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Devolver prestamo");

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

        jLabel4.setText("Prestamos por unidad");

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
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(358, 358, 358))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(315, 315, 315))))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(330, 330, 330))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
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
        int filaSeleccionada = jTable1.getSelectedRow();
        int idLector=(Integer)tabla1.getValueAt(filaSeleccionada, 0);  //id_Lector
        int idEjemplar=(Integer)(tabla1.getValueAt(filaSeleccionada, 2));  //id_Ejemplar
        CargarFilasTabla2(idLector,idEjemplar);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Nos retorna 0 si es verdadero 2 si es falso.
        int option = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar este registro?","Eliminacion de registro",JOptionPane.OK_CANCEL_OPTION);
        switch(option){
            case 0:
                try{
                int idPrestamo=(Integer)tabla2.getValueAt(jTable2.getSelectedRow(), 4);
                int idEjemplar=(Integer)tabla2.getValueAt(jTable2.getSelectedRow(), 5);
                int idLector=(Integer)tabla1.getValueAt(jTable1.getSelectedRow(), 0);
                if(idPrestamo != -1 && idEjemplar!=-1 && idLector!=-1){
                    EjemplarData ejemplarData = new EjemplarData();
                    //Modificamos la cantidad de ejemplares.
                    Ejemplar ejeliminado = ejemplarData.buscarEjemplarPorid(idEjemplar);
                    ejeliminado.setCantidad(ejeliminado.getCantidad()+1);
                    ejemplarData.modificarEjemplar(ejeliminado);
                    //Eliminamos el prestamo.
                    PrestamoData prestamoData = new PrestamoData();
                    prestamoData.EliminarPrestamo(idPrestamo);
                    //Actualizamos las tablas
                    CargarFilasTabla2(idLector, (Integer)(tabla1.getValueAt(jTable1.getSelectedRow(), 2)));
                    CargarFilasTabla1();
                }
                else JOptionPane.showMessageDialog(this, "Seleccione al menos una fila en ambas tablas.");
                }
                catch(java.lang.ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(this, "Seleccione al menos una fila en ambas tablas.");
                }
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    
    private static void LimpiarTabla(JTable jtable, DefaultTableModel table){
        int f = jtable.getRowCount()-1;
        for(int x=f;x>=0;x--){
            table.removeRow(x);
        }
    }
    
    private void CargarColumnasTabla1(){
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
        for (Prestamo p :prestamoData.buscarPrestamos()){
            tabla1.addRow(new Object[]{
                p.getLector().getNmroSocio(),
                p.getLector().getNombre(),
                p.getEjemplar().getCodigo(),
                p.getEjemplar().getLibro().getTitulo(),
                p.getEjemplar().getEstado(),
                p.getCantidad()});
        }
    }
    
    private void CargarColumnasTabla2(){
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
        LimpiarTabla(jTable2, tabla2);
        PrestamoData prestamoData = new PrestamoData();
        for (Prestamo p :prestamoData.BuscarPrestamoPorIds(idLector, idEjemplar)){
            tabla2.addRow(new Object[]{
            p.getEjemplar().getLibro().getTitulo(),
            p.getEjemplar().getLibro().getAutor(),
            p.getFechainicio(),
            p.getFechafin(),
            p.getIdPrestamo(),
            p.getEjemplar().getCodigo(),
            LocalDate.now().isAfter(p.getFechafin())});
        }
    }
    

}
