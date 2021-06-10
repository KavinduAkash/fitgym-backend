package com.ijse.fitgym.dto.json.response;

public class ResponseDTO {
    private int code;
    private boolean success;
    private String message;
    private Object data;

    public ResponseDTO(int code) {
        this.code = code;
    }

    public ResponseDTO(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public ResponseDTO(int code, boolean success, String message, Object data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
