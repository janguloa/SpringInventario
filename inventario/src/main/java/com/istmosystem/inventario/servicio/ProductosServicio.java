package com.istmosystem.inventario.servicio;

import java.util.List;
import com.istmosystem.inventario.modelo.Productos;

public interface ProductosServicio {
	
	List<Productos> findAllActives();
	
	List<Productos> findCodigo();
	
	Productos CreateUser (Productos productos);
	
	Productos UpdateUser (Productos productos);
	
	void DeleteUser (String codigo);

}
