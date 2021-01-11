package charpicture.img;


import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

/**
 * 对图像操作的简化 API
 *
 * @author zozoh(zozohtnt @ gmail.com)
 */
public class Images {


    /**
     * 文字生成图片
     *
     * @param content 文字内容
     * @param width   图片宽度，默认256
     * @param height  图片高度，默认256
     * @return 图像
     */
    public static BufferedImage createText(String content, int width, int height) {
        // 处理下参数
        if (StringUtils.isBlank(content)) {
            return null;
        }
        // 分析要写入的文字
        if (content.length() > 2) {
            content = ("" + content.charAt(0));
        }
        content = content.toUpperCase();

        if (width <= 0) {
            width = 256;
        }
        if (height <= 0) {
            height = 256;
        }

        // 准备
        BufferedImage im;
        Graphics2D gc;
        Color colorFont = Color.white;
        Color colorBg = Color.black;
        // 判断图片格式
        int imageType = BufferedImage.TYPE_INT_RGB;
        // 生成背景
        im = new BufferedImage(width, height, imageType);
        gc = im.createGraphics();
        gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gc.setBackground(colorBg);
        gc.clearRect(0, 0, width, height);
        // 写入文字
        Font cFont = new Font("微软雅黑", Font.BOLD, 128);
        gc.setColor(colorFont);
        gc.setFont(cFont);
        FontMetrics cFontM = gc.getFontMetrics(cFont);
        int cW = cFontM.stringWidth(content);
        int ascent = cFontM.getAscent(); // 取得Ascent
        int descent = cFontM.getDescent(); // 取得Descent
        int x, y;
        x = width / 2 - cW / 2;
        y = (height - (ascent + descent)) / 2 + ascent;
        gc.drawString(content, x, y);
        return im;
    }


    public static void main(String[] args) {
        BufferedImage aaa = createText("lv", 256, 256);
        try {
            ImageIO.write(aaa, "JPG", new File("d:" + "/" + UUID.randomUUID().toString() + ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
