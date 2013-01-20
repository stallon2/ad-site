package pl.stalkon.ad.core.model.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stalkon.ad.core.model.Ad;
import pl.stalkon.ad.core.model.dao.AdDao;
import pl.stalkon.ad.core.model.service.AdService;
import pl.styall.library.core.model.defaultimpl.User;
import pl.styall.library.core.model.defaultimpl.UserDao;

@Service("adService")
public class AdServiceImpl implements AdService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdDao adDao;
	
	@Transactional
	@Override
	public Ad register(Ad ad, Long id) {
		User poster = userDao.get(id);
		ad.setPoster(poster);
		adDao.add(ad);
		return ad;
	}

	@Transactional
	@Override
	public List<Ad> get(Map<String, Object> queryObject) {
		return adDao.get(queryObject);
	}
	@Transactional
	@Override
	public Ad get(Long id) {
		return adDao.get(id);
	}
	
	

}
