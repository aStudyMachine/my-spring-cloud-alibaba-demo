package cn.studymachine.config;

import cn.studymachine.pojo.UserDTO;
import cn.studymachine.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author wukun
 * @since 2021/12/26
 */
@Configuration
@MapperScan("cn.studymachine.mapper")
public class MybatisPlusConfig {

    @Resource
    private UserService userService;

    /**
     * 动态表名拦截器
     *
     * @return the mybatis plus interceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();

        // 比较奇特的写法  new HashMap {{}}
        HashMap<String, TableNameHandler> map = new HashMap<String, TableNameHandler>(2) {{
            put("example5_order", (sql, tableName) -> {
                // todo 这里可以替换成 认证授权框架的 获取当前登录租户id的方法.
                UserDTO userDTO = userService.getLoginUser();
                return tableName + "_" + userDTO.getTenantId();
            });
        }};

        dynamicTableNameInnerInterceptor.setTableNameHandlerMap(map);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return interceptor;
    }
}
