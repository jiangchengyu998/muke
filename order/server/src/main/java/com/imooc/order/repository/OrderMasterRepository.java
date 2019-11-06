package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description:  订单
 * @Author jiangchengyu
 * @Date 2019/11/4
 * @Version V1.0
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
