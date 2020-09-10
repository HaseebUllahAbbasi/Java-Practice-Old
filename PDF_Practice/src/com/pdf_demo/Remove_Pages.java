package com.pdf_demo;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class Remove_Pages
{
    public static void main(String[] args) throws IOException {
        File file = new File("sample_2.pdf");
        PDDocument document = PDDocument.load(file);

        //Listing the number of existing pages
        int noOfPages= document.getNumberOfPages();
        System.out.print(noOfPages);

        //Removing the pages
        document.removePage(2);

        System.out.println("page removed");

        //Saving the document
        document.save("sample_4.pdf");

        //Closing the document
        document.close();
    }
}
