package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    public static List<String> generate (int sizeGrid) throws GridSizeLessThat2Exception {
        if(sizeGrid<2){
            throw new GridSizeLessThat2Exception();
        }
        if(sizeGrid>300){
            sizeGrid=300;
            System.out.println("The maximum grid size is 300.");
            System.out.println("a Grid of size 300 was created");
        }
        List<String> result= new ArrayList<>();
        Random generator= new Random();
        for (int i=0;i<sizeGrid;i++){
            StringBuilder line=new StringBuilder();
            for (int j=0;j<sizeGrid;j++){
                if(generator.nextInt()%3==0){
                    line.append("X");
                }else {
                    line.append(".");
                }
            }
            result.add(line.toString());
        }
        return result;
    }
}
