package org.example;

import org.jsoup.Jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class scraper {
    public static void main(String[] args) {
        //first create a url or copy the url from the web site
        String url="https://books.toscrape.com/";
        try {
                // create a variable document                    //use jsoup to connect that url to get use get()
            Document document= (Document) Jsoup.connect(url).get();
          //Elements is used to store list of elements   //this select can query HTML tags and classess also query ID's in Html
           Elements books=document.select(".product_pod");

           //loop to check the where books
            System.out.println("-----------Start---------------");
            for(Element bk:books) {
                //Every book as title
                String title = String.valueOf(bk.select("h3 > a").text());
                System.out.println();
                String price = String.valueOf(bk.select(".price_color").text());
                System.out.println(title + " " + price);
                //getting only price less than 20
//                String actualprice = price.substring(1);
//                if (Double.parseDouble(actualprice) < 20.0) {
//                    System.out.println(title + " " + price);
//                }
            }
            System.out.println("--------------End ---------------");

        }catch (IOException e){
            //we using try catch because some time the url may not found for this we using exception
            e.printStackTrace();
        }

// note:when we scrap from any website that where data we get as string
    }
}
