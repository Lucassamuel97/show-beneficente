package br.edu.utfpr.alunos.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;

public class Response<T> {

    private T data;
    private List<String> errors;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public Response(List<String> errors) {
        this.errors = errors;
    }

    public Response(T data, List<String> errors) {
        this.data = data;
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setErrors(BindingResult result) {
        result.getAllErrors().forEach(error -> this.addError(error.getDefaultMessage()));
    }

    public void addError(String error) {
        if (errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }

}
