package br.com.conductor.exception;

import java.util.ArrayList;
import java.util.List;

import br.com.conductor.model.ApiErrorResponse;
import br.com.conductor.model.Error;

public class ApiException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int code;
    private ApiErrorResponse apiErrorResponse;

    public ApiException(int code, String msg, Exception ex) {
        super(msg);
        this.code = code;
        populateErrorReponse(ex);
    }

    public ApiErrorResponse getApiReponseError() {
        return apiErrorResponse;
    }

    private void populateErrorReponse(Exception ex) {
        apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setCode(String.valueOf(this.code));
        apiErrorResponse.setMessage(ex.getMessage());
        apiErrorResponse.setDescription(ex.getLocalizedMessage());
        List<Error> errors = new ArrayList<Error>();
        Error error = new Error();
        error.setCode(String.valueOf(ex.hashCode()));
        error.setMessage(ex.getMessage());
        error.setNativeMessage(ex.getLocalizedMessage());
        error.setTrackid(null);
        errors.add(error);
        apiErrorResponse.setErrors(errors);
    }

    public static ApiException throwError(int code, String message, Exception e) {
        Error error = new Error();
        error.setCode(String.valueOf(code));
        error.setMessage(e.getMessage());
        error.setNativeMessage(e.getLocalizedMessage());
        List<Error> errorsList = new ArrayList<Error>();
        errorsList.add(error);
        return new ApiException(code, message, e);
    }

}