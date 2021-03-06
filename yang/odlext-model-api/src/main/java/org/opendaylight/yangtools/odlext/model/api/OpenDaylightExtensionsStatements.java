/*
 * Copyright (c) 2017 Pantheon Technologies, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.odlext.model.api;

import static java.util.Objects.requireNonNull;

import com.google.common.annotations.Beta;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.model.api.meta.DeclaredStatement;
import org.opendaylight.yangtools.yang.model.api.meta.EffectiveStatement;
import org.opendaylight.yangtools.yang.model.api.meta.StatementDefinition;

@Beta
public enum OpenDaylightExtensionsStatements implements StatementDefinition {
    // FIXME: this extension is not present in yang-ext.yang as published by mdsal
    ANYXML_SCHEMA_LOCATION(QName.create(OpenDaylightExtensionsConstants.ORIGINAL_MODULE, "anyxml-schema-location"),
        "target-node", AnyxmlSchemaLocationStatement.class, AnyxmlSchemaLocationEffectiveStatement.class);
    // FIXME: add augment-identifier
    // FIXME: add rpc-context-instance
    // FIXME: add context-reference
    // FIXME: add context-instance
    // FIXME: add instance-target

    private final Class<? extends EffectiveStatement<?, ?>> effectiveRepresentation;
    private final Class<? extends DeclaredStatement<?>> declaredRepresentation;
    private final QName statementName;
    private final QName argumentName;

    OpenDaylightExtensionsStatements(final QName statementName, final String argumentName,
            final Class<? extends DeclaredStatement<?>> declaredRepresentation,
            final Class<? extends EffectiveStatement<?, ?>> effectiveRepresentation) {
        this.statementName = statementName.intern();
        this.argumentName = QName.create(statementName, argumentName);
        this.declaredRepresentation = requireNonNull(declaredRepresentation);
        this.effectiveRepresentation = requireNonNull(effectiveRepresentation);
    }

    @Nonnull
    private static QName createQName(final String namespace, final String localName) {
        return QName.create(namespace, localName).intern();
    }

    @Nonnull
    private static QName createQName(final String namespace, final String revision, final String localName) {
        return QName.create(namespace, revision, localName).intern();
    }

    @Nonnull
    @Override
    public QName getStatementName() {
        return statementName;
    }

    @Override
    @Nullable
    public QName getArgumentName() {
        return argumentName;
    }

    @Override
    @Nonnull
    public Class<? extends DeclaredStatement<?>> getDeclaredRepresentationClass() {
        return declaredRepresentation;
    }

    @Nonnull
    @Override
    public Class<? extends EffectiveStatement<?, ?>> getEffectiveRepresentationClass() {
        return effectiveRepresentation;
    }

    @Override
    public boolean isArgumentYinElement() {
        return false;
    }
}
