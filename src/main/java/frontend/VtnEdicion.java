package frontend;

import analizadorJson.analizador.Analizar;
import analizadorJson.tablaSimbolos.TablaSimbolosJson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class VtnEdicion extends javax.swing.JFrame {

    private File archivoJson;
    private File archivoDef;
    private TablaSimbolosJson tablaSimbolosJson = new TablaSimbolosJson();
    private NumeroLinea numLineaJson;
    private NumeroLinea numLineaDef;

    public VtnEdicion(File archivoJson, File archivoDef) {
        this.archivoJson = archivoJson;
        this.archivoDef = archivoDef;
        initComponents();
        this.numLineaJson = new NumeroLinea(taJson);
        this.numLineaDef = new NumeroLinea(taDef);
        this.spJson.setRowHeaderView(numLineaJson);
        this.spDef.setRowHeaderView(numLineaDef);
        this.taConsola.setEditable(false);
        this.setLocationRelativeTo(null);
        this.taJson.setText(VtnPrincipal.leerArchivo(this.archivoJson));
        this.taDef.setText(VtnPrincipal.leerArchivo(this.archivoDef));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        spJson = new javax.swing.JScrollPane();
        taJson = new javax.swing.JTextArea();
        spDef = new javax.swing.JScrollPane();
        taDef = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taConsola = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taJson.setColumns(20);
        taJson.setRows(5);
        spJson.setViewportView(taJson);

        jTabbedPane1.addTab("resultado.json", spJson);

        taDef.setColumns(20);
        taDef.setRows(5);
        spDef.setViewportView(taDef);

        jTabbedPane1.addTab("reportes.def", spDef);
        jTabbedPane1.addTab("Reportes", jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        taConsola.setColumns(20);
        taConsola.setRows(5);
        jScrollPane1.setViewportView(taConsola);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEjecutar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEjecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.guardar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        this.tablaSimbolosJson.limpiar();
        this.taConsola.setText(null);
        Analizar analizar = new Analizar(taJson.getText(), taConsola, this.tablaSimbolosJson);
        analizar.analizar();
        this.tablaSimbolosJson.imprimirTabla();
    }//GEN-LAST:event_btnEjecutarActionPerformed

    public void guardar() {
        String contenidoJson = taJson.getText();
        String contenidoDef = taDef.getText();
        boolean guardadoDef = guardarArchivo(this.archivoDef, contenidoDef);
        boolean guardadoJson = guardarArchivo(this.archivoJson, contenidoJson);
        if (guardadoJson && guardadoDef) {
            JOptionPane.showMessageDialog(null, "Cambios guardados");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudieron guardar todos los cambios");
        }
    }

    public boolean guardarArchivo(File archivo, String documento) {
        FileOutputStream salida;
        boolean guardado = false;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            guardado = true;
            salida.close();
        } catch (FileNotFoundException ex) {
            //Error
        } catch (IOException ex) {
            //Error
        }
        return guardado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane spDef;
    private javax.swing.JScrollPane spJson;
    private javax.swing.JTextArea taConsola;
    private javax.swing.JTextArea taDef;
    private javax.swing.JTextArea taJson;
    // End of variables declaration//GEN-END:variables
}
