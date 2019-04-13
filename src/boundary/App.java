/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.C45;
import control.ConfusionMatrix;
import entity.Data;
import control.ExcelHandler;
import control.PSO;
import entity.Particle;
import control.Reflector;
import control.SplitValidator;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author acer
 */
public class App extends javax.swing.JFrame {
    
    private List<entity.Data> data = new ArrayList<>();
    
    /**
     * Creates new form App
     */
    public App() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dashboard = new javax.swing.JPanel();
        Data = new javax.swing.JPanel();
        tittle_data = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tabel_data = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        nutritionalStatusTable = new javax.swing.JTable();
        buton_data = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        splitRatioTextField = new javax.swing.JTextField();
        numPopulationTextField = new javax.swing.JTextField();
        numIterationTextField = new javax.swing.JTextField();
        c1TextField = new javax.swing.JTextField();
        c2TextField = new javax.swing.JTextField();
        targetTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        analyzeButton = new javax.swing.JButton();
        Hasil1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        accuracyTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        cm_C45 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        cm_PSOC45 = new javax.swing.JTable();
        hasilText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel3.setText("Optimasi C4.5");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText(".");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText(".");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel6.setText("dengan PSO");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", home);

        dashboard.setLayout(new javax.swing.BoxLayout(dashboard, javax.swing.BoxLayout.LINE_AXIS));

        Data.setPreferredSize(new java.awt.Dimension(250, 541));
        Data.setLayout(new javax.swing.BoxLayout(Data, javax.swing.BoxLayout.PAGE_AXIS));

        tittle_data.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tittle_data.setPreferredSize(new java.awt.Dimension(100, 50));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Data Pasien Penyakit Ispa");

