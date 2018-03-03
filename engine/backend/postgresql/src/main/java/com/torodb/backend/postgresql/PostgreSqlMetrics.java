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

package com.torodb.backend.postgresql;

import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import com.torodb.core.metrics.MetricNameFactory;
import com.torodb.core.metrics.ToroMetricRegistry;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PostgreSqlMetrics {

  private static final MetricNameFactory factory = new MetricNameFactory("PostgreSQLWrite");
  public final Timer insertDocPartDataTimer;
  public final Meter insertRows;
  public final Meter insertFields;
  public final Meter insertDefault;
  public final Meter insertCopy;

  @Inject
  public PostgreSqlMetrics(ToroMetricRegistry registry) {
    insertDocPartDataTimer = registry.timer(factory.createMetricName("insertDocPartDataTimer"));
    insertRows = registry.meter(factory.createMetricName("insertRows"));
    insertFields = registry.meter(factory.createMetricName("insertFields"));
    insertDefault = registry.meter(factory.createMetricName("insertDefault"));
    insertCopy = registry.meter(factory.createMetricName("insertCopy"));
  }

}
