package cn.studymachine.thread;

import cn.studymachine.entity.UserEntity;
import cn.studymachine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;

@Component
public class TenantThreadExecutor {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {

        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                List<UserEntity> list = userService.list();
                System.out.println("当前租户所有user 列表 = " + list);

                List<UserEntity> userAndAddr = userService.getUserAndAddr(list.get(0).getName());
                System.out.println("列表第一个用户的地址 = " + userAndAddr);

                try {
                    // 每隔五秒查询
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