        jButton3.setText("Analyze");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tittle_dataLayout = new javax.swing.GroupLayout(tittle_data);
        tittle_data.setLayout(tittle_dataLayout);
        tittle_dataLayout.setHorizontalGroup(
            tittle_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittle_dataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tittle_dataLayout.setVerticalGroup(
            tittle_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittle_dataLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(tittle_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Data.add(tittle_data);

        tabel_data.setPreferredSize(new java.awt.Dimension(700, 166));
        tabel_data.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tabel_data.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        nutritionalStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Pendidikan", "Pekerjaan", "Penghasilan", "Ptr", "Ventilasi", "Pencahayaan", "Kelembaban", "Lantai", "Dinding", "Atap", "Ispa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nutritionalStatusTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(nutritionalStatusTable);

        tabel_data.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        Data.add(tabel_data);

        buton_data.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        buton_data.setPreferredSize(new java.awt.Dimension(211, 50));
        buton_data.setLayout(new java.awt.BorderLayout());

        jButton1.setText("Muat Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadData(evt);
            }
        });
        buton_data.add(jButton1, java.awt.BorderLayout.CENTER);

        Data.add(buton_data);

        dashboard.add(Data);

        jTabbedPane1.addTab("Dashboard", dashboard);

        splitRatioTextField.setText("0.7");

        numPopulationTextField.setText("20");

        numIterationTextField.setText("10");

        c1TextField.setText("0.91");

        c2TextField.setText("0.09");

        targetTextField.setText("0.9");

        jLabel9.setText("Split Ratio");

        jLabel11.setText("Num. Population");

        jLabel12.setText("Num. Iteration");

        jLabel13.setText("C1");

        jLabel14.setText("C2");

        jLabel15.setText("Target");

        analyzeButton.setText("Analyze");
        analyzeButton.setPreferredSize(null);
        analyzeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeButtonActionPerformed(evt);
            }
        });

        Hasil1.setBackground(new java.awt.Color(0, 0, 204));
        Hasil1.setPreferredSize(new java.awt.Dimension(50, 541));
        Hasil1.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setMaximumSize(new java.awt.Dimension(3276, 32767));
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 50));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setText("Hasil Akurasi");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel11);

        jPanel12.setPreferredSize(new java.awt.Dimension(390, 34));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jScrollPane6.setPreferredSize(new java.awt.Dimension(452, 34));

        accuracyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "C4.5", "PSO - C4.5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accuracyTable.setPreferredSize(new java.awt.Dimension(150, 32));
        jScrollPane6.setViewportView(accuracyTable);

        jPanel12.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setMaximumSize(new java.awt.Dimension(3276, 32767));
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 50));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Confusion Matrix C4.5");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel13);

        jPanel14.setPreferredSize(new java.awt.Dimension(390, 90));
        jPanel14.setLayout(new java.awt.BorderLayout());

        cm_C45.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null},
                {"2", null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cm_C45.setName(""); // NOI18N
        jScrollPane7.setViewportView(cm_C45);

        jPanel14.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel14);

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMaximumSize(new java.awt.Dimension(3276, 32767));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 50));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setText("Confusion Matrix PSO - C4.5");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.add(jPanel15);

        jPanel16.setPreferredSize(new java.awt.Dimension(390, 90));
        jPanel16.setLayout(new java.awt.BorderLayout());

        cm_PSOC45.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null},
                {"2", null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(cm_PSOC45);

        jPanel16.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel16);

        Hasil1.add(jPanel10, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analyzeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(splitRatioTextField)
                    .addComponent(numPopulationTextField)
                    .addComponent(numIterationTextField)
                    .addComponent(c1TextField)
                    .addComponent(c2TextField)
                    .addComponent(targetTextField))
                .addGap(1577, 1577, 1577))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(hasilText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(322, Short.MAX_VALUE)
                    .addComponent(Hasil1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1186, 1186, 1186)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(splitRatioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPopulationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numIterationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(analyzeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(hasilText)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Hasil1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Analysis", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadData(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadData
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView()
                .getDefaultDirectory());
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = jfc.getSelectedFile();
                ExcelHandler handler = new ExcelHandler();
                this.data = handler.read(selectedFile, 1);
                this.setDataTable(this.data);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loadData
    
    private void setDataTable(List<entity.Data> data) {
        DefaultTableModel model = (DefaultTableModel)this
                                    .nutritionalStatusTable.getModel();
        model.setRowCount(0);
        model.setColumnCount(3 + entity.Data.FEATURES.length);
        Object[] obj;
        int i = 0;
        for (entity.Data row : data) {
            obj = new Object[model.getColumnCount()];
            obj[0] = ++i;
            obj[1] = row.getNama();
            for (int j = 0; j < entity.Data.FEATURES.length; j++) {
                obj[j + 2] = Reflector.callUserFunc(entity.Data.class, row, 
                        "get" + StringUtils
                                .capitalize(entity.Data.FEATURES[j]));
            }
            obj[2 + entity.Data.FEATURES.length] = Reflector.callUserFunc(
                entity.Data.class, row, "get" + StringUtils
                        .capitalize(entity.Data.LABEL));
            model.addRow(obj);
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void analyzeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeButtonActionPerformed
        SplitValidator splitValidator = 
                new SplitValidator((ArrayList)this.data);
        Map<String, List<entity.Data>> split = splitValidator
                .stratifiedSplit(Double
                        .parseDouble(splitRatioTextField.getText()));
        List<entity.Data> trainData = split.get("train");
        List<entity.Data> testData = split.get("test");
        
        C45 clf = new C45();
        clf.fit(trainData);
        double c45Score = clf.score(testData);
        
        ConfusionMatrix cm = new ConfusionMatrix();
        for (entity.Data row : testData) {
            int predicted = clf.predictLabel(row);
            int actual = row.getIspa();
            cm.update(Integer.toString(actual), Integer.toString(predicted));
        }
        
        double c1 = Double.parseDouble(c1TextField.getText());
        double c2 = Double.parseDouble(c2TextField.getText());
        int numPopulation = Integer.parseInt(numPopulationTextField.getText());
        int numIteration = Integer.parseInt(numIterationTextField.getText());
        double target = Double.parseDouble(targetTextField.getText());
        
        PSO pso = new PSO(entity.Data.FEATURES.length, numPopulation, 
                numIteration, c1, c2, target);
        Particle bestParticle = pso.exec(trainData, testData);
        double c45PsoScore = bestParticle.getBest();
        
        C45 optimizedClf = bestParticle.getClf();
        ConfusionMatrix cmPso = new ConfusionMatrix();
        for (entity.Data row : testData) {
            int predicted = optimizedClf.predictLabel(row);
            int actual = row.getIspa();
            System.out.println(actual + "::" + predicted);
            cmPso.update(Integer.toString(actual), Integer.toString(predicted));
        }
        
        DefaultTableModel accuracyModel = (DefaultTableModel)this
                                            .accuracyTable.getModel();
        accuracyModel.setRowCount(1);
        accuracyModel.setColumnCount(2);
        accuracyModel.setValueAt((c45Score * 100) + "%", 0, 0);
        accuracyModel.setValueAt((c45PsoScore * 100) + "%", 0, 1);
        
        Map<String, Map<String, Integer>> c45Mat = cm.getMatrix();
        DefaultTableModel cmC45Model = (DefaultTableModel)this
                                        .cm_C45.getModel();
        cmC45Model.setRowCount(2);
        cmC45Model.setColumnCount(3);
        cmC45Model.setValueAt(c45Mat.get("1").get("1"), 0, 1);
        cmC45Model.setValueAt(c45Mat.get("1").get("2"), 0, 2);
        cmC45Model.setValueAt(c45Mat.get("2").get("1"), 1, 1);
        cmC45Model.setValueAt(c45Mat.get("2").get("2"), 1, 2);
        
        Map<String, Map<String, Integer>> psoC45Mat = cmPso.getMatrix();
        DefaultTableModel cmPsoC45Model = (DefaultTableModel)this
                                        .cm_PSOC45.getModel();
        cmPsoC45Model.setRowCount(2);
        cmPsoC45Model.setColumnCount(3);
        cmPsoC45Model.setValueAt(psoC45Mat.get("1").get("1"), 0, 1);
        cmPsoC45Model.setValueAt(psoC45Mat.get("1").get("2"), 0, 2);
        cmPsoC45Model.setValueAt(psoC45Mat.get("2").get("1"), 1, 1);
        cmPsoC45Model.setValueAt(psoC45Mat.get("2").get("2"), 1, 2);
    }//GEN-LAST:event_analyzeButtonActionPerformed

    private void dev() {
//        ExcelHandler exl = new ExcelHandler();
//        List<Data> data;
//        try {
//            
//            data = exl.read("/data/data.xlsx", 1);
//            SplitValidator splitValidator = new SplitValidator(data);
//            Map<String, List<Data>> split = splitValidator
//                    .stratifiedSplit(SPLIT_RATIO);
//            List<Data> trainData = split.get("train");
//            List<Data> testData = split.get("test");
//
//            C45 clf = new C45();
//            clf.fit(trainData);
////            clf.showTree();
//            System.out.println(clf.score(testData));
//            
//            int[] params = new int[] {10, 20, 40, 80, 100};
//            
//            Map<Integer, Object[]> experimentData = new HashMap<>();
//            experimentData.put(0, new Object[] {"ID", "d", "NUM_POPULATION", 
//                                    "NUM_ITERATION", "C1", "C2", "SCORE", 
//                                    "d'", "SELECTED_FEATURES"});
//            int rownum = 1;
//            for (int population : params) {
//                for (int iteration : params) {
//                    double c1 = Math.random();
//                    double c2 = Math.random();
//                    PSO pso = new PSO(Data.FEATURES.length, population, 
//                                    iteration, c1, c2, 0.9);
//                    Particle bestParticle = pso.exec(trainData, testData);
//                    double score = bestParticle.getBest();
//                    System.out.println(c1 + ", " + c2 + ": " + score);
//
//                    List<String> selectedFeatures = bestParticle
//                            .getSelectedFeatures();
//                    experimentData.put(rownum, new Object[] {rownum++, 
//                        Data.FEATURES.length, population, iteration, 
//                        c1, c2, score, selectedFeatures.size(), 
//                        Arrays.toString(selectedFeatures
//                                .toArray(new String[0]))});
//                }
//            }
//            
//            exl.write("/data/test_result.xlsx", experimentData);
//        } catch (IOException ex) {
//            Logger.getLogger(C45PSO.class.getName()).log(Level.SEVERE, 
//                    null, ex);
//        }
    }
    
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Data;
    private javax.swing.JPanel Hasil1;
    private javax.swing.JTable accuracyTable;
    private javax.swing.JButton analyzeButton;
    private javax.swing.JPanel buton_data;
    private javax.swing.JTextField c1TextField;
    private javax.swing.JTextField c2TextField;
    private javax.swing.JTable cm_C45;
    private javax.swing.JTable cm_PSOC45;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel hasilText;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField numIterationTextField;
    private javax.swing.JTextField numPopulationTextField;
    private javax.swing.JTable nutritionalStatusTable;
    private javax.swing.JTextField splitRatioTextField;
    private javax.swing.JPanel tabel_data;
    private javax.swing.JTextField targetTextField;
    private javax.swing.JPanel tittle_data;
    // End of variables declaration//GEN-END:variables
}