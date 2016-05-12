package com.dani.jpa.domain;

import java.io.Serializable;

public abstract class DomainObject<PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8936290437070708943L;

    public abstract PK getId();

    public abstract void setId(PK id);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getId() == null || obj == null || ! (this.getClass().equals(obj.getClass()))) {
            return false;
        }
        @SuppressWarnings("rawtypes")
        DomainObject that = (DomainObject) obj;
        return this.getId().equals(that.getId());
    }
}
