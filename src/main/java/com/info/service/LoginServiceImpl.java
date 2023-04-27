package com.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.binding.LoginRequest;
import com.info.constants.AppConstants;
import com.info.entity.UserEntity;
import com.info.props.AppProperties;
import com.info.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private AppProperties appProps;

	@Override
	public String login(LoginRequest request) {
		UserEntity user = repo.findByUserEmailAndUserPwd(request.getEmail(), request.getPwd());
		if(null==user) {
			return appProps.getMessages().get(AppConstants.INVALID_CREDENTIALS);
		}
		if(user.getUserAccountStatus().equals(AppConstants.LOCKED)) {
			return appProps.getMessages().get(AppConstants.ACC_LOCKED);
		}
	
		return AppConstants.SUCCESS;
	}

}
