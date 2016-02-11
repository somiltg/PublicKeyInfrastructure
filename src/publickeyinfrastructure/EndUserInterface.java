/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author somil
 */
public class EndUserInterface extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form SystemUserInterface
     */
    private SenderTransferTable SenderTableModel;
    private ReceiverTransferTable ReceiverTableModel;
    private SenderSideTransfer SelectedSenderTransfer;
    private ReceiverSideTransfer SelectedReceiverTransfer;
    
    private boolean clearing;
    private static boolean Hostname;
    private static boolean CAHostName;
    EndUser controller;// for connecting to the controller
    /** Creates new form Dashboard
     * @param controller */
    public EndUserInterface(EndUser controller) {
        SenderTableModel = new SenderTransferTable();
        ReceiverTableModel=new ReceiverTransferTable();
        initComponents();
        //arranging the screen 
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int jFrameh=this.getSize().height;
        int jFramew=this.getSize().width;
        setLocation((dim.width-jFramew)/2,(dim.height-jFrameh)/2);
       jChangesSuccessfulLabel.setVisible(false);
        this.controller=controller;
        setTable(jSenderProgressTable,true);
        setTable(jReceiverProgressTable,false);
        //Set Settings

       jDestinationField.setText(EndUser.getDestiFolder());
       jBufferField.setText(EndUser.getBufferSize()+"");
       jAlgoBox.setSelectedIndex(EndUser.getAlgoType().equals("AES")?0:1);
       jCAIPfield.setText(EndUser.getCAIP());
       jCANameField.setText(EndUser.getCASign());
       jMyUNameField.setText(EndUser.getMyName());
        while(EndUser.getDestiFolder().isEmpty())
        {
             JOptionPane.showMessageDialog(this,"Destination folder for received files not set. Compulsory to fill this field", "Required",
                    JOptionPane.INFORMATION_MESSAGE);
             jDestinationButton.doClick();
             EndUser.setDestiFolder(jDestinationField.getText());
        } 
    }
                       
  private void setTable(JTable jTable,final boolean i)
  {
      jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          jTable.getSelectionModel().addListSelectionListener(new
                ListSelectionListener() {
        
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if(i)SenderTableSelectionChanged();
               else ReceiverTableSelectionChanged();
            }
                });
       //HEADER 
       JTableHeader header = jTable.getTableHeader();
      header.setBackground(Color.blue);
      header.setForeground(Color.white);
      //setting column width
        jTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
       jTable.getColumnModel().getColumn(5).setPreferredWidth(120);
         jTable.getColumnModel().getColumn(3).setPreferredWidth(70);
       jTable.getColumnModel().getColumn(4).setPreferredWidth(110);
       jTable.getColumnModel().getColumn(7).setPreferredWidth(110);
      Font font=new Font("Arial Black", Font.PLAIN,13 );
      header.setFont(font);
      ProgressRenderer renderer=null;
         renderer = new ProgressRenderer(0, 100);
        renderer.setStringPainted(true); // show progress text
     jTable.setDefaultRenderer(JProgressBar.class, renderer);
     CenterRenderer renderer1=new CenterRenderer();
     jTable.setDefaultRenderer(String.class, renderer1);
     
          // Set table's row height large enough to fit JProgressBar.
        jTable.setRowHeight(
                (int) renderer.getPreferredSize().getHeight());
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        jSenderTable = new javax.swing.JPanel();
        jCancelButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSenderProgressTable = new javax.swing.JTable(SenderTableModel);
        jFileLabel = new javax.swing.JLabel();
        jTransferFileField = new javax.swing.JTextField();
        jFileChooseButton = new javax.swing.JButton();
        jMessageLabel = new javax.swing.JLabel();
        jOrLabel = new javax.swing.JLabel();
        jFileChooseClear = new javax.swing.JButton();
        jMessageClearBox = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMessageArea = new javax.swing.JTextArea();
        jProxyLabel7 = new javax.swing.JLabel();
        jProxyLabel8 = new javax.swing.JLabel();
        jIPField = new javax.swing.JTextField();
        jUserNameLabel = new javax.swing.JLabel();
        jUserNameField = new javax.swing.JTextField();
        jClearButton1 = new javax.swing.JButton();
        jStartTransferButton = new javax.swing.JButton();
        jReceiverTable = new javax.swing.JPanel();
        jAcceptButton = new javax.swing.JButton();
        jFileLabel1 = new javax.swing.JLabel();
        jRequestorName = new javax.swing.JTextField();
        jFileLabel2 = new javax.swing.JLabel();
        jRequestorFileName = new javax.swing.JTextField();
        jFileLabel3 = new javax.swing.JLabel();
        jFileLabel4 = new javax.swing.JLabel();
        jRequestorIP = new javax.swing.JTextField();
        jRejectButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jReceiverProgressTable = new javax.swing.JTable(ReceiverTableModel);
        jCancelButton2 = new javax.swing.JButton();
        jClearButton2 = new javax.swing.JButton();
        jMessageLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jMessageArea1 = new javax.swing.JTextArea();
        jProxyLabel9 = new javax.swing.JLabel();
        jSettings = new javax.swing.JPanel();
        jCAIPLabel = new javax.swing.JLabel();
        jDestinationField = new javax.swing.JTextField();
        jDestinationButton = new javax.swing.JButton();
        jDestinationLabel = new javax.swing.JLabel();
        jCAIPfield = new javax.swing.JTextField();
        jBufferField = new javax.swing.JTextField();
        jApplyButton = new javax.swing.JButton();
        jCancelChangesButton = new javax.swing.JButton();
        jConnectionsLabel6 = new javax.swing.JLabel();
        jProxyLabel5 = new javax.swing.JLabel();
        jConnectionsLabel9 = new javax.swing.JLabel();
        jClearChangesButton = new javax.swing.JButton();
        jChangesSuccessfulLabel = new javax.swing.JLabel();
        jConnectionsLabel7 = new javax.swing.JLabel();
        jAlgoBox = new javax.swing.JComboBox();
        jUserName = new javax.swing.JLabel();
        jMyUNameField = new javax.swing.JTextField();
        jUserName1 = new javax.swing.JLabel();
        jCANameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("End User interface");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(176, 224, 222));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jTabbedPane1.setForeground(new java.awt.Color(58, 152, 233));
        jTabbedPane1.setToolTipText("DOWNLOAD MANAGER");
        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jSenderTable.setBackground(new java.awt.Color(217, 230, 241));
        jSenderTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSenderTable.setForeground(new java.awt.Color(67, 254, 242));
        jSenderTable.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N

        jCancelButton1.setBackground(new java.awt.Color(185, 164, 216));
        jCancelButton1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jCancelButton1.setText("Cancel");
        jCancelButton1.setActionCommand("jDownloadButton");
        jCancelButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButton1ActionPerformed(evt);
            }
        });

        jSenderProgressTable.setBackground(new java.awt.Color(239, 251, 146));
        jSenderProgressTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSenderProgressTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jSenderProgressTable.setModel(SenderTableModel);
        jSenderProgressTable.setToolTipText("Table for transfer progress");
        jSenderProgressTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(jSenderProgressTable);

        jFileLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jFileLabel.setForeground(new java.awt.Color(24, 0, 161));
        jFileLabel.setText("Choose the file to be sent");
        jFileLabel.setFocusable(false);
        jFileLabel.setRequestFocusEnabled(false);

        jTransferFileField.setEditable(false);
        jTransferFileField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jTransferFileField.setFocusable(false);
        jTransferFileField.setRequestFocusEnabled(false);

        jFileChooseButton.setBackground(new java.awt.Color(15, 25, 50));
        jFileChooseButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jFileChooseButton.setForeground(new java.awt.Color(244, 236, 236));
        jFileChooseButton.setText("Choose File...");
        jFileChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooseButtonActionPerformed(evt);
            }
        });

        jMessageLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jMessageLabel.setForeground(new java.awt.Color(24, 0, 161));
        jMessageLabel.setText("Message to send");
        jMessageLabel.setFocusable(false);
        jMessageLabel.setRequestFocusEnabled(false);

        jOrLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jOrLabel.setForeground(new java.awt.Color(161, 21, 0));
        jOrLabel.setText("OR");
        jOrLabel.setFocusable(false);
        jOrLabel.setRequestFocusEnabled(false);

        jFileChooseClear.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jFileChooseClear.setText("Clear");
        jFileChooseClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooseClearActionPerformed(evt);
            }
        });

        jMessageClearBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jMessageClearBox.setText("Clear");
        jMessageClearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMessageClearBoxActionPerformed(evt);
            }
        });

        jMessageArea.setColumns(20);
        jMessageArea.setLineWrap(true);
        jMessageArea.setRows(5);
        jScrollPane3.setViewportView(jMessageArea);

        jProxyLabel7.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jProxyLabel7.setForeground(new java.awt.Color(24, 0, 161));
        jProxyLabel7.setText("Host Address/Hostname of the Receiver:");
        jProxyLabel7.setFocusable(false);
        jProxyLabel7.setRequestFocusEnabled(false);

        jProxyLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jProxyLabel8.setForeground(new java.awt.Color(161, 17, 0));
        jProxyLabel8.setText("IPv6 not supported");
        jProxyLabel8.setFocusable(false);
        jProxyLabel8.setRequestFocusEnabled(false);

        jIPField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jIPField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jIPFieldFocusLost(evt);
            }
        });

        jUserNameLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserNameLabel.setForeground(new java.awt.Color(24, 0, 161));
        jUserNameLabel.setText("Recipient Name/ID (As registered with Certifying Authority)");
        jUserNameLabel.setFocusable(false);
        jUserNameLabel.setRequestFocusEnabled(false);

        jUserNameField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jUserNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jUserNameFieldFocusLost(evt);
            }
        });

        jClearButton1.setBackground(new java.awt.Color(185, 164, 216));
        jClearButton1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jClearButton1.setText("Clear");
        jClearButton1.setActionCommand("jDownloadButton");
        jClearButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jClearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearButton1ActionPerformed(evt);
            }
        });

        jStartTransferButton.setBackground(new java.awt.Color(185, 164, 216));
        jStartTransferButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jStartTransferButton.setText("Start Transfer Process");
        jStartTransferButton.setActionCommand("jDownloadButton");
        jStartTransferButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jStartTransferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartTransferButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jSenderTableLayout = new javax.swing.GroupLayout(jSenderTable);
        jSenderTable.setLayout(jSenderTableLayout);
        jSenderTableLayout.setHorizontalGroup(
            jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSenderTableLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jCancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jClearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(823, 823, 823))
            .addGroup(jSenderTableLayout.createSequentialGroup()
                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jMessageLabel))
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(jStartTransferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jUserNameLabel))
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jProxyLabel7)
                                .addGap(40, 40, 40)
                                .addComponent(jProxyLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jOrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jFileLabel)))
                        .addGap(116, 116, 116)
                        .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIPField, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMessageClearBox))
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFileChooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTransferFileField, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFileChooseClear)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSenderTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(706, 706, 706))
        );
        jSenderTableLayout.setVerticalGroup(
            jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSenderTableLayout.createSequentialGroup()
                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jOrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292))
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(jSenderTableLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTransferFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFileChooseClear))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jFileChooseButton)
                                .addGap(18, 18, 18)
                                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMessageClearBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jProxyLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProxyLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jStartTransferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jSenderTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jClearButton1))
                    .addGroup(jSenderTableLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCancelButton1)))
                .addGap(3890, 3890, 3890))
        );

        jTabbedPane1.addTab("Sender Interface", jSenderTable);

        jReceiverTable.setBackground(new java.awt.Color(217, 230, 241));
        jReceiverTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jReceiverTable.setForeground(new java.awt.Color(67, 254, 242));
        jReceiverTable.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N

        jAcceptButton.setBackground(new java.awt.Color(185, 164, 216));
        jAcceptButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jAcceptButton.setText("Accept");
        jAcceptButton.setActionCommand("jDownloadButton");
        jAcceptButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAcceptButtonActionPerformed(evt);
            }
        });

        jFileLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jFileLabel1.setForeground(new java.awt.Color(24, 0, 161));
        jFileLabel1.setText("Requestor Name:");
        jFileLabel1.setFocusable(false);
        jFileLabel1.setRequestFocusEnabled(false);

        jRequestorName.setEditable(false);
        jRequestorName.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jRequestorName.setFocusable(false);
        jRequestorName.setRequestFocusEnabled(false);

        jFileLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jFileLabel2.setForeground(new java.awt.Color(161, 8, 0));
        jFileLabel2.setText("NEW INCOMING REQUEST:");
        jFileLabel2.setFocusable(false);
        jFileLabel2.setRequestFocusEnabled(false);

        jRequestorFileName.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jRequestorFileName.setRequestFocusEnabled(false);
        jRequestorFileName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRequestorFileNameFocusLost(evt);
            }
        });

        jFileLabel3.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jFileLabel3.setForeground(new java.awt.Color(24, 0, 161));
        jFileLabel3.setText("Requestor IP:");
        jFileLabel3.setFocusable(false);
        jFileLabel3.setRequestFocusEnabled(false);

        jFileLabel4.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jFileLabel4.setForeground(new java.awt.Color(24, 0, 161));
        jFileLabel4.setText("Save File as:");
        jFileLabel4.setFocusable(false);
        jFileLabel4.setRequestFocusEnabled(false);

        jRequestorIP.setEditable(false);
        jRequestorIP.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jRequestorIP.setFocusable(false);
        jRequestorIP.setRequestFocusEnabled(false);

        jRejectButton.setBackground(new java.awt.Color(185, 164, 216));
        jRejectButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jRejectButton.setText("Reject");
        jRejectButton.setActionCommand("jDownloadButton");
        jRejectButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRejectButtonActionPerformed(evt);
            }
        });

        jReceiverProgressTable.setBackground(new java.awt.Color(239, 251, 146));
        jReceiverProgressTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jReceiverProgressTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jReceiverProgressTable.setModel(ReceiverTableModel);
        jReceiverProgressTable.setToolTipText("Table for receiver progress");
        jReceiverProgressTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(jReceiverProgressTable);

        jCancelButton2.setBackground(new java.awt.Color(185, 164, 216));
        jCancelButton2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jCancelButton2.setText("Cancel");
        jCancelButton2.setActionCommand("jDownloadButton");
        jCancelButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButton2ActionPerformed(evt);
            }
        });

        jClearButton2.setBackground(new java.awt.Color(185, 164, 216));
        jClearButton2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jClearButton2.setText("Clear");
        jClearButton2.setActionCommand("jDownloadButton");
        jClearButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jClearButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearButton2ActionPerformed(evt);
            }
        });

        jMessageLabel1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jMessageLabel1.setForeground(new java.awt.Color(24, 0, 161));
        jMessageLabel1.setText("Message received");
        jMessageLabel1.setFocusable(false);
        jMessageLabel1.setRequestFocusEnabled(false);

        jMessageArea1.setEditable(false);
        jMessageArea1.setBackground(new java.awt.Color(255, 250, 225));
        jMessageArea1.setColumns(20);
        jMessageArea1.setFont(new java.awt.Font("Ubuntu Light", 1, 15)); // NOI18N
        jMessageArea1.setLineWrap(true);
        jMessageArea1.setRows(5);
        jScrollPane5.setViewportView(jMessageArea1);

        jProxyLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jProxyLabel9.setForeground(new java.awt.Color(161, 17, 0));
        jProxyLabel9.setText("Location decided by Destination Folder in Settings");
        jProxyLabel9.setFocusable(false);
        jProxyLabel9.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jReceiverTableLayout = new javax.swing.GroupLayout(jReceiverTable);
        jReceiverTable.setLayout(jReceiverTableLayout);
        jReceiverTableLayout.setHorizontalGroup(
            jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jReceiverTableLayout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jFileLabel2)
                .addGap(0, 767, Short.MAX_VALUE))
            .addGroup(jReceiverTableLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jAcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(475, 475, 475))
            .addGroup(jReceiverTableLayout.createSequentialGroup()
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jReceiverTableLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jCancelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(802, 802, 802)
                        .addComponent(jClearButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jReceiverTableLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jReceiverTableLayout.createSequentialGroup()
                        .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jReceiverTableLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFileLabel1)
                                    .addComponent(jFileLabel3)
                                    .addGroup(jReceiverTableLayout.createSequentialGroup()
                                        .addComponent(jFileLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jProxyLabel9))))
                            .addGroup(jReceiverTableLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jMessageLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRequestorFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(jRequestorName, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(jRequestorIP, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jReceiverTableLayout.setVerticalGroup(
            jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jReceiverTableLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jFileLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFileLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRequestorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFileLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRequestorIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFileLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRequestorFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProxyLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAcceptButton)
                    .addComponent(jRejectButton))
                .addGap(23, 23, 23)
                .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jReceiverTableLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jReceiverTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jClearButton2)
                            .addComponent(jCancelButton2)))
                    .addComponent(jMessageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Receiver Interface", jReceiverTable);

        jSettings.setBackground(new java.awt.Color(217, 230, 241));
        jSettings.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSettings.setForeground(new java.awt.Color(67, 254, 242));
        jSettings.setAutoscrolls(true);
        jSettings.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jSettings.setPreferredSize(new java.awt.Dimension(1313, 2500));

        jCAIPLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jCAIPLabel.setForeground(new java.awt.Color(24, 0, 161));
        jCAIPLabel.setText("Certifying Authority Address/Hostname:");
        jCAIPLabel.setFocusable(false);
        jCAIPLabel.setRequestFocusEnabled(false);

        jDestinationField.setEditable(false);
        jDestinationField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jDestinationField.setFocusable(false);
        jDestinationField.setRequestFocusEnabled(false);

        jDestinationButton.setBackground(new java.awt.Color(15, 25, 50));
        jDestinationButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jDestinationButton.setForeground(new java.awt.Color(244, 236, 236));
        jDestinationButton.setText("Choose Folder...");
        jDestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDestinationButtonActionPerformed(evt);
            }
        });

        jDestinationLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jDestinationLabel.setForeground(new java.awt.Color(24, 0, 161));
        jDestinationLabel.setText("Destination folder for received files");
        jDestinationLabel.setFocusable(false);
        jDestinationLabel.setRequestFocusEnabled(false);

        jCAIPfield.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jCAIPfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAIPfieldFocusLost(evt);
            }
        });

        jBufferField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jBufferField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jBufferFieldFocusLost(evt);
            }
        });

        jApplyButton.setBackground(new java.awt.Color(185, 164, 216));
        jApplyButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jApplyButton.setText("Apply Changes");
        jApplyButton.setActionCommand("jDownloadButton");
        jApplyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jApplyButtonActionPerformed(evt);
            }
        });

        jCancelChangesButton.setBackground(new java.awt.Color(185, 164, 216));
        jCancelChangesButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jCancelChangesButton.setText("Cancel Changes");
        jCancelChangesButton.setActionCommand("jDownloadButton");
        jCancelChangesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCancelChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelChangesButtonActionPerformed(evt);
            }
        });

        jConnectionsLabel6.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jConnectionsLabel6.setForeground(new java.awt.Color(24, 0, 161));
        jConnectionsLabel6.setText("Buffer Size");
        jConnectionsLabel6.setFocusable(false);
        jConnectionsLabel6.setRequestFocusEnabled(false);

        jProxyLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jProxyLabel5.setForeground(new java.awt.Color(161, 17, 0));
        jProxyLabel5.setText("IPv6 not supported");
        jProxyLabel5.setFocusable(false);
        jProxyLabel5.setRequestFocusEnabled(false);

        jConnectionsLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jConnectionsLabel9.setForeground(new java.awt.Color(161, 17, 0));
        jConnectionsLabel9.setText("in KB, Recommended: <10 KB");
        jConnectionsLabel9.setFocusable(false);
        jConnectionsLabel9.setRequestFocusEnabled(false);

        jClearChangesButton.setBackground(new java.awt.Color(185, 164, 216));
        jClearChangesButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jClearChangesButton.setText("Clear Changes");
        jClearChangesButton.setActionCommand("jDownloadButton");
        jClearChangesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jClearChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearChangesButtonActionPerformed(evt);
            }
        });

        jChangesSuccessfulLabel.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jChangesSuccessfulLabel.setForeground(new java.awt.Color(8, 8, 8));
        jChangesSuccessfulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jChangesSuccessfulLabel.setText("Changes Applied Successfully");
        jChangesSuccessfulLabel.setFocusable(false);

        jConnectionsLabel7.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jConnectionsLabel7.setForeground(new java.awt.Color(24, 0, 161));
        jConnectionsLabel7.setText("Type of Data Encryption Algo");
        jConnectionsLabel7.setFocusable(false);
        jConnectionsLabel7.setRequestFocusEnabled(false);

        jAlgoBox.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jAlgoBox.setMaximumRowCount(2);
        jAlgoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Advanced Encryption Standard(AES)", "Data Encrytion Standard(DES)" }));

        jUserName.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName.setForeground(new java.awt.Color(251, 0, 6));
        jUserName.setText("Our UserName(as registered with Certifying Authority) ");
        jUserName.setFocusable(false);
        jUserName.setRequestFocusEnabled(false);

        jMyUNameField.setEditable(false);
        jMyUNameField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jMyUNameField.setFocusable(false);

        jUserName1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName1.setForeground(new java.awt.Color(251, 0, 6));
        jUserName1.setText("Name of the Certified Authority(as issued in certificates)");
        jUserName1.setFocusable(false);
        jUserName1.setRequestFocusEnabled(false);

        jCANameField.setEditable(false);
        jCANameField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jCANameField.setFocusable(false);

        javax.swing.GroupLayout jSettingsLayout = new javax.swing.GroupLayout(jSettings);
        jSettings.setLayout(jSettingsLayout);
        jSettingsLayout.setHorizontalGroup(
            jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSettingsLayout.createSequentialGroup()
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jSettingsLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jConnectionsLabel7)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSettingsLayout.createSequentialGroup()
                                    .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jSettingsLayout.createSequentialGroup()
                                                .addComponent(jCAIPLabel)
                                                .addGap(102, 102, 102)
                                                .addComponent(jProxyLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jSettingsLayout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(jConnectionsLabel6)
                                                .addGap(244, 244, 244)
                                                .addComponent(jConnectionsLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jUserName)
                                        .addComponent(jUserName1))
                                    .addGap(40, 40, 40)
                                    .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jMyUNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jSettingsLayout.createSequentialGroup()
                                                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCAIPfield, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jBufferField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14))
                                            .addComponent(jAlgoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jCANameField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jSettingsLayout.createSequentialGroup()
                                    .addComponent(jClearChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(148, 148, 148)
                                    .addComponent(jCancelChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(187, 187, 187)
                                    .addComponent(jApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSettingsLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jDestinationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jSettingsLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(jDestinationLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDestinationField, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jSettingsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jChangesSuccessfulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(996, Short.MAX_VALUE))
        );
        jSettingsLayout.setVerticalGroup(
            jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSettingsLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jChangesSuccessfulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDestinationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDestinationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jDestinationButton)
                .addGap(30, 30, 30)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCAIPfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAIPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProxyLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConnectionsLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jConnectionsLabel9)
                    .addComponent(jBufferField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jConnectionsLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAlgoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMyUNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCANameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jClearChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCancelChangesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1335, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Settings", jSettings);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1424, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2440, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClearChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearChangesButtonActionPerformed
        jChangesSuccessfulLabel.setForeground(Color.red);
        jChangesSuccessfulLabel.setText("Crucial Fields empty! Until applied, old settings would work...");
        jDestinationField.setText("");
        jBufferField.setText(null);
        jCAIPfield.setText(null);
        jAlgoBox.setSelectedIndex(0);
        jChangesSuccessfulLabel.setVisible(true);
        new Display(this).start();
    }//GEN-LAST:event_jClearChangesButtonActionPerformed

    private void jCancelChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelChangesButtonActionPerformed
        jDestinationField.setText(EndUser.getDestiFolder());
        jBufferField.setText(""+EndUser.getBufferSize());
        if(EndUser.getAlgoType().equals("AES"))
        jAlgoBox.setSelectedIndex(0); else   jAlgoBox.setSelectedIndex(1);
        jCAIPfield.setText(EndUser.getCAIP());
    }//GEN-LAST:event_jCancelChangesButtonActionPerformed

    private void jApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApplyButtonActionPerformed
        if(jDestinationField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Destination Folder not given", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jBufferField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Buffer Size not given", "Error",
                JOptionPane.ERROR_MESSAGE);
            jBufferField.selectAll();jBufferField.requestFocus(); return;
        }
        if( jCAIPfield.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Certifying Authority Address required in for verification", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus(); return;
        }

        EndUser.setDestiFolder(jDestinationField.getText());
        EndUser.setBufferSize(Integer.parseInt(jBufferField.getText()));
        EndUser.setCAIP(jCAIPfield.getText());
        EndUser.setAlgoType(jAlgoBox.getSelectedIndex()==1?"DES":"AES");
        jChangesSuccessfulLabel.setForeground(Color.RED);
        jChangesSuccessfulLabel.setText("Changes Applied Successfully!!");
        jChangesSuccessfulLabel.setVisible(true);
        new Display(this).start();
    }//GEN-LAST:event_jApplyButtonActionPerformed

    private void jBufferFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBufferFieldFocusLost

        int buffer;
        try
        {
            buffer=Integer.parseInt(jBufferField.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Buffer Size has to be an integer!!", "Error",
                JOptionPane.ERROR_MESSAGE);
            jBufferField.selectAll();jBufferField.requestFocus(); return;
        }
        if(buffer>1024 || buffer<=0){
            JOptionPane.showMessageDialog(this,"Illegal or too much buffer!", "Error",
                JOptionPane.ERROR_MESSAGE);
            jBufferField.selectAll();jBufferField.requestFocus(); return; }
    }//GEN-LAST:event_jBufferFieldFocusLost

    private void jCAIPfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAIPfieldFocusLost
        // TODO add your handling code here:
        String ip=jCAIPfield.getText();
        if (ip.isEmpty() ){
            return;
        }
        CAHostName=false;
        int i,num;
        for(i=0;i<ip.length();i++)
        {//to check for other characters
            if(ip.charAt(i)=='/' || Character.isLetterOrDigit(ip.charAt(i)) || ip.charAt(i)=='.' ||ip.charAt(i)==':'|| ip.charAt(i)=='-'); else break;
        }
        if(i!=ip.length())
        {
            JOptionPane.showMessageDialog(this,"Address/Hostname can only contain A_Z,0-9,.,/,-:", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus();jCAIPfield.selectAll();return;
        }
        if(ip.endsWith("http://") || ip.endsWith("https://"))
        {
            JOptionPane.showMessageDialog(this,"Incomplete names, Must have something other than protocols", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus();jCAIPfield.selectAll();return;
        }
        //to check for ipv4 checking
        StringTokenizer parts = new StringTokenizer(ip, "/.");
        if ( parts.countTokens() > 5 || parts.countTokens()<=2) {
            JOptionPane.showMessageDialog(this,"Considered Hostname", "Information",
                JOptionPane.INFORMATION_MESSAGE);CAHostName=true; return;
        }
        int n=parts.countTokens();
        for ( i=1;i<=n;i++)
        {//to check for hostname or ip
            String s=parts.nextToken().toString();
            try{
                int parseInt = Integer.parseInt( s );
            }
            catch (NumberFormatException nfe) {
                if(s.isEmpty()) {JOptionPane.showMessageDialog(this,"Invalid name or address", "Error",
                    JOptionPane.ERROR_MESSAGE); jCAIPfield.requestFocus();jCAIPfield.selectAll();return;}
            JOptionPane.showMessageDialog(this,"Considered as Hostname", "Information",
                JOptionPane.INFORMATION_MESSAGE); CAHostName=true;  return;
        }
        }
        CAHostName=false;
        parts=new StringTokenizer(ip, ".");
        if(parts.countTokens()!=4 || ip.endsWith(".") || ip.indexOf('/')!=-1)
        {
            JOptionPane.showMessageDialog(this,"Invalid IP Address", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus();jCAIPfield.selectAll(); return;
        }

        for ( i=0; i<4;i++)
        {//valid periods
            num = Integer.parseInt( parts.nextToken().toString() );
            if(num<0 || num>255) {JOptionPane.showMessageDialog(this,"Valid IP Address has periods from 0 to 255", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus();jCAIPfield.selectAll(); return;
        }
        }
    }//GEN-LAST:event_jCAIPfieldFocusLost

    private void jDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDestinationButtonActionPerformed
        if(!jDestinationField.getText().isEmpty()) return;
        JFileChooser filechooser;
        //if(controller.getDestinationFolder().equals(""))
        String filepath=jDestinationField.getText();
        filechooser=new JFileChooser();
        filechooser.removeChoosableFileFilter(filechooser.getAcceptAllFileFilter());
        filechooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.canWrite() && pathname.canExecute();
            }

            @Override
            public String getDescription() {
                return "Executable and writable folders";
            }
        });
        //else filechooser=new JFileChooser(new File(controller.getDestinationFolder()));
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setMultiSelectionEnabled(false);
        if(filechooser.showDialog(this,"Choose Folder")==JFileChooser.APPROVE_OPTION)
        {
            if(!filechooser.getSelectedFile().exists())
            { JOptionPane.showMessageDialog(this,"Invalid Folder path", "Error",
                JOptionPane.ERROR_MESSAGE); jDestinationField.setText(filepath);
        }
        else jDestinationField.setText(filechooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jDestinationButtonActionPerformed

    private void jAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAcceptButtonActionPerformed
       actionReceiverClear();
       if(jRequestorFileName.getText().isEmpty())
       {
             JOptionPane.showMessageDialog(this,"File Name Required", "Error",
                JOptionPane.ERROR_MESSAGE);
             jRequestorFileName.requestFocus();
       }
       if(!isFileValid(jRequestorFileName.getText().toString()))
       {
             JOptionPane.showMessageDialog(this,"Invalid Filename", "Error",
                JOptionPane.ERROR_MESSAGE);
             jRequestorFileName.requestFocus();           
       }    
    }//GEN-LAST:event_jAcceptButtonActionPerformed

    private void jStartTransferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartTransferButtonActionPerformed
        // TODO add your handling code here:
        SenderSideTransfer record;
        if(jTransferFileField.getText().isEmpty() && jMessageArea.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Neither any file is selected nor any message given", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jIPField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"IP of Receiver not mentioned", "Error",
                JOptionPane.ERROR_MESSAGE);
            jIPField.requestFocus(); return;
        }
        if( jUserNameField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registered Name of the receiver required for verification", "Error",
                JOptionPane.ERROR_MESSAGE);
            jUserNameField.requestFocus(); return;
        }
    if(jMessageArea.getText().isEmpty())record=new SenderSideTransfer(jUserNameField.getText(), jTransferFileField.getText(), jIPField.getText(), Hostname);
    else record=new SenderSideTransfer(Hostname, jUserNameField.getText(), jMessageArea.getText(), jIPField.getText());
    this.AddEntry(record);
    record.run();
    jIPField.setText(null);
    jMessageArea.setText(null);
    jDestinationField.setText(null);
    jUserNameField.setText(null);
    }//GEN-LAST:event_jStartTransferButtonActionPerformed

    private void jClearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearButton1ActionPerformed
        // TODO add your handling code here:
        actionSenderClear();
    }//GEN-LAST:event_jClearButton1ActionPerformed

    private void jUserNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jUserNameFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserNameFieldFocusLost

    private void jIPFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jIPFieldFocusLost
        String ip=jIPField.getText();
        Hostname=false;
        if (ip.isEmpty()) return;
        int i,num;
        for(i=0;i<ip.length();i++)
        {//to check for other characters
            if(ip.charAt(i)=='/' || Character.isLetterOrDigit(ip.charAt(i)) || ip.charAt(i)=='.' ||ip.charAt(i)==':'|| ip.charAt(i)=='-'); else break;
        }
        if(i!=ip.length())
        {
            JOptionPane.showMessageDialog(this,"Address/Hostname can only contain A_Z,0-9,.,/,-:", "Error",
                JOptionPane.ERROR_MESSAGE);
            jIPField.requestFocus();jIPField.selectAll();return;
        }
        if(ip.endsWith("http://") || ip.endsWith("https://"))
        {
            JOptionPane.showMessageDialog(this,"Incomplete names, Must have something other than protocols", "Error",
                JOptionPane.ERROR_MESSAGE);
            jIPField.requestFocus();jIPField.selectAll();return;
        }
        //to check for ipv4 checking
        StringTokenizer parts = new StringTokenizer(ip, "/.");
        if ( parts.countTokens() > 5 || parts.countTokens()<=2) {
            JOptionPane.showMessageDialog(this,"Considered Hostname", "Information",
                JOptionPane.INFORMATION_MESSAGE);Hostname=true; return;
        }
        int n=parts.countTokens();
        for ( i=1;i<=n;i++)
        {//to check for hostname or ip
            String s=parts.nextToken().toString();
            try{
                int parseInt = Integer.parseInt( s );
            }
            catch (NumberFormatException nfe) {
                if(s.isEmpty()) {JOptionPane.showMessageDialog(this,"Invalid name or address", "Error",
                    JOptionPane.ERROR_MESSAGE); jIPField.requestFocus();jIPField.selectAll();return;}
            JOptionPane.showMessageDialog(this,"Considered as Hostname", "Information",
                JOptionPane.INFORMATION_MESSAGE); Hostname=true; return;
        }
        }
        Hostname=false;
        parts=new StringTokenizer(ip, ".");
        if(parts.countTokens()!=4 || ip.endsWith(".") || ip.indexOf('/')!=-1)
        {
            JOptionPane.showMessageDialog(this,"Invalid IP Address", "Error",
                JOptionPane.ERROR_MESSAGE);
            jIPField.requestFocus();jIPField.selectAll(); return;
        }

        for ( i=0; i<4;i++)
        {//valid periods
            num = Integer.parseInt( parts.nextToken().toString() );
            if(num<0 || num>255) {JOptionPane.showMessageDialog(this,"Valid IP Address has periods from 0 to 255", "Error",
                JOptionPane.ERROR_MESSAGE);
            jIPField.requestFocus();jIPField.selectAll(); return;
        }
        }
    }//GEN-LAST:event_jIPFieldFocusLost

    private void jMessageClearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMessageClearBoxActionPerformed
        jMessageArea.setText("");
    }//GEN-LAST:event_jMessageClearBoxActionPerformed

    private void jFileChooseClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooseClearActionPerformed
        jTransferFileField.setText("");
        jMessageArea.setEnabled(true);
        jMessageLabel.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooseClearActionPerformed

    private void jFileChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooseButtonActionPerformed

        JFileChooser filechooser;
        String filename=jTransferFileField.getText();
        //if(controller.getDestinationFolder().equals(""))
        filechooser=new JFileChooser();
        //else filechooser=new JFileChooser(new File(controller.getDestinationFolder()));
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setMultiSelectionEnabled(false);
        if(filechooser.showDialog(this,"Choose File")==JFileChooser.APPROVE_OPTION)
        {
            if(!filechooser.getSelectedFile().exists())
            { JOptionPane.showMessageDialog(this,"Invalid File", "Error",
                JOptionPane.ERROR_MESSAGE); jDestinationField.setText(filename);
        }
        else {
            jTransferFileField.setText(filechooser.getSelectedFile().toString());
            jMessageLabel.setEnabled(false); jMessageArea.setEnabled(false);
        }
        }

    }//GEN-LAST:event_jFileChooseButtonActionPerformed

    private void jCancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButton1ActionPerformed
        controller.actionCancel(SelectedSenderTransfer);
        updateButtons();
    }//GEN-LAST:event_jCancelButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
       SettingsStorageDatabase.update((byte)3, EndUser.getDestiFolder());
       SettingsStorageDatabase.update((byte)2, EndUser.getBufferSize()+"");
       SettingsStorageDatabase.update((byte)4, EndUser.getCAIP());
       SettingsStorageDatabase.update((byte)5, EndUser.getAlgoType());
       
    }//GEN-LAST:event_formWindowClosing

    private void jRejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRejectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRejectButtonActionPerformed

    private void jCancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButton2ActionPerformed
       controller.actionCancel(SelectedReceiverTransfer);
        updateButtons();
    }//GEN-LAST:event_jCancelButton2ActionPerformed

    private void jClearButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearButton2ActionPerformed
        // TODO add your handling code here:
        actionReceiverClear();
    }//GEN-LAST:event_jClearButton2ActionPerformed

    private void jRequestorFileNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRequestorFileNameFocusLost
       String filename=jRequestorFileName.getText();
        if("".equals(filename))jRequestorFileName.setText("Enter a name for the downloaded file");
        else if(!controller.isFileValid(filename))
        {
            JOptionPane.showMessageDialog(this,
                "Illegal File Name!", "Error",
                JOptionPane.ERROR_MESSAGE);
            jRequestorFileName.selectAll(); jRequestorFileName.requestFocus();
        }
    }//GEN-LAST:event_jRequestorFileNameFocusLost

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
            java.util.logging.Logger.getLogger(EndUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndUserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
 private void actionSenderClear() {
       if(SelectedSenderTransfer==null)return;
        clearing= true;
        SenderTableModel.clearTransfer(jSenderProgressTable.getSelectedRow());
        clearing = false;
        SelectedSenderTransfer = null;
        updateButtons();
    }
 private void actionReceiverClear() {
       if(SelectedReceiverTransfer==null)return;
        clearing= true;
        ReceiverTableModel.clearTransfer(jReceiverProgressTable.getSelectedRow());
        clearing = false;
        SelectedReceiverTransfer = null;
        updateButtons();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAcceptButton;
    private javax.swing.JComboBox jAlgoBox;
    private javax.swing.JButton jApplyButton;
    private javax.swing.JTextField jBufferField;
    private javax.swing.JLabel jCAIPLabel;
    private javax.swing.JTextField jCAIPfield;
    private javax.swing.JTextField jCANameField;
    private javax.swing.JButton jCancelButton1;
    private javax.swing.JButton jCancelButton2;
    private javax.swing.JButton jCancelChangesButton;
    private javax.swing.JLabel jChangesSuccessfulLabel;
    private javax.swing.JButton jClearButton1;
    private javax.swing.JButton jClearButton2;
    private javax.swing.JButton jClearChangesButton;
    private javax.swing.JLabel jConnectionsLabel6;
    private javax.swing.JLabel jConnectionsLabel7;
    private javax.swing.JLabel jConnectionsLabel9;
    private javax.swing.JButton jDestinationButton;
    private javax.swing.JTextField jDestinationField;
    private javax.swing.JLabel jDestinationLabel;
    private javax.swing.JButton jFileChooseButton;
    private javax.swing.JButton jFileChooseClear;
    private javax.swing.JLabel jFileLabel;
    private javax.swing.JLabel jFileLabel1;
    private javax.swing.JLabel jFileLabel2;
    private javax.swing.JLabel jFileLabel3;
    private javax.swing.JLabel jFileLabel4;
    private javax.swing.JTextField jIPField;
    private javax.swing.JTextArea jMessageArea;
    private javax.swing.JTextArea jMessageArea1;
    private javax.swing.JButton jMessageClearBox;
    private javax.swing.JLabel jMessageLabel;
    private javax.swing.JLabel jMessageLabel1;
    private javax.swing.JTextField jMyUNameField;
    private javax.swing.JLabel jOrLabel;
    private javax.swing.JLabel jProxyLabel5;
    private javax.swing.JLabel jProxyLabel7;
    private javax.swing.JLabel jProxyLabel8;
    private javax.swing.JLabel jProxyLabel9;
    private javax.swing.JTable jReceiverProgressTable;
    private javax.swing.JPanel jReceiverTable;
    private javax.swing.JButton jRejectButton;
    private javax.swing.JTextField jRequestorFileName;
    private javax.swing.JTextField jRequestorIP;
    private javax.swing.JTextField jRequestorName;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jSenderProgressTable;
    private javax.swing.JPanel jSenderTable;
    private javax.swing.JPanel jSettings;
    private javax.swing.JButton jStartTransferButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTransferFileField;
    private javax.swing.JLabel jUserName;
    private javax.swing.JLabel jUserName1;
    private javax.swing.JTextField jUserNameField;
    private javax.swing.JLabel jUserNameLabel;
    // End of variables declaration//GEN-END:variables
 @Override
    public void update(Observable o, Object arg) {
       if (SelectedSenderTransfer != null && SelectedSenderTransfer.equals(o) || SelectedReceiverTransfer!=null && SelectedReceiverTransfer.equals(o))
            updateButtons();//To change body of generated methods, choose Tools | Templates.
    }

    private static class ProgressRenderer extends JProgressBar
        implements TableCellRenderer {
     
    // Constructor for ProgressRenderer.
    public ProgressRenderer(int min, int max) {
        super(min, max);
    }
     
  /* Returns this JProgressBar as the renderer
     for the given table cell. */
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        // Set JProgressBar's percent complete value.
        setValue((int) ((Float) value).floatValue());
        return this;
    }
    }
    private static class CenterRenderer extends DefaultTableCellRenderer {
     
  /* Centers the elelmets in all class of type string */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
{
    JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    renderedLabel.setHorizontalAlignment(CENTER);
    return renderedLabel;
}
   
    }
void hideResult()
{
    jChangesSuccessfulLabel.setVisible(false);
}
    private static class Display extends Thread {

        EndUserInterface board;
        public Display(EndUserInterface d) {
            this.board=d;
        }

        @Override
        public void run() {
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EndUserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            board.hideResult();//To change body of generated methods, choose Tools | Templates.
        }
        
    }
   
void AddEntry(ReceiverSideTransfer download) {
       ReceiverTableModel.addTransfer(download);
    }
void AddEntry(SenderSideTransfer download) {
       SenderTableModel.addTransfer(download);
    }
   // Called when table row selection changes.
    private void SenderTableSelectionChanged() {
    /* Unregister from receiving notifications
       from the last selected download and if not downloading at the moment, add new observer the newly selected */
        if (SelectedSenderTransfer != null)
            SelectedSenderTransfer.deleteObserver(EndUserInterface.this);
        if (!clearing && jSenderProgressTable.getSelectedRow()!=-1) {
            SelectedSenderTransfer =
                    SenderTableModel.getTransfer(jSenderProgressTable.getSelectedRow());
            SelectedSenderTransfer.addObserver(EndUserInterface.this);
            updateButtons();
        }
    }
    private void ReceiverTableSelectionChanged() {
    /* Unregister from receiving notifications
       from the last selected download and if not downloading at the moment, add new observer the newly selected */
        if (SelectedReceiverTransfer != null)
            SelectedReceiverTransfer.deleteObserver(EndUserInterface.this);
        if (!clearing && jReceiverProgressTable.getSelectedRow()!=-1) {
            SelectedReceiverTransfer =
                    ReceiverTableModel.getTransfer(jReceiverProgressTable.getSelectedRow());
            SelectedReceiverTransfer.addObserver(EndUserInterface.this);
            updateButtons();
        }
    }
 void DisplayMessage(String str, String title,int choice)
{
  if(choice==0)
  JOptionPane.showMessageDialog(this,
                    str, title,
                    JOptionPane.ERROR_MESSAGE);
  else 
      JOptionPane.showMessageDialog(this,
                    str, title,
                    JOptionPane.INFORMATION_MESSAGE);
  if(str.equals("HostName Unknown error!!"))jIPField.requestFocus();
}
     
    // Clear the selected download.
    
  /* Update each button's state based off of the
     currently selected download's status. */
    private void updateButtons() {
        if (SelectedSenderTransfer != null) {
            int status = SelectedSenderTransfer.getStatus();
            switch (status) {
                case 1:
                case 2:
                case 10:   
                case 3:
                    jCancelButton1.setEnabled(false);
                    jClearButton1.setEnabled(true);
                    break;
                default: // COMPLETE or CANCELLED
                   jCancelButton1.setEnabled(true);
                    jClearButton1.setEnabled(false);
            }
        } else {
            // No download is selected in table.
            jCancelButton1.setEnabled(false);
            jClearButton1.setEnabled(false);
        }
        if (SelectedReceiverTransfer != null) {
            int status = SelectedReceiverTransfer.getStatus();
            switch (status) {
                case 1:
                case 2:
                case 3:    
                    jCancelButton2.setEnabled(false);
                    jClearButton2.setEnabled(true);
                    break;
                default: // COMPLETE or CANCELLED
                   jCancelButton2.setEnabled(true);
                    jClearButton2.setEnabled(false);
            }
        } else {
            // No download is selected in table.
            jCancelButton2.setEnabled(false);
            jClearButton2.setEnabled(false);
        }
    }   
}
