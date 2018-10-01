package br.edu.ifpr.treinamento.modelo.service.command;

import java.util.Collection;

public interface JpaPersistenceDAO<K,T>
{
    int insert(T t);

    int update(T t);

    int delete(K key);

    int delete();

    T select(K key);

    Collection<T> select();

}
