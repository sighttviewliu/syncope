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
package org.apache.syncope.common.lib.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.syncope.common.lib.AbstractBaseBean;
import org.apache.syncope.common.lib.patch.UserPatch;

@XmlRootElement(name = "userRequestForm")
@XmlType
public class UserRequestForm extends AbstractBaseBean {

    private static final long serialVersionUID = -7044543391316529128L;

    private String username;

    private String taskId;

    private String formKey;

    private Date createTime;

    private Date dueDate;

    private String owner;

    private UserTO userTO;

    private UserPatch userPatch;

    private final List<UserRequestFormProperty> properties = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(final String formKey) {
        this.formKey = formKey;
    }

    public Date getCreateTime() {
        if (createTime != null) {
            return new Date(createTime.getTime());
        }
        return null;
    }

    public void setCreateTime(final Date createTime) {
        if (createTime != null) {
            this.createTime = new Date(createTime.getTime());
        } else {
            this.createTime = null;
        }
    }

    public Date getDueDate() {
        if (dueDate != null) {
            return new Date(dueDate.getTime());
        }
        return null;
    }

    public void setDueDate(final Date dueDate) {
        if (dueDate != null) {
            this.dueDate = new Date(dueDate.getTime());
        } else {
            this.dueDate = null;
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public UserTO getUserTO() {
        return userTO;
    }

    public void setUserTO(final UserTO userTO) {
        this.userTO = userTO;
    }

    public UserPatch getUserPatch() {
        return userPatch;
    }

    public void setUserPatch(final UserPatch userPatch) {
        this.userPatch = userPatch;
    }

    @JsonIgnore
    public Optional<UserRequestFormProperty> getProperty(final String id) {
        return properties.stream().filter(property -> id.equals(property.getId())).findFirst();
    }

    @XmlElementWrapper(name = "workflowFormProperties")
    @XmlElement(name = "workflowFormProperty")
    @JsonProperty("workflowFormProperties")
    public List<UserRequestFormProperty> getProperties() {
        return properties;
    }
}
