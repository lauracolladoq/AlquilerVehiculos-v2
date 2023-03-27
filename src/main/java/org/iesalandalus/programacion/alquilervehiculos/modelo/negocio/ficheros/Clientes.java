package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes {
	Cliente cliente;

	private List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}

	// devolverá una nueva lista con los mismos elementos (no debe crear nuevas
	// instancias)
	@Override
	public List<Cliente> get() {
		return new ArrayList<>(coleccionClientes);
		// Devuelve un list pero en verdad de vuelve un ArrayList
	}

	// añadirá un cliente a la lista si éste no es nulo y no existe aún en la lista.
	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
		coleccionClientes.add(cliente);

	}

	// devolverá el cliente si éste se encuentra en la lista y null en caso
	// contrario.
	@Override
	public Cliente buscar(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		Cliente clienteComodin = null;
		int coleccionAux = coleccionClientes.indexOf(cliente);
		if (coleccionAux != -1) {
			clienteComodin = coleccionClientes.get(coleccionAux);
		}
		return clienteComodin;

	}

	// borrará el cliente si éste existe en la lista o lanzará una excepción en caso
	// contrario.
	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (buscar(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccionClientes.remove(cliente);

	}

	// permitirá cambiar el nombre o el teléfono (si estos parámetros no son
	// nulos ni blancos) de un cliente existente y si no lanzará la correspondiente
	// excepción.
	@Override

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (coleccionClientes.indexOf(cliente) == -1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			Cliente clienteBuscado = buscar(cliente);
			// Si el nombre no es nulo ni blanco, me deja cambiar el nombre
			if (nombre != null && !nombre.isBlank()) {
				clienteBuscado.setNombre(nombre);
			}
			if (telefono != null && !telefono.isBlank()) {
				clienteBuscado.setTelefono(telefono);

			}
		}

	}
}
