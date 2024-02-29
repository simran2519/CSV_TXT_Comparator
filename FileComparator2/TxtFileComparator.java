package Weekly_Assignment.FileComparator2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class TxtFileComparator extends FileComparator
{
    @Override
    public boolean comparefiles(String file1, String file2) throws IOException {
        File f1 = new File(file1);
        File f2 = new File(file2);

        Scanner sc1 = new Scanner(new FileReader(f1));
        Scanner sc2 = new Scanner(new FileReader(f2));

        String line1, line2;
        boolean flag = true;
        int row=0;
        int col;
        File output ;
        FileWriter fileWriter = null;
        while (sc1.hasNextLine() && sc2.hasNextLine()) {

            row++;
            line1 = sc1.nextLine();
            line2 = sc2.nextLine();
            String[] a1 = line1.split(" ");
            String[] a2 = line2.split(" ");
            for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
                String s1 = a1[i];
                String s2 = a2[i];
                col=i+1;
                if (!s1.equals(s2)) {
                    if(flag==true)
                    {
                        output = new File("C:/Users/91774/Desktop/AVI soft/Weekly_Assignment/FileComparator2/outputFile1.txt");
                        fileWriter = new FileWriter(output);
                        fileWriter.append("(Word "+ col+" in line " + row+") : " + s1 + "------------- " + s2+"\n");
                    }
                    else
                    {
                        fileWriter.append("(Word "+ col+" in line " + row+") : " + s1 + "------------- " + s2+"\n");
                    }
                    flag = false;
                }
            }
        }
        sc1.close();
        sc2.close();
        if(fileWriter!=null)
        {
            fileWriter.close();
        }
        return flag;
    }
}
