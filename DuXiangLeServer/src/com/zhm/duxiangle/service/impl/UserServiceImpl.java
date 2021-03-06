package com.zhm.duxiangle.service.impl;

import java.util.List;

import com.zhm.duxiangle.bean.Page;
import com.zhm.duxiangle.bean.UserInfo;
import com.zhm.duxiangle.dao.UserDao;
import com.zhm.duxiangle.dao.impl.UserDaoImpl;
import com.zhm.duxiangle.service.UserService;
import com.zhm.duxiangle.utils.TextUtils;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();

	@Override
	public UserInfo getUserInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		if (TextUtils.isEmpty(userId)) {
			return null;
		}
		return dao.getUserInfoByUserid(Integer.valueOf(userId));
	}

	@Override
	public Page getUserInfoListByPage(int thispage, int rowperpage) {
		Page page = new Page();
		// 1、当前页面页码
		page.setThispage(thispage);
		// 2、每页记录数
		page.setRowperpage(rowperpage);
		// 3、总记录数
		int countrow = dao.getUserCount();
		page.setCountrow(countrow);
		// 4、总页数
		int countpage = countrow / (rowperpage == 0 ? 1 : rowperpage) + ((countrow % rowperpage) == 0 ? 0 : 1);
		page.setCountpage(countpage);
		// 5、首页
		page.setFirstpage(1);
		// 6、尾页
		page.setLastpage(countpage);
		// 7、上一页
		page.setPrepage(thispage == 0 ? 0 : thispage - 1);
		// 8、下一页
		page.setNextpage(thispage == countpage ? countpage : thispage + 1);
		// 9、每页内容--客户
		List<UserInfo> infoList = dao.getUserInfoList(thispage, rowperpage);
		page.setList(infoList);
		return page;
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		UserInfo info = dao.getUserInfoByUserid(Integer.valueOf(userInfo.getUserId()));
		if (info == null) {
			return dao.insertUserInfo(userInfo);
		} else {
			return dao.updateUserInfo(userInfo);
		}
	}

	@Override
	public int updateUserInfoWithoutAvatar(UserInfo userInfo) {
		UserInfo info = dao.getUserInfoByUserid(Integer.valueOf(userInfo.getUserId()));
		if (info == null) {
			return dao.insertUserInfo(userInfo);
		} else {
			return dao.updateUserInfoWithoutAvatar(userInfo);
		}
	}

	@Override
	public int updatePicWall(UserInfo userInfo) {
		// TODO Auto-generated method stub
		UserInfo info = dao.getUserInfoByUserid(Integer.valueOf(userInfo.getUserId()));
		if (info == null) {
			return dao.insertUserInfoWithPicWall(userInfo);
		} else {
			return dao.updatePicWall(userInfo);
		}
	}

	@Override
	public List<UserInfo> findUserInfoByKeyWords(String keywords) {
		// TODO Auto-generated method stub
		
		return dao.findUserInfoByKeyWords(keywords);
	}

	@Override
	public Page pageUserInfoByIsbn(String isbn,int thispage,int rowperpage) {
		Page page = new Page();
		// 1、当前页面页码
		page.setThispage(thispage);
		// 2、每页记录数
		page.setRowperpage(rowperpage);
		// 3、总记录数
		int countrow = dao.getUserInfoCountByIsbn(isbn);
		page.setCountrow(countrow);
		// 4、总页数
		int countpage = countrow / (rowperpage == 0 ? 1 : rowperpage) + ((countrow % rowperpage) == 0 ? 0 : 1);
		page.setCountpage(countpage);
		// 5、首页
		page.setFirstpage(1);
		// 6、尾页
		page.setLastpage(countpage);
		// 7、上一页
		page.setPrepage(thispage == 0 ? 0 : thispage - 1);
		// 8、下一页
		page.setNextpage(thispage == countpage ? countpage : thispage + 1);
		// 9、每页内容--客户
		List<UserInfo> infoList = dao.getUserInfoByIsbn(isbn,thispage, rowperpage);
		page.setList(infoList);
		return page;
	}

}
