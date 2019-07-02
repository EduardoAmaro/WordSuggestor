package dev.feldmann.autowordsuggestor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

public class MainScreen extends javax.swing.JFrame {

    public static MainScreen instance;
    private ScreenEvents events;

    public MainScreen(Tri tri) {
        initComponents();
        events = new ScreenEvents(this, tri);

        this.listSuggestions.setVisibleRowCount(1);
        this.listSuggestions.setLayoutOrientation(listSuggestions.HORIZONTAL_WRAP);
        this.listSuggestions.addListSelectionListener(e -> events.clickSuggestedSword(e));
        this.fieldText.addCaretListener(e -> events.caretUpdate(e));
        this.butttonSend.addActionListener(e -> events.clickSend(e));
        this.fieldText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                events.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                events.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.resetWeights.addActionListener(e -> events.resetWeight());
        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                Collections.emptySet());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fieldText = new javax.swing.JTextField();
        panelText = new javax.swing.JScrollPane();
        textAreaText = new javax.swing.JTextArea();
        butttonSend = new javax.swing.JButton();
        panelSuggestions = new javax.swing.JScrollPane();
        listSuggestions = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Auto Word Suggestor");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        fieldText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fieldText.setText("");

        textAreaText.setColumns(20);
        textAreaText.setRows(5);
        textAreaText.setEnabled(false);
        textAreaText.setDisabledTextColor(Color.black);
        textAreaText.setFont(new java.awt.Font("Dialog", 0, 14));
        panelText.setViewportView(textAreaText);

        menuBar = new JMenuBar();
        options = new JMenu("Options");
        resetWeights = new JMenuItem("Resetar Pesos");
        options.add(resetWeights);
        menuBar.add(options);
        setJMenuBar(menuBar);

        butttonSend.setLabel("Send");

        listSuggestions.setBackground(new java.awt.Color(238, 238, 238));
        listSuggestions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listSuggestions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSuggestions.setPreferredSize(new java.awt.Dimension(80, 87));
        listSuggestions.setSelectionBackground(new java.awt.Color(51, 51, 51));
        panelSuggestions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelSuggestions.setViewportView(listSuggestions);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(fieldText, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(butttonSend))
                                        .addComponent(panelText)
                                        .addComponent(panelSuggestions))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(panelText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelSuggestions, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fieldText, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                        .addComponent(butttonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(Tri tri) {
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instance = new MainScreen(tri);
                instance.setVisible(true);

            }
        });
    }

    public static class Suggestion {

        String prefix;
        String suffix;

        public Suggestion(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;

        }

        @Override
        public String toString() {
            return prefix + suffix;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton butttonSend;
    public javax.swing.JTextField fieldText;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JList<Suggestion> listSuggestions;
    private javax.swing.JScrollPane panelSuggestions;
    private javax.swing.JScrollPane panelText;
    public javax.swing.JTextArea textAreaText;
    private javax.swing.JMenuBar menuBar;
    private JMenu options;
    private JMenuItem resetWeights;
    // End of variables declaration//GEN-END:variables
}
