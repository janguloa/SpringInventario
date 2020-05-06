package com.istmosystem.inventario.servicio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.istmosystem.inventario.modelo.ProductosInventario;
import com.istmosystem.inventario.repositorio.ProductosInventarioRepositorio;

@Service("productoInventario")
@Transactional
public class ProductosInventarioServicioImpl implements ProductosInventarioServicio {
	
	@Autowired
	private ProductosInventarioRepositorio productosInventarioRepositorio;
	
	@Override
	public List<ProductosInventario> findAllActives() {
		
		List <ProductosInventario> lista = productosInventarioRepositorio.findAllByEstado("0");
		
		return lista;
	}

	@Override
	public List<ProductosInventario> findByCodigo() {
		
		List <ProductosInventario> lista = productosInventarioRepositorio.findAllByCodproducto("CONSOL1");
		
		return lista;
	}

	@Override
	public ProductosInventario CreateRegistry(ProductosInventario productoInventario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductosInventario UpdateRegistry(ProductosInventario productoInventario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRegistry(Long codigo) {
		// TODO Auto-generated method stub

	}

}