package fapi.service;

import java.util.Optional;

public interface DefaultService<T>  {
    Iterable<T> findALL();

    Optional<T> findById(Long id);

    T save(T dto);

    void deleteById(Long id);
}
