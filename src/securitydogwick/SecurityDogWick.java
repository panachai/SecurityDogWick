package securitydogwick;

public class SecurityDogWick extends javax.swing.JFrame {

    private boolean stop;
    private WaitThread wt1;
    private OwnerThread OwnerTh;
    private DogThread DogTh;
    private PoliceThread PoliceTh;
    private ThifeThread ThifeTh;

    private Object objOwner;
    private Object objDog;
    private Object objPolice;
    private Object objThife;

    public SecurityDogWick() {
        initComponents();
        ThifeTh = new ThifeThread();
        wt1 = new WaitThread();
        OwnerTh = new OwnerThread();
        DogTh = new DogThread();
        ThifeTh = new ThifeThread();
        PoliceTh = new PoliceThread();

        objOwner = new Object();
        objDog = new Object();
        objPolice = new Object();
        objThife = new Object();
    }

    class WaitThread extends Thread {

        public void run() {
//Sleep -> Interrupted ปกติ
            int i = 0;
            int hour = 0;
            int day = 0;
            while (!stop) {
                try {
                    lbShowClock.setText(String.format("%02d", hour) + ":" + String.format("%02d", i));
                    i++;
                    Thread.sleep(20);
                    if (i >= 60) {
                        i = 0;
                        hour++;

                        if (hour == 8) {

                            synchronized (objDog) {
                                objDog.notify();
                            }
                            synchronized (objThife) {
                                objThife.notify();
                            }
                        }
                        if (hour == 16) {
                            synchronized (objOwner) {
                                objOwner.notify();
                            }
                        }
                    }
                    if (hour >= 24) {
                        day++;
                        hour = 0;
                        lbDay.setText("DAY : " + String.format("%02d", day));
                        synchronized (objOwner) { //เริ่มวันใหม่ ให้ถัด notify ไปรอบนึง
                            objOwner.notify();
                        }
                        synchronized (objDog) {
                            objDog.notify();
                        }
                        synchronized (objPolice) {
                            objPolice.notify();
                        }
                        synchronized (objThife) {
                            objThife.notify();
                        }
                    }
                } catch (InterruptedException ie) {
                    i = 0;
                }
            }
        }
    }

    class OwnerThread extends Thread {

        public void run() {
            while (!stop) {
                try {
                    lbOwnerS.setText("wake");
                    synchronized (objOwner) {
                        objOwner.wait();
                    }
                    lbOwnerS.setText("sleep");
                    synchronized (objOwner) {
                        objOwner.wait();
                    }
                } catch (InterruptedException ie) {

                    try {
                        lbOwnerS.setText("wake");
                        Thread.sleep(1000);
                        lbOwnerS.setText("Call to Police");
                        Thread.sleep(1000);
                        lbOwnerS.setText("Waiting Police");
                        PoliceTh.interrupt();
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }
    }

    class DogThread extends Thread {

        public void run() {
            while (!stop) {
                try {
                    lbDogS.setText("sleep");
                    synchronized (objDog) {
                        objDog.wait();
                    }
                    lbDogS.setText("wake");
                    synchronized (objDog) {
                        objDog.wait();
                    }
                } catch (InterruptedException ie) {

                    try {
                        lbStatus.setForeground(new java.awt.Color(255, 0, 0));
                        Thread.sleep(1000);
                        lbDogS.setForeground(new java.awt.Color(255, 0, 0));
                        lbDogS.setText("bark bark!!");
                        OwnerTh.interrupt();
                    } catch (InterruptedException ex) {

                    }

                }
            }
        }
    }

    class PoliceThread extends Thread {

        public void run() {
            while (!stop) {
                try {
                    lbPoliceS.setText("wake");
                    synchronized (objPolice) {
                        objPolice.wait();
                    }

                } catch (InterruptedException ie) {

                    try {
                        lbPoliceS.setText("Go to home");
                        Thread.sleep(1000);
                        lbPoliceS.setText("Capture Thife");
                        ThifeTh.interrupt();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }

    class ThifeThread extends Thread {

        public void run() {
            while (!stop) {
                try {
                    lbThifeS.setText("sleep");
                    btThife.setEnabled(false);
                    synchronized (objThife) {
                        objThife.wait();
                    }
                    lbThifeS.setText("wake");
                    btThife.setEnabled(true);
                    synchronized (objThife) {
                        objThife.wait();
                    }
                } catch (InterruptedException ie) {
                    lbThifeS.setText("Capture");
                }
            }
        }
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
        btThife = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbDay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("John Wick");

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
        lbOwnerS.setText("____________");

        lbDogS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbDogS.setText("____________");

        lbPoliceS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPoliceS.setText("____________");

        lbThifeS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbThifeS.setText("____________");

        btThife.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btThife.setText("THIFE START");
        btThife.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThifeActionPerformed(evt);
            }
        });

        jLabel1.setText("by panachai");

        lbDay.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lbDay.setText("DAY : 00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btStop)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOwner)
                            .addComponent(lbDog)
                            .addComponent(lbPolice)
                            .addComponent(lbThife))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDogS)
                            .addComponent(lbOwnerS)
                            .addComponent(lbPoliceS)
                            .addComponent(lbThifeS))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbDay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbShowClock)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbHeader))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lbStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btThife)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDay)
                            .addComponent(lbShowClock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbOwner)
                            .addComponent(lbOwnerS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDog)
                            .addComponent(lbDogS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPolice)
                            .addComponent(lbPoliceS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbThife)
                            .addComponent(lbThifeS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btThife)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btStart)
                            .addComponent(btStop))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        stop = false;
        lbDogS.setForeground(new java.awt.Color(0, 0, 0));
        lbStatus.setForeground(new java.awt.Color(0, 0, 0));
        wt1.start();
        OwnerTh.start();
        DogTh.start();
        PoliceTh.start();
        ThifeTh.start();
    }//GEN-LAST:event_btStartActionPerformed

    private void btStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStopActionPerformed
        stop = true;
        //เพิ่มการหยุดที่ถูกต้อง
    }//GEN-LAST:event_btStopActionPerformed

    private void btThifeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThifeActionPerformed
        DogTh.interrupt();
        stop = true;
    }//GEN-LAST:event_btThifeActionPerformed

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
    private javax.swing.JButton btThife;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDay;
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
