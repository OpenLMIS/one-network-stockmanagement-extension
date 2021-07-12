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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openlmis.stockmanagement.dto.StockEventDto;
import org.openlmis.stockmanagement.events.StockEventEvent;
import org.openlmis.stockmanagement.events.StockEventObserver;
import org.openlmis.stockmanagement.testbuilder.StockEventDtoDataBuilder;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StockEventEventTest {

  private StockEventDto generateInstance() {
    return new StockEventDtoDataBuilder().createStockEventDto();
  }

  @Test
  public void shouldCreateNotificationAfterNewStockEvent() {

    StockEventDto stockEventDto = generateInstance();

    StockEventEvent observable = new StockEventEvent();
    StockEventObserver observer = new StockEventObserver();

    observable.addPropertyChangeListener(observer);

    observable.process(stockEventDto);
    assertEquals(observer.getStockEvent(), stockEventDto);
  }
}
