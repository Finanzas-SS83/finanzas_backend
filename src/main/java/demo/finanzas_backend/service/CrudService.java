package demo.finanzas_backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudService<T> {
    T save (T t) throws Exception;
    void delete (Long id) throws Exception;
    List<T> getAll() throws Exception;
    T getById(Long id) throws Exception;
}
