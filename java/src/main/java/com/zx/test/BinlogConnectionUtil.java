package com.zx.test;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import com.rabbitmq.client.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class BinlogConnectionUtil {

    /*public static void main(String[] args) {
        try {

            String filePath="/Users/ricky/Downloads/mysql-bin.000026";
            File binlogFile = new File(filePath);
            EventDeserializer eventDeserializer = new EventDeserializer();
            eventDeserializer.setCompatibilityMode(
                    EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                    EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
            );
            BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
            try {
                for (Event event; (event = reader.readEvent()) != null; ) {
                    System.out.println(event.toString());
                }
            } finally {
                reader.close();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        try {
            BinaryLogClient client = new BinaryLogClient("127.0.0.1", 3306, "root", "admin");
            client.setBinlogFilename("mysql-bin.000026");
            client.setBinlogPosition(202214);
            client.registerEventListener(new BinaryLogClient.EventListener() {
                @Override
                public void onEvent(Event event) {
                    System.out.println(event.toString());
                    System.out.println(client.getBinlogPosition());
                }
            });
            client.connect();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

}
