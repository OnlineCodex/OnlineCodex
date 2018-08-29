package oc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class ModalDialog extends JDialog {
 
	   
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTextPane jTextPane = null; 
	public static Image oCLogo = null;
	
    public ModalDialog(String s, boolean enabled) {
        initComponents(s);    
        okButton.setEnabled(enabled);
        setModal(true);       
    }

    public void setEnabled(boolean e)
    {
      okButton.setEnabled(e);
    }
    public void setText(String s)
    {
    	jTextPane.setText(s);
    }
    
    public void appendText(String s)
    {
      String t = jTextPane.getText();
      t += "\n" + s;
      jTextPane.setText(t);
    }
    
    private void initComponents(String s)//GEN-BEGIN:initComponents
    {
      //this.setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Validierungsinformationen");
        oCLogo = new ImageIcon(OnlineCodex.getInstance().getClass().getClassLoader().getResource("oc/sysimages/oCLogo.png")).getImage();
        this.setIconImage(oCLogo);
        this.setSize(50, 100);
        this.setContentPane(getJPanel(s));
        
        pack();
        
        Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
          Dimension labelSize = jScrollPane.getPreferredSize();
          setLocation(screenSize.width/2 - (labelSize.width/2),
                      screenSize.height/2 - (labelSize.height/2));
    }
    
 
  /**
   * This method initializes jPanel 
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel getJPanel(String s) {
    if (jPanel == null) {
      GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
      gridBagConstraints1.gridx = 0;  // Generated
      gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;  // Generated
      gridBagConstraints1.gridy = 1;  // Generated
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;  // Generated
      gridBagConstraints.gridy = 0;  // Generated
      gridBagConstraints.weightx = 1.0;  // Generated
      gridBagConstraints.weighty = 1.0;  // Generated
      gridBagConstraints.insets = new java.awt.Insets(4,4,4,4);  // Generated
      gridBagConstraints.gridx = 0;  // Generated
      jPanel = new JPanel();
      jPanel.setLayout(new GridBagLayout());  // Generated
      jPanel.add(getJScrollPane(s), gridBagConstraints);  // Generated
      jPanel.add(getButtonPanel(), gridBagConstraints1);
    }
    return jPanel;
  }



  /**
   * This method initializes jScrollPane  
   *  
   * @return javax.swing.JScrollPane  
   */
  private JScrollPane getJScrollPane(String s) {
    if (jScrollPane == null) {
      jScrollPane = new JScrollPane();
      jScrollPane.setPreferredSize(new java.awt.Dimension(600,200));  // Generated
      jScrollPane.setViewportView(getJTextPane(s));  // Generated
    }
    return jScrollPane;
  }



  /**
   * This method initializes jTextArea  
   *  
   * @return javax.swing.JTextArea  
   */
  private JTextPane getJTextPane(String s) {
    if (jTextPane == null) {
    
      jTextPane = new JTextPane();
     
      StyledDocument doc = jTextPane.getStyledDocument();      
	  //  Set alignment to be centered for all paragraphs
	  MutableAttributeSet standard = new SimpleAttributeSet();
	  StyleConstants.setAlignment(standard, StyleConstants.ALIGN_CENTER);
	  doc.setParagraphAttributes(0, 0, standard, true);	 
	  
	  MutableAttributeSet keyWord = new SimpleAttributeSet();
	  StyleConstants.setForeground(keyWord, Color.red);
	  StyleConstants.setFontFamily(keyWord, "arial");
	  StyleConstants.setFontSize(keyWord, 12);
	  StyleConstants.setBold(keyWord, true);
	  
	  jTextPane.setText(s);
	  
	  //  Highlight some keywords	  
	  doc.setCharacterAttributes(0, s.length(), keyWord, false);
	  
      jTextPane.setEditable(false);
     
 
    }
    return jTextPane;
  }

  /**
   * This method initializes buttonPanel  
   *  
   * @return javax.swing.JPanel 
   */
  private JPanel buttonPanel = null;
  private JPanel getButtonPanel() {
    if (buttonPanel == null) {
      buttonPanel = new JPanel();
      buttonPanel.add(getOkButton(), null);  // Generated
      
    }
    return buttonPanel;
  }



  /**
   * This method initializes okButton 
   *  
   * @return javax.swing.JButton  
   */
  private JButton okButton = null;
  private JButton getOkButton() {
    if (okButton == null) {
      okButton = new JButton();
      okButton.setText("OK");
      okButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          doOk();
        }
      });
    }
    return okButton;
  }

  private void doOk()
  {
    this.dispose();
  }
}
