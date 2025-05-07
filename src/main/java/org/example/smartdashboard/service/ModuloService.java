package org.example.smartdashboard.service;

import org.example.smartdashboard.model.Modulo;
import org.example.smartdashboard.repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    private final ModuloRepository repository;

    public ModuloService(ModuloRepository repository) {
        this.repository = repository;
    }

    public List<Modulo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Modulo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Modulo salvar(Modulo modulo) {
        return repository.save(modulo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
