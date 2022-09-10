package com.repository.lector;

import com.model.Lector;

import java.util.List;

public interface ILectorRepository {

    List<Lector> findLectorByName(String name);

}
