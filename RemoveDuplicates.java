package week2.day2.assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0;
		String[] split = text.split(" ");
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split.length; j++) {
				if (split[i] == split[j]) {
					count++;
					if (count > 1) {
						text.replaceAll(text, "");
					}
				}

			}
			System.out.println(split[i]);

		}

	}

}
