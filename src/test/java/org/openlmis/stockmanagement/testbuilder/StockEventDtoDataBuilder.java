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

package org.openlmis.stockmanagement.testbuilder;

import org.openlmis.stockmanagement.dto.StockEventDto;
import org.openlmis.stockmanagement.dto.StockEventLineItemDto;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Collections.singletonList;


@SuppressWarnings("PMD.TooManyMethods")
public class StockEventDtoDataBuilder {

  /**
   * Create stock event dto object for testing.
   *createStockEventDto
   * @return created dto object.
   */
  public static StockEventDto createStockEventDto() {
    StockEventDto stockEventDto = new StockEventDto();

    stockEventDto.setDocumentNumber("c");
    stockEventDto.setSignature("e");

    stockEventDto.setProgramId(UUID.randomUUID());
    stockEventDto.setFacilityId(UUID.randomUUID());

    StockEventLineItemDto eventLineItemDto = createStockEventLineItem();

    stockEventDto.setLineItems(singletonList(eventLineItemDto));
    return stockEventDto;
  }

  /**
   * Create stock event line item dto object for testing.
   *
   * @return created dto object.
   */
  public static StockEventLineItemDto createStockEventLineItem() {
    StockEventLineItemDto eventLineItemDto = new StockEventLineItemDto();
    eventLineItemDto.setReasonFreeText("d");
    eventLineItemDto.setReasonId(UUID.fromString("e3fc3cf3-da18-44b0-a220-77c985202e06"));
    eventLineItemDto.setQuantity(1);
    eventLineItemDto.setOrderableId(UUID.randomUUID());
    eventLineItemDto.setOccurredDate(LocalDate.now());
    eventLineItemDto.setSourceId(UUID.fromString("cefcde83-7ee0-4a5a-9580-f32e3eec10ed"));
    eventLineItemDto.setDestinationId(UUID.fromString("0bd28568-43f1-4836-934d-ec5fb11398e8"));
    eventLineItemDto.setSourceFreeText("a");
    eventLineItemDto.setDestinationFreeText("b");
    return eventLineItemDto;
  }
}
