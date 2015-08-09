package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lfitzger on 8/6/15.
 */
public class CustomerTest {

    @Test
    public void bookGetsCheckedOutWhenCustomerChecksOutBook() {
        Customer customer = new Customer();
        Library library = mock(Library.class);
        Book harryPotter = mock(Book.class);
        customer.checkOutBook(library, harryPotter);
        verify(harryPotter).checkOut();
    }


}