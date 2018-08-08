import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class JavaSpider {
    public static void main(String[] args) throws IOException {

//        //抓取省市区
//        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/index.html";
//        //String[] select_arr={".provincetable a[href]" ,".citytable a[href]",".countytable a[href]",".towntable a[href]",".villagetable"};
////        printProvince(url, ".provincetable a[href]");
//        String beijing_url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/41.html";//河南省
//        printProvince(beijing_url, ".citytable tr td a[href]");


        String pic_url="https://stock.tuchong.com/search?category=149,2004";


    }
    public static void getPink(String url, String select) throws IOException {
        Document doc = Jsoup.connect(url).timeout(1000 * 10).get();
        Elements a_hrefs = doc.select(select);
        System.out.println("数量" + a_hrefs.size());
        for (Element a_href : a_hrefs) {
            String province = a_href.text();
            if (!Pattern.matches("[\\u4E00-\\u9FA5\\\\s]+", province)) {//若文字不是汉字
                continue;
            }
            String province_link = a_href.absUrl("href");
            System.out.println(province + "---》" + province_link);

        }
    }

    public static void printProvince(String url, String select) throws IOException {
        Document doc = Jsoup.connect(url).timeout(1000 * 10).get();
        Elements a_hrefs = doc.select(select);
        System.out.println("数量" + a_hrefs.size());
        for (Element a_href : a_hrefs) {
            String province = a_href.text();
            if (!Pattern.matches("[\\u4E00-\\u9FA5\\\\s]+", province)) {//若文字不是汉字
                continue;
            }
            String province_link = a_href.absUrl("href");
            System.out.println(province + "---》" + province_link);

        }
    }



}
