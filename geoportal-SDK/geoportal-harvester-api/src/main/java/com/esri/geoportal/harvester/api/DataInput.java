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

/**
 * Data input.
 * @param <T> type of data provided
 */
public interface DataInput<T> extends DataBroker, AutoCloseable {
  
  /**
   * Checks if more data available.
   * @return <code>true</code> if more data available
   * @throws DataInputException if checking if more data available fails
   */
  boolean hasNext() throws DataInputException;
  
  /**
   * Gets next available data reference.
   * @return data reference
   * @throws DataInputException if getting next data reference fails
   */
  DataReference<T> next() throws DataInputException;
  
}
