package rfid;

public class Questions {

	private int number;
	private String answer = "";

	public Questions(int number) {
		this.number = number;
	}

	public void getQuestion() {
		switch (number) {
		case 1:
			System.out.println("Was ist die Hauptstadt Deutschlands?");
			setAnswer("Berlin");
			break;
		case 2:
			System.out.println("Was ergibt 8/2(2+2)?");
			setAnswer("16");
			break;
		case 3:
			System.out.println("Blaze it?");
			setAnswer("420");
			break;
		case 4:
			System.out
					.println("Was ist das meist verkaufte Comic-book der Welt?");
			setAnswer("Superman");
			break;
		case 5:
			System.out.println("Wer ist der/die aktuelle Bundeskanzler*in?");
			setAnswer("Olaf Scholz");
			break;
		case 6:
			System.out.println("Wer hat den 'Home Computer' erfunden?");
			setAnswer("John Blankenbaker");
			break;
		case 7:
			System.out.println("Wo sind Eisbären beheimatet?");
			setAnswer("Arktis");
			break;
		case 8:
			System.out.println("Wer hat die Glühbirne erfunden?");
			setAnswer("Thomas Edison");
			break;
		case 9:
			System.out
					.println("Wieviele Knochen besitzt ein erwachsenes Menschliches Skelett?");
			setAnswer("206");
			break;
		case 10:
			System.out.println("Was ist der beste Anime aller Zeiten?");
			setAnswer("One Piece");
			break;
		default:
			System.out.println("Fehler");
			System.exit(2);
		}
	}

	private void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

}
