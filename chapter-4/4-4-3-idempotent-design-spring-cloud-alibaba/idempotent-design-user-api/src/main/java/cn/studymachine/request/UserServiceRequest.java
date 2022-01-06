package cn.studymachine.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserServiceRequest<T> implements Serializable {
    static final long serialVersionUID = -34934934939442L;

    private T requestData;

    private String productId;

    private String tenantId;

    private String uuid;

    private String userName;

}
