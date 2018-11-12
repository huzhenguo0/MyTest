package com.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
//jsoup 爬虫
public class ReptileTest {
	@Test
	public void test(){
		try {
            long startTime = System.currentTimeMillis();
            List<String> buildingIdList = new ArrayList<>();
            int pageNum = 0;
            while (1 == 1) {
                pageNum++;
                try {
                    System.out.println("当前页：" + pageNum);
                    String url = "http://sz.diandianzu.com/listing/p"+pageNum;
                    Document doc = Jsoup.connect(url).get();
                    if(doc == null){
                        continue;
                    }
                    Elements data = doc.getElementsByClass("list-main");
                    Elements dataIdList = data.select("[data-id]");
                    if (null == dataIdList || dataIdList.size() <= 0) {
                        break;
                    }
                    for (Element dataIdElement : dataIdList) {
                        String dataId = dataIdElement.attr("data-id");
                        System.out.println("写字楼id:" + dataId);
                        buildingIdList.add(dataId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("一共有写字楼"+buildingIdList.size());
            long endTime = System.currentTimeMillis();
            System.out.println("获取楼盘id一共用时"+(endTime - startTime)/1000+"秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
