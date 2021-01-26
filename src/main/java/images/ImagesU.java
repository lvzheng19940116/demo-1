package images;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author LvZheng
 * @date 2021/1/26
 */
public class ImagesU {
    /**
     * 文字生成图片
     * 小于等于2取前两个 等于三取后两个  大于等于4取4个
     * 背景颜色随机
     *
     * @param content 文字内容
     * @param width   图片宽度，默认256
     * @param height  图片高度，默认256
     * @return 图像
     */
    public static BufferedImage createImages(String content, int width, int height) {
        // 处理下参数
        if (StringUtils.isBlank(content)) {
            return null;
        }
        // 分析要写入的文字
        if (content.length() <= 2) {
            content = content;
        } else if (content.length() == 3) {
            content = content.substring(1, 3);
        } else if (content.length() > 3) {
            content = content.substring(0, 4);
        }

        content = content.toUpperCase();

        // 准备
        BufferedImage im;
        Graphics2D gc;
        Color colorFont = Color.white;
        Color colorBg = randomBg();
        // 判断图片格式
        int imageType = BufferedImage.TYPE_INT_BGR;
        // 生成背景
        im = new BufferedImage(width, height, imageType);
        gc = im.createGraphics();
        gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gc.setBackground(colorBg);
        gc.clearRect(0, 0, width, height);
        Font cFont = getFont();
        gc.setColor(colorFont);
        gc.setFont(cFont);
        FontMetrics cFontM = gc.getFontMetrics(cFont);
        int cW = cFontM.stringWidth(content);
        int ascent = cFontM.getAscent();
        int descent = cFontM.getDescent();
        // int a,b;
        int x = 0;
        int y = 0;
        if (content.length() <= 2 || cW < width) {
            x = width / 2 - cW / 2;
            y = (height - (ascent + descent)) / 2 + ascent;
            gc.drawString(content, x, y);
        } else {
            //需要换行  页面宽度（width）小于 字符串长度
            if (cW > width) {
                int rowWidth = 0;   //已用字当前行宽度
                int tempWidth;
                String lineString = "";
                List<String> contentLineList = new ArrayList<String>();
                List<Integer> contentLineWidth = new ArrayList<Integer>();
                FontDesignMetrics metrics = FontDesignMetrics.getMetrics(cFont);
                int fontHeight = metrics.getHeight();
                //每个新增字体宽度增加后如果超过文本框宽度就换行，没超过就不换行
                for (int i = 0; i < content.length(); i++) {
                    tempWidth = rowWidth;//存之前的情况
                    rowWidth = rowWidth + metrics.charWidth(content.charAt(i));

                    if (rowWidth > width) {
                        contentLineList.add(lineString);
                        contentLineWidth.add(tempWidth);
                        rowWidth = metrics.charWidth(content.charAt(i));
                        lineString = "" + content.charAt(i);
                    } else {
                        lineString = lineString + content.charAt(i);
                    }

                    //最后一个字
                    if (i == content.length() - 1) {
                        contentLineList.add(lineString);
                        contentLineWidth.add(rowWidth);
                    }
                }

                //图片上写入每行文字  每行居中实现
                for (int i = 0; i < contentLineList.size(); i++) {
                    gc.drawString(contentLineList.get(i), (width - contentLineWidth.get(i)) / 2 + 5, (fontHeight + 5) * (i + 1));
                }
            }


        }
        return im;
    }

    /**
     * 引入自定义的字体
     */
    public static Font getFont() {
        Font font = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("static/font/simkai.ttf");
            InputStream inputStream = classPathResource.getInputStream();
            Font tempFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = tempFont.deriveFont(Font.BOLD, 118 * 4);
            GraphicsEnvironment ge = GraphicsEnvironment
                    .getLocalGraphicsEnvironment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }


    private static Color randomBg() {
        Map<Integer, Color> maps = Maps.newHashMap();
        maps.put(1, new Color(0, 212, 184));
        maps.put(2, new Color(59, 117, 252));
        maps.put(3, new Color(143, 82, 246));
        maps.put(4, new Color(252, 152, 36));

        int i = (int) (Math.random() * 4) + 1;
        Color color;
        if (0 < i && i < 5) {
            color = maps.get(i);
        } else {
            color = new Color(0, 212, 184);
        }
        return color;
    }

    public static void main(String[] args) {
        //汉字是270  数字是142
        BufferedImage aaa = createImages("8524", 1080, 1200);
        try {
            ImageIO.write(aaa, "JPG", new File("d:" + "/" + UUID.randomUUID().toString() + ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
