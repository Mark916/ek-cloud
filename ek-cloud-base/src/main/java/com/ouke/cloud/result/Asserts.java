package com.ouke.cloud.result;

import com.ouke.cloud.exception.ApiException;

/**
 * @ClassName Asserts.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月28日 17:59:00
 */
public class Asserts {
    public static final String EXCEPTION_MESSAGE_NULL_POINTER = "Null point exception.";

    public static final String EXCEPTION_MESSAGE_INVALID_PARAMETER = "Input parameter is invalid.";

    public static final String EXCEPTION_MESSAGE_NO_PRIVILEGE = "No privilege for this operation.";

    public static final String EXCEPTION_MESSAGE_NO_RECORD = "Record does not exist.";

    /**
     * Common fail assertion method.
     *
     * @param message error message
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * Common fail assertion method with error code
     *
     * @param errorCode error code
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    /**
     * Convenient assertion method reporting NPE exception
     *
     */
    public static void failNPE() {
        throw new ApiException(EXCEPTION_MESSAGE_NULL_POINTER);
    }

    /**
     * Convenient assertion method reporting invalid parameter exception
     */
    public static void failInvalidParam() {
        throw new ApiException(EXCEPTION_MESSAGE_INVALID_PARAMETER);
    }

    /**
     * Convenient assertion method reporting invalid parameter exception
     * with extra detailed message
     *
     * @param message
     */
    public static void failInvalidParam(String message) {
        throw new ApiException(EXCEPTION_MESSAGE_INVALID_PARAMETER + message);
    }

    /**
     * Convenient assertion method reporting no privilege exception
     */
    public static void failNoPrivilege() {
        throw new ApiException(EXCEPTION_MESSAGE_NO_PRIVILEGE);
    }

    /**
     * Convenient assertion method reporting exception of record not exist
     */
    public static void failRecordNotExists() {
        throw new ApiException(EXCEPTION_MESSAGE_NO_RECORD);
    }
}
