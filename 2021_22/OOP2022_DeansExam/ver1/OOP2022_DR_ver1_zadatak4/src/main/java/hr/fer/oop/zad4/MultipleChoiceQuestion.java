package hr.fer.oop.zad4;

public class MultipleChoiceQuestion {

	private String questionTitle;
	private String questionText;
	private String choice1;
	private String choice2;
	private String choice3;
	private Integer correctChoice;
	private Integer answer;

	public MultipleChoiceQuestion(String questionTitle, String questionText
			                    , String choice1, String choice2
			                    , String choice3, Integer correctChoice) {
		this.questionTitle = questionTitle;
		this.questionText = questionText;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.correctChoice = correctChoice;
	}	
	
	public String getQuestionTitle() {
		return questionTitle;
	}
	public String getQuestionText() {
		return questionText;
	}
	public String getChoice1() {
		return choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public int getCorrectChoice() {
		return correctChoice;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

	
	public boolean hasAnswer()  {
		return answer != null;
	}
	
	public boolean isCorrect() {
		return hasAnswer() && answer == correctChoice;
	}

}
