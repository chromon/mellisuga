package com.mellisuga.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.mellisuga.dao.QuestionDAO;
import com.mellisuga.dao.TopicDAO;
import com.mellisuga.db.DBConnection;
import com.mellisuga.model.Member;
import com.mellisuga.model.Question;
import com.mellisuga.model.Topic;

@WebServlet("/AskServlet")
public class AskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AskServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		Member m = (Member) request.getSession().getAttribute("member"); 
		
		String question_title = request.getParameter("question_title");
		String question_content = request.getParameter("question_content");
		String tags = request.getParameter("tags");
		String is_anonymous = request.getParameter("is_anonymous");
		
		// 更新日期
		Date date = new Date();
		String dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date); 
		Timestamp now = Timestamp.valueOf(dateFormate);
		
		SqlSession session = null;
		try {
			session = DBConnection.openDefaultSession();
			
			// 添加问题
			QuestionDAO questionDAO = session.getMapper(QuestionDAO.class);
			
			Question question = new Question();
			question.setQuestion_title(question_title);
			question.setQuestion_content(question_content);
			question.setAnswers_num(0);
			question.setFollowers_num(0);
			question.setLast_updated(now);
			question.setScan_num(0);
			question.setReply_num(0);
			if(is_anonymous != null) {
				question.setIs_anonymous(0);
			}else {
				question.setIs_anonymous(1);
			}
			question.setMember_id(m.getId());
			questionDAO.insertQuestion(question);
			
			session.commit();
			
			// 查询问题
			Question q = questionDAO.queryQuestionByQUid(question);
			
			// 添加话题
			TopicDAO topicDAO = session.getMapper(TopicDAO.class);
			if(tags != null) {
			    String[] tag = tags.split(",");
			    for(int i = 0; i < tag.length; i++) {
			    	System.out.println(tag[i]);
			    	Topic topic = new Topic();
			    	topic.setTagname(tag[i]);
			    	topic.setQuestion_id(q.getId());
			    	topicDAO.insertTopic(topic);
			    }
			}
			session.commit();
			
			
			// 添加日志
			// TODO 数据库表想简单了～
			// TODO 数据库表想简单了～
			// TODO 数据库表想简单了～
			// TODO 数据库表想简单了～
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeSession(session);
		}
		
	}

}