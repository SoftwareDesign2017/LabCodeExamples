package bookStore.service;

import bookStore.repository.MockAuthorRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorServiceImplTest {
    private static AuthorService target;

    @BeforeClass
    public static void init() {
        target = new AuthorServiceImpl(new MockAuthorRepository());
    }

    @Test
    public void testAll() {
        Assert.assertTrue(target.getAll().size() == 2);
    }
}
