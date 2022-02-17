import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.nio.file.Paths;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class Problem3 {

    public static void ApacheIO(String link, String path)
    {
        try {
            URL inputStream = new URL(link);
            String name = FilenameUtils.getName(link);
            File fileOS = new File(path + "/" + name);
            FileUtils.copyURLToFile(inputStream, fileOS);
            System.out.println("Download Complete");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Download Fail");
        }
    }

    public static void ApacheHTTP(String link, String path){
        CloseableHttpClient clinet = HttpClients.createDefault();
        HttpGet downloadlink = new HttpGet(link);
        CloseableHttpResponse response = null;
        try{
            response = clinet.execute(downloadlink);
            HttpEntity entity = response.getEntity();
            InputStream url = entity.getContent();
            String name = FilenameUtils.getName(link);
            FileOutputStream output = new FileOutputStream(new File(path +"/"+name));
            int inByte;
            while((inByte = url.read()) != -1){
                output.write(inByte);
            }
            url.close();
            output.close();
            System.out.println("Download Complete");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void UrlConnection(String link, String path){
        try {
            InputStream url = new URL(link).openStream();
            String name = path+"/"+FilenameUtils.getName(link);
            Files.copy(url,Paths.get(name), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Download Complete");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args){

        System.out.println("Apache IO");
        String link = "https://javarevisited.blogspot.com/2014/10/right-way-to-close-inputstream-file-resource-in-java.html";
        String link2 = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Cat_poster_1.jpg/1920px-Cat_poster_1.jpg";
        String link3 = "https://cs.muic.mahidol.ac.th/courses/ooc/api/stylesheet.css";
        String path = "C:\\Users\\ASUS\\Desktop\\Download";

        ApacheIO(link,path);


        ApacheIO(link2,path);


        ApacheIO(link3,path);

        System.out.println("=======================");

        System.out.println("Apache HTTP");

        ApacheHTTP(link,path);


        ApacheHTTP(link2,path);


        ApacheHTTP(link3,path);

        System.out.println("=======================");

        System.out.println("URLConnection");

        UrlConnection(link,path);
        UrlConnection(link2,path);
        UrlConnection(link3,path);
    }
}
