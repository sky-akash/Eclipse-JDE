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
package net.rim.ejde.internal.ui.wizards.templates;

import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;

public class BlankAppNewWizard extends NewBBTemplateWizard {

    public static final String ID = "net.rim.ejde.blankWizard";

    /**
     * Constructor for BlankAppNewWizard.
     */
    public BlankAppNewWizard() {
        super();
    }

    public void init( IFieldData data ) {
        super.init( data );
        setWindowTitle( "BlackBerry Application" );
    }

    /*
     * @see NewExtensionTemplateWizard#createTemplateSections()
     */
    public ITemplateSection[] createTemplateSections() {
        BlankAppTemplate template = new BlankAppTemplate();
        return new ITemplateSection[] { template };
    }
}
