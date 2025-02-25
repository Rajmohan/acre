/**
 *   Copyright 2004-2005 Sun Microsystems, Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.acre.visualizer.ui.pqleditor;

import org.acre.common.AcreStringUtil;
import org.acre.visualizer.ui.Main;

import javax.swing.JDialog;

/**
 *
 * @author  Administrator
 */
public class MakePDMForm extends javax.swing.JPanel {
    
    /** Creates new form MakePDMForm */
    public MakePDMForm() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        pdmNameLabel = new javax.swing.JLabel();
        pdmNameTF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        pdmNameLabel.setText("Enter PDM Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(pdmNameLabel, gridBagConstraints);

        pdmNameTF.setColumns(25);
        pdmNameTF.setToolTipText("Enter a unique PDM Name for the New PDM");
        pdmNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdmNameTFActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        add(pdmNameTF, gridBagConstraints);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/acre/visualizer/ui/icons/buttons/SaveButton.gif")));
        saveButton.setMnemonic('S');
        saveButton.setToolTipText("Save Query Argument");
        saveButton.setBorderPainted(false);
        saveButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jPanel1.add(saveButton);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/acre/visualizer/ui/icons/buttons/CancelButton.gif")));
        cancelButton.setBorderPainted(false);
        cancelButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.add(cancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

    }//GEN-END:initComponents

    private void pdmNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdmNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pdmNameTFActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancelMakePDM();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveMakePDM();
    }//GEN-LAST:event_saveButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pdmNameLabel;
    private javax.swing.JTextField pdmNameTF;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    JDialog myDialog;
    boolean canceled = false;

    public JDialog getDialog() {
        return myDialog;
    }

    public void setDialog(JDialog myDialog) {
        this.myDialog = myDialog;
    }

    private void cancelMakePDM() {
        canceled = true;
        hideMe();
    }

    public void hideMe() {
        if (myDialog!= null)
            myDialog.setVisible(false);
    }

    public void showMe() {
        if (myDialog != null)
            myDialog.setVisible(true);
    }

    String pdmName;

    private void saveMakePDM() {
        canceled = false;
        pdmName = pdmNameTF.getText();
        if (AcreStringUtil.isEmpty(pdmNameTF.getText())) {
            Main.showMainInfo("PDM Name cannot be null or empty",
                    "Make PDM Error");
        }
        hideMe();
    }

    public String getPdmName() {
        return pdmName;
    }

    public void setPdmName(String pdmName) {
        canceled = false;
        pdmNameTF.setText(pdmName);
        this.pdmName = pdmName;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
