package platzi.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import platzi.market.domain.mapper.Product;
import platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {
        CategoryMapper.class
})
public interface ProductMapper {

    @Mappings({
        @Mapping(source = "idProducto", target = "productId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "precioVenta", target = "price"),
        @Mapping(source = "cantidadStock", target = "stock"),
        @Mapping(source = "estado", target = "active"),
        @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

    List<Product> toProducts(List<Producto> productos);

}
