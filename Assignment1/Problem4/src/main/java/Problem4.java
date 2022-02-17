import java.net.*;
import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;


public class Problem4 {
    static HashSet<String> weblink = new HashSet<>();
    static String realweb = "";

    public static void crawler(String URL) {
        String url = URL.split("#")[0];
        try {
            URL link = new URL(url); // Link from crawer
            URL scope = new URL(realweb); //Check that if it go out
            if (!weblink.contains(url) && link.getHost().contains(scope.getHost()) && url.length() > 0) {
                try {

                    if (weblink.add(url)) {
                        System.out.println(url);
                        download(url);
                    }
                    Document doc = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true).get();

                    Elements availableLinksOnPage = doc.select("a[href]");

                    for (Element ele : availableLinksOnPage) {
                        crawler(ele.attr("abs:href"));
                    }
                } catch (IllegalArgumentException | IOException e) {
                    // print exception messages
                    System.err.println("For '" + url + "': " + e.getMessage());
                    download(url);
                }
            }
        } catch (IOException e){
            System.out.println("ERROR AT LINK OF THE CRAWER");
            System.err.println("For '" + url + "': " + e.getMessage());
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
            FileOutputStream output = new FileOutputStream(new File(path));
            int inByte;
            while((inByte = url.read()) != -1){
                output.write(inByte);
            }
            url.close();
            output.close();
        } catch (IOException e) {
            System.out.println("ERROR AT APACHEIO");
            System.err.println("For '" + link + "': " + e.getMessage());

        }
    }
    public static void download(String url)  {
        try {
            URL link = new URL(url);
            ArrayList<String> correct_path = new ArrayList<>();
            String save = new String(link.getPath().replaceAll("/"," "));
            for(String word : save.split(" ")){
                if(word.length() > 0) {
                    correct_path.add(word);
                }
            }
            correct_path.remove(0);
            String path_of_url = correct_path.toString().replaceAll("\\[|\\]", "").replaceAll(", ","/");

            String path = "C:\\Users\\ASUS\\Desktop\\Download\\q4" + "\\" + path_of_url;
            File file = new File(path);
            file.getParentFile().mkdirs();
            FileWriter create = new FileWriter(file);
            ApacheHTTP(url, path);
        }catch (IOException e) {
            System.out.println("ERROR AT DOWNLOAD");
            System.err.println("For '" + url + "': " + e.getMessage());

        }
    }
    public static void main(String[] args){
        String url = "https://cs.muic.mahidol.ac.th/courses/ooc/api/index.html";
        realweb = url;
        crawler(url);
        System.out.println("Download Finish");
    }
}
