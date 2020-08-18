package cn.service.provider;

import java.util.List;

import cn.entity.Provider;


public interface ProviderService {
	List<Provider> findProvider();
	
	List<Provider> findProviderBy(String proCode,String proName, int currentPage, int pageSize );
	
	int addProvider(Provider provider);
	
	Provider findById(Integer providerId);
	
	int modifyProvider(Provider provider);
	
	/*List<Provider> checkIspayment(Integer id);*/
	
	int delProvider(Integer providerId);

	int findTotalCount(String proCode, String proName);
}
