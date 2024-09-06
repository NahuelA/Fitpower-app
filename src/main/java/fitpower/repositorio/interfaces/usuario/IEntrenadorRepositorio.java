package fitpower.repositorio.interfaces.usuario;

import fitpower.model.usuario.Entrenador;

import java.util.List;

public interface IEntrenadorRepositorio {
     void guardar(Entrenador entrenador);
     Entrenador buscarPorIdHistorial(String idHistorial);
     List<Entrenador> obtenerTodos();
     void actualizar(Entrenador entrenador);
     void eliminar(String idHistorial);
}

