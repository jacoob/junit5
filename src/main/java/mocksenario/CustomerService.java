package mocksenario;

import common.Customer;

/**
 * Author : mahdi ,  Date : 9/5/2021
 */
public class CustomerService {
    CustomerDao dao;

    public CustomerService(CustomerDao dao) {
        this.dao = dao;
    }

    public Customer saveCustomer(Customer customer){
        return dao.get(customer);
    }
}
