package scrape;

import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*; // Only needed if scraping a local File.

public class Scraper {
  public Scraper() {
    File input = new File("/Users/earias/Desktop/CO_gen_assembly.html");
    Document doc = null;
    try {
      doc = Jsoup.parse(input, "UTF-8", "");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    clean(doc);

    /**
    Document doc = null;
    try {
      doc = Jsoup.connect("http://www.geog.leeds.ac.uk/courses/other/" +
          "programming/practicals/general/web/scraping-intro/table.html").get();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    */

    Element table = doc.getElementById("Bill Type");
    Elements rows = table.getElementsByTag("tr");

    for (Element row : rows) {
      Elements tds = row.getElementsByTag("th");
      for (int i = 0; i < tds.size(); i++) {
        if (i == 1) System.out.println(tds.get(i).text());
      }
    }
  }

  public static void main (String args[]) {
    new Scraper();
  }
}
