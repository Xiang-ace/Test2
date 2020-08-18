package cn.dao.bill;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.entity.Bill;

public interface BillMapper {
	//选择查找订单
	List<Bill> findBill(@Param("productName") String productName,
			@Param("providerId") Integer ProviderId,
			@Param("isPayment") Integer isPayment, RowBounds rowBounds);

	/*int addBill(@Param("billCode") String billCode,
			@Param("productName") String productName,
			@Param("productDesc") String productDesc,
			@Param("productUnit") String productUnit,
			@Param("productCount") Double productCount,
			@Param("totalPrice") Double totalPrice,
			@Param("isPayment") Integer isPayment,
			@Param("providerId") Integer providerId, @Param("date") Date date);*/
	//添加订单
	int addBill(Bill bill);
	//显示订单详情
	Bill findById(Integer billId);
	//修改订单
	int modifyBill(Bill bill);
	//删除订单
	int delBill(Integer billId);
	
	//检测供应商下面订单是否均已付款
	List<Bill> checkIspayment(Integer providerId);

	int findTotalCount(@Param("productName")String productName, @Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment);
}
