package com.pdf_demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class Main
{
        public static void main (String args[]) throws IOException {

            //Creating PDF document object
            PDDocument document = new PDDocument();

            //Saving the document

            PDPage page = new PDPage();
            document.addPage(page);

            document.save("doc.pdf");

            System.out.println("PDF created");
            //Closing the document
            document.close();

        }

}
