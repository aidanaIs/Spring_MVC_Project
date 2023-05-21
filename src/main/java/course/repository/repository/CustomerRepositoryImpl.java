package course.repository.repository;

import course.entity.Customer;
import course.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import course.Exceptions.MyException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    //put assign method in

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCustomer(Customer customer) {
        LocalDate currentDate = LocalDate.now();
        long age = ChronoUnit.YEARS.between(customer.getDateOfBirth(), currentDate);
        try {
            if (age < 18) {
                throw new MyException("This customer under the of 18!");
            }
            else {
                entityManager.persist(customer);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customers = entityManager.createQuery("select u from Customer u", Customer.class).getResultList();
            if (customers.isEmpty()) {
                throw new MyException("While there is no agent");
            } else return customers;
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    //check whether you'r gonna use this method
    @Override
    public Customer getCustomerById(Long id) {
        try {
            Customer customer = entityManager.find(Customer.class, id);
            if (customer.getId().equals(id)) {
                return customer;
            } else {
                throw new MyException("Booking of this" + id + "was not found");
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateCustomerById(Long id, Customer customer) {
        try {
            Customer asCustomer = entityManager.find(Customer.class, id);
            if (asCustomer.getId().equals(id)) {
                asCustomer.setName(customer.getName());
                asCustomer.setSurName(customer.getSurName());
                asCustomer.setEmail(customer.getEmail());
                asCustomer.setGender(customer.getGender());
//                customer.setAge(customer.getAge());
                asCustomer.setPhoneNumber(customer.getPhoneNumber());
                asCustomer.setDateOfBirth(customer.getDateOfBirth());

            } else {
                throw new MyException("Customer of this" + id + "was not found");

            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void deleteCustomerById(Long id) {
        try {
            Customer customer = entityManager.find(Customer.class, id);
            if (customer.getId().equals(id)) {
                entityManager.remove(customer);
            } else {
                throw new MyException("Customer of this" + id + "was not found");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
