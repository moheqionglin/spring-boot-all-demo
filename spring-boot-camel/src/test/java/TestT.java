import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:42 PM.
 */

public class TestT {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void test(){
        String a = "a";
        log.info("{}", a);
    }
}
