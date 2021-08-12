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

package org.openlmis.stockmanagement.service;

import org.openlmis.stockmanagement.dto.StockEventDto;
import org.openlmis.stockmanagement.util.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class StockEventIntegrationDataService {

  @Value("${service.url}")
  private String stockmanagementUrl;

  private static final String SERVICE_URL = "/api/integration/stockEvent";

  private final AuthService authService;

  @Autowired
  public StockEventIntegrationDataService(AuthService authService) {
    this.authService = authService;
  }

  /**
   * Send an stockEvent to one-network-integration-service.
   *
   * @param stockEventDto object
   */
  public void sendStockEvent(StockEventDto stockEventDto)
      throws StockEventIntegrationDataException {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    String url = stockmanagementUrl + SERVICE_URL;

    try {
      headers.setBearerAuth(authService.obtainAccessToken());
      restTemplate.exchange(
          RequestHelper.createUri(url),
          HttpMethod.POST,
          new HttpEntity<>(stockEventDto, headers),
          Object.class);

    } catch (RestClientException ex) {
      throw new StockEventIntegrationDataException(
          "Unable to send orderable to one-network-integration-service.", ex
      );
    }
  }
}