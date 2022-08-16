package com.ouke.cloud.result;

/**
 * @author edison
 */

public enum ResultCode {
    SUCCESS(200, "Operation is successful."),
    FAILED(500, "System internal failure."),
    BAD_REQUEST(400, "Invalid parameter."),
    UNAUTHORIZED(401, "Unauthenticated."),
    FORBIDDEN(403, "Resource not authorized."),
    NOT_FOUND(404, "Resource not found.");

    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
