package com.ijse.fitgym.exception;

public class FitGymServiceException extends RuntimeException{
    private int status;
    private String message;

    public FitGymServiceException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FitGymServiceException{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
