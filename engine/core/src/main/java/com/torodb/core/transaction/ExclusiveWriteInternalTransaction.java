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

package com.torodb.core.transaction;

import com.torodb.core.backend.BackendConnection;
import com.torodb.core.backend.ExclusiveWriteBackendTransaction;
import com.torodb.core.transaction.metainf.MetainfoRepository;
import com.torodb.core.transaction.metainf.MetainfoRepository.SnapshotStage;
import com.torodb.core.transaction.metainf.MutableMetaSnapshot;

import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.function.Function;

/**
 *
 */
public class ExclusiveWriteInternalTransaction
    extends WriteInternalTransaction<ExclusiveWriteBackendTransaction> {

  private ExclusiveWriteInternalTransaction(MetainfoRepository metainfoRepository,
      MutableMetaSnapshot metaSnapshot, ExclusiveWriteBackendTransaction backendTransaction,
      WriteLock writeLock) {
    super(metainfoRepository, metaSnapshot, backendTransaction, writeLock);
  }

  static ExclusiveWriteInternalTransaction createExclusiveWriteTransaction(
      BackendConnection backendConnection, MetainfoRepository metainfoRepository) {
    WriteLock exclusiveLock = exclusiveLock();
    exclusiveLock.lock();
    try {
      return createWriteTransaction(metainfoRepository, snapshot ->
          new ExclusiveWriteInternalTransaction(metainfoRepository, snapshot, backendConnection
              .openExclusiveWriteTransaction(), exclusiveLock));
    } catch (Throwable throwable) {
      exclusiveLock.unlock();
      throw throwable;
    }
  }

  protected static <T extends WriteInternalTransaction<?>> T createWriteTransaction(
      MetainfoRepository metainfoRepository,
      Function<MutableMetaSnapshot, T> internalTransactionSupplier) {
    try (SnapshotStage snapshotStage = metainfoRepository.startSnapshotStage()) {

      MutableMetaSnapshot snapshot = snapshotStage.createMutableSnapshot();

      return internalTransactionSupplier.apply(snapshot);
    }
  }

}
