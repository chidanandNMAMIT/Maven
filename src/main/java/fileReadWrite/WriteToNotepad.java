package fileReadWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToNotepad {

	public static void main(String[] args) throws IOException {
		
		FileWriter fr=new FileWriter("C:\\Users\\Siddu\\Desktop\\Notepad.txt");
		BufferedWriter br=new BufferedWriter(fr);
		br.write("This is sample");
		br.newLine();
		br.write("Testing tools");
		br.newLine();
		br.close();
		}
}
