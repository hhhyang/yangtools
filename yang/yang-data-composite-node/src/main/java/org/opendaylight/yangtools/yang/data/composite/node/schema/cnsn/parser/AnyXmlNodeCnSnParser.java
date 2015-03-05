/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.data.composite.node.schema.cnsn.parser;

import javax.xml.transform.dom.DOMSource;
import org.opendaylight.yangtools.yang.data.api.Node;
import org.opendaylight.yangtools.yang.data.impl.schema.transform.base.parser.AnyXmlNodeBaseParser;
import org.opendaylight.yangtools.yang.model.api.AnyXmlSchemaNode;

public class AnyXmlNodeCnSnParser extends AnyXmlNodeBaseParser<Node<?>> {

    public AnyXmlNodeCnSnParser() {
        super();
    }

    @Override
    protected DOMSource parseAnyXml(Node<?> element, AnyXmlSchemaNode schema) {
        // This will be removed
        return null;
    }
}
