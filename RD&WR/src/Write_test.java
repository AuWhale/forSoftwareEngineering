import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Write_test {
	public static void main(String [] args)  throws IOException {
		String path = "F:\\WorkSpace\\";
		String titlein = "yq_in";
		String titleout = "yq_out";
		String province = "";
		String judge1 = "�㽭ʡ";
		String str = "";
		boolean tag = true; 
		
		File file1 = new File(path + titlein +".txt");
		File file2 = new File(path + titleout + ".txt");
		if(file2.exists()) {
			file2.delete();
			file2.createNewFile();
		}
		file2.createNewFile();
		
		FileReader frr = new FileReader(file1);
		BufferedReader brr = new BufferedReader(frr);
		
		FileWriter fwr = new FileWriter(file2, true);
		BufferedWriter bwr = new BufferedWriter(fwr);
		
		if(brr.readLine() != null) {
			str = brr.readLine();
		}
			while(!str.equals("") || str != null ) {
				str = brr.readLine();

				province = str.substring(0, 3);
				
				if(province.equals(judge1)) {
				//�жϵ�ǰʡ�ݣ����Ϊ�㽭ʡ��ֱ��д��
					if(tag == true) {
					//Ϊ�ڵ�һ��д��ʡ����ӱ�ǩ
						bwr.write(province);
						bwr.newLine();
						bwr.flush();
					}
					tag = false;
					
					str = str.substring(4);

					bwr.write(str);
					bwr.newLine();
					bwr.flush();
				}
				else if(!province.equals(judge1)) {
				//�жϵ�ǰʡ�ݣ���������㽭ʡ������Ϊ�ж�����
					bwr.newLine();
					tag = true;
					judge1 = province;
					if(tag == true) {
						bwr.write(province);
						
						bwr.newLine();
						bwr.flush();
					}
					tag = false;
					str = str.substring(4);
					bwr.write(str);
					bwr.newLine();
					bwr.flush();
				}
			}
		bwr.close();
		brr.close();
		frr.close();
		fwr.close();
	}
}
