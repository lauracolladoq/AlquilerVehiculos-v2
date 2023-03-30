package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos implements IVehiculos {
	private static final File FICHERO_VEHICULOS = new File("datos/vehiculos.xml");
	private static final String RAIZ = "vehiculos";
	private static final String VEHICULO = "vehiculo";
	private static final String MARCA = "marca";
	private static final String MODELO = "modelo";
	private static final String MATRICULA = "matricula";
	private static final String CILINDRADA = "cilindrada";
	private static final String PLAZAS = "plazas";
	private static final String PMA = "pma";
	private static final String TIPO = "tipo";
	private static final String TURISMO = "turismo";
	private static final String AUTOBUS = "autobus";
	private static final String FURGONETA = "furgoneta";

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
