/*
 * ToroDB
 * Copyright © 2014 8Kdata Technology (www.8kdata.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.torodb.backend.jobs;

import com.torodb.core.backend.WriteBackendTransaction;
import com.torodb.core.dsl.backend.AddDatabaseDdlJob;
import com.torodb.core.transaction.metainf.MetaDatabase;

public class AddDatabaseDdlJobImpl implements AddDatabaseDdlJob {

  private final MetaDatabase db;

  public AddDatabaseDdlJobImpl(MetaDatabase db) {
    super();
    this.db = db;
  }

  @Override
  public void execute(WriteBackendTransaction connection) {
    connection.addDatabase(db);
  }

  @Override
  public MetaDatabase getDatabase() {
    return db;
  }

  @Override
  public String toString() {
    return "add database{db:" + db + '}';
  }

}
