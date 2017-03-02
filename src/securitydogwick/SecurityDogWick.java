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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btStart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btStart.setText("START");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        btStop.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btStop.setText("STOP");
        btStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStopActionPerformed(evt);
            }
        });

        lblShowClock.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblShowClock.setText("00:00");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Security Dog Wick");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btStart)
                .addGap(73, 73, 73)
                .addComponent(btStop)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(lblShowClock)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblShowClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btStop)
                    .addComponent(btStart))
                .addContainerGap())
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblShowClock;
    // End of variables declaration//GEN-END:variables
}
