/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999, 2000 The Apache Software Foundation.  All rights
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
package org.apache.tools.ant.gui.customizer;

import javax.swing.*;
import java.awt.Component;

/**
 * Custom property editor for editing double values.
 * 
 * @version $Revision: 1.1.1.1 $ 
 * @author Simeon Fitch 
 */
public class DoublePropertyEditor extends AbstractPropertyEditor {
    /** Editing widget. */
    private JTextField _widget = null;

    /** 
     * Default ctor.
     * 
     */
    public DoublePropertyEditor() {
        _widget = new JTextField();
        _widget.addFocusListener(new FocusHandler(this));
    }

    /** 
     * Get the child editing component. Uses JComponent so we can have tool
     * tips, etc.
     * 
     * @return Child editing component.
     */
    protected Component getChild() {
        return _widget;
    }

    /**
     * This method is intended for use when generating Java code to set
     * the value of the property.  It should return a fragment of Java code
     * that can be used to initialize a variable with the current property
     * value.
     * <p>
     * Example results are "2", "new Color(127,127,34)", "Color.orange", etc.
     *
     * @return A fragment of Java code representing an initializer for the
     *      current value.
     */
    public String getJavaInitializationString() {
        return "new Double(" + getAsText() + ")";
    }

    /**
     * Set (or change) the object that is to be edited.  Builtin types such
     * as "int" must be wrapped as the corresponding object type such as
     * "java.lang.Integer".
     *
     * @param value The new target object to be edited.  Note that this
     *     object should not be modified by the PropertyEditor, rather 
     *     the PropertyEditor should create a new object to hold any
     *     modified value.
     */
    public void setValue(Object value) {
        Object old = _widget.getText();
        if(!(value instanceof Double)) {
            value = new Double(0);
        }

        _widget.setText(value.toString());
    }

    /**
     * @return The value of the property.  Builtin types such as "int" will
     * be wrapped as the corresponding object type such as "java.lang.Integer".
     */
    public Object getValue() {
        Double retval = null;
        try {
            retval = new Double(_widget.getText());
        }
        catch(NumberFormatException ex) {
            retval = new Double(0);
            _widget.setText(retval.toString());
        }
        return retval;
    }

    /**
     * Set the property value by parsing a given String.  May raise
     * java.lang.IllegalArgumentException if either the String is
     * badly formatted or if this kind of property can't be expressed
     * as text.
     * @param text  The string to be parsed.
     */
    public void setAsText(String text) {
        Object old = _widget.getText();
        Double val = null;
        try {
            val = new Double(text);
        }
        catch(NumberFormatException ex) {
            val = new Double(0);
        }
        text = val.toString();
        _widget.setText(text);
    }

    /**
     * @return The property value as a human editable string.
     * <p>   Returns null if the value can't be expressed 
     *       as an editable string.
     * <p>   If a non-null value is returned, then the PropertyEditor should
     *       be prepared to parse that string back in setAsText().
     */
    public String getAsText() {
        return _widget.getText();
    } 
}


