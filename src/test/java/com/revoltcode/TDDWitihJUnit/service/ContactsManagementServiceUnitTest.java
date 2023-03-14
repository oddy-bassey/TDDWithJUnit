package com.revoltcode.TDDWitihJUnit.service;

import com.revoltcode.TDDWitihJUnit.domain.CustomerContact;
import com.revoltcode.TDDWitihJUnit.repository.CustomerContactRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * SETUP PREVIEW
 * Instruct JUnit to do the following:
 * - Not load @Controllers
 * - load mocks for @Service and dependencies
 *   Examples: @datarepository and similar
 * - Use mockito for our mocking framework
 */

@ExtendWith(MockitoExtension.class) // replaces: @RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

    // Create Mocks
    @Mock
    private CustomerContactRepository customerContactRepository;

    // Autowire the service
    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Test
    public void testAddContactHappyPath () {

        // Create the contact
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Steven");
        mockCustomerContact.setLastName("Hendry");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(mockCustomerContact);

        // Test adding the contact
        CustomerContact newContact = contactsManagementService.add(new CustomerContact());

        // Verify the save
        assertEquals("Steven", newContact.getFirstName());
    }
}
