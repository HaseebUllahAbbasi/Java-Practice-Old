package com.pdf_demo;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Sep_Mer
{
    public static void main(String[] args) throws IOException {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String fileP = selectedFile.getPath();
            System.out.println(fileP);

        }

                //Loading an existing PDF document
        File file = jfc.getSelectedFile();
        PDDocument document = PDDocument.load(file);

        //Instantiating Splitter class
        Splitter splitter = new Splitter();

        //splitting the pages of a PDF document
        List<PDDocument> Pages = splitter.split(document);

        //Creating an iterator
        Iterator<PDDocument> iterator = Pages.listIterator();

        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        PDDocument new_Doc = new PDDocument();

        Scanner input = new Scanner(System.in);

        int start = input.nextInt();
        int end = input.nextInt();

        //Saving each page as an individual document
        while(start<end)
        {
            start++;
            PDDocument pd = iterator.next();
            System.out.println("start is "+start);
            PDFmerger.appendDocument(new_Doc,pd);
        }
        new_Doc.save("solution.pdf");
        System.out.println("PDF’s created");
        document.close();
    }

}
