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

package com.torodb.mongodb.repl.commands.impl;

import com.eightkdata.mongowp.Status;
import com.eightkdata.mongowp.server.api.Command;
import com.eightkdata.mongowp.server.api.Request;
import com.eightkdata.mongowp.server.api.tools.Empty;
import com.torodb.core.supervision.Supervisor;
import com.torodb.mongodb.repl.commands.LogAndStopCommand;
import com.torodb.mongodb.repl.guice.MongoDbRepl;
import com.torodb.torod.SharedWriteTorodTransaction;

import javax.inject.Inject;

/**
 * The implementation of {@link LogAndStopCommand}.
 */
public class LogAndStopReplImpl extends ReplCommandImpl<String, Empty> {

  private final Supervisor supervisor;

  @Inject
  public LogAndStopReplImpl(@MongoDbRepl Supervisor supervisor) {
    this.supervisor = supervisor;
  }

  @Override
  public Status<Empty> apply(Request req, Command<? super String, ? super Empty> command, 
      String arg, SharedWriteTorodTransaction trans) {
    UnsupportedOperationException ex = new UnsupportedOperationException(
        "Command " + arg + " is not supported yet");
    supervisor.onError(this, ex);
    throw ex;
  }

}
