/*
* Copyright (c) 2010-2012 Research In Motion Limited. All rights reserved.
*
* This program and the accompanying materials are made available
* under the terms of the Eclipse Public License, Version 1.0,
* which accompanies this distribution and is available at
*
* http://www.eclipse.org/legal/epl-v10.html
*
*/
package net.rim.ejde.internal.ui.editors.locale;

import net.rim.sdk.resourceutil.ResourceElement;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Shell;

class ResourceValueModifier implements ICellModifier {
    private Shell _shell;
    private IResourceCellEditor _cellEditor;

    private static final String _property = ResourceEditorPage.VALUE_COLUMN_ID;

    ResourceValueModifier( Shell shell, IResourceCellEditor cellEditor ) {
        _shell = shell;
        _cellEditor = cellEditor;
    }

    public boolean canModify( Object element, String property ) {
        if( element instanceof ResourceElement && _property.equals( property ) ) {
            return true;
        }

        return false;
    }

    public Object getValue( Object element, String property ) {
        if( element instanceof ResourceElement && _property.equals( property ) ) {
            return ( (ResourceElement) element ).getValue();
        }

        return null;
    }

    public void modify( Object element, String property, Object value ) {
        // null indicates that the validator rejected the value.
        if( value == null ) {
            showError( _cellEditor.getErrorMessage() );
            return;
        }

        if( element instanceof Item ) {
            element = ( (Item) element ).getData();
        }

        if( element instanceof ResourceElement && _property.equals( property ) ) {
            ResourceElement resElement = (ResourceElement) element;
            resElement.getLocale().changeValue( resElement.getKey(), value );
        }
    }

    private void showError( String message ) {
        MessageDialog.openError( _shell, "Error - Resource Editor", message );
    }
}
