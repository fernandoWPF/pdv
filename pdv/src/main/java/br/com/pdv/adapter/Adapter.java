package br.com.pdv.adapter;

import java.util.List;

public interface Adapter<T, E, S> {

    List<S> entityToResponse(List<T> entities);
    
    S entityToResponse(T entity);

    T requestToEntity(E request);

}
