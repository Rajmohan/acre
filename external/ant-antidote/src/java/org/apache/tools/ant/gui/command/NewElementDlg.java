/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000 - 2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "Ant" and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

package org.apache.tools.ant.gui.command;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.gui.util.Collections;

/**
 * A Dialog which asks for a new xml element's type.
 * 
 * @version $Revision: 1.1.1.1 $
 * @author Nick Davis<a href="mailto:nick_home_account@yahoo.com">nick_home_account@yahoo.com</a>, Christoph Wilhelms<a href="mailto:christoph.wilhelms@t-online.de">christoph.wilhelms@t-online.de</a>
 */
public class NewElementDlg extends javax.swing.JDialog {
    // Dialog's components
    private javax.swing.JPanel _southPanel;
    private javax.swing.JPanel _buttonPanel;
    private javax.swing.JButton _buttonOK;
    private javax.swing.JButton _buttonCancel;
    private javax.swing.JCheckBox _optionalButton;
    private javax.swing.JPanel _selectPanel;
    private javax.swing.JPanel _panelData;
    private javax.swing.JLabel _label;
    private javax.swing.JTextField _elementText;
    private javax.swing.JScrollPane _listScrollPane;
    private javax.swing.JList _elementList;
    /** set to true if cancel is pressed */
    private boolean _cancel = true;
    /** holds the element type */
    private String _elementName;
    /** list of core tasks */
    private List _coreElements;
    /** list of optional tasks */
    private List _optionalElements;
    /** list of tasks to display */
    private List _elements;

