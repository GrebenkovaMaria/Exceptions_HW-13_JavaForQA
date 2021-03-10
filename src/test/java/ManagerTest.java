import domain.Book;
import domain.Product;
import domain.TShirt;
import exception.NotFoundException;
import manager.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager();
    Book bookFirst = new Book(1, "Онегин", 100, "Пушкин");
    Book bookSecond = new Book(2, "Война и мир", 1000, "Толстой");
    Book bookThird = new Book(3, "Солярис", 350, "Лем");
    TShirt tShirtFirst = new TShirt(4, "addidas forever", 300, "Addidas");
    TShirt tShirtSecond = new TShirt(5, "spring", 300, "Asos");
    TShirt tShirtThird = new TShirt(6, "I'm the best", 300, "H&M");


    @BeforeEach
    public void setUp() {
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(tShirtFirst);
        manager.add(tShirtSecond);
        manager.add(tShirtThird);
    }


    @Test
    public void shouldRemoveIfExists() {
        manager.removeById(1);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{bookSecond, bookThird, tShirtFirst, tShirtSecond, tShirtThird};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMakeExceptionIfNotExists() {
        assertThrows(NotFoundException.class, () -> manager.removeById(8));
    }


}












