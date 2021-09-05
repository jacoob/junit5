package mocksenario;

import common.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Author : mahdi ,  Date : 9/5/2021
 */

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerDao dao;

    @Test
    public void saveTest(){
//        CustomerDao dao = new CustomerDao();
        Customer customer = new Customer("mahdi");
        Mockito.lenient().when(dao.get(customer)).thenReturn(customer);
        assertEquals("mahdi", dao.get(customer).getName());
    }
}
