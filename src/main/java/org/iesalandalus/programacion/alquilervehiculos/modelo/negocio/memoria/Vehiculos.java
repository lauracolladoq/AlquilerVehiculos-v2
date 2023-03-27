package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos implements IVehiculos {

	private List<Vehiculo> coleccionVehiculos;

	// creará la lista
	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}

	// devolverá una nueva lista con los mismos elementos (no debe crear nuevas
	// instancias).
	@Override
	public List<Vehiculo> get() {
		return new ArrayList<>(coleccionVehiculos);
	}

	// devolverá la cantidad de elementos que contiene la lista
	@Override
	public int getCantidad() {
		return coleccionVehiculos.size();
	}

	// añadirá un turismo a la lista si éste no es nulo y no existe aún en la lista.
	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un vehículo nulo.");
		}
		if (coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un vehículo con esa matrícula.");
		}
		coleccionVehiculos.add(vehiculo);

	}

	// devolverá el turismo si éste se encuentra en la lista y null en caso
	// contrario.
	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
		Vehiculo VehiculoComodin = null;
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un vehículo nulo.");
		}
		int coleccionVehiculosAux = coleccionVehiculos.indexOf(vehiculo);
		if (coleccionVehiculosAux != -1) {
			VehiculoComodin = coleccionVehiculos.get(coleccionVehiculosAux);
		}
		return VehiculoComodin;
	}

	// borrará el turismo si éste existe en la lista o lanzará una excepción en caso
	// contrario
	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehículo nulo.");
		}
		if (buscar(vehiculo) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún vehículo con esa matrícula.");
		}
		coleccionVehiculos.remove(vehiculo);

	}

}
