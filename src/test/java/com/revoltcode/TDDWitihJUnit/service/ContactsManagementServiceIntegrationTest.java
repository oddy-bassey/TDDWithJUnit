package com.revoltcode.TDDWitihJUnit.service;

import com.revoltcode.TDDWitihJUnit.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * SETUP PREVIEW
 * Instruct JUnit to do the following:
 * - Not load @Controllers
 * - Only load @Service and dependencies
 *   Examples: @datarepository and similar
 * - Connect to H2 data source - test-specific or other staging
 */

@ExtendWith(SpringExtension.class) // replaces: @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {

    // Autowire the service
    @Autowired
    private ContactsManagementService contactsManagementService;

    @Test
    public void testAddContactHappyPath () {

        // Create the contact
        CustomerContact customerContact = new CustomerContact();
        customerContact.setFirstName("Steven");
        customerContact.setLastName("Hendry");

        // Test adding the contact
        CustomerContact newContact = contactsManagementService.add(customerContact);

        // Verify the addition
        assertNotNull(newContact);
        assertNotNull(newContact.getId());
        assertEquals("Steven", newContact.getFirstName());
    }
}
