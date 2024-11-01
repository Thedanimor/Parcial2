package com.example.Parcial.Service;

import com.example.Parcial.Model.Genero;
import com.example.Parcial.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    // Guardar un nuevo Género
    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }

    // Listar todos los Géneros
    public List<Genero> listar() {
        return generoRepository.findAll();
    }

    // Buscar un Género por su ID
    public Genero buscarPorId(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    // Actualizar un Género existente
    public Genero actualizar(Genero genero) {
        if (genero.getId() != null && generoRepository.existsById(genero.getId())) {
            return generoRepository.save(genero);
        } else {
            throw new RuntimeException("Género no encontrado con ID: " + genero.getId());
        }
    }

    // Eliminar un Género por su ID
    public void eliminar(Integer id) {
        if (generoRepository.existsById(id)) {
            generoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Género no encontrado con ID: " + id);
        }
    }
}
