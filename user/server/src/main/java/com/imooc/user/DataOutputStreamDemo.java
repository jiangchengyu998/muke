package com.imooc.user;

import java.io.*;

public class DataOutputStreamDemo {
//    public static void main(String[] args) throws Exception {
////        DataOutputStream dos = null;
////        File file = new File("D:" + File.separator + "order.txt");
////        dos = new DataOutputStream(new FileOutputStream(file));
////        String names[] = {"衬衣", "手套", "围巾"};
////        float prices[] = {98.3f, 30.3f, 50.5f};
////        int nums[] = {3, 2, 1};
////        for (int i = 0; i < names.length; i++) {
////            dos.writeChars(names[i]);
////            dos.writeChar('\t');
////            dos.writeFloat(prices[i]);
////            dos.writeChar('\t');
////            dos.writeInt(nums[i]);
////            dos.writeChar('\t');
////
////        }
////        dos.close();
//        jjjj();
//    }

    public static int jjjj() throws Exception{
        DataInputStream dis =null;

        File f =new File("D:"+File. separator+"order.txt");
        dis = new DataInputStream(new FileInputStream(f));
        String name =null;
        float price =0.0f;
        int num =0;
        char temp[]=null;
        char c = 0;
        int len=0;

        try {
            while (true) {
                temp = new char[200];
                len = 0;
                while ((c = dis.readChar() )!= '\t') {
                    temp[len] = c;
                    len++;
                }
                name = new String(temp, 0, len);
                price = dis.readFloat();
                dis.readChar();
                num = dis.readInt();
                dis.readChar();
                System.out.printf("名称：%s; 价格：%5.2f; 数量：%d\n", name, price, num);
            }
        } catch (Exception ignored) {

        }

        dis.close();
        return 0;
    }
}
