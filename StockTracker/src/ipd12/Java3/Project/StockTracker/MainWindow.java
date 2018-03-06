package ipd12.Java3.Project.StockTracker;

import static ipd12.Java3.Project.StockTracker.Globals.currentPortfolio;
import static ipd12.Java3.Project.StockTracker.Globals.currentTradesSet;
import static ipd12.Java3.Project.StockTracker.Globals.currentUser;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import jxl.write.WriteException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class MainWindow extends javax.swing.JFrame {

    Database db;
    User user; //?public
    Portfolio portfolio;
    public TableModel tm = new MyTableModel(new Object[][]{});
    public DefaultComboBoxModel<Portfolio> cbbPortfolioModel = new DefaultComboBoxModel<>();//R
    public static boolean isRealMode = true; //the app opens in TrackMode by default
    public boolean isLoggedIn = false;
    

    //D
    DefaultListModel<Portfolio> modelPortfoliosList = new DefaultListModel<>();

    public MainWindow() {

        try {
            db = new Database();
            initComponents();
            
            FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("Excel files (*.xls)", "xls");
            fileChooser.setFileFilter(csvFilter);
            cbbPortfolio.addItemListener(new ItemChangeListener());

            tTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) throws UnsupportedOperationException {
                    try {
                        int sRow = tTable.getSelectedRow();
                        Trade t = currentTradesSet.get(sRow);
                        String status = String.format("   %s - %s (%s) trade opened since %s", t.name, t.sector, t.industry, t.opDate + "");
                        lblStatus.setText(status);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                    
                }
            });
            tm = new MyTableModel( new Object[][] {{"", "", "", "", "", "", "", ""}} );
            tTable.setModel(tm);
            tTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            tTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            tTable.getColumnModel().getColumn(2).setPreferredWidth(90);
            tTable.getColumnModel().getColumn(3).setPreferredWidth(90);
            tTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            tTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            tTable.getColumnModel().getColumn(7).setPreferredWidth(48);
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

    private void reloadPortfolios() throws SQLException {       // reload the portolios list of current MODE of current user 
        
        cbbPortfolioModel.removeAllElements();
        modelPortfoliosList.clear();
        ArrayList<Portfolio> list = db.getAllPortfolios();
        if (!list.isEmpty()) {
            for (Portfolio p : list) {
                modelPortfoliosList.addElement(p);
                cbbPortfolioModel.addElement(p);
                if (p.isIsDefault()){
                    cbbPortfolio.setSelectedIndex(cbbPortfolioModel.getSize()-1);
                    cbIsDefaultPortfolio.setSelected(true);
                }
            }
            currentPortfolio = cbbPortfolioModel.getElementAt(cbbPortfolio.getSelectedIndex());
            if(Globals.firstLoad){
                rewriteMainTable();
                Globals.firstLoad = false;
            }
        }
        else {
            currentPortfolio = null;
            lblStatus.setText("Add your new portfolio in Portfolio Manager");
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
        dlgManage_btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPortfolios = new javax.swing.JList<>();
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
        ppMain_Browse = new javax.swing.JMenuItem();
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
        dlgAdd_lblStatus = new javax.swing.JLabel();
        btgAdd = new javax.swing.ButtonGroup();
        dlgUser = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dlgUser_tfUsername = new javax.swing.JTextField();
        dlgUser_tfPassword = new javax.swing.JPasswordField();
        dlgUser_btCancel = new javax.swing.JButton();
        dlgUser_btLogin = new javax.swing.JButton();
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
        jLabel20 = new javax.swing.JLabel();
        dlgSignUp_lblNameQ = new javax.swing.JLabel();
        dlgSignUp_tfName = new javax.swing.JTextField();
        fileChooser = new javax.swing.JFileChooser();
        lblStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTable = new javax.swing.JTable();
        btAddTrade = new javax.swing.JButton();
        btDeleteTrade = new javax.swing.JButton();
        btSaveChanges = new javax.swing.JButton();
        cbbPortfolio = new javax.swing.JComboBox<>();
        cbIsDefaultPortfolio = new javax.swing.JCheckBox();
        btMove = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btEditTrade = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotalInv = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTotalValue = new javax.swing.JLabel();
        lblTotalGainText = new javax.swing.JLabel();
        lblTotalGain = new javax.swing.JLabel();
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

        dlgManage.setModal(true);

        dlgManage_btnAdd.setText("Add");
        dlgManage_btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgManage_btnAddActionPerformed(evt);
            }
        });

        dlgManage_btnEdit.setText("Edit");
        dlgManage_btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgManage_btnEditActionPerformed(evt);
            }
        });

        dlgManage_btnDelete.setText("Delete");
        dlgManage_btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgManage_btnDeleteActionPerformed(evt);
            }
        });

        dlgManage_btnCancel.setText("Cancel");
        dlgManage_btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgManage_btnCancelActionPerformed(evt);
            }
        });

        lstPortfolios.setModel(modelPortfoliosList);
        lstPortfolios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstPortfoliosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstPortfoliosMouseReleased(evt);
            }
        });
        lstPortfolios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPortfoliosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstPortfolios);

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
                        .addComponent(dlgManage_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(dlgManage_btnCancel)
                    .addComponent(dlgManage_btnAdd)
                    .addComponent(dlgManage_btnEdit)
                    .addComponent(dlgManage_btnDelete))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        dlgManageLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dlgManage_btnAdd, dlgManage_btnCancel, dlgManage_btnDelete, dlgManage_btnEdit});

        ppMain_Move.setText("Move trade");
        ppMain.add(ppMain_Move);

        ppMain_Browse.setText("Browse symbol");
        ppMain_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppMain_BrowseActionPerformed(evt);
            }
        });
        ppMain.add(ppMain_Browse);
        ppMain.add(jSeparator2);

        ppMain_Delete.setText("Delete trade");
        ppMain.add(ppMain_Delete);

        ppManage_Edit.setText("Edit");
        ppManage_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppManage_EditActionPerformed(evt);
            }
        });
        ppManage.add(ppManage_Edit);
        ppManage.add(jSeparator3);

        ppManage_Delete.setText("Delete");
        ppManage_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppManage_DeleteActionPerformed(evt);
            }
        });
        ppManage.add(ppManage_Delete);

        dlgAdd.setModal(true);
        dlgAdd.setResizable(false);

        jLabel16.setText("Number of Shares");

        jLabel18.setText("Symbol");

        dlgAdd_tfSymbol.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dlgAdd_tfSymbolPropertyChange(evt);
            }
        });
        dlgAdd_tfSymbol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dlgAdd_tfSymbolKeyTyped(evt);
            }
        });

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
        dlgAdd_btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAdd_btResetActionPerformed(evt);
            }
        });

        dlgAdd_btCancel.setText("Cancel");
        dlgAdd_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAdd_btCancelActionPerformed(evt);
            }
        });

        dlgAdd_lblSymbolOk.setBackground(new java.awt.Color(51, 204, 0));
        dlgAdd_lblSymbolOk.setForeground(new java.awt.Color(51, 204, 0));
        dlgAdd_lblSymbolOk.setText("");

        dlgAdd_lblStatus.setText("symbol not found");

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
                            .addComponent(dlgAdd_lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(15, 15, 15)
                .addComponent(dlgAdd_lblStatus)
                .addGap(18, 18, 18)
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(dlgAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAdd_btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgAdd_btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dlgUser.setModal(true);
        dlgUser.setResizable(false);
        dlgUser.setSize(new java.awt.Dimension(380, 200));

        jLabel1.setText("Username");

        jLabel3.setText("Password");

        dlgUser_btCancel.setText("Cancel");
        dlgUser_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgUser_btCancelActionPerformed(evt);
            }
        });

        dlgUser_btLogin.setText("Log In");
        dlgUser_btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgUser_btLoginActionPerformed(evt);
            }
        });

        dlgUser_cbbDefaultUser.setText("Remember me");

        dlgUser_btSignUp.setText("Sign Up");
        dlgUser_btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgUser_btSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgUserLayout = new javax.swing.GroupLayout(dlgUser.getContentPane());
        dlgUser.getContentPane().setLayout(dlgUserLayout);
        dlgUserLayout.setHorizontalGroup(
            dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgUserLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dlgUser_tfUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgUser_tfPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgUserLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(dlgUser_btCancel)
                .addGap(18, 18, 18)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dlgUser_cbbDefaultUser)
                    .addGroup(dlgUserLayout.createSequentialGroup()
                        .addComponent(dlgUser_btLogin)
                        .addGap(18, 18, 18)
                        .addComponent(dlgUser_btSignUp)))
                .addGap(71, 71, 71))
        );
        dlgUserLayout.setVerticalGroup(
            dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgUserLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dlgUser_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dlgUser_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dlgUser_cbbDefaultUser)
                .addGap(18, 18, 18)
                .addGroup(dlgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgUser_btCancel)
                    .addComponent(dlgUser_btLogin)
                    .addComponent(dlgUser_btSignUp))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        dlgSignUp.setModal(true);
        dlgSignUp.setUndecorated(true);
        dlgSignUp.setResizable(false);
        dlgSignUp.setSize(new java.awt.Dimension(380, 200));

        jLabel4.setText("Username");

        jLabel5.setText("Password");

        dlgSignUp_rbtCancel.setText("Cancel");
        dlgSignUp_rbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgSignUp_rbtCancelActionPerformed(evt);
            }
        });

        dlgSignUp_lblHelpUserName.setText("?");
        dlgSignUp_lblHelpUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dlgSignUp_lblHelpUserNameMouseEntered(evt);
            }
        });

        dlgSignUp_lblHelpPassword.setText("?");
        dlgSignUp_lblHelpPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dlgSignUp_lblHelpPasswordMouseEntered(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 204, 0));
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("x");

        dlgSignUp_lblPassOk.setBackground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblPassOk.setForeground(new java.awt.Color(51, 204, 0));
        dlgSignUp_lblPassOk.setText("");

        dlgSignUp_cbbDefaultUser.setText("Remember me");

        dlgSignUp_btSignUp.setText("Sign Up");
        dlgSignUp_btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgSignUp_btSignUpActionPerformed(evt);
            }
        });

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

        jLabel20.setText("Name");

        dlgSignUp_lblNameQ.setText("?");
        dlgSignUp_lblNameQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dlgSignUp_lblNameQMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout dlgSignUpLayout = new javax.swing.GroupLayout(dlgSignUp.getContentPane());
        dlgSignUp.getContentPane().setLayout(dlgSignUpLayout);
        dlgSignUpLayout.setHorizontalGroup(
            dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSignUpLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgSignUpLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dlgSignUp_rbtCancel)
                        .addGap(49, 49, 49)
                        .addComponent(dlgSignUp_btSignUp)
                        .addGap(89, 89, 89))
                    .addGroup(dlgSignUpLayout.createSequentialGroup()
                        .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(dlgSignUp_lblHelpPassword))
                            .addComponent(jLabel10)
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dlgSignUp_lblNameQ)
                                    .addComponent(dlgSignUp_lblHelpUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 23, Short.MAX_VALUE)
                        .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addComponent(dlgSignUp_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addComponent(dlgSignUp_tfPassConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dlgSignUp_lblPassOk))
                            .addComponent(dlgSignUp_cbbDefaultUser)
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addComponent(dlgSignUp_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dlgSignUp_lblUserOk))
                            .addGroup(dlgSignUpLayout.createSequentialGroup()
                                .addComponent(dlgSignUp_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        dlgSignUpLayout.setVerticalGroup(
            dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSignUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(dlgSignUp_lblNameQ)
                    .addComponent(dlgSignUp_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgSignUp_tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(dlgSignUp_lblUserOk)
                    .addComponent(dlgSignUp_lblHelpUserName))
                .addGap(18, 18, 18)
                .addComponent(dlgSignUp_cbbDefaultUser)
                .addGap(34, 34, 34)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dlgSignUp_tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlgSignUp_lblHelpPassword)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgSignUp_tfPassConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(dlgSignUp_lblPassOk))
                .addGap(26, 26, 26)
                .addGroup(dlgSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgSignUp_rbtCancel)
                    .addComponent(dlgSignUp_btSignUp))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Tracker");
        setResizable(false);
        setSize(new java.awt.Dimension(935, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStatus.setText("Status");
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        tTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tTable.setComponentPopupMenu(ppMain);
        tTable.setNextFocusableComponent(btRefresh);
        tTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tTableMouseReleased(evt);
            }
        });
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

        btAddTrade.setText("Add Trade/Trade Now");
        btAddTrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTradeActionPerformed(evt);
            }
        });

        btDeleteTrade.setText("Delete Trade");

        btSaveChanges.setText("Save Changes");

        cbbPortfolio.setModel(cbbPortfolioModel);

        cbIsDefaultPortfolio.setText("use by default");

        btMove.setText("Move to another portfolio");
        btMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveActionPerformed(evt);
            }
        });

        btRefresh.setText("Refresh");

        jLabel9.setText("Portfolio:");

        btEditTrade.setText("Edit Trade");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Invested:");

        lblTotalInv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalInv.setText(" ");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotal.setText("Value:");

        lblTotalValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalValue.setText(" ");

        lblTotalGainText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalGainText.setText("Current profit:");

        lblTotalGain.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotalGain.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(btEditTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalInv, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalGain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalGainText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalGainText)
                                    .addComponent(lblTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalGain, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTotalInv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        mMenuBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mMenuBarMouseMoved(evt);
            }
        });

        mFile.setText(" File ");

        smExpExcel.setText("Export to Excel");
        smExpExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smExpExcelActionPerformed(evt);
            }
        });
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
        mPortfolios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mPortfoliosMouseClicked(evt);
            }
        });
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

        mLogin.setText("Log In");
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

    private void mLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mLoginMouseClicked
