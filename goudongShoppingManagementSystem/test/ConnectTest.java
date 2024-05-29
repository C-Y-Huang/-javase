import edu.uestc.angel.commons.JdbcHelper;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertFalse;



public class ConnectTest {
    @Test
    public void testGetConnection() {
        // 获取JdbcHelper实例
        JdbcHelper jdbcHelper = JdbcHelper.getInstance();

        // 尝试获取数据库连接
        Connection connection = jdbcHelper.getConnection();

        // 验证连接是否成功获取（非null）
        assertFalse("Failed to obtain a database connection.",connection == null);


        // 关闭连接
        jdbcHelper.free(connection);
    }
}
