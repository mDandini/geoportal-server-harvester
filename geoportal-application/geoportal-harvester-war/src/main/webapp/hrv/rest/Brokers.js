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

define(["dojo/_base/declare",
        "dojo/_base/lang",
        "dojo/request/xhr",
        "dojo/Deferred"
      ],
  function(declare,lang,xhr,Deferred){
    var REST = "rest/harvester/brokers";
  
    return {
      output: function() {
        return xhr(REST+"?category=OUTBOUND",{handleAs: "json"});
      },
      
      input: function() {
        return xhr(REST+"?category=INBOUND",{handleAs: "json"});
      },
      
      get: function(id) {
        return xhr(REST+"/"+id,{handleAs: "json"});
      },
      
      delete: function(id) {
        return xhr.del(REST+"/"+id,{handleAs: "json"});
      },
      
      create: function(brokerDefinition) {
        return xhr.post(REST,{data: brokerDefinition, handleAs: "json", headers: {"Content-Type": "application/json"}});
      },
      
      update: function(id, brokerDefinition) {
        return xhr.put(REST+"/"+id,{data: brokerDefinition, handleAs: "json", headers: {"Content-Type": "application/json"}});
      }
    };
});

