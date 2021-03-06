package com.mellisuga.db;

import org.apache.ibatis.session.SqlSession;

import com.mellisuga.dao.MessageTextDAO;
import com.mellisuga.dao.PermissionDAO;
import com.mellisuga.dao.ReportTypeDAO;
import com.mellisuga.dao.RoleDAO;
import com.mellisuga.dao.RolePermissionDAO;
import com.mellisuga.model.MessageText;
import com.mellisuga.model.Permission;
import com.mellisuga.model.ReportType;
import com.mellisuga.model.Role;
import com.mellisuga.model.RolePermission;

public class InitDB {

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = DBConnection.openDefaultSession();
			
			System.out.println("正在初始化数据库...");
			
			// 角色
			RoleDAO roleDAO = session.getMapper(RoleDAO.class);
			
			Role role0 = new Role();
			role0.setRolename("NormalUser");
			role0.setPid(0);
			role0.setStatus(1);
			role0.setRemark("普通用户，可以评论、私信、回答");
			
			Role role1 = new Role();
			role1.setRolename("LimitedUser1");
			role1.setPid(0);
			role1.setStatus(1);
			role1.setRemark("一级受限用户，不能评论，可以私信、回答");
			
			Role role2 = new Role();
			role2.setRolename("LimitedUser2");
			role2.setPid(0);
			role2.setStatus(1);
			role2.setRemark("二级受限用户，不能评论、私信，只可回答");
			
			Role role3 = new Role();
			role3.setRolename("LimitedUser3");
			role3.setPid(0);
			role3.setStatus(1);
			role3.setRemark("三级受限用户，不能评论、私信、回答");
			
			Role role4 = new Role();
			role4.setRolename("BlockedUser");
			role4.setPid(0);
			role4.setStatus(0);
			role4.setRemark("封禁用户，帐号停用");

			roleDAO.insertRole(role0);
			roleDAO.insertRole(role1);
			roleDAO.insertRole(role2);
			roleDAO.insertRole(role3);
			roleDAO.insertRole(role4);
			
			// 权限
			PermissionDAO permissionDAO = session.getMapper(PermissionDAO.class);

			Permission permission0 = new Permission();
			permission0.setName("Comment");
			permission0.setTitle("评论");
			permission0.setStatus(1);
			permission0.setRemark("评论权限，包括问题和答案");
			permission0.setSort(50);
			permission0.setPid(0);
			permission0.setLevel(1);
			
			Permission permission1 = new Permission();
			permission1.setName("PrivateMessage");
			permission1.setTitle("私信");
			permission1.setStatus(1);
			permission1.setRemark("发送私信权限");
			permission1.setSort(50);
			permission1.setPid(0);
			permission1.setLevel(1);
			
			Permission permission2 = new Permission();
			permission2.setName("Answer");
			permission2.setTitle("回答");
			permission2.setStatus(1);
			permission2.setRemark("回答问题权限");
			permission2.setSort(50);
			permission2.setPid(0);
			permission2.setLevel(1);
			
			Permission permission3 = new Permission();
			permission3.setName("Reading");
			permission3.setTitle("阅读");
			permission3.setStatus(1);
			permission3.setRemark("阅读问体及评论权限");
			permission3.setSort(50);
			permission3.setPid(0);
			permission3.setLevel(1);

			permissionDAO.insertPermission(permission0);
			permissionDAO.insertPermission(permission1);
			permissionDAO.insertPermission(permission2);
			permissionDAO.insertPermission(permission3);
			
			session.commit();
			
			// 角色权限对应操作
			RolePermissionDAO rolePermissionDAO = session.getMapper(RolePermissionDAO.class);
			
			// 获取权限
			Permission commentPermission = permissionDAO.queryPermissionByName(permission0);
			Permission pmPermission = permissionDAO.queryPermissionByName(permission1);
			Permission answerPermission = permissionDAO.queryPermissionByName(permission2);
			Permission readingPermission = permissionDAO.queryPermissionByName(permission3);

