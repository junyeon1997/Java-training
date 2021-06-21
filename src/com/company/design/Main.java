package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.Writer;

public class Main {

    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.example.co.kr",22,"/home/path");
        ftpClient.connect();
        ftpClient.disConnect();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();
    }





    }


