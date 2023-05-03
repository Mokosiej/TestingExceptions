import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Книга", 200);
        Product product3 = new Product(3, "Машина", 2_000_000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(2);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 20_000);
        Product product2 = new Product(2, "Книга", 200);
        Product product3 = new Product(3, "Машина", 2_000_000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(4)
        );
    }


}