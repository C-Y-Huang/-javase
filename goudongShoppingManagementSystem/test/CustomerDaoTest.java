import edu.uestc.angel.dao.CustomerDao;
import edu.uestc.angel.dao.ipml.CustomerDaoImpl;
import edu.uestc.angel.pojo.Customer;
import org.junit.Test;


public class CustomerDaoTest {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Test public void testFindByVipCard() {
        Customer customer = customerDao.findByVipCard("1900");
        System.out.println(customer);
    }
    @Test public void testFindAll() {
        System.out.println(customerDao.findAll());
    }

    @Test public void testSave() {
        Customer customer = new Customer();
        customer.setVipCard("1989");
        customer.setBirthday("02/18");
        customer.setIntegral(1880f);
        System.out.println(customerDao.save(customer));
    }

    @Test public void testUpdateByVipCard() {
        Customer customer = new Customer();
        customer.setVipId(9);
        customer.setBirthday("11/23");
        customer.setIntegral(2680f);
        customer.setVipCard("1937");
        System.out.println(customerDao.updateByVipCard(customer,"1989"));
    }
    @Test public void testFindHigherIntegral() {
        System.out.println(customerDao.findHigherIntegral());
    }
    @Test public void testCount() {
        System.out.println(customerDao.count());
    }
    @Test public void testFindById() {
        System.out.println(customerDao.findVipcardByVipId(1));
    }
}
