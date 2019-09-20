package freeframe.utils;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.regex.Pattern;

public class FileReorderingTool {

     static {
         try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (UnsupportedLookAndFeelException e) {
             e.printStackTrace();
         }
     }


    public static void main(String[] args) {

        System.out.println(UIManager.getSystemLookAndFeelClassName());

        JFileChooser jFileChooser = new JFileChooser();
//        jFileChooser.setVisible(true);
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JFrame frame = new JFrame();


        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(jFileChooser);

        JButton button1 = new JButton("拖拽文件夹到此/选择文件夹");
        button1.setBounds(200,500, 100, 50);
        button1.setContentAreaFilled(false);  //消除按钮背景颜色
        button1.setOpaque(false); //除去边框
        button1.setFocusPainted(false);//出去突起
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = jFileChooser.showOpenDialog(frame);
                if(result == JFileChooser.APPROVE_OPTION) {

                    File file = jFileChooser.getSelectedFile();//获取打开的文件
                    System.out.println(file.getAbsolutePath());
                    recordering(file);

                }
            }
        });
        button1.setTransferHandler(new TransferHandler() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    Object o = t.getTransferData(DataFlavor.javaFileListFlavor);

                    String filepath = o.toString();
                    if (filepath.startsWith("[")) {
                        filepath = filepath.substring(1);
                    }
                    if (filepath.endsWith("]")) {
                        filepath = filepath.substring(0, filepath.length() - 1);
                    }
                    System.out.println(filepath);
                    button1.setText(filepath);
                    recordering(new File(filepath));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public boolean canImport(JComponent comp, DataFlavor[] flavors) {
                for (int i = 0; i < flavors.length; i++) {
                    if (DataFlavor.javaFileListFlavor.equals(flavors[i])) {
                        return true;
                    }
                }
                return false;
            }
        } );
        frame.add(button1);
        frame.setVisible(true);
    }


    private static void recordering(File file){

        File[] files = file.listFiles();
        List<File> fileList = Arrays.asList(files);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                Integer o1Index = Integer.valueOf(Pattern.compile("[^0-9]").matcher(o1.getName()).replaceAll("").trim());
                Integer o2Index = Integer.valueOf(Pattern.compile("[^0-9]").matcher(o2.getName()).replaceAll("").trim());
                return o1Index.compareTo(o2Index);
            }
        });

        String path = file.getAbsolutePath();
        int i = 0;
        for (File file1 : fileList) {
            if (file1.isDirectory()){
                return;
            }
            String suffixName = file1.getName().substring(file1.getName().lastIndexOf("."));

            String oldName = file1.getName();
            if (file1.renameTo(new File(path + File.separator + i + suffixName))) {
                System.out.println(i+"修改 "+ oldName +" 成功! : "+(i+suffixName));
            }
            else{
                System.err.println(i+"修改 "+ oldName +" 失败!");
            }
            i++;
        }

//        Reader reader = null;
//        try {
//            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
//            // 一次读一个字符
//            reader = new InputStreamReader(new FileInputStream(file));
//            int tempchar;
//            while ((tempchar = reader.read()) != -1) {
//                if (((char) tempchar) != '\r') {
//                    System.out.print((char) tempchar);
//                    //   String str = ""+tempchar;
//                }
//            }
//            reader.close();
//        } catch (Exception et) {
//            et.printStackTrace();
//        }
    }
}
