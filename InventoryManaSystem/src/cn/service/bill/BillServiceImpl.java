package cn.service.bill;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.bill.BillMapper;
import cn.entity.Bill;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Resource
	private BillMapper billMapper;

	@Override
	public List<Bill> findBill(String productName, Integer providerId,
			Integer isPayment, int currentPage, int pageSize) {
		//偏移量，即从第几行开始读取数据，起始位为0
		int offset=(currentPage-1)*pageSize;
		//限制条数，即每页有几条数据
		int limit=pageSize;
		RowBounds rowBounds  = new RowBounds(offset, limit);
		List<Bill> billList = billMapper.findBill(productName, providerId,
				isPayment,rowBounds);
		
		return billList;
	}

	@Override
	public int addBill(Bill bill) {
		int i = billMapper.addBill(bill);
		return i;
	}

	@Override
	public Bill findById(Integer billId) {
		Bill bill = billMapper.findById(billId);
		return bill;
	}

	@Override
	public int delBill(Integer billId) {
		int i = billMapper.delBill(billId);
		return i;
	}

	@Override
	public int modifyBill(Bill bill) {
		int i = billMapper.modifyBill(bill);
		return i;
	}

	@Override
	public List<Bill> checkIspayment(Integer providerId) {
		List<Bill> list = billMapper.checkIspayment(providerId);
		return list;
	}

	@Override
	public int findTotalCount(String productName, Integer providerId,Integer isPayment) {
		int totalCount = billMapper.findTotalCount(productName, providerId,isPayment);
		return totalCount;
	}
	
	
}
