package Weekly_Assignment.FileComparator2;
import java.io.IOException;
abstract class FileComparator
{
    public abstract boolean comparefiles(String file1 , String file2) throws IOException;
}