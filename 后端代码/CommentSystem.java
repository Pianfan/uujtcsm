package dishEvaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Comment {
	private String commenterName;
	private String commentContent;

	public Comment(String commenterName, String commentContent) {
		this.commenterName = commenterName;
		this.commentContent = commentContent;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public String getCommentContent() {
		return commentContent;
	}
}

class Dish {
	private String dishName;
	private List<Comment> comments;

	public Dish(String dishName) {
		this.dishName = dishName;
		this.comments = new ArrayList<>();
	}

	public String getDishName() {
		return dishName;
	}

	public void addComment(String commenterName, String commentContent) {
		Comment comment = new Comment(commenterName, commentContent);
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}
}

public class CommentSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("菜品名称：");
		String dishName = scanner.nextLine();

		Dish dish = new Dish(dishName);

		while (true) {
			System.out.print("请输入一个用户名(or type 'exit' to finish)：");
			String commenterName = scanner.nextLine();

			if (commenterName.equalsIgnoreCase("exit")) {
				break;
			}

			System.out.print("请输入此用户的评论：");
			String commentContent = scanner.nextLine();

			// 判断评论内容是否为空
			while (commentContent.trim().isEmpty()) {
				System.out.println("评论不能为空，请重新输入：");
				commentContent = scanner.nextLine();
			}

			dish.addComment(commenterName, commentContent);
		}

		// Display comments
		System.out.println("“" + dish.getDishName() + "”" + "评论列表：");
		List<Comment> comments = dish.getComments();

		for (Comment comment : comments) {
			System.out.println(comment.getCommenterName() + "：" + comment.getCommentContent());
		}

		scanner.close();
	}
}
