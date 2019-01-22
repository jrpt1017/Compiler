/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalorchestrav2;
import java.awt.Color;
import java.util.List;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.Utilities;
import javax.swing.undo.UndoManager;
    
/**
 *
 * @author Jonnel
 */
//Closed project file 9-27 11:20 PM para icheck yung sinend ni martin popo
public class OrchestraFrame extends javax.swing.JFrame {
   protected UndoManager undoManager = new UndoManager();
    int idcount = 1;
    int maxhiddenrow;
    String[] idstring={""};
    String syntax = "";
    List<String> fixedList = Arrays.asList(idstring);
    List<String> stringList = new ArrayList<String>( fixedList );
    
    
    /**
     * Creates new form OrchestraFrame
     */
    public OrchestraFrame() {
        
        initComponents();
        btnSyntax.setEnabled(false); 
        btnSemantic.setEnabled(false);
        setDefaultText();
        
        txtareaCompiler.getDocument().addUndoableEditListener(
        new UndoableEditListener() {
          public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
          }
        });
        
        //set Key Bindings
        Action action = new AbstractAction() {
                @Override
        public void actionPerformed(ActionEvent e) {
            if(undoManager.canUndo() == true)
            {
                undoManager.undo();
                undoManager.undo();
            }
        }};
        String keyStrokeAndKeyUndo = "control Z";
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKeyUndo);
        txtareaCompiler.getInputMap().put(keyStroke, keyStrokeAndKeyUndo);
        txtareaCompiler.getActionMap().put(keyStrokeAndKeyUndo, action);


        Action action1 = new AbstractAction() {
                @Override
        public void actionPerformed(ActionEvent e) {
            if(undoManager.canRedo() == true)
            {
               undoManager.redo();
               undoManager.redo();
            }
        }};
        String keyStrokeAndKeyRedo = "control Y";
        KeyStroke keyStroke1 = KeyStroke.getKeyStroke(keyStrokeAndKeyRedo);
        txtareaCompiler.getInputMap().put(keyStroke1, keyStrokeAndKeyRedo);
        txtareaCompiler.getActionMap().put(keyStrokeAndKeyRedo, action1);
        
        
        //Text Colors
        txtareaCompiler.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e){
                KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT_PARENTHESIS, KeyEvent.VK_SHIFT);

                if(!e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET)
                {
                    txtareaCompiler.replaceSelection("");
                   // txtareaCompiler.insert("]", txtareaCompiler.getCaretPosition());
                }
                else if (e.isShiftDown() && e.getKeyChar() != '9' && e.getKeyCode() == 57) { //openparenthesis
                    txtareaCompiler.replaceSelection("");
                    //txtareaCompiler.insert(")", txtareaCompiler.getCaretPosition());
                }
                else if (e.isShiftDown() && e.getKeyChar() != '[' && e.getKeyCode() == 91) { //open brace
                    txtareaCompiler.replaceSelection("");
                    //txtareaCompiler.insert("}", txtareaCompiler.getCaretPosition());
                }
            }   

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        }
    
        private int findLastNonWordChar (String text, int index) {
            while (--index >= 0) {
                if (String.valueOf(text.charAt(index)).matches("\\W")) {
                    break;
                }
            }
            return index;
        }

         private int findFirstNonWordChar (String text, int index) {
            while (index < text.length()) {
                if (String.valueOf(text.charAt(index)).matches("\\W")) {
                    break;
                }
                index++;
            }
            return index;
        }
         //textlinenumber

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaCompiler = new javax.swing.JTextArea();
        btnRemove = new javax.swing.JButton();
        Lexical = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        btnChoose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblFileName = new javax.swing.JLabel();
        lblRowCol = new javax.swing.JLabel();
        tabMainTables = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLexeme = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSyntax = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConstantDeclaration = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblGlobalDeclaration = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblLocalDeclaration = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblIdentifier = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblFunctionParemeters = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblFunctionDeclaration = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblFunctionReturn = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblArray = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblStructDeclaration = new javax.swing.JTable();
        btnSyntax = new javax.swing.JButton();
        tabErrorTables = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblError = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblErrorSyntax = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblErrorSemantic = new javax.swing.JTable();
        btnSemantic = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtareaCompiler.setBackground(new java.awt.Color(51, 51, 51));
        txtareaCompiler.setColumns(20);
        txtareaCompiler.setFont(new java.awt.Font("Fira Code", 0, 18)); // NOI18N
        txtareaCompiler.setForeground(new java.awt.Color(255, 255, 255));
        txtareaCompiler.setRows(5);
        txtareaCompiler.setTabSize(4);
        txtareaCompiler.setCaretColor(new java.awt.Color(255, 255, 255));
        txtareaCompiler.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtareaCompilerCaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(txtareaCompiler);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 890, 530));

        btnRemove.setBackground(new java.awt.Color(255, 153, 0));
        btnRemove.setFont(new java.awt.Font("Segoe Script", 2, 24)); // NOI18N
        btnRemove.setText("Clear");
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRemoveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRemoveMouseReleased(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 120, 40));

        Lexical.setBackground(new java.awt.Color(253, 189, 57));
        Lexical.setFont(new java.awt.Font("Segoe Script", 2, 24)); // NOI18N
        Lexical.setText("Lexical");
        Lexical.setToolTipText("");
        Lexical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LexicalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LexicalMouseReleased(evt);
            }
        });
        Lexical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LexicalActionPerformed(evt);
            }
        });
        jPanel1.add(Lexical, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Pristina", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("#Orchestra Compiler");

        btnRun.setBackground(new java.awt.Color(253, 189, 57));
        btnRun.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        btnRun.setText("Run Program");
        btnRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRunMousePressed(evt);
            }
        });

        lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("FILE NAME: ");

        btnChoose.setBackground(new java.awt.Color(253, 189, 57));
        btnChoose.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        btnChoose.setText("Choose File");
        btnChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnChooseMousePressed(evt);
            }
        });
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(253, 189, 57));
        btnSave.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        btnSave.setText("Save File");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveMousePressed(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblFileName.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        lblFileName.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnRun)
                .addGap(32, 32, 32)
                .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(lbl)
                .addGap(18, 18, 18)
                .addComponent(lblFileName)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl)
                            .addComponent(lblFileName))
                        .addContainerGap())))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1660, 70));

        lblRowCol.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblRowCol.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRowCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        tblLexeme.setBackground(new java.awt.Color(51, 51, 51));
        tblLexeme.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        tblLexeme.setForeground(new java.awt.Color(255, 255, 255));
        tblLexeme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LEXEME", "TOKEN", "LINE", "COLUMN", "DESCRIPTION"
            }
        ));
        tblLexeme.setToolTipText("Lexical");
        jScrollPane1.setViewportView(tblLexeme);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        tabMainTables.addTab("Lexical", jPanel3);

        tblSyntax.setBackground(new java.awt.Color(51, 51, 51));
        tblSyntax.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        tblSyntax.setForeground(new java.awt.Color(255, 255, 255));
        tblSyntax.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTION", ""
            }
        ));
        jScrollPane4.setViewportView(tblSyntax);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        tabMainTables.addTab("Syntax", jPanel4);

        tblConstantDeclaration.setBackground(new java.awt.Color(51, 51, 51));
        tblConstantDeclaration.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblConstantDeclaration.setForeground(new java.awt.Color(255, 255, 255));
        tblConstantDeclaration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Value", "Type"
            }
        ));
        jScrollPane3.setViewportView(tblConstantDeclaration);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Constant Declaration", jPanel5);

        tblGlobalDeclaration.setBackground(new java.awt.Color(51, 51, 51));
        tblGlobalDeclaration.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblGlobalDeclaration.setForeground(new java.awt.Color(255, 255, 255));
        tblGlobalDeclaration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Element", "Value", "Type"
            }
        ));
        jScrollPane8.setViewportView(tblGlobalDeclaration);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Global Declaration", jPanel7);

        tblLocalDeclaration.setBackground(new java.awt.Color(51, 51, 51));
        tblLocalDeclaration.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblLocalDeclaration.setForeground(new java.awt.Color(255, 255, 255));
        tblLocalDeclaration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Value", "Type", "Array 1D Size", "Array 2D Size"
            }
        ));
        jScrollPane9.setViewportView(tblLocalDeclaration);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Local Declaration", jPanel12);

        tblIdentifier.setAutoCreateRowSorter(true);
        tblIdentifier.setBackground(new java.awt.Color(51, 51, 51));
        tblIdentifier.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblIdentifier.setForeground(new java.awt.Color(255, 255, 255));
        tblIdentifier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Value", "Type"
            }
        ));
        jScrollPane10.setViewportView(tblIdentifier);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Identifier", jPanel14);

        tblFunctionParemeters.setBackground(new java.awt.Color(51, 51, 51));
        tblFunctionParemeters.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblFunctionParemeters.setForeground(new java.awt.Color(255, 255, 255));
        tblFunctionParemeters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Function Name", "Identifier", "Value", "Type"
            }
        ));
        jScrollPane11.setViewportView(tblFunctionParemeters);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Parameters", jPanel16);

        tblFunctionDeclaration.setBackground(new java.awt.Color(51, 51, 51));
        tblFunctionDeclaration.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblFunctionDeclaration.setForeground(new java.awt.Color(255, 255, 255));
        tblFunctionDeclaration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Function Name", "Identifier", "Value", "Type"
            }
        ));
        jScrollPane12.setViewportView(tblFunctionDeclaration);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Declaration", jPanel17);

        tblFunctionReturn.setBackground(new java.awt.Color(51, 51, 51));
        tblFunctionReturn.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblFunctionReturn.setForeground(new java.awt.Color(255, 255, 255));
        tblFunctionReturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Function Name", "Value", "Type"
            }
        ));
        jScrollPane13.setViewportView(tblFunctionReturn);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Return", jPanel18);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Function", jPanel15);

        tblArray.setBackground(new java.awt.Color(51, 51, 51));
        tblArray.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblArray.setForeground(new java.awt.Color(255, 255, 255));
        tblArray.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "1D Size", "2D Size", "Value", "Type"
            }
        ));
        jScrollPane14.setViewportView(tblArray);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Array", jPanel19);

        tblStructDeclaration.setBackground(new java.awt.Color(51, 51, 51));
        tblStructDeclaration.setFont(new java.awt.Font("Fira Code", 0, 16)); // NOI18N
        tblStructDeclaration.setForeground(new java.awt.Color(255, 255, 255));
        tblStructDeclaration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Struct Name", "Object Name", "Member ID", "Value", "Member Type"
            }
        ));
        jScrollPane15.setViewportView(tblStructDeclaration);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Struct Declaration", jPanel20);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabMainTables.addTab("Semantics", jPanel11);

        jPanel1.add(tabMainTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 740, 570));

        btnSyntax.setBackground(new java.awt.Color(253, 189, 57));
        btnSyntax.setFont(new java.awt.Font("Segoe Script", 2, 24)); // NOI18N
        btnSyntax.setText("Syntax");
        btnSyntax.setToolTipText("<html>\n<font face=\"Verdana\" color=\"blue\" size=\"14\">Run Lexical First</font>\n</html>");
        btnSyntax.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSyntax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSyntaxMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSyntaxMousePressed(evt);
            }
        });
        btnSyntax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSyntaxActionPerformed(evt);
            }
        });
        jPanel1.add(btnSyntax, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 130, 40));

        tblError.setBackground(new java.awt.Color(51, 51, 51));
        tblError.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        tblError.setForeground(new java.awt.Color(255, 255, 255));
        tblError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexeme", "Message", "Location"
            }
        ));
        jScrollPane5.setViewportView(tblError);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1595, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );

        tabErrorTables.addTab("Lexical Error", jPanel6);

        tblErrorSyntax.setBackground(new java.awt.Color(51, 51, 51));
        tblErrorSyntax.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        tblErrorSyntax.setForeground(new java.awt.Color(255, 255, 255));
        tblErrorSyntax.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Non-Terminal", "Error Message"
            }
        ));
        jScrollPane6.setViewportView(tblErrorSyntax);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1595, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );

        tabErrorTables.addTab("Syntax Error", jPanel8);

        tblErrorSemantic.setBackground(new java.awt.Color(51, 51, 51));
        tblErrorSemantic.setFont(new java.awt.Font("Fira Code", 0, 20)); // NOI18N
        tblErrorSemantic.setForeground(new java.awt.Color(255, 255, 255));
        tblErrorSemantic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifier", "Message", "Location"
            }
        ));
        jScrollPane7.setViewportView(tblErrorSemantic);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1595, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabErrorTables.addTab("Semantic Error", jPanel9);

        jPanel1.add(tabErrorTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 1600, 190));

        btnSemantic.setBackground(new java.awt.Color(253, 189, 57));
        btnSemantic.setFont(new java.awt.Font("Segoe Script", 2, 24)); // NOI18N
        btnSemantic.setText("Semantic");
        btnSemantic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSemanticMousePressed(evt);
            }
        });
        jPanel1.add(btnSemantic, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lexicalorchestrav2/orchestra1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1660, 780));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lexicalorchestrav2/top.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, 1660, 492));
        jPanel1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 890, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void setTable()
    {
        tblLexeme.setRowHeight(25);
        tblSyntax.setRowHeight(25);
        tblLocalDeclaration.setRowHeight(25);
        tblConstantDeclaration.setRowHeight(25);
        tblLocalDeclaration.setRowHeight(25);
        tblIdentifier.setRowHeight(25);
        tblFunctionParemeters.setRowHeight(25);
        tblFunctionDeclaration.setRowHeight(25);
        tblFunctionReturn.setRowHeight(25);
        tblErrorSemantic.setRowHeight(25);
        tblError.setRowHeight(25);
        tblErrorSyntax.setRowHeight(25);
    }
    
    void setDefaultText()
    {
        txtareaCompiler.setText(""
        + "PRELUDE \n\n"
        + "CONCERT()\n"
        + "{\n"
        + "}\n"
        + "ENCORE");
    }
    
    public int a=10;
    public char b =(char)a;
    private void LexicalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LexicalMousePressed
        // TODO add your handling code here:
        setTable();
        idcount = 1;
        String sourcecodelexic = txtareaCompiler.getText(); //Gets the code from the TextArea
        String lexeme = ""; //Storage for Lexemes
        String sourcecodearray[] = sourcecodelexic.split("\\r?\\n"); //Splits the whole to lines
        String sourcecode;
        DefaultTableModel model = (DefaultTableModel) tblLexeme.getModel(); //Table for Lexeme
        DefaultTableModel error = (DefaultTableModel) tblError.getModel();  //Table for Lexical error
        
        model.setRowCount(0);
        error.setRowCount(0);

        int check = 0;
        int i = 0;
        for(int j = 0; j < sourcecodearray.length; j++) // sourcecodearray.length = Number of Lines from the Text Area
        {
            sourcecode = sourcecodearray[j]; //temporarily stores the current line
            try{
                for( i = 0; i < sourcecode.length(); i++) // sourcecode.length = Number of Characters in a Line
                {
                    if(sourcecode.charAt(i) == 'B')
                    {
                        lexeme = lexeme.concat("B");
                        i++;
                        if(sourcecode.charAt(i) == 'O')
                        {
                            lexeme = lexeme.concat("O");
                            i++;
                            if(sourcecode.charAt(i) == 'O')
                            {
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'L')
                                {
                                    lexeme = lexeme.concat("L");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "BOOL",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for Bool
                                        if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '\n')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "BOOL",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "BOOL has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //Checks the Identifier after it fails from the reserved word
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                                model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                        stringList.add(lexeme);
                                        model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                        idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    //Starting with C
                    else if(sourcecode.charAt(i) == 'C'){
                        lexeme = "";
                        lexeme = lexeme.concat("C");
                        i++;
                        if(sourcecode.charAt(i) == 'A'){
                            lexeme = lexeme.concat("A");
                            i++;
                            if(sourcecode.charAt(i) =='D'){
                                lexeme = lexeme.concat("D");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("E");
                                    i++;
                                    if(sourcecode.charAt(i) == 'N'){
                                        lexeme = lexeme.concat("N");
                                        i++;
                                        if(sourcecode.charAt(i) == 'C'){
                                            lexeme = lexeme.concat("C");
                                            i++;
                                            if(sourcecode.charAt(i) == 'E'){
                                                lexeme = lexeme.concat("E");
                                                if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "CADENCE",""+(j+1),""+(i+2)});
                                                    lexeme = "";    //Clears the value for the next Lexeme
                                                    check = 1;  //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    i++;
                                                    //Delimiter for Default
                                                    if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == ';'||sourcecode.charAt(i) == ':')
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                        model.addRow(new String[]{lexeme, "CADENCE",""+(j+1),""+(i+1)});
                                                        lexeme = "";    //Clears the variable for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                    else
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                        error.addRow(new String[]{lexeme, "CADENCE has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                        lexeme = ""; //Clears the value for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'H'){
                            lexeme = lexeme.concat("H");
                            i++;
                            if(sourcecode.charAt(i) == 'A'){
                                lexeme = lexeme.concat("A");
                                i++;
                                if(sourcecode.charAt(i) == 'R'){
                                    lexeme = lexeme.concat("R");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "CHAR",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for Char
                                        if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '\n')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "CHAR",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "CHAR has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                            else if(sourcecode.charAt(i) == 'O'){
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'R'){
                                    lexeme = lexeme.concat("R");
                                    i++;
                                    if(sourcecode.charAt(i) == 'D'){
                                        lexeme = lexeme.concat("D");
                                        i++;
                                        if(sourcecode.charAt(i) == 'S'){
                                            lexeme = lexeme.concat("S");
                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "CHORDS",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for Chords
                                                if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "CHORDS",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "CHORDS has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'O'){
                            lexeme = lexeme.concat("O");
                            i++;
                            if(sourcecode.charAt(i) == 'N'){
                                lexeme = lexeme.concat("N");
                                i++;
                                if(sourcecode.charAt(i) == 'C'){
                                    lexeme = lexeme.concat("C");
                                    i++;
                                    if(sourcecode.charAt(i) == 'E'){
                                        lexeme = lexeme.concat("E");
                                        i++;
                                        if(sourcecode.charAt(i) == 'R'){
                                            lexeme = lexeme.concat("R");
                                            i++;
                                            if(sourcecode.charAt(i) == 'T'){
                                                lexeme = lexeme.concat("T");
                                                if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "CONCERT",""+(j+1),""+(i+2)});
                                                    lexeme = "";    //Clears the value for the next Lexeme
                                                    check = 1;  //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    i++;
                                                    //Delimiter for Concert
                                                    if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                        model.addRow(new String[]{lexeme, "CONCERT",""+(j+1),""+(i+1)});
                                                        lexeme = "";    //Clears the variable for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                    else
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                        error.addRow(new String[]{lexeme, "CONCERT has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                        lexeme = ""; //Clears the value for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if(sourcecode.charAt(i) == 'S'){
                                    lexeme = lexeme.concat("S");
                                    i++;
                                    if(sourcecode.charAt(i) == 'T'){
                                        lexeme = lexeme.concat("T");
                                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "CONST",""+(j+1),""+(i+2)});
                                            lexeme = "";    //Clears the value for the next Lexeme
                                            check = 1;  //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            i++;
                                            //Delimiter for Const
                                            if(sourcecode.charAt(i) == ' ')
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "CONST",""+(j+1),""+(i+1)});
                                                lexeme = "";    //Clears the variable for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                error.addRow(new String[]{lexeme, "CONST has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                lexeme = ""; //Clears the value for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //Checks the Identifier after it fails from the reserved word
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //start of letter D
                    else if(sourcecode.charAt(i) == 'D'){
                        lexeme=lexeme.concat("D");
                        i++;
                        if(sourcecode.charAt(i) == 'O'){
                            lexeme = lexeme.concat("O");
                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                model.addRow(new String[]{lexeme, "DO",""+(j+1),""+(i+2)});
                                lexeme = "";    //Clears the value for the next Lexeme
                                check = 1;  //Determines that the lexeme is a reserved word
                            }
                            else
                            {
                                i++;
                                //Delimiter for Do
                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == '{')
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                    model.addRow(new String[]{lexeme, "DO",""+(j+1),""+(i+1)});
                                    lexeme = "";    //Clears the variable for the next Lexeme
                                    i--;    //LookAhead
                                    check = 1; //Determines that the lexeme is a reserved word
                                }
                                else
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                    error.addRow(new String[]{lexeme, "DO has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = ""; //Clears the value for the next Lexeme
                                    i--;    //LookAhead
                                    check = 1; //Determines that the lexeme is a reserved word
                                }
                            }
                        }
                        if(check == 0) //Checks the Identifier after it fails from the reserved word
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                           model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter E
                    else if(sourcecode.charAt(i) == 'E'){
                        lexeme = "";
                        lexeme = lexeme.concat("E");
                        i++;
                        if(sourcecode.charAt(i) == 'L'){
                            lexeme = lexeme.concat("L");
                            i++;
                            if(sourcecode.charAt(i) == 'S'){
                                lexeme = lexeme.concat("S");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("E");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "ELSE",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for else
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == '{')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "ELSE",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else if(sourcecode.charAt(i) == 'I'){
                                            lexeme = lexeme.concat("I");
                                            i++;
                                            if(sourcecode.charAt(i) == 'F'){
                                                lexeme = lexeme.concat("F");
                                                if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "ELSEIF",""+(j+1),""+(i+2)});
                                                    lexeme = "";    //Clears the value for the next Lexeme
                                                    check = 1;  //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    i++;
                                                    //Delimiter for encore
                                                    if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '(')
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                        model.addRow(new String[]{lexeme, "ELSEIF",""+(j+1),""+(i+1)});
                                                        lexeme = "";    //Clears the variable for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                    else
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                        error.addRow(new String[]{lexeme, "ELSEIF has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                        lexeme = ""; //Clears the value for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                }
                                            }
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "ELSE has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'N'){
                            lexeme = lexeme.concat("N");
                            i++;
                            if(sourcecode.charAt(i) == 'C'){
                                lexeme = lexeme.concat("C");
                                i++;
                                if(sourcecode.charAt(i) == 'O'){
                                    lexeme = lexeme.concat("O");
                                    i++;
                                    if(sourcecode.charAt(i) == 'R'){
                                        lexeme = lexeme.concat("R");
                                        i++;
                                        if(sourcecode.charAt(i) == 'E'){
                                            lexeme = lexeme.concat("E");
                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "ENCORE",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for encore
                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == ';')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "ENCORE",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "ENCORE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter F
                    else if(sourcecode.charAt(i) == 'F'){
                        lexeme = "";
                        lexeme = lexeme.concat("f");
                        i++;
                        if(sourcecode.charAt(i) == 'A'){
                            lexeme = lexeme.concat("a");
                            i++;
                            if(sourcecode.charAt(i) == 'L'){
                                lexeme = lexeme.concat("l");
                                i++;
                                if(sourcecode.charAt(i) == 'S'){
                                    lexeme = lexeme.concat("s");
                                    i++;
                                    if(sourcecode.charAt(i) == 'E'){
                                        lexeme = lexeme.concat("e");
                                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{"false", "Boolean_Literal",""+(j+1),""+(i+2)});
                                            lexeme = "";    //Clears the value for the next Lexeme
                                            check = 1;  //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            i++;
                                            //Delimiter for false
                                            if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == ';'
                                            ||sourcecode.charAt(i) == ','||sourcecode.charAt(i) == '}'||sourcecode.charAt(i+1)=='('
                                            ||sourcecode.charAt(i+1)==')')
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{"false", "Boolean_Literal",""+(j+1),""+(i+1)});
                                                lexeme = "";    //Clears the variable for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                error.addRow(new String[]{"false", "FALSE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                lexeme = ""; //Clears the value for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'L'){
                            lexeme = lexeme.concat("L");
                            i++;
                            if(sourcecode.charAt(i) == 'O'){
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'A'){
                                    lexeme = lexeme.concat("A");
                                    i++;
                                    if(sourcecode.charAt(i) == 'T'){
                                        lexeme = lexeme.concat("T");
                                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "FLOAT",""+(j+1),""+(i+2)});
                                            lexeme = "";    //Clears the value for the next Lexeme
                                            check = 1;  //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            i++;
                                            //Delimiter for float
                                            if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "FLOAT",""+(j+1),""+(i+1)});
                                                lexeme = "";    //Clears the variable for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                error.addRow(new String[]{lexeme, "FLOAT has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                lexeme = ""; //Clears the value for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                                    
                    //Starting Letter I
                    else if(sourcecode.charAt(i) == 'I'){
                        lexeme="";
                        lexeme = lexeme.concat("I");
                        i++;
                        if(sourcecode.charAt(i) == 'F'){
                            lexeme = lexeme.concat("F");
                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                model.addRow(new String[]{lexeme, "IF",""+(j+1),""+(i+2)});
                                lexeme = "";    //Clears the value for the next Lexeme
                                check = 1;  //Determines that the lexeme is a reserved word
                            }
                            else
                            {
                                i++;
                                //Delimiter for if
                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == '(')
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                    model.addRow(new String[]{lexeme, "IF",""+(j+1),""+(i+1)});
                                    lexeme = "";    //Clears the variable for the next Lexeme
                                    i--;    //LookAhead
                                    check = 1; //Determines that the lexeme is a reserved word
                                }
                                else
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                    error.addRow(new String[]{lexeme, "IF has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = ""; //Clears the value for the next Lexeme
                                    i--;    //LookAhead
                                    check = 1; //Determines that the lexeme is a reserved word
                                }
                            }
                        }
                            else if(sourcecode.charAt(i) == 'N'){
                                lexeme = lexeme.concat("N");
                                i++;
                                if(sourcecode.charAt(i) == 'T'){
                                    lexeme = lexeme.concat("T");

                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme,"INT",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for int
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme,"INT",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else if(sourcecode.charAt(i)!='E'&&sourcecode.charAt(i)!='R')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "INT has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }

                                    }

                                    if(sourcecode.charAt(i) == 'E'){
                                        lexeme = lexeme.concat("E");
                                        i++;
                                        if(sourcecode.charAt(i) == 'R'){
                                            lexeme = lexeme.concat("R");
                                            i++;
                                            if(sourcecode.charAt(i) == 'L'){
                                                lexeme = lexeme.concat("L");
                                                i++;
                                                if(sourcecode.charAt(i) == 'U'){
                                                    lexeme = lexeme.concat("U");
                                                    i++;
                                                    if(sourcecode.charAt(i) == 'D'){
                                                        lexeme = lexeme.concat("D");
                                                        i++;
                                                        if(sourcecode.charAt(i) == 'E'){
                                                            lexeme = lexeme.concat("E");
                                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                                model.addRow(new String[]{lexeme, "INTERLUDE",""+(j+1),""+(i+2)});
                                                                lexeme = "";    //Clears the value for the next Lexeme
                                                                check = 1;  //Determines that the lexeme is a reserved word
                                                            }
                                                            else
                                                            {
                                                                i++;
                                                                //Delimiter for interlude
                                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                                                {
                                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                                    model.addRow(new String[]{lexeme,"INTERLUDE",""+(j+1),""+(i+1)});
                                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                                    i--;    //LookAhead
                                                                    check = 1; //Determines that the lexeme is a reserved word
                                                                }
                                                                else
                                                                {
                                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                                    error.addRow(new String[]{lexeme, "INTERLUDE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                                    i--;    //LookAhead
                                                                    check = 1; //Determines that the lexeme is a reserved word
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    else if(sourcecode.charAt(i) == 'R'){
                                        lexeme = lexeme.concat("R");
                                        i++;
                                        if(sourcecode.charAt(i) == 'O'){
                                            lexeme = lexeme.concat("O");
                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "INTRO",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for intro
                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "INTRO",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "INTRO has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(check == 0) //check if it is an id 
                            {
                                int sample = 0;
                                int k = 1;
                                    if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                    || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                    || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                    || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                    || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                    || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                    || sourcecode.charAt(i) == '{' )
                                    {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                    }
                                    else
                                    {
                                        while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                        &&  k <= 14)
                                        {
                                            lexeme += sourcecode.charAt(i);
                                            i++;
                                            if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                            || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                            || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                            || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                            || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                            || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                            || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                            || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                            || sourcecode.charAt(i) == '{')
                                            {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                                break;
                                            }
                                            else
                                            {
                                                sample = 1;
                                            }
                                            k++;
                                        }

                                        if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                        {
                                            error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                            lexeme = "";
                                        }
                                        else if (k > 14)
                                        {
                                            error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                        }
                                    }  
                            }
                    }
                    //Starting Letter L
                    else if(sourcecode.charAt(i) == 'L'){
                        lexeme = lexeme.concat("L");
                        i++;
                        if(sourcecode.charAt(i) == 'O'){
                            lexeme = lexeme.concat("O");
                            i++;
                            if(sourcecode.charAt(i) == 'O'){
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'P'){
                                    lexeme = lexeme.concat("P");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "LOOP",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for loop
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == '(')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "LOOP",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "LOOP has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter M
                    else if(sourcecode.charAt(i) == 'M'){
                        lexeme ="";
                        lexeme = lexeme.concat("M");
                        i++;
                        if(sourcecode.charAt(i) == 'U'){
                            lexeme = lexeme.concat("U");
                            i++;
                            if(sourcecode.charAt(i) == 'T'){
                                lexeme = lexeme.concat("T");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("E");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "MUTE",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for mute
                                        if(sourcecode.charAt(i) == ' ')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "MUTE",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "MUTE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    //Starting Letter N
                    else if(sourcecode.charAt(i) == 'N'){
                        lexeme = "";
                        lexeme = lexeme.concat("N");
                        i++;
                        if(sourcecode.charAt(i) == 'O'){
                            lexeme = lexeme.concat("O");
                            i++;
                            if(sourcecode.charAt(i) == 'T'){
                                lexeme = lexeme.concat("T");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("E");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "NOTE",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for note
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == ':')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "NOTE",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "NOTE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter O
                    else if(sourcecode.charAt(i) == 'O'){
                        lexeme = "";
                        lexeme = lexeme.concat("O");
                        i++;
                        if(sourcecode.charAt(i) == 'U'){
                            lexeme = lexeme.concat("U");
                            i++;
                            if(sourcecode.charAt(i) == 'T'){
                                lexeme = lexeme.concat("T");
                                i++;
                                if(sourcecode.charAt(i) == 'R'){
                                    lexeme = lexeme.concat("R");
                                    i++;
                                    if(sourcecode.charAt(i) == 'O'){
                                        lexeme = lexeme.concat("O");
                                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "OUTRO",""+(j+1),""+(i+2)});
                                            lexeme = "";    //Clears the value for the next Lexeme
                                            check = 1;  //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            i++;
                                            //Delimiter for outro
                                            if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '"')
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "OUTRO",""+(j+1),""+(i+1)});
                                                lexeme = "";    //Clears the variable for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                error.addRow(new String[]{lexeme, "OUTRO has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                lexeme = ""; //Clears the value for the next Lexeme
                                                i--;    //LookAhead
                                                check = 1; //Determines that the lexeme is a reserved word
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    //Starting Letter P
                    else if(sourcecode.charAt(i) == 'P'){
                        lexeme = "";
                        lexeme = lexeme.concat("P");
                        i++;
                        if(sourcecode.charAt(i) == 'L'){
                            lexeme = lexeme.concat("L");
                            i++;
                            if(sourcecode.charAt(i) == 'A'){
                                lexeme = lexeme.concat("A");
                                if(sourcecode.charAt(i) == 'Y'){
                                    lexeme = lexeme.concat("Y");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "PLAY",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for play
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == ';')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "PLAY",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "PLAY has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'R'){
                            lexeme = lexeme.concat("R");
                            i++;
                            if(sourcecode.charAt(i) == 'E'){
                                lexeme = lexeme.concat("E");
                                i++;
                                if(sourcecode.charAt(i) == 'L'){
                                    lexeme = lexeme.concat("L");
                                    i++;
                                    if(sourcecode.charAt(i) == 'U'){
                                        lexeme = lexeme.concat("U");
                                        i++;
                                        if(sourcecode.charAt(i) == 'D'){
                                            lexeme = lexeme.concat("D");
                                            i++;
                                            if(sourcecode.charAt(i) == 'E'){
                                                lexeme = lexeme.concat("E");
                                                if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme,"PRELUDE",""+(j+1),""+(i+2)});
                                                    lexeme = "";    //Clears the value for the next Lexeme
                                                    check = 1;  //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    i++;
                                                    //Delimiter for prelude
                                                    if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                        model.addRow(new String[]{lexeme, "PRELUDE",""+(j+1),""+(i+1)});
                                                        lexeme = "";    //Clears the variable for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                    else
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                        error.addRow(new String[]{lexeme, "PRELUDE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                        lexeme = ""; //Clears the value for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else if(sourcecode.charAt(i) == 'O'){
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'D'){
                                    lexeme = lexeme.concat("D");
                                    i++;
                                    if(sourcecode.charAt(i) == 'U'){
                                        lexeme = lexeme.concat("U");
                                        i++;
                                        if(sourcecode.charAt(i) == 'C'){
                                            lexeme = lexeme.concat("C");
                                            i++;
                                            if(sourcecode.charAt(i) == 'E'){
                                               lexeme = lexeme.concat("E");
                                               if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme,"PRODUCE",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for prelude
                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == '(')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "PRODUCE",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "PRODUCE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                           model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '('
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter R
                    else if(sourcecode.charAt(i) == 'R'){
                        lexeme = "";
                        lexeme = lexeme.concat("R");
                        i++;
                        if(sourcecode.charAt(i) == 'E'){
                            lexeme = lexeme.concat("E");
                            i++;
                            if(sourcecode.charAt(i) == 'C'){
                                lexeme = lexeme.concat("C");
                                i++;
                                if(sourcecode.charAt(i) == 'O'){
                                    lexeme = lexeme.concat("O");
                                    i++;
                                    if(sourcecode.charAt(i) == 'R'){
                                        lexeme = lexeme.concat("R");
                                        i++;
                                        if(sourcecode.charAt(i) == 'D'){
                                           lexeme = lexeme.concat("D");
                                           i++;
                                            if(sourcecode.charAt(i) == 'S'){
                                                lexeme = lexeme.concat("S");
                                                if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "RECORDS",""+(j+1),""+(i+2)});
                                                    lexeme = "";    //Clears the value for the next Lexeme
                                                    check = 1;  //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    i++;
                                                    //Delimiter for records
                                                    if(sourcecode.charAt(i) == ' ')
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                        model.addRow(new String[]{lexeme, "RECORDS",""+(j+1),""+(i+1)});
                                                        lexeme = "";    //Clears the variable for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                    else
                                                    {
                                                        //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                        error.addRow(new String[]{lexeme, "RECORDS has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                        lexeme = ""; //Clears the value for the next Lexeme
                                                        i--;    //LookAhead
                                                        check = 1; //Determines that the lexeme is a reserved word
                                                    }
                                                }
                                            }     
                                        }
                                    }
                                }
                            }
                            else if(sourcecode.charAt(i) == 'P'){
                                lexeme = lexeme.concat("P");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("E");
                                    i++;
                                    if(sourcecode.charAt(i) == 'A'){
                                        lexeme = lexeme.concat("A");
                                        i++;
                                        if(sourcecode.charAt(i) == 'T'){
                                            lexeme = lexeme.concat("T");
                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "REPEAT",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for repeat
                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '(')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "REPEAT",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "REPEAT has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%' || sourcecode.charAt(i) == '('
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '('
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter S
                    else if(sourcecode.charAt(i) == 'S'){
                        lexeme = "";
                        lexeme = lexeme.concat("S");
                        i++;
                        if(sourcecode.charAt(i) == 'T'){
                            lexeme = lexeme.concat("T");
                            i++;
                            if(sourcecode.charAt(i) == 'O'){
                                lexeme = lexeme.concat("O");
                                i++;
                                if(sourcecode.charAt(i) == 'P'){
                                    lexeme = lexeme.concat("P");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "STOP",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for stop
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == ';')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{lexeme, "STOP",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{lexeme, "STOP has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                            else if(sourcecode.charAt(i) == 'R'){
                                lexeme = lexeme.concat("R");
                                i++;
                                if(sourcecode.charAt(i) == 'I'){
                                    lexeme = lexeme.concat("I");
                                    i++;
                                    if(sourcecode.charAt(i) == 'N'){
                                        lexeme = lexeme.concat("N");
                                        i++;
                                        if(sourcecode.charAt(i) == 'G'){
                                            lexeme = lexeme.concat("G");
                                            if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                            {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                model.addRow(new String[]{lexeme, "STRING",""+(j+1),""+(i+2)});
                                                lexeme = "";    //Clears the value for the next Lexeme
                                                check = 1;  //Determines that the lexeme is a reserved word
                                            }
                                            else
                                            {
                                                i++;
                                                //Delimiter for string
                                                if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == ';')
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                    model.addRow(new String[]{lexeme, "STRING",""+(j+1),""+(i+1)});
                                                    lexeme = "";    //Clears the variable for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                                else
                                                {
                                                    //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                    error.addRow(new String[]{lexeme, "STRING has an invalid Delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                    lexeme = ""; //Clears the value for the next Lexeme
                                                    i--;    //LookAhead
                                                    check = 1; //Determines that the lexeme is a reserved word
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                         if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%' || sourcecode.charAt(i) == '('
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&' 
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '('
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    //Starting Letter T
                    else if(sourcecode.charAt(i) == 'T'){
                        lexeme = "";
                        lexeme = lexeme.concat("t");
                        i++;
                        if(sourcecode.charAt(i) == 'R'){
                            lexeme = lexeme.concat("r");
                            i++;
                            if(sourcecode.charAt(i) == 'U'){
                                lexeme = lexeme.concat("u");
                                i++;
                                if(sourcecode.charAt(i) == 'E'){
                                    lexeme = lexeme.concat("e");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{"true", "Boolean_Literal",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                        check = 1;  //Determines that the lexeme is a reserved word
                                    }
                                    else
                                    {
                                        i++;
                                        //Delimiter for true
                                        if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n'||sourcecode.charAt(i) == ';'
                                        ||sourcecode.charAt(i) == ','||sourcecode.charAt(i) == '}'||sourcecode.charAt(i+1)=='('
                                        ||sourcecode.charAt(i+1)==')')
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                            model.addRow(new String[]{"true", "Boolean_Literal",""+(j+1),""+(i+1)});
                                            lexeme = "";    //Clears the variable for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                        else
                                        {
                                            //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                            error.addRow(new String[]{"true", "TRUE has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = ""; //Clears the value for the next Lexeme
                                            i--;    //LookAhead
                                            check = 1; //Determines that the lexeme is a reserved word
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{' || sourcecode.charAt(i) == '(' )
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{' || sourcecode.charAt(i) == '(')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                    
                    else if(sourcecode.charAt(i) == 'W'){
                        lexeme = "";
                        lexeme = lexeme.concat("W");
                        i++;
                        if(sourcecode.charAt(i) == 'O'){
                            lexeme = lexeme.concat("O");
                            i++;
                            if(sourcecode.charAt(i) == 'R'){
                                lexeme = lexeme.concat("R");
                                i++;
                                if(sourcecode.charAt(i) == 'L'){
                                    lexeme = lexeme.concat("L");
                                    i++;
                                    if(sourcecode.charAt(i) == 'D'){
                                        lexeme = lexeme.concat("D");
                                        i++;
                                        if(sourcecode.charAt(i) == 'T'){
                                            lexeme = lexeme.concat("T");
                                            i++;
                                            if(sourcecode.charAt(i) == 'O'){
                                                lexeme = lexeme.concat("O");
                                                i++;
                                                if(sourcecode.charAt(i) == 'U'){
                                                    lexeme = lexeme.concat("U");
                                                    i++;
                                                    if(sourcecode.charAt(i) == 'R'){
                                                        lexeme = lexeme.concat("R");
                                                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                            model.addRow(new String[]{lexeme, "WORLDTOUR",""+(j+1),""+(i+2)});
                                                            lexeme = "";    //Clears the value for the next Lexeme
                                                            check = 1;  //Determines that the lexeme is a reserved word
                                                        }
                                                        else
                                                        {
                                                            i++;
                                                            //Delimiter for true
                                                            if(sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '\n')
                                                            {
                                                                //Adds the Lexeme, Line # and Column # to the Lexical Table
                                                                model.addRow(new String[]{lexeme, "WORLDTOUR",""+(j+1),""+(i+1)});
                                                                lexeme = "";    //Clears the variable for the next Lexeme
                                                                i--;    //LookAhead
                                                                check = 1; //Determines that the lexeme is a reserved word
                                                            }
                                                            else
                                                            {
                                                                //Adds the Lexeme, Line # and Column # to the Lexical Error Table
                                                                error.addRow(new String[]{lexeme, "WORLDTOUR has invalid Delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                                                lexeme = ""; //Clears the value for the next Lexeme
                                                                i--;    //LookAhead
                                                                check = 1; //Determines that the lexeme is a reserved word
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(check == 0) //check if it is an id 
                        {
                            int sample = 0;
                            int k = 1;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'|| sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '{'  || sourcecode.charAt(i) == '(')
                                {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while((Character.isLetter(sourcecode.charAt(i)) == true  || Character.isDigit(sourcecode.charAt(i)) == true)
                                    &&  k <= 14)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '('
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                        || sourcecode.charAt(i) == '{')
                                        {
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            //System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    idcount++;
                                    }
                                    lexeme = "";
                                    i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if((Character.isLetter(sourcecode.charAt(i)) == false && Character.isDigit(sourcecode.charAt(i)) == false))
                                    {
                                        error.addRow(new String[]{lexeme, " Variables are combination of Letters and Numbers.","Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else if (k > 14)
                                    {
                                        error.addRow(new String[]{lexeme, " Variables only consists of 15 Characters.","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                    }
                                }  
                        }
                    }
                   
                    //--END OF RESERVED WORDS--//

                    //--START OF RESERVED SYMBOLS--//

                    // LOGICAL Symbols
                    else if(sourcecode.charAt(i) == '&')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("&");
                        if(i == (sourcecode.length()-1))
                        {
                            error.addRow(new String[]{lexeme,"Unrecognized Character","Error At Line "+(j+1)+", Column : "+(i+1)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(sourcecode.charAt(i) == '&')
                            {
                                lexeme = lexeme.concat("&");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                                    {
                                        model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, "&& has invalid Delimeter","Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"Unrecognized Character","Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '|')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("|");
                        if(i == (sourcecode.length()-1))
                        {
                            error.addRow(new String[]{lexeme,"Unrecognized Character", "Error At Line "+(j+1)+", Column : "+(i+1)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(sourcecode.charAt(i) == '|')
                            {
                                lexeme = lexeme.concat("|");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                                    {
                                        model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme,"|| has invalid delimeter.", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"Unrecognized Character", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    //--END OF LOGICAL SYMBOLS--//

                    //--START OF MATHEMATICAL SYMBOLS--//
                    else if(sourcecode.charAt(i) == '/')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("/");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(')
                            {
                                model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"/ has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '+')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("+");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '||sourcecode.charAt(i) == '(' || sourcecode.charAt(i)==')')
                            {
                                model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '+')
                            {
                                lexeme = lexeme.concat("+");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Increment Operator",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == ';'|| Character.isLetter(sourcecode.charAt(i))
                                            || sourcecode.charAt(i) == ')')
                                    {
                                        model.addRow(new String[]{lexeme,"Increment Operator",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, "++ has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }

                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"+ has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '-')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("-");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if( Character.isLetter(sourcecode.charAt(i)) == true || Character.isDigit(sourcecode.charAt(i)) == true)
                            {
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '(' || sourcecode.charAt(i) == ' ')
                            {
                                    model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                            }
                            else if(sourcecode.charAt(i) == '-')
                            {
                                lexeme = lexeme.concat("-");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Decrement Operator",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(Character.isLetter(sourcecode.charAt(i))==true || Character.isDigit(sourcecode.charAt(i))==true)
                                    {
                                        if(Character.isDigit(sourcecode.charAt(i-3))||Character.isLetter(sourcecode.charAt(i-3) ))
                                        {
                                            lexeme = "";
                                            lexeme = lexeme.concat("-");
                                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+1)});
                                            i--;
                                        }
                                        else
                                        {
                                            model.addRow(new String[]{lexeme, "Decrement Operator",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                    else if(sourcecode.charAt(i)==';'||sourcecode.charAt(i)==' ')
                                    {
                                        model.addRow(new String[]{lexeme, "Decrement Operator",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, "-- has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            
                            /*else if(Character.isDigit(sourcecode.charAt(i)) == true)
                            {
                                lexeme += sourcecode.charAt(i);
                                i++;
                                int sample = 0;
                                int k = 1;

                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t')
                                {
                                    model.addRow(new String[]{lexeme, "Integer", "Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    while(Character.isDigit(sourcecode.charAt(i)) == true && k <= 9)
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                        || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t')
                                        {
                                            model.addRow(new String[]{lexeme, "Integer"});
                                            lexeme = "";
                                            sample = 0;
                                            i--;
                                            break;
                                        }
                                        else
                                        {
                                            sample = 1;
                                        }
                                        k++;
                                    }

                                    if(sourcecode.charAt(i) == '.')
                                    {
                                        lexeme += sourcecode.charAt(i);
                                        i++;
                                        k = 0;
                                        while( Character.isDigit(sourcecode.charAt(i)) == true && k <= 9)
                                        {
                                            lexeme += sourcecode.charAt(i);
                                            i++;
                                            if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                            || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                            || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                            || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                            || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                            || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                            || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                            || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                            || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t')
                                            {
                                                model.addRow(new String[]{lexeme, "Float"});
                                                lexeme = "";
                                                sample = 0;
                                                i--;
                                                break;
                                            }
                                            else
                                            {
                                                sample = 1;
                                            }
                                            k++;
                                        }
                                        if((Character.isDigit(sourcecode.charAt(i)) == false) || (k == 10 && sample == 1))
                                        {
                                            error.addRow(new String[]{lexeme, "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                        else if (k < 10 && sample == 1)
                                        {
                                            error.addRow(new String[]{lexeme, "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                    else if((Character.isDigit(sourcecode.charAt(i)) == false)
                                    || (k == 10 && sample == 1))
                                    {
                                        error.addRow(new String[]{lexeme, "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else if (k < 10 && sample == 1)
                                    {
                                        error.addRow(new String[]{lexeme, "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }*/
                        }
                    }
                    
                    //*
                    else if(sourcecode.charAt(i) == '*')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("*");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                            {
                                model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"* has invalid delimeter", " Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }
                    //%

                    else if(sourcecode.charAt(i) == '%')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("%");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' ' || sourcecode.charAt(i) == '(')
                            {
                                model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme, "% has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    } 
                    //--END OF MATHEMATICAL SYMBOLS--/

                    else if(sourcecode.charAt(i) == ';')
                    {
                        lexeme="";
                        lexeme = lexeme.concat(";");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\n'
                            || sourcecode.charAt(i) == '(' || sourcecode.charAt(i) == ')') //Delims of ;
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme, "; has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    //--START OF RELATIONAL SYMBOLS AND MAY LOGICAL DIN DITO NA !(NOT) --//

                    else if(sourcecode.charAt(i) == '>')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat(">");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of <
                            {
                                model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '=')
                            {
                                lexeme = lexeme.concat("=");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                        || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of <=
                                    {
                                        model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, ">= has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme, "> has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '<')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("<");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of <
                            {
                                model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '=')
                            {
                                lexeme = lexeme.concat("=");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                        || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of <=
                                    {
                                        model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, "<= has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme, "< has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '=')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("=");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == '{' || sourcecode.charAt(i) == '"'
                            || sourcecode.charAt(i) == '(' || sourcecode.charAt(i) == '\t'
                            || sourcecode.charAt(i) == '\'' || sourcecode.charAt(i) == ' '
                            ||sourcecode.charAt(i)=='[') //assignment symbol
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '=')
                            {
                                lexeme = lexeme.concat("=");
                                if(i == (sourcecode.length()-1)) //if walang delimiter
                                {
                                    model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                    || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of ==
                                    {
                                        model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme, "== has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"= has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '!')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("!");
                        if(i == (sourcecode.length()-1))
                        {
                            model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                            || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(') //Delims of !
                            {
                                model.addRow(new String[]{lexeme, "Logical Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(sourcecode.charAt(i) == '=')
                            {
                                lexeme = lexeme.concat("=");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                    || sourcecode.charAt(i) == ' '|| sourcecode.charAt(i) == '(')//Delims of !=
                                    {
                                        model.addRow(new String[]{lexeme, "Relational Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme,"!= has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme,"! has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }
                    //--END OF RELATIONAL SYMBOLS AND MAY LOGICAL DIN DITO NA !(NOT) --

                    //--START OF ESCAPE CHARACTERS--
                    else if(sourcecode.charAt(i) == '\\')
                    {
                        
                        lexeme = lexeme.concat("\\");
                        i++;
                        if(sourcecode.charAt(i) == '\'')
                        {
                            lexeme = lexeme.concat("\'");
                            if(i == (sourcecode.length()-1))
                            {
                                model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                i++;
                                if((Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\t'
                                || (!(Character.isDigit(sourcecode.charAt(i))) == true)))
                                {
                                    model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme, "", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == '\"')
                        {
                            lexeme = lexeme.concat("\"");
                            if(i == (sourcecode.length()-1))
                            {
                                model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                i++;
                                if((Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\t'
                                || (!(Character.isDigit(sourcecode.charAt(i))) == true)))
                                {
                                    model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme,"", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == '\\')
                        {
                            lexeme = lexeme.concat("\\");
                            if(i == (sourcecode.length()-1))
                            {
                                model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                i++;
                                if((Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\t'
                                || (!(Character.isDigit(sourcecode.charAt(i))) == true))
                                && sourcecode.charAt(i) != '\\')
                                {
                                    model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme, "",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 'n')
                        {
                            lexeme = lexeme.concat("n");
                            if(i == (sourcecode.length()-1))
                            {
                                model.addRow(new String[]{lexeme,"Escape Character",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                i++;
                                if((Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\t'
                                || (!(Character.isDigit(sourcecode.charAt(i))) == true)))
                                {
                                    model.addRow(new String[]{lexeme,"Escape Character",""+(j+1),""+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme, "", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                        }
                        else if(sourcecode.charAt(i) == 't')
                        {
                            lexeme = lexeme.concat("t");
                            if(i == (sourcecode.length()-1))
                            {
                                model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                i++;
                                if((Character.isDigit(sourcecode.charAt(i)) == true || Character.isLetter(sourcecode.charAt(i)) == true
                                || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\t'
                                || (!(Character.isDigit(sourcecode.charAt(i))) == true)))
                                {
                                model.addRow(new String[]{lexeme, "Escape Character",""+(j+1),""+(i+1)});
                                lexeme = "";
                                i--;
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme, "", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                        }
                        else
                        {
                            error.addRow(new String[]{lexeme+ "Error At Line "+(j+1)+", Column : "+(i+1)});
                            lexeme = "";
                            i--;
                        }
                    }
                     //----END OF ESCAPE CHARACTERS--

                    // '
                    else if(sourcecode.charAt(i) == '\'')
                    {
                        lexeme = lexeme.concat("\'");
                        if(i == (sourcecode.length()-1))
                        {
                            error.addRow(new String[]{lexeme,"Expecting Character Literal","Error At Line "+(j+1)+", Column : "+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            if(sourcecode.charAt(i) == '\\')
                            {
                                lexeme = lexeme.concat("\\");
                                i++;
                                if(sourcecode.charAt(i) == '\'')
                                {
                                    lexeme = lexeme.concat("\'");
                                    if(i == (sourcecode.length()-1))
                                    {
                                        error.addRow(new String[]{lexeme, "Invalid Delimiter for ' " , "Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        i++;
                                        if(sourcecode.charAt(i) == '\'')
                                        {
                                            lexeme = lexeme.concat("\'");
                                            model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }


                                else if(sourcecode.charAt(i) == '\"')
                                {
                                    lexeme = lexeme.concat("\"");
                                    if(i == (sourcecode.length()-1))
                                    {
                                        error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        i++;
                                        if(sourcecode.charAt(i) == '\'')
                                        {
                                            lexeme = lexeme.concat("\'");
                                            model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == '\\')
                                {
                                    lexeme = lexeme.concat("\\");
                                        if(i == (sourcecode.length()-1))
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal" , "Error At Line "+(j+1)+", Column : "+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            i++;
                                            if(sourcecode.charAt(i) == '\'')
                                            {
                                                lexeme = lexeme.concat("'");
                                                model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                                lexeme = "";
                                            }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == 'n')
                                {
                                    lexeme = lexeme.concat("n");
                                    if(i == (sourcecode.length()-1))
                                    {
                                        error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        i++;
                                        if(sourcecode.charAt(i) == '\'')
                                        {
                                            lexeme = lexeme.concat("\'");
                                            model.addRow(new String[]{lexeme, "Character Literal",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == 't')
                                {
                                    lexeme = lexeme.concat("t");
                                    if(i == (sourcecode.length()-1))
                                    {
                                        error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+2)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        i++;
                                        if(sourcecode.charAt(i) == '\'')
                                        {
                                            lexeme = lexeme.concat("\'");
                                            model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }
                                else
                                {
                                    error.addRow(new String[]{lexeme, "Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                            else if(sourcecode.charAt(i)=='\'')
                            {
                                lexeme = lexeme.concat("\'");
                                model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                lexeme = "";
                            }

                            else
                            {
                                lexeme += sourcecode.charAt(i);
                                if(i == (sourcecode.length()-1))
                                {
                                    error.addRow(new String[]{lexeme, "Expecting ' for Character Literal",  "Error At Line "+(j+1)+", Column : "+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    i++;
                                    if(sourcecode.charAt(i) == '\'')
                                    {
                                        lexeme = lexeme.concat("\'");
                                        model.addRow(new String[]{lexeme, "Character_Literal",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{lexeme,"Expecting ' for Character Literal", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme = "";
                                        i--;
                                    }
                                }
                            }
                        }
                    }

                    //--START OF OTHER RESERVED SYMBOLS--

                    else if(sourcecode.charAt(i) == ':')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat(":");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1)))
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{lexeme, ": has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '.')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat(".");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                            || sourcecode.charAt(i+1) == ',' || sourcecode.charAt(i+1) == ';' || sourcecode.charAt(i+1) == '"'
                            || sourcecode.charAt(i+1) == '\''|| sourcecode.charAt(i+1) == '('|| sourcecode.charAt(i+1) == ')')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{". " , ". has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == ',')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat(",");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                            Character.isAlphabetic(sourcecode.charAt(i+1))
                            || sourcecode.charAt(i+1) == ',' || sourcecode.charAt(i+1) == ';' || sourcecode.charAt(i+1) == '"'
                            || sourcecode.charAt(i+1) == '\''||sourcecode.charAt(i+1)=='{'||Character.isDigit(sourcecode.charAt(i+1)))
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{", " , ", has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '(')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("(");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                            || sourcecode.charAt(i+1) == '(' || sourcecode.charAt(i+1) == ')' || sourcecode.charAt(i+1) == '~'
                            || sourcecode.charAt(i+1) == '!')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"( " , "( has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == ')')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat(")");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                            || sourcecode.charAt(i+1) == '(' || sourcecode.charAt(i+1) == ')' || sourcecode.charAt(i+1) == '~'
                            || sourcecode.charAt(i+1) == '!'|| sourcecode.charAt(i+1) == ';'|| sourcecode.charAt(i+1) == '{'||sourcecode.charAt(i+1)=='+'
                            ||sourcecode.charAt(i+1)=='-'||sourcecode.charAt(i+1)=='='||sourcecode.charAt(i+1)=='*'||sourcecode.charAt(i+1)=='/'
                            ||sourcecode.charAt(i+1)=='%'||sourcecode.charAt(i+1)=='<'||sourcecode.charAt(i+1)=='>'||sourcecode.charAt(i+1) == ']')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{") " , ") has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '{')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("{");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))||
                            sourcecode.charAt(i+1)=='"'||sourcecode.charAt(i+1)=='('||sourcecode.charAt(i+1)=='{'||sourcecode.charAt(i+1)=='\'')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"{ " , "{ has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }

                    else if(sourcecode.charAt(i) == '}')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("}");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                            Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                            || sourcecode.charAt(i+1) == ',' || sourcecode.charAt(i+1) == ';'|| sourcecode.charAt(i+1) == '}')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"}" , "} has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }
                    // "
                    else if(sourcecode.charAt(i) == '"')
                    {

                        lexeme = lexeme.concat("\"");
                        if(i == (sourcecode.length()-1))
                        {
                                error.addRow(new String[]{lexeme, "Expecting String Literal", "Error At Line "+(j+1)+", Column : "+(i+2)});
                                lexeme = "";
                        }
                        else
                        {
                                i++;
                            while(sourcecode.charAt(i) != '"')
                            {
                                lexeme += sourcecode.charAt(i);
                                i++;
                                if(i == (sourcecode.length()-1))
                                {
                                   break;
                                }
                            }
                            if(sourcecode.charAt(i) == '"')
                            {
                               lexeme += sourcecode.charAt(i);
                               model.addRow(new String[]{lexeme, "String_Literal",""+(j+1),""+(i+2)});
                               lexeme = "";
                            }
                            else if(i == (sourcecode.length()-1))
                            {
                                error.addRow(new String[]{lexeme, "Expecting \" for String Literal ",  " Error At Line "+(j+1)+" Column : "+(i+2)});
                                lexeme = "";
                            }
                        }
                    }
//                    else if(sourcecode.charAt(i) == '"')
//                    {
//                        lexeme = lexeme.concat("\"");
//                        if(i == (sourcecode.length()-1))
//                        {
//                            error.addRow(new String[]{"\"", "Expecting String Literal",  " Error At Line "+(j+1)+" Column : "+(i+2)});
//                            lexeme = "";
//                        }
//                        else
//                        {
//                            i++;
//                            while(sourcecode.charAt(i) != '"')
//                            {
//                                if(sourcecode.charAt(i)=='\\')
//                                {
//                                    // int y=i+1;
//                                    if(sourcecode.charAt(i+1)=='"'){
//                                        lexeme += sourcecode.charAt(i+1);
//                                        i=i+2;
//                                    }
//                                }
//                                else
//                                {
//                                    lexeme += sourcecode.charAt(i);
//                                    i++;
//                                }
////                                if(i == (sourcecode.length()-1))
////                                {
////                                     break;
////                                }
//                            }
//                            if(sourcecode.charAt(i) == '"')
//                            {
//                                lexeme = lexeme.concat("\"");
//                                if(i == (sourcecode.length()-1))
//                                {
//                                    model.addRow(new String[]{lexeme, "String_Literal",""+(j+1),""+(i+2)});
//                                    lexeme = "";
//                                }
//                                else
//                                {
//                                    if(sourcecode.charAt(i+1)=='\n'||sourcecode.charAt(i+1)==';'||sourcecode.charAt(i+1)==' '
//                                    ||sourcecode.charAt(i+1)==','||sourcecode.charAt(i+1)=='}'||sourcecode.charAt(i+1) == '.')
//                                    {
//                                        model.addRow(new String[]{lexeme, "String_Literal",""+(j+1),""+(i+1)});
//                                        lexeme = "";
//                                    }
//                                    else
//                                    {
//                                        //lexeme="";
//                                        lexeme += sourcecode.charAt(i+1);
//                                        error.addRow(new String[]{lexeme ,"String Literal has invalid delimeter",  " Error at Line "+(j+1)+" Column :"+(i+2)});
//                                        lexeme = "";
//                                    }
//                                }
//                            }
//                            else if(i == (sourcecode.length()-1))
//                            {
//                                error.addRow(new String[]{lexeme, "Expecting \" for String Literal ",  " Error At Line "+(j+1)+" Column : "+(i+2)});
//                                lexeme = "";
//                            }
//                        }
//                    }
                    else if(sourcecode.charAt(i) == '#')
                    {
                      //  lexeme = lexeme.concat("#");
                        if(i == (sourcecode.length()-1))
                        {
                            error.addRow(new String[]{"#", "Expecting # for Comment", " Error At Line "+(j+1)+" Column : "+(i+2)});
                            lexeme = "";
                        }
                        else
                        {
                            i++;
                            while(sourcecode.charAt(i) != '#')
                            {

                                if(sourcecode.charAt(i)=='\\')
                                {
                                    // int y=i+1;
                                    if(sourcecode.charAt(i+1)=='"'){
                                        lexeme += sourcecode.charAt(i+1);
                                        i=i+2;
                                    }
                                    else if(sourcecode.charAt(i+1)=='#')
                                    {
                                        lexeme += sourcecode.charAt(i+1);
                                        i=i+2;
                                    }
                                }
                                else
                                {
                                    lexeme += sourcecode.charAt(i);
                                    i++;
                                }
//                               if(i == (sourcecode.length()-1))
//                               {
//                                 break;
//                               }
                            }
                            if(sourcecode.charAt(i) == '#')
                            {
                             //   lexeme = lexeme.concat("\#");
                                if(i == (sourcecode.length()-1))
                                {
                                    model.addRow(new String[]{lexeme, "Comment",""+(j+1),""+(i+2)});
                                    lexeme = "";
                                }
                                else
                                {
                                    if(sourcecode.charAt(i+1)=='\n'||sourcecode.charAt(i+1)==';'||sourcecode.charAt(i+1)==' ')
                                    {
                                        model.addRow(new String[]{lexeme, "Comment",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        //lexeme="";
                                        lexeme += sourcecode.charAt(i+1);
                                        error.addRow(new String[]{lexeme ,"Comment has invalid delimeter",  " Error at Line "+(j+1)+" Column :"+(i+2)});
                                        lexeme = "";
                                    }
                                }
                            }
                            else if(i == (sourcecode.length()-1))
                            {
                                error.addRow(new String[]{lexeme, "Expecting # for Comment", " Error At Line "+(j+1)+" Column : "+(i+2)});
                                lexeme = "";
                            }
                        }
                    }
                    // \n
//                    else if(sourcecode.charAt(i) == '\n')
//                    {
//                        lexeme = "";
//                        lexeme = lexeme.concat("\\n");
//                        model.addRow(new String[]{lexeme, "New Line",""+(j+1),""+(i+2)});
//                        lexeme = "";
//                    }
                    
                    // [
                    else if(sourcecode.charAt(i) == '[')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("[");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == b || 
                                Character.isDigit(sourcecode.charAt(i+1))|| Character.isAlphabetic(sourcecode.charAt(i+1))|| sourcecode.charAt(i+1)=='('
                                    ||sourcecode.charAt(i+1)==']'||sourcecode.charAt(i+1)=='('||sourcecode.charAt(i+1)=='+'||sourcecode.charAt(i+1)=='-')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"[" ,"[ has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }
                    // ]
                    else if(sourcecode.charAt(i) == ']')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("]");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == b
                            ||sourcecode.charAt(i+1) == '+'||sourcecode.charAt(i+1) == '-'||sourcecode.charAt(i+1) == '*'||sourcecode.charAt(i+1) == '/'
                            ||sourcecode.charAt(i+1) == '>'||sourcecode.charAt(i+1) == '<'||sourcecode.charAt(i+1) == ';'||sourcecode.charAt(i+1)=='[' 
                            ||sourcecode.charAt(i+1)=='='||sourcecode.charAt(i+1)==','||sourcecode.charAt(i+1)==')'||sourcecode.charAt(i+1)=='(')
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"]" , "] has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }
                    //~
                    else if(sourcecode.charAt(i) == '~')
                    {
                        lexeme = "";
                        lexeme = lexeme.concat("~");
                        if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                            lexeme = "";    //Clears the value for the next Lexeme
                        }
                        else
                        {
                            if(Character.isAlphabetic(sourcecode.charAt(i+1)))
                            {
                                model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                lexeme = "";
                            }
                            else
                            {
                                error.addRow(new String[]{"~" , "~ has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme="";
                            }
                        }
                    }
                    // \t
                    else if(sourcecode.charAt(i) == '\t')
                     {
                        lexeme = lexeme.concat("\\t");
                        model.addRow(new String[]{lexeme, "Horizontal Tab",""+(j+1),""+(i+2)});
                        lexeme = "";
                    }
                    //--END OF OTHER RESERVED SYMBOLS--

                    //--START OF INTEGER AND FLOAT LITERALS--

                    else if(Character.isDigit(sourcecode.charAt(i)) == true) // Integer and Float Literals
                    {
                        lexeme += sourcecode.charAt(i);
                        i++;
                        int sample = 0; //check if correct si delimeter
                        int k = 1;
                        int a=10;
                        char b =(char)a;
                        //System.out.println("hehe"+b+"hehe");
                        if(i == (sourcecode.length())) //Detects if the line has reached the end
                        {   //Adds the Lexeme, Line # and Column # to the Lexical Table

                            error.addRow(new String[]{lexeme ,lexeme+" has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                            lexeme="";
                        }
                        else
                        {
                            if(sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                            || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                            || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                            || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                            || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                            || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                            || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                            || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                            || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == ':'
                            || sourcecode.charAt(i) == '\t') //Delimiters for INT Literals (INT Literals)
                            {
                                model.addRow(new String[]{lexeme, "Integer_Literal",""+(j+1),""+(i+2)});
                                lexeme="";
                                if(sourcecode.charAt(i)==' ')
                                {
                                lexeme+= sourcecode.charAt(i);
                                model.addRow(new String[]{lexeme, "Space",""+(j+1),""+(i+2)});
                                }
                                else if(sourcecode.charAt(i)=='+'||sourcecode.charAt(i)=='-')
                                {
                                        lexeme+=sourcecode.charAt(i);
                                        if(sourcecode.charAt(i+1)=='-'&& sourcecode.charAt(i)=='-'){                                        

                                             lexeme+= sourcecode.charAt(i+1);
                                             model.addRow(new String[]{lexeme, "Decrement Operator",""+(j+1),""+(i+2)});
                                             i++;
                                        }
                                        else if(sourcecode.charAt(i+1)=='+'&& sourcecode.charAt(i)=='+'){
                                             lexeme+= sourcecode.charAt(i+1);
                                             model.addRow(new String[]{lexeme, "Increment Operator",""+(j+1),""+(i+2)});
                                             i++;
                                        }
                                        else{
                                            model.addRow(new String[]{lexeme, "Mathematical Symbol",""+(j+1),""+(i+2)});
                                            lexeme="";
                                        }
                                       
                                }
                                else if(sourcecode.charAt(i) == ',')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat(",");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                                        Character.isAlphabetic(sourcecode.charAt(i+1))
                                        || sourcecode.charAt(i+1) == ',' || sourcecode.charAt(i+1) == ';' || sourcecode.charAt(i+1) == '"'
                                        || sourcecode.charAt(i+1) == '\''||sourcecode.charAt(i+1)=='{'||Character.isDigit(sourcecode.charAt(i+1)))
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{", " , ", has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }
                                else if(sourcecode.charAt(i) == '[')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat("[");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == b || 
                                            Character.isDigit(sourcecode.charAt(i+1))|| Character.isAlphabetic(sourcecode.charAt(i+1))|| sourcecode.charAt(i+1)=='('
                                                ||sourcecode.charAt(i+1)==']'||sourcecode.charAt(i+1)=='('||sourcecode.charAt(i+1)=='+'||sourcecode.charAt(i+1)=='-')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{"[" ,"[ has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }
                                // ]
                                else if(sourcecode.charAt(i) == ']')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat("]");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == b
                                        ||sourcecode.charAt(i+1) == '+'||sourcecode.charAt(i+1) == '-'||sourcecode.charAt(i+1) == '*'||sourcecode.charAt(i+1) == '/'
                                        ||sourcecode.charAt(i+1) == '>'||sourcecode.charAt(i+1) == '<'||sourcecode.charAt(i+1) == ';'||sourcecode.charAt(i+1)=='[' 
                                        ||sourcecode.charAt(i+1)=='=' || sourcecode.charAt(i+1) == ' ' || sourcecode.charAt(i+1) == ',')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{"]" , "] has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }
                                else if(sourcecode.charAt(i) == ';')
                                {
                                    lexeme="";
                                    lexeme = lexeme.concat(";");
                                    if(i == (sourcecode.length()-1))
                                    {
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        i++;
                                        if(Character.isLetter(sourcecode.charAt(i)) == true
                                        || sourcecode.charAt(i) == ' '  || sourcecode.charAt(i) == '\n'
                                        || sourcecode.charAt(i) == '(' || sourcecode.charAt(i) == ')') //Delims of ;
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{lexeme, "; has invalid delimeter", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme = "";
                                            i--;
                                        }
                                    }
                                }
                                else if(sourcecode.charAt(i)==':')
                                {
                                    lexeme+=sourcecode.charAt(i);
                                    if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                                    Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1)))
                                    {
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+1)});
                                        lexeme = "";
                                    }
                                    else
                                    {
                                        error.addRow(new String[]{": " , ": has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                        lexeme="";
                                    }           
                                }
                                else if(sourcecode.charAt(i) == '(')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat("(");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||
                                        Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                                        || sourcecode.charAt(i+1) == '(' || sourcecode.charAt(i+1) == ')' || sourcecode.charAt(i+1) == '~'
                                        || sourcecode.charAt(i+1) == '!')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{"( " , "( has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == ')')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat(")");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||
                                        Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                                        || sourcecode.charAt(i+1) == '(' || sourcecode.charAt(i+1) == ')' || sourcecode.charAt(i+1) == '~'
                                        || sourcecode.charAt(i+1) == '!'|| sourcecode.charAt(i+1) == ';'|| sourcecode.charAt(i+1) == '{'||sourcecode.charAt(i+1)=='+'
                                        ||sourcecode.charAt(i+1)=='-'||sourcecode.charAt(i+1)=='='||sourcecode.charAt(i+1)=='*'||sourcecode.charAt(i+1)=='/'
                                        ||sourcecode.charAt(i+1)=='%'||sourcecode.charAt(i+1)=='<'||sourcecode.charAt(i+1)=='>'||sourcecode.charAt(i+1) == ']')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{") " , ") has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == '{')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat("{");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||sourcecode.charAt(i+1) == '\n' ||
                                        Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))||
                                        sourcecode.charAt(i+1)=='"'||sourcecode.charAt(i+1)=='('||sourcecode.charAt(i+1)=='{'||sourcecode.charAt(i+1)=='\'')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{"{ " , "{ has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }

                                else if(sourcecode.charAt(i) == '}')
                                {
                                    lexeme = "";
                                    lexeme = lexeme.concat("}");
                                    if(i == (sourcecode.length()-1)) //Detects if the line has reached the end
                                    {   //Adds the Lexeme, Line # and Column # to the Lexical Table
                                        model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                        lexeme = "";    //Clears the value for the next Lexeme
                                    }
                                    else
                                    {
                                        if(sourcecode.charAt(i+1) == ' '||
                                        Character.isAlphabetic(sourcecode.charAt(i+1)) || Character.isDigit(sourcecode.charAt(i+1))
                                        || sourcecode.charAt(i+1) == ',' || sourcecode.charAt(i+1) == ';'|| sourcecode.charAt(i+1) == '}')
                                        {
                                            model.addRow(new String[]{lexeme, "Reserved Symbol",""+(j+1),""+(i+2)});
                                            lexeme = "";
                                        }
                                        else
                                        {
                                            error.addRow(new String[]{"}" , "} has invalid delimeter",  "Error At Line "+(j+1)+", Column : "+(i+1)});
                                            lexeme="";
                                        }
                                    }
                                }
                               // else if(sourcecode.charAt(i)=='*'||sourcecode.charAt(i)=='/')
                                else
                                {
                                    lexeme+= sourcecode.charAt(i);
                                    error.addRow(new String[]{lexeme, "Unrecog Symbol",""+(j+1),""+(i+2)});
                                    lexeme="";
                                }
                            }
                        
                            
                        else
                        {
                            while(Character.isDigit(sourcecode.charAt(i)) == true && k <= 9) //Determines the length of the INT
                            {
                                lexeme += sourcecode.charAt(i);
                                i++;
                                if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == ':'
                                || sourcecode.charAt(i) == '\t'|| sourcecode.charAt(i) == '\n' &&(k<=9))
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                    model.addRow(new String[]{lexeme, "Integer_Literal",""+(j+1),""+(i+1)});
                                    lexeme = "";
                                    sample = 0;
                                    i--; //LookAhead
                                    break;  //break na kasi valid naman na si lexeme
                                }
                                else
                                {
                                    sample = 1;
                                }
                                k++;
                            }

                            if(sourcecode.charAt(i) == '.') //Determines if the value if FLOAT
                            {
                                lexeme += sourcecode.charAt(i);
                                i++;
                                k = 0;
                            
                                while( Character.isDigit(sourcecode.charAt(i)) == true && k <= 9)
                                {
                                    lexeme += sourcecode.charAt(i);
                                    i++;
                                    if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                    || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>'
                                    || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                    || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                    || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                    || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                    || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                    || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                    || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == ':'
                                    || sourcecode.charAt(i) == '\t') // Delimeter
                                    {
                                        //TRAILING ZEROES ON WORKING
                                       //lexeme.replace(' ',lexeme.charAt(lexeme.length()-1));
                                       // lexeme.charAt(lexeme.length()-1);
                                        model.addRow(new String[]{lexeme, "Float_Literal",""+(j+1),""+(i+1)});
                                        lexeme = ""; //Clears the variable for Lexeme
                                        sample = 0;
                                        i--; // LookAhead Character
                                        break;  //break na kasi valid naman na si lexeme
                                    }
                                    else
                                    {
                                        sample = 1;
                                    }
                                    k++;
                                }
                                if((Character.isDigit(sourcecode.charAt(i)) == false)
                                || (k >= 10))
                                {
                                    error.addRow(new String[]{lexeme, "" ,"Error At Line "+(j+1)+", Column : "+(i+1)});
                                    lexeme = "";
                                    i--;
                                }
                            }
                            else if((Character.isDigit(sourcecode.charAt(i)) == false) //Determines if the next character is not digit
                            || (k >= 10 && sample == 1)) //Determines if the number exceeds the length of 10 digits
                            {
                                error.addRow(new String[]{lexeme,"", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                            else if(k >= 10 && sample == 1)
                            {
                                error.addRow(new String[]{lexeme+ "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }
                    }

                    //--END OF INTEGER AND FLOAT LITERALS--//
                    
                    //--START OF IDENTIFIER CHECKER--
                    else if(Character.isLetter(sourcecode.charAt(i)) == true)
                    {
                        lexeme="";
                        lexeme += sourcecode.charAt(i);
                        i++;
                        int sample = 0;
                        int k = 1; // Storage for Length of Variable
                        if((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                        || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '('
                        || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                        || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                        || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                        || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                        || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                        || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                        || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                        || sourcecode.charAt(i) == '.' || sourcecode.charAt(i) == '('
                        || sourcecode.charAt(i) == '{' || sourcecode.charAt(i) == '~' && k<=1) //Delimeter for Variable
                        {
                            //Adds the Lexeme, Line # and Column # to the Lexical Table
                                    if(stringList.contains(lexeme))
                                    {
                                        //System.out.println("Hala nahulog");
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else{
                            stringList.add(lexeme);
                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                            idcount++;
                                    }
                            lexeme = ""; // Clears the Lexeme
                            i--; // LookAhead
                                    
                        }
                        else
                        {
                            while(Character.isLetter(sourcecode.charAt(i)) == true || Character.isDigit(sourcecode.charAt(i)) == true || sourcecode.charAt(i)=='_' &&   k <= 15)
                            {
                                lexeme += sourcecode.charAt(i);
                                i++;
                                if(((i == sourcecode.length()) || sourcecode.charAt(i) == '<' || sourcecode.charAt(i) == ' '
                                || sourcecode.charAt(i) == '=' || sourcecode.charAt(i) == '>' || sourcecode.charAt(i) == '!'
                                || sourcecode.charAt(i) == '-' || sourcecode.charAt(i) == '+'
                                || sourcecode.charAt(i) == '*' || sourcecode.charAt(i) == '}'
                                || sourcecode.charAt(i) == '/' || sourcecode.charAt(i) == '%'
                                || sourcecode.charAt(i) == '|' || sourcecode.charAt(i) == '&'
                                || sourcecode.charAt(i) == ')' || sourcecode.charAt(i) == ';'
                                || sourcecode.charAt(i) == '[' || sourcecode.charAt(i) == ']'
                                || sourcecode.charAt(i) == ',' || sourcecode.charAt(i) == '\t'
                                || sourcecode.charAt(i) == '.' || sourcecode.charAt(i) == '('
                                || sourcecode.charAt(i) == '{' || sourcecode.charAt(i) == '~') && (k<=14)) //Delimeter for Variable
                                {
                                    //Adds the Lexeme, Line # and Column # to the Lexical Table
                                    if(stringList.contains(lexeme))
                                    {
                                        idstring = stringList.toArray(new String[] {});
                                        for(idcount=1;idcount<idstring.length;idcount++)
                                        {
//                                            System.out.println(idstring[idcount]);
                                            if(idstring[idcount].equals(lexeme))
                                            {
                                            //System.out.println("nangyayari ba ako");
                                            model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                            }
                                        }
                                    }
                                    else
                                    {
                                    stringList.add(lexeme);
                                    model.addRow(new String[]{lexeme,"ID",""+(j+1),""+(i+1),"ID"+idcount});
                                    lexeme = ""; // Clears the Lexeme
                                    idcount++;
                                    }
                                    sample = 0;
                                    i--; //LookAhead
                                    break;  //Exits the loop
                                }
                                else
                                {
                                    sample = 1; //determines if the delimiter is incorrect
                                }
                                k++;
                            }
//                            if(Character.isLetter(sourcecode.charAt(i)) == false || Character.isDigit(sourcecode.charAt(i)) == false && k <= 15 && sample == 1)
//                            {
//                                error.addRow(new String[]{lexeme, "Invalid Delimiter", "Error At Line "+(j+1)+", Column : "+(i+1)});
//                                lexeme = "";
//                                i--;
//                            }
                            if (k > 15 && sample == 1) //else if ((k < 10 && sample == 1) || k == 1)
                            {
                                error.addRow(new String[]{lexeme, "Identifiers only consist of 15 characters", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";      
                                i--;
                            }
                            else if (sample == 1) //else if ((k < 10 && sample == 1) || k == 1)
                            {
                                error.addRow(new String[]{lexeme, "INVALID DELIMITER OF IDENTIFIER", "Error At Line "+(j+1)+", Column : "+(i+1)});
                                lexeme = "";
                                i--;
                            }
                        }
                    }
                    //--END OF IDENTIFIER CHECKER--

                    else if(sourcecode.charAt(i) == ' ')
                    {
                        lexeme += sourcecode.charAt(i);
                        model.addRow(new String[]{" ","Space",""+(j+1),""+(i+2)});
                        lexeme = "";
                    }
//                    else if(sourcecode.charAt(i) == '\n')
//                    {
//                        lexeme += sourcecode.charAt(i);
//                        model.addRow(new String[]{"\n", "New Line",""+(j+1),""+(i+2)});
//                        lexeme = "";
//                    }
                    else
                    {
                        error.addRow(new String[]{"","INVALID - Unrecognized Character", "Error at Line"+(j+1)+", Column:"+(i+1)});
                    }
                    check = 0;
                }
            }catch(StringIndexOutOfBoundsException e)
            {

            }
        }// TODO add your handling code here:
        if(tblError.getRowCount() == 0) //check the error table of Lexical Error Table and THERE IS NO ERROR
        {
            btnSyntax.setEnabled(true);  // Enables the Syntax Button
            tabMainTables.setSelectedIndex(0);
            tabErrorTables.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "No Lexical Error Detected!");
            //playSound("Justin Bieber - Baby.wav");

        }
        else
        {
            btnSyntax.setEnabled(false);    
            btnRemove.setEnabled(true);    
            tabMainTables.setSelectedIndex(0); 
            tabErrorTables.setSelectedIndex(0);  
            //playSound("318_harry_potter_hedwigs_theme_song_music_mp3_ringtone_ringtone_mp3.wav");
            JOptionPane.showMessageDialog(null, "Lexical Error Detected!");
        }
    }//GEN-LAST:event_LexicalMousePressed
    
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRemoveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseReleased

    private void btnRemoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMousePressed
        // TODO add your handling code here:
        reInitialize();
        code = "";
        
        DefaultTableModel model = (DefaultTableModel) tblLexeme.getModel(); //Table for Lexeme
        DefaultTableModel modelSyntax = (DefaultTableModel) tblSyntax.getModel(); //Table for Syntax
        DefaultTableModel modelConstantDec = (DefaultTableModel) tblConstantDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelGlobalDec = (DefaultTableModel) tblGlobalDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelLocalDec = (DefaultTableModel) tblLocalDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelIdentifier = (DefaultTableModel) tblIdentifier.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionParameters = (DefaultTableModel) tblFunctionParemeters.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionDeclaration = (DefaultTableModel) tblFunctionDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionReturn = (DefaultTableModel) tblFunctionReturn.getModel(); //Table for Semantic
        DefaultTableModel modelArray = (DefaultTableModel) tblArray.getModel(); //Table for Semantic
        DefaultTableModel modelStruct = (DefaultTableModel) tblStructDeclaration.getModel(); //Table for Semantic
        DefaultTableModel error = (DefaultTableModel) tblError.getModel();
        DefaultTableModel errorSyntax = (DefaultTableModel) tblErrorSyntax.getModel();
        DefaultTableModel errorSemantic = (DefaultTableModel) tblErrorSemantic.getModel();
        
        txtareaCompiler.setText("");
        btnSyntax.setEnabled(false);
        btnSemantic.setEnabled(false);
       
        //Clearing
        
        model.setRowCount(0);
        modelSyntax.setRowCount(0);
        modelConstantDec.setRowCount(0);
        modelGlobalDec.setRowCount(0);
        modelLocalDec.setRowCount(0);
        modelArray.setRowCount(0);
        modelStruct.setRowCount(0);
        modelIdentifier.setRowCount(0);
        error.setRowCount(0);
        errorSyntax.setRowCount(0);
        errorSemantic.setRowCount(0);
        modelFunctionParameters.setRowCount(0);
        modelFunctionDeclaration.setRowCount(0);
        modelFunctionReturn.setRowCount(0);
        //
        
        tokenPos = 0;
        token = 0;
        isFromWorldtour = false;
        hasError = false;
        is2darray = false;
        errNo = "";
    }//GEN-LAST:event_btnRemoveMousePressed

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void txtareaCompilerCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtareaCompilerCaretUpdate
        // TODO add your handling code here:
        // TODO add your handling code here:
        int caretPos = txtareaCompiler.getCaretPosition();
        int rowNum = (caretPos == 0) ? 1 : 0;
        for(int offset = caretPos; offset > 0;)
        {
            try{
                offset = Utilities.getRowStart(txtareaCompiler, offset) - 1;

            }catch (BadLocationException ex){
                Logger.getLogger(OrchestraFrame.class.getName()).log(Level.SEVERE, null, ex);

            }
            rowNum++;
        }
        int offset = 0;
        try {
            offset = Utilities.getRowStart(txtareaCompiler, caretPos);
        }catch(BadLocationException ex)
        {
            Logger.getLogger(OrchestraFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        colNum = caretPos - offset + 1;
        lblRowCol.setText("LINE: "+rowNum+"\n COLUMN: "+colNum);
    }//GEN-LAST:event_txtareaCompilerCaretUpdate
    //list of tokens
    final int CONCERT = 1, INTERLUDE = 2, PRODUCE = 3, CONST = 4, STOP = 5, PLAY = 6, IF = 7, ELSE =8, ELSEIF = 9, CHORDS = 10
              ,NOTE = 11, CADENCE = 12, LOOP = 13, REPEAT = 14, DO = 15, INT = 16, FLOAT = 17, STRING = 18, CHAR = 19, BOOL = 20
              ,RECORDS = 21, MUTE = 22, OUTRO = 23, INTRO = 24, PRELUDE = 25, TRUE = 26, FALSE = 27
              //RESERVED SYMBOLS
              ,SEMICOLON = 28, OPENCURLYBRACE = 29, CLOSECURLYBRACE = 30, OPENBRACKET = 31, CLOSEBRACKET = 32, OPENPARENTHESIS = 33
              ,CLOSEPARENTHESIS = 34, SHARP = 35, PERIOD = 36, COMMA = 37, EQUAL = 38, TILDE = 39, SINGLEQUOTE = 40, DOUBLEQUOTE = 41
              ,COLON = 42, DOLLARSIGN = 43
              //MATHEMATICAL OPERATORS
              ,PLUS = 44, MINUS = 45, MULTIPLY = 46, DIVIDE = 47, MODULUS = 48, INCREMENT = 49, DECREMENT = 50
              //RELATIONAL OPERATORS
              ,GREATERTHAN = 51, LESSTHAN = 52, GREATERTHANEQUAL = 53, LESSTHANEQUAL = 54, EQUALEQUAL = 55, NOTEQUAL = 56
              //LOGICAL
              ,AND = 57, OR = 58, NOT = 59
              //IDENTIFIER
              ,IDENTIFIER = 60
              //LITERALS
              ,INTEGERLITERAL = 61, FLOATLITERAL = 62, CHARLITERAL = 63, STRINGLITERAL = 64, BOOLLITERAL = 65  
               //
              ,ENCORE = 66, WORLDTOUR = 67;
    
    public int tokenPos = 0;
    public int token = 0;
    public boolean isFromWorldtour = false;
    public boolean hasError = false, is2darray = false;
    public String errNo = "";
    
    void addToSyntaxTable(String production, String set)
    {
        DefaultTableModel modelSyntax = (DefaultTableModel) tblSyntax.getModel();
        modelSyntax.addRow(new String[]{production, set});
    }
    
    void addToSyntaxErrorTable(String production, String set)
    {
        DefaultTableModel modelErrorSyntax = (DefaultTableModel) tblErrorSyntax.getModel();
        modelErrorSyntax.addRow(new String[]{production, set+" At Line "+tblLexeme.getModel().getValueAt(tokenPos-2, 2)});
    }
    void addToSyntaxErrorTableForPrelude(String production, String set)
    {
        DefaultTableModel modelErrorSyntax = (DefaultTableModel) tblErrorSyntax.getModel();
        modelErrorSyntax.addRow(new String[]{production, set+" At Line "+tblLexeme.getModel().getValueAt(tokenPos-1, 2)});
    }
        
    int getToken()
    {
        String tokenText = tblLexeme.getValueAt(tokenPos, 1).toString();
        //String tokenTextID = tblLexeme.getValueAt(tokenPos, 4).toString();
        String leftSide = tblLexeme.getValueAt(tokenPos, 0).toString();
        int tokenValue = 0;
        if(tokenText.equals("ID"))
        {
            tokenValue = IDENTIFIER;
        }   
        else if(tokenText.startsWith("Integer_Literal"))
        {
            tokenValue = INTEGERLITERAL;
        }
        else if(tokenText.startsWith("Float_Literal"))
        {
            tokenValue = FLOATLITERAL;
        }
        else if(tokenText.startsWith("Character_Literal"))
        {
            tokenValue = CHARLITERAL;
        }
        else if(tokenText.startsWith("String_Literal"))
        {
            tokenValue = STRINGLITERAL;
        }
        else if(tokenText.startsWith("Boolean_Literal"))
        {
            tokenValue = BOOLLITERAL;
        }
        else if(tokenText.equals("Reserved Symbol"))
        {
            switch(leftSide)
            {
                case ";" : tokenValue = SEMICOLON; break;
                case "{" : tokenValue = OPENCURLYBRACE; break;
                case "}" : tokenValue = CLOSECURLYBRACE; break;
                case "[" : tokenValue = OPENBRACKET; break;
                case "]" : tokenValue = CLOSEBRACKET; break;
                case "(" : tokenValue = OPENPARENTHESIS; break;
                case ")" : tokenValue = CLOSEPARENTHESIS; break;
                case "#" : tokenValue = SHARP; break;
                case "." : tokenValue = PERIOD; break;
                case "," : tokenValue = COMMA; break;
                case "=" : tokenValue = EQUAL; break;
                case "~" : tokenValue = TILDE; break;
                case "'" : tokenValue = SINGLEQUOTE; break;
                case "\"": tokenValue = DOUBLEQUOTE; break;
                case ":" : tokenValue = COLON; break;
                case "$" : tokenValue = DOLLARSIGN; break;
                default: JOptionPane.showMessageDialog(null, "Symbol Not Tokenize "+ tblLexeme.getValueAt(tokenPos, 0));
            }
        }
        else if(tokenText.equals("Mathematical Symbol"))
        {
            switch(leftSide)
            {
                case "+" : tokenValue = PLUS; break;
                case "-" : tokenValue = MINUS; break;
                case "*" : tokenValue = MULTIPLY; break;
                case "/" : tokenValue = DIVIDE; break;
                case "%" : tokenValue = MODULUS; break;
                default: JOptionPane.showMessageDialog(null, "Symbol Not Tokenize "+ tblLexeme.getValueAt(tokenPos, 0));
            }
        }
        else if(tokenText.equals("Increment Operator"))
        {
            tokenValue = INCREMENT;
        }
        else if(tokenText.equals("Decrement Operator"))
        {
            tokenValue = DECREMENT;
        }
        else if(tokenText.equals("Relational Symbol"))
        {
            switch(leftSide)
            {
                case ">" : tokenValue = GREATERTHAN; break;
                case "<" : tokenValue = LESSTHAN; break;
                case ">=" : tokenValue = GREATERTHANEQUAL; break;
                case "<=" : tokenValue = LESSTHANEQUAL; break;
                case "==" : tokenValue = EQUALEQUAL; break;
                case "!=" : tokenValue = NOTEQUAL; break; 
                default: JOptionPane.showMessageDialog(null, "Symbol Not Tokenize "+ tblLexeme.getValueAt(tokenPos, 0));

            }   
        }
        else if(tokenText.equals("Logical Symbol"))
        {
            switch(leftSide)
            {
                case "&&" : tokenValue = AND; break;
                case "||" : tokenValue = OR; break;
                case "!" : tokenValue = NOT; break;
                default: JOptionPane.showMessageDialog(null, "Symbol Not Tokenize "+ tblLexeme.getValueAt(tokenPos, 0));
            }   
        }
        else
        {
            switch(tokenText)
            {
                case "CONCERT" : tokenValue = CONCERT; break;
                case "INTERLUDE" : tokenValue = INTERLUDE; break;
                case "CONST" : tokenValue = CONST; break;
                case "STOP" : tokenValue = STOP; break;
                case "PLAY" : tokenValue = PLAY; break;
                case "IF" : tokenValue = IF; break;
                case "ELSE" : tokenValue = ELSE; break;
                case "ELSEIF" : tokenValue = ELSEIF; break;
                case "CHORDS" : tokenValue = CHORDS; break;
                case "NOTE" : tokenValue = NOTE; break;
                case "CADENCE" : tokenValue = CADENCE; break;
                case "LOOP" : tokenValue = LOOP; break;
                case "REPEAT" : tokenValue = REPEAT; break;
                case "DO" : tokenValue = DO; break;
                case "INT" : tokenValue = INT; break;
                case "FLOAT" : tokenValue = FLOAT; break;
                case "STRING" : tokenValue = STRING; break;
                case "CHAR" : tokenValue = CHAR; break;
                case "BOOL" : tokenValue = BOOL; break;
                case "RECORDS" : tokenValue = RECORDS; break;
                case "MUTE" : tokenValue = MUTE; break;
                case "OUTRO" : tokenValue = OUTRO; break;
                case "INTRO" : tokenValue = INTRO; break;
                case "PRELUDE" : tokenValue = PRELUDE; break;
                case "PRODUCE" : tokenValue = PRODUCE; break;
                case "ENCORE" : tokenValue = ENCORE; break;
                case "WORLDTOUR" : tokenValue = WORLDTOUR; break;
                default: JOptionPane.showMessageDialog(null, "Reserved Word Not Tokenize "+ tblLexeme.getValueAt(tokenPos, 0));
            }
        }
        tokenPos++;
        return tokenValue;
    }
    
    void removeNotNeed()
    {
        DefaultTableModel model = (DefaultTableModel) tblLexeme.getModel();
        int rowModel = model.getRowCount(), ctr=0;
        while(ctr<rowModel)
        {
            if(tblLexeme.getValueAt(ctr, 1).toString().trim().equals("Space") || tblLexeme.getValueAt(ctr, 1).toString().trim().equals("New Line")
            || tblLexeme.getValueAt(ctr, 1).toString().trim().equals("Comment")|| tblLexeme.getValueAt(ctr, 1).toString().trim().equals("Horizontal Tab"))
            {
              model.removeRow(ctr);
              ctr--;
            }   
            ctr++;
        }    
    }
    int unexpected = 0 , postToken;
    boolean checker(int expectedToken)
    {
        unexpected = token;
        if(token == expectedToken)
        {   
            postToken = token;
            if(tokenPos<tblLexeme.getRowCount()){
                token = getToken(); //get next token
            }
            return true;
        }
        else
        {   
            return false;
        }
    }
    public boolean isConcert = false;
    void production_program() //first production accdg to cfg hihi
    {    
        if(checker(PRELUDE))
        {
            
            addToSyntaxTable("<program>","PRELUDE");
            addToSyntaxTable("<program>", "<global>");
                production_global();
            if(checker(CONCERT))
            {
                code = code.concat("int main");
                isConcert = true;
                addToSyntaxTable("<program>","CONCERT");
                if(checker(OPENPARENTHESIS))
                {
                    code = code.concat("(");
                    addToSyntaxTable("<program>","(");
                    if(checker(CLOSEPARENTHESIS))
                    {
                        code = code.concat(")");
                        addToSyntaxTable("<program>",")");
                        if(checker(OPENCURLYBRACE))
                        {
                            code = code.concat("{");
                            code = code.concat(" std::cout << std::setprecision(4) << std::fixed;");
                            addToSyntaxTable("<program>","{");
                            if(checker1(INT)||checker1(FLOAT)||checker1(CHAR)||checker1(STRING)||checker1(BOOL) && hasError == false) //check if pupunta kay production vardec1 // localdec
                            {
                                addToSyntaxTable("<program>","<localdec>");
                                    production_vardec1();
                                addToSyntaxTable("<program>","<statements>");
                                    production_statements();
                                if(checker(CLOSECURLYBRACE))
                                {
                                    code = code.concat(" system(\"pause\");\n return 0;\n");
                                    code = code.concat("\n }");
                                    addToSyntaxTable("<program>","}"); 
                                    if(checker(ENCORE))
                                    {
                                        addToSyntaxTable("<program>","ENCORE");
                                    }
                                    else
                                    {
                                        addToSyntaxErrorTable("<program>", "Expecting ENCORE");
                                    }
                                }   
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<program>", "Expecting }, Identifier, ++, --, IF, ELSEIF, ELSE, CHORDS, LOOP, DO, OUTRO, INTRO");
                                    hasError = true;
                                }
                            }
                            else
                            {
                                addToSyntaxTable("<program>","<statements>");
                                    production_statements();
                                if(checker(CLOSECURLYBRACE))
                                {
                                    code = code.concat(" system(\"pause\");\n return 0;\n");
                                    code = code.concat("\n }");
                                    addToSyntaxTable("<program>","}"); 
                                    if(checker(ENCORE))
                                    {
                                        addToSyntaxTable("<program>","ENCORE");
                                    }
                                    else
                                    {
                                        addToSyntaxErrorTable("<program>", "Expecting ENCORE");
                                    }
                                }   
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<program>", "Expecting },INT, FLOAT, CHAR, STRING, BOOL, Identifier, ++, --, IF, ELSEIF, ELSE, CHORDS, LOOP, DO, OUTRO, INTRO");
                                    hasError = true;
                                }
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<program>", "Expecting {");
                            hasError = true;
                        }
                    }   
                    else if(hasError == false)
                    {
                         addToSyntaxErrorTable("<program>", "Expecting )");
                         hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<program>", "Expecting (");
                }   
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<program>","Concert function Not Found");
                hasError = true;
            }     
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTableForPrelude("<program>","Prelude function not found");
            hasError = true;
        }
    }
    
    void production_global()
    {  
      
        if(checker(RECORDS))
        {
            code = code.concat("\n struct");
            addToSyntaxTable("<global>", "<struct>");
                production_struct();
        }
        else if(checker(CONST))
        {
            code = code.concat("\n const ");
            addToSyntaxTable("<global>", "<const>");
                production_const();
        }
        else if(checker(WORLDTOUR))
        {
            isFromWorldtour = true;
            addToSyntaxTable("<global>","<globaldec>");
            production_varglobaldec();
        }
        else if(checker(INTERLUDE))
        {
            addToSyntaxTable("<global>", "<functiondef>");
            addToSyntaxTable("<functiondef>", "INTERLUDE");    
                production_functiondef();
        }       
        else
            addToSyntaxTable("<global>", "<null>");
    }

    
    void production_const()
    {
        switch(token)
        {
            case INT : 
                checker(INT);
                code = code.concat(" int");
                addToSyntaxTable("<const>","<intconst>");
                addToSyntaxTable("<intconst>", "CONST"); 
                addToSyntaxTable("<intconst>","INT");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<intconst>","Identifier");
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<intconst>","=");
                        addToSyntaxTable("<intconst>","<intval>");
                            production_intval();
                        addToSyntaxTable("<intconst>","<nextint>");
                            production_nextint();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<intconst>", ";");
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<intconst>", "Expecting ;");
                            hasError = true;
                        }    
                    }
                    else if(hasError == false)
                    {
                      addToSyntaxErrorTable("<intconst>", "Expecting =");  
                      hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<intconst>", "Expecting Identifer");  
                    hasError = true;
                }
                break;
            case FLOAT:
                checker(FLOAT);
                code = code.concat(" float");
                addToSyntaxTable("<const>","<floatconst>");
                addToSyntaxTable("<floatconst>", "CONST"); 
                addToSyntaxTable("<floatconst>","FLOAT");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<floatconst>","Identifier");
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<floatconst>","=");
                        addToSyntaxTable("<floatconst>","<floatval>");
                            production_floatval();
                        addToSyntaxTable("<floatconst>","<nextfloat>");
                            production_nextfloat();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<floatconst>", ";");
                        }
                        else if(hasError == false)
                        { 
                            addToSyntaxErrorTable("<floatconst>", "Expecting ;");
                            hasError = true;
                        }    
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<floatconst>","Expecting =");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<floatconst>","Expecting Identifier");
                    hasError = true;
                }
                break;
            
            case CHAR:
                checker(CHAR);
                code = code.concat(" char");
                addToSyntaxTable("<const>","<charconst>");
                addToSyntaxTable("<charconst>", "CONST"); 
                addToSyntaxTable("<charconst>","INT");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<charconst>","Identifier");
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<charconst>","=");
                        addToSyntaxTable("<charconst>","<charval>");
                            production_charval();
                        addToSyntaxTable("<charconst>","<nextchar>");
                            production_nextchar();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<charconst>", ";");
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<charconst>", "Expecting ;");
                            hasError = true;
                        }    
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<charconst>","Expecting =");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<charconst>","Expecting Identifier");
                    hasError = true;
                }
                break;
            
            case STRING:
                checker(STRING);
                code = code.concat(" string");
                addToSyntaxTable("<const>","<stringconst>");
                addToSyntaxTable("<stringconst>", "CONST");
                addToSyntaxTable("<stringconst>","STRING");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<stringconst>","Identifier");
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<stringconst>","=");
                        addToSyntaxTable("<stringconst>","<stringval>");
                            production_stringval();
                        addToSyntaxTable("<stringconst>","<nextstring>");
                            production_nextstring();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<stringconst>", ";");
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<stringconst>", "Expecting ;");
                            hasError = true;
                        }    
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<stringconst>","Expecting =");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<stringconst>","Expecting Identifier");
                    hasError = true;
                }
            break;
            
            case BOOL:
                checker(BOOL);
                code = code.concat(" bool");
                addToSyntaxTable("<const>","<boolconst>");
                addToSyntaxTable("<boolconst>", "CONST"); 
                addToSyntaxTable("<boolconst>","BOOL");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<boolconst>","Identifier");
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<boolconst>","=");
                        addToSyntaxTable("<boolconst>","<boolval>");
                            production_boolval();
                        addToSyntaxTable("<boolconst>","<nextbool>");
                            production_nextbool();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<boolconst>", ";");
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<boolconst>", "Expecting ; at Line ");
                            hasError = true;
                        }    
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<boolconst>","Expecting =");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<boolconst>","Expecting Identifier");
                    hasError = true;
                }
            break;
            default:  addToSyntaxErrorTable("<boolconst>", "Expecting INT, FLOAT, CHAR, STRING, BOOL");
                      hasError = true;
        }
        production_global();
    }
    
    void production_nextint()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextint>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextint>","Identifier");
                if(checker(EQUAL))
                {
                    code = code.concat(" =");
                    addToSyntaxTable("<nextint>","=");
                    addToSyntaxTable("<nextint>","<intval>");
                        production_intval();
                    production_nextint();
                }
                else if(hasError == false)
                {
                     addToSyntaxErrorTable("<nextint>","Expecting =");
                     hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextint>","Expecting Identifer");
                hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<nextint>","null");
        }
    }
        
    void production_intval()
    {
        switch(token)
        {
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                code = code.concat(" "+getItem());
                    addToSyntaxTable("<intval>", "INT_LIT");
                break;
            case IDENTIFIER:
                    addToSyntaxTable("<intval>", "<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                break;
            default: addToSyntaxErrorTable("<intval>","Expecting Integer Literal or Identifier");
                        hasError = true;
        }  
    }
    
    void production_nextfloat()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextfloat>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextfloat>","Identifier");
                if(checker(EQUAL))
                {
                    code = code.concat(" =");
                    addToSyntaxTable("<nextfloat>","=");
                    addToSyntaxTable("<nextfloat>","<floatval>");
                        production_floatval();
                        production_nextfloat();
                }
                else if(hasError == false)
                {
                     addToSyntaxErrorTable("<nextfloat>","Expecting =");
                     hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextfloat>","Expecting Identifer");
                hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<nextfloat>", "null");
        }
    }
    
    void production_floatval()
    {
        switch(token)
        {
            case FLOATLITERAL:
                checker(FLOATLITERAL);
                code = code.concat(" "+getItem());
                    addToSyntaxTable("<floatval>", "FLOAT_LIT");
                break;
            case IDENTIFIER:
                    addToSyntaxTable("<floatval>", "<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                break;
            default: addToSyntaxErrorTable("<floatval>","Expecting Float Literal or Identifier"); hasError = true;
        }  
    }
    
    void production_nextchar()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextchar>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextchar>","Identifier");
                if(checker(EQUAL))
                {
                    code = code.concat(" =");
                    addToSyntaxTable("<nextchar>","=");
                    addToSyntaxTable("<nextchar>","<charval>");
                        production_charval();
                        production_nextchar();
                }
                else if(hasError == false)
                {
                     addToSyntaxErrorTable("<nextchar>","Expecting =");
                     hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextchar>","Expecting Identifer");
                hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<nextchar>", "null");
        }
    }
    
    void production_charval()
    {
        switch(token)
        {
            case CHARLITERAL:
                    checker(CHARLITERAL);
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<charval>", "CHAR_LIT");
                break;
            case IDENTIFIER:
                    addToSyntaxTable("<charval>", "<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                break;
            default: addToSyntaxErrorTable("<charval>","Expecting Char Literal or Identifier"); hasError = true;
        }  
    }
    
    void production_nextstring()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextstring>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextstring>","Identifier");
                if(checker(EQUAL))
                {
                    code = code.concat(" =");
                    addToSyntaxTable("<nextstring>","=");
                    addToSyntaxTable("<nextstring>","<stringval>");
                        production_stringval();
                        production_nextstring();
                }
                else if(hasError == false)
                {
                     addToSyntaxErrorTable("<nextstring>","Expecting =");
                     hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextstring>","Expecting Identifer");
                hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<nextstring>", "null");
        }
    }
    
    void production_stringval()
    {
        switch(token)
        {
            case STRINGLITERAL:
                checker(STRINGLITERAL);
                code = code.concat(" "+getItem());
                    addToSyntaxTable("<stringval>", "STRING_LIT");
                break;
            case IDENTIFIER:
                    addToSyntaxTable("<stringval>", "<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                break;
            default: addToSyntaxErrorTable("<charval>","Expecting String Literal or Identifier"); hasError = true;
        }  
    }
    
    void production_nextbool()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextbool>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextbool>","Identifier");
                if(checker(EQUAL))
                {
                    code = code.concat(" =");
                    addToSyntaxTable("<nextbool>","=");
                    addToSyntaxTable("<nextbool>","<boolval>");
                        production_boolval();
                        production_nextbool();
                }
                else if(hasError == false)
                {
                     addToSyntaxErrorTable("<<nextbool>>","Expecting =");
                     hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextbool>","Expecting Identifer");
                hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<nextbool>", "null");
        } 
    }
    
    void production_boolval()
    {
        switch(token)
        {
            case BOOLLITERAL:
                checker(BOOLLITERAL);
                code = code.concat(" "+getItem());
                    addToSyntaxTable("<boolval>", "BOOL_LIT");
                break;
            case IDENTIFIER:
                    addToSyntaxTable("<boolval>", "<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                break;
            default: addToSyntaxErrorTable("<boolval>","Expecting Bool Literal or Identifier"); hasError = true;
        }  
    }

    void production_functiondef()
    {
        if(checker(MUTE))
        {
            code = code.concat("\n void");
            addToSyntaxTable("<functiondef>", "MUTE");
             if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<functiondef>","Identifier");
                if(checker(OPENPARENTHESIS))
                {
                    code = code.concat(" (");
                    addToSyntaxTable("<functiondef>","(");
                    addToSyntaxTable("<functiondef>","<funcparam>");
                        production_funcparam();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        code = code.concat(" )");
                        addToSyntaxTable("<functiondef>",")");
                        if(checker(OPENCURLYBRACE))
                        {
                            code = code.concat(" {");
                            if(checker1(INT)||checker1(FLOAT)||checker1(CHAR)||checker1(STRING)||checker1(BOOL) && hasError == false) //check if pupunta kay production vardec1 // localdec
                            {
                                addToSyntaxTable("<program>","<localdec>");
                                    production_vardec1();
                                addToSyntaxTable("<program>","<statements>");
                                    production_statements();
                                if(checker(PRODUCE))
                                {
                                    addToSyntaxErrorTable("<functiondef>","Unexpected Produce");
                                    hasError = true;
                                }
                                if(checker(CLOSECURLYBRACE))
                                {
                                    code = code.concat("\n }");
                                    addToSyntaxTable("<functiondef>","}");
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<functiondef>","Expecting }");
                                    hasError = true;
                                }
                            }
                            else
                            {
                                addToSyntaxTable("<functiondef>","{");
                                addToSyntaxTable("<functiondef>","<statements>");
                                    production_statements();
                                if(checker(PRODUCE))
                                {
                                    addToSyntaxErrorTable("<functiondef>","Unexpected Produce");
                                    hasError = true;
                                }
                                if(checker(CLOSECURLYBRACE))
                                {
                                    code = code.concat("\n }");
                                    addToSyntaxTable("<functiondef>","}");
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<functiondef>","Expecting }");
                                    hasError = true;
                                }
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<functiondef>","Expecting {");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<functiondef>","Expecting )");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<functiondef>","(");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<functiondef>","Expecting Identifier");
                hasError = true;
            }
        }
        else
        {
            switch(token)
            {
                case INT: 
                    checker(INT);
                    code = code.concat("\n int");
                    addToSyntaxTable("<functiondef>","<datatype>");
                    addToSyntaxTable("<datatype>","INT");
                    break;
                    
                case FLOAT:
                    checker(FLOAT);
                    code = code.concat("\n float");
                    addToSyntaxTable("<functiondef>","<datatype>");
                    addToSyntaxTable("<datatype>","FLOAT");
                    break;
                
                case CHAR: 
                    checker(CHAR);
                    code = code.concat("\n char");
                    addToSyntaxTable("<functiondef>","<datatype>");
                    addToSyntaxTable("<datatype>","CHAR");
                    break;

                case STRING:
                    checker(STRING);
                    code = code.concat("\n string");
                    addToSyntaxTable("<functiondef>","<datatype>");
                    addToSyntaxTable("<datatype>","STRING");
                    break;

                case BOOL:
                    checker(BOOL);
                    code = code.concat("\n bool");
                    addToSyntaxTable("<functiondef>","<datatype>");
                    addToSyntaxTable("<datatype>","BOOL");
                    break;

                default:
                    addToSyntaxErrorTable("<functiondef>","Expecting MUTE, INT, FLOAT, CHAR, STRING or BOOL datatype"); hasError = true;
            }
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<functiondef>","Identifier");
                if(checker(OPENPARENTHESIS))
                {
                    code = code.concat(" (");
                    addToSyntaxTable("<functiondef>","(");
                    addToSyntaxTable("<functiondef>","<funcparam>");
                        production_funcparam();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        code = code.concat(")");
                        addToSyntaxTable("<functiondef>",")");
                        if(checker(OPENCURLYBRACE))
                        {
                            code = code.concat(" {");
                            if(checker1(INT)||checker1(FLOAT)||checker1(CHAR)||checker1(STRING)||checker1(BOOL) && hasError == false) //check if pupunta kay production vardec1 // localdec
                            {
                                addToSyntaxTable("<functiondef>","{");
                                addToSyntaxTable("<functiondef>","<localdec>");
                                    production_vardec1();
                                addToSyntaxTable("<functiondef>","<statements>");
                                    production_statements();
                                if(checker(PRODUCE))
                                {
                                    code = code.concat("\n return");
                                    addToSyntaxTable("<functiondef>","PRODUCE");
                                    if(checker1(OPENPARENTHESIS) || checker1(INTEGERLITERAL) || checker1(FLOATLITERAL) || checker1(CHARLITERAL) 
                                    || checker1(BOOLLITERAL) || checker1(STRINGLITERAL) || checker1(IDENTIFIER) )
                                    {
                                       addToSyntaxTable("<functiondef>","<returnval>");
                                       if(checker1(INTEGERLITERAL) || checker1(FLOATLITERAL) || checker1(CHARLITERAL) 
                                       || checker1(BOOLLITERAL) || checker1(STRINGLITERAL))
                                       {
                                            addToSyntaxTable("<returnval>","<literal>");
                                                production_literal();
                                            if(checker(SEMICOLON))
                                            {
                                                code = code.concat(";");
                                                if(checker(CLOSECURLYBRACE))
                                                {
                                                    code = code.concat("\n }");
                                                    addToSyntaxTable("<functiondef>","}");
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                    hasError = true;
                                                }
                                            }
                                            else if(hasError == false)
                                            {
                                                addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                hasError = true;
                                            }
                                       }
                                       else if(checker1(OPENPARENTHESIS))
                                       {
                                            addToSyntaxTable("<returnval>","<mathexpr>");
                                                production_mathexpr();
                                            if(checker(SEMICOLON))
                                            {
                                                code = code.concat(";");
                                                addToSyntaxTable("<returnval>",";");
                                                if(checker(CLOSECURLYBRACE))
                                                {
                                                    code = code.concat("\n }");
                                                    addToSyntaxTable("<functiondef>","}");
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                    hasError = true;
                                                }
                                            }
                                            else if(hasError == false)
                                            {
                                                addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                hasError = true;
                                            }
                                        }
                                        else if(checker1(IDENTIFIER))
                                        {
                                            addToSyntaxTable("<returnval>","<identifier>");
                                            checker(IDENTIFIER);
                                            code = code.concat(" "+getItem());
                                            if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                                            {
                                                addToSyntaxTable("<size>","<mathexpr>");
                                                addToSyntaxTable("<mathexpr>","INT_LIT");
                                                    production_nextmathexpr();
                                                if(checker(SEMICOLON))
                                                {
                                                    code = code.concat(";");
                                                    addToSyntaxTable("<returnval>",";");
                                                    if(checker(CLOSECURLYBRACE))
                                                        addToSyntaxTable("<functiondef>","}");
                                                    else if(hasError == false)
                                                    {
                                                        addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                        hasError = true;
                                                    }
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                    hasError = true;
                                                }
                                            }
                                            else
                                            {
                                                production_identifier();
                                                if(checker(SEMICOLON))
                                                {
                                                    code = code.concat(";");
                                                    addToSyntaxTable("<returnval>",";");
                                                    if(checker(CLOSECURLYBRACE))
                                                    {
                                                        code = code.concat("\n }");
                                                        addToSyntaxTable("<functiondef>","}");
                                                    }
                                                    else if(hasError == false)
                                                    {
                                                        addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                        hasError = true;
                                                    }
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                    hasError = true;
                                                }
                                            }
                                        }
                                        else if(hasError == false)
                                        {
                                            addToSyntaxErrorTable("<functiondef>","Invalid Return Value, Expecting Literals, Identifier of Math Expression");
                                            hasError = true;
                                        }
                                    }
                                    else if(hasError == false)
                                    {
                                        addToSyntaxErrorTable("<functiondef>","Expecting return value");
                                        hasError = true;
                                    }
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<functiondef>","Expecting PRODUCE");  
                                    hasError = true;
                                }
                            }
                            else
                            {
                                addToSyntaxTable("<functiondef>","{");
                                addToSyntaxTable("<functiondef>","<statements>");
                                    production_statements();

                                if(checker(PRODUCE))
                                {
                                    code = code.concat("\n return");
                                    addToSyntaxTable("<functiondef>","PRODUCE");
                                    if(checker1(OPENPARENTHESIS) || checker1(INTEGERLITERAL) || checker1(FLOATLITERAL) || checker1(CHARLITERAL) 
                                    || checker1(BOOLLITERAL) || checker1(STRINGLITERAL) || checker1(IDENTIFIER) )
                                    {
                                       addToSyntaxTable("<functiondef>","<returnval>");
                                       if(checker1(INTEGERLITERAL) || checker1(FLOATLITERAL) || checker1(CHARLITERAL) 
                                       || checker1(BOOLLITERAL) || checker1(STRINGLITERAL))
                                       {
                                            addToSyntaxTable("<returnval>","<literal>");
                                                production_literal();
                                            if(checker(SEMICOLON))
                                            {
                                                code = code.concat(";");
                                                if(checker(CLOSECURLYBRACE))
                                                {
                                                    code = code.concat("\n }");
                                                    addToSyntaxTable("<functiondef>","}");
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                    hasError = true;
                                                }
                                            }
                                            else if(hasError == false)
                                            {
                                                addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                hasError = true;
                                            }
                                       }
                                       else if(checker1(OPENPARENTHESIS))
                                       {
                                            addToSyntaxTable("<returnval>","<mathexpr>");
                                                production_mathexpr();
                                            if(checker(SEMICOLON))
                                            {
                                                code = code.concat(";");
                                                addToSyntaxTable("<returnval>",";");
                                                if(checker(CLOSECURLYBRACE))
                                                {
                                                    code = code.concat("\n }");
                                                    addToSyntaxTable("<functiondef>","}");
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                    hasError = true;
                                                }
                                            }
                                            else if(hasError == false)
                                            {
                                                addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                hasError = true;
                                            }
                                        }
                                       else if(checker1(IDENTIFIER))
                                       {
                                            addToSyntaxTable("<returnval>","<identifier>");
                                            checker(IDENTIFIER);
                                            code = code.concat(" "+getItem());
                                            if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                                            {
                                                addToSyntaxTable("<size>","<mathexpr>");
                                                addToSyntaxTable("<mathexpr>","INT_LIT");
                                                    production_nextmathexpr();
                                                if(checker(SEMICOLON))
                                                {
                                                    code = code.concat(";");
                                                    addToSyntaxTable("<returnval>",";");
                                                    if(checker(CLOSECURLYBRACE))
                                                        addToSyntaxTable("<functiondef>","}");
                                                    else if(hasError == false)
                                                    {
                                                        addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                        hasError = true;
                                                    }
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                    hasError = true;
                                                }
                                            }
                                            else
                                            {
                                                production_identifier();
                                                if(checker(SEMICOLON))
                                                {
                                                    code = code.concat(";");
                                                    addToSyntaxTable("<returnval>",";");
                                                    if(checker(CLOSECURLYBRACE))
                                                    {
                                                        code = code.concat("\n }");
                                                        addToSyntaxTable("<functiondef>","}");
                                                    }
                                                    else if(hasError == false)
                                                    {
                                                        addToSyntaxErrorTable("<functiondef>", "Expecting }");
                                                        hasError = true;
                                                    }
                                                }
                                                else if(hasError == false)
                                                {
                                                    addToSyntaxErrorTable("<functiondef>","Expecting ;");
                                                    hasError = true;
                                                }
                                            }
                                       }
                                       else if(hasError == false)
                                       {
                                           addToSyntaxErrorTable("<functiondef>","Invalid Return Value, Expecting Literals, Identifier of Math Expression");
                                           hasError = true;
                                       }
                                    }
                                    else if(hasError == false)
                                    {
                                        addToSyntaxErrorTable("<functiondef>","Expecting return value");
                                        hasError = true;
                                    }
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<functiondef>","Expecting PRODUCE");  
                                    hasError = true;
                                }    
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<functiondef>","Expecting {");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<functiondef>","Expecting )");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<functiondef>","(");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<functiondef>","Expecting Identifier");
                hasError = true;
            }
        }
        production_global(); 
    }
    
    void production_statements()
    {
        if(checker(IDENTIFIER) && hasError == false) //assignment stmnts
        {
            code = code.concat(" "+getItem());
            if(checker1(OPENPARENTHESIS)) //funccall statement
            {
                addToSyntaxTable("<statements>","<funccall>");
                    production_funccall();
                if(checker(SEMICOLON))
                {
                    code = code.concat(";");
                    addToSyntaxTable("<statements>",";");
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<statements>","Expecting ;");
                    hasError = true;
                }
            }
            else if(checker1(OPENBRACKET)) //arr index
            {
                addToSyntaxTable("<identifier>","<arrid>");
                addToSyntaxTable("<arrid>","id");
                    production_arrid();
                    production_assignment();
            }
            else if(checker1(TILDE)) //struct id
            {
                checker(TILDE);
                code = code.concat(".");
                addToSyntaxTable("<identifier>","<structid>");
                addToSyntaxTable("<structid>","identifier");
                addToSyntaxTable("<structid>","~");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(""+getItem());
                    addToSyntaxTable("<structid>","identifier");
                    production_assignment();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<structid>","Expecting Identifier");
                    hasError = true; 
                }
            }
            else if(checker1(INCREMENT) || checker1(DECREMENT))
            {
                addToSyntaxTable("<statements>","<incdec>");
                    production_incdec();
            }
            else
                production_assignment();
        }
        else if(checker1(IF)||checker1(CHORDS) && hasError == false) //conditional stmnts
        {
            addToSyntaxTable("<statements>","<condstatements>");
                production_condstatements();
        }
        else if(checker1(LOOP)||checker1(REPEAT)||checker1(DO) && hasError == false) //looping stmnts
        {
            addToSyntaxTable("<statements>","<loopstatements>");
                production_loopstatements();
        }
        else if(checker1(OUTRO)||checker1(INTRO) && hasError == false) //i/o statements
        {
            addToSyntaxTable("<statements>","<I/Ostatements>");
                production_iostatements();
        }
        else if(checker1(INCREMENT) || checker1(DECREMENT) && hasError == false) //incdec
        {
            addToSyntaxTable("<statements>","<incdec>");
                production_incdec();
        }
        else
        {
            //System.out.println("HEYasdASD: "+token);
            addToSyntaxTable("<statements>","null");
                //return;
        }
    }
    
    void production_funccall()
    {
        checker(OPENPARENTHESIS);
        code = code.concat("(");
        addToSyntaxTable("<statements>","<funccall>");
        addToSyntaxTable("<funccall>","id");
        addToSyntaxTable("<funccall>","(");
        addToSyntaxTable("<funccall>","<funcargs>");
            production_funcargs();
        if(checker(CLOSEPARENTHESIS))
        {
            code = code.concat(")");
            addToSyntaxTable("<funccall>",")");

        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<funcall>","Expecting )");
            hasError = true;
        }
    }
    
    void production_iostatements()
    {
        switch(token)
        {
            case OUTRO:
                checker(OUTRO);
                code = code.concat("\n cout<<");
                addToSyntaxTable("<I/Ostatements>","<outro>");
                addToSyntaxTable("<outro>","OUTRO");
                addToSyntaxTable("<outro>","<output>");
                    production_output();
                addToSyntaxTable("<outro>","<nextoutput>");
                    production_nextoutput();
                if(checker(SEMICOLON))
                {
                    code = code.concat(";");
                    addToSyntaxTable("<outro>",";");
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<outro>","Expecting Semicolon , Period");
                    hasError = true;
                }
            break;
            
            case INTRO:
                checker(INTRO);
                code = code.concat(" cin>>");
                addToSyntaxTable("<I/Ostatements>","<intro>");
                addToSyntaxTable("<intro>","INTRO");
                addToSyntaxTable("<intro>","<identifier>");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                        production_identifier();
                    addToSyntaxTable("<inttro>","<nextinput>");
                        production_nextinput();
                    if(checker(SEMICOLON))
                    {
                        code = code.concat(";");
                        code = code.concat("if(!cin)cout<<\"Mismatched Data Type from Input!\"<<endl<<endl;");
                        addToSyntaxTable("<intro>",";");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<intro>","Expecting Semicolon , Comma");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<intro>","Expecting Identifier");
                    hasError = true;
                }
        }
        production_statements();
    }
    
    void production_nextinput()
    {
        switch(token)
        {
            case COMMA:
                checker(COMMA);
                code = code.concat(" >>");
                addToSyntaxTable("<nextinput>",",");
                addToSyntaxTable("<nextinput>","<identifier>");
                    checker(IDENTIFIER);
                    code = code.concat(" "+getItem());
                    production_identifier();
                addToSyntaxTable("<nextinput>","<nextinput>");
                    production_nextinput();
                break;  
            
            default: addToSyntaxTable("<nextinput>","null");
        }
    }
    
    void production_nextoutput()
    {
        switch(token)
        {
            case PERIOD:
                checker(PERIOD);
                code = code.concat(" <<");
                addToSyntaxTable("<nextoutput>","<output>");
                    production_output();
                    production_nextoutput();
                break;
            
            default: addToSyntaxTable("<nextoutput>","null");
        }
    }
    
    void production_output()
    {
        switch(token)
        {
            case STRINGLITERAL:
                checker(STRINGLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<output>","<STRING LIT>");
                break;
                
            case IDENTIFIER:
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                {
                    addToSyntaxTable("<output>","<mathexpr>");
                    addToSyntaxTable("<mathexpr>","identifier");
                    production_nextmathexpr();
                }
                else
                {
                    addToSyntaxTable("<output>","<identifier>");
                    production_identifier();
                }
                
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL: 
                addToSyntaxTable("<output>","<mathexpr>");
                    production_mathexpr();
            break;
                
            
            case OPENPARENTHESIS:
                addToSyntaxTable("<output>","<mathexpr>");
                    production_mathexpr();
                break;
                
            default: addToSyntaxErrorTable("<output>","Expecting String Literal, Identifier, Math Expression");
                    hasError = true;
        }
    }
    boolean isFromForLoop = false;
    void production_loopstatements()
    {
        switch(token)
        {
            case LOOP:
            isFromForLoop = true;
            checker(LOOP);
            code = code.concat("\n for");
            addToSyntaxTable("<loopstatements>","<loop>");
            addToSyntaxTable("<loop>","LOOP");
            if(checker(OPENPARENTHESIS))
            {
                code = code.concat("(");
                addToSyntaxTable("<loop>","(");
                addToSyntaxTable("<loop>","<identifier>");
                if(checker(IDENTIFIER))
                {
                code = code.concat(" "+getItem());
                    production_identifier();
                    if(checker(EQUAL))
                    {
                        code = code.concat(" =");
                        addToSyntaxTable("<loop>","=");
                        addToSyntaxTable("<loop>","<loopinit>");
                            production_loopinit();
                        if(checker(SEMICOLON))
                        {
                            code = code.concat(";");
                            addToSyntaxTable("<loop>",";");
                            addToSyntaxTable("<loop>","<condexpr>");
                                production_condexpr();
                                production_nextcondexpr();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<loop>",";");
                                addToSyntaxTable("<loop>","<incdec>");
                                    production_incdec();
                                if(checker(CLOSEPARENTHESIS))
                                {
                                    code = code.concat(")");
                                    addToSyntaxTable("<loop>",")");
                                    if(checker(OPENCURLYBRACE))
                                    {
                                        code = code.concat(" {");
                                        addToSyntaxTable("<loop>","{");
                                        addToSyntaxTable("<loop>","<statements>");
                                            production_statements();
                                        addToSyntaxTable("<loop>","<stop/play>");
                                            production_stopplay();
                                        if(checker(CLOSECURLYBRACE))
                                        {
                                            code = code.concat("\n }");
                                            addToSyntaxTable("<loop>","}");

                                        }
                                        else if(hasError == false)
                                        {
                                            addToSyntaxErrorTable("<loop>","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                                            hasError = true;
                                        }
                                    }
                                    else if(hasError == false)
                                    {
                                        addToSyntaxErrorTable("<loop>","Expecting {");
                                        hasError = true;
                                    }
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<loop>","Expecting )");
                                    hasError = true;
                                }
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<loop>","Expecting ;");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<loop>","Expecting ;");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<loop>","Expecting =");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<loop>","Expecting identifier");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<loop>","Expecting (");
                hasError = true;
            }
            break;
            
            case REPEAT:
            checker(REPEAT);
            code = code.concat("\n while");
            addToSyntaxTable("<loopstatements>","<repeat>");
            addToSyntaxTable("<repeat>","REPEAT");
            if(checker(OPENPARENTHESIS))
            {
                code = code.concat(" (");
                addToSyntaxTable("<repeat>","(");
                addToSyntaxTable("<repeat>","<condexpr>");
                    production_condexpr();
                    production_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    code = code.concat(")");
                    addToSyntaxTable("<repeat>",")");
                    if(checker(OPENCURLYBRACE))
                    {
                        code = code.concat(" {");
                        addToSyntaxTable("<repeat>","{");
                        addToSyntaxTable("<repeat>","<statements>");
                            production_statements();
                        addToSyntaxTable("<repeat>","<stop/play>");
                            production_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat("\n }");
                            addToSyntaxTable("<repeat>","}");
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<repeat>","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<repeat>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<repeat>","Expecting )");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<repeat>","Expecting (");
                hasError = true;
            }
            
            break;
            
            case DO:
            checker(DO);
            code = code.concat("\n do");
            addToSyntaxTable("<loopstatements>","<dorepeat>");
            addToSyntaxTable("<dorepeat>","DO");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat("{");
                addToSyntaxTable("<dorepeat>","{");
                addToSyntaxTable("<dorepeat>","<statements>");
                    production_statements();
                addToSyntaxTable("<dorepeat>","<stop/play>");
                    production_stopplay();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat("\n }");
                    addToSyntaxTable("<dorepeat>","}");
                    if(checker(REPEAT))
                    {
                        code = code.concat(" while");
                        addToSyntaxTable("<dorepeat>","REPEAT");
                        if(checker(OPENPARENTHESIS))
                        {
                            code = code.concat(" (");
                            addToSyntaxTable("<dorepeat>","(");
                            addToSyntaxTable("<dorepeat>","<condexpr>");
                                production_condexpr();
                                production_nextcondexpr();
                            if(checker(CLOSEPARENTHESIS))
                            {
                                code = code.concat(" )");
                                addToSyntaxTable("<dorepeat>",")");
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<dorepeat>",";");
                                }
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<dorepeat>","Expecting ;");
                                    hasError = true;
                                }
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<dorepeat>","Expecting )");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<dorepeat>","Expecting (");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<dorepeat>","Expecting REPEAT");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<dorepeat>","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<dorepeat>","Expecting {");
                hasError = true;
            }
            
            break;
            
            default: 
                addToSyntaxTable("<loopstatements>","null");
        }
         production_statements();
    }
    
    void production_incdec()
    {
        switch(token)
        {
            case INCREMENT: case DECREMENT:
                if(checker(INCREMENT))
                {
                    code = code.concat(" ++");
                    addToSyntaxTable("<incdec>","<preinc>");
                    addToSyntaxTable("<preinc>","++");
                        production_preinc();
                    if(checker(SEMICOLON))
                    {
                        if(isFromForLoop == false)
                            code = code.concat(";");
                        addToSyntaxTable("<incdec>",";");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<incdec>","Expecting ;");
                        hasError = true;
                    }
                }
                else if(checker(DECREMENT))
                {
                    code = code.concat(" --");
                    addToSyntaxTable("<incdec>","<predec>");
                    addToSyntaxTable("<predec>","--");
                        production_predec();
                    if(checker(SEMICOLON))
                    {
                        if(isFromForLoop == false)
                            code = code.concat(";");
                        addToSyntaxTable("<incdec>",";");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<incdec>","Expecting ;");
                        hasError = true;
                    }
                }
                break;
            
            case IDENTIFIER:
                checker(IDENTIFIER);
                code = code.concat("\n "+getItem());
                production_identifier();
                if(checker(INCREMENT))
                {
                    code = code.concat(" ++");
                    addToSyntaxTable("<incdec>","<postinc>");
                    addToSyntaxTable("<postinc>","++");
                    if(checker(SEMICOLON))
                    {
                        if(isFromForLoop == false)
                            code = code.concat(";");
                        addToSyntaxTable("<incdec>",";");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<incdec>","Expecting ;");
                        hasError = true;
                    }
                }
                else if(checker(DECREMENT))
                {
                    code = code.concat(" --");
                    addToSyntaxTable("<incdec>","<postdec>");
                    addToSyntaxTable("<postidec>","--");
                    if(checker(SEMICOLON))
                    {
                        if(isFromForLoop == false)
                            code = code.concat(";");
                        addToSyntaxTable("<incdec>",";");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<incdec>","Expecting ;");
                        hasError = true;
                    }
                }
                break;   
        }
        production_statements();
    }
    
    void production_preinc()
    {
        addToSyntaxTable("<preinc>","<identifier>");
        if(checker(IDENTIFIER))
        {
            code = code.concat(" "+getItem());
            production_identifier();
        }
        else if(hasError == false)
        {
             addToSyntaxErrorTable("<preinc>","Expecting identifier");
            hasError = true;
        }
    }
    
    void production_predec()
    {
        addToSyntaxTable("<predec>","<identifier>");
        if(checker(IDENTIFIER))
        {
            code = code.concat(" "+getItem());
            production_identifier();
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<predec>","Expecting identifier");
            hasError = true;
        }
    }
    
    void production_loopinit()
    {
        switch(token)
        {
            case IDENTIFIER:
                addToSyntaxTable("<loopinit>","<identifier>");
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                production_identifier(); break;
            
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<loopinit>","INT LIT"); break;
                
            default: addToSyntaxErrorTable("<loopinit>","Expecting Identifier or Integer Literal"); hasError = true;
        }
    }
    //public boolean hasError = false;
    void production_condstatements()
    {
        switch(token)
        {
            case IF:
            checker(IF); //determines that it is an IF statement
            code = code.concat("\n if");
            addToSyntaxTable("<condstatements>","<ifstatement>");
            addToSyntaxTable("<ifstatement>","IF");
            if(checker(OPENPARENTHESIS))
            {
                code = code.concat(" (");
                addToSyntaxTable("<ifstatement>","(");
                addToSyntaxTable("<ifstatement>","<condexpr>");
                    production_condexpr();
                //addToSyntaxTable("<condexpr>","<condexpr>");
                    production_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    code = code.concat(")");
                    addToSyntaxTable("<ifstatement>",")");
                    if(checker(OPENCURLYBRACE))
                    {
                        code = code.concat(" {");
                        addToSyntaxTable("<ifstatement>","{");
                        addToSyntaxTable("<ifstatement>","<statements>");
                            production_statements();
                        addToSyntaxTable("<ifstatement>","<stop/play>");
                            production_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat("\n }");
                            addToSyntaxTable("<ifstatement>","}");
                            addToSyntaxTable("<ifstatement>","<elseifstatement>");
                                production_elseifstatement();
                            addToSyntaxTable("<elseifstatement>","<elsestatement>");
                                production_elsestatement();
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<ifstatement>","Expecting }, PRODUCE, PLAY,STOP, NOTE");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<ifstatement>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<ifstatement>","Expecting )");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<ifstatement>","Expecting (");
                hasError = true;
            }
            break;
            
            case CHORDS:
            checker(CHORDS);
            code = code.concat("\n switch");
            addToSyntaxTable("<condstatements>","<switchstatement>");
            addToSyntaxTable("<switchstatement>","CHORDS");
            if(checker(OPENPARENTHESIS))
            {
                code = code.concat("(");
                addToSyntaxTable("<switchstatement>","(");
                addToSyntaxTable("<switchstatement>","<identifier>");
                if(checker(IDENTIFIER))
                {    
                    code = code.concat(" "+getItem());
                    production_identifier();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        code = code.concat(" )");
                        addToSyntaxTable("<switchstatement>",")");
                        if(checker(OPENCURLYBRACE))
                        {
                            code = code.concat(" {");
                            addToSyntaxTable("<switchstatement>","{");
                            addToSyntaxTable("<switchstatement>","<case>");
                                production_case();
                            addToSyntaxTable("<switchstatement>","<default>");
                                production_default();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat("\n }");
                                addToSyntaxTable("<switchstatement>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<switchstatement>","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<switchstatement>","Expecting {");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<switchstatement>","Expecting )");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<switchstatement>","Expecting Identifier");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<switchstatement>","Expecting (");
                hasError = true;
            }
        }
        production_statements();
    }
    
    void production_default()
    {
        if(checker(CADENCE))
        {
            code = code.concat("\n default");
            addToSyntaxTable("<default>","CADENCE");
            if(checker(COLON))
            {
                code = code.concat(":");
                addToSyntaxTable("<default>",":");
                addToSyntaxTable("<default>","<statements>");
                    production_statements();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<default>","Expecting :");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<default>","null");
    }
    
    void production_case()
    {
        if(checker(NOTE))
        {
            code = code.concat("\n case");
            addToSyntaxTable("<case>","NOTE");
            addToSyntaxTable("<case>","<switchconst>");
                production_switchconst();
            if(checker(COLON))
            {
                code = code.concat(" :");
                addToSyntaxTable("<case>","<statements>");
                    production_statements();
                addToSyntaxTable("<case>","<stop/play>");
                    production_stopplay();
                addToSyntaxTable("<case>","<nextcase>");
                    production_nextcase();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<case>","Expecting :");
                hasError = true;
            }
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<case>","Expecting NOTE");
            hasError = true;
        }
    }
    
    void production_nextcase()
    {
        if(checker1(NOTE))
        {
            addToSyntaxTable("<nextcase>","<case>");
                production_case();
        }
        else
            addToSyntaxTable("<nextcase>","null");
    }
    
    void production_stopplay()
    {
        switch(token)
        {
            case STOP:
                addToSyntaxTable("<stop/play>","<stop>");
                checker(STOP);
                code = code.concat("\n break");
                addToSyntaxTable("<stop>","STOP");
                if(checker(SEMICOLON))
                {
                    code = code.concat(" ;");
                    addToSyntaxTable("<stop>",";");
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<stop>","Expecting ;");
                    hasError = true;
                }
                break;
                
            case PLAY:
                addToSyntaxTable("<stop/play>","<play>");
                checker(PLAY);
                code = code.concat("\n continue");
                addToSyntaxTable("<play>","PLAY");
                if(checker(SEMICOLON))
                {
                    code = code.concat(";");
                    addToSyntaxTable("<play>",";");
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<play>","Expecting ;");
                    hasError = true;
                }
                break;
                
            default:
                addToSyntaxTable("<stop/play>","null");
        }
    }
    
    void production_switchconst()
    {
        switch(token)
        {
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<switchconst>","INT LIT");
                break;
                
            case CHARLITERAL:
                checker(CHARLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<switchconst>","CHAR LIT");
                break;
                
            default:
                addToSyntaxErrorTable("<switchconst>","Expecting Integer or Char Literal"); hasError = true;
        }
    }
    
    void production_elseifstatement()
    {
        if(checker(ELSEIF))
        {
            code = code.concat("\n else if");
            addToSyntaxTable("<elseifstatement>","ELSEIF");
            if(checker(OPENPARENTHESIS))
            {
                code = code.concat(" (");
                addToSyntaxTable("<elseifstatement>","(");
                addToSyntaxTable("<elseifstatement>","<condexpr>");
                    production_condexpr();
                    production_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    code = code.concat(" )");
                    addToSyntaxTable("<elseifstatement>",")");
                    if(checker(OPENCURLYBRACE))
                    {
                         code = code.concat(" {");
                        addToSyntaxTable("<elseifstatement>","{");
                        addToSyntaxTable("<elseifstatement>","<statements>");
                            production_statements();
                        addToSyntaxTable("<elseifstatement>","<stop/play>");
                            production_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat("\n }");
                            addToSyntaxTable("<elseifstatement>","}");
                            addToSyntaxTable("<elseifstatement>","<elseifstatement>");
                                production_elseifstatement();
                            addToSyntaxTable("<elseifstatement>","<elsestatement>");
                                production_elsestatement();
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<elseifstatement>","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<elseifstatement>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<elseifstatement>","Expecting )");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<elseifstatement>","Expecting (");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<elseifstatement>","null");
    }
    
    void production_elsestatement()
    {
        if(checker(ELSE))
        {
            code = code.concat("\n else");
            addToSyntaxTable("<elsestatement>","ELSE");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                addToSyntaxTable("<elsestatement>","{");
                addToSyntaxTable("<elsestatement>","<statements>");
                    production_statements();
                addToSyntaxTable("<elsestatement>","<stop/play>");
                        production_stopplay();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat("\n }");
                    addToSyntaxTable("<elsestatement>","}");
                        production_statements();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<elsestatement","Expecting }, PRODUCE, PLAY, STOP, NOTE");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<elsestatement>","Expecting }");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<elsestatement>","null");
    }
    
    void production_condexpr()
    {
        switch(token)
        {
            case OPENPARENTHESIS:
                checker(OPENPARENTHESIS);
                code = code.concat(" (");
                addToSyntaxTable("<condexpr>","(");
                    production_condexpr();
                //addToSyntaxTable("<condexpr>","<condexpr>");
                    production_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    code = code.concat(" )");
                    addToSyntaxTable("<condexpr>",")");
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<condexpr>","Expecting )");
                    hasError = true;
                }
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:  
                addToSyntaxTable("<condexpr>","<literal>");
                    production_literal();
                //addToSyntaxTable("<condexpr>","<condexpr>");
                    production_nextcondexpr();
                break;

            case IDENTIFIER:
                addToSyntaxTable("<condexpr>","<identifier>");
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                    production_identifier();
                //addToSyntaxTable("<condexpr>","<condexpr>");
                    production_nextcondexpr();
                break;           
            default: addToSyntaxTable("<condexpr>","null");    
        }
        
    }
    
    void production_nextcondexpr()
    {
        if((postToken == PLUS || postToken == MINUS || postToken == MULTIPLY || postToken == DIVIDE || postToken == MODULUS
            || postToken == NOT || postToken == AND || postToken == OR || postToken == GREATERTHAN || postToken == LESSTHAN
            || postToken == GREATERTHANEQUAL || postToken == LESSTHANEQUAL || postToken == NOTEQUAL || postToken == EQUALEQUAL) && (hasError == false)
            && (token == PLUS || token == MINUS || token == MULTIPLY || token == DIVIDE || token == MODULUS
            ||token == NOT || token == AND || token == OR || token == GREATERTHAN || token == LESSTHAN
            || token == GREATERTHANEQUAL || token == LESSTHANEQUAL || token == NOTEQUAL || token == EQUALEQUAL))
        {
            addToSyntaxErrorTable("<condexpr>","Invalid. Two Consecutive Operators Found.");
            hasError = true;
        }
        else
        {
            switch(token)
            {          
                case GREATERTHAN: case LESSTHAN: case GREATERTHANEQUAL: case LESSTHANEQUAL: case NOTEQUAL: case EQUALEQUAL:
                    addToSyntaxTable("<condexpr>","<relop>");
                        production_relop();
                    addToSyntaxTable("<condexpr>","<condexpr>");
                        production_condexpr();
                        production_nextcondexpr();
                    break;

                case NOT: case AND: case OR:
                    addToSyntaxTable("<condexpr>","<logicop>");
                        production_logicop();
                    addToSyntaxTable("<condexpr>","<condexpr>");
                        production_condexpr();
                    //addToSyntaxTable("<condexpr>","<condexpr>");
                        production_nextcondexpr();
                    break;

                case PLUS: case MINUS: case MULTIPLY: case DIVIDE: case MODULUS:
                    addToSyntaxTable("<condexpr>","<mathexpr>");
                        production_mathexprOperator();
                    addToSyntaxTable("<condexpr>","<condexpr>");
                        production_condexpr(); 
                    production_nextcondexpr();
                    break;
            }
        }
    }
    
    void production_mathexpr()
    {
        switch(token)
        {
            case OPENPARENTHESIS:
                checker(OPENPARENTHESIS);
                code = code.concat(" (");
                addToSyntaxTable("<mathexpr>","(");
                    production_mathexpr();
                    production_nextmathexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    code = code.concat(" )");
                    addToSyntaxTable("<mathexpr>",")");
                    if(checker1(PLUS)||checker1(MINUS)||checker1(MULTIPLY)||checker1(DIVIDE)||checker1(MODULUS))
                        production_nextmathexpr();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<mathexpr>","Expecting )");
                    hasError = true;
                }
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL:
                addToSyntaxTable("<mathexpr>","<literal>");
                    production_literal();
                //addToSyntaxTable("<condexpr>","<condexpr>");
                    production_nextmathexpr();
                break;

            case IDENTIFIER:
                addToSyntaxTable("<mathexpr>","<identifier>");
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                    production_identifier();
                    production_nextmathexpr();
                break;
        }
    }
    
    void production_nextmathexpr()
    {
        switch(token)
        {
            case PLUS:
                checker(PLUS);
                code = code.concat(" +");
                addToSyntaxTable("<mathop>","+");
                production_mathexpr();
                production_nextmathexpr();
                break;
                
            case MINUS:
                checker(MINUS);
                code = code.concat(" -");
                addToSyntaxTable("<mathop>","-");
                production_mathexpr();
                production_nextmathexpr();
                break;
                
            case MULTIPLY:
                checker(MULTIPLY);
                code = code.concat(" *");
                addToSyntaxTable("<mathop>","*");
                production_mathexpr();
                production_nextmathexpr();
                break;
                
            case DIVIDE:
                checker(DIVIDE);
                code = code.concat(" /");
                addToSyntaxTable("<mathop>","/");
                production_mathexpr();
                production_nextmathexpr();
                break;
                
            case MODULUS:
                code = code.concat(" %");
                checker(MODULUS);
                addToSyntaxTable("<mathop>","%");
                production_mathexpr();
                production_nextmathexpr();
                break;
        }
    }
    
    void production_mathexprOperator()
    {
        switch(token)
        {
            case PLUS:
                checker(PLUS);
                code = code.concat(" +");
                addToSyntaxTable("<mathop>","+");
                break;
                
            case MINUS:
                checker(MINUS);
                code = code.concat(" -");
                addToSyntaxTable("<mathop>","-");
                break;
                
            case MULTIPLY:
                checker(MULTIPLY);
                code = code.concat(" *");
                addToSyntaxTable("<mathop>","*");
                break;
                
            case DIVIDE:
                checker(DIVIDE);
                code = code.concat(" /");
                addToSyntaxTable("<mathop>","/");
                break;
                
            case MODULUS:
                checker(MODULUS);
                code = code.concat(" %");
                addToSyntaxTable("<mathop>","%");
                break;
        }
    }
    
    void production_relop()
    {
        switch(token)
        {
            case GREATERTHAN:
                checker(GREATERTHAN);
                code = code.concat(" >");
                addToSyntaxTable("<relop>",">");
                break;
                
            case LESSTHAN:
                checker(LESSTHAN);
                code = code.concat(" <");
                addToSyntaxTable("<relop>","<");
                break;
                
            case GREATERTHANEQUAL:
                checker(GREATERTHANEQUAL);
                code = code.concat(">=");
                addToSyntaxTable("<relop>",">=");
                break;
                
            case LESSTHANEQUAL:
                checker(LESSTHANEQUAL);
                code = code.concat(" <=");
                addToSyntaxTable("<relop>","<=");
                break;
                
            case EQUALEQUAL:
                checker(EQUALEQUAL);
                code = code.concat(" ==");
                addToSyntaxTable("<relop>","==");
                break;
                
            case NOTEQUAL:
                checker(NOTEQUAL);
                code = code.concat(" !=");
                addToSyntaxTable("<relop>","!=");
                break;
        }
    }
    
    void production_logicop()
    {
        switch(token)
        {
            case AND:
                checker(AND);
                code = code.concat(" &&");
                addToSyntaxTable("<logicop>","&&");
                break;
                
            case OR:
                checker(OR);
                code = code.concat(" ||");
                addToSyntaxTable("<logicop>","||");
                break;
                
            case NOT:
                checker(NOT);
                code = code.concat(" !");
                addToSyntaxTable("<logicop>","!");
                break;
        }
    }
    
    void production_vardec1()
    {
        switch(token)
        {
            case INT : 
                checker(INT); 
                code = code.concat("\nint ");
                addToSyntaxTable("<vardec>", "INT"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat("[");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat("]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<intarrinit>");
                                    production_intarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrint>");
                                    production_nextarrint();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<vardec>","<intvarinit>");
                                production_intvarinit();
                            addToSyntaxTable("<vardec>","<nextintdec>");
                                production_nextintdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ; , Comma");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case FLOAT : 
                checker(FLOAT); 
                code = code.concat("\n float");
                addToSyntaxTable("<datatype>", "FLOAT"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat("]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<floatarrinit>");
                                    production_floatarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrfloat>");
                                    production_nextarrfloat();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ], +, - , / ,*, %");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<vardec>","<floatvarinit>");
                                production_floatvarinit();
                            addToSyntaxTable("<vardec>","<nextfloatdec>");
                                production_nextfloatdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;, Comma");    
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case CHAR : 
                checker(CHAR); 
                code = code.concat("\n char");
                addToSyntaxTable("<datatype>", "CHAR"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat("]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<chararrinit>");
                                    production_chararrinit();
                                addToSyntaxTable("<arraydec>","<nextarrchar>");
                                    production_nextarrchar();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ], +, - , / , * , %");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<vardec>","<charvarinit>");
                                production_charvarinit();
                            addToSyntaxTable("<vardec>","<nextchardec>");
                                production_nextchardec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;, Comma");
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case STRING : 
                checker(STRING); 
                code = code.concat("\n string");
                addToSyntaxTable("<datatype>", "STRING"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat("[");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat("]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<stringarrinit>");
                                    production_stringarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrstring>");
                                    production_nextarrstring();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ], +, - , / , * , %");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<vardec>","<stringvarinit>");
                                production_stringvarinit();
                            addToSyntaxTable("<vardec>","<nextstringdec>");
                                production_nextstringdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;, Comma");   
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case BOOL : 
                checker(BOOL); 
                code = code.concat("\n bool");
                addToSyntaxTable("<datatype>", "BOOL"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat("[");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat("]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<boolarrinit>");
                                    production_boolarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrbool>");
                                    production_nextarrbool();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(";");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ], + , - , / , * , %");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<vardec>","<boolvarinit>");
                                production_boolvarinit();
                            addToSyntaxTable("<vardec>","<nextbooldec>");
                                production_nextbooldec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(";");
                                addToSyntaxTable("<vardec>", ";");
                            }    
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ; , Comma");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            default: addToSyntaxErrorTable("<vardec>", "Expecting INTEGER, FLOAT, CHAR, STRING or BOOL datatype"); hasError = true;
        }
        if(checker1(FLOAT)||checker1(INT)||checker1(CHAR)||checker1(STRING)||checker1(BOOL))
        {
            production_vardec1();
        }
        else
            production_statements();
    }
    
    void production_assignment()
    {
        if(checker(EQUAL))
        {            
            code = code.concat(" =");
            addToSyntaxTable("<statements>","<assignment>");
            addToSyntaxTable("<assignment>","<identifier>");
            addToSyntaxTable("<assignment>","=");                
            addToSyntaxTable("<assignment>","<varassign>");
                production_varassign();
            addToSyntaxTable("<assignment>","<moreassign>");
                //production_moreassign();
            if(checker(COMMA))
            {
                code = code.concat(" ,");
                addToSyntaxTable("<moreassign>", ",");
                    production_assignment();
            }
            else if(checker(SEMICOLON))
            {
                code = code.concat(" ;");
                addToSyntaxTable("<assignment>", ";");
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<assignment>", "Expecting ;");
                hasError = true;
            }
        }
        production_statements();
    }
    
    void production_funcargs()
    {
        switch(token)
        {
            case IDENTIFIER:
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                production_identifier();
                    addToSyntaxTable("<funcargs>","<nextargs>");
                    production_nextargs();
                break;
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                production_literal();
                    addToSyntaxTable("<funcargs>","<nextargs>");
                production_nextargs();
                break;
            //case mathexpr;
            default: addToSyntaxTable("<funcargs>","null");
        }
        return;
    }
    void production_nextargs()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextargs>",",");
                production_funcargs();
        }
        else
        {
            addToSyntaxTable("<nextargs>","null");
        }
            
    }
    
    void production_varassign()
    {
        switch(token)
        {
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                production_literal();
                break;
            
            case IDENTIFIER:
                checker(IDENTIFIER);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<varassign>", "<identifier>");
                if(checker1(OPENPARENTHESIS))
                {
                    production_funccall();
                }
                else
                {
                    production_identifier(); 
                }
                break;
                
            case OPENPARENTHESIS:
                addToSyntaxTable("<varassign>","<mathexpr>");
                production_mathexpr();
                break;
                
            default: if(hasError == false){
                addToSyntaxErrorTable("<varassign>", "Expecting Integer Literal, Float Literal, Char Literal, String Literal, Bool Literal, Identifier or Math Expression");
                hasError = true;
            }
        }

    }
    void production_literal()
    {
        switch(token)
        {
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                code = code.concat(" "+getItem());
                if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                {
                    addToSyntaxTable("<varassign>","<mathexpr>");
                    addToSyntaxTable("<mathexpr>","INT_LIT");
                        production_nextmathexpr();
                }
                else
                {
                    addToSyntaxTable("<varassign>", "<literal>");
                    addToSyntaxTable("<literal>","INT_LIT");
                }
                break;
                
            case FLOATLITERAL:
                checker(FLOATLITERAL);
                code = code.concat(" "+getItem());
                if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                {
                    addToSyntaxTable("<varassign>","<mathexpr>");
                    addToSyntaxTable("<mathexpr>","FLOAT_LIT");
                    production_nextmathexpr();
                }
                else
                {
                    addToSyntaxTable("<varassign>", "<literal>");
                    addToSyntaxTable("<literal>","FLOAT_LIT");
                }
                break;
                
            case CHARLITERAL:
                checker(CHARLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<literal>","CHAR_LIT");
                break;
                
            case STRINGLITERAL:
                checker(STRINGLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<literal>","STRING_LIT");
                break;
                
            case BOOLLITERAL:
                checker(BOOLLITERAL);
                code = code.concat(" "+getItem());
                addToSyntaxTable("<literal>","BOOL_LIT");
                break;
                
            default: addToSyntaxTable("<literal>","null"); return;
        }
    }
    
    void production_identifier()
    { 
        if(checker1(OPENBRACKET)) //arr index
        {
            addToSyntaxTable("<identifier>","<arrid>");
            addToSyntaxTable("<arrid>","id");
                production_arrid();
        }
        else if(checker1(TILDE)) //struct id
        {
            checker(TILDE);
            code = code.concat(".");
            addToSyntaxTable("<identifier>","<structid>");
            addToSyntaxTable("<structid>","identifier");
            addToSyntaxTable("<structid>","~");
            if(checker(IDENTIFIER))
            {
                code = code.concat(""+getItem());
                addToSyntaxTable("<structid>","identifier");
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<structid>","Expecting Identifier");
                hasError = true; 
            }
        }
        else
        {
            if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
            {
                production_nextmathexpr();
            }
            else
                addToSyntaxTable("<identifier>", "Identifier");
        }
    }
    
    
    void production_arrid()
    {
        checker(OPENBRACKET);
        code = code.concat(" [");
        addToSyntaxTable("<arrid>","[");
        addToSyntaxTable("<arrid>","<size>");
            production_size();
        if(checker(CLOSEBRACKET))
        {
            code = code.concat(" ]");
            addToSyntaxTable("<arrid>","]");
            addToSyntaxTable("<arrid>","<dimension>");
                production_dimension();
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<arrid>","Expecting ]");
            hasError = true;
        }
    }
    
    void production_funcparam()
    {
        addToSyntaxTable("<funcparam>","<datatype>");
        switch(token)
        {
            case INT: 
                checker(INT);
                code = code.concat(" int");
                addToSyntaxTable("<datatype>","INT");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<funcparam>","Identifier");
                    addToSyntaxTable("<funcparam>","<moreparam>");
                        production_moreparam();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<funcparam>","Expecting Identifier");
                    hasError = true;
                }
                break;
                
            case FLOAT:
                checker(FLOAT);
                code = code.concat(" float");
                addToSyntaxTable("<datatype>","FLOAT");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<funcparam>","Identifier");
                    addToSyntaxTable("<funcparam>","<moreparam>");
                        production_moreparam();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<funcparam>","Expecting Identifier");
                    hasError = true;
                }
                break;
                
            case CHAR: 
                checker(CHAR);
                code = code.concat(" char");
                addToSyntaxTable("<datatype>","CHAR");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<funcparam>","Identifier");
                    addToSyntaxTable("<funcparam>","<moreparam>");
                        production_moreparam();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<funcparam>","Expecting Identifier");
                    hasError = true;
                }
                break;
                
            case STRING:
                checker(STRING);
                code = code.concat(" string");
                addToSyntaxTable("<datatype>","STRING");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<funcparam>","Identifier");
                    addToSyntaxTable("<funcparam>","<moreparam>");
                        production_moreparam();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<funcparam>","Expecting Identifier");
                    hasError = true;
                }
                break;
            
            case BOOL:
                checker(BOOL);
                code = code.concat(" bool");
                addToSyntaxTable("<datatype>","BOOL");
                if(checker(IDENTIFIER))
                {
                    code = code.concat(" "+getItem());
                    addToSyntaxTable("<funcparam>","Identifier");
                    addToSyntaxTable("<funcparam>","<moreparam>");
                        production_moreparam();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<funcparam>","Expecting Identifier");
                    hasError = true;
                }
                break;
                
            default:
                addToSyntaxTable("<funcparam>","null");
        }      
    }
    
    void production_moreparam()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<moreparam>",",");
                production_funcparam();
        }
        else
            addToSyntaxTable("<moreparam>","null");
    }
    
    void production_struct()
    {
        addToSyntaxTable("<struct>", "RECORDS");
        if(checker(IDENTIFIER))
        {
            code = code.concat(" "+getItem());
            addToSyntaxTable("<struct>", "Identifier");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                addToSyntaxTable("<struct>", "{");
                addToSyntaxTable("<struct>", "<structdec>");
                if(checker1(INT)||checker1(FLOAT)||checker1(CHAR)||checker1(STRING)||checker1(BOOL))
                {
                    production_vardec(); //sa kanya na tong production
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat("\n }");
                        addToSyntaxTable("<struct>","}");
                        if(checker(IDENTIFIER))
                        {
                            code = code.concat(" "+getItem());
                            addToSyntaxTable("<struct>","Identifier");
                            addToSyntaxTable("<struct>","<nextstructid>");
                                production_nextstructid();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<struct>", ";");
                                    production_global();
                                    //production_localdec();
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<nextstructid>", "Expecting ;");
                                hasError = true;
                            }    
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<struct>","Expecting identifier");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<struct>", "Expecting }");
                        hasError = true;
                    }
                }
                else
                {
                    addToSyntaxTable("<structdec>","null");
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat("\n }");
                        addToSyntaxTable("<struct>","}");
                        if(checker(IDENTIFIER))
                        {
                            code = code.concat(" "+getItem());
                            addToSyntaxTable("<struct>","Identifier");
                            addToSyntaxTable("<struct>","<nextstructid>");
                                production_nextstructid();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<struct>", ";");
                                    production_global();
                                    //production_localdec();
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<nextstructid>", "Expecting ;");
                                hasError = true;
                            }    
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<struct>","Expecting identifier");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<struct>", "Expecting }");
                        hasError = true;
                    }
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<struct>", "Expecting {");
                hasError = true;
            }
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<struct>", "Expecting IDENTIFIER");
            hasError = true;
        }
        return;
    }
   
    void production_nextstructid()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextstructid>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
               addToSyntaxTable("<nextstructid>","Identifier");
                    production_nextstructid();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextstructid>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextstructid>","null");
    }
    
    void production_localdec() 
    {
        addToSyntaxTable("<localdec>", "<vardec>");
            production_vardec();
    }
    
    void production_vardec() //ginagamit na to ni struct dec sa pagtawag kay vardec :>; yung sa ginagamit ni statements, vardec1() na, nakahiwalay
    {
        switch(token)
        {
            case INT : 
                checker(INT); 
                code = code.concat("\n int");
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<structdec>", "<arraydec>");
                            addToSyntaxTable("<arraydec>", "INT"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<intarrinit>");
                                    production_intarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrint>");
                                    production_nextarrint();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<structdec>", "<vardec>");
                            addToSyntaxTable("<vardec>", "INT"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<intvarinit>");
                                production_intvarinit();
                            addToSyntaxTable("<vardec>","<nextintdec>");
                                production_nextintdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case FLOAT : 
                checker(FLOAT); 
                code = code.concat("\n float");
                //addToSyntaxTable("<vardec>", "FLOAT"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<structdec>", "<arraydec>");
                            addToSyntaxTable("<arraydec>", "FLOAT"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<floatarrinit>");
                                    production_floatarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrfloat>");
                                    production_nextarrfloat();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<structdec>", "<vardec>");
                            addToSyntaxTable("<vardec>", "FLOAT"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<floatvarinit>");
                                production_floatvarinit();
                            addToSyntaxTable("<vardec>","<nextfloatdec>");
                                production_nextfloatdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case CHAR : 
                checker(CHAR); 
                code = code.concat("\n char");
                //addToSyntaxTable("<datatype>", "CHAR"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<structdec>", "<arraydec>");
                            addToSyntaxTable("<arraydec>", "CHAR"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<chararrinit>");
                                    production_chararrinit();
                                addToSyntaxTable("<arraydec>","<nextarrchar>");
                                    production_nextarrchar();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<structdec>", "<vardec>");
                            addToSyntaxTable("<vardec>", "CHAR"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<charvarinit>");
                                production_charvarinit();
                            addToSyntaxTable("<vardec>","<nextchardec>");
                                production_nextchardec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;"); 
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case STRING : 
                checker(STRING); 
                code = code.concat("\n string");
                //addToSyntaxTable("<datatype>", "STRING"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<structdec>", "<arraydec>");
                            addToSyntaxTable("<arraydec>", "STRING"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<stringarrinit>");
                                    production_stringarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrstring>");
                                    production_nextarrstring();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<structdec>", "<vardec>");
                            addToSyntaxTable("<vardec>", "STRING"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<stringvarinit>");
                                production_stringvarinit();
                            addToSyntaxTable("<vardec>","<nextstringdec>");
                                production_nextstringdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case BOOL : 
                checker(BOOL); 
                code = code.concat("\n bool");
                //addToSyntaxTable("<datatype>", "BOOL"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<structdec>", "<arraydec>");
                            addToSyntaxTable("<arraydec>", "BOOL");
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<boolarrinit>");
                                    production_boolarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrbool>");
                                    production_nextarrbool();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<structdec>", "<vardec>");
                            addToSyntaxTable("<vardec>", "BOOL"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<boolvarinit>");
                                production_boolvarinit();
                            addToSyntaxTable("<vardec>","<nextbooldec>");
                                production_nextbooldec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }    
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");   
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            default: addToSyntaxErrorTable("<vardec>", "Expecting INTEGER, FLOAT, CHAR, STRING or BOOL datatype"); hasError = true;
        }        
        if(checker1(CLOSECURLYBRACE))
            return;
        else
        {
            if(checker1(INT)||checker1(FLOAT)||checker1(STRING)||checker1(CHAR)||checker1(BOOL))
                production_vardec();
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<struct>","Expecting }");
                hasError = true;
            }
        }
    }
    
    void production_varglobaldec()
    {
        switch(token)
        {
            case INT : 
                checker(INT);
                code = code.concat("\n int");
                //addToSyntaxTable("<vardec>", "INT"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        //addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay vararraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<globaldec>","<arrglobaldec>");
                            addToSyntaxTable("<arrglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<arrglobaldec>","<arraydec>");
                            addToSyntaxTable("<arraydec>", "INT"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<intarrinit>");
                                    production_intarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrint>");
                                    production_nextarrint();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si varglobaldec
                        {
                            addToSyntaxTable("<globaldec>","<varglobaldec>");
                            addToSyntaxTable("<varglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<varglobaldec>","<vardec>");
                            addToSyntaxTable("<vardec>", "INT"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<intvarinit>");
                                production_intvarinit();
                            addToSyntaxTable("<vardec>","<nextintdec>");
                                production_nextintdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");    
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case FLOAT : 
                checker(FLOAT); 
                code = code.concat("\n float");
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<globaldec>","<arrglobaldec>");
                            addToSyntaxTable("<arrglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<arrglobaldec>","<arraydec>");
                            addToSyntaxTable("<arraydec>", "FLOAT"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");  
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<floatarrinit>");
                                    production_floatarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrfloat>");
                                    production_nextarrfloat();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<globaldec>","<varglobaldec>");
                            addToSyntaxTable("<varglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<varglobaldec>","<vardec>");
                            addToSyntaxTable("<vardec>", "FLOAT"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<floatvarinit>");
                                production_floatvarinit();
                            addToSyntaxTable("<vardec>","<nextfloatdec>");
                                production_nextfloatdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case CHAR : 
                checker(CHAR); 
                code = code.concat("\n char");
                addToSyntaxTable("<datatype>", "CHAR"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<globaldec>","<arrglobaldec>");
                            addToSyntaxTable("<arrglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<arrglobaldec>","<arraydec>");
                            addToSyntaxTable("<arraydec>", "CHAR"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");    
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<chararrinit>");
                                    production_chararrinit();
                                addToSyntaxTable("<arraydec>","<nextarrchar>");
                                    production_nextarrchar();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<globaldec>","<varglobaldec>");
                            addToSyntaxTable("<varglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<varglobaldec>","<vardec>");
                            addToSyntaxTable("<vardec>", "CHAR"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<charvarinit>");
                                production_charvarinit();
                            addToSyntaxTable("<vardec>","<nextchardec>");
                                production_nextchardec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case STRING : 
                checker(STRING); 
                code = code.concat("\n string");
                addToSyntaxTable("<datatype>", "STRING"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<globaldec>","<arrglobaldec>");
                            addToSyntaxTable("<arrglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<arrglobaldec>","<arraydec>");
                            addToSyntaxTable("<arraydec>", "CHAR"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");     
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<stringarrinit>");
                                    production_stringarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrstring>");
                                    production_nextarrstring();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<globaldec>","<varglobaldec>");
                            addToSyntaxTable("<varglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<varglobaldec>","<vardec>");
                            addToSyntaxTable("<vardec>", "STRING"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<stringvarinit>");
                                production_stringvarinit();
                            addToSyntaxTable("<vardec>","<nextstringdec>");
                                production_nextstringdec();
                            if(checker(SEMICOLON))
                            {
                                code = code.concat(" ;");
                                addToSyntaxTable("<vardec>", ";");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");  
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            case BOOL : 
                checker(BOOL); 
                code = code.concat("\n bool");
                addToSyntaxTable("<datatype>", "BOOL"); 
                    if(checker(IDENTIFIER))
                    {
                        code = code.concat(" "+getItem());
                        addToSyntaxTable("<vardec>","Identifier");
                        if(checker(OPENBRACKET)) //pupunta kay arraydec since naka detect openbracket
                        {
                            code = code.concat(" [");
                            addToSyntaxTable("<globaldec>","<arrglobaldec>");
                            addToSyntaxTable("<arrglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<arrglobaldec>","<arraydec>");
                            addToSyntaxTable("<arraydec>", "CHAR"); 
                            addToSyntaxTable("<arraydec>","Identifier");
                            addToSyntaxTable("<arraydec>","[");
                            addToSyntaxTable("<arraydec>","<size>");   
                                production_size();
                            if(checker(CLOSEBRACKET))
                            {
                                code = code.concat(" ]");
                                addToSyntaxTable("<arraydec>","]");
                                addToSyntaxTable("<arraydec>","<dimension>");
                                    production_dimension();
                                addToSyntaxTable("<arraydec>","<boolarrinit>");
                                    production_boolarrinit();
                                addToSyntaxTable("<arraydec>","<nextarrbool>");
                                    production_nextarrbool();
                                if(checker(SEMICOLON))
                                {
                                    code = code.concat(" ;");
                                    addToSyntaxTable("<arraydec>",";");
                                } 
                                else if(hasError == false)
                                {
                                    addToSyntaxErrorTable("<arraydec>","Expecting ;");
                                    hasError = true;
                                }
                            }   
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<arraydec>","Expecting ]");
                                hasError = true;
                            }
                        }
                        else //itutuloy si vardec
                        {
                            addToSyntaxTable("<globaldec>","<varglobaldec>");
                            addToSyntaxTable("<varglobaldec>","WORLDTOUR");
                            addToSyntaxTable("<varglobaldec>","<vardec>");
                            addToSyntaxTable("<vardec>", "BOOL"); 
                            addToSyntaxTable("<vardec>","Identifier");
                            addToSyntaxTable("<vardec>","<boolvarinit>");
                                production_boolvarinit();
                            addToSyntaxTable("<vardec>","<nextbooldec>");
                                production_nextbooldec();
                            if(checker(SEMICOLON))
                            {
                                addToSyntaxTable("<vardec>", ";");
                            }    
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<vardec>", "Expecting ;");     
                                hasError = true;
                            }
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<vardec>", "Expecting IDENTIFIER");
                        hasError = true;
                    }
                break;
                
            default: addToSyntaxErrorTable("<vardec>", "Expecting INTEGER, FLOAT, CHAR, STRING or BOOL datatype"); hasError = true;
        }        
        if(isFromWorldtour)
        {
                production_global();
        }
//            
//        else
//        {   
//            if(checker(CLOSECURLYBRACE))
//                return;
//            else
//            {
//                if(checker1(INT)||checker1(FLOAT)||checker1(STRING)||checker1(CHAR)||checker1(BOOL))
//                    production_vardec();
//                else
//                {
//                    addToSyntaxErrorTable("<struct>","Expecting }");
//                    System.out.println("may error");
//                }
//            }
//        }
    }
    
    
    boolean checker1(int expectedToken)
    {
        if(token == expectedToken)
        {   
           return true;
        }
        else
        {   
            return false;
        }
    }
    
    void production_nextarrint()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextarrint>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextarrint>","Identifier");
                if(checker(OPENBRACKET))
                {   
                    code = code.concat(" [");
                    addToSyntaxTable("<nextarrint>","[");
                    addToSyntaxTable("<nextarrint>","<size>");
                        production_size();
                    if(checker(CLOSEBRACKET))
                    {
                        code = code.concat(" ]");
                        addToSyntaxTable("<nextarrint>","]");
                        addToSyntaxTable("<nextarrint>","<dimension>");
                            production_dimension();
                        addToSyntaxTable("<nextarrint>","<intarrinit>");
                            production_intarrinit();
                            production_nextarrint();
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<nextarrint>","Expecting ]");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<nextarrint>","Expecting [");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextarrint>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextarrint>","null");
    }
    
    void production_nextarrfloat()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextarrfloat>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextarrfloat>","Identifier");
                if(checker(OPENBRACKET))
                {
                    code = code.concat(" [");
                    addToSyntaxTable("<nextarrfloat>","[");
                    addToSyntaxTable("<nextarrfloat>","<size>");
                        production_size();
                    if(checker(CLOSEBRACKET))
                    {
                        code = code.concat(" ]");
                        addToSyntaxTable("<nextarrfloat>","]");
                        addToSyntaxTable("<nextarrfloat>","<dimension>");
                            production_dimension();
                        addToSyntaxTable("<nextarrfloat>","<floatarrinit>");
                            production_floatarrinit();
                            production_nextarrfloat();
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<nextarrfloat>","Expecting ]");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<nextarrfloat>","Expecting [");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextarrfloat>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextarrfloat>","null");
    }
    
    void production_nextarrchar()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextarrchar>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextarrchar>","Identifier");
                if(checker(OPENBRACKET))
                {
                    code = code.concat(" [");
                    addToSyntaxTable("<nextarrchar>","[");
                    addToSyntaxTable("<nextarrchar>","<size>");
                        production_size();
                    if(checker(CLOSEBRACKET))
                    {
                        code = code.concat(" ]");
                        addToSyntaxTable("<nextarrchar>","]");
                        addToSyntaxTable("<nextarrchar>","<dimension>");
                            production_dimension();
                        addToSyntaxTable("<nextarrchar>","<chararrinit>");
                            production_chararrinit();
                            production_nextarrchar();
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<nextarrchar>","Expecting ]");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<nextarrchar>","Expecting [");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextarrchar>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextarrchar>","null");
    }
    
    void production_nextarrstring()
    {
        if(checker(COMMA))
        {
            addToSyntaxTable("<nextarrstring>",",");
            if(checker(IDENTIFIER))
            {
                addToSyntaxTable("<nextarrstring>","Identifier");
                if(checker(OPENBRACKET))
                {
                    addToSyntaxTable("<nextarrstring>","[");
                    addToSyntaxTable("<nextarrstring>","<size>");
                        production_size();
                    if(checker(CLOSEBRACKET))
                    {
                        addToSyntaxTable("<nextarrstring>","]");
                        addToSyntaxTable("<nextarrstring>","<dimension>");
                            production_dimension();
                        addToSyntaxTable("<nextarrstring>","<stringarrinit>");
                            production_stringarrinit();
                            production_nextarrstring();
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<nextarrstring>","Expecting ]");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<nextarrstring>","Expecting [");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextarrstring>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextarrstring>","null");
    }
    
    void production_nextarrbool()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextarrbool>",",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextarrbool>","Identifier");
                if(checker(OPENBRACKET))
                {
                    code = code.concat(" [");
                    addToSyntaxTable("<nextarrbool>","[");
                    addToSyntaxTable("<nextarrbool>","<size>");
                        production_size();
                    if(checker(CLOSEBRACKET))
                    {
                        code = code.concat(" ]");
                        addToSyntaxTable("<nextarrbool>","]");
                        addToSyntaxTable("<nextarrbool>","<dimension>");
                            production_dimension();
                        addToSyntaxTable("<nextarrbool>","<boolarrinit>");
                            production_boolarrinit();
                            production_nextarrbool();
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<nextarrbool>","Expecting ]");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<nextarrbool>","Expecting [");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextarrbool>","Expecting Identifier");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<nextarrbool>","null");
    }
    public String errMsg = "<int1darr>";
    
    void production_intarrinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                if(checker1(INTEGERLITERAL)||checker1(IDENTIFIER)) //1darray
                {
                    addToSyntaxTable("<intarrinit>","=");
                    addToSyntaxTable("<intarrinit>","{");
                    addToSyntaxTable("<intarrinit>","<intarrval>");
                    addToSyntaxTable("<intarrval>","<1dintarrval>");
                    addToSyntaxTable("<1dintarrrval>","<intval>");
                        production_intval();
                    addToSyntaxTable("<1dintarrval>","<next1dintarrval>");
                        production_next1dintarrval();
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat(" }");
                        addToSyntaxTable("<intarrinit>","}");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<intarrinit>","Expecting }");
                        hasError = true;
                    }
                }
                else if(is2darray == true)
                {
                    if(checker1(OPENCURLYBRACE)) //2darray
                    {
                        checker(OPENCURLYBRACE);
                        code = code.concat(" {");
                        addToSyntaxTable("<intarrinit>","=");
                        addToSyntaxTable("<intarrinit>","{");
                        addToSyntaxTable("<intarrinit>","<intarrval>");
                        addToSyntaxTable("<intarrval>","<2dintarrval>");
                        addToSyntaxTable("<2dintarrval>","{");
                        addToSyntaxTable("<2dintarrval>","<1dintarrval>");
                        addToSyntaxTable("<1dintarrval>","<intval>");
                            production_intval();
                        addToSyntaxTable("<1dintarrval>","<next1dintarrval>");
                            production_next1dintarrval();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat(" }");
                            addToSyntaxTable("<2dintarrval>","}");
                            addToSyntaxTable("<2dintarrval>","<next2dintarrval>");    
                                production_next2dintarrval();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat(" }");
                                addToSyntaxTable("<intarrinit>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<intarrinit>","Expecting }");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<2dintarrval>","Expecting }");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<2dintarrval>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<intarrinit>","Can't Initialize a 2d Array. Dimension not given.");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<intarrinit>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<intarrinit>","null"); 
    }
    
    void production_next2dintarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next2dintarrval>",",");
            if(checker1(OPENCURLYBRACE))
            {   
                checker(OPENCURLYBRACE);
                code = code.concat(" {");
                addToSyntaxTable("<next2dintarrval>","<2dintarrval>");
                addToSyntaxTable("<2dintarrval>","{");
                addToSyntaxTable("<2dintarrval>","<1dintarrval>");
                addToSyntaxTable("<1dintarrval>","<intval>");
                    production_intval();
                addToSyntaxTable("<1dintarrval>","<next1dintarrval>");
                    production_next1dintarrval();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat(" }");
                    addToSyntaxTable("<2dintarrval>","}");
                    addToSyntaxTable("<2dintarrval>","<next2dintarrval>");    
                        production_next2dintarrval();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<2dintarrval>","Expecting }");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<2dintarrval>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<next2dintarrval>","null");
    }
    
    void production_floatarrinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                if(checker1(FLOATLITERAL)||checker1(IDENTIFIER)) //1darray
                {
                    addToSyntaxTable("<floatarrinit>","=");
                    addToSyntaxTable("<floatarrinit>","{");
                    addToSyntaxTable("<floatarrinit>","<floatarrval>");
                    addToSyntaxTable("<floatarrval>","<1dfloatarrval>");
                    addToSyntaxTable("<1dfloatarrrval>","<floatval>");
                        production_floatval();
                    addToSyntaxTable("<1dfloatarrval>","<next1dfloatarrval>");
                        production_next1dfloatarrval();
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat(" }");
                        addToSyntaxTable("<floatarrinit>","}");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<floatarrinit>","Expecting }");
                        hasError = true;
                    }
                }
                else if(is2darray == true)
                {
                    if(checker1(OPENCURLYBRACE)) //2darray
                    {   
                        checker(OPENCURLYBRACE);
                        code = code.concat(" {");
                        addToSyntaxTable("<floatarrinit>","=");
                        addToSyntaxTable("<floatarrinit>","{");
                        addToSyntaxTable("<floatarrinit>","<floatarrval>");
                        addToSyntaxTable("<floatarrval>","<2dfloatarrval>");
                        addToSyntaxTable("<2dfloatarrval>","{");
                        addToSyntaxTable("<2dfloatarrval>","<1dfloatarrval>");
                        addToSyntaxTable("<1dfloatarrval>","<floatval>");
                            production_floatval();
                        addToSyntaxTable("<1dfloatarrval>","<next1dfloatarrval>");
                            production_next1dfloatarrval();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat(" }");
                            addToSyntaxTable("<2dfloatarrval>","}");
                            addToSyntaxTable("<2dfloatarrval>","<next2dfloatarrval>");    
                                production_next2dfloatarrval();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat(" }");
                                addToSyntaxTable("<floatarrinit>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<floatarrinit>","Expecting }");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<2dfloatarrval>","Expecting }");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<2dfloatarrval>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<floatarrinit>","Can't Initialize a 2d Array. Dimension not given.");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<floatarrinit>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<floatarrinit>","null");       
    }
    
    void production_next2dfloatarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next2dfloatarrval>",",");
            if(checker1(OPENCURLYBRACE))
            {   
                checker(OPENCURLYBRACE);
                code = code.concat(" {");
                addToSyntaxTable("<next2dfloatarrval>","<2dfloatarrval>");
                addToSyntaxTable("<2dfloatarrval>","{");
                addToSyntaxTable("<2dfloatarrval>","<1dfloatarrval>");
                addToSyntaxTable("<1dfloatarrval>","<floatval>");
                    production_floatval();
                addToSyntaxTable("<1dfloatarrval>","<next1dfloatarrval>");
                    production_next1dfloatarrval();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat(" }");
                    addToSyntaxTable("<2dfloatarrval>","}");
                    addToSyntaxTable("<2dfloatarrval>","<next2dfloatarrval>");    
                        production_next2dfloatarrval();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<2dfloatarrval>","Expecting }");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<2dfloatarrval>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<next2dfloatarrval>","null");
    }
    
    void production_chararrinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                if(checker1(CHARLITERAL)||checker1(IDENTIFIER)) //1darray
                {
                    addToSyntaxTable("<chararrinit>","=");
                    addToSyntaxTable("<chararrinit>","{");
                    addToSyntaxTable("<chararrinit>","<chararrval>");
                    addToSyntaxTable("<chararrval>","<1dchararrval>");
                    addToSyntaxTable("<1dchararrrval>","<charval>");
                        production_charval();
                    addToSyntaxTable("<1dchararrval>","<next1dchararrval>");
                        production_next1dchararrval();
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat(" }");
                        addToSyntaxTable("<chararrinit>","}");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<chararrinit>","Expecting }");
                        hasError = true;
                    }
                }
                else if(is2darray == true)
                {
                    if(checker1(OPENCURLYBRACE)) //2darray
                    {   
                        checker(OPENCURLYBRACE);
                        code = code.concat(" {");
                        addToSyntaxTable("<chararrinit>","=");
                        addToSyntaxTable("<chararrinit>","{");
                        addToSyntaxTable("<chararrinit>","<chararrval>");
                        addToSyntaxTable("<chararrval>","<2dchararrval>");
                        addToSyntaxTable("<2dchararrval>","{");
                        addToSyntaxTable("<2dchararrval>","<1dchararrval>");
                        addToSyntaxTable("<1dchararrval>","<charval>");
                            production_charval();
                        addToSyntaxTable("<1dchararrval>","<next1dchararrval>");
                            production_next1dchararrval();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat(" }");
                            addToSyntaxTable("<2dchararrval>","}");
                            addToSyntaxTable("<2dchararrval>","<next2dchararrval>");    
                                production_next2dchararrval();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat(" }");
                                addToSyntaxTable("<chararrinit>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<chararrinit>","Expecting }");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<2dchararrval>","Expecting }");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<2dchararrval>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<chararrinit>","Can't Initialize a 2d Array. Dimension not given.");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<chararrinit>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<chararrinit>","null");      
    }
    
    void production_next2dchararrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next2dchararrval>",",");
            if(checker1(OPENCURLYBRACE))
            {   
                checker(OPENCURLYBRACE);
                code = code.concat(" {");
                addToSyntaxTable("<next2dchararrval>","<2dchararrval>");
                addToSyntaxTable("<2dchararrval>","{");
                addToSyntaxTable("<2dchararrval>","<1dchararrval>");
                addToSyntaxTable("<1dchararrval>","<charval>");
                    production_charval();
                addToSyntaxTable("<1dchararrval>","<next1dchararrval>");
                    production_next1dchararrval();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat(" }");
                    addToSyntaxTable("<2dchararrval>","}");
                    addToSyntaxTable("<2dchararrval>","<next2dchararrval>");    
                        production_next2dchararrval();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<2dchararrval>","Expecting }");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<2dchararrval>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<next2dchararrval>","null");
    }
    
    void production_stringarrinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                if(checker1(STRINGLITERAL)||checker1(IDENTIFIER)) //1darray
                {
                    addToSyntaxTable("<stringarrinit>","=");
                    addToSyntaxTable("<stringarrinit>","{");
                    addToSyntaxTable("<stringarrinit>","<stringarrval>");
                    addToSyntaxTable("<stringarrval>","<1dstringarrval>");
                    addToSyntaxTable("<1dstringarrrval>","<stringval>");
                        production_stringval();
                    addToSyntaxTable("<1dstringarrval>","<next1dstringarrval>");
                        production_next1dstringarrval();
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat(" }");
                        addToSyntaxTable("<stringarrinit>","}");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<stringarrinit>","Expecting }");
                        hasError = true;
                    }
                }
                else if(is2darray == true)
                {
                    if(checker1(OPENCURLYBRACE)) //2darray
                    {   
                        checker(OPENCURLYBRACE);
                        code = code.concat(" {");
                        addToSyntaxTable("<stringarrinit>","=");
                        addToSyntaxTable("<stringarrinit>","{");
                        addToSyntaxTable("<stringarrinit>","<stringarrval>");
                        addToSyntaxTable("<stringarrval>","<2dstringarrval>");
                        addToSyntaxTable("<2dstringarrval>","{");
                        addToSyntaxTable("<2dstringarrval>","<1dstringarrval>");
                        addToSyntaxTable("<1dstringarrval>","<stringval>");
                            production_stringval();
                        addToSyntaxTable("<1dstringarrval>","<next1dstringarrval>");
                            production_next1dstringarrval();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat(" }");
                            addToSyntaxTable("<2dstringarrval>","}");
                            addToSyntaxTable("<2dstringarrval>","<next2dstringarrval>");    
                                production_next2dstringarrval();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat(" }");
                                addToSyntaxTable("<stringarrinit>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<stringarrinit>","Expecting }");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<2dstringarrval>","Expecting }");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<2dstringarrval>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<stringarrinit>","Can't Initialize a 2d Array. Dimension not given.");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<stringarrinit>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<stringarrinit>","null");  
    }
    
    void production_next2dstringarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next2dstringarrval>",",");
            if(checker1(OPENCURLYBRACE))
            {   
                checker(OPENCURLYBRACE);
                code = code.concat(" {");
                addToSyntaxTable("<next2dstringarrval>","<2dstringarrval>");
                addToSyntaxTable("<2dstringarrval>","{");
                addToSyntaxTable("<2dstringarrval>","<1dstringarrval>");
                addToSyntaxTable("<1dstringarrval>","<stringval>");
                    production_stringval();
                addToSyntaxTable("<1dstringarrval>","<next1dstringarrval>");
                    production_next1dstringarrval();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat(" }");
                    addToSyntaxTable("<2dstringarrval>","}");
                    addToSyntaxTable("<2dstringarrval>","<next2dstringarrval>");    
                        production_next2dstringarrval();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<2dstringarrval>","Expecting }");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<2dstringarrval>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<next2dstringarrval>","null");
    }
    
    void production_boolarrinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            if(checker(OPENCURLYBRACE))
            {
                code = code.concat(" {");
                if(checker1(BOOLLITERAL)||checker1(IDENTIFIER)) //1darray
                {
                    addToSyntaxTable("<boolarrinit>","=");
                    addToSyntaxTable("<boolarrinit>","{");
                    addToSyntaxTable("<boolarrinit>","<boolarrval>");
                    addToSyntaxTable("<boolarrval>","<1dboolarrval>");
                    addToSyntaxTable("<1dboolarrrval>","<boolval>");
                        production_boolval();
                    addToSyntaxTable("<1dboolarrval>","<next1dboolarrval>");
                        production_next1dboolarrval();
                    if(checker(CLOSECURLYBRACE))
                    {
                        code = code.concat(" }");
                        addToSyntaxTable("<boolarrinit>","}");
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<boolarrinit>","Expecting }");
                        hasError = true;
                    }
                }
                else if(is2darray == true)
                {
                    if(checker1(OPENCURLYBRACE)) //2darray
                    {   
                        checker(OPENCURLYBRACE);
                        code = code.concat(" {");
                        addToSyntaxTable("<boolarrinit>","=");
                        addToSyntaxTable("<boolarrinit>","{");
                        addToSyntaxTable("<boolarrinit>","<boolarrval>");
                        addToSyntaxTable("<boolarrval>","<2dboolarrval>");
                        addToSyntaxTable("<2dboolarrval>","{");
                        addToSyntaxTable("<2dboolarrval>","<1dstringarrval>");
                        addToSyntaxTable("<1dboolarrval>","<boolval>");
                            production_boolval();
                        addToSyntaxTable("<1dboolarrval>","<next1dboolarrval>");
                            production_next1dboolarrval();
                        if(checker(CLOSECURLYBRACE))
                        {
                            code = code.concat(" }");
                            addToSyntaxTable("<2dboolarrval>","}");
                            addToSyntaxTable("<2dboolarrval>","<next2dboolarrval>");    
                                production_next2dboolarrval();
                            if(checker(CLOSECURLYBRACE))
                            {
                                code = code.concat(" }");
                                addToSyntaxTable("<boolarrinit>","}");
                            }
                            else if(hasError == false)
                            {
                                addToSyntaxErrorTable("<boolarrinit>","Expecting }");
                                hasError = true;
                            }
                        }
                        else if(hasError == false)
                        {
                            addToSyntaxErrorTable("<2dboolarrval>","Expecting }");
                            hasError = true;
                        }
                    }
                    else if(hasError == false)
                    {
                        addToSyntaxErrorTable("<2dboolarrval>","Expecting {");
                        hasError = true;
                    }
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<boolarrinit>","Can't Initialize a 2d Array. Dimension not given.");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<boolarrinit>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<boolarrinit>","null");
    }
    
    void production_next2dboolarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next2dboolarrval>",",");
            if(checker1(OPENCURLYBRACE))
            {   
                checker(OPENCURLYBRACE);
                code = code.concat(" {");
                addToSyntaxTable("<next2dboolarrval>","<2dboolarrval>");
                addToSyntaxTable("<2dboolarrval>","{");
                addToSyntaxTable("<2dboolarrval>","<1dboolarrval>");
                addToSyntaxTable("<1dboolarrval>","<boolval>");
                    production_boolval();
                addToSyntaxTable("<1dboolarrval>","<next1dboolarrval>");
                    production_next1dboolarrval();
                if(checker(CLOSECURLYBRACE))
                {
                    code = code.concat(" }");
                    addToSyntaxTable("<2dboolarrval>","}");
                    addToSyntaxTable("<2dboolarrval>","<next2dboolarrval>");    
                        production_next2dboolarrval();
                }
                else if(hasError == false)
                {
                    addToSyntaxErrorTable("<2dboolarrval>","Expecting }");
                    hasError = true;
                }
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<2dboolarrval>","Expecting {");
                hasError = true;
            }
        }
        else
            addToSyntaxTable("<next2dboolarrval>","null");
    }
    
    void production_next1dintarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next1dintarrval>",",");
            addToSyntaxTable("<next1dintarrval>","<1dintarrval>");
            addToSyntaxTable("<1dintarrval>","<intval>");
                production_intval();
                production_next1dintarrval();
        }
        else
            addToSyntaxTable("<next1dintarrval>","null");
    }
    
    void production_next1dfloatarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next1dfloatarrval>",",");
            addToSyntaxTable("<next1dfloatarrval>","<1dfloatarrval>");
            addToSyntaxTable("<1dfloatarrval>","<floatval>");
                production_floatval();
                production_next1dfloatarrval();
        }
        else
            addToSyntaxTable("<next1dfloatarrval>","null");
    }
    
    void production_next1dchararrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next1dchararrval>",",");
            addToSyntaxTable("<next1dchararrval>","<1dchartarrval>");
            addToSyntaxTable("<1dchararrval>","<charval>");
                production_charval();
                production_next1dchararrval();
        }
        else
            addToSyntaxTable("<next1dchararrval>","null");
    }
    
    void production_next1dstringarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next1dstringarrval>",",");
            addToSyntaxTable("<next1dstringarrval>","<1dstringarrval>");
            addToSyntaxTable("<1dstringarrval>","<stringval>");
                production_stringval();
                production_next1dstringarrval();
        }
        else
            addToSyntaxTable("<next1dstringarrval>","null");
    }
    
    void production_next1dboolarrval()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<next1dboolarrval>",",");
            addToSyntaxTable("<next1dboolarrval>","<1dboolarrval>");
            addToSyntaxTable("<1dfloatarrval>","<boolval>");
                production_boolval();
                production_next1dboolarrval();
        }
        else
            addToSyntaxTable("<next1dboolarrval>","null");
    }
    
    void production_size()
    {
        if(checker(INTEGERLITERAL))
        {
            code = code.concat(" "+getItem());
            if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
            {
                addToSyntaxTable("<size>","<mathexpr>");
                addToSyntaxTable("<mathexpr>","INT_LIT");
                production_nextmathexpr();
            }
            else
            {
                addToSyntaxTable("<size>", "INT_LIT");
            }
        }
        else if(checker1(IDENTIFIER))
        {
            addToSyntaxTable("<size>", "<Identifier>");
            checker(IDENTIFIER);
            code = code.concat(" "+getItem());
            if(checker1(PLUS))
            {
                addToSyntaxTable("<size>","<mathexpr>");
                production_nextmathexpr();
            }
            else
            {
                production_identifier();
            }
        }
        else if(checker1(OPENPARENTHESIS))
        {
            addToSyntaxTable("<size>","<mathexpr>");
            production_mathexpr();
        }
        else if(hasError == false)
        {
            addToSyntaxErrorTable("<size>","Expecting Integer Literal or Identifier, Struct ID, Array Index, Math Expression");
            hasError = true;
        }
    }
    
    void production_dimension()
    {
        if(checker(OPENBRACKET))
        {
            code = code.concat(" [");
            is2darray = true;
            addToSyntaxTable("<dimension>","[");
            addToSyntaxTable("<dimension>","<size>");
                production_size();
            if(checker(CLOSEBRACKET))
            {
                code = code.concat(" ]");
               addToSyntaxTable("<dimension>","]");
            }
            else if(hasError == false)
            {
               addToSyntaxErrorTable("<dimension>","Expecting ] , + , - , / , * , %");
               hasError = true;
            }
        }
        else
        {
            addToSyntaxTable("<dimension>","null");
            is2darray = false;
        }
    }
    
    void production_intvarinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            addToSyntaxTable("<intvarinit>", "=");
            addToSyntaxTable("<intvarinit>", "<intval>");
                production_intval();
        }
        else
        {
            addToSyntaxTable("<intvarinit>", "null");
        }
    }
    
    void production_floatvarinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            addToSyntaxTable("<floatvarinit>", "=");
            addToSyntaxTable("<floatvarinit>", "<floatval>");
                production_floatval();
        }
        else
        {
            addToSyntaxTable("<floatvarinit>", "null");
        }
    }
    
    void production_charvarinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            addToSyntaxTable("<charvarinit>", "=");
            addToSyntaxTable("<charvarinit>", "<charval>");
                production_charval();
        }
        else
        {
            addToSyntaxTable("<charvarinit>", "null");
        }
    }
    
    void production_stringvarinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            addToSyntaxTable("<stringvarinit>", "=");
            addToSyntaxTable("<stringvarinit>", "<stringval>");
                production_stringval();
        }
        else
        {
            addToSyntaxTable("<stringvarinit>", "null");
        }
    }
    
    void production_boolvarinit()
    {
        if(checker(EQUAL))
        {
            code = code.concat(" =");
            addToSyntaxTable("<boolvarinit>", "=");
            addToSyntaxTable("<boolvarinit>", "<boolval>");
                production_boolval();
        }
        else
        {
            addToSyntaxTable("<boolvarinit>", "null");
        }
    }
    
    void production_nextintdec()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextintdec>", ",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextintdec>", "identifier");
                addToSyntaxTable("<nextintdec>", "<intvarinit>");
                    production_intvarinit();  
                    production_nextintdec();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextintdec>","Expecting identifier");
                hasError = true;
            }
        } 
        else
            addToSyntaxTable("<nextintdec>", "null");
    }
    void production_nextfloatdec()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextfloatdec>", ",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextfloatdec>", "identifier");
                addToSyntaxTable("<nextfloatdec>", "<floatvarinit>");
                    production_floatvarinit();  
                    production_nextfloatdec();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextfloatdec>","Expecting identifier");
                hasError = true;
            }
        } 
        else
            addToSyntaxTable("<nextfloatdec>", "null");
    }
    
    void production_nextchardec()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextchardec>", ",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextchardec>", "identifier");
                addToSyntaxTable("<nextchardec>", "<charvarinit>");
                    production_charvarinit();  
                    production_nextchardec();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextchardec>","Expecting identifier");
                hasError = true;
            }
        } 
        else
            addToSyntaxTable("<nextchardec>", "null");
        
    }
    
    void production_nextstringdec()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextstringdec>", ",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextstringdec>", "identifier");
                addToSyntaxTable("<nextstringdec>", "<stringvarinit>");
                    production_stringvarinit();  
                    production_nextstringdec();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextstringdec>","Expecting identifier");
                hasError = true;
            }
        } 
        else
            addToSyntaxTable("<nextstringdec>", "null");
        
    }
    
    void production_nextbooldec()
    {
        if(checker(COMMA))
        {
            code = code.concat(" ,");
            addToSyntaxTable("<nextbooldec>", ",");
            if(checker(IDENTIFIER))
            {
                code = code.concat(" "+getItem());
                addToSyntaxTable("<nextbooldec>", "identifier");
                addToSyntaxTable("<nextbooldec>", "<boolvarinit>");
                    production_boolvarinit();  
                    production_nextbooldec();
            }
            else if(hasError == false)
            {
                addToSyntaxErrorTable("<nextbooldec>","Expecting identifier");
                hasError = true;
            }
        } 
        else
            addToSyntaxTable("<nextbooldec>", "null");
    }
    
    
    //Semantic Program Constant Declarations
    
    String scope = null;
    String parentDataType = null;
    String identifier = null;
    String value = null;
    String datatype = null;
    String literalType = null;
    String functionName = null;
    String array1D = null;
    String array2d = null;
    String arraySize = null;
    String Default = "";
    String structName = "";
    String objectName = "";
    String functionDataType = "";
    String IDArray = "";
    int errorCode;
    int countArray1D = 0;
    int countArray2D1 = 0;
    int countArraySeparator = 0;
    int countArray2D2 = 0;
    boolean isFunction = false;
    boolean isFromAssignment=false;
    String dataTypeCatcher = "";
    ArrayList<String> ArrayValues = new ArrayList<>();
    ArrayList<String> memberName = new ArrayList<>();
    ArrayList<String> memberValue = new ArrayList<>();
    ArrayList<String> memberType = new ArrayList<>();
    ArrayList<String> argumentIdentifier = new ArrayList<>();
    ArrayList<String> argumentDataType = new ArrayList<>();
    
    void reInitialize()
    {
        scope = null;
        parentDataType = null;
        identifier = null;
        value = null;
        datatype = null;
        literalType = null;
        functionName = null;
        array1D = null;
        array2d = null;
        arraySize = null;
        Default = "";
        structName = "";
        objectName = "";
        functionDataType = "";
        IDArray = "";
        errorCode = 0;
        countArray1D = 0;
        countArray2D1 = 0;
        countArraySeparator = 0;
        countArray2D2 = 0;
        isFunction = false; 
        isFromAssignment = false;
        dataTypeCatcher = "";
        ArrayValues.clear();
        memberName.clear();
        memberValue.clear();
        memberType.clear();
        argumentIdentifier.clear();
        argumentDataType.clear();
        isFromForLoop = false;
    }
    
    String getItem()
    {
        String item = tblLexeme.getValueAt(tokenPos-2, 0).toString();
        return item;
    }
    
    void addToLocalDeclarationTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblLocalDeclaration.getModel();
        
        model.addRow(new Object[] {identifier, value, parentDataType, arraySize, array2dCopy});

    }
    void addToConstantDeclarationTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblConstantDeclaration.getModel();
        
        model.addRow(new Object[] {identifier, value, parentDataType});
    }
    
    void addToGlobalDeclarationTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblGlobalDeclaration.getModel();
        
        model.addRow(new Object[] {identifier, value, parentDataType});
    }
    
    void addToIdentifierTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblIdentifier.getModel();
        
        model.addRow(new Object[] {identifier, value, parentDataType});
    }
    
    void addToArrayTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblIdentifier.getModel();
        
        model.addRow(new Object[] {identifier, value, parentDataType});
    }
    
    void addToParameterTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblFunctionParemeters.getModel();
        
        model.addRow(new Object[] {functionName, identifier, value, parentDataType});
    }
    
    void addToFunctionTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblFunctionDeclaration.getModel();
        
        model.addRow(new Object[] {functionName, identifier, value, parentDataType});
    }
    
    void addToStructTable()
    {
        DefaultTableModel model = (DefaultTableModel)tblStructDeclaration.getModel();
        
        model.addRow(new Object[] {structName, identifier, value, parentDataType});
    }
        
    void addToSemanticErrorTable(int errorCode)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        if(errorCode == 1)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+
            " is Already Defined", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 2)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Array size must be >= 1 but <= 1000", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)});
        }
        else if(errorCode == 3)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+
            " is Already Defined", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 4)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+
            " is Not Defined", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 5)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+
            " can't be altered.", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 6)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Array Index Out of Bounds "+array1D+ " >= "+countArray1D, "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 7)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "2D Array Index Out of Bounds "+array2d+ " >= "+countArray2D2, "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
        else if(errorCode == 8)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Array 1D Index Out of Bounds: "+array1D+" >= "+countArray2D1, tblLexeme.getModel().getValueAt(tokenPos-2, 2)});
        }
        else if(errorCode == 9)
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+" is NOT Defined", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
        
    }
    
    void checkNotInitialized()
    {
        if(parentDataType.equals("INT"))
        {
            Default = "0";
        }
        else if(parentDataType.equals("FLOAT"))
        {
            Default = "0.00";
        }
        else if(parentDataType.equals("CHAR"))
        {
            Default = "";
        }
        else if(parentDataType.equals("STRING"))
        {
            Default = "";
        }
        else if(parentDataType.equals("BOOL"))
        {
            Default = "false";
        }
        else
        {
            Default = "0";
        }
    }
    
    void semantic_program()
    {
        if(checker(PRELUDE))
        {
            semantic_global();
            if(checker(CONCERT))
            {
                scope = "concert";
                if(checker(OPENPARENTHESIS))
                {
                    if(checker(CLOSEPARENTHESIS))
                    {
                        if(checker(OPENCURLYBRACE))
                        {
                            semantic_declaration(); //statements
                            semantic_nextDeclaration(); //next set of statements
                            if(checker(CLOSECURLYBRACE))
                            {
                                if(checker(ENCORE))
                                {
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    void semantic_nextDeclaration()
    {
        switch(token)
        {
            case INT: case FLOAT: case CHAR: case STRING: case BOOL: case OUTRO: case INTRO: case IDENTIFIER: case IF: case CHORDS:
                semantic_declaration();
                semantic_nextDeclaration();
                break;
        }
    }
    
    void semantic_global()
    {
        if(checker(RECORDS))
        {
            semantic_struct();
        }
        else if(checker(CONST))
        {
            scope = "const";
            semantic_const();
        }
        else if(checker(WORLDTOUR))
        {
            scope = "worldtour";
            semantic_worldtour();
        }
        else if(checker(INTERLUDE))
        {    
            scope = "function";
            semantic_functiondef();
        }
    }
    
    void semantic_struct()
    {
        String text = "";
        parentDataType = "RECORDS";
        if(checker(IDENTIFIER))
        {
            structName = getItem();
            if(scope == "function")
            {            
                text = getItem();
                identifier = text;
                interlude_checkAlreadyDefined(text);
            }
            else if(scope == "concert")
            {
                text = getItem();
                identifier = text;
                concert_checkAlreadyDefined(text);
            }
            else
            {
                text = getItem();
                identifier = text;
                checkAlreadyDefined(text);  
            }
            value = "0";
            addToIdentifierTable();
            if(checker(OPENCURLYBRACE))
            {
                parentDataType = getParentDataType();
                if(checker(IDENTIFIER))
                {
                    if(scope == "function")
                    {            
                        text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else if(scope == "concert")
                    {
                        text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else
                    {
                        text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);  
                    }
                    dataTypeCatcher = parentDataType;
                    identifier = text;
                    semantic_valueInitialize2();
                    semantic_nextStructVariable();
                    if(checker(SEMICOLON))
                    {
                        semantic_nextMember();
                        if(checker(CLOSECURLYBRACE))
                        {
                            if(checker(IDENTIFIER))
                            {
                                objectName = getItem();
                                checkStoreStructValues();
                                semantic_nextObject();

                                memberName.clear();
                                memberValue.clear();
                                memberType.clear();
                                if(checker(SEMICOLON))
                                {
                                    semantic_global();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    void semantic_nextObject()
    {
        if(checker(COMMA))
        {
            if(checker(IDENTIFIER))
            {
                objectName = getItem();
                checkStoreStructValues();
                semantic_nextObject();
            }
        }
    }
    
    void checkStoreStructValues()
    {
        DefaultTableModel model = (DefaultTableModel)tblStructDeclaration.getModel();   
        DefaultTableModel identifier = (DefaultTableModel)tblIdentifier.getModel();  
        int i =0;
        checkAlreadyDefined(objectName);
        identifier.addRow(new Object[] {objectName, "", "Struct Alias"});
        
        while(i < memberName.size())
        {
            structCheckAlreadyDefined(memberName.get(i), i);
            model.addRow(new Object[] {structName, objectName, memberName.get(i), memberValue.get(i), memberType.get(i)});
            i++;
        }
    }
    
    void structCheckAlreadyDefined(String identifier, int member)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow = tblIdentifier.getRowCount(); 
        boolean flag = false, flag1= false;
        for(int i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                flag1 = true; break;
            }
        }
        
        
        if(flag1 == true)
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+" is Already Defined", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        
        int identifierrow1 = tblStructDeclaration.getRowCount();
        for(int i = 0; i < identifierrow1; i++)
        {
            if(identifier.equals(tblStructDeclaration.getValueAt(i, 2).toString()) && objectName.equals(tblStructDeclaration.getValueAt(i, 1).toString()))
            {
                flag = true; break;
            }
        }
        
        
        if(flag == true)
            semanticerror.addRow(new Object[] {memberName.get(member), "Variable "+memberName.get(member)+" is Already Defined", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
    }
    
    void semantic_nextMember()
    {
        String text = "";
        switch(token)
        {
            case INT: case FLOAT: case CHAR: case STRING: case BOOL:
                parentDataType = getParentDataType();
                if(checker(IDENTIFIER))
                {
                    if(scope == "function")
                    {            
                        text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else if(scope == "concert")
                    {
                        text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else
                    {
                        text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);  
                    }
                    identifier = text;
                    semantic_valueInitialize2();
                    semantic_nextStructVariable();
                    if(checker(SEMICOLON))
                    {
                        semantic_nextMember();
                    }
                }
            break;
        }
    }
    
    void semantic_nextStructVariable()
    {
        if(checker(COMMA))
        {
            if(checker(IDENTIFIER))
            {
                value = "0";
                identifier = getItem();
                semantic_valueInitialize2();
                semantic_nextStructVariable();
            }
        }
    }
    
    void semantic_valueInitialize2()
    {
        if(checker(EQUAL))
        {
            semantic_value2();
            memberName.add(identifier);
            memberValue.add(value);
            memberType.add(parentDataType);
        }
        else if(checker(OPENBRACKET))
        {
            semantic_const_arraySize();
            array1D = arraySize;
            if(checker(CLOSEBRACKET))
            {
                semantic_2dArray();
            }
            memberName.add(identifier);
            memberValue.add(value);
            memberType.add(parentDataType);
        }
        else
        {
            checkNotInitialized(); //if variable was not initialized a value, values will be set to default accordign to datatype
            value = Default;
            memberName.add(identifier);
            memberValue.add(value);
            memberType.add(parentDataType);
        }
    }
    
    void semantic_functiondef()
    {
        DefaultTableModel identifierTable = (DefaultTableModel)tblIdentifier.getModel();
        String text = "";
        switch(token)
        {
            case MUTE:  //void
                checker(MUTE);
                if(checker(IDENTIFIER))
                {
                    if(scope == "function")
                    {            
                        text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else if(scope == "concert")
                    {
                        text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else
                    {
                        text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);  
                    }
                }
                
                functionName = text;
//                checkNotInitialized();
                value = "0";
                identifierTable.addRow(new Object[] {functionName, value, "MUTE"});
                if(checker(OPENPARENTHESIS))
                {
                    semantic_parameters();
                    semantic_nextParameter();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        if(checker(OPENCURLYBRACE))
                        {
                            semantic_declaration();
                            semantic_nextDeclaration();
                            if(checker(CLOSECURLYBRACE))
                            {

                            }
                        }
                    }
                }
                
                break;
                
            case INT: case FLOAT: case CHAR: case STRING: case BOOL:
                parentDataType = getParentDataType();
                functionDataType = parentDataType;
                if(checker(IDENTIFIER))
                {
                    if(scope == "function")
                    {            
                        text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else if(scope == "concert")
                    {
                        text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else
                    {
                        text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);  
                    }
                }
                
                functionName = text;
//                checkNotInitialized();
                value = "0";
                identifierTable.addRow(new Object[] {functionName, value, functionDataType});
                if(checker(OPENPARENTHESIS))
                {
                    semantic_parameters();
                    semantic_nextParameter();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        if(checker(OPENCURLYBRACE))
                        {
                            semantic_declaration();
                            semantic_nextDeclaration();
                            if(checker(PRODUCE))
                            {
                                semantic_value3();
                                checkReturnValue(functionDataType, datatype);
                                if(checker(SEMICOLON))
                                {
                                    if(checker(CLOSECURLYBRACE))
                                    {

                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        System.out.println("Token after } of function: "+token);
        semantic_global();
    }
    
    void checkReturnValue(String datatype, String datatype1)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        if(datatype.equals(datatype1))
        {

        }else if(datatype.equals("INT") && datatype1.equals("FLOAT"))
        {

        }else if(datatype1 == null)
        {

        }
        else{
           semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Returning Data Type Does Not Match: "+datatype1+" to "+datatype, tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
    }
    
    void semantic_parameters()
    {
        switch(token)
        {
            case INT: case FLOAT: case CHAR: case STRING: case BOOL:
                parentDataType = getParentDataType();
                if(checker(IDENTIFIER))
                {
                    checkNotInitialized();
                    
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);
                    }
                    semantic_parameter_extension(); //for array index, struct id
                    addToParameterTable();
                    addToFunctionTable();
                }
            break;
        }
    }
    
    void semantic_nextParameter()
    {
        if(checker(COMMA))
        {
            parentDataType = getParentDataType();
            if(checker(IDENTIFIER))
            {
                checkNotInitialized();
                value = Default;
                if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkAlreadyDefined(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    identifier = text;
                    interlude_checkAlreadyDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkAlreadyDefined(text);
                }
                semantic_parameter_extension(); //for array index, struct id
                addToParameterTable();
                addToFunctionTable();
                semantic_nextParameter();
            }
        }
        
    }
    
    void semantic_parameter_extension()
    {
        switch(token)
        {
            case OPENBRACKET:
                checker(OPENBRACKET);
                semantic_const_arraySize();
                array1D = arraySize;
                if(checker(CLOSEBRACKET))
                {
                    semantic_2dArray();
                }
            case TILDE: 
        }
    }
    
    void semantic_worldtour()
    {
        parentDataType = getParentDataType();
        if(checker(IDENTIFIER))
        {
            if(scope == "concert")
            {
                String text = getItem();
                identifier = text;
                concert_checkAlreadyDefined(text);
            }
            else if(scope == "function")
            {
                String text = getItem();
                identifier = text;
                interlude_checkAlreadyDefined(text);
            }
            else
            {
                String text = getItem();
                identifier = text;
                checkAlreadyDefined(text);
            }
            semantic_worldtour_extension();
            semantic_worldtour_nextVariable();
        }
        semantic_global();
    }
    
    void semantic_worldtour_extension()
    {
        switch(token)
        {
            case OPENBRACKET: case EQUAL: case COMMA:
                semantic_worldtour_valueInitialize();
                if(checker(SEMICOLON))
                {
                    
                }
                addToGlobalDeclarationTable();
                addToIdentifierTable();
                break;
            
            case SEMICOLON:
                checker(SEMICOLON);
                addToGlobalDeclarationTable();
                addToIdentifierTable();
                break; 
        }
    }
    
    void semantic_value4()
    {
        switch(token)
        {
            case IDENTIFIER:
                checker(IDENTIFIER);
                if(scope == "function")
                {                        
                    String text = getItem();
                    identifier = text;
                    interlude_checkIfDefined(text);
                }
                else if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkIfDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkIfDefined(text);  
                }
                
                semantic_extension();
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                semantic_value();
                break;
        }
    }
    
    void semantic_value2()
    {
        switch(token)
        {
            case IDENTIFIER:
                checker(IDENTIFIER);
                if(scope == "function")
                {                        
                    String text = getItem();
                    identifier = text;
                    interlude_checkIfDefined(text);
                }
                else if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkIfDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkIfDefined(text);  
                }
                //semantic_extension();
                if(isFunction == false)
                {
                    checkSameDataType(dataTypeCatcher,datatype);
                }
                semantic_extension();
                semantic_nextOperand1();
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                semantic_value();
                if(isFunction == false)
                {
                    checkSameDataType(dataTypeCatcher,datatype);
                }
                semantic_nextOperand1();
                break;
        }
    }
    
    void checkSameDataType(String datatype, String datatype1)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        if(datatype.equals(datatype1))
        {

        }
        else if(datatype.equals("INT") && datatype1.equals("FLOAT"))
        {
            
        }
        else if(datatype.equals("FLOAT") && datatype1.equals("INT"))
        {
            
        }
        else if(datatype1 == null)
        {

        }
        else
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+datatype1+" Cannot be converted to "+datatype, tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
        datatype = null;
    }
    boolean isStruct = false;
    void semantic_extension()
    {
        switch(token)
        {
            case OPENBRACKET: //array
                checker(OPENBRACKET);
                isFromAssignment=true;
                semantic_const_arraySize();
                if(checker(CLOSEBRACKET))
                {
                    semantic_2dArray();
                }
                break;
                
            case TILDE: //struct member
                isStruct = true;
                semantic_structMemberCheck();
                break;
                
            case OPENPARENTHESIS: 
                semantic_interlude();
                break;
        }
    }
    
    void semantic_structMemberCheck()
    {
        String objName = getItem();
        String objLine = tblLexeme.getModel().getValueAt(tokenPos-2, 2).toString();
        
        if(checker(TILDE))
        {
            checkIfObjectName(objName,datatype,objLine);
            if(checker(IDENTIFIER))
            {
                checkIfStructMember(objName,getItem());
                if(isFunction==true)
                {
                    argumentIdentifier.add(getItem());
                    argumentDataType.add(datatype);
                    isFunction=false;
                }
            }
        }
    }
    
    void checkIfStructMember(String objName, String structMember)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow1 = tblStructDeclaration.getRowCount();
        int i;
        for( i = 0; i < identifierrow1; i++)
        {
            if(objName.equals(tblStructDeclaration.getValueAt(i, 1).toString()) && structMember.equals(tblStructDeclaration.getValueAt(i, 2).toString()))
            {
                break;
            }
        }
        
        if(i == (identifierrow1))
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), 
                "Variable "+structMember+" is not a member of Records : "+objName, 
                tblLexeme.getModel().getValueAt(tokenPos-2, 2)});
        }else{
//            if(isStruct == true)
//            //dataTypeCatcher = tblStructDeclaration.getValueAt(i, 4).toString();
//            datatype = tblStructDeclaration.getValueAt(i, 4).toString();
//            else
//            {
                dataTypeCatcher = tblStructDeclaration.getValueAt(i, 4).toString();
                datatype = tblStructDeclaration.getValueAt(i, 4).toString();
//            }
        }
    }
    
    void checkIfObjectName(String id, String dtype, String line)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        if(!dtype.equals("Struct Alias"))
        {
            semanticerror.addRow(new Object[] {id, "Variable "+id+"Is Not An Object of Struct", line});   
        }
    }
    
    void semantic_worldtour_valueInitialize()
    {
       switch(token)
       {
            case EQUAL:
               checker(EQUAL);
               semantic_value();
               addToGlobalDeclarationTable();
               addToIdentifierTable();
               semantic_worldtour_nextVariable();
               break;
               
            case COMMA:
                value = null;
                addToGlobalDeclarationTable();
                addToIdentifierTable();
                semantic_worldtour_nextVariable();
                break;
                
                
            case SEMICOLON:
                checker(SEMICOLON);
                addToGlobalDeclarationTable();
                addToIdentifierTable();
                break;
                
            case OPENBRACKET:
                checker(OPENBRACKET);
                semantic_const_arraySize();
                array1D = arraySize;
                if(checker(CLOSEBRACKET))
                {
                    semantic_2dArray();
                    semantic_worldtour_nextVariable();
                }
                break;
        }
    }
    
    void semantic_worldtour_nextVariable()
    {
        if(checker(COMMA))
        {
            if(checker(IDENTIFIER))
            {
                if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkAlreadyDefined(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    identifier = text;
                    interlude_checkAlreadyDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkAlreadyDefined(text);
                }
                semantic_worldtour_valueInitialize();
                semantic_worldtour_nextVariable();
            }
        }
    }
    
    void semantic_const()
    {
        parentDataType = getParentDataType();
        if(checker(IDENTIFIER))
        {
            if(scope == "concert")
            {
                String text = getItem();
                identifier = text;
                concert_checkAlreadyDefined(text);
            }
            else if(scope == "function")
            {
                String text = getItem();
                identifier = text;
                interlude_checkAlreadyDefined(text);
            }
            else
            {
                String text = getItem();
                identifier = text;
                checkAlreadyDefined(text);
            }
            semantic_const_valueInitialize();
            addToConstantDeclarationTable();
            addToIdentifierTable();
            
            semantic_const_nextVariable();
            if(checker(SEMICOLON))
            {
                semantic_global();
            }
        }
    }
    
    void semantic_const_nextVariable()
    {
        switch(token)
        {
            case COMMA:
                checker(COMMA);
                if(checker(IDENTIFIER))
                {
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);
                    }
                    semantic_const_valueInitialize();
                    addToConstantDeclarationTable();
                    addToIdentifierTable();
                    semantic_const_nextVariable();
                }
            break;
        }
    }
    
    void semantic_const_valueInitialize()
    {
       switch(token)
       {
            case EQUAL:
               checker(EQUAL);
               semantic_value();
               break;
        }
    }
    
    void semantic_const_arraySize()
    {
        switch(token)
        {
            case IDENTIFIER:
                checker(IDENTIFIER);
                if(scope == "concert")
                {
                    String text = getItem();
                    concert_checkInt(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    interlude_checkInt(text);
                }
                else
                {
                    String text = getItem();
                    checkInt(text);
                }
                checkArraySize(Integer.parseInt(arraySize));
                break;
            
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                value = getItem();
                datatype = "INT";
                literalType = "INT Literal";
                arraySize = getItem();
                checkArraySize(Integer.parseInt(arraySize));
                break; 
        }
//        arraySize = "";
    }
    
    
    String getParentDataType()
    {
        switch(token)
        {
            case INT:
                checker(INT); return "INT";
            case FLOAT:
                checker(FLOAT); return "FLOAT";
            case CHAR:
                checker(CHAR); return "CHAR";
            case STRING:
                checker(STRING); return "STRING";
            case BOOL:
                checker(BOOL); return "BOOL";
            case MUTE:
                checker(MUTE); return "MUTE";
        }
        return null;
    }

    void semantic_declaration()
    {
        switch(token)
        {
            case INT: case FLOAT: case CHAR: case STRING: case BOOL:
                parentDataType = getParentDataType();
                if(checker(IDENTIFIER))
                {   
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);
                    }
                    
                    dataTypeCatcher = parentDataType;
                    semantic_valueInitialize();
                    semantic_nextVariable();
                    
                    if(checker(SEMICOLON))
                    {
                        semantic_declaration();
                    }
                }
                break;
                
            case OUTRO:
                checker(OUTRO);
                semantic_value4();
                semantic_nextOutput();
                if(checker(SEMICOLON))
                {
                    semantic_declaration();
                }
                break;
                
            case INTRO:
                checker(INTRO);
                if(checker(IDENTIFIER))
                {
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkIfDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkIfDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkIfDefined(text);
                    }
                    
                    if(datatype.equals("STRING"))
                    {
                        changeCinToGetline();
                    }
                    semantic_extension();
                    semantic_nextInput();
                    if(checker(SEMICOLON))
                    {
                        semantic_declaration();
                    }
                }
                break;
                
            case IDENTIFIER:
                checker(IDENTIFIER);
                if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkIfDefined(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    identifier = text;
                    interlude_checkIfDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkIfDefined(text);
                }
                dataTypeCatcher = datatype;
                semantic_checkIfConstant(identifier);
                semantic_extension();
                semantic_assignmentOperator();
                
                if(checker(SEMICOLON)){
                    semantic_declaration();
                }
                break;
                
            case IF: case CHORDS:
                semantic_conditional();
                break;
                
            case LOOP: case REPEAT: case DO:
                semantic_loopstatements();
                break;
            
            case INCREMENT: case DECREMENT:
                semantic_incdec();
                break;
        }
    }
    
    void semantic_loopinit()
    {
        switch(token)
        {
            case IDENTIFIER:
                semantic_value4(); 
                break;
            
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                break;
                
//            default: addToSyntaxErrorTable("<loopinit>","Expecting Identifier or Integer Literal"); hasError = true;
        }
    }
    
    void semantic_preinc()
    {
        if(checker1(IDENTIFIER))
        {
            semantic_value4();
        }
    }
    
    void semantic_incdec()
    {
        switch(token)
        {
            case INCREMENT: case DECREMENT:
                if(checker(INCREMENT))
                {
                    semantic_preinc();
                    if(checker(SEMICOLON))
                    {
                        
                    }
                }
                else if(checker(DECREMENT))
                {
                    semantic_preinc();
                    if(checker(SEMICOLON))
                    {

                    }
                }
                break;
            
            case IDENTIFIER:
                semantic_value4();
                if(checker(INCREMENT))
                {
                    if(checker(SEMICOLON))
                    {
                        
                    }
                }
                else if(checker(DECREMENT))
                {
                    if(checker(SEMICOLON))
                    {

                    }
                }
                break;   
        }
        semantic_declaration();
    }
    
    void semantic_loopstatements()
    {
        switch(token)
        {
            case LOOP:
            //isFromForLoop = true;
            checker(LOOP);
            if(checker(OPENPARENTHESIS))
            {
                if(checker1(IDENTIFIER))
                {
                    semantic_value4();
                    if(checker(EQUAL))
                    {
                        semantic_loopinit();
                        if(checker(SEMICOLON))
                        {
                            semantic_condexpr();
                            semantic_nextcondexpr();
                            if(checker(SEMICOLON))
                            {
                                semantic_incdec();
                                if(checker(CLOSEPARENTHESIS))
                                {
                                    if(checker(OPENCURLYBRACE))
                                    {
                                        semantic_declaration();
                                        semantic_nextDeclaration();
                                        semantic_stopplay();
                                        if(checker(CLOSECURLYBRACE))
                                        {
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            break;
            
            case REPEAT:
            checker(REPEAT);
            if(checker(OPENPARENTHESIS))
            {
                semantic_condexpr();
                semantic_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    if(checker(OPENCURLYBRACE))
                    {
                        semantic_declaration();
                        semantic_nextDeclaration();
                        semantic_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {

                        }
                    }
                }
            }
            break;
            
            case DO:
            checker(DO);
            if(checker(OPENCURLYBRACE))
            {
                semantic_declaration();
                semantic_stopplay();
                if(checker(CLOSECURLYBRACE))
                {
                    if(checker(REPEAT))
                    {
                        if(checker(OPENPARENTHESIS))
                        {
                            semantic_condexpr();
                            semantic_nextcondexpr();
                            if(checker(CLOSEPARENTHESIS))
                            {
                                if(checker(SEMICOLON))
                                {

                                }
                            }
                        }
                    }
                }
            }
            
            break;
            
            default: 
                //addToSyntaxTable("<loopstatements>","null");
        }
         semantic_declaration();
    }
    
    void semantic_conditional()
    {
        switch(token)
        {
            case IF:
            checker(IF); //determines that it is an IF statement
            if(checker(OPENPARENTHESIS))
            {
                semantic_condexpr();
                semantic_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    if(checker(OPENCURLYBRACE))
                    {
                        semantic_declaration();
                        semantic_nextDeclaration();
                        semantic_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {
                            semantic_elseifstatement();
                            production_elsestatement();
                        }
                    }
                }
            }
            break;
            
            case CHORDS:
            checker(CHORDS);
            if(checker(OPENPARENTHESIS))
            {
                if(checker1(IDENTIFIER))
                {    
                    semantic_value4();
                    if(checker(CLOSEPARENTHESIS))
                    {
                        if(checker(OPENCURLYBRACE))
                        {
                            semantic_case();
                            semantic_stopplay();
                            production_default();
                            if(checker(CLOSECURLYBRACE))
                            {
                                
                            }
                        }
                    }
                }
            }
        }
    }
    
    void semantic_default()
    {
        if(checker(CADENCE))
        {
            if(checker(COLON))
            {
                semantic_declaration();
                semantic_nextDeclaration();
            }
        }
    }
    
    void semantic_case()
    {
        if(checker(NOTE))
        {
            semantic_switchconst();
            if(checker(COLON))
            {
                semantic_declaration();
                semantic_nextDeclaration();
                semantic_stopplay();
                semantic_nextcase();
            }
        }
    }
    
    void semantic_nextcase()
    {
        if(checker1(NOTE))
            semantic_case();
    }
    
    void semantic_switchconst()
    {
        switch(token)
        {
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                break;
                
            case CHARLITERAL:
                checker(CHARLITERAL);
                break;
                
//            default:
//                addToSyntaxErrorTable("<switchconst>","Expecting Integer or Char Literal"); hasError = true;
        }
    }
    
    void semantic_elseifstatement()
    {
        if(checker(ELSEIF))
        {
            if(checker(OPENPARENTHESIS))
            {
                semantic_condexpr();
                semantic_nextcondexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    if(checker(OPENCURLYBRACE))
                    {
                        semantic_declaration();
                        semantic_nextDeclaration();
                        semantic_stopplay();
                        if(checker(CLOSECURLYBRACE))
                        {
                            semantic_elseifstatement();
                            semantic_elsestatement();
                        }
                    }
                }
            }
        }
    }
    
    void semantic_elsestatement()
    {
        if(checker(ELSE))
        {
            if(checker(OPENCURLYBRACE))
            {
                semantic_declaration();
                semantic_nextDeclaration();
                semantic_stopplay();
                if(checker(CLOSECURLYBRACE))
                {
                    semantic_declaration();
                }
            }
        }
    }
    
    void semantic_stopplay()
    {
        switch(token)
        {
            case STOP:
                checker(STOP);
                if(checker(SEMICOLON))
                {
                }
                break;
                
            case PLAY:
                checker(PLAY);
                if(checker(SEMICOLON))
                {
                }
                break;
                
            default:
                //addToSyntaxTable("<stop/play>","null");
        }
    }
    
    void semantic_nextcondexpr()
    {
        switch(token)
        {          
            case GREATERTHAN: case LESSTHAN: case GREATERTHANEQUAL: case LESSTHANEQUAL: case NOTEQUAL: case EQUALEQUAL:
                    semantic_relop();
                    semantic_condexpr();
                    semantic_nextcondexpr();
                break;

            case NOT: case AND: case OR:
                    semantic_logicop();
                    semantic_condexpr();
                    semantic_nextcondexpr();
                break;

            case PLUS: case MINUS: case MULTIPLY: case DIVIDE: case MODULUS:
                    semantic_mathexprOperator();
                    semantic_condexpr(); 
                    semantic_nextcondexpr();
                break;
        }
    }
    
    void checkOperands()
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        String before = tblLexeme.getValueAt(tokenPos-3, 0).toString();
        String after = tblLexeme.getValueAt(tokenPos-1, 0).toString();
        String datatype;
        boolean flag = false,flag1 = false;
        int identifierrow = tblLocalDeclaration.getRowCount();
        for(int i = 0; i < identifierrow; i++)
        {
            datatype = tblLocalDeclaration.getValueAt(i, 2).toString();
            if(before.equals(tblLocalDeclaration.getValueAt(i, 0).toString()) && (!"INT".equals(datatype) || !"FLOAT".equals(datatype)))
            {
                System.out.println("pst: "+tblLocalDeclaration.getValueAt(i, 2).toString()+" i: "+i);
                flag = true;
                break;
            }
        }
        
        for(int i = 0; i < identifierrow; i++)
        {
            datatype = tblLocalDeclaration.getValueAt(i, 2).toString();
            if(after.equals(tblLocalDeclaration.getValueAt(i, 0).toString()) && ("INT".equals(datatype) || !"FLOAT".equals(datatype)))
            {
                System.out.println("pst1: "+tblLocalDeclaration.getValueAt(i, 2).toString()+" i: "+i);
                flag1 = true;
                break;
            }
        }
        if(flag && flag1)
        {
            semanticerror.addRow(new Object[] {"", "Error", "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
        }
            
    }
    
    void semantic_mathexprOperator()
    {
        switch(token)
        {
            case PLUS:
                checker(PLUS);
                //checkOperands();
                break;
                
            case MINUS:
                checker(MINUS);
                break;
                
            case MULTIPLY:
                checker(MULTIPLY);
                break;
                
            case DIVIDE:
                checker(DIVIDE);
                break;
                
            case MODULUS:
                checker(MODULUS);
                break;
        }
    }
    
    void semantic_logicop()
    {
        switch(token)
        {
            case AND:
                checker(AND);
                break;
                
            case OR:
                checker(OR);
                break;
                
            case NOT:
                checker(NOT);
                break;
        }
    }
    
    void semantic_relop()
    {
        switch(token)
        {
            case GREATERTHAN:
                checker(GREATERTHAN);
                break;
                
            case LESSTHAN:
                checker(LESSTHAN);
                break;
                
            case GREATERTHANEQUAL:
                checker(GREATERTHANEQUAL);
                break;
                
            case LESSTHANEQUAL:
                checker(LESSTHANEQUAL);
                break;
                
            case EQUALEQUAL:
                checker(EQUALEQUAL);
                break;
                
            case NOTEQUAL:
                checker(NOTEQUAL);
                break;
        }
    }
    
    void semantic_nextmathexpr()
    {
        switch(token)
        {
            case PLUS:
                checker(PLUS);
                semantic_mathexpr();
                semantic_nextmathexpr();
                break;
                
            case MINUS:
                checker(MINUS);
                semantic_mathexpr();
                semantic_nextmathexpr();
                break;
                
            case MULTIPLY:
                checker(MULTIPLY);
                semantic_mathexpr();
                semantic_nextmathexpr();
                break;
                
            case DIVIDE:
                checker(DIVIDE);
                semantic_mathexpr();
                semantic_nextmathexpr();
                break;
                
            case MODULUS:
                checker(MODULUS);
                semantic_mathexpr();
                semantic_nextmathexpr();
                break;
        }
    }
    
    void semantic_mathexpr()
    {
        switch(token)
        {
            case OPENPARENTHESIS:
                checker(OPENPARENTHESIS);
                    semantic_mathexpr();
                    semantic_nextmathexpr();
                if(checker(CLOSEPARENTHESIS))
                {
                    if(checker1(PLUS)||checker1(MINUS)||checker1(MULTIPLY)||checker1(DIVIDE)||checker1(MODULUS))
                        semantic_nextmathexpr();
                }
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL:
                semantic_literal();
                semantic_nextmathexpr();
                break;

            case IDENTIFIER:
                semantic_value4();
                semantic_nextmathexpr();
                break;
        }
    }
   
    
    
    void semantic_literal()
    {
        switch(token)
        {
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                {
                    semantic_nextmathexpr();
                }
                break;
                
            case FLOATLITERAL:
                checker(FLOATLITERAL);
                if(checker1(PLUS)||checker1(MINUS)||checker1(DIVIDE)||checker1(MODULUS)||checker1(MULTIPLY))
                {
                    semantic_nextmathexpr();
                }
                break;
                
            case CHARLITERAL:
                checker(CHARLITERAL);
                break;
                
            case STRINGLITERAL:
                checker(STRINGLITERAL);
                break;
                
            case BOOLLITERAL:
                checker(BOOLLITERAL);
                break;
                
            default: //addToSyntaxTable("<literal>","null"); return;
        }
    }
    
    void semantic_condexpr()
    {
        switch(token)
        {
            case OPENPARENTHESIS:
                checker(OPENPARENTHESIS);
                    semantic_condexpr();
                    semantic_nextcondexpr();  
                if(checker(CLOSEPARENTHESIS))
                {
                }
                break;
                
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:  
                    semantic_literal();
                    semantic_nextcondexpr();
                break;

            case IDENTIFIER:
                semantic_value4();
                //semantic_identifier();
                semantic_nextcondexpr();
                break;           
            default: //addToSyntaxTable("<condexpr>","null");    
        }
    }
    
    void changeCinToGetline()
    {
        code = code.replace("cin>> "+getItem()+" ;", 
                "getline(cin, "+getItem()+");");
        
        code = code.replace("cin>> "+getItem()+";", 
                "getline(cin, "+getItem()+");");
    }
    
    void semantic_assignmentOperator()
    {
        switch(token)
        {
            case EQUAL:
                checker(EQUAL);
                semantic_operand();
                break;
            
            case OPENPARENTHESIS: 
                semantic_interlude();
        }
    }
    
    void semantic_interlude()
    {
        String funcName = getItem();
        String line = tblLexeme.getModel().getValueAt(tokenPos-2, 2).toString();
        String column = tblLexeme.getModel().getValueAt(tokenPos-2, 3).toString();
        
        
        checker(OPENPARENTHESIS);
            checkIfFunctionName(funcName,line,column);
            isFunction = true;
            semanticArguments();
            if(checker(CLOSEPARENTHESIS))
            {
                checkTransferedParameters(funcName);
                isFunction=false;
            }

    }
    
    void checkTransferedParameters(String functionName)
    {
        DefaultTableModel function = (DefaultTableModel)tblFunctionParemeters.getModel();
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int i = 0;
        int j = 0;
        int parameter_num = 0;
        ArrayList<Integer> parameter_num_index = new ArrayList<>();
        
        while(i < function.getRowCount())
        {
            if(tblFunctionParemeters.getValueAt(i, 0).toString().equals(functionName))
            {
                parameter_num++;
                parameter_num_index.add(i);            
            }
                i++;
        }
        if(parameter_num < argumentIdentifier.size())
        {
             semanticerror.addRow(new Object[] {argumentIdentifier.toString(), "Passed Arguments is Greater Than Required", tblLexeme.getModel().getValueAt(tokenPos-2, 2)});   
        }
        else if(parameter_num > argumentIdentifier.size())
        {
            semanticerror.addRow(new Object[] {argumentIdentifier.toString(), "Passed Arguments is Less Than Required", tblLexeme.getModel().getValueAt(tokenPos-2, 2)});   
        }
        else
        {         
            for(j = 0; j < parameter_num_index.size(); j++)
            {
                if(checkSameDataTypeParameters(tblFunctionParemeters.getValueAt(parameter_num_index.get(j), 3).toString(), argumentDataType.get(j),parameter_num_index.get(j), j, parameter_num) == false)
                {
                    break;
                }
            } 
        }
        argumentIdentifier.clear();
        argumentDataType.clear();
    }
    
    boolean checkSameDataTypeParameters(String datatype,String datatype1, int i, int j, int numParameter)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        if(datatype.equals(datatype1))
            return true;
        else if(datatype.equals("INT") && datatype1.equals("FLOAT"))
            return true;
        else if(datatype.equals("FLOAT") && datatype1.equals("INT"))
            return true;
        else if(datatype1 == null)
            return true;
        else
        {
           semanticerror.addRow(new Object[] {argumentIdentifier.get(j), "Incompatible Types: "+tblFunctionParemeters.getValueAt(i, 3)+" Cannot be converted to "+argumentDataType.get(j), tblLexeme.getModel().getValueAt(tokenPos-2, 2)});   
           return false;
        }
    }
    
    void semanticArguments()
    {
        switch(token)
        {
            case IDENTIFIER: case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                semantic_operand();
                semanticNextArguments();
            break;
        }
    }   
    
    void semanticNextArguments()
    {
        if(checker(COMMA))
        {
            isFunction = true;
            semantic_operand();
            semanticNextArguments();
        }
    }
    
    void checkIfFunctionName(String functionName, String line, String column)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow = tblFunctionParemeters.getRowCount();
        int i;
        boolean var = false, var1 = false;
        for( i = 0; i < identifierrow; i++)
        {
            if(functionName.equals(tblFunctionParemeters.getValueAt(i, 0).toString()))
            {
                var = true;
            }
        }
        
        int identifierrow1 = tblIdentifier.getRowCount();
        int k;
        for(k = 0; k < identifierrow1; k++)
        {
            if(functionName.equals(tblIdentifier.getValueAt(k, 0).toString()))
            {
                var1 = true;
            }
        }
        
        if(var == false && var1 == false)
            semanticerror.addRow(new Object[] {functionName, "Function "+functionName+" was NOT Defined.", "Line: "+line+ " Column: "+column});
    }

    void semantic_operand()
    {
        switch(token)
        {
            case IDENTIFIER: case INTEGERLITERAL: case FLOATLITERAL:
            case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                semantic_value2();
                if(isFunction == true)
                {
                    String text = getItem();
                    argumentIdentifier.add(text);
                    argumentDataType.add(datatype);
                    isFunction = false;
                }
                semantic_unary();
                semantic_nextOperand1();
                break;
                
            case OPENPARENTHESIS:
                semantic_mathexpr();
                break;
        }
    }
    
    void semantic_nextOperand1()
    {
        switch(token)
        {
            case PLUS: case MINUS: case MULTIPLY: case DIVIDE: case MODULUS: 
                semantic_operator();
                semantic_operand();
                semantic_nextOperand1();
                break;
        }
    }
    
    void semantic_operator()
    {
        switch(token)
        {
            case PLUS: 
                checker(PLUS);
                //checkOperands();
                break;
            case MINUS:
                checker(MINUS);
                break;
            case MULTIPLY:
                checker(MULTIPLY);
                break;
            case DIVIDE:
                checker(DIVIDE);
                break;
            case MODULUS:
                checker(MODULUS);
                break;
        }
    }
    
    void semantic_unary()
    {
        switch(token)
        {
            case INCREMENT:
                checker(INCREMENT);
                break;
            case DECREMENT:
                checker(DECREMENT);
                break;
        }
    }

    void semantic_nextInput()
    {
        if(checker(COMMA))
        {
            if(checker(IDENTIFIER))
            {
                if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkIfDefined(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    identifier = text;
                    interlude_checkIfDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkAlreadyDefined(text);
                }
                semantic_nextInput();
            }
        }
    }

    void semantic_valueInitialize()
    {
        if(checker(EQUAL))
        {
            semantic_value2();
            if(scope == "function")
                addToFunctionTable();
            else 
                addToLocalDeclarationTable();
        }
        else if(checker(OPENBRACKET))
        {
            semantic_const_arraySize();
            array1D = arraySize;
            if(checker(CLOSEBRACKET))
            {
                semantic_2dArray();
            }
            if(scope == "function")
                addToFunctionTable();
            else 
                addToLocalDeclarationTable();
        }
        else if(checker(TILDE))
        {
            semantic_structMemberCheck();
        }
        else
        {
            checkNotInitialized(); //if variable was not initialized a value, values will be set to default accordign to datatype
            value = Default;
            if(scope == "function")
                addToFunctionTable();
            else 
                addToLocalDeclarationTable();
        }
        //arraySize = null;
    }
    
    void semantic_nextOutput()
    {
        if(checker(PERIOD))
        {
            semantic_value4();
            semantic_nextOutput();
        }
    }
    boolean is2dArray = false;
    int array2dCopy = 0;
    void semantic_2dArray()
    {
        switch(token)
        {
            case EQUAL: //array values
                checker(EQUAL);
                if(checker(OPENCURLYBRACE))
                {
                    semantic_value2();
                    ArrayValues.add(value);
                    countArray1D = countArray1D + 1;
                    check1DSize();
                    semantic_nextValue();
                    countArray1D = 0;
                    countArray2D2 = 0;
                    if(checker(CLOSECURLYBRACE))
                    {
                        store1DValues();
                    }
                }
                break;
                
            case OPENBRACKET: //2darray
                checker(OPENBRACKET);
                is2dArray = true;
                semantic_const_arraySize();
                array2d = arraySize;
                array2dCopy = Integer.parseInt(arraySize);
                if(checker(CLOSEBRACKET))
                {
                    semantic_2dArrayValue();
                }
                break;
                
            default: store1DValues();
        }       
    }

    void semantic_2dArrayValue()
    {
        switch(token)
        {
            case EQUAL:
                checker(EQUAL);
                if(checker(OPENCURLYBRACE))
                {
                    if(checker(OPENCURLYBRACE))
                    {
                        semantic_value2();
                        ArrayValues.add(value);
                        countArray2D2 = countArray2D2 + 1;
                        check2D2Size();
                        semantic_nextValue();
                        ArrayValues.add("@");
                        countArraySeparator++;
                        countArray2D1 = countArray2D1 + 1;
                        check2D1Size();
                        countArray2D2 = 0;
                        if(checker(CLOSECURLYBRACE))
                        {
                            semantic_nextElement();
                            countArray1D = 0;
                            countArray2D1 = 0;
                            countArray2D2 = 0;
                            if(checker(CLOSECURLYBRACE))
                            {
                                store2DValues();
                            }
                        }
                    }
                }
                break;
                
            default: store2DValues(); 
        }
    }
    
    void semantic_nextElement()
    {
        switch(token)
        {
            case COMMA:
                checker(COMMA);
                if(checker(OPENCURLYBRACE))
                {
                    semantic_value2();
                    ArrayValues.add(value);
                    countArray2D2 = countArray2D2 + 1;
                    check2D2Size();
                    semantic_nextValue();
                    ArrayValues.add("@");
                    countArraySeparator++;
                    countArray2D1 = countArray2D1 + 1;
                    check2D1Size();
                    countArray2D2 = 0;
                    if(checker(CLOSECURLYBRACE))
                    {
                        semantic_nextElement();
                    }
                }
                break;
        }
    }
    
    void store1DValues()
    {
        DefaultTableModel identifier1 = (DefaultTableModel)tblIdentifier.getModel();
        DefaultTableModel array = (DefaultTableModel)tblArray.getModel();
        int ctr=0;
        checkNotInitialized();
        for(ctr = 0; ctr< Integer.parseInt(array1D); ctr++)
        {
            if(ctr >= ArrayValues.size())
            {
                identifier1.addRow(new Object[] {identifier+"["+ctr+"]", Default, parentDataType});
                array.addRow(new Object[] {identifier, ctr, "null", Default, parentDataType});
            }
            else
            {
                identifier1.addRow(new Object[] {identifier+"["+ctr+"]", ArrayValues.get(ctr), parentDataType});
                array.addRow(new Object[] {identifier, ctr, "null",ArrayValues.get(ctr), parentDataType});
            }
        }
        ArrayValues.clear();
        value = "Array";
    }
    
    void store2DValues()
    {
        DefaultTableModel identifier1 = (DefaultTableModel)tblIdentifier.getModel();
        DefaultTableModel array = (DefaultTableModel)tblArray.getModel();
        int ctr=0,ctr1=0,count=0;
        checkNotInitialized();
        for(ctr = 0; ctr<Integer.parseInt(array1D); ctr++)
        {
            if(count<(ArrayValues.size()-countArraySeparator))
            {
                do
                {
                    identifier1.addRow(new Object[] {identifier+"["+ctr+"]"+"["+ctr1+"]", ArrayValues.get(count), parentDataType});
                    array.addRow(new Object[] {identifier, ctr, ctr1, ArrayValues.get(count), parentDataType});
                    ctr1++;
                    count++;
                }while(!ArrayValues.get(count).equals("@"));
                count++;
                
                if(ctr1<=Integer.parseInt(array2d))
                {
                    do
                    {
                        identifier1.addRow(new Object[] {identifier+"["+ctr+"]"+"["+ctr1+"]", Default, parentDataType});     
                        array.addRow(new Object[] {identifier, ctr, ctr1-Integer.parseInt(array2d), Default, parentDataType});
                        ctr1++;
                    }while(ctr1 < (Integer.parseInt(array2d)));
                }
            }
            else
            {
                do
                {
                    identifier1.addRow(new Object[] {identifier+"["+ctr+"]"+"["+ctr1+"]", Default, parentDataType});     
                    array.addRow(new Object[] {identifier, ctr, ctr1-Integer.parseInt(array2d), Default, parentDataType});
                    ctr1++;
                }while(ctr1 < (Integer.parseInt(array2d)));
                ctr1=0;
            }
        }
        ArrayValues.clear();
        value = "Array";
        array2d = null;
    }
    
    void semantic_nextValue()
    {
        if(checker(COMMA))
        {
            semantic_value3();
            ArrayValues.add(value);
            if(countArray2D2 == 0)
            {
                countArray1D++;
                check1DSize();
            }
            if(countArray2D2 > 0)
            {
                countArray2D2++;
                check2D2Size();
            }
            semantic_nextValue();
        }
    }
    
    void check2D2Size()
    {
      if(countArray2D2 > Integer.parseInt(array2d))
        {
            errorCode = 7;
            addToSemanticErrorTable(errorCode);
        }  
    }
    
    void check1DSize()
    {
        int errorCode=0;
        if(countArray1D > Integer.parseInt(array1D))
        {
            errorCode = 6;
            addToSemanticErrorTable(errorCode);
        }
    }
    
    void check2D1Size()
    {
        int errorCode = 0;
        if(countArray2D1 > Integer.parseInt(array1D))
        {
            errorCode = 8;
            addToSemanticErrorTable(errorCode);
        }
    }

    void semantic_value3()
    {
        switch(token)
        {
            case IDENTIFIER:
                if(checker(IDENTIFIER))
                {
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkIfDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkIfDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);
                    }
                    IDArray = getItem();
                    semantic_extension();
                }
                break;
            
            case INTEGERLITERAL: case FLOATLITERAL: case CHARLITERAL: case STRINGLITERAL: case BOOLLITERAL:
                semantic_value();
                break;
                
        }
    }
    
    void semantic_arraySize()
    {
        switch(token)
        {
            case IDENTIFIER: case INTEGERLITERAL:
                semantic_value1();
                break;
                
            case OPENPARENTHESIS: //mathexpr
                semantic_mathexpr();
                break;
        }
    }
    
    void semantic_value1()
    {
        switch(token)
        {
            case IDENTIFIER:
                checker(IDENTIFIER);
                if(scope == "concert")
                {
                    String text = getItem();
                    identifier = text;
                    concert_checkIfDefined(text);
                }
                else if(scope == "function")
                {
                    String text = getItem();
                    identifier = text;
                    interlude_checkIfDefined(text);
                }
                else
                {
                    String text = getItem();
                    identifier = text;
                    checkIfDefined(text);
                }
                break;
            
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                value = getItem();
                datatype = "INT";
                literalType = "INT Literal";
                arraySize = getItem();
                checkArraySize(Integer.parseInt(arraySize));
                break;
        }
    }
    
    void checkArraySize(int arraySizeValue)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow = tblLocalDeclaration.getRowCount(),i=0,size=0,size1=0; boolean flag = false, flag1 = false;
        if(arraySizeValue > 1000 || arraySizeValue < 1)
        {
            errorCode = 2; //wrong array size;
            addToSemanticErrorTable(2);
        }
        else if(isFromAssignment==true)
        {
            for(i = 0; i < identifierrow; i++)
            {
                if(identifier.equals(tblLocalDeclaration.getValueAt(i, 0).toString()) && tblLocalDeclaration.getValueAt(i, 1).toString() == "Array")
                {
                    flag = true; break;
                }
            }
            size = Integer.parseInt(tblLocalDeclaration.getValueAt(i, 3).toString());
            if(flag == true)
            {
                if(arraySizeValue > size)
                    semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Array Index Out of Bounds "+size+ " >= "+arraySizeValue, "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
            }
            
            if(is2dArray == true) //check 2darray size
            {
                
                for(i = 0; i < identifierrow; i++)
                {
                    if(identifier.equals(tblLocalDeclaration.getValueAt(i, 0).toString()) && tblLocalDeclaration.getValueAt(i, 1).toString() == "Array")
                    {
                        flag1 = true; break;
                    }
                }
                size1 = Integer.parseInt(tblLocalDeclaration.getValueAt(i, 4).toString());
                if(flag1 == true)
                {
                    if(arraySizeValue > size1)
                        semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Array Index Out of Bounds "+size1+ " >= "+arraySizeValue, "Line: "+ tblLexeme.getModel().getValueAt(tokenPos-2, 2)+" Column "+tblLexeme.getModel().getValueAt(tokenPos-2, 3)}); 
                }
            }
            is2dArray = false;
            isFromAssignment=false;
        }
        return;
    }
    
    void semantic_nextVariable()
    {
        switch(token)
        {
            case COMMA:
                checker(COMMA);
                if(checker(IDENTIFIER))
                {
                    if(scope == "concert")
                    {
                        String text = getItem();
                        identifier = text;
                        concert_checkAlreadyDefined(text);
                    }
                    else if(scope == "function")
                    {
                        String text = getItem();
                        identifier = text;
                        interlude_checkAlreadyDefined(text);
                    }
                    else
                    {
                        String text = getItem();
                        identifier = text;
                        checkAlreadyDefined(text);
                    }
                    semantic_valueInitialize();
                    semantic_nextVariable();
                }
            break;
        }
    }
    
    void semantic_value()
    {
        switch(token)
        {
            case IDENTIFIER:
                
                break;
            
            case INTEGERLITERAL:
                checker(INTEGERLITERAL);
                value = getItem();
                datatype = "INT";
                literalType = "INT Literal";
                break;
                
            case FLOATLITERAL:
                checker(FLOATLITERAL);
                value = getItem();
                datatype = "FLOAT";
                literalType = "FLOAT Literal";
                break;
                
            case CHARLITERAL:
                checker(CHARLITERAL);
                value = getItem();
                datatype = "CHAR";
                literalType = "CHAR Literal";
                break;
                
            case STRINGLITERAL:
                checker(STRINGLITERAL);
                value = getItem();
                datatype = "STRING";
                literalType = "STRING Literal";
                break;
                
            case BOOLLITERAL:
                checker(BOOLLITERAL);
                value = getItem();
                datatype = "BOOL";
                literalType = "BOOL Literal";
                break;
                //s
        }
    }
   
    void semantic_checkIfConstant(String identifier)
    {
        boolean isConstantDeclared = false, isLocallyDeclared = false; 
        
        int identifierrow = tblConstantDeclaration.getRowCount();
        for(int i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblConstantDeclaration.getValueAt(i, 0).toString()))
            {
                isConstantDeclared = true;
            }
        }
        
        int identifierrow1 = tblLocalDeclaration.getRowCount();
        for(int i = 0; i < identifierrow1; i++)
        {
            if(identifier.equals(tblLocalDeclaration.getValueAt(i, 0).toString()))
            {
                isLocallyDeclared = true;
            }
        }
        
        if(isConstantDeclared==true && isLocallyDeclared==false)
        {
            errorCode = 5;
            addToSemanticErrorTable(errorCode);
        }
        
    }
    
    void concert_checkAlreadyDefined(String identifier)
    {
       // System.out.println("ID: "+identifier);
//        int identifierrow = tblIdentifier.getRowCount();
//        for(int i = 0; i < identifierrow; i++)
//        {
//            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
//            {
//                errorCode = 1;
//                addToSemanticErrorTable(errorCode);
//            }
//        }
        
        int identifierrow1 = tblLocalDeclaration.getRowCount();
        for(int i = 0; i < identifierrow1; i++)
        {
            if(identifier.equals(tblLocalDeclaration.getValueAt(i, 0).toString()))
            {
                errorCode = 1;
                addToSemanticErrorTable(errorCode);
            }
        }
      
     }
    
    void concert_checkIfDefined(String identifier)
    {
        boolean isDefined = false, isDefined1 = false;
        int identifierrow = tblIdentifier.getRowCount();
        int i,k;
        for(i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                isDefined = true;
                break;
            }
        }
        
        int identifierrow1 = tblLocalDeclaration.getRowCount();
        for(k = 0; k < identifierrow1; k++)
        {
            if(identifier.equals(tblLocalDeclaration.getValueAt(k, 0).toString()))
            {
                isDefined1 = true;
                break;
            }
        }
        
        if(isDefined == false && isDefined1 == false)
        {
            errorCode = 4;
            addToSemanticErrorTable(errorCode);
        }
        else if(i < identifierrow)
        {
            datatype = tblIdentifier.getValueAt(i,2).toString();
            value = tblIdentifier.getValueAt(i,1).toString();
            literalType = datatype;
        }
        else if(k < identifierrow1)
        {
            datatype = tblLocalDeclaration.getValueAt(k,2).toString();
            value = tblLocalDeclaration.getValueAt(k,1).toString();
            literalType = datatype;
        }
        arraySize = value; 
     }
    
    void interlude_checkAlreadyDefined(String identifier)
    {
        int identifierrow = tblIdentifier.getRowCount();
        for(int i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                errorCode = 3;
                addToSemanticErrorTable(3);
            }
        }
        
        int identifierrow1 = tblFunctionDeclaration.getRowCount();
        for(int i = 0; i < identifierrow1; i++)
        {
            if(functionName.equals(tblFunctionDeclaration.getValueAt(i, 0).toString()) && 
                identifier.equals(tblFunctionDeclaration.getValueAt(i, 1).toString()))
            {
                errorCode = 3;
                addToSemanticErrorTable(3);
            }
        }
    }
    
    void interlude_checkIfDefined(String identifier)
    {
        boolean isDefined = false, isDefined1 = false;
        int i,k;
        int identifierrow = tblIdentifier.getRowCount();
        
        for(i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                isDefined = true;
                break;
            }
        }
        
        int identifierrow1 = tblFunctionDeclaration.getRowCount();
        for(k = 0; k < identifierrow1; k++)
        {
            if(functionName.equals(tblFunctionDeclaration.getValueAt(k, 0).toString()) && 
                identifier.equals(tblFunctionDeclaration.getValueAt(k, 1).toString()))
            {
                isDefined1 = true;
                break;
            }
        }
        
        
        if(isDefined == false && isDefined1 == false)
        {
            errorCode = 4;
            addToSemanticErrorTable(errorCode);
        }
        else if(i < identifierrow)
        {
            datatype = tblIdentifier.getValueAt(i, 2).toString();
            value = tblIdentifier.getValueAt(i, 1).toString();
            literalType = datatype;
        }
        else if(k < identifierrow1)
        {
            datatype = tblFunctionDeclaration.getValueAt(k, 3).toString();
            value = tblFunctionDeclaration.getValueAt(k, 2).toString();
            literalType = datatype;
        }
    }
    
    void checkAlreadyDefined(String identifier)
    {
        int identifierrow = tblIdentifier.getRowCount();
        for(int i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                errorCode = 3;
                addToSemanticErrorTable(3);
            }
        }
    }
    
    void checkIfDefined(String identifier)
    {
        boolean isDefined = false;
        int identifierrow = tblIdentifier.getRowCount();
        int i;
        for(i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                isDefined = true;
                break;
            }
        }
        
        if(isDefined == false)
        {
            errorCode = 4;
            addToSemanticErrorTable(errorCode);
        }
        else
        {
            datatype = tblIdentifier.getValueAt(i, 2).toString();
            value = tblIdentifier.getValueAt(i, 1).toString();
            literalType = datatype;
        }
    }
    
    void concert_checkInt(String identifier)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow = tblLocalDeclaration.getRowCount();
        int i; boolean flagLocal = false, flagIdentifier = false;
        for(i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblLocalDeclaration.getValueAt(i, 0).toString()))
            {
                flagLocal=true;
                break;
            }
        }
        
        
        int identifierrow1 = tblIdentifier.getRowCount();
        int k;
        for(k = 0; k < identifierrow1; k++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(k, 0).toString()))
            {
                flagIdentifier=true;
                break;
            }
        }
        int errorCode = 0;
        if(i == (identifierrow) && k == identifierrow1) //undeclared variable
        {
            errorCode = 9;
            addToSemanticErrorTable(errorCode);
        }
        else if(i < identifierrow && !tblLocalDeclaration.getValueAt(i, 2).toString().equals("INT") && flagIdentifier == false) //variable is declared in LOCAL but different data type 
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+tblLocalDeclaration.getValueAt(i, 2).toString()+" Cannot be converted to INT", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
        else if(k < identifierrow1 && !tblIdentifier.getValueAt(k, 2).toString().equals("INT") && flagLocal == false) //variable is declared in CONST or GLOBAL but different data type
        {
            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+tblIdentifier.getValueAt(k, 2).toString()+" Cannot be converted to INT", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
        else if((flagLocal == false) && (flagIdentifier == true))
        {
            arraySize = tblIdentifier.getValueAt(k, 1).toString();    
        }
        else
        {
            if(!tblLocalDeclaration.getValueAt(i, 2).toString().equals("INT"))
            {
                semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+tblLocalDeclaration.getValueAt(i, 2).toString()+" Cannot be converted to INT", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
            }
            else
            {
               if(!tblLocalDeclaration.getValueAt(i, 2).toString().equals("INT"))
               {
                    semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+tblLocalDeclaration.getValueAt(i, 2).toString()+" Cannot be converted to INT", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
               }
               else if(flagLocal==true && flagIdentifier==true)
               {
                   arraySize = tblLocalDeclaration.getValueAt(i, 1).toString();
               }
               else if(flagLocal==true && flagIdentifier==false)
               {
                    arraySize = tblLocalDeclaration.getValueAt(i, 1).toString();    
               }
            }
        }
    }
    
    void checkInt(String identifier)
    {
        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
        int identifierrow = tblIdentifier.getRowCount();
        int i;
        for(i = 0; i < identifierrow; i++)
        {
            if(identifier.equals(tblIdentifier.getValueAt(i, 0).toString()))
            {
                break;
            }
        }
        
        if(i == (identifierrow))
        {
            addToSemanticErrorTable(9);
            //semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenPos-2, 0)+" is NOT Defined", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
        }
        else
        {
            if(!tblIdentifier.getValueAt(i, 2).toString().equals("INT"))
            {
                semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenPos-2, 0),"Incompatible Types: "+tblIdentifier.getValueAt(i, 2).toString()+" Cannot be converted to INT", tblLexeme.getModel().getValueAt(tokenPos-2, 2)}); 
            }
            else
            {
                arraySize = tblIdentifier.getValueAt(i, 1).toString();               
            }
        }
    }
    
    void interlude_checkInt(String identifier)
    {
//        DefaultTableModel semanticerror = (DefaultTableModel)tblErrorSemantic.getModel();
//        int identifierrow = tblFunctionDeclaration.getRowCount();
//        int i;
//        for(i = 0; i < identifierrow; i++)
//        {
//            if(function_name.equals(tblFunctionDeclaration.getValueAt(i, 0).toString()) && 
//                    identifier.equals(tblFunctionDeclaration.getValueAt(i, 1).toString()))
//            {
//                break;
//            }
//        }
//        
//        
//        int identifierrow1 = tblIdentifier.getRowCount();
//        int k;
//        for(k = 0; k < identifierrow1; k++)
//        {
//            if(identifier.equals(tblIdentifier.getValueAt(k, 0).toString()))
//            {
//                break;
//            }
//        }
//        
//        if(i == (identifierrow) && k == identifierrow1)
//        {     
//            semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenpost-2, 0), "Variable "+tblLexeme.getModel().getValueAt(tokenpost-2, 0)+" is NOT Defined", tblLexeme.getModel().getValueAt(tokenpost-2, 2)}); 
//        }else if(i < identifierrow && !tblFunctionDeclaration.getValueAt(i, 3).toString().equals("HASHTAG")){
//             semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenpost-2, 0),"Incompatible Types: "+tblFunctionDeclaration.getValueAt(i, 3).toString()+" Cannot be converted to HASHTAG", tblLexeme.getModel().getValueAt(tokenpost-2, 2)}); 
//        }else if(k < identifierrow1 && !tblIdentifier.getValueAt(k, 2).toString().equals("HASHTAG")){
//             semanticerror.addRow(new Object[] {tblLexeme.getModel().getValueAt(tokenpost-2, 0),"Incompatible Types: "+tblIdentifier.getValueAt(k, 2).toString()+" Cannot be converted to HASHTAG", tblLexeme.getModel().getValueAt(tokenpost-2, 2)}); 
//        }
    }

       
    private void LexicalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LexicalMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_LexicalMouseReleased
    String code="#include <iostream>\n #include <cstdlib>\n  #include <exception>\n #include <iomanip>\n using namespace std; int main ( ) { std::cout << std::setprecision(4) << std::fixed; system(\"pause\");\n" +
" return 0;}";
    
    private void LexicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LexicalActionPerformed
        // TODO add your handling code hcoere:
    }//GEN-LAST:event_LexicalActionPerformed

    private void btnSemanticMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemanticMousePressed
        // TODO add your handling code here:
        reInitialize(); //re-initialize globbal variables
        
        DefaultTableModel modelConstantDec = (DefaultTableModel) tblConstantDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelGlobalDec = (DefaultTableModel) tblGlobalDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelLocalDec = (DefaultTableModel) tblLocalDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelIdentifier = (DefaultTableModel) tblIdentifier.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionParameters = (DefaultTableModel) tblFunctionParemeters.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionDeclaration = (DefaultTableModel) tblFunctionDeclaration.getModel(); //Table for Semantic
        DefaultTableModel modelFunctionReturn = (DefaultTableModel) tblFunctionReturn.getModel(); //Table for Semantic
        DefaultTableModel modelArray = (DefaultTableModel) tblArray.getModel(); //Table for Semantic
        DefaultTableModel errorSemantic = (DefaultTableModel) tblErrorSemantic.getModel();
       
        //Clearing
        modelConstantDec.setRowCount(0);
        modelGlobalDec.setRowCount(0);
        modelLocalDec.setRowCount(0);
        modelIdentifier.setRowCount(0);
        errorSemantic.setRowCount(0);
        modelFunctionParameters.setRowCount(0);
        modelFunctionDeclaration.setRowCount(0);
        modelFunctionReturn.setRowCount(0);
        modelArray.setRowCount(0);
        //
        System.out.println("code: \n"+code);
        tokenPos = 0;
        removeNotNeed();
        token = getToken();
        semantic_program();
        
        tabErrorTables.setSelectedIndex(2);
        tabMainTables.setSelectedIndex(2);
        
        if(tblErrorSemantic.getRowCount() == 0) //check the error table of Syntax Error Table and THERE IS NO ERROR
            JOptionPane.showMessageDialog(null, "No Semantic Error Detected!");
        else
            JOptionPane.showMessageDialog(null, "Semantic Error Detected!");
    }//GEN-LAST:event_btnSemanticMousePressed

    private void btnSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMousePressed
        // TODO add your handling code here:
        String FileName = JOptionPane.showInputDialog(null, "File Name: ");
        FileWriter fstream;
        try 
        {
            File f = new File(new File(".").getAbsolutePath()+"\\Files\\"+FileName+".txt");
            if(f.exists()) 
            { 
                JOptionPane.showMessageDialog(null, "File Already Exists. Try a Different Filename.");
            }
            else if(FileName.equals("") == false)
            {
                fstream = new FileWriter(new File(".").getAbsolutePath()+"//Files//"+FileName+".txt",true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(txtareaCompiler.getText());
                out.newLine();
                out.close();
                JOptionPane.showMessageDialog(null, FileName+" Was Saved Successfully!");
                lblFileName.setText(" "+FileName);
            }
        }
        catch (IOException ex) 
        {
            Logger.getLogger(OrchestraFrame.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnSaveMousePressed

    private void btnChooseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChooseMousePressed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(new File(".").getAbsolutePath()+"\\Files");
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = jfc.getSelectedFile();
            String content;
            try 
            {
                content = new Scanner(new File(selectedFile.getAbsolutePath())).useDelimiter("\\Z").next();
                String filename[] = selectedFile.getName().split("\\.");
                lblFileName.setText(filename[0]);
                txtareaCompiler.setText(content);
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(OrchestraFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChooseMousePressed

    private void btnRunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRunMousePressed
        // TODO add your handling code here:
        new Thread(new Runnable() {
            @Override
            public void run() {
                String FileName = lblFileName.getText();
                if(FileName == null )
                {        
                }
                else if(FileName.trim().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter a Valid File Name!");
                }
                else
                {
                    File file = new File(new File(".").getAbsolutePath()+"\\programs\\"+FileName+".cpp");
                    FileWriter out = null;
                    try
                    {
                        out = new FileWriter(file);
                        out.write(code);
                        out.close();
                    }
                    catch (IOException ex) 
                    {
                        Logger.getLogger(OrchestraFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String[] command =
                    {
                        "cmd",
                    };
                    Process p;
                    try
                    {
                        p = Runtime.getRuntime().exec(command);
                        PrintWriter stdin = new PrintWriter(p.getOutputStream());
                        stdin.println("cd "+new File(".").getAbsolutePath()+"\\programs\"");
                        stdin.println("g++ -o "+FileName+" "+FileName+".cpp && del "+FileName+".cpp && start "+FileName+".exe");
                        stdin.close();

                        String line = "";

                        BufferedReader errorReader = new BufferedReader(
                                new InputStreamReader(p.getErrorStream()));
                        while ((line = errorReader.readLine()) != null) 
                        {
                            System.out.println(line);
                        }
                        errorReader.close();
                        p.waitFor();
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("SUCCESS RUN");
    }//GEN-LAST:event_btnRunMousePressed

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSyntaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSyntaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSyntaxActionPerformed

    private void btnSyntaxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSyntaxMousePressed
        // TODO add your handling code here:
        DefaultTableModel modelSyntax = (DefaultTableModel) tblSyntax.getModel(); //Table for Syntax
        DefaultTableModel errorSyntax = (DefaultTableModel) tblErrorSyntax.getModel();
        int rowModelSyntax = modelSyntax.getRowCount();
        int rowErrorSyntax = errorSyntax.getRowCount();

        for(int ctr = rowModelSyntax-1; ctr>=0; ctr--)
        modelSyntax.removeRow(ctr);

        for(int ctr1 = rowErrorSyntax-1; ctr1>=0; ctr1--)
        errorSyntax.removeRow(ctr1);
        code = "";  //translate to c++
        code = "#include <iostream>\n #include <cstdlib>\n  #include <exception>\n #include <iomanip>\n using namespace std;\n\n";
        hasError = false;
        tokenPos = 0;
        removeNotNeed();
        token = getToken();
        production_program();

        if(tblErrorSyntax.getRowCount() == 0) //check the error table of Syntax Error Table and THERE IS NO ERROR
        {
            btnSemantic.setEnabled(true);  // Enables the Syntax Button
            tabMainTables.setSelectedIndex(1);
            tabErrorTables.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "No Syntax Error Detected!");
            //playSound("Justin Bieber - Baby.wav");

        }
        else
        {
            btnSemantic.setEnabled(false);
            btnRemove.setEnabled(true);
            tabMainTables.setSelectedIndex(1);
            tabErrorTables.setSelectedIndex(1);
            //playSound("318_harry_potter_hedwigs_theme_song_music_mp3_ringtone_ringtone_mp3.wav");
            JOptionPane.showMessageDialog(null, "Syntax Error Detected!");
        }
    }//GEN-LAST:event_btnSyntaxMousePressed

    private void btnSyntaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSyntaxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSyntaxMouseClicked
    public int colNum;
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
            java.util.logging.Logger.getLogger(OrchestraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrchestraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrchestraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrchestraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrchestraFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lexical;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSemantic;
    private javax.swing.JButton btnSyntax;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JLabel lblRowCol;
    private javax.swing.JTabbedPane tabErrorTables;
    private javax.swing.JTabbedPane tabMainTables;
    private javax.swing.JTable tblArray;
    private javax.swing.JTable tblConstantDeclaration;
    private javax.swing.JTable tblError;
    private javax.swing.JTable tblErrorSemantic;
    private javax.swing.JTable tblErrorSyntax;
    private javax.swing.JTable tblFunctionDeclaration;
    private javax.swing.JTable tblFunctionParemeters;
    private javax.swing.JTable tblFunctionReturn;
    private javax.swing.JTable tblGlobalDeclaration;
    private javax.swing.JTable tblIdentifier;
    private javax.swing.JTable tblLexeme;
    private javax.swing.JTable tblLocalDeclaration;
    private javax.swing.JTable tblStructDeclaration;
    private javax.swing.JTable tblSyntax;
    private javax.swing.JTextArea txtareaCompiler;
    // End of variables declaration//GEN-END:variables
}
