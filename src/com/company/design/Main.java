package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;

public class Main {

    public static void main(String[] args) {
        SftpClient sftpClient = new SftpClient("www.example.co.kr",22,"/home/etc","text.tmp");

        sftpClient.connect();

        sftpClient.write();

        sftpClient.read();

        sftpClient.disConnect();
    }

}


