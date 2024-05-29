import edu.uestc.angel.dao.GoodsDao;
import edu.uestc.angel.dao.ipml.GoodsDaoImpl;
import org.junit.Test;


public class GoodsDaoTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Test public void testSelectById() {
        System.out.println(goodsDao.getPriceById(1));
    }
}
