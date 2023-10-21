package es.upm.grise.profundizacion.control_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LibraryTest {

	// Test para ver si se añade 1 libro a la biblioteca
	@Test
	public void testAddBook() throws NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book book = new Book("Libro1");
		try {
			library.addBook(book);

			assertEquals(book, library.getBook("Libro1"));
		} catch (DuplicatedBookException e) {
			fail("DuplicatedBookException thrown");
		}

	}

	// Test para ver si se añaden 2 libros a la biblioteca
	@Test
	public void testAddTwoBooks() throws NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book book1 = new Book("Libro1");
		Book book2 = new Book("Libro2");
		try {
			library.addBook(book1);
			library.addBook(book2);

			assertEquals(book1, library.getBook("Libro1"));
			assertEquals(book2, library.getBook("Libro2"));
		} catch (DuplicatedBookException e) {
			fail("DuplicatedBookException thrown");
		}

	}

	// Test para ver si se añade un libro duplicado a la biblioteca
	@Test
	public void testAddDuplicatedBook() throws DuplicatedBookException {
		boolean duplicatedBookExceptionThrown = false;
		try{
			Library library = new Library();
			Book book1 = new Book("Libro1");
			Book book2 = new Book("Libro1");
			library.addBook(book1);
			library.addBook(book2);
		} catch (DuplicatedBookException e) {
			duplicatedBookExceptionThrown = true;
		}
		assertEquals(true, duplicatedBookExceptionThrown);
	}

	// Test para ver si se eliminan los libros bien
	@Test
	public void testRemoveBook() throws NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book book1 = new Book("Libro1");
		try {
			library.addBook(book1);
			library.removeBook(book1);

		} catch (DuplicatedBookException e) {
			fail("DuplicatedBookException thrown");
		}
	}

	// Test para coger un libro inexistente
	@Test
	public void testGetNonExistingBook() throws NonExistingBookException, EmptyLibraryException {
		boolean nonExistingBookExceptionThrown = false;
		Library library = new Library();
		try {
			library.getBook("Libro2");

		} catch (NonExistingBookException e) {
			nonExistingBookExceptionThrown = true;
			
		} catch (EmptyLibraryException e) {
			nonExistingBookExceptionThrown = true;
		}
		assertEquals(true, nonExistingBookExceptionThrown);
	}
}
