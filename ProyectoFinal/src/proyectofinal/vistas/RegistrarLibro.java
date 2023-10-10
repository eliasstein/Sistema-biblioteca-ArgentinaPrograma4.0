/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.vistas;

import javax.swing.JOptionPane;
import proyectofinal.clases.Libro;
import proyectofinal.conexiones.LibroData;
/**
 *
 * @author Chocobo
 */
public class RegistrarLibro extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarLibro
     */
    public RegistrarLibro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRActivo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jBregistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtIsbn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtEditorial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtAutor = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registrar libro");

        jRActivo.setText("¿Se encuentra activo?");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro");

        jBregistrar.setText("Registrar");
        jBregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBregistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("ISBN:");

        jLabel3.setText("Titulo:");
        jLabel3.setToolTipText("");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Editorial-año:");

        jLabel6.setText("Activo:");

        jLabel7.setText("Autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRActivo)
                            .addComponent(jtIsbn)
                            .addComponent(jtTitulo)
                            .addComponent(jtCategoria)
                            .addComponent(jtEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jtAutor))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBregistrar)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRActivo)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBregistrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBregistrarActionPerformed
        // Registrar Lector en la base de datos:
        Long Isbn=0L;
        String titulo = jtTitulo.getText();
        String categoria = jtCategoria.getText();  //Inicializamos las variables.
        String editorial = jtEditorial.getText();
        String autor = jtAutor.getText();
        try{

            if(!titulo.isEmpty() && !categoria.isEmpty() && !editorial.isEmpty() && !autor.isEmpty() && !jtIsbn.getText().isEmpty()){ //Comprobamos si algun campo clave del formulario esta vacio.
                if(jtIsbn.getText().length()>9 && jtIsbn.getText().length()<15)
                    Isbn = Long.parseLong(jtIsbn.getText());              //si todos los campos estan llenos intenta convertir el campo del Istb a entero
                else{
                    JOptionPane.showMessageDialog(this,"ERROR\nEl ISBN tiene que tener una longitud de entre 10 y 14.", "ERROR longitudinal", JOptionPane.ERROR_MESSAGE);    //Si algun campo clave esta vacio muestra un error.
                    return;//Retorna al inicio (Cancela la ejecucion del metodo)
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"ERROR\nNo puede haber campos vacios", "ERROR de campos", JOptionPane.ERROR_MESSAGE);    //Si algun campo clave esta vacio muestra un error.
                return;//Retorna al inicio (Cancela la ejecucion del metodo)
            }

        }catch(NumberFormatException ex){//Error por si no puede convertir el String a Long
            JOptionPane.showMessageDialog(this,"ERROR\nEl ISBN debe ser de tipo numerico.", "ERROR al parsear", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Si todo lo anterior funciono bien creamos un objeto de tipo Lector el cual luego sera subido a la base de datos.
        Libro libro = new Libro(Isbn,titulo,categoria,editorial,autor,jRActivo.isSelected());
        LibroData librodata = new LibroData();
        if (librodata.ExisteLibro(libro.getIsbn())){
            JOptionPane.showMessageDialog(this,"ERROR\nEl ISBN ya esta siendo utilizado por otro libro, intente cambiandolo", "ERROR ISBN ya existente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        librodata.RegistrarLibro(libro);
        JOptionPane.showMessageDialog(this, "El libro ''"+libro.getTitulo()+"'' ha sido añadido exitosamente");
        
        jtAutor.setText("");
        jtCategoria.setText("");
        jtEditorial.setText("");
        jtIsbn.setText("");
        jtTitulo.setText("");
        jRActivo.setSelected(false);
        
    }//GEN-LAST:event_jBregistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBregistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRActivo;
    private javax.swing.JTextField jtAutor;
    private javax.swing.JTextField jtCategoria;
    private javax.swing.JTextField jtEditorial;
    private javax.swing.JTextField jtIsbn;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
}
