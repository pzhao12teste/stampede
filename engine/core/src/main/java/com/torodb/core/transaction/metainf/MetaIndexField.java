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

package com.torodb.core.transaction.metainf;

import com.torodb.core.TableRef;

import javax.annotation.Nonnull;

/**
 *
 */
public interface MetaIndexField {

  @Nonnull
  public abstract int getPosition();

  @Nonnull
  public abstract TableRef getTableRef();

  /**
   * The name of the field to index on the document model.
   *
   * @return
   */
  @Nonnull
  public abstract String getName();

  @Nonnull
  public abstract FieldIndexOrdering getOrdering();

  public abstract boolean isCompatible(MetaDocPart docPart);

  public abstract boolean isCompatible(MetaDocPart docPart, MetaDocPartIndexColumn indexColumn);

  public abstract boolean isMatch(MetaDocPart docPart, String identifier,
      MetaDocPartIndexColumn indexColumn);

  public abstract boolean isMatch(MetaIndexField otherIndexField);

  public default String defautToString() {
    return "indexField{" + "position:" + getPosition() + ", tableRef:" + getTableRef() + ", name:"
        + getName() + ", ordering:" + getOrdering() + '}';
  }
}
