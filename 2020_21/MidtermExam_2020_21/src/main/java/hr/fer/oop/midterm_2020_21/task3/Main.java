package hr.fer.oop.midterm_2020_21.task3;



public class Main {

		public static void main(String[] args) {
			Image i1 = new Image(249, "caption1");
			Image i2 = new Image(150, "caption2");

			Video v1 = new Video(20, 500, 150, "caption");

			Story s1 = new Story(102, 3);

			InstagramPost<Post> igPost = new InstagramPost<>("user","17.4.2021",i1);

			System.out.println(igPost.calculatePostImpact(500));	
		
			InstagramStory igStory= new InstagramStory("user2", "18.4.2021", s1);
			
			System.out.println(igStory.calculateStoryImpact(430));
			
			v1.printPostData();
		}

}
