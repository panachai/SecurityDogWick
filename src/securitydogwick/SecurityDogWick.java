package securitydogwick;

public class SecurityDogWick extends javax.swing.JFrame {

    private boolean stop;
    private WaitThread wt1;
    private Object obj1;

    class WaitThread extends Thread {

        public void run() {
//Sleep -> Interrupted ปกติ
            int i = 0;
            int hour = 0;
            while (!stop) {
                try {
                    lbShowClock.setText(String.format("%02d", hour) +":" + String.format("%02d", i));
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
        lbShowClock = new javax.swing.JLabel();
        lbHeader = new javax.swing.JLabel();
        lbOwner = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        lbDog = new javax.swing.JLabel();
        lbPolice = new javax.swing.JLabel();
        lbThife = new javax.swing.JLabel();
        lbOwnerS = new javax.swing.JLabel();
        lbDogS = new javax.swing.JLabel();
        lbPoliceS = new javax.swing.JLabel();
        lbThifeS = new javax.swing.JLabel();

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

        lbShowClock.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lbShowClock.setText("00:00");

        lbHeader.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbHeader.setText("Security Dog Wick");

        lbOwner.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbOwner.setText("OWNER");

        lbStatus.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbStatus.setText("STATUS");

        lbDog.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDog.setText("DOG");

        lbPolice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPolice.setText("POLICE");

        lbThife.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbThife.setText("THIFE");

        lbOwnerS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbOwnerS.setText("______");

        lbDogS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDogS.setText("______");

        lbPoliceS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPoliceS.setText("______");

        lbThifeS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbThifeS.setText("______");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOwner)
                    .addComponent(lbDog)
                    .addComponent(lbPolice)
                    .addComponent(lbThife))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOwnerS)
                    .addComponent(lbDogS)
                    .addComponent(lbPoliceS)
                    .addComponent(lbThifeS))
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lbHeader))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lbShowClock))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lbStatus)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btStart)
                .addGap(73, 73, 73)
                .addComponent(btStop)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader)
                .addGap(18, 18, 18)
                .addComponent(lbShowClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbOwner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPolice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbThife))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbOwnerS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDogS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPoliceS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbThifeS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
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
    private javax.swing.JLabel lbDog;
    private javax.swing.JLabel lbDogS;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbOwner;
    private javax.swing.JLabel lbOwnerS;
    private javax.swing.JLabel lbPolice;
    private javax.swing.JLabel lbPoliceS;
    private javax.swing.JLabel lbShowClock;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbThife;
    private javax.swing.JLabel lbThifeS;
    // End of variables declaration//GEN-END:variables
}
