package hr.fer.oop.midterm_2018_19.task3;

public class HumanPlayer extends Person implements Player {

	private String nickname;

	public HumanPlayer(String nickname,  String id, String name) {
		super(id, name);
		this.nickname = nickname;

	}

	@Override
	public String getNickname() {
		return nickname;
	}

}
