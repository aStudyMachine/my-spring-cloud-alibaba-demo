package cn.studymachine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wukun
 * @since 2021/12/23
 */
@SpringBootApplication
@MapperScan("cn.studymachine")
public class Example4Application {

    /*---------------------------------------------- Fields ~ ----------------------------------------------*/



    /*---------------------------------------------- Methods ~ ----------------------------------------------*/


    public static void main(String[] args) {
        SpringApplication.run(Example4Application.class, args);
    }

}
