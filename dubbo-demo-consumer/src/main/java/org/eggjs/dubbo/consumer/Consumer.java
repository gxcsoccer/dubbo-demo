package org.eggjs.dubbo.consumer;

import org.eggjs.dubbo.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    /**
     * To get ipv6 address to work, add
     * System.setProperty("java.net.preferIPv6Addresses", "true");
     * before running your application.
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        UserService userService = (UserService) context.getBean("userService"); // get remote service proxy
        while (true) {
            try {
                Thread.sleep(1000);
                String hello = userService.sayHello("world"); // call remote method
                System.out.println(hello); // get result
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
