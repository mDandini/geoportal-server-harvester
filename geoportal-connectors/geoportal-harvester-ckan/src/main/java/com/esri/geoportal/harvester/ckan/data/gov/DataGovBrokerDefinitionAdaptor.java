/*
 * Copyright 2017 Esri, Inc.
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
package com.esri.geoportal.harvester.ckan.data.gov;

import static com.esri.geoportal.harvester.ckan.data.gov.DataGovConstants.*;
import com.esri.geoportal.harvester.api.defs.EntityDefinition;
import com.esri.geoportal.harvester.api.ex.InvalidDefinitionException;
import com.esri.geoportal.harvester.ckan.CkanBrokerDefinitionAdaptor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Data.gov broker definition adaptor.
 */
public class DataGovBrokerDefinitionAdaptor extends CkanBrokerDefinitionAdaptor {
  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DataGovBrokerDefinitionAdaptor.class);
  private static final URL DEFAULT_API_URL = createDefaultUrl("https://catalog.data.gov/", "DEFAULT_API_URL");
  private static final URL DEFAULT_XML_URL = createDefaultUrl("https://data.gov.in/catalog/", "DEFAULT_XML_URL");
  private static final String DEFAULT_OID_KEY = "harvest_object_id";
  
  private static URL createDefaultUrl(String url, String name) {
    try {
      return new URL(url);
    } catch (MalformedURLException ex) {
      LOG.error(String.format("Invalid %s: %s", name, url));
      return null;
    }
  }
  
  private URL xmlUrl;
  private String oidKey;
  
  public DataGovBrokerDefinitionAdaptor(EntityDefinition def) throws InvalidDefinitionException {
    super(def);
  }

  @Override
  protected void initialize(EntityDefinition def) throws InvalidDefinitionException {
    super.initialize(def);
    try {
      xmlUrl = new URL(get(P_XML_URL));
    } catch (MalformedURLException ex) {
      throw new InvalidDefinitionException(String.format("Invalid %s: %s", P_XML_URL, get(P_XML_URL)), ex);
    }
    oidKey = get(P_OID_KEY);
  }

  @Override
  public void override(Map<String, String> params) {
    super.override(params);
    consume(params,P_XML_URL);
  }
  
  public URL getXmlUrl() {
    return xmlUrl;
  }

  public void setXmlUrl(URL hostUrl) {
    this.xmlUrl = hostUrl;
    set(P_XML_URL,hostUrl.toExternalForm());
  }

  public String getOidKey() {
    return oidKey;
  }

  public void setOidKey(String oidKey) {
    this.oidKey = oidKey;
    set(P_OID_KEY, oidKey);
  }
  
}