    /**
     * Creates new form NewElementDlg
     */
    public NewElementDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        enableButtons();
    }
    
    /**
     * Fills the listbox with the input list.
     */
    public void setLists(String[] coreElements, String[] optionalElements) {

        // Are there any items to display?
        if ( (coreElements == null || coreElements.length == 0) &&
             (optionalElements == null || optionalElements.length == 0 ) ) {

            // Hide the list
            _listScrollPane.setVisible(false);
            _optionalButton.setVisible(false);
        } else {
            
            // Are there any core elements?
            if (coreElements == null) {
                _coreElements = new ArrayList();
                
                // Display the optional elements
                _optionalButton.setSelected(true);
                _optionalButton.setVisible(false);
            } else {
                // Create a sorted list of the core elements
                List temp = Collections.fill(null, coreElements);
                java.util.Collections.sort(temp);
                _coreElements = temp;
            }
            
            // Are there any optional elements?
            if (optionalElements == null) {
                _optionalElements = new ArrayList();
                
                // Display the core elements
                _optionalButton.setSelected(false);
                _optionalButton.setVisible(false);
            } else {
                // Create a sorted list of the optional elements
                List temp = Collections.fill(null, optionalElements);
                java.util.Collections.sort(temp);
                _optionalElements = temp;
            }
            
            // Are the lists the same?
            if (_optionalElements.containsAll(_coreElements) &&
                _coreElements.containsAll(_optionalElements) ) {
                    
                // Hide the button
                _optionalButton.setVisible(false);
            }
        }
        enableButtons();
    }
    
    /**
     * Returns true if cancel was pressed
     */
    public boolean getCancel() {
        return _cancel;
    }
    
    /**
     * Returns the entered element type
     */
    public String getElementName() {
        return _elementName;
    }

    /**
     * Enable or disable buttons
     */
    private void enableButtons() {
        
        // Enable the OK button?
        if (isInputValid()) {
            _buttonOK.setEnabled(true);
        } else {
            _buttonOK.setEnabled(false);
        }

        // Display the core or optional elements?
        Object oldList = _elements;
        if (_optionalButton.isSelected()) {
            _elements = _optionalElements;
        } else {
            _elements = _coreElements;
        }

        // Did the list change?
        if (oldList != _elements) {
            _elementList.setListData(_elements.toArray());
        }
    }
    
    /**
     * Returns true if the user input is valid.
     */
    private boolean isInputValid() {
        return ( isXMLName( _elementText.getText() ) );
    }
    
    /**
     * Returns true if the value is a legal XML name.
     *
     * @param value the string being tested
     */
    public boolean isXMLName (String value)
    {
	if (value == null || value.length() == 0)
	    return false;

	char c = value.charAt (0);
	if (!isLetter (c) && c != '_' && c != ':')
	    return false;
	for (int i = 1; i < value.length (); i++)
	    if (!isNameChar (value.charAt (i)))
		return false;
	return true;
    }
    
    /**
     * Returns true if the character is allowed to be a non-initial
     * character in an XML name.
     */
    public boolean isNameChar (char c)
    {
	if (isLetter (c))
	    return true;
	else if (c == '>')
	    return false;
	else if (c >= '0' && c <= '9')
	    return true;
	else if (c == '.' || c == '-' || c == '_' || c == ':')
	    return true;
	else
	    return false;
    }
    
    /**
     * Returns true if the character is a letter.
     */
    public boolean isLetter (char c)
    {
	if (c >= 'a' && c <= 'z')
	    return true;
	if (c >= 'A' && c <= 'Z')
	    return true;

        return false;
    }
    
    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {
        _southPanel = new javax.swing.JPanel();
        _buttonPanel = new javax.swing.JPanel();
        _buttonOK = new javax.swing.JButton();
        _buttonCancel = new javax.swing.JButton();
        _selectPanel = new javax.swing.JPanel();
        _panelData = new javax.swing.JPanel();
        _label = new javax.swing.JLabel();
        _elementText = new javax.swing.JTextField();
        _listScrollPane = new javax.swing.JScrollPane();
        _elementList = new javax.swing.JList();
        _optionalButton = new javax.swing.JCheckBox(
            "show type elements", false);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        }
        );
        
        _southPanel.setLayout(new java.awt.FlowLayout(2, 2, 0));
        _southPanel.setPreferredSize(new java.awt.Dimension(156, 50));
        _southPanel.setMinimumSize(new java.awt.Dimension(154, 50));
        
        _buttonPanel.setLayout(new java.awt.FlowLayout(1, 2, 0));
        _buttonPanel.setPreferredSize(new java.awt.Dimension(146, 50));
        _buttonPanel.setMinimumSize(new java.awt.Dimension(150, 50));
        _buttonPanel.setAlignmentY(0.0F);
        _buttonPanel.setAlignmentX(0.0F);
        
        _buttonOK.setText("OK");
        _buttonOK.setPreferredSize(new java.awt.Dimension(50, 30));
        _buttonOK.setMaximumSize(new java.awt.Dimension(50, 30));
        _buttonOK.setMargin(new java.awt.Insets(10, 10, 10, 10));
        _buttonOK.setMinimumSize(new java.awt.Dimension(50, 30));
        _buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickOK(evt);
            }
        }
        );
        _buttonPanel.add(_buttonOK);
        _buttonCancel.setText("Cancel");
        _buttonCancel.setPreferredSize(new java.awt.Dimension(70, 30));
        _buttonCancel.setMaximumSize(new java.awt.Dimension(60, 30));
        _buttonCancel.setMargin(new java.awt.Insets(10, 10, 10, 10));
        _buttonCancel.setMinimumSize(new java.awt.Dimension(60, 30));
        _buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickCancel(evt);
            }
        }
        );
        _buttonPanel.add(_buttonCancel);
        _southPanel.add(_buttonPanel);
        getContentPane().add(_southPanel, java.awt.BorderLayout.SOUTH);
        _selectPanel.setLayout(new java.awt.BorderLayout(10, 10));
        _selectPanel.setBorder(new javax.swing.border.EtchedBorder());
        _label.setText("Element Type:");
        _label.setAlignmentX(0.5F);
        _panelData.add(_label);
        
        
        _elementText.setPreferredSize(new java.awt.Dimension(110, 25));
        _elementText.setMargin(new java.awt.Insets(2, 2, 2, 2));
        _elementText.setMinimumSize(new java.awt.Dimension(14, 25));
        _elementText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                _elementTextKeyReleased(evt);
            }
        }
        );
        _panelData.add(_elementText);
        
        _selectPanel.add(_panelData, java.awt.BorderLayout.SOUTH);
        
        _elementList.setMaximumSize(new java.awt.Dimension(100, 20));
        _elementList.setMinimumSize(new java.awt.Dimension(10, 10));
        _elementList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                itemSelected(evt);
            }
        }
        );
        _elementList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemMouseClicked(evt);
            }
        }
        );
        _listScrollPane.setViewportView(_elementList);
       
        _optionalButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        _optionalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableButtons();
            }
        }
        );

        _selectPanel.add(_optionalButton, java.awt.BorderLayout.NORTH);
        _selectPanel.add(_listScrollPane, java.awt.BorderLayout.CENTER);
        getContentPane().add(_selectPanel, java.awt.BorderLayout.CENTER);
        pack();
    }

    /** Called when a key is released */
    private void _elementTextKeyReleased(java.awt.event.KeyEvent evt) {
        enableButtons();
    }

    /** Called when an item is selected from the list */
    private void itemSelected(javax.swing.event.ListSelectionEvent evt) {
        // Update the text field
        _elementText.setText((String) _elementList.getSelectedValue());
        enableButtons();
    }

    /** Called when the list is clicked */
    private void itemMouseClicked(java.awt.event.MouseEvent evt) {
        
        int count = evt.getClickCount();
        Object obj = _elementList.getSelectedValue();
        
        // Double click on an item?
        if (count == 2 && obj != null) {
            
            // Update the text field
            _elementText.setText((String) _elementList.getSelectedValue());
            
            // Process like OK was pressed
            if (isInputValid()) {
                clickOK(null);
            }
        }
    }
    
    /** Called when the Cancel button is pressed */
    private void clickCancel(java.awt.event.ActionEvent evt) {
        
        // Make us invisible
        setVisible(false);
        dispose();
        
        // Set the cancel flag
        _cancel = true;
    }

    /** Called when the OK button is pressed */
    private void clickOK(java.awt.event.ActionEvent evt) {
        
        // Make us invisible
        setVisible(false);
        dispose();

        // Return selected item.
        _cancel = false;
        _elementName = _elementText.getText();
    }

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {
        setVisible(false);
        dispose();
    }

    /**
     * Test the dialog
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new NewElementDlg(new javax.swing.JFrame(), true).show();
    }
}
