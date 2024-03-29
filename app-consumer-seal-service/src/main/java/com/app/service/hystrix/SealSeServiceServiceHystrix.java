package com.app.service.hystrix;

import org.springframework.stereotype.Component;

import com.app.entity.SealServiceOrderEntity;
import com.app.service.SealSeServiceService;

@Component
public class SealSeServiceServiceHystrix implements SealSeServiceService{

	@Override
	public String querySealSeServiceList(int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}
	
	@Override
	public String querySealServiceWaitToWorkOrder(int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToReceiveList(String userToken, int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToSignonList(String userToken, int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToFinishList(String userToken, int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToAssessmentList(String userToken, int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String queryAllSealSeServiceWaitToAssessmentList(int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String queryAllSealSeServiceWaitToCheckList(int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String queryAllSealSeServiceFinishedList(int limit, int page) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceDetail(String id) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String insertSealSeServiceMation(String userToken, SealServiceOrderEntity sealServiceOrderEntity) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceMationToEdit(String userToken, String id) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String editSealSeServiceMationById(String userToken, String id, SealServiceOrderEntity sealServiceOrderEntity) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToWorkMation(String userToken, String id) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String editSealSeServiceWaitToWorkMation(String userToken, String id, String serviceUserId, String cooperationUserId) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToReceiveMation(String userToken, String id) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String insertSealSeServiceWaitToReceiveMation(String userToken, String id, String subscribeTime, String remark) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String querySealSeServiceWaitToSignonMation(String userToken, String id) {
		throw new RuntimeException("请求失败，服务无法访问");
	}

	@Override
	public String insertSealSeServiceWaitToSignonMation(String userToken, String id, String longitude, String latitude, String address, String remark) {
		throw new RuntimeException("请求失败，服务无法访问");
	}


}
