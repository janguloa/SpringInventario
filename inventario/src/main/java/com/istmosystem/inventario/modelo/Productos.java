package com.istmosystem.inventario.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Productos {
	
	@Id
	private String codproducto;
	private String descripcion;
	private String estado;
	private Date fecha_modificacion;
	private Date fecha_registro;
	private String usuario_registro;
	private String usuario_modifico;
	
	public Productos() {
		
	}
	
	public Productos(String codproducto, String descripcion, String estado, Date fecha_modificacion,
			Date fecha_registro, String usuario_registro, String usuario_modifico) {
		this.codproducto = codproducto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fecha_modificacion = fecha_modificacion;
		this.fecha_registro = fecha_registro;
		this.usuario_registro = usuario_registro;
		this.usuario_modifico = usuario_modifico;
	}
	
	public String getCodproducto() {
		return codproducto;
	}
	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getUsuario_registro() {
		return usuario_registro;
	}
	public void setUsuario_registro(String usuario_registro) {
		this.usuario_registro = usuario_registro;
	}
	public String getUsuario_modifico() {
		return usuario_modifico;
	}
	public void setUsuario_modifico(String usuario_modifico) {
		this.usuario_modifico = usuario_modifico;
	}
}