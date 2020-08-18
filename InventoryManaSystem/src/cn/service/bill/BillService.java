package cn.service.bill;


import java.util.List;

import cn.entity.Bill;

public interface BillService {
	List<Bill> findBill(String productName, Integer providerId,
			Integer isPayment, int currentPage, int pageSize);

	int addBill(Bill bill);
	
	Bill findById(Integer billId);
	
	int modifyBill(Bill bill);
	
	int delBill(Integer billId);
	
	int findTotalCount(String productName,Integer providerId, Integer isPayment);
	
	List<Bill> checkIspayment(Integer providerId);
}
