package cn.studymachine.bo;

import java.io.Serializable;

public class NewProductDetailBo implements Serializable {
    private Long productId;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
