package cn.service.provider;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.provider.ProviderMapper;
import cn.entity.Provider;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService{

	@Resource
	private ProviderMapper providerMapper;

	@Override
	public List<Provider> findProvider() {
		
		return providerMapper.findProvider();
	}

	@Override
	public List<Provider> findProviderBy(String proCode, String proName, int currentPage, int pageSize) {
		//偏移量，即从第几行开始读取数据，起始位为0
				int offset=(currentPage-1)*pageSize;
				//限制条数，即每页有几条数据
				int limit=pageSize;
				RowBounds rowBounds  = new RowBounds(offset, limit);
		return providerMapper.findProviderBy(proCode, proName,rowBounds);
	}

	@Override
	public int addProvider(Provider provider) {
		int i = providerMapper.addProvider(provider);
		return i;
	}

	@Override
	public int delProvider(Integer providerId) {
		int i = providerMapper.delProvider(providerId);
		return i;
	}

	@Override
	public Provider findById(Integer providerId) {
		Provider provider = providerMapper.findById(providerId);
		return provider;
	}

	@Override
	public int modifyProvider(Provider provider) {
		int i = providerMapper.modifyProvider(provider);
		return i;
	}

	@Override
	public int findTotalCount(String proCode, String proName) {
		int totalCount = providerMapper.findTotalCount(proCode, proName);
		return totalCount;
	}

}
