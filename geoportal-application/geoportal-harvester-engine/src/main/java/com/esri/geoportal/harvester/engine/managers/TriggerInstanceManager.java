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
package com.esri.geoportal.harvester.engine.managers;

import com.esri.geoportal.harvester.api.TriggerInstance;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Trigger instance manager.
 */
public interface TriggerInstanceManager {
  
  static class TaskUuidTriggerInstancePair {
    private UUID taskId;
    private TriggerInstance triggerInstance;

    /**
     * Gets task id.
     * @return the taskId
     */
    public UUID getTaskId() {
      return taskId;
    }

    /**
     * Sets task id.
     * @param taskId the taskId to set
     */
    public void setTaskId(UUID taskId) {
      this.taskId = taskId;
    }

    /**
     * Gets trigger instance.
     * @return the triggerInstance
     */
    public TriggerInstance getTriggerInstance() {
      return triggerInstance;
    }

    /**
     * Sets trigger instance.
     * @param triggerInstance the triggerInstance to set
     */
    public void setTriggerInstance(TriggerInstance triggerInstance) {
      this.triggerInstance = triggerInstance;
    }
  }
  
  /**
   * Puts trigger instance into the manager.
   * @param uuid uuid of the trigger instance
   * @param instance trigger instance
   */
  void put(UUID uuid, TaskUuidTriggerInstancePair instance);
  
  /**
   * Gets a trigger instance from the manager.
   * @param uuid uuid of the trigger instance
   * @return trigger instance
   */
  TaskUuidTriggerInstancePair get(UUID uuid);
  
  /**
   * Removes trigger instance.
   * @param uuid uuid of the trigger instance
   * @return removed instance
   */
  TaskUuidTriggerInstancePair remove(UUID uuid);
  
  /**
   * Lists all instances.
   * @return list of instance entries.
   */
  List<Map.Entry<UUID, TaskUuidTriggerInstancePair>> listAll();
  
  /**
   * Clears manager.
   */
  void clear();
}
