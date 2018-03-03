/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.torod.core.language.update;

import com.torodb.torod.core.language.AttributeReference;
import com.torodb.torod.core.language.update.utils.UpdateActionVisitor;
import java.util.Collection;
import com.torodb.kvdocument.values.KVValue;

/**
 *
 */
public class SetFieldUpdateAction extends SingleFieldUpdateAction {
    
    private final KVValue newValue;

    public SetFieldUpdateAction(
            Collection<AttributeReference> modifiedField, 
            KVValue newValue
    ) {
        super(modifiedField);
        this.newValue = newValue;
    }

    public KVValue getNewValue() {
        return newValue;
    }

    @Override
    public <Result, Arg> Result accept(
            UpdateActionVisitor<Result, Arg> visitor, 
            Arg argument
    ) {
        return visitor.visit(this, argument);
    }
    
}
