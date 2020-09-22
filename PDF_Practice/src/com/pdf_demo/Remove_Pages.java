package com.pdf_demo;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Remove_Pages
{
    public static void main(String[] args) throws IOException {
        File file = new File("sample_2.pdf");
        PDDocument document = PDDocument.load(file);
        Scanner scanner = new Scanner(System.in);
        //Listing the number of existing pages
        int noOfPages= document.getNumberOfPages();
        System.out.print(noOfPages);


        //Removing the pages
        System.out.println("Enter range(start,end) to remove the pagees");

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        if(end> noOfPages || start > noOfPages || start <0 || end<0)
            return;
        int j=start;
        for (int i=start; i<end; i++)
        {
            document.removePage(j);
        }

        System.out.println("page removed");

        //Saving the document
        document.save("sample_5.pdf");

        //Closing the document
        document.close();
    }
}
