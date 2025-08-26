package platzi.market.persistence;

import org.springframework.stereotype.Repository;
import platzi.market.domain.mapper.Product;
import platzi.market.domain.repository.ProductRepository;
import platzi.market.persistence.crud.ProductoCrudRepository;
import platzi.market.persistence.entity.Producto;
import platzi.market.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRepository crud;
    private final ProductMapper mapper;

    public ProductoRepository(ProductoCrudRepository crud, ProductMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) crud.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = crud.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = crud.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(mapper::toProducts);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return crud.findById(productId).map(mapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(crud.save(producto));
    }

    @Override
    public void delete(int productId) {
        crud.deleteById(productId);
    }

}
