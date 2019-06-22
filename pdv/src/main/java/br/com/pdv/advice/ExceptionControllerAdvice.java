package br.com.pdv.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.pdv.domain.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorDTO trataException(final Exception exception) {
        return new ErrorDTO(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO trataException(final MethodArgumentNotValidException exception) {
        StringBuilder builder = new StringBuilder();
        BindingResult bindingResult = exception.getBindingResult();
        builder.append("[Atributo]: ");
        builder.append(bindingResult.getFieldError().getField());
        builder.append(" [Conteudo]: ");
        builder.append(bindingResult.getFieldValue(bindingResult.getFieldError().getField()));
        builder.append(" [Erro]: ");
        builder.append(bindingResult.getFieldError().getDefaultMessage());
        return new ErrorDTO(String.valueOf(builder));
    }
}
