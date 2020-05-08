package nk.trainings.backend.service;

import java.util.Optional;

public interface DefaultService<T>  {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T entity);

    void deleteById(Long id);
}
