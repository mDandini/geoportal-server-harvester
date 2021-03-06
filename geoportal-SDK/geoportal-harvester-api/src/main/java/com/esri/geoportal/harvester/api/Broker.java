/*
 * Copyright 2016 Esri, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.geoportal.harvester.api;

import com.esri.geoportal.commons.utils.SimpleCredentials;
import com.esri.geoportal.harvester.api.defs.EntityDefinition;

/**
 * Broker.
 * <p>
 * It represents a mechanism of obtaining or publishing data. There are two sub-types
 * of this interface: {@link com.esri.geoportal.harvester.api.specs.InputBroker} used to get data and {@link com.esri.geoportal.harvester.api.specs.OutputBroker}
 * used to publish data.
 * 
 * @param <C> connector type
 * @see com.esri.geoportal.harvester.api API
 * @see com.esri.geoportal.harvester.api.specs.InputBroker
 * @see com.esri.geoportal.harvester.api.specs.OutputBroker
 * @see com.esri.geoportal.harvester.api.defs.EntityDefinition
 * @see Connector
 */
public interface Broker<C extends Connector> extends Initializable {
  
  /**
   * Gets entity definition.
   * @return entity definition
   */
  EntityDefinition getEntityDefinition();
  /**
   * Gets connector.
   * @return connector
   */
  C getConnector();
  
  /**
   * Checks if user has access to the resources.
   * @param creds user credentials
   * @return <code>true</code> if access is granted
   */
  boolean hasAccess(SimpleCredentials creds);
}
