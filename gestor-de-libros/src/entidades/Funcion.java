package entidades;

public interface Funcion<T extends Comparable<T>> {
	void funcion(T dato, Object parametros);
}
