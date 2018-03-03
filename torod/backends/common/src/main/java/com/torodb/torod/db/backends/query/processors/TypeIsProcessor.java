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

package com.torodb.torod.db.backends.query.processors;

import com.torodb.torod.core.language.querycriteria.QueryCriteria;
import com.torodb.torod.core.language.querycriteria.TypeIsQueryCriteria;
import com.torodb.torod.core.language.querycriteria.utils.QueryCriteriaVisitor;
import com.torodb.torod.db.backends.query.ProcessedQueryCriteria;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class TypeIsProcessor {

    public static List<ProcessedQueryCriteria> process(
            TypeIsQueryCriteria criteria,
            QueryCriteriaVisitor<List<ProcessedQueryCriteria>, Void> visitor) {

        QueryCriteria structureQuery = Utils.getStructureQueryCriteria(criteria.getAttributeReference(), criteria.getExpectedType());
        
        if (Utils.isTypeKnownInStructure(criteria.getAttributeReference())) {
            return Collections.singletonList(new ProcessedQueryCriteria(structureQuery, null));
        } else {
            return Collections.singletonList(new ProcessedQueryCriteria(structureQuery, criteria));
        }
    }
}
