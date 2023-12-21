package dev.manan.dishdeck.data.entity;

import dev.manan.dishdeck.configuration.RequestContext;
import lombok.Data;

import static java.util.Objects.isNull;

@Data
public class AuditableBean {

    protected Long createdTime;
    protected Long modifiedTime;
    protected String createdBy;
    protected String modifiedBy;
    protected boolean deleted;

    public void audit() {
        if( isNull(createdTime) ) {
            createdTime = System.currentTimeMillis();
        }
        modifiedTime = System.currentTimeMillis();
        if( isNull(createdBy) ) {
            createdBy = RequestContext.getCurrentUserId();
        }
        modifiedBy = RequestContext.getCurrentUserId();;
    }
}
