package platzi.market.persistence;

import org.springframework.stereotype.Repository;
import platzi.market.persistence.crud.ProductoCrudRepository;
import platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private final ProductoCrudRepository crud;

    public ProductoRepository(ProductoCrudRepository crud) {
        this.crud = crud;
    }

    public List<Producto> getAll() {
        return (List<Producto>) crud.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return crud.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return crud.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return crud.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return crud.save(producto);
    }

    public void delete(int idProducto) {
        crud.deleteById(idProducto);
    }

}
