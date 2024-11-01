package com.example.Parcial.Service;

import com.example.Parcial.Model.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    private List<Autor> autores = new ArrayList<>();


    public Autor guardar(Autor autor) {
        autores.add(autor);
        return autor;
    }


    public List<Autor> listar() {
        return autores;
    }


    public Autor buscarPorId(Integer id) {
        return autores.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }


    public Autor actualizar(Autor autor) {
        // Buscar el autor existente por ID
        for (int i = 0; i < autores.size(); i++) {
            Autor autorExistente = autores.get(i);
            if (autorExistente.getId().equals(autor.getId())) {
                // Actualizar los campos del autor existente
                autores.set(i, autor);
                return autor; // Retornar el autor actualizado
            }
        }
        return null; // Retornar null si no se encontró el autor
    }

    // Método para eliminar un autor por su ID
    public boolean eliminar(Integer id) {
        return autores.removeIf(a -> a.getId().equals(id));
    }
}