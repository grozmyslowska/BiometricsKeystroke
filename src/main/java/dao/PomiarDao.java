package dao;

import model.Pomiar;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface PomiarDao {
    void save(Pomiar t);
    HashSet<String> findNames();
    List<Pomiar> findByName(String name);
    List<Pomiar> findAll();
}
