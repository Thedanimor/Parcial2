package com.example.Parcial.Service;

import com.example.Parcial.Model.Prestamo;
import com.example.Parcial.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    // Guardar un nuevo Préstamo
    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    // Listar todos los Préstamos
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    // Buscar un Préstamo por su ID
    public Prestamo buscarPorId(Integer id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    // Actualizar un Préstamo existente
    public Prestamo actualizar(Prestamo prestamo) {
        if (prestamo.getId() != null && prestamoRepository.existsById(prestamo.getId())) {
            return prestamoRepository.save(prestamo);
        } else {
            throw new RuntimeException("Préstamo no encontrado con ID: " + prestamo.getId());
        }
    }

    // Eliminar un Préstamo por su ID
    public void eliminar(Integer id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Préstamo no encontrado con ID: " + id);
        }
    }
}
