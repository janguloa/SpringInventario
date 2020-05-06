package com.istmosystem.inventario.repositorio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.istmosystem.inventario.modelo.ProductosInventario;

@Repository
public interface ProductosInventarioRepositorio extends CrudRepository<ProductosInventario, Long> {

	List <ProductosInventario> findAllByCodproducto(String codigo);
	
	List <ProductosInventario> findAllByEstado(String estado);
	
}