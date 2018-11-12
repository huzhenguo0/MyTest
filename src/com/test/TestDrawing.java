package com.test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

/**
 * Created by hdwang on 2018/10/11.
 */
public class TestDrawing {

    @Test
    public void test(){
    	testComposite();
    }
    /**
     * 合成测试
     */
    public static void testComposite() {
        //创建背景图片（带透明分量的）
        BufferedImage bg = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bgGraphics = (Graphics2D) bg.getGraphics();
        bgGraphics.setColor(Color.yellow); //设置颜色
        bgGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //边缘抗锯齿
        bgGraphics.fillRect(0, 0, bg.getWidth(), bg.getHeight()); //填充矩形
        bgGraphics.setColor(Color.BLACK);
        bgGraphics.setFont(new Font("楷体", Font.ITALIC, 50));
        bgGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //文本抗锯齿
        bgGraphics.drawString("背景黄色", 50, 150); //画文本
        bgGraphics.dispose();

        //创建第二张图片
        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D imageGraphics = (Graphics2D) image.getGraphics();
        imageGraphics.setColor(Color.GREEN);
        imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        imageGraphics.fillRoundRect(0, 0, image.getWidth(), image.getHeight(), image.getWidth(), image.getHeight());
        imageGraphics.setColor(Color.BLACK);
        imageGraphics.setFont(new Font("楷体", Font.ITALIC, 50));
        imageGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        imageGraphics.drawString("前景绿色", 50, 200);
        imageGraphics.dispose();

        JFrame jf = new JFrame(); //窗体
        JPanel contentPanel = new JPanel(); //内容面板
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.blue)); //设置边框
        //contentPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setText("组合模式：");
        contentPanel.add(label);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("默认");
        comboBox.addItem("CLEAR");
        comboBox.addItem("SRC");
        comboBox.addItem("DST");
        comboBox.addItem("SRC_OVER");
        comboBox.addItem("DST_OVER");
        comboBox.addItem("SRC_IN");
        comboBox.addItem("DST_IN");
        comboBox.addItem("SRC_OUT");
        comboBox.addItem("DST_OUT");
        comboBox.addItem("SRC_ATOP");
        comboBox.addItem("DST_ATOP");
        comboBox.addItem("XOR");
        contentPanel.add(comboBox);

        jf.setContentPane(contentPanel); //窗体设置内容面板为jp
        jf.setBounds(200, 200, 500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true); //窗体可见


        final DrawingPanel drawPanel = new DrawingPanel();
        drawPanel.setBounds(0,35,500,440);
        drawPanel.setPreferredSize(new Dimension(500,440));
        drawPanel.setBorder(BorderFactory.createLineBorder(Color.red)); //设置边框
        drawPanel.setBg(bg);
        drawPanel.setImage(image);
       // drawPanel.setAlphaComposite(AlphaComposite.SrcAtop);
        contentPanel.add(drawPanel);

        final Map<String,AlphaComposite> compositeMap = new HashMap<>();
        compositeMap.put("CLEAR",AlphaComposite.Clear);
        compositeMap.put("SRC",AlphaComposite.Src);
        compositeMap.put("DST",AlphaComposite.Dst);
        compositeMap.put("SRC_OVER",AlphaComposite.SrcOver);
        compositeMap.put("DST_OVER",AlphaComposite.DstOver);
        compositeMap.put("SRC_IN",AlphaComposite.SrcIn);
        compositeMap.put("DST_IN",AlphaComposite.DstIn);
        compositeMap.put("SRC_OUT",AlphaComposite.SrcOut);
        compositeMap.put("DST_OUT",AlphaComposite.DstOut);
        compositeMap.put("SRC_ATOP",AlphaComposite.SrcAtop);
        compositeMap.put("DST_ATOP",AlphaComposite.DstAtop);
        compositeMap.put("XOR",AlphaComposite.Xor);
        //下拉框选中事件
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selected =  e.getItem().toString();
                    System.out.println(selected);
                    drawPanel.setAlphaComposite(compositeMap.get(selected));
                    drawPanel.repaint(); //重画
                }
            }
        });

        //窗体改变事件
        jf.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("window state:"+e.paramString());
            }
        });
    }


    static class DrawingPanel extends JPanel{
        BufferedImage bg;
        BufferedImage image;
        AlphaComposite alphaComposite;

        public BufferedImage getBg() {
            return bg;
        }

        public void setBg(BufferedImage bg) {
            this.bg = bg;
        }

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
        }

        public AlphaComposite getAlphaComposite() {
            return alphaComposite;
        }

        public void setAlphaComposite(AlphaComposite alphaComposite) {
            this.alphaComposite = alphaComposite;
        }

        /**
         * 重写paint方法
         * @param g
         */
        @Override
        public  void paint(Graphics g){
            //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
            super.paint(g);

            //在面板上画画
            Graphics2D g2d = (Graphics2D)g;
            g2d.setComposite(AlphaComposite.Src);
            g2d.drawImage(bg,100,100,null); //背景图
            if(alphaComposite!=null) {
                g2d.setComposite(alphaComposite);
            }else{
                //默认SrcOver
                g2d.setComposite(AlphaComposite.SrcOver);
            }
            g2d.drawImage(image,100,100,null); //叠加图

            //g2d.setColor(Color.GREEN);
            //g2d.fillRoundRect(100,100,image.getWidth(),image.getHeight(),image.getWidth(),image.getHeight()); //叠加图层
            g2d.dispose();
        }
    }
}