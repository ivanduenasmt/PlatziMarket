package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByStockLessThanAndEstado(int stock, boolean estado);
    List<Producto> findByPrecioVentaOrderByNombreAsc(double precioVenta);
}