			// 获取角色
			Role normalRole = roleDAO.queryRoleByName(role0);
			Role limitedRole1 = roleDAO.queryRoleByName(role1);
			Role limitedRole2 = roleDAO.queryRoleByName(role2);
			Role limitedRole3 = roleDAO.queryRoleByName(role3);
			//Role blockedRole = roleDAO.queryRoleByName(role4);
			
			// 普通用户评论权限
			RolePermission rolePermissionNU0 = new RolePermission();
			rolePermissionNU0.setRole_id(normalRole.getId());
			rolePermissionNU0.setPermission_id(commentPermission.getId());
			// 普通用户私信权限
			RolePermission rolePermissionNU1 = new RolePermission();
			rolePermissionNU1.setRole_id(normalRole.getId());
			rolePermissionNU1.setPermission_id(pmPermission.getId());
			// 普通用户回答权限
			RolePermission rolePermissionNU2 = new RolePermission();
			rolePermissionNU2.setRole_id(normalRole.getId());
			rolePermissionNU2.setPermission_id(answerPermission.getId());
			//普通用户阅读权限
			RolePermission rolePermissionNU3 = new RolePermission();
			rolePermissionNU3.setRole_id(normalRole.getId());
			rolePermissionNU3.setPermission_id(readingPermission.getId());
			// 插入
			rolePermissionDAO.insertRolePermission(rolePermissionNU0);
			rolePermissionDAO.insertRolePermission(rolePermissionNU1);
			rolePermissionDAO.insertRolePermission(rolePermissionNU2);
			rolePermissionDAO.insertRolePermission(rolePermissionNU3);

			// 一级受限用户私信权限
			RolePermission rolePermissionLU10 = new RolePermission();
			rolePermissionLU10.setRole_id(limitedRole1.getId());
			rolePermissionLU10.setPermission_id(pmPermission.getId());
			// 一级受限用户回答权限
			RolePermission rolePermissionLU11 = new RolePermission();
			rolePermissionLU11.setRole_id(limitedRole1.getId());
			rolePermissionLU11.setPermission_id(answerPermission.getId());
			// 一级受限用户阅读权限
			RolePermission rolePermissionLU12 = new RolePermission();
			rolePermissionLU12.setRole_id(limitedRole1.getId());
			rolePermissionLU12.setPermission_id(readingPermission.getId());
			// 插入
			rolePermissionDAO.insertRolePermission(rolePermissionLU10);
			rolePermissionDAO.insertRolePermission(rolePermissionLU11);
			rolePermissionDAO.insertRolePermission(rolePermissionLU12);

			// 二级受限用户回答权限
			RolePermission rolePermissionLU20 = new RolePermission();
			rolePermissionLU20.setRole_id(limitedRole2.getId());
			rolePermissionLU20.setPermission_id(answerPermission.getId());
			// 二级受限用户阅读权限
			RolePermission rolePermissionLU21 = new RolePermission();
			rolePermissionLU21.setRole_id(limitedRole2.getId());
			rolePermissionLU21.setPermission_id(readingPermission.getId());
			// 插入
			rolePermissionDAO.insertRolePermission(rolePermissionLU20);
			rolePermissionDAO.insertRolePermission(rolePermissionLU21);

			// 三级受限用户阅读权限
			RolePermission rolePermissionLU30 = new RolePermission();
			rolePermissionLU30.setRole_id(limitedRole3.getId());
			rolePermissionLU30.setPermission_id(readingPermission.getId());
			// 插入
			rolePermissionDAO.insertRolePermission(rolePermissionLU30);
			
			// 插入举报类型
			ReportTypeDAO reportTypeDAO = session.getMapper(ReportTypeDAO.class);
			/*
			 * 广告等垃圾信息
			 * 不友善内容
			 * 违反法律法规的内容
			 * 不宜公开讨论的政治内容
			 * ×问题已失效或过期×
			 * ×需要进一步修改×
			 * 其他
			 * */
			ReportType reportType0 = new ReportType();
			reportType0.setReport_type_content("广告等垃圾信息");
			reportType0.setIs_common(1);

