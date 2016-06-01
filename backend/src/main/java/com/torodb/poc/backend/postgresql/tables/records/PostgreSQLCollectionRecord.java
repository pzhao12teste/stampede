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
package com.torodb.poc.backend.postgresql.tables.records;

import com.torodb.poc.backend.postgresql.tables.PostgreSQLCollectionTable;
import com.torodb.poc.backend.tables.records.MetaCollectionRecord;

public class PostgreSQLCollectionRecord extends MetaCollectionRecord {

    private static final long serialVersionUID = -6808738482552131596L;

	/**
	 * Create a detached MetaCollectionRecord
	 */
	public PostgreSQLCollectionRecord() {
		super(PostgreSQLCollectionTable.COLLECTION);
	}

    @Override
    public MetaCollectionRecord values(String database, String name) {
        
        setValue(0, database);
        setValue(1, name);
        return this;
    }

	/**
	 * Create a detached, initialised MetaCollectionRecord
	 */
	public PostgreSQLCollectionRecord(String database, String name) {
		super(PostgreSQLCollectionTable.COLLECTION);
		
		values(database, name);
	}
}
