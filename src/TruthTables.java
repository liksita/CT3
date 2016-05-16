import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TruthTables {

	//Wertetabelle
	public ArrayList<int[]> table = new ArrayList<int[]>();

	//Beißpiel um Eingabe zu vereinfachen
	public ArrayList<int[]> tableExample = new ArrayList<int[]>();

	//Eingabevektore für die Beißpieltabelle 
//	public int[] v1 = { 0, 0, 0, 1 };
//	public int[] v2 = { 1, 0, 0, 0 };
//	public int[] v3 = { 0, 1, 0, 0 };
//	public int[] v4 = { 1, 1, 0, 0 };
//	public int[] v5 = { 0, 0, 1, 1 };
//	public int[] v6 = { 1, 0, 1, 0 };
//	public int[] v7 = { 0, 1, 1, 1 };
//	public int[] v8 = { 1, 1, 1, 0 };
	
	public int[] v1 = { 0, 0, 0, 0 };
	public int[] v2 = { 0, 0, 1, 0 };
	public int[] v3 = { 0, 1, 0, 0 };
	public int[] v4 = { 0, 1, 1, 0 };
	public int[] v5 = { 1, 0, 0, 0 };
	public int[] v6 = { 1, 0, 1, 0 };
	public int[] v7 = { 1, 1, 0, 0 };
	public int[] v8 = { 1, 1, 1, 1 };

	//Konstruktor
	public TruthTables() {
		tableExample.add(v1);
		tableExample.add(v2);
		tableExample.add(v3);
		tableExample.add(v4);
		tableExample.add(v5);
		tableExample.add(v6);
		tableExample.add(v7);
		tableExample.add(v8);
	}

	// #############################################################################
	//Eine Tabelle in Form von ArrayList mit Arrays, die Eingabevektoren sowie Resultatwert enthalten, eingeben

	public void addTable(ArrayList<int[]> tableExample) {
		this.table = tableExample;
		printTable(this.table);
	}

	// #############################################################################
	//Eine Taelle erzeugen durch die Eingaben von der Konsole

	public void createTable() throws IOException {

		boolean finish = false;
		while (!finish) {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(
					"Geben Sie den Eingabevektor ein! Die Integer Zahlen sollen durch einen Leehrzeichen getrennt sein!");
			String eingabe = br.readLine().trim();
			String[] eingabeArray = eingabe.split(" ");
			int length = eingabeArray.length;
			int[] inputVector = new int[length + 1];
			for (int i = 0; i < length; i++) {
				inputVector[i] = Integer.valueOf(eingabeArray[i]);
			}
			System.out.println("Geben Sie den Resultatwert für den letzten Eingabevektor ein");
			String eingabe2 = br.readLine().trim();
			inputVector[length] = Integer.valueOf(eingabe2);

			this.table.add(inputVector);

			System.out.println("Wenn noch ein Vektor folgt, drücken Sie die 1");
			System.out.println("Ist die Wertetabelle fertig, drücken Sie die 2");
			String eingabe3 = br.readLine().trim();
			if (eingabe3.equals("2")) {
				finish = true;
			}
		}
	}

	// #############################################################################
	//Den Resultatwert für einen entsprechenden Eingabevektor finden

	public int getResult(int[] vector) {
		int length = table.get(0).length - 1;
		if (length != vector.length) {
			System.out.println("Eingabevektor hat falsche Groesse");
			return Integer.MIN_VALUE;
		}
		for (int i = 0; i < this.table.size(); i++) {
			boolean notFound = false;
			for (int j = 0; j < length; j++) {
				if (table.get(i)[j] != vector[j]) {
					notFound = true;
				}
			}
			if (notFound == false) {
//				System.out.println("Resultatwert: " + table.get(i)[length]);
				return table.get(i)[length];
			}
		}
		System.out.println("es wurde keinen Resultatwert für den eingegebenen Eingabevektor gefunden");
		return Integer.MIN_VALUE;
	}

	// #############################################################################
	//Zwei Vektoren auf Nachbarschaft prüfen

	public void checkNeighbours(int[] v1, int[] v2) {
		int length = table.get(0).length - 1;
		if ((length != v1.length) || (length != v2.length)) {
			System.out.println("Eingabevektoren haben falsche Groesse");
			return;
		}
		for (int i = 0; i < this.table.size(); i++) {
			boolean notFound = false;
			for (int j = 0; j < length; j++) {
				if (table.get(i)[j] != v1[j]) {
					notFound = true;
				}
			}
			if (notFound == false) {
				boolean notNeighbours = false;
				if (i != 0) {
					for (int k = 0; k < length; k++) {
						if (this.table.get(i - 1)[k] != v2[k]) {
							notNeighbours = true;
						}
					}
					if (notNeighbours == false) {
						System.out.println("Die Vektore sind Nachbare");
						return;
					}
				}
				if (i < (table.size() - 1)) {
					notNeighbours = false;
					for (int l = 0; l < length; l++) {
						if (this.table.get(i + 1)[l] != v2[l]) {
							notNeighbours = true;
						}
					}

					if (notNeighbours == false) {
						System.out.println("Die Vektore sind Nachbare");
						return;
					}
				}
			}
		}
		System.out.println("Die Vektore sind keine Nachbare");
		return;
	}
	
	// #############################################################################
	//Überprüfung auf unterschiedliche Belegungen von Vektoren (für die einfachen Bedingungsüberdeckung)
	public boolean differentValues(int[] v1, int[] v2) {
		int length = v1.length - 1;
		boolean different = true;
		for (int i = 0; i < length; i++) {
			if (v1[i] == v2[i]) {
				different = false;
				return different;
			}
		}
		return different;
	}
	
	// #############################################################################
	//Print Methode für die Tabelle

	public void printTable(ArrayList<int[]> tablePrint) {
		if (tablePrint.isEmpty()) {
			System.out.println("Es liegt noch keine Werteabelle vor");
		} else {
			int length = tablePrint.get(0).length;
			for (int j = 0; j < length; j++) {
				if (j == length - 1) {
					System.out.print("B" + "  ");
				} else {
					System.out.print("A" + j + " ");
				}
				for (int k = 0; k < tablePrint.size(); k++) {
					System.out.print(tablePrint.get(k)[j]);
					System.out.print(" ");
				}
				System.out.println(" ");
			}
		}
	}
	
	// #############################################################################
	//Einfache Bedingungsüberdeckung: Überprüfung, ob jede (atomare) Teilbedingung in jeder
	//Entscheidung mindestens einmal mit den Werten True und False ausgeführt wurde

	
	public void simpleConditionCoverage() {
		for (int i = 0; i < this.table.size(); i++) {
			for (int j = i + 1; j < this.table.size(); j ++) {
				if (differentValues(this.table.get(i), this.table.get(j))) {
					boolean entscheidungsueberdeckung = true;
					if (this.table.get(i)[this.table.get(i).length - 1] == this.table.get(j)[this.table.get(j).length - 1]) {
						entscheidungsueberdeckung = false;
					}
					System.out.println("Entscheidungsüberdeckung: " + entscheidungsueberdeckung);
					System.out.println("einfache Bedingungsüberdeckung: ");
					ArrayList<int[]> result = new ArrayList<>();
					result.add(this.table.get(i));
					result.add(this.table.get(j));
					printTable(result);
					return;
				}
			}
		}
		System.out.println("einfache Bedingungsüberdeckung nicht möglich");
	}
	
	// #############################################################################
	//Einfache Bedingungsüberdeckung: Überprüfung, ob jede (atomare) Teilbedingung in jeder
	//Entscheidung mindestens einmal mit den Werten True und False ausgeführt wurde. Es wird die Va
	//riante geliefert, wo auch Entscheidungsüberdeckung enthalten ist
	
	public void simpleConditionCoverageWithDecisionCoverage() {
		for (int i = 0; i < this.table.size(); i++) {
			for (int j = i + 1; j < this.table.size(); j ++) {
				if (differentValues(this.table.get(i), this.table.get(j))) {
					
					boolean entscheidungsueberdeckung = true;
					if (this.table.get(i)[this.table.get(i).length - 1] == this.table.get(j)[this.table.get(j).length - 1]) {
						entscheidungsueberdeckung = false;
					}
					
					if (entscheidungsueberdeckung == false) {
						continue;
					}
					
					System.out.println("einfache Bedingungsüberdeckung: ");
					ArrayList<int[]> result = new ArrayList<>();
					result.add(this.table.get(i));
					result.add(this.table.get(j));
					printTable(result);
					System.out.println("Entscheidungsüberdeckung: " + entscheidungsueberdeckung);
					return;
				}
			}
		}
		System.out.println("einfache Bedingungsüberdeckung nicht möglich");
	}
	
	
	// #############################################################################
	//Hilfsmethode
	//Ändert den entsprechenden Wert auf Gegenteil
	public int[] changeValue(int[] vector, int value) {
		int length = vector.length - 1;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = vector[i];
		}
		if (vector[value] == 0) {
			result[value] = 1;
		}
		else if (vector[value] == 1)  {
			result[value] = 0;
		}
		
		
		return result;
	}
	
	// #############################################################################
	//Minimale bestimmende Mehrfachbedingungsüberdeckung
	
	public void minimalDeterminingMultipleConditionCoverage() {
		int length = this.table.get(0).length;
		ArrayList<int[]> coverage = new ArrayList<>();
		for (int i = 0; i < this.table.size(); i++) {
			for (int j = 0; j < length - 1; j++) {
				if ((getResult(changeValue(this.table.get(i), j)) != this.table.get(i)[length-1]) &&
						(!coverage.contains(this.table.get(i)))){
					coverage.add(this.table.get(i));
				}
			}
		}
		System.out.println("Minimale bestimmende Mehrfachbedingungsüberdeckung");
		printTable(coverage);
	}

	// #############################################################################
	//Beißpiele

	public static void main(String[] args) throws IOException {
		// gültige Eingabevektore
		int[] vector1 = { 0, 0, 0 };
		int[] vector2 = { 1, 0, 0 };
		int[] vector3 = { 0, 1, 0 };
		int[] vector4 = { 1, 1, 0 };
		int[] vector5 = { 0, 0, 1 };
		int[] vector6 = { 1, 0, 1 };
		int[] vector7 = { 0, 1, 1 };
		int[] vector8 = { 1, 1, 1 };
		// ungültiger Eingabevektor
		int[] vector9 = { 1, 1, 2 };

		TruthTables table = new TruthTables();

		// table.createTable();
		// table.printTable();

		table.addTable(table.tableExample);

		table.getResult(vector1);

		//Nachbare
		table.checkNeighbours(vector1, vector2);
		table.checkNeighbours(vector2, vector1);
		table.checkNeighbours(vector2, vector3);
		table.checkNeighbours(vector3, vector2);
		table.checkNeighbours(vector3, vector4);
		table.checkNeighbours(vector4, vector3);
		table.checkNeighbours(vector4, vector5);
		table.checkNeighbours(vector5, vector4);
		table.checkNeighbours(vector5, vector6);
		table.checkNeighbours(vector6, vector5);
		table.checkNeighbours(vector6, vector7);
		table.checkNeighbours(vector7, vector6);
		table.checkNeighbours(vector7, vector8);
		table.checkNeighbours(vector8, vector7);
		// keine Nachbare
		table.checkNeighbours(vector8, vector1);
		table.checkNeighbours(vector1, vector8);
		table.checkNeighbours(vector1, vector3);
		//falsche Eingabe
		table.checkNeighbours(vector8, vector9);
		table.checkNeighbours(vector9, vector8);
		//einfache Bedingungsüberdeckung
		table.simpleConditionCoverageWithDecisionCoverage();
		//Minimale bestimmende Mehrfachbedingungsüberdeckung
		table.minimalDeterminingMultipleConditionCoverage();
		
	}

}
