package com.pdf_demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class Open_Doc
{
    public static void main(String[] args) throws IOException {
        File file = new File("doc.pdf");
        PDDocument document = PDDocument.load(file);

        System.out.println("PDF loaded");

        //Adding a blank page to the document
        document.addPage(new PDPage());

        //Saving the document
        document.save("doc_1.pdf");

        //Closing the document
        document.close();

    }
}
