/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.stockmanagement.events;

import org.openlmis.stockmanagement.dto.StockEventDto;
import org.openlmis.stockmanagement.extension.point.StockEventPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Component(value = "StockEventEvent")
public class StockEventEvent implements StockEventPostProcessor {
  private StockEventDto stockEventDto;
  private PropertyChangeSupport support;
  private final Logger logger = LoggerFactory.getLogger(getClass());

  public StockEventEvent() {
    support = new PropertyChangeSupport(this);
  }

  @Override
  public void process(StockEventDto stockEventDto) {
    logger.info("StockEventEvent - processing");
    support.firePropertyChange("stockEvent", this.stockEventDto, stockEventDto);
    this.stockEventDto = stockEventDto;
  }

  public void addPropertyChangeListener(PropertyChangeListener pcl) {
    logger.info("StockEventEvent - adding listener");
    support.addPropertyChangeListener(pcl);
  }
}
