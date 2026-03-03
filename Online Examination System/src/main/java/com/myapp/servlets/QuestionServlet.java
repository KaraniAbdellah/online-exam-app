package com.myapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.myapp.dao.QuestionDao;
import com.myapp.utils.Question;

/**
 * Servlet implementation class QuestionServlet
 */
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static QuestionDao questionDao = new QuestionDao();
	private static int id = 1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionServlet() {
		super();
		QuestionServlet.id++;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int examId = QuestionServlet.id + 1;
		System.out.println("examnIDIDIDIDDID: " + examId);
		String ques = request.getParameter("questionText");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String crctOption = request.getParameter("correctOption");

		Question question = new Question();
		question.setExamId(examId);
		question.setQuestion(ques);
		question.setOptionA(optionA);
		question.setOptionB(optionB);
		question.setOptionC(optionC);
		question.setOptionD(optionD);
		question.setCorrectOpt(crctOption);

		int id = questionDao.addQuestion(question);
		if (id != -1) {
			question.setQuestionId(id);
		}
		response.sendRedirect("LoadQuestionsServlet?examId=" + examId);
	}

}
