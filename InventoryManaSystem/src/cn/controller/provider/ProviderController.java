package cn.controller.provider;

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

@Controller
public class ProviderController {

	@Resource
	private ProviderService providerService;
	@Resource
	private BillService billService;
	
	// 查询供应商
	
			int currentPage = 1;
			int totalPage = 0;
			int pageSize = 8;
			
	@RequestMapping("/sys/provider")
	public String findProviderBy(
			HttpSession session,
			Model model,
			@RequestParam(value = "currentPage", required = false) Integer currentPage1,
			@RequestParam(value = "queryProCode", required = false) String proCode,
			@RequestParam(value = "queryProName", required = false) String proName) {
		// System.out.println(proCode+" "+proName);
		
		
		int totalCount = providerService.findTotalCount(proCode, proName);
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
		System.out.println(totalCount);
		// Page page = new Page(pageSize, currentPage, totalPage, totalCount);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("totalPage", totalPage);
		
		List<Provider> proList = providerService.findProviderBy(proCode,
				proName,currentPage, pageSize);
		model.addAttribute("proList", proList);
		return "pro/providerlist";
	}

	// 添加供应商
	@RequestMapping("/sys/provideradd")
	public String addProvider() {
		return "pro/provideradd";
	}

	@RequestMapping("/sys/provideraddsave")
	public String doAddProvider(
			@RequestParam(value = "proCode") String providerCode,
			@RequestParam(value = "proName") String providerName,
			@RequestParam(value = "proContact") String providerContact,
			@RequestParam(value = "proPhone") String providerPhone,
			@RequestParam(value = "proAddress") String providerAddress,
			@RequestParam(value = "proFax") String providerFax,
			@RequestParam(value = "proDesc") String providerDesc) {
		Date date = new Date();
		Provider provider = new Provider(null, providerCode, providerName,
				providerDesc, providerContact, providerPhone, providerAddress,
				providerFax, 1, date, null, null);
		int i = providerService.addProvider(provider);
		if(i>0){
			//添加成功
			return "redirect:/sys/provider";
		}else{
			return "redirect:/sys/provideradd";
		}
	}

	// 显示供应商详情
	@RequestMapping("/sys/proview")
	public String providerView(Model model, @RequestParam Integer proid) {
		Provider provider = providerService.findById(proid);
		model.addAttribute("provider", provider);
		return "pro/providerview";
	}

	// 修改供应商信息
	@RequestMapping("/sys/providermodify")
	public String modifyProvider(Model model, @RequestParam Integer proid) {
		Provider provider = providerService.findById(proid);
		model.addAttribute("provider", provider);
		return "pro/providermodify";
	}
	@RequestMapping("/sys/providermodifysave")
	public String providermodifysave(@RequestParam(value = "proid") Integer id,
			@RequestParam(value = "proCode") String providerCode,
			@RequestParam(value = "proName") String providerName,
			@RequestParam(value = "proContact") String providerContact,
			@RequestParam(value = "proPhone") String providerPhone,
			@RequestParam(value = "proAddress") String providerAddress,
			@RequestParam(value = "proFax") String providerFax,
			@RequestParam(value = "proDesc") String providerDesc) {
		Provider provider = new Provider(id, providerCode, providerName,
				providerDesc, providerContact, providerPhone, providerAddress,
				providerFax);
		// System.out.println(provider);
		int i = providerService.modifyProvider(provider);
		if (i > 0) {
			// 修改成功
			return "redirect:/sys/provider";
		} else {
			return "redirect:/sys/providermodify";
		}
	}

	// 删除供应商
	@RequestMapping("/sys/delprovider")
	@ResponseBody
	// proid该值是从ajxa中传递过来的
	public Object delProvider(HttpServletRequest request,
			@RequestParam Integer proid) {
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Integer> map1 = new HashMap<>();
		/**
		 * 删除供应商之前检测供应商下是否有未付款订单
		 * 通过供应商的id在bill表中查询isPayment
		 */
		//List<Provider> list = providerService.checkIspayment(proid);
		List<Bill> list = billService.checkIspayment(proid);
		int n = 0;
		for (Bill bill : list) {
			if(bill.getIsPayment()==1){
				n++;
			}
		}
		if(n==0){
			int i = providerService.delProvider(proid);
			if (i == 1) {
				map.put("delResult", "true");
			} else if (i == 0) {
				map.put("delResult", "false");
			}
			return map;
		}else{
			//记录该供应商下有多少条未付款订单
			map1.put("delResult", n);
			return map1;
		}
	}
}
