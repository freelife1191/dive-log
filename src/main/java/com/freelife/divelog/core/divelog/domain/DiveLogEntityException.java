package com.freelife.divelog.core.divelog.domain;

import com.freelife.divelog.common.exception.SystemException;

@SuppressWarnings("serial")
public class DiveLogEntityException extends SystemException {
    public DiveLogEntityException(String foramt, Object... args) {
        super(String.format(foramt, args));
    }
}
