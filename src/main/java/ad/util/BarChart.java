package ad.util;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {
    
    public ChartPanel getChartPanel(JFreeChart chart){
    	ChartPanel frame1 = new ChartPanel(chart,true);
    	return frame1;
    }
    
    public JFreeChart getBarChart(CategoryDataset dataset,String title){
    	JFreeChart chart = ChartFactory.createBarChart3D(
                title, // 图表标题
               "结果类型", // 目录轴的显示标签
               "资产数量", // 数值轴的显示标签
               dataset, // 数据集
               PlotOrientation.VERTICAL, // 图表方向：水平、垂直
               true,           // 是否显示图例(对于简单的柱状图必须是false)
               false,          // 是否生成工具
               false           // 是否生成URL链接
               );

			//从这里开始
			CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
			CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
			domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
			domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
			ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
			rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
			chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
			chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
			
			return chart;
    }
       
       public CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           dataset.addValue(100, "未查", "未查");
           dataset.addValue(200, "符合", "符合");
           dataset.addValue(300, "不符合", "不符合");
           dataset.addValue(400, "报废", "报废");
           return dataset;
       }
       
    public void writeChart(JFreeChart jfreechart,String path)
   	{
    	try {
			ByteArrayOutputStream fos = new ByteArrayOutputStream();

				try {
					ChartUtilities.writeChartAsJPEG(
						fos, //文件流
						1, //JPEGͼ格式
						jfreechart, //ͳ结果图
						1000, //宽
						500,//高
						null //ChartRenderingInfo 
						);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				File file=new File(path);
				if (!file.exists()) {
					file.createNewFile();
				}
				DataOutputStream to=new DataOutputStream(new FileOutputStream(file));
				fos.writeTo(to);
				
				to.close();
				fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   			
   	}
	
	
	/*public static void main(String args[]){
	    JFrame frame=new JFrame("Java数据统计图");
	    frame.setLayout(new GridLayout(2,2,10,10));
	    
	    BarChart bar = new BarChart();
	    JFreeChart chart = bar.getBarChart(bar.getDataSet(),"酒仙桥地区资产清查结果柱状图");
	    bar.writeChart(chart, "e:/bar.jpg");
	    frame.add(bar.getChartPanel(chart));//添加柱形图
	    
	    PieChart pie = new PieChart();
	    chart = pie.getPieChart(pie.getDataSet(),"水果产量");
	    pie.writeChart(chart, "e:/pie.jpg");
	    frame.add(bar.getChartPanel(chart));//添加饼状图
	    
	    SeriesChart series = new SeriesChart();
	    chart = series.getSeriesChart(series.createDataset());
	    series.writeChart(chart, "e:/series.jpg");
	    frame.add(series.getChartPanel(chart));//添加折线图
	    
	    
	    frame.setBounds(50, 50, 800, 600);
	    frame.setVisible(true);
	}*/
}
