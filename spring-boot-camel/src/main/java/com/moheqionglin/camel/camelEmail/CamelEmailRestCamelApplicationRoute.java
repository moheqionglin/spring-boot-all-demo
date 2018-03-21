package com.moheqionglin.camel.camelEmail;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.component.jms.JmsMessageType.Text;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:12 PM.
 */
@Component
public class CamelEmailRestCamelApplicationRoute extends RouteBuilder{

    private String username = "xxx@163.com";
    private String password = "xxxcode";

    //http://people.apache.org/~dkulp/camel/mail.html
    //https://www.cnblogs.com/shihuc/p/5069783.html
    @Override
    public void configure() throws Exception {

        from("file://.camel-watch/camel-file/camel-email?moveFailed=.camel-error/")
                .log("====INDEX COMPANY FILE READ ${header.CamelFileNameOnly} ======")
                .setHeader("CamelJmsMessageType", constant(Text))
                //com.sun.mail.smtp.SMTPSendFailedException: 553 Mail from must equal authorized user
                //553解决方法： 不设置 from 或者 from 跟 登录username 不一致会报 553
                .setHeader("from", constant(username))
                .setHeader("to", constant("zhou_wanli@wuxiapptec.com"))
                .setHeader("subject", constant("ceshi youjian测试邮件"))
                .setBody(constant("asdfadsfasfdasf 测试邮件"))
                //javax.mail.AuthenticationFailedException: 550 Error: authentication failed
                //550解决方法： 在浏览器登录邮箱--> 设置 --> POP3/SMTP/IMAP --> 客户端授权密码 --> 开启
                //javax.mail.AuthenticationFailedException: 535 Error: authentication failed
                //535 解决方法： 替换 password为 邮箱的授权码
                .to("smtps://smtp.163.com?username=" + username + "&password=" + password);

    }
}
