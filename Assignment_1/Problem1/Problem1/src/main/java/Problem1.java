import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;

public class Problem1 extends DirectoryWalker {


        public static List<File> searchFile(final File dir) throws IOException {
            return new DirectoryWalker() {
                @Override
                protected void handleFile(File file, int depth, Collection results) throws IOException {
                    if(file.isFile()){
                        results.add(file);
                    }
                }

                public List<File> Find() throws IOException {
                    List<File> found1 = new ArrayList();
                    this.walk(dir, found1);
                    return found1;
                }
            }.Find();
        }

        public static List<File> searchDirectory(final File dir) throws IOException {
            List<File> found = new DirectoryWalker(){
                @Override
                protected boolean handleDirectory(File directory, int depth, Collection results) throws IOException {
                    if(directory.isDirectory()){
                        results.add(directory);
                    }
                    return true;
                }
                public List<File> Find() throws IOException{
                    List<File> found = new ArrayList<>();
                    this.walk(dir, found);
                    return found;
                }
            }.Find();
            return found;
        }

        public static void getExtension (final File dir, String Command) throws IOException{
            List<File> file =  searchFile(dir);
            List<String> extensionarray = new ArrayList<String>();
            int size = searchFile(dir).size();
            for(int i = 0; i < size; i++){
                extensionarray.add(FilenameUtils.getExtension(String.valueOf(file.get(i))));
            }
            HashMap<String, Integer> freq = new HashMap<>();

            for (String temp : extensionarray) {
                if (temp.length() > 0) {
                    if (freq.containsKey(temp))
                        freq.put(temp, freq.get(temp) + 1);
                    else
                        freq.put(temp, 1);
                }
            }

            if(Command.equals("listAll")) {
                System.out.println("Total number of files for each extension = "+freq);
            }
            if(Command.equals("listKey")){
                Set<String> keys = freq.keySet();
                System.out.println("List all unique file extensions = " + keys);
            }
            if(Command.equals("listCount")){
                System.out.println("Total number of unique file extensions = " + freq.size());
            }

        }



        public static void main(String[] args) throws IOException {
            File dir = new File("C:\\Users\\ASUS\\Downloads\\Compressed\\jdk-11.0.13_doc-all");

            System.out.println("File = " + searchFile(dir).size());
            System.out.println("Dir = " + searchDirectory(dir).size());
            getExtension(dir,"listCount");
            getExtension(dir,"listKey");
            getExtension(dir,"listAll");

        }
}
