package com.kputimcevs.insurance.premium.entities.policy;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class PolicyObject {
    @NotBlank
    public String objectName;
    @Valid
    public List<SubObject> subObjects = new ArrayList<>();

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<SubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<SubObject> subObjects) {
        this.subObjects = subObjects;
    }
}
