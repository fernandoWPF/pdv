package br.com.pdv.service.validator;

import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {

    void validate(T obj);

}
