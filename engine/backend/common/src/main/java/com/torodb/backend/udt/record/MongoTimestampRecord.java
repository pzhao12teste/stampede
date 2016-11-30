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

package com.torodb.backend.udt.record;

import com.torodb.backend.udt.MongoTimestampUDT;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UDTRecordImpl;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value = {"http://www.jooq.org", "3.4.1"},
    comments = "This class is generated by jOOQ")
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class MongoTimestampRecord extends UDTRecordImpl<MongoTimestampRecord> implements
    Record2<Integer, Integer> {

  private static final long serialVersionUID = -103355438;

  public void setSecs(Integer secs) {
    setValue(0, secs);
  }

  public Integer getSecs() {
    return (Integer) getValue(0);
  }

  public void setCounter(Integer counter) {
    setValue(1, counter);
  }

  public Integer getCounter() {
    return (Integer) getValue(1);
  }

  // -------------------------------------------------------------------------
  // Record2 type implementation
  // -------------------------------------------------------------------------
  @Override
  public Row2<Integer, Integer> fieldsRow() {
    return (Row2) super.fieldsRow();
  }

  @Override
  public Row2<Integer, Integer> valuesRow() {
    return (Row2) super.valuesRow();
  }

  @Override
  public Field<Integer> field1() {
    return MongoTimestampUDT.COUNTER;
  }

  @Override
  public Field<Integer> field2() {
    return MongoTimestampUDT.SECS;
  }

  @Override
  public Integer value1() {
    return getSecs();
  }

  @Override
  public Integer value2() {
    return getCounter();
  }

  @Override
  public MongoTimestampRecord value1(Integer value) {
    setSecs(value);
    return this;
  }

  @Override
  public MongoTimestampRecord value2(Integer value) {
    setCounter(value);
    return this;
  }

  @Override
  public MongoTimestampRecord values(Integer value1, Integer value2) {
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------
  /**
   * Create a detached MongoTimestamPRecord
   */
  public MongoTimestampRecord() {
    super(MongoTimestampUDT.MONGO_TIMESTAMP);
  }

  public MongoTimestampRecord(Integer secs, Integer counter) {
    super(MongoTimestampUDT.MONGO_TIMESTAMP);

    setValue(0, secs);
    setValue(1, counter);
  }
}
