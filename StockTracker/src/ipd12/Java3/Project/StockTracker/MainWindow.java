
package ipd12.Java3.Project.StockTracker;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class MainWindow extends javax.swing.JFrame {
    
    Database db;
    public TableModel tm = new MyTableModel(new Object[][]{});
    public boolean isReal = true; //the app opens in TrackMode by default
    
    public MainWindow() {
        try {
            db = new Database();
            initComponents();
            
            tm = new MyTableModel(
            
            new Object[][] {
            {"Mary", "Camp", "Snowboa", new Integer(5),
                new Boolean(false), "Mary", "Camp", "Sn"},
            {"Alison", "Huml", "Rowing", new Integer(3), new Boolean(true), "Mary", "Campione", "Sn"},
            {"Kathy", "Walrath", "Knitting", new Integer(2),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Sharon", "Zakhour", "Speed rea", new Integer(20),
                new Boolean(true), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Camp", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Camp", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Camp", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Camp", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"},
            {"Philip", "Milne", "Pool", new Integer(10),
                new Boolean(false), "Mary", "Campione", "Sn"}}
            
            );
            tTable.setModel(tm);
            
            tTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            tTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            tTable.getColumnModel().getColumn(2).setPreferredWidth(90);
            tTable.getColumnModel().getColumn(3).setPreferredWidth(90);
            tTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            tTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            tTable.getColumnModel().getColumn(7).setPreferredWidth(48);
   
            //Set columns names
//            tTable.setColumnSelectionAllowed(true);
//            jScrollPane1.setViewportView(tTable);
//            tTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
//            if (tTable.getColumnModel().getColumnCount() > 0) {
//                tTable.getColumnModel().getColumn(0).setHeaderValue("Symbol");
//                tTable.getColumnModel().getColumn(1).setHeaderValue("Quantity");
//                tTable.getColumnModel().getColumn(2).setHeaderValue("Entry");
//                tTable.getColumnModel().getColumn(3).setHeaderValue("Last");
//                tTable.getColumnModel().getColumn(4).setHeaderValue("Change");
//                tTable.getColumnModel().getColumn(5).setHeaderValue("Value");
//                tTable.getColumnModel().getColumn(6).setHeaderValue("Gain/Loss");
//                tTable.getColumnModel().getColumn(7).setHeaderValue("%");
//            }
        
        
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            // display dialog with error message and terminate the program
            JOptionPane.showMessageDialog(this,
                    "Fatal error: unable to connect to database:\n" + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgUser = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dlgUser_tfUsername = new javax.swing.JTextField();
        dlgUser_tfPassword = new javax.swing.JPasswordField();
        dlgUser_btCancel = new javax.swing.JButton();
        dlgUser_btLogin = new javax.swing.JButton();
        dlgUser_lblHelpUserName = new javax.swing.JLabel();
        dlgUser_lblHelpPassword = new javax.swing.JLabel();
        dlgUser_lblUserOk = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dlgUser_cbbDefaultUser = new javax.swing.JCheckBox();
        dlgUser_btSignUp = new javax.swing.JButton();
        dlgSignUp = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dlgSignUp_tfUsername = new javax.swing.JTextField();
        dlgSignUp_tfPassword = new javax.swing.JPasswordField();
        dlgSignUp_rbtCancel = new javax.swing.JButton();
        dlgSignUp_lblHelpUserName = new javax.swing.JLabel();
        dlgSignUp_lblHelpPassword = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dlgSignUp_lblPassOk = new javax.swing.JLabel();
        dlgSignUp_cbbDefaultUser = new javax.swing.JCheckBox();
        dlgSignUp_btSignUp = new javax.swing.JButton();
        dlgSignUp_tfPassConfirmation = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        dlgSignUp_lblUserOk = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dlgPortfolios = new javax.swing.JDialog();
        dlgMoving = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        dlgMoving_lblCurrentTrade = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dlgMoving_cbbChoosePortfolio = new javax.swing.JComboBox<>();
        dlgMoving_btMove = new javax.swing.JButton();
        dlgMoving_btCancel = new javax.swing.JButton();
        dlgManage = new javax.swing.JDialog();
        dlgManage_btnAdd = new javax.swing.JButton();
        dlgManage_btnEdit = new javax.swing.JButton();
        dlgManage_btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dlgManage_tfName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dlgManage_lblId = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dlgManage_cbbType = new javax.swing.JComboBox<>();
        dlgManage_tfCash = new javax.swing.JTextField();
        dlgManage_cbByDefault = new javax.swing.JCheckBox();
        ppMain = new javax.swing.JPopupMenu();
        ppMain_Move = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ppMain_Delete = new javax.swing.JMenuItem();
        ppManage = new javax.swing.JPopupMenu();
        ppManage_Edit = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ppManage_Delete = new javax.swing.JMenuItem();
        dlgAdd = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        dlgAdd_tfNumberOfShares = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        dlgAdd_tfSymbol = new javax.swing.JTextField();
        dlgAdd_btAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dlgAdd_rbBuy = new javax.swing.JRadioButton();
        dlgAdd_rbSell = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        dlgAdd_rbShortSell = new javax.swing.JRadioButton();
        dlgAdd_rbCoverShort = new javax.swing.JRadioButton();
        dlgAdd_btReset = new javax.swing.JButton();
        dlgAdd_btCancel = new javax.swing.JButton();
        dlgAdd_lblSymbolOk = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btgAdd = new javax.swing.ButtonGroup();
        lblStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTable = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btAddTrade = new javax.swing.JButton();
        btDeleteTrade = new javax.swing.JButton();
        btSaveChanges = new javax.swing.JButton();
        cbbPortfolio = new javax.swing.JComboBox<>();
        cbIsDefaultPortfolio = new javax.swing.JCheckBox();
        btMove = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btEditTrade = new javax.swing.JButton();
        mMenuBar = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        smExpExcel = new javax.swing.JMenuItem();
        smExpCsv = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        smExit = new javax.swing.JMenuItem();
        mTrade = new javax.swing.JMenu();
        mSwitch = new javax.swing.JMenu();
        mPortfolios = new javax.swing.JMenu();
        mReports = new javax.swing.JMenu();
        smReportCurrent = new javax.swing.JMenuItem();
        smReportAll = new javax.swing.JMenuItem();
        mEmpty = new javax.swing.JMenu();
        mUser = new javax.swing.JMenu();
        mLogin = new javax.swing.JMenu();

        dlgUser.setModal(true);
        dlgUser.setResizable(false);
        dlgUser.setSize(new java.awt.Dimension(380, 200));

        jLabel1.setText("Username");

        jLabel3.setText("Password");

        dlgUser_tfPassword.setText("jPasswordField1");

        dlgUser_btCancel.setText("Cancel");
        dlgUser_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgUser_btCancelActionPerformed(evt);
            }
        });

        dlgUser_btLogin.setText("Log In");

        dlgUser_lblHelpUserName.setText("?");

        dlgUser_lblHelpPassword.setText("?");

        dlgUser_lblUserOk.setBackground(new java.awt.Color(0, 204, 0));
        dlgUser_lblUserOk.setForeground(new java.awt.Color(255, 51, 51));
        dlgUser_lblUserOk.setText("x");

        jLabel7.setBackground(new java.awt.Color(51, 204, 0));
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("");

        dlgUser_cbbDefaultUser.setText("Default user");

        dlgUser_btSignUp.setText("Sign Up");

        javax.swing.GroupLayout dlgUserLayout = new javax.swing.GroupLayout(dlgUser.getContentPane());
        dlgUser.getContentPane().setLayout(dlgUserLayout);
        dlgUserLayout.setHorizontalGroup(
            dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgUserLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgUserLayout.createSequentialGroup()
                        .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgUserLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(dlgUser_lblHelpUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dlgUser_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgUserLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21)
                                .addComponent(dlgUser_lblHelpPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dlgUser_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(dlgUserLayout.createSequentialGroup()
                        .addComponent(dlgUser_btCancel)
                        .addGap(18, 18, 18)
                        .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlgUser_cbbDefaultUser)
                            .addGroup(dlgUserLayout.createSequentialGroup()
                                .addComponent(dlgUser_btLogin)
                                .addGap(18, 18, 18)
                                .addComponent(dlgUser_btSignUp)))
                        .addGap(18, 18, 18)))
                .addComponent(dlgUser_lblUserOk, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(22, 22, 22))
        );

        dlgUserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlgUser_btCancel, dlgUser_btLogin, dlgUser_btSignUp});

        dlgUserLayout.setVerticalGroup(
            dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgUserLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dlgUser_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgUser_lblHelpUserName)
                    .addComponent(dlgUser_lblUserOk)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dlgUser_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgUser_lblHelpPassword))
                .addGap(18, 18, 18)
                .addComponent(dlgUser_cbbDefaultUser)
                .addGap(18, 18, 18)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgUser_btCancel)
                    .addComponent(dlgUser_btLogin)
                    .addComponent(dlgUser_btSignUp))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        dlgSignUp.setResizable(false);
        dlgSignUp.setSize(new java.awt.Dimension(380, 200));

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        dlgSignUp_tfPassword.setText("jPasswordField1");

        dlgSignUp_rbtCancel.setText("Cancel");
        dlgSignUp_rbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgSignUp_rbtCancelActionPerformed(evt);
            }
        });

        dlgSignUp_lblHelpUserName.setText("?");

        dlgSignUp_lblHelpPassword.setText("?");

        jLabel8.setBackground(new java.awt.Color(0, 204, 0));
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("x");

        dlgSignUp_lblPassOk.setBackground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblPassOk.setForeground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblPassOk.setText("");

        dlgSignUp_cbbDefaultUser.setText("Default user");

        dlgSignUp_btSignUp.setText("Sign Up");

        dlgSignUp_tfPassConfirmation.setText("jPasswordField1");
        dlgSignUp_tfPassConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgSignUp_tfPassConfirmationActionPerformed(evt);
            }
        });

        jLabel10.setText("Confirm");

        dlgSignUp_lblUserOk.setBackground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblUserOk.setForeground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblUserOk.setText("");

        jLabel12.setBackground(new java.awt.Color(0, 204, 0));
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("x");

        javax.swing.GroupLayout dlgSignUpLayout = new javax.swing.GroupLayout(dlgSignUp.getContentPane());
        dlgSignUp.getContentPane().setLayout(dlgSignUpLayout);
        dlgSignUpLayout.setHorizontalGroup(
            dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSignUpLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgSignUpLayout.createSequentialGroup()
                        .addComponent(dlgSignUp_rbtCancel)
                        .addGap(49, 49, 49)
                        .addComponent(dlgSignUp_btSignUp)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dlgSignUpLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(dlgSignUp_lblHelpUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dlgSignUpLayout.createSequentialGroup()
                                    .addComponent(dlgSignUp_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dlgSignUp_lblUserOk)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dlgSignUp_cbbDefaultUser))
                            .addContainerGap(25, Short.MAX_VALUE))
                        .addGroup(dlgSignUpLayout.createSequentialGroup()
                            .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(dlgSignUpLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dlgSignUp_lblHelpPassword)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dlgSignUp_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(dlgSignUpLayout.createSequentialGroup()
                                    .addComponent(dlgSignUp_tfPassConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dlgSignUp_lblPassOk)
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        dlgSignUpLayout.setVerticalGroup(
            dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSignUpLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dlgSignUp_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgSignUp_lblHelpUserName)
                    .addComponent(jLabel8)
                    .addComponent(dlgSignUp_lblUserOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dlgSignUp_cbbDefaultUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dlgSignUp_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgSignUp_lblHelpPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgSignUp_tfPassConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(dlgSignUp_lblPassOk)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgSignUp_rbtCancel)
                    .addComponent(dlgSignUp_btSignUp))
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgPortfoliosLayout = new javax.swing.GroupLayout(dlgPortfolios.getContentPane());
        dlgPortfolios.getContentPane().setLayout(dlgPortfoliosLayout);
        dlgPortfoliosLayout.setHorizontalGroup(
            dlgPortfoliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dlgPortfoliosLayout.setVerticalGroup(
            dlgPortfoliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        dlgMoving.setTitle("Trade move");
        dlgMoving.setResizable(false);

        jLabel6.setText("Current trade");

        dlgMoving_lblCurrentTrade.setText("...");

        jLabel11.setText("Move to portfilio");

        dlgMoving_cbbChoosePortfolio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose portfilio", "Item 2", "Item 3", "Item 4" }));

        dlgMoving_btMove.setText("Move");

        dlgMoving_btCancel.setText("Cancel");

        javax.swing.GroupLayout dlgMovingLayout = new javax.swing.GroupLayout(dlgMoving.getContentPane());
        dlgMoving.getContentPane().setLayout(dlgMovingLayout);
        dlgMovingLayout.setHorizontalGroup(
            dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMovingLayout.createSequentialGroup()
                .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgMovingLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgMovingLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(dlgMoving_lblCurrentTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgMovingLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dlgMoving_cbbChoosePortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dlgMovingLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(dlgMoving_btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(dlgMoving_btMove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgMovingLayout.setVerticalGroup(
            dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgMovingLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dlgMoving_lblCurrentTrade))
                .addGap(28, 28, 28)
                .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(dlgMoving_cbbChoosePortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(dlgMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgMoving_btMove)
                    .addComponent(dlgMoving_btCancel))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        dlgManage_btnAdd.setText("Add");

        dlgManage_btnEdit.setText("Edit");

        dlgManage_btnDelete.setText("Delete");

        jButton1.setText("Cancel");

        jScrollPane2.setViewportView(jList1);

        jLabel13.setText("Portfolio id: ");

        jLabel14.setText("Portfolio name:");

        jLabel15.setText("Portfolio type:");

        dlgManage_lblId.setText("...");

        jLabel17.setText("Available cash:");

        dlgManage_cbbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Test" }));

        dlgManage_cbByDefault.setText("Use by default");

        javax.swing.GroupLayout dlgManageLayout = new javax.swing.GroupLayout(dlgManage.getContentPane());
        dlgManage.getContentPane().setLayout(dlgManageLayout);
        dlgManageLayout.setHorizontalGroup(
            dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgManageLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgManageLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(21, 21, 21)
                                .addComponent(dlgManage_lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgManageLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(5, 5, 5)
                                .addComponent(dlgManage_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(dlgManageLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(5, 5, 5)
                                    .addComponent(dlgManage_cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(dlgManageLayout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dlgManage_cbByDefault)
                                        .addComponent(dlgManage_tfCash))))))
                    .addGroup(dlgManageLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dlgManage_btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dlgManage_btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dlgManage_btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgManageLayout.setVerticalGroup(
            dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgManageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dlgManageLayout.createSequentialGroup()
                        .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(dlgManage_lblId))
                        .addGap(18, 18, 18)
                        .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(dlgManage_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(dlgManage_cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(dlgManage_tfCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dlgManage_cbByDefault)))
                .addGap(18, 18, 18)
                .addGroup(dlgManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(dlgManage_btnAdd)
                    .addComponent(dlgManage_btnEdit)
                    .addComponent(dlgManage_btnDelete))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        dlgManageLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dlgManage_btnAdd, dlgManage_btnDelete, dlgManage_btnEdit, jButton1});

        ppMain_Move.setText("Move trade");
        ppMain.add(ppMain_Move);
        ppMain.add(jSeparator2);

        ppMain_Delete.setText("Delete trade");
        ppMain.add(ppMain_Delete);

        ppManage_Edit.setText("Edit");
        ppManage.add(ppManage_Edit);
        ppManage.add(jSeparator3);

        ppManage_Delete.setText("Delete");
        ppManage.add(ppManage_Delete);

        dlgAdd.setModal(true);
        dlgAdd.setResizable(false);

        jLabel16.setText("Number of Shares");

        jLabel18.setText("Symbol");

        dlgAdd_btAdd.setText("Add Trade");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btgAdd.add(dlgAdd_rbBuy);
        dlgAdd_rbBuy.setText("Buy");
        dlgAdd_rbBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAdd_rbBuyActionPerformed(evt);
            }
        });

        btgAdd.add(dlgAdd_rbSell);
        dlgAdd_rbSell.setText("Sell");
        dlgAdd_rbSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAdd_rbSellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlgAdd_rbBuy)
                .addGap(10, 10, 10)
                .addComponent(dlgAdd_rbSell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAdd_rbBuy)
                    .addComponent(dlgAdd_rbSell))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btgAdd.add(dlgAdd_rbShortSell);
        dlgAdd_rbShortSell.setText("Short Sell");

        btgAdd.add(dlgAdd_rbCoverShort);
        dlgAdd_rbCoverShort.setText("Cover a Short");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dlgAdd_rbShortSell)
                .addGap(18, 18, 18)
                .addComponent(dlgAdd_rbCoverShort)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAdd_rbShortSell)
                    .addComponent(dlgAdd_rbCoverShort))
                .addContainerGap())
        );

        dlgAdd_btReset.setText("Reset");

        dlgAdd_btCancel.setText("Cancel");
        dlgAdd_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAdd_btCancelActionPerformed(evt);
            }
        });

        dlgAdd_lblSymbolOk.setBackground(new java.awt.Color(51, 204, 0));
        dlgAdd_lblSymbolOk.setForeground(new java.awt.Color(51, 204, 0));
        dlgAdd_lblSymbolOk.setText("");

        jLabel19.setText("symbol not found");

        javax.swing.GroupLayout dlgAddLayout = new javax.swing.GroupLayout(dlgAdd.getContentPane());
        dlgAdd.getContentPane().setLayout(dlgAddLayout);
        dlgAddLayout.setHorizontalGroup(
            dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgAddLayout.createSequentialGroup()
                        .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dlgAdd_tfNumberOfShares))
                        .addGap(18, 18, 18)
                        .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dlgAdd_tfSymbol, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dlgAdd_lblSymbolOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dlgAdd_btAdd))
                    .addGroup(dlgAddLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dlgAdd_btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(dlgAdd_btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        dlgAddLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dlgAdd_tfNumberOfShares, dlgAdd_tfSymbol});

        dlgAddLayout.setVerticalGroup(
            dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgAddLayout.createSequentialGroup()
                        .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAdd_tfNumberOfShares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlgAdd_tfSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dlgAdd_lblSymbolOk)))
                    .addComponent(dlgAdd_btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAdd_btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgAdd_btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(935, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(935, 550));

        lblStatus.setText("Status");
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        tTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tTable.setComponentPopupMenu(ppMain);
        tTable.setNextFocusableComponent(btRefresh);
        tTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(tTable);
        tTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tTable.getColumnModel().getColumnCount() > 0) {
            tTable.getColumnModel().getColumn(0).setHeaderValue("Symbol");
            tTable.getColumnModel().getColumn(1).setHeaderValue("Quantity");
            tTable.getColumnModel().getColumn(2).setHeaderValue("Entry");
            tTable.getColumnModel().getColumn(3).setHeaderValue("Last");
            tTable.getColumnModel().getColumn(4).setHeaderValue("Change");
            tTable.getColumnModel().getColumn(5).setHeaderValue("Value");
            tTable.getColumnModel().getColumn(6).setHeaderValue("Gain/Loss");
            tTable.getColumnModel().getColumn(7).setHeaderValue("%");
        }

        lblTotal.setText("sdfsdfsdfsd");

        btAddTrade.setText("Add Trade/Trade Now");

        btDeleteTrade.setText("Delete Trade");

        btSaveChanges.setText("Save Changes");

        cbbPortfolio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choosen Portfolio", "Item 2", "Item 3", "Item 4" }));

        cbIsDefaultPortfolio.setText("use by default");

        btMove.setText("Move to another portfolio");
        btMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveActionPerformed(evt);
            }
        });

        btRefresh.setText("Refresh");

        jLabel9.setText("Portfolio:");

        jLabel2.setText("Total");

        btEditTrade.setText("Edit Trade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addGap(317, 317, 317))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbbPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbIsDefaultPortfolio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAddTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDeleteTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSaveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEditTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbPortfolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIsDefaultPortfolio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTotal))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAddTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btMove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDeleteTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        mMenuBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mMenuBarMouseMoved(evt);
            }
        });

        mFile.setText(" File ");

        smExpExcel.setText("Export to Excel");
        mFile.add(smExpExcel);

        smExpCsv.setText("Export to CSV");
        mFile.add(smExpCsv);
        mFile.add(jSeparator1);

        smExit.setText("Exit");
        mFile.add(smExit);

        mMenuBar.add(mFile);

        mTrade.setText(" Add trade/Trade now ");
        mMenuBar.add(mTrade);

        mSwitch.setText(" Switch to Test Mode ");
        mMenuBar.add(mSwitch);

        mPortfolios.setText(" Manage portfolios ");
        mMenuBar.add(mPortfolios);

        mReports.setText(" Create report ");

        smReportCurrent.setText("Current portfolio");
        mReports.add(smReportCurrent);

        smReportAll.setText("All portfolios");
        mReports.add(smReportAll);

        mMenuBar.add(mReports);

        mEmpty.setText("                                                                                         ");
        mMenuBar.add(mEmpty);

        mUser.setText("User:                               ");
        mMenuBar.add(mUser);

        mLogin.setText("Log In/Out");
        mLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mLoginMouseClicked(evt);
            }
        });
        mMenuBar.add(mLogin);

        setJMenuBar(mMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dlgUser_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgUser_btCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgUser_btCancelActionPerformed

    private void dlgSignUp_rbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgSignUp_rbtCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgSignUp_rbtCancelActionPerformed

    private void dlgSignUp_tfPassConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgSignUp_tfPassConfirmationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgSignUp_tfPassConfirmationActionPerformed

    private void mLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mLoginMouseClicked
        dlgUser.pack();
        dlgUser.setLocationRelativeTo(null);
        dlgUser.setVisible(true);
    }//GEN-LAST:event_mLoginMouseClicked

    private void btMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMoveActionPerformed

    private void dlgAdd_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAdd_btCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdd_btCancelActionPerformed

    private void dlgAdd_rbSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAdd_rbSellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdd_rbSellActionPerformed

    private void dlgAdd_rbBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAdd_rbBuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdd_rbBuyActionPerformed

    private void mMenuBarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mMenuBarMouseMoved
       // mMenuBar.set
    }//GEN-LAST:event_mMenuBarMouseMoved
    
    public void rewriteMainTable(Object[][] newData) {
        tm = new MyTableModel(newData);
        tTable.setModel(tm);
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddTrade;
    private javax.swing.JButton btDeleteTrade;
    private javax.swing.JButton btEditTrade;
    private javax.swing.JButton btMove;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btSaveChanges;
    private javax.swing.ButtonGroup btgAdd;
    private javax.swing.JCheckBox cbIsDefaultPortfolio;
    private javax.swing.JComboBox<String> cbbPortfolio;
    private javax.swing.JDialog dlgAdd;
    private javax.swing.JButton dlgAdd_btAdd;
    private javax.swing.JButton dlgAdd_btCancel;
    private javax.swing.JButton dlgAdd_btReset;
    private javax.swing.JLabel dlgAdd_lblSymbolOk;
    private javax.swing.JRadioButton dlgAdd_rbBuy;
    private javax.swing.JRadioButton dlgAdd_rbCoverShort;
    private javax.swing.JRadioButton dlgAdd_rbSell;
    private javax.swing.JRadioButton dlgAdd_rbShortSell;
    private javax.swing.JTextField dlgAdd_tfNumberOfShares;
    private javax.swing.JTextField dlgAdd_tfSymbol;
    private javax.swing.JDialog dlgManage;
    private javax.swing.JButton dlgManage_btnAdd;
    private javax.swing.JButton dlgManage_btnDelete;
    private javax.swing.JButton dlgManage_btnEdit;
    private javax.swing.JCheckBox dlgManage_cbByDefault;
    private javax.swing.JComboBox<String> dlgManage_cbbType;
    private javax.swing.JLabel dlgManage_lblId;
    private javax.swing.JTextField dlgManage_tfCash;
    private javax.swing.JTextField dlgManage_tfName;
    private javax.swing.JDialog dlgMoving;
    private javax.swing.JButton dlgMoving_btCancel;
    private javax.swing.JButton dlgMoving_btMove;
    private javax.swing.JComboBox<String> dlgMoving_cbbChoosePortfolio;
    private javax.swing.JLabel dlgMoving_lblCurrentTrade;
    private javax.swing.JDialog dlgPortfolios;
    private javax.swing.JDialog dlgSignUp;
    private javax.swing.JButton dlgSignUp_btSignUp;
    private javax.swing.JCheckBox dlgSignUp_cbbDefaultUser;
    private javax.swing.JLabel dlgSignUp_lblHelpPassword;
    private javax.swing.JLabel dlgSignUp_lblHelpUserName;
    private javax.swing.JLabel dlgSignUp_lblPassOk;
    private javax.swing.JLabel dlgSignUp_lblUserOk;
    private javax.swing.JButton dlgSignUp_rbtCancel;
    private javax.swing.JPasswordField dlgSignUp_tfPassConfirmation;
    private javax.swing.JPasswordField dlgSignUp_tfPassword;
    private javax.swing.JTextField dlgSignUp_tfUsername;
    private javax.swing.JDialog dlgUser;
    private javax.swing.JButton dlgUser_btCancel;
    private javax.swing.JButton dlgUser_btLogin;
    private javax.swing.JButton dlgUser_btSignUp;
    private javax.swing.JCheckBox dlgUser_cbbDefaultUser;
    private javax.swing.JLabel dlgUser_lblHelpPassword;
    private javax.swing.JLabel dlgUser_lblHelpUserName;
    private javax.swing.JLabel dlgUser_lblUserOk;
    private javax.swing.JPasswordField dlgUser_tfPassword;
    private javax.swing.JTextField dlgUser_tfUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JMenu mEmpty;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mLogin;
    private javax.swing.JMenuBar mMenuBar;
    private javax.swing.JMenu mPortfolios;
    private javax.swing.JMenu mReports;
    private javax.swing.JMenu mSwitch;
    private javax.swing.JMenu mTrade;
    private javax.swing.JMenu mUser;
    private javax.swing.JPopupMenu ppMain;
    private javax.swing.JMenuItem ppMain_Delete;
    private javax.swing.JMenuItem ppMain_Move;
    private javax.swing.JPopupMenu ppManage;
    private javax.swing.JMenuItem ppManage_Delete;
    private javax.swing.JMenuItem ppManage_Edit;
    private javax.swing.JMenuItem smExit;
    private javax.swing.JMenuItem smExpCsv;
    private javax.swing.JMenuItem smExpExcel;
    private javax.swing.JMenuItem smReportAll;
    private javax.swing.JMenuItem smReportCurrent;
    private javax.swing.JTable tTable;
    // End of variables declaration//GEN-END:variables
}