			ReportType reportType1 = new ReportType();
			reportType1.setReport_type_content("不友善内容");
			reportType1.setIs_common(1);

			ReportType reportType2 = new ReportType();
			reportType2.setReport_type_content("违反法律法规的内容");
			reportType2.setIs_common(1);

			ReportType reportType3 = new ReportType();
			reportType3.setReport_type_content("不宜公开讨论的政治内容");
			reportType3.setIs_common(1);

			ReportType reportType4 = new ReportType();
			reportType4.setReport_type_content("问题已失效或过期");
			reportType4.setIs_common(0);

			ReportType reportType5 = new ReportType();
			reportType5.setReport_type_content("需要进一步修改");
			reportType5.setIs_common(0);

			ReportType reportType6 = new ReportType();
			reportType6.setReport_type_content("其他");
			reportType6.setIs_common(1);
			
			reportTypeDAO.insertReportType(reportType0);
			reportTypeDAO.insertReportType(reportType1);
			reportTypeDAO.insertReportType(reportType2);
			reportTypeDAO.insertReportType(reportType3);
			reportTypeDAO.insertReportType(reportType4);
			reportTypeDAO.insertReportType(reportType5);
			reportTypeDAO.insertReportType(reportType6);
			
			// 初始化默认消息文本
			MessageTextDAO messageTextDAO = session.getMapper(MessageTextDAO.class);

			MessageText mt = new MessageText();
			mt.setContent("你关注的问题有了一个新答案");
			mt.setMessage_name("NewAnswerMsg");
			
			
			MessageText mt1 = new MessageText();
			mt1.setContent("系统公告");
			mt1.setMessage_name("SystemNotice");
			
			MessageText mt2 = new MessageText();
			mt2.setContent("邀请你回答一个问题");
			mt2.setMessage_name("InviteMsg");
			
			MessageText mt3 = new MessageText();
			mt3.setContent("评论了你的回答");
			mt3.setMessage_name("CommentAnswerMsg");
			
			MessageText mt4 = new MessageText();
			mt4.setContent("评论了你的问题");
			mt4.setMessage_name("CommentQuestionMsg");
			
			MessageText mt5 = new MessageText();
			mt5.setContent("回答了你的问题");
			mt5.setMessage_name("AnswerQuestionMsg");
			
			MessageText mt6 = new MessageText();
			mt6.setContent("提到了你");
			mt6.setMessage_name("AtYouMsg");
			
			MessageText mt7 = new MessageText();
			mt7.setContent("回复了你的评论");
			mt7.setMessage_name("ReplyCommentMsg");
			
			MessageText mt8 = new MessageText();
			mt8.setContent("关注了你");
			mt8.setMessage_name("FollowingYouMsg");
			
			MessageText mt9 = new MessageText();
			mt9.setContent("赞同了你的回答");
			mt9.setMessage_name("AgreeAnswerMsg");
			
			MessageText mt10 = new MessageText();
			mt10.setContent("感谢了你的回答");
			mt10.setMessage_name("ThankYouAnswerMsg");
			
			messageTextDAO.insertMessageText(mt);
			messageTextDAO.insertMessageText(mt1);
			messageTextDAO.insertMessageText(mt2);
			messageTextDAO.insertMessageText(mt3);
			messageTextDAO.insertMessageText(mt4);
			messageTextDAO.insertMessageText(mt5);
			messageTextDAO.insertMessageText(mt6);
			messageTextDAO.insertMessageText(mt7);
			messageTextDAO.insertMessageText(mt8);
			messageTextDAO.insertMessageText(mt9);
			messageTextDAO.insertMessageText(mt10);
			
			session.commit();
			
			System.out.println("数据库初始化完成.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeSession(session);
		}
		
	}
}
