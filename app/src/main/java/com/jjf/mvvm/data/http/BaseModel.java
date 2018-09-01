package com.jjf.mvvm.data.http;

/**
 * @author :jinjiafeng
 * date:  on 18-8-30
 * description:
 */
public class BaseModel<T> {
    public static final int SUCCESS = 200;

    private int code;
    private String message;
    private T results;

    public T getResults() {
        return results;
    }

    public int getCode() {
        return code;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
