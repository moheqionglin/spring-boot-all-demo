package test;

import com.moheqionglin.SslClientApplication;
import com.moheqionglin.cxfEndpoint.SupplierManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wanli zhou
 * @created 2018-03-01 2:10 PM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration({ SslClientApplication.class})
public class SupplierManagerTest {

    @Autowired
    private SupplierManager supplierManager ;

    @Test
    public void sslTest(){
//        GetSupplierV2 v = new GetSupplierV2();
//        try {
//            System.out.println(supplierManager.getSupplierV2(v));
//        } catch (BusinessServiceException_Exception e) {
//            e.printStackTrace();
//        }
    }
}
