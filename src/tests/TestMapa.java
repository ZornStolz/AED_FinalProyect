package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import ferrocarrilSubterraneo_Logica.Mapa;
import ferrocarrilSubterraneo_Logica.ZonaSegura;
import grafos.AlgoritmosGrafos;

class TestMapa {
	
	private Mapa mapa;
	
	void setUp1(){		
		mapa = new Mapa(1,true);		
		mapa.calcularDificultad(0);
	}

	@Test
	void test() {
		
		setUp1();
		
		System.out.println("\n Matriz \n");
		
		int[][] level = mapa.getMatrizPesos();
		
		for(int i = 0; i < level.length; i++) {
			for(int j = 0; j < level.length; j++) {
				if(level[i][j] > 0 && level[i][j] < 100 )
					System.out.println(" " + i + " " + j + " " + level[i][j]);
			}
		}		
		
		ZonaSegura[] lista = mapa.getListaPesos();
		
		System.out.println("\n lista \n");
		
		for(int i = 0; i < lista.length; i++) {
			
			ZonaSegura zona = lista[i];
			
			while(zona.getSiguiente() != null) {
				System.out.println(" " + i + " " + zona.getVertice() + " " + zona.getNivelDePeligro());
				zona = zona.getSiguiente();
			}
		}
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
	
	@Test
	void testCambiarModelo() {		
		setUp1();		
		
		assertTrue(mapa.getModelo());
		mapa.cambiarModelo();
		assertFalse(mapa.getModelo());
	}
}
