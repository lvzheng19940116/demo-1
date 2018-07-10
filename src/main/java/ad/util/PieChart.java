// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package ad.util;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class PieChart
{
    public JFreeChart getPieChart(DefaultPieDataset data,String title){
          JFreeChart chart = ChartFactory.createPieChart3D(title,data,true,false,false);
        //设置百分比
          PiePlot pieplot = (PiePlot) chart.getPlot();
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比
       
      //没有数据的时候显示的内容
          pieplot.setNoDataMessage("无数据显示");
          pieplot.setCircular(false);
          pieplot.setLabelGap(0.02D);
       
          pieplot.setIgnoreNullValues(true);//设置不显示空值
          pieplot.setIgnoreZeroValues(true);//设置不显示负值
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
          piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
          return chart;
    }
    
    public DefaultPieDataset getDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("苹果",100);
        dataset.setValue("梨子",200);
        dataset.setValue("葡萄",300);
        dataset.setValue("香蕉",400);
        dataset.setValue("荔枝",500);
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
    
    
    public ChartPanel getChartPanel(JFreeChart chart){
    	ChartPanel frame1 = new ChartPanel (chart,true);
        return frame1;
    }
	
}
