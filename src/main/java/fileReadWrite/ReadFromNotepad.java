package fileReadWrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromNotepad {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("C:\\Users\\Siddu\\Desktop\\Notepad.txt");
		BufferedReader br= new BufferedReader(fr);
		String x="";
		while ((x=br.readLine()) != null)
		{
		System.out.println(x +"\n");
		}
		br.close();
		}

	}


