package com.example.Parcial.Service;

import com.example.Parcial.Model.Libro;
import com.example.Parcial.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Guardar un nuevo Libro
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    // Listar todos los Libros
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    // Buscar un Libro por su ID
    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    // Actualizar un Libro existente
    public Libro actualizar(Libro libro) {
        if (libro.getId() != null && libroRepository.existsById(libro.getId())) {
            return libroRepository.save(libro);
        } else {
            throw new RuntimeException("Libro no encontrado con ID: " + libro.getId());
        }
    }

    // Eliminar un Libro por su ID
    public void eliminar(Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Libro no encontrado con ID: " + id);
        }
    }
}
