package images;


import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

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
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

/**
 * @author LvZheng
 * @date 2021/1/11
 */
@Slf4j
@Component
public class ImagesUtil {

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
        // 写入文字
        //   Font cFont = new Font("微软雅黑", Font.BOLD, 128);
        Font cFont = getFont();
        gc.setColor(colorFont);
        gc.setFont(cFont);
        FontMetrics cFontM = gc.getFontMetrics(cFont);
        // 字符串长度（像素）
        int cW = cFontM.stringWidth(content);
        log.info("字符串长度{}", cW);
        // 算出行数
        int lineSize = (int) Math.ceil(cW * 1.0 / width);
        log.info("算出行数{}", lineSize);
        //字体高度
        int fontHeight = (int) cFont.getSize2D();
        // 字体基线到最上方的距离
        int ascent = cFontM.getAscent();
        // 字体的基线到大多数字母数字的底部
        int descent = cFontM.getDescent();
        // int a,b;
        int x = 0;
        int y = 0;
        if (content.length() == 2) {
            x = width / 2 - cW / 2;
            y = (height - (ascent + descent)) / 2 + ascent;
            gc.drawString(content, x, y);
        } else {
            //需要换行  页面宽度（width）小于 字符串长度
            if (cW > width) {
                // 存储每一行的字符串
                StringBuilder sb = new StringBuilder();
                int j = 0;
                int tempStart = 0;
                // 存储换行之后每一行的字符串
                String tempStrs[] = new String[lineSize];
                for (int i = 0; i < content.length(); i++) {
                    char ch = content.charAt(i);
                    sb.append(ch);
                    Rectangle2D bounds2 = cFontM.getStringBounds(sb.toString(), null);
                    //文字累计宽度
                    int tempStrPilexlWildth = (int) bounds2.getWidth();
                    if (tempStrPilexlWildth > width) {
                        tempStrs[j++] = content.substring(tempStart, i);
                        tempStart = i;
                        sb.delete(0, sb.length());
                        sb.append(ch);
                    }
                    if (i == content.length() - 1) {
                        // 最后一行
                        tempStrs[j] = content.substring(tempStart);
                    }
                }
                for (int i = 0; i < tempStrs.length; i++) {
                    gc.drawString(tempStrs[i], 5, (fontHeight + 5) * (i + 1));
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
            // 解决中文支持问题
            ClassPathResource classPathResource = new ClassPathResource("static/font/simkai.ttf");
            InputStream inputStream = classPathResource.getInputStream();
            Font tempFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            //适应图片比例
            font = tempFont.deriveFont(Font.BOLD, 118);
            GraphicsEnvironment ge = GraphicsEnvironment
                    .getLocalGraphicsEnvironment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }


    private static Color randomBg() {
        Map<Integer, Color> maps = Maps.newHashMap();
        maps.put(1, Color.cyan);
        maps.put(2, Color.blue);
        maps.put(3, Color.green);
        maps.put(4, Color.gray);
        maps.put(5, Color.magenta);
        maps.put(6, Color.orange);
        maps.put(7, Color.yellow);
        maps.put(8, Color.pink);
        int i = (int) (Math.random() * 8) + 1;
        log.info("随机数：{}", i);
        Color color;
        if (0 < i && i < 9) {
            color = maps.get(i);
        } else {
            color = Color.gray;
        }
        return color;
    }


    public static void main(String[] args) {
        //汉字是270  数字是142
        BufferedImage aaa = createImages("abcd", 270, 270);
        try {
            ImageIO.write(aaa, "JPG", new File("d:" + "/" + UUID.randomUUID().toString() + ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //-7
        //183

        //57
        //183


    }
}
