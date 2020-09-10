package com.pdf_demo;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Sep_Mer
{
    public static void main(String[] args) throws IOException {

        //Loading an existing PDF document
        File file = new File("sample_2.pdf");
        PDDocument document = PDDocument.load(file);

        //Instantiating Splitter class
        Splitter splitter = new Splitter();

        //splitting the pages of a PDF document
        List<PDDocument> Pages = splitter.split(document);

        //Creating an iterator
        Iterator<PDDocument> iterator = Pages.listIterator();

        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        PDDocument new_Doc = new PDDocument();

        //Saving each page as an individual document
        int i = 1;
        while(iterator.hasNext())
        {
            if(i<5)
            {
                i++;
                iterator.next();
                continue;
            }
            i++;
            PDDocument pd = iterator.next();
            System.out.println("i is "+i);
            PDFmerger.appendDocument(new_Doc,pd);
        }
        new_Doc.save("sample_3.pdf");
        System.out.println("PDF’s created");
        document.close();
    }

}
