/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.persistence.api.entity;

import java.util.Date;
import org.apache.syncope.common.lib.patch.AnyPatch;
import org.apache.syncope.common.lib.to.AnyTO;
import org.apache.syncope.common.lib.types.ResourceOperation;
import org.apache.syncope.core.persistence.api.entity.task.PullTask;

public interface Remediation extends Entity {

    AnyType getAnyType();

    void setAnyType(AnyType anyType);

    ResourceOperation getOperation();

    void setOperation(ResourceOperation operation);

    void setPayload(AnyTO anyTO);

    void setPayload(AnyPatch anyPatch);

    void setPayload(String key);

    <T extends AnyTO> T getPayloadAsTO(Class<T> reference);

    <P extends AnyPatch> P getPayloadAsPatch(Class<P> reference);

    String getPayloadAsKey();

    String getError();

    void setError(String error);

    Date getInstant();

    void setInstant(Date instant);

    PullTask getPullTask();

    void setPullTask(PullTask pullTask);

    String getRemoteName();

    void setRemoteName(String remoteName);
}
