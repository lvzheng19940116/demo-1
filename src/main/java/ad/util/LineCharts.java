package ad.util;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class LineCharts {

	// 保存为文件
	public static void saveAsFile(JFreeChart chart, String outputPath, int weight, int height) {
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			  
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);
			// 保存为PNG
			// ChartUtilities.writeChartAsPNG(out, chart, 600, 400);
			// 保存为JPEG
			ChartUtilities.writeChartAsJPEG(out, chart, weight, height);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}

	// 根据CategoryDataset创建JFreeChart对象
	public static JFreeChart createChart(CategoryDataset categoryDataset, String titel, String yLend) {
		// 创建JFreeChart对象：ChartFactory.createLineChart
		JFreeChart jfreechart = ChartFactory.createLineChart(titel, // 标题
				"年分", // categoryAxisLabel （category轴，横轴，X轴标签）
				yLend, // valueAxisLabel（value轴，纵轴，Y轴的标签）
				categoryDataset, // dataset
				PlotOrientation.VERTICAL, true, // legend
				false, // tooltips
				false); // URLs
		// 使用CategoryPlot设置各种参数。以下设置可以省略。
		CategoryPlot plot = (CategoryPlot) jfreechart.getPlot();

		// 背景色 透明度
		plot.setBackgroundAlpha(0.5f);
		// 前景色 透明度
		plot.setForegroundAlpha(0.5f);
		// 其他设置 参考 CategoryPlot类
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		renderer.setBaseShapesVisible(false); // series 点（即数据点）可见
		renderer.setAutoPopulateSeriesStroke(true);
		renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
		renderer.setUseSeriesOffset(true); // 设置偏移量
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));// x轴的字体
		NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
		// numberaxis.set
		plot.getRangeAxis().setLabelFont(new Font("宋体", Font.BOLD, 15));// 设置y轴字体
		numberaxis.setTickLabelFont(new Font("黑体", Font.PLAIN, 12));// 设置Y轴坐标上的文字
		numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));// 设置Y轴的标题文字
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));// 设置下标的字体
		jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
		return jfreechart;
	}

	/**
	 * 创建CategoryDataset对象
	 * 
	 */
	public static CategoryDataset createDataset(JSONArray jsonArr, String colKey, String titel, String dateType) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if ("d".equals(dateType)) {
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObject = jsonArr.getJSONObject(i);
				String string = jsonObject.getString("createTime");
				String substring = string.substring(8, 11);
				dataset.addValue(jsonObject.getDouble(colKey), titel, substring);
			}
		} else if ("h".equals(dateType)) {
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject jsonObject = jsonArr.getJSONObject(i);
				String string = jsonObject.getString("createTime");
				String substring = string.substring(12, 15);
				dataset.addValue(jsonObject.getDouble(colKey), titel, substring);

			}
		}

		return dataset;
	}

}