//        String defUser = "";
        if (mLogin.getText().equals("Log In")) {
//            try {
//            defUser = db.checkDefaultUser();
//        } catch (SQLException ex) {
//        }
//        if (defUser.equals("")) {
//        } else {
//            dlgUser_tfUsername.setText(defUser);
//            dlgUser_cbbDefaultUser.setSelected(true);
//        }
            
            dlgUser.pack();
            dlgUser.setLocationRelativeTo(null);
            dlgUser.setVisible(true);
        } else {
            mLogin.setText("Log In");
            mUser.setText("User:                          ");
            //action when logged out goes here
            
//            try {
//                defUser = db.checkDefaultUser();
//            } catch (SQLException ex) {
//            }
//            if (defUser.equals("")) {
//                dlgUser_cbbDefaultUser.setSelected(false);
//            } else {
//                dlgUser_tfUsername.setText(defUser);
//                dlgUser_cbbDefaultUser.setSelected(true);
//            }
            
            dlgUser.pack();
            dlgUser.setLocationRelativeTo(null);
            dlgUser.setVisible(true);
        }
    }//GEN-LAST:event_mLoginMouseClicked

    private void dlgAdd_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAdd_btCancelActionPerformed
        dlgAdd.setVisible(false);
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

    private void dlgUser_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgUser_btCancelActionPerformed
        dlgUser.setVisible(false);
    }//GEN-LAST:event_dlgUser_btCancelActionPerformed
    long currentUserIdForAdd = 0;
    String currentNameForAdd = "";
    String currentUserNameForAdd = "";
    String currentPasswordForAdd = "";
    boolean currentIsDefaultForAdd = false;


    private void dlgUser_btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgUser_btLoginActionPerformed
         
        try {
            String userN = dlgUser_tfUsername.getText();
            String pass = dlgUser_tfPassword.getText();
            if (userN.equals("")) {
                return;
            }
            isLoggedIn = db.checkLogin(userN, pass);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        if (isLoggedIn) {
            mLogin.setText("Log Out");
            lblStatus.setText("Hi! You are successfully logged in!");
            //dlgUser_btLogin.setText("Log Out");

            try {
                String userN = dlgUser_tfUsername.getText();
                currentUserIdForAdd = db.getCurrentUserId(userN);
                currentNameForAdd = db.getCurrentUserName(userN);
                currentUserNameForAdd = dlgUser_tfUsername.getText();
                currentPasswordForAdd = dlgUser_tfPassword.getText();
                currentIsDefaultForAdd = dlgUser_cbbDefaultUser.isSelected();

                user = new User(currentUserIdForAdd, currentNameForAdd, currentUserNameForAdd, currentPasswordForAdd, currentIsDefaultForAdd);
                Globals.currentUser = user;
                reloadPortfolios();

                if (currentIsDefaultForAdd) {
                    db.updateIsDefaultUserSetFalse();
                    db.updateIsDefaultUserSetTrue();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

            }
            dlgUser.setVisible(false);
            dlgUser_tfUsername.setText("");
            dlgUser_tfPassword.setText("");
            mUser.setText("User: " + Globals.currentUser.getName() + "                     ");
        } else {
            dlgUser_tfUsername.setText("");
            dlgUser_tfPassword.setText("");
            dlgUser_tfUsername.requestFocus();
        }

    }//GEN-LAST:event_dlgUser_btLoginActionPerformed

    private void dlgUser_btSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgUser_btSignUpActionPerformed
       // dlgUser.setVisible(false);
        dlgSignUp.pack();
        dlgSignUp.setLocationRelativeTo(null);
        dlgSignUp.setVisible(true);

    }//GEN-LAST:event_dlgUser_btSignUpActionPerformed

    private void dlgSignUp_rbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgSignUp_rbtCancelActionPerformed
        dlgSignUp.setVisible(false);
        dlgUser.setVisible(true);
    }//GEN-LAST:event_dlgSignUp_rbtCancelActionPerformed

    private void dlgSignUp_btSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgSignUp_btSignUpActionPerformed
        try {
            String name = dlgSignUp_tfName.getText();
            String userN = dlgSignUp_tfUsername.getText();
            String pass = dlgSignUp_tfPassword.getText();
            String passConf = dlgSignUp_tfPassConfirmation.getText();
            boolean isDef = dlgSignUp_cbbDefaultUser.isSelected();
            if (name.equals("") ||userN.equals("") || pass.equals("") || passConf.equals("")) {
                return;
            }
        if (!name.matches("[A-Za-z]{2,25}")) {
                    JOptionPane.showMessageDialog(this,
                    "Error: Name must contain"
                            + " letters only and be between 2 and 15 characters.",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
            if (!userN.matches("[A-Za-z0-9_-]{3,10}")) {
                 JOptionPane.showMessageDialog(this,
                    "Username must contain  "
                            + " minimum 3 and maximum 10 characters, "
                            + "can be made up of letters, numbers, underscore and hyphen.",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
                    return;                 
                }
            if (!pass.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,10}")) {
                
                 JOptionPane.showMessageDialog(this,
                    "Password must be between  5 and 10 characters, contain at "
                            + "least one uppercase letter, one lowercase letter and one number.",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
                    return;    
                   
                }
            if (pass.equals(passConf)) {
                db.signUp(name,userN, pass, isDef);
                
                user= new User(db.getCurrentUserId(userN),name,userN,pass,isDef);
                 Globals.currentUser = user;
                 
               if(isDef){
                    db.updateIsDefaultUserSignUpSetFalse();
                    
               }
                dlgSignUp_tfUsername.setText("");
                dlgSignUp_tfPassword.setText("");
                dlgSignUp_tfPassConfirmation.setText("");
                dlgSignUp.setVisible(false);
               // dlgUser.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Password and confirmation password must be the same value!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException  ex) {
           JOptionPane.showMessageDialog(this,
                        "Error signing up:\n" + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_dlgSignUp_btSignUpActionPerformed

    private void dlgSignUp_tfPassConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgSignUp_tfPassConfirmationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgSignUp_tfPassConfirmationActionPerformed

    private void mPortfoliosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mPortfoliosMouseClicked
        dlgManage.pack();
        dlgManage.setLocationRelativeTo(null);
        dlgManage.setVisible(true);
    }//GEN-LAST:event_mPortfoliosMouseClicked

    long currSelectedId = 0;
    String currSelectedName = "";
    boolean currSelectedIsDef = false;
    Portfolio.PortType currSelectedType = Portfolio.PortType.Test;
    long currSelectedUserId = 0;
    BigDecimal currSelectedAmount = new BigDecimal(0);


    private void lstPortfoliosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPortfoliosValueChanged
       Portfolio port = lstPortfolios.getSelectedValue();
        if (port == null) {
            currSelectedId = 0;

            return;
        }
        currSelectedId = port.getId();
        currSelectedName = port.getName();
        currSelectedIsDef = port.isIsDefault();
        currSelectedType = port.getPortType();
        //currSelectedUserId = port.getUserId();
        currSelectedAmount = port.getAmount();

        dlgManage_lblId.setText(currSelectedId + "");
        dlgManage_tfName.setText(currSelectedName);
        dlgManage_cbbType.setSelectedIndex(currSelectedType.ordinal());
        dlgManage_cbByDefault.setSelected(currSelectedIsDef);
        dlgManage_tfCash.setText(currSelectedAmount + "");

        if (currSelectedType == Portfolio.PortType.Real) {
            dlgManage_tfCash.enable(false);
        } 
        if (currSelectedType == Portfolio.PortType.Test) {
            dlgManage_tfCash.enable(true);

        }



    }//GEN-LAST:event_lstPortfoliosValueChanged

    private void lstPortfoliosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPortfoliosMouseClicked

        dlgManage_lblId.setText(currSelectedId + "");
        dlgManage_tfName.setText(currSelectedName);
        dlgManage_cbbType.setSelectedIndex(currSelectedType.ordinal());
        dlgManage_cbByDefault.setSelected(currSelectedIsDef);
        dlgManage_tfCash.setText(currSelectedAmount + "");


    }//GEN-LAST:event_lstPortfoliosMouseClicked

    private void lstPortfoliosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstPortfoliosMouseReleased

        //Right click Roma
        if (SwingUtilities.isRightMouseButton(evt)) {
            JList list = (JList) evt.getSource();

            ppManage.show(evt.getComponent(), evt.getX(), evt.getY());

            int index = lstPortfolios.locationToIndex((evt.getPoint()));
            if (index == -1) {
                return;
            }
            list.setSelectedIndex(index);
        }
    }//GEN-LAST:event_lstPortfoliosMouseReleased

    private void dlgManage_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgManage_btnAddActionPerformed
        try {
            int id = 0;
            String name = dlgManage_tfName.getText();
            if (dlgManage_tfName.equals("")) {
                return;
            }
            Portfolio.PortType pType = Portfolio.PortType.valueOf(dlgManage_cbbType.getSelectedItem().toString());

            DecimalFormat formatter = new DecimalFormat("###.##");
            formatter.setParseBigDecimal(true);
            BigDecimal amount = (BigDecimal) formatter.parse(dlgManage_tfCash.getText() + "");

            boolean isDef = dlgManage_cbByDefault.isSelected();

            Portfolio p;

            p = new Portfolio(id, name, isDef, pType, amount);

            db.addPortfolio(p);

            reloadPortfolios();
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: you must enter a valid non-negative decimal number as the amount",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // display dialog with error message and terminate the program
            JOptionPane.showMessageDialog(this,
                    "Error adding record:\n" + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_dlgManage_btnAddActionPerformed
    
    
    //If default user exists, put his name to Username BOX and open login window
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String defUser;
        defUser = db.checkDefaultUser();
        if (defUser.equals("")) {
            lblStatus.setText("Welcome to Stock Tracker!");
            dlgUser.pack();
            dlgUser.setLocationRelativeTo(null);
            dlgUser.setVisible(true);
        } else {
            dlgUser_tfUsername.setText(defUser);
            dlgUser_cbbDefaultUser.setSelected(true);
            lblStatus.setText("Please enter your password");
            dlgUser.pack();
            dlgUser.setLocationRelativeTo(null);
            dlgUser.setVisible(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void dlgManage_btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgManage_btnDeleteActionPerformed
         if (currSelectedId == 0) {

            return;
        }

        Portfolio delPort = lstPortfolios.getSelectedValue();
        if (delPort == null) {
            return;
        }
        try {
            db.deletePortfolio(delPort);
            reloadPortfolios();
            dlgManage_tfName.setText("");
            dlgManage_tfCash.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error executing SQL query (DELETE)\n" + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dlgManage_btnDeleteActionPerformed

    private void ppManage_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppManage_DeleteActionPerformed
        if (currSelectedId == 0) {

            return;
        }

        Portfolio delPort = lstPortfolios.getSelectedValue();
        if (delPort == null) {
            return;
        }
        try {
            db.deletePortfolio(delPort);
            reloadPortfolios();
            dlgManage_tfName.setText("");
            dlgManage_tfCash.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error executing SQL query (DELETE)\n" + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ppManage_DeleteActionPerformed

    private void ppManage_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppManage_EditActionPerformed
        try {
           int id = Integer.parseInt(dlgManage_lblId.getText());
            
            String portN = dlgManage_tfName.getText();
            if (portN.equals("")) {
                return;
            }

             Portfolio.PortType portT = Portfolio.PortType.valueOf(dlgManage_cbbType.getSelectedItem().toString());
             
             boolean isDef = dlgManage_cbByDefault.isSelected();
             
            DecimalFormat formatter = new DecimalFormat("###.##");
            formatter.setParseBigDecimal(true);
            BigDecimal amount = (BigDecimal) formatter.parse(dlgManage_tfCash.getText());
            
            //System.out.println(dlgAdd_sEngine.getValue()+"");
            //System.out.println(engine);
            Portfolio p;

            p = new Portfolio(id, portN, isDef, portT, amount);

           
                db.updatePortfolio(p);
               
            dlgAdd.setVisible(false);
            reloadPortfolios();
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: you must enter a valid non-negative decimal number as the engine size",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // display dialog with error message and terminate the program
            JOptionPane.showMessageDialog(this,
                    "Error adding/updating record:\n" + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ppManage_EditActionPerformed

    private void dlgManage_btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgManage_btnEditActionPerformed
         try {
            
            

           int id = Integer.parseInt(dlgManage_lblId.getText());
            
            String portN = dlgManage_tfName.getText();
            if (portN.equals("")) {
                return;
            }

             Portfolio.PortType portT = Portfolio.PortType.valueOf(dlgManage_cbbType.getSelectedItem().toString());
             
             boolean isDef = dlgManage_cbByDefault.isSelected();
             
            DecimalFormat formatter = new DecimalFormat("###.##");
            formatter.setParseBigDecimal(true);
            BigDecimal amount = (BigDecimal) formatter.parse(dlgManage_tfCash.getText());
            
            

           

            Portfolio p;

            p = new Portfolio(id, portN, isDef, portT, amount);

           
                db.updatePortfolio(p);
               
            dlgAdd.setVisible(false);
            reloadPortfolios();
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: you must enter a valid non-negative decimal number as the engine size",
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            // display dialog with error message and terminate the program
            JOptionPane.showMessageDialog(this,
                    "Error adding/updating record:\n" + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_dlgManage_btnEditActionPerformed

    private void dlgManage_btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgManage_btnCancelActionPerformed
        dlgManage.setVisible(false);
    }//GEN-LAST:event_dlgManage_btnCancelActionPerformed

    private void dlgSignUp_lblNameQMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgSignUp_lblNameQMouseEntered
        dlgSignUp_lblNameQ.setToolTipText("Letters only, between 2 and 15 characters");
    }//GEN-LAST:event_dlgSignUp_lblNameQMouseEntered

    private void dlgSignUp_lblHelpUserNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgSignUp_lblHelpUserNameMouseEntered
        dlgSignUp_lblHelpUserName.setToolTipText( "Between 3 and 10 characters"
                + " (letters, numbers, underscore and hyphen)");
    }//GEN-LAST:event_dlgSignUp_lblHelpUserNameMouseEntered

    private void dlgSignUp_lblHelpPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgSignUp_lblHelpPasswordMouseEntered
        dlgSignUp_lblHelpPassword.setToolTipText( "Between  5 and 10 characters, at "
                            + "least one uppercase letter, one lowercase letter and one number");
    }//GEN-LAST:event_dlgSignUp_lblHelpPasswordMouseEntered

    private void dlgAdd_btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAdd_btResetActionPerformed
        resetDlgAdd();
    }//GEN-LAST:event_dlgAdd_btResetActionPerformed

    private void btMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMoveActionPerformed

    private void btAddTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTradeActionPerformed
        resetDlgAdd();
        dlgAdd.pack();
        dlgAdd.setLocationRelativeTo(null);
        dlgAdd.setVisible(true);
    }//GEN-LAST:event_btAddTradeActionPerformed

    private void dlgAdd_tfSymbolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgAdd_tfSymbolKeyTyped
        String symbol = dlgAdd_tfSymbol.getText()+ evt.getKeyChar();
        checkSymbol(symbol);
    }//GEN-LAST:event_dlgAdd_tfSymbolKeyTyped

    private void dlgAdd_tfSymbolPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dlgAdd_tfSymbolPropertyChange
        System.out.println("EE");
        checkSymbol(dlgAdd_tfSymbol.getText());
        
    }//GEN-LAST:event_dlgAdd_tfSymbolPropertyChange

    private void ppMain_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppMain_BrowseActionPerformed
        // PopUp menu - button Browse THIS
        try {
            int sRow = tTable.getSelectedRow();
            Trade t = currentTradesSet.get(sRow);
            String url = "https://www.nasdaq.com/symbol/" + t.symbol;
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI(url);
            desktop.browse(oURL);
        } catch (ArrayIndexOutOfBoundsException | URISyntaxException | IOException ex) {
        }
    }//GEN-LAST:event_ppMain_BrowseActionPerformed

    private void tTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTableMouseReleased
      
               
    }//GEN-LAST:event_tTableMouseReleased

    private void smExpExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smExpExcelActionPerformed
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            if (!path.matches(".+\\.[A-Za-z0-9]{1,20}")) {
                System.out.println("no extension match");
                file = new File(path + ".xls");
            }
            ExcelWriter ew = new ExcelWriter(file.getPath());
            try {
                ew.write(tm); // write current table model

            } catch (IOException | WriteException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error access to the file :\n" + ex.getMessage(),
                        "File saving error",
                        JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this,
                        "The portfolio was successfully exported!",
                        "Confirmation message",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_smExpExcelActionPerformed

    public void rewriteMainTable() {
        StringJoiner symbolJoiner = new StringJoiner(",");
        int quantity; 
        BigDecimal quantityBD, entry, last, change, value, gain; 
        BigDecimal totalInvested = new BigDecimal(0);
        BigDecimal totalGain = new BigDecimal(0);
        BigDecimal totalValue = new BigDecimal(0);
                
        double dPercent;
        currentTradesSet = db.updateByPortfolio();
        int rows = currentTradesSet.size();
        lblStatus.setText("Loading data ...");

        //  Start updating prices from API
        //1. Creating symbols list
        if (rows > 0) {
            for (int row = 0; row < rows; row++) {
                symbolJoiner.add(currentTradesSet.get(row).symbol);
            }
            Object[][] newData = new Object[rows][8];
            for (int row = 0; row < rows; row++) {
                newData[row][0] = currentTradesSet.get(row).symbol;
                quantity = currentTradesSet.get(row).numerOfShares;
                quantityBD = new BigDecimal(quantity);
                newData[row][1] = quantityBD;
                entry = currentTradesSet.get(row).sharePrice;
                newData[row][2] = entry;
                totalInvested = totalInvested.add(quantityBD.multiply(entry));
                lblTotalInv.setText(totalInvested.toString());
            }
            
            try {
                String url = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols=" + symbolJoiner + "&apikey=FS3KK17YEXZPQ4W5";
                JSONObject json = API.getJson(url);
                JSONArray arr = json.getJSONArray("Stock Quotes");
                for (int row = 0; row < rows; row++) {
                    JSONObject o = arr.getJSONObject(row);
                    last = o.getBigDecimal("2. price").setScale(2, RoundingMode.HALF_UP);
                    newData[row][3] = last;
                    change = last.subtract((BigDecimal) newData[row][2]);
                    newData[row][4] = change;
                    value = last.multiply((BigDecimal) newData[row][1]);
                    newData[row][5] = value;
                    gain = change.multiply((BigDecimal) newData[row][1]);
                    newData[row][6] = gain;
                    dPercent = gain.doubleValue() / ((((BigDecimal) newData[row][1]).multiply((BigDecimal) newData[row][2])).doubleValue()) * 100;
                    if (((BigDecimal)newData[row][1]).doubleValue() < 0){
                        dPercent=-dPercent;
                    } 
                    newData[row][7] = (dPercent < 0 ? "" : "+") + "" + String.format("%.2f", dPercent) + " %";
                    totalGain = totalGain.add(gain);
                    totalValue = totalValue.add(value);
                    
                    lblStatus.setText("Prices are up to date");
                    lblTotalValue.setText("$ "+ totalValue.toString());
                    lblTotalGain.setText("$ "+ totalGain.toString());
                    if(totalGain.doubleValue()<0){
                        lblTotalGainText.setText("Current loss:");
                        lblTotalGain.setForeground(Color.red);
                    }
                }
            } catch (NullPointerException ex) {
                lblStatus.setText("Error: API connection failed! Can not update the prices");
                for (int row = 0; row < rows; row++) {
                    newData[row][3] = "updating...";
                    newData[row][4] = "";
                    newData[row][5] = "";
                    newData[row][6] = "";
                    newData[row][7] = "";
                }
            }
            tm = new MyTableModel(newData);
            tTable.setModel(tm);
        } else {
            lblStatus.setText("You don't have active trades in this portfolio");
            Object[][] newData = new Object[rows][8];
            tm = new MyTableModel(newData);
            tTable.setModel(tm);
        }
        cbbPortfolio.enable(true);
    }

    private void resetDlgAdd() {
        dlgAdd_lblStatus.setText(" ");
        dlgAdd_tfNumberOfShares.setText("");
        btgAdd.clearSelection();
        dlgAdd_tfSymbol.setText("");
    }

    private void checkSymbol(String symbol) {
        
        if (symbol.matches("[a-zA-Z]+")&&symbol.length()<20 && symbol.length()>0){
            symbol = symbol.toUpperCase();
            int symbolsFound = db.checkSymbol(symbol);
            dlgAdd_lblStatus.setText(symbolsFound+" matches found");
            if (symbolsFound==1){
                dlgAdd_lblSymbolOk.setForeground(Color.green);
                dlgAdd_lblSymbolOk.setText("");
            }
        }
        else{
            dlgAdd_lblSymbolOk.setForeground(Color.red);
                dlgAdd_lblSymbolOk.setText("X");
//            JOptionPane.showMessageDialog(this,
//                    "Error: unable to reload transactions\n",
//                    "Database error",
//                    JOptionPane.ERROR_MESSAGE);
        }
    }

    class ItemChangeListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                lblTotalValue.setText("");
                lblTotalGain.setText("");
                lblTotalInv.setText("");
                lblTotalGainText.setText("Current profit:");
                lblTotalGain.setForeground(Color.black);
                int ind = cbbPortfolio.getSelectedIndex();
                Portfolio port = cbbPortfolioModel.getElementAt(ind);
                cbbPortfolio.enable(false);
                currentPortfolio = port;
                if (port.isIsDefault()) {
                    cbIsDefaultPortfolio.setSelected(true);
                }else{
                    cbIsDefaultPortfolio.setSelected(false);
                }
                if(!Globals.firstLoad){
                    rewriteMainTable();                  
                }
            }
        }
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
    private javax.swing.JComboBox<Portfolio> cbbPortfolio;
    private javax.swing.JDialog dlgAdd;
    private javax.swing.JButton dlgAdd_btAdd;
    private javax.swing.JButton dlgAdd_btCancel;
    private javax.swing.JButton dlgAdd_btReset;
    private javax.swing.JLabel dlgAdd_lblStatus;
    private javax.swing.JLabel dlgAdd_lblSymbolOk;
    private javax.swing.JRadioButton dlgAdd_rbBuy;
    private javax.swing.JRadioButton dlgAdd_rbCoverShort;
    private javax.swing.JRadioButton dlgAdd_rbSell;
    private javax.swing.JRadioButton dlgAdd_rbShortSell;
    private javax.swing.JTextField dlgAdd_tfNumberOfShares;
    private javax.swing.JTextField dlgAdd_tfSymbol;
    private javax.swing.JDialog dlgManage;
    private javax.swing.JButton dlgManage_btnAdd;
    private javax.swing.JButton dlgManage_btnCancel;
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
    private javax.swing.JLabel dlgSignUp_lblNameQ;
    private javax.swing.JLabel dlgSignUp_lblPassOk;
    private javax.swing.JLabel dlgSignUp_lblUserOk;
    private javax.swing.JButton dlgSignUp_rbtCancel;
    private javax.swing.JTextField dlgSignUp_tfName;
    private javax.swing.JPasswordField dlgSignUp_tfPassConfirmation;
    private javax.swing.JPasswordField dlgSignUp_tfPassword;
    private javax.swing.JTextField dlgSignUp_tfUsername;
    private javax.swing.JDialog dlgUser;
    private javax.swing.JButton dlgUser_btCancel;
    private javax.swing.JButton dlgUser_btLogin;
    private javax.swing.JButton dlgUser_btSignUp;
    private javax.swing.JCheckBox dlgUser_cbbDefaultUser;
    private javax.swing.JPasswordField dlgUser_tfPassword;
    private javax.swing.JTextField dlgUser_tfUsername;
    private javax.swing.JFileChooser fileChooser;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblTotalGain;
    private javax.swing.JLabel lblTotalGainText;
    private javax.swing.JLabel lblTotalInv;
    private javax.swing.JLabel lblTotalValue;
    private javax.swing.JList<Portfolio> lstPortfolios;
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
    private javax.swing.JMenuItem ppMain_Browse;
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
