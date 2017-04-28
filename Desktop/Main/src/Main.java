import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Document document = Jsoup.connect("https://github.com/allegro").get();
        Elements elements = document.select("a[itemprop = name codeRepository]");
        System.out.println("Repozytorium, ktorego kod byl ostatnio rozwijany to: " + getLastUpdatedRepository(elements));
    }

    private static String getLastUpdatedRepository(Elements elementsList){
        return elementsList.first().text();
    }
}
