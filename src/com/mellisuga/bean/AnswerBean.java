package com.mellisuga.bean;

import com.mellisuga.model.Answers;
import com.mellisuga.model.Member;
import com.mellisuga.model.Question;
import com.mellisuga.model.Vote;

public class AnswerBean {

	private Answers answer;
	
	private Question question;
	
	private Member member;

	private Vote vote;
	
	private VoterBean voterBean;
	
	private boolean isThanked;
	
	private boolean isCollected;
	
	private boolean isNoHelp;
	
	private Double answerWeight;
	
	public Answers getAnswer() {
		return answer;
	}

	public void setAnswer(Answers answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

	public VoterBean getVoterBean() {
		return voterBean;
	}

	public void setVoterBean(VoterBean voterBean) {
		this.voterBean = voterBean;
	}

	public boolean isThanked() {
		return isThanked;
	}

	public void setThanked(boolean isThanked) {
		this.isThanked = isThanked;
	}

	public boolean isCollected() {
		return isCollected;
	}

	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}

	public boolean isNoHelp() {
		return isNoHelp;
	}

	public void setNoHelp(boolean isNoHelp) {
		this.isNoHelp = isNoHelp;
	}

	public Double getAnswerWeight() {
		return answerWeight;
	}

	public void setAnswerWeight(Double answerWeight) {
		this.answerWeight = answerWeight;
	}

}
