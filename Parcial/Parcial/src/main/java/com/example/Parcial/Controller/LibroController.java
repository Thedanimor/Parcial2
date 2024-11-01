package com.example.Parcial.Controller;

import com.example.Parcial.Model.Libro;
import com.example.Parcial.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/guardar")
    public Libro guardar(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @GetMapping("/listar")
    public List<Libro> listar() {
        return libroService.listar();
    }

    @GetMapping("/{id}")
    public Libro buscarPorId(@PathVariable Integer id) {
        return libroService.buscarPorId(id);
    }

    @PutMapping("/actualizar")
    public Libro actualizar(@RequestBody Libro libro) {
        return libroService.actualizar(libro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        libroService.eliminar(id);
    }
}
