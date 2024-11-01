package com.example.Parcial.Repository;

import com.example.Parcial.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{

    @Query(value = "SELECT * FROM cliente", nativeQuery = true)
    List<Cliente> findAllClientes();

    @Query(value = "SELECT * FROM cliente WHERE id = ?1", nativeQuery = true)
    Cliente findClienteById(Integer id);

}
