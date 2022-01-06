package cn.studymachine.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodServiceRequest<T> implements Serializable {

    private T requestData;

    private String productId;

    private String tenantId;

    private String uuid;

    private String threadId;

    private String userName;

}
