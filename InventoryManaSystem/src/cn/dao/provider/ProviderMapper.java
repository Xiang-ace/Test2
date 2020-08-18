package cn.dao.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.entity.Provider;


public interface ProviderMapper {
	List<Provider> findProvider();
	
	List<Provider> findProviderBy(@Param("providerCode")String proCode,@Param("providerName")String proName, RowBounds rowBounds);

	int addProvider(Provider provider);
	
	//通过id查找显示provider详情
	Provider findById(Integer providerId);
	
	//通过providerId修改provider
	int modifyProvider(Provider provider);
	
	//检测该供应商下订单是否已付款
	/*List<Provider> checkIspayment(Integer providerId);*/
	
	int delProvider(Integer providerId);

	int findTotalCount(@Param("providerCode")String proCode,@Param("providerName") String proName);
}
