package vn.plusplus.java.core;


import vn.plusplus.java.core.phim.phimmoi.PhimMoiModel;
import vn.plusplus.java.core.phim.phimmoi.PhimMoiParser;

import java.util.List;

public class Application {

    public static void main(String[] args){
        String url = "http://www.phimmoi.net/phim-chieu-rap/";
        PhimMoiParser phimMoiParser = new PhimMoiParser();
        List<String> linkArray = phimMoiParser.parserListLink(url);
        for(String link : linkArray){
            PhimMoiModel phim = phimMoiParser.parserDetail(link);
            System.out.println(phim.toString());
        }
    }
}
