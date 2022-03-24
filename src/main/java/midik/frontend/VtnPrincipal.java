package midik.frontend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sockets.Cliente;

public class VtnPrincipal extends javax.swing.JFrame {

    private File directorioProyecto1;
    private File directorioProyecto2;

    public VtnPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSelecP1 = new javax.swing.JButton();
        btnSelecP2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSelecP1.setText("Seleccionar");
        btnSelecP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecP1ActionPerformed(evt);
            }
        });

        btnSelecP2.setText("Seleccionar");
        btnSelecP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecP2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proyecto 1");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Proyecto 2");

        btnAnalizar.setText("ANALIZAR");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelecP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(btnAnalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecP2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecP1)))
                .addGap(105, 105, 105)
                .addComponent(btnAnalizar)
                .addGap(195, 195, 195))
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Abrir proyecto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecP2ActionPerformed
        JFileChooser selectorDirectorio = new JFileChooser();
        selectorDirectorio.setDialogTitle("Selecciona el directorio del Proyecto 2");
        selectorDirectorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorDirectorio.setAcceptAllFileFilterUsed(false);
        if (selectorDirectorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File directorioSeleccionado = selectorDirectorio.getSelectedFile();
            this.directorioProyecto2 = directorioSeleccionado;
        }


    }//GEN-LAST:event_btnSelecP2ActionPerformed

    private void btnSelecP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecP1ActionPerformed
        JFileChooser selectorDirectorio = new JFileChooser();
        selectorDirectorio.setDialogTitle("Selecciona el directorio del Proyecto 1");
        selectorDirectorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selectorDirectorio.setAcceptAllFileFilterUsed(false);
        if (selectorDirectorio.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File DirectorioSeleccionado = selectorDirectorio.getSelectedFile();
            this.directorioProyecto1 = DirectorioSeleccionado;
        }

    }//GEN-LAST:event_btnSelecP1ActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if (this.directorioProyecto1 == null || this.directorioProyecto2 == null) {
            JOptionPane.showMessageDialog(null, "Por favor elige los directorios", "Incorrecto", JOptionPane.WARNING_MESSAGE);
        } else {
            Cliente cliente = new Cliente(directorioProyecto1, directorioProyecto2, this);
            cliente.IniciarCliente();
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        fileChosser.setDialogTitle("Selecciona el proyecto");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo copy", "copy");
        fileChosser.setFileFilter(filter);
        int seleccion = fileChosser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChosser.getSelectedFile();
            abrirProyecto(archivo);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void abrirProyecto(File archivoCopy) {
        String estructura = leerArchivo(archivoCopy);
        String[] archivos = estructura.split(",");
        File archivoJson = new File(archivos[0].replace(" ", ""));
        File archivoDef = new File(archivos[1].replace(" ", ""));
        VtnEdicion vtnEdicion = new VtnEdicion(archivoJson, archivoDef);
        vtnEdicion.setVisible(true);
        this.dispose();
    }

    public static String leerArchivo(File archivo) {
        String contenido = "";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
                contenido += linea + "\n";
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
        return contenido;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnSelecP1;
    private javax.swing.JButton btnSelecP2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
