package cn.studymachine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wukun
 * @since 2021/12/26
 */
@SpringBootApplication
@MapperScan("cn.studymachine")
public class ReplaceTableNameApplication {

    /*---------------------------------------------- Fields ~ ----------------------------------------------*/



    /*---------------------------------------------- Methods ~ ----------------------------------------------*/

    public static void main(String[] args) {
        SpringApplication.run(ReplaceTableNameApplication.class, args);
    }
}
