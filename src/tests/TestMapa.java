package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import ferrocarrilSubterraneo_Logica.Mapa;
import grafos.AlgoritmosGrafos;

class TestMapa {
	
	private Mapa mapa;
	
	void setUp1(){		
		mapa = new Mapa(1,true);		
		mapa.calcularDificultad(0);
	}

	@Test
	void testPuntajeMinimo() {		
		setUp1();		
		assertTrue(mapa.puntajeMinimo(0, 100) != 0);		
	}
	@Test
	void testEstaConectado() {		
		setUp1();		
		assertTrue(mapa.estaConectado(0, 1) == -1);
		assertTrue(mapa.estaConectado(0, 3) != -1);
	}
}
