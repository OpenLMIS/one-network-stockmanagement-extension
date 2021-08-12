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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.openlmis.stockmanagement.dto.StockEventDto;
import org.openlmis.stockmanagement.service.StockEventIntegrationDataException;
import org.openlmis.stockmanagement.service.StockEventIntegrationDataService;

@RunWith(MockitoJUnitRunner.class)
public class StockEventEventTest {

  @Mock
  private StockEventDto stockEventDto;

  @Mock
  private StockEventIntegrationDataService stockEventIntegrationDataService;

  @InjectMocks
  private StockEventEvent stockEventEvent;

  @Test
  public void shouldCallSendStockEventMethod() throws StockEventIntegrationDataException {
    stockEventEvent.process(stockEventDto);
    Mockito.verify(stockEventIntegrationDataService, Mockito.atLeastOnce())
        .sendStockEvent(stockEventDto);
  }
}
