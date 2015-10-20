import com.exchangeService.Account;
import com.exchangeService.dao.AccountDao;
import com.exchangeService.dao.DaoFactory;
import com.exchangeService.dao.PostrgesDaoFactory;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostgresAccountDaoTest {
    @Test
    public void getAllAccountTests(){
        DaoFactory daoFactory = new PostrgesDaoFactory();
        List<Account> accounts;
        try(Connection connection = daoFactory.getConnection()){
            AccountDao accountDao = daoFactory.getAccountDao(connection);
            accounts = accountDao.getAllAccounts();
            Assert.assertNotNull(accounts);
            Assert.assertTrue(accounts.size() > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
