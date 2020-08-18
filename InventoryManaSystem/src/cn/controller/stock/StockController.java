package cn.controller.stock;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.entity.Bill;
import cn.entity.Provider;
import cn.service.bill.BillService;
import cn.service.provider.ProviderService;
import cn.util.Page;

import com.alibaba.fastjson.JSONArray;
@Controller
public class StockController {

	@Resource
	private BillService billService;
	@Resource
	private ProviderService providerService;
	
	// 显示订单
		int currentPage = 1;
		int totalPage = 0;
		int pageSize = 8;
		
	@RequestMapping("/sys/stock")
	public String billList(
			HttpSession session,
			Model model,
			
			@RequestParam(value = "currentPage", required = false) Integer currentPage1,
			
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "providerId", required = false) Integer providerId,
			@RequestParam(value = "isPayment", required = false) Integer isPayment) {
		/* 查询并保存供应商的信息 */
		List<Provider> providerList = providerService.findProvider();
		// model.addAttribute("providerList", providerList);
		session.setAttribute("providerList", providerList);
		int totalCount = billService.findTotalCount(productName, providerId,isPayment);
		if (currentPage1 != null) {
			currentPage = currentPage1;
		} else {
			currentPage = 1;
		}
		Page page = new Page();
		page.setTotalCount(totalCount);
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		// Page page = new Page(pageSize, currentPage, totalPage, totalCount);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("totalPage", totalPage);
		
		List<Bill> billList = billService.findBill(productName, providerId, isPayment,currentPage, pageSize);
		session.setAttribute("billList", billList);
		return "stock/stocklist";
	}

/*	@RequestMapping("/sys/billselect")
	@ResponseBody
	public String billselect(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Provider> list = (List<Provider>) session.getAttribute("providerList");
		for (Provider provider : list) {
			System.out.println(provider.getProviderName());
		}
		String json = JSONArray.toJSONString(list);
		return json;
	}*/
	//查看单个订单详情
	@RequestMapping("/sys/stockview")
	public String billView(HttpSession session,HttpServletRequest request){
	//	@RequestParam(value="billid") //这种方式获取不到
		String billidStr = request.getParameter("billid");
		//System.out.println(billidStr);
		Integer billid=Integer.parseInt(billidStr);
		Bill bill = billService.findById(billid);
		session.setAttribute("bill", bill);
		//System.out.println(bill);
		return "stock/stockview";
	}
	//修改订单
	private Integer billid = null;
	@RequestMapping("/sys/stockmodify")
	public String billModify(HttpSession session,HttpServletRequest request){
		String billidStr = request.getParameter("billid");
		billid = Integer.parseInt(billidStr);
		//System.out.println(billid);
		Bill bill = billService.findById(billid);
		session.setAttribute("bill", bill);
		//System.out.println(bill.getProvider().getProviderName());
		return "stock/stockmodify";
	}
	@RequestMapping("/sys/dostockmodify")
	public String dobillmodify(String billCode,String productName,String productUnit,Double productCount,
			Double totalPrice,Integer isPayment,Integer providerId){
		//获取当前bill的id
		Integer id = billid;
		Bill bill = new Bill(id, billCode, productName, productUnit, productCount, totalPrice, isPayment, providerId);
		int i = billService.modifyBill(bill);
		//System.out.println("修改"+i+"条订单");
		if(i>0){
			return "redirect:/sys/stock";
		}else{
			return "redirect:/sys/stockmodify";
		}
	}
	
	//删除订单
	@RequestMapping("/sys/stockdel")
	@ResponseBody
	public Object stockDelete(@RequestParam Integer billid,@RequestParam Double productCount){
		HashMap<String, String> map = new HashMap<>();
		
		int i=0;
		int productCount1=productCount.intValue();
		
		if(productCount1==0){
			i = billService.delBill(billid);
			System.out.println(i);
		}
		
		if(i==1 && productCount1==0){
			//删除成功后，保存true到map中
			map.put("delResult", "true");
		}else if(i==0 && productCount!=0){
			map.put("delResult", "cannot");
		}else{
			map.put("delResult", "false");
		}
		return map;
	//	return "redirect:/sys/stock";
	}
	

}
