package vn.plusplus.java.core.phim;


import vn.plusplus.java.core.phim.phimmoi.PhimMoiModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhimService {

    public void writePhimToFile(PhimMoiModel phim) throws IOException {

        String phimStr = phim.toString();
        FileWriter writer = null;
        PrintWriter buffer = null;
        try {
            writer = new FileWriter("/home/kiemnx/project/plus/java-jsoup-example/data-phim.txt", true);
            buffer = new PrintWriter(writer);
            buffer.println(phimStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buffer.close();
            writer.close();
        }
    }

    public List<PhimMoiModel> timTheoDate(String yearIssue) throws IOException {
        List<PhimMoiModel> response = new ArrayList<>();
        // Doc tu file tim kiem cac film co nam  == yearIssue
        FileReader fr = new FileReader("/home/kiemnx/project/plus/java-jsoup-example/data-phim.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while (true) {
            line = br.readLine();
            if(line == null){
                break;
            }
            PhimMoiModel model = new PhimMoiModel();
            String[] items = line.split(",");
            for(String item : items){
                if(item.startsWith("Name:")){
                    model.setName(item.replace("Name: ", ""));
                } else if(item.startsWith("PublicDate: ")){
                    model.setPublicDate(item.replace("PublicDate: ", ""));
                }
            }

            if(model.getPublicDate().equals(yearIssue)) {
                response.add(model);
            }
        }

        return response;
    }
}
