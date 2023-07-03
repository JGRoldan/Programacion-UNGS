package tano_construcciones;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaDeServiciosTest {
	static final String SERVICIO_PINTURA = "Pintura";
	static final String SERVICIO_PINTURA_EN_ALTURA = "PinturaEnAltura";
	static final String SERVICIO_ELECTRICIDAD = "Electricidad";
	static final String SERVICIO_GASISTA_INSTALACION = "GasistaInstalacion";
	static final String SERVICIO_GASISTA_REVISION = "GasistaRevision";
	EmpresaDeServicios empresa;
	int dniClienteRegistrado, dniClienteNuevo;
	int nroEspecialistaElectrisista, nroEspecialistaPintorAltura1, nroEspecialistaPintorAltura2,
			nroEspecialistaGasistaRevision, nroEspecialistaGasistaInstalacion, nroEspecialistaPintor;

	int nroEspecialistaNuevo1, nroEspecialistaNuevo2, nroEspecialistaNuevo3, nroEspecialistaNuevo4,
			nroEspecialistaNuevo5;
	int codServicio_cli1_pintor1,codServicio_cli2_gasista;

	@Before
	public void setUp() throws Exception {

		empresa = new EmpresaDeServicios();
		empresa.registrarEspecialista(1001, "Electricista1", "1144556677", SERVICIO_ELECTRICIDAD);
		empresa.registrarEspecialista(20, "GasistaInstalacion", "1144556688", SERVICIO_GASISTA_INSTALACION);
		empresa.registrarEspecialista(33, "PintorAltura1", "1144556699", SERVICIO_PINTURA_EN_ALTURA);
		empresa.registrarEspecialista(452, "Electricista2", "1144557700", SERVICIO_ELECTRICIDAD);
		empresa.registrarEspecialista(34, "PintorAltura2", "1144557733", SERVICIO_PINTURA_EN_ALTURA);
		empresa.registrarEspecialista(300, "Pintor", "1144557744", SERVICIO_PINTURA);
		empresa.registrarEspecialista(500, "GasistaRevision", "1144557834", SERVICIO_GASISTA_REVISION);
		nroEspecialistaElectrisista = 452;
		nroEspecialistaPintorAltura1 = 33;
		nroEspecialistaPintorAltura2 = 34;
		nroEspecialistaGasistaInstalacion = 20;
		nroEspecialistaGasistaRevision = 500;
		nroEspecialistaPintor = 300;
		nroEspecialistaNuevo1 = 200;
		nroEspecialistaNuevo2 = 201;
		nroEspecialistaNuevo3 = 202;
		nroEspecialistaNuevo4 = 203;
		nroEspecialistaNuevo5 = 204;

		empresa.registrarCliente(30449448, "Cliente1", "1146651100");
		empresa.registrarCliente(37223451, "Cliente2", "1146651111");
		dniClienteRegistrado = 37223451;
		dniClienteNuevo = 42469448;

		int cli1_elec1 = empresa.solicitarServicioElectricidad(30449448, 1001, "calle falsa 123", 700, 20);
		codServicio_cli1_pintor1 = empresa.solicitarServicioPintura(30449448, nroEspecialistaPintorAltura1, "calle falsa 123", 24, 4500, 2, 18000,
				5000);
		int cli2_elec2 = empresa.solicitarServicioElectricidad(37223451, nroEspecialistaElectrisista, "otra Calle 321", 650, 2);
		codServicio_cli2_gasista = empresa.solicitarServicioGasistaInstalacion(37223451, nroEspecialistaGasistaInstalacion,
				"bulevar 333", 3, 3200);
		int cli1_elec2 = empresa.solicitarServicioElectricidad(30449448, nroEspecialistaElectrisista, "calle falsa 139", 650, 10);

		empresa.finalizarServicio(cli1_elec1, 30000); // facturacion = 30000 + 700*20
		empresa.finalizarServicio(cli2_elec2, 10000); // facturacion = 10000 + 650*2
		empresa.finalizarServicio(cli1_elec2, 5000); // facturacion = 5000 + 650*10
		empresa.finalizarServicio(codServicio_cli2_gasista, 1000);// facturacion = 1000 + 3*3200

	}

	@Test
	public void registrarClienteNuevo_finalizaOK() {
		empresa.registrarCliente(dniClienteNuevo, "clienteX", "1146453465");
	}

	@Test(expected = RuntimeException.class)
	public void registrarClienteRepetido_generaError() {
		empresa.registrarCliente(dniClienteRegistrado, "clienteX", "1146453465");
	}

	@Test
	public void registrarEspecialistaNuevo_finalizaOK() {
		empresa.registrarEspecialista(nroEspecialistaNuevo1, "EspecialistaEnTodo", "1146453465", SERVICIO_ELECTRICIDAD);
		empresa.registrarEspecialista(nroEspecialistaNuevo2, "EspecialistaEnTodo", "1146453465", SERVICIO_PINTURA);
		empresa.registrarEspecialista(nroEspecialistaNuevo3, "EspecialistaEnTodo", "1146453465",
				SERVICIO_PINTURA_EN_ALTURA);
		empresa.registrarEspecialista(nroEspecialistaNuevo4, "EspecialistaEnTodo", "1146453465",
				SERVICIO_GASISTA_INSTALACION);
		empresa.registrarEspecialista(nroEspecialistaNuevo5, "EspecialistaEnTodo", "1146453465",
				SERVICIO_GASISTA_REVISION);
	}

	@Test(expected = RuntimeException.class)
	public void registrarEspecialistaRepetido_generaError() {
		empresa.registrarEspecialista(nroEspecialistaElectrisista, "clienteX", "1146453465", SERVICIO_GASISTA_REVISION);
	}

	@Test(expected = RuntimeException.class)
	public void registrarEspecialistaDeTipoDesconocido_generaError() {
		empresa.registrarEspecialista(nroEspecialistaNuevo1, "EspecialistaServicioDesconocido", "1146453465",
				"Carpintero");
	}

	@Test
	public void solicitarServicios_finalizaOK() {
		empresa.solicitarServicioPintura(dniClienteRegistrado, nroEspecialistaPintor, "otra Calle 871", 9, 2000);
		empresa.solicitarServicioGasistaRevision(dniClienteRegistrado, nroEspecialistaGasistaRevision, "bulevar 777", 1,
				3200);
	}

	@Test(expected = RuntimeException.class)
	public void solicitarServicioConNroEspecialidadInvalido_generaError() {
		empresa.solicitarServicioPintura(dniClienteRegistrado, nroEspecialistaNuevo1, "otra Calle 871", 9, 2000);
	}

	@Test(expected = RuntimeException.class)
	public void solicitarServicioConDniClienteInvalido_generaError() {
		empresa.solicitarServicioPintura(dniClienteNuevo, nroEspecialistaPintor, "otra Calle 871", 9, 2000);
	}

	@Test(expected = RuntimeException.class)
	public void solicitarServicioConTipoEspecialidadInvalido_generaError() {
		empresa.solicitarServicioPintura(dniClienteRegistrado, nroEspecialistaElectrisista, "otra Calle 871", 9, 2000);
	}

	@Test
	public void cambiarResponsableConEspecialistaMismoTipo_finalizaOK() {
		empresa.cambiarResponsable(codServicio_cli1_pintor1, nroEspecialistaPintorAltura2);
	}

	@Test(expected = RuntimeException.class)
	public void cambiarResponsableConEspecialistaOtroTipo_generaError() {
		empresa.cambiarResponsable(codServicio_cli1_pintor1, nroEspecialistaElectrisista);
	}

	@Test
	public void testCantidadServiciosRealizadosPorTipo() {
		Map<String, Integer> cantidadPorTipo = empresa.cantidadDeServiciosRealizadosPorTipo();
		// Verifica la cantidad de servicios finalizados de cada tipo.
		assertEquals(3, cantidadPorTipo.get(SERVICIO_ELECTRICIDAD).intValue());
		assertEquals(0, cantidadPorTipo.get(SERVICIO_PINTURA).intValue());
		assertEquals(0, cantidadPorTipo.get(SERVICIO_PINTURA_EN_ALTURA).intValue());
		assertEquals(1, cantidadPorTipo.get(SERVICIO_GASISTA_INSTALACION).intValue());
		assertEquals(0, cantidadPorTipo.get(SERVICIO_GASISTA_REVISION).intValue());
	}

	@Test
	public void finalizarServicio_devuelveMontoAFacturar() {
		// Monto esperado es costoMateriales + costoDelServicio
		// 1000 + ( 24*4500 + 18000 + 5000 )
		assertEquals(132000, empresa.finalizarServicio(codServicio_cli1_pintor1, 1000), 0.01);
	}

	@Test
	public void verificarFacturacionTotalPorTipoElectricista() {
		// Es la suma del monto facturado por todos los servicios de electricidad
		// finalizados
		assertEquals(66800, empresa.facturacionTotalPorTipo(SERVICIO_ELECTRICIDAD), 0.01);
	}

	@Test
	public void verificarFacturacionTotalEsperada() {
		assertEquals(77400, empresa.facturacionTotal(), 0.01);
	}

	@Test
	public void serviciosAtendidosPorEspecialista() {
		String esperado = " + [ " + codServicio_cli2_gasista + " - " + SERVICIO_GASISTA_INSTALACION + " ] "
				+ "bulevar 333\n";
		assertEquals(esperado, empresa.listadoServiciosAtendidosPorEspecialista(nroEspecialistaGasistaInstalacion));
	}

}