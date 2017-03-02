package securitydogwick;

public class SecurityDogWick extends javax.swing.JFrame {

    private boolean stop;
    private WaitThread wt1;
    private Object obj1;

    class WaitThread extends Thread {

        public void run() {
//Sleep -> Interrupted ปกติ
            int i = 0;
            while (!stop) {
                try {
                    lblShowClock.setText("i = " + i);
                    i++;
                    Thread.sleep(50);
                } catch (InterruptedException ie) {
                    i = 0;
                }
            }
            
        }
    }

    public SecurityDogWick() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btStart = new javax.swing.JButton();
        btStop = new javax.swing.JButton();
        lblShowClock = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btStart.setText("START");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        btStop.setText("STOP");
        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStopActionPerformed(evt);
            }
        });

        lblShowClock.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btStart)
                        .addGap(105, 105, 105)
                        .addComponent(btStop))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lblShowClock)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblShowClock)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btStart)
                    .addComponent(btStop))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        stop = false;
        wt1 = new WaitThread();
        wt1.start();
    }//GEN-LAST:event_btStartActionPerformed

    private void btStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStopActionPerformed
        stop = true;
    }//GEN-LAST:event_btStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecurityDogWick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecurityDogWick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecurityDogWick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecurityDogWick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecurityDogWick().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStart;
    private javax.swing.JButton btStop;
    private javax.swing.JLabel lblShowClock;
    // End of variables declaration//GEN-END:variables
}
