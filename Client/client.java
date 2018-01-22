package client.v3;
import java.io.*; 
import java.net.*;

public class Start extends javax.swing.JFrame{ 
    Socket client;
}
PrintWriter out;
BufferedReader in;
boolean Spento=false; //quando va a true termina il Thread boolean 
LINK=false; // se si è instaurato il collegamento va a true 
boolean BloccaDestra, BloccaSinistra; // fine corsa
public Start() {
initComponents(); Sinistra.setEnabled(false); Destra.setEnabled(false); STOP .setEnabled(false);
}
//Codice autogenerato da Netbeans @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code"> private void initComponents() {
jPanel1 = new javax.swing.JPanel(); jLabel1 = new javax.swing.JLabel(); IP = new javax.swing.JTextField(); jLabel2 = new javax.swing.JLabel(); Port = new javax.swing.JTextField(); Vai = new javax.swing.JButton(); Annulla = new javax.swing.JButton(); jPanel2 = new javax.swing.JPanel(); Sinistra = new javax.swing.JButton(); Destra = new javax.swing.JButton(); STOP = new javax.swing.JButton(); jLabel3 = new javax.swing.JLabel();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); setTitle("RotatorInterfacePI");
setResizable(false);
jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opzioni Connessione")); jLabel1.setText("Indirizzo IP Server:");
IP.setHorizontalAlignment(javax.swing.JTextField.LEFT); IP.setToolTipText("");
IP.setMaximumSize(null);
IP.setMinimumSize(null);
IP.setPreferredSize(new java.awt.Dimension(125, 28)); IP.setSize(new java.awt.Dimension(120, 28)); IP.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { IPActionPerformed(evt);
} });
jLabel2.setText("Porta(Deafault 4000):");
Port.setText("4000");
Port.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { PortActionPerformed(evt);
} });
javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1); jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(jPanel1Layout.createSequentialGroup()
.addGap(63, 63, 63) .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jLabel2)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jLabel1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addContainerGap(95, Short.MAX_VALUE)) );
jPanel1Layout.setVerticalGroup( jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(jPanel1Layout.createSequentialGroup()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(jLabel1))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel2)
.addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))) );
Vai.setText("Vai");
Vai.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { VaiActionPerformed(evt);
} });
Matteo Bavecchi 4°A ITI
a.s. 2014/2015
Annulla.setText("Annulla");
Annulla.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { AnnullaActionPerformed(evt);
} });
jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Comando Rotore")); jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseReleased(java.awt.event.MouseEvent evt) { jPanel2MouseReleased(evt);
} });
Sinistra.setText("<--");
Sinistra.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseReleased(java.awt.event.MouseEvent evt) { SinistraMouseReleased(evt);
}
public void mouseClicked(java.awt.event.MouseEvent evt) {
SinistraMouseClicked(evt); }
});
Sinistra.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { SinistraActionPerformed(evt);
} });
Sinistra.addKeyListener(new java.awt.event.KeyAdapter() { public void keyPressed(java.awt.event.KeyEvent evt) {
SinistraKeyPressed(evt); }
});
Destra.setText("-->");
Destra.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseReleased(java.awt.event.MouseEvent evt) { DestraMouseReleased(evt);
} });
Destra.addActionListener(new java.awt.event.ActionListener() { public void actionPerformed(java.awt.event.ActionEvent evt) {
DestraActionPerformed(evt); }
});
STOP.setText("STOP");
STOP.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) { STOPActionPerformed(evt);
} });
javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2); jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(Sinistra, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(18, 18, 18)
.addComponent(STOP, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE) .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(Destra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(52, 52, 52))
); jPanel2Layout.setVerticalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(jPanel2Layout.createSequentialGroup()
.addGap(19, 19, 19) .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(Destra, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(Sinistra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE) .addComponent(STOP, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
.addContainerGap(38, Short.MAX_VALUE)) );
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(layout.createSequentialGroup()
.addContainerGap() .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addGap(0, 0, Short.MAX_VALUE)
.addComponent(Vai) .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED) .addComponent(Annulla))
.addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) .addContainerGap())
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup() .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(140, 140, 140))
); layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addContainerGap()
.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE) .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) .addGap(19, 19, 19)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(Vai)
.addComponent(Annulla)) .addContainerGap())
);
pack();
}// </editor-fold>

private void AnnullaActionPerformed(java.awt.event.ActionEvent evt) {
    Spento=true; //mettendo a true Spento si termina il Thread
    if(LINK) //se si è instaurato il collegamento, si invia la stringa "-1" per interrompere la
        connessione out.println("-1");
    System.exit(0);//si esce dall' applicazione 
}

private void VaiActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        client = new Socket(IP.getText(),new Integer(Port.getText()));//ci si collega al server con i dati inseriti nelle text fields
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream())); LINK=true;
        }catch (Exception e) { e.printStackTrace(); }
    IP .setEnabled(false);

    Port.setEnabled(false);
    Vai.setEnabled(false);

    if(client.isConnected()){
        Sinistra.setEnabled(true);
        Destra.setEnabled(true); 
        STOP.setEnabled(true);

new Thread(new Runnable() { public void run() {
    while (!Spento) { //finchè l' applicazione è attiva
        try {
            double volts=Double.parseDouble(in.readLine()); //double OldRange = (1.10);
                                                            //double NewRange = (360);
            double gradi = ((volts * 360) / 1.10) - 540; 
            jLabel3.setText(Long.toString((long) gradi));
            if(gradi>359) { 
                if(!BloccaDestra)
                    out.println("2");//ferma il rotore BloccaDestra=true;//non far andare piu a destra il rotore
                }
                else if(gradi<-359) {
                    if(!BloccaSinistra)
                        out.println("2"); //ferma il rotore
                    BloccaSinistra=true;//non far andare piu a sinistra il rotore
                    }else{ BloccaDestra=false; BloccaSinistra=false;
                }
        }
    catch (Exception e) {
    } 
}
}).start(); }}

e.printStackTrace(); 
}




private void SinistraActionPerformed(java.awt.event.ActionEvent evt) {
    if(!BloccaSinistra)
        out.println("1");

    try {
        System.out.println(in.readLine());
    }
    catch (Exception e) { e.printStackTrace();

    } 
}

private void DestraActionPerformed(java.awt.event.ActionEvent evt) { 
    if(!BloccaDestra)
        out.println("0");
    try { 
        System.out.println(in.readLine());
    }
    catch (Exception e) { e.printStackTrace();
    }
}


private void STOPActionPerformed(java.awt.event.ActionEvent evt) {
    out.println("2");
    try {
        System.out.println(in.readLine());
    }
catch (Exception e) { e.printStackTrace();
}

public static void main(String args[]) {
    /* Set the Nimbus look and feel */
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
* For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */
try {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) { javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
} }
} catch (ClassNotFoundException ex) { java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) { java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) { java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) { java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} //</editor-fold>
    /* Create and display the form */ java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new Start().setVisible(true);
    } });
 }
    // Variables declaration - do not modify private javax.swing.JButton Annulla; private javax.swing.JButton Destra; private javax.swing.JTextField IP;
    private javax.swing.JTextField Port;
    private javax.swing.JButton STOP;
    private javax.swing.JButton Sinistra;
    private javax.swing.JButton Vai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1; 
    private javax.swing.JPanel jPanel2;
    // End of variables declaration }
