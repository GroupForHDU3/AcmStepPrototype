import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class ChartCreater {
	
	public static CategoryDataset typeCreateDataset2(Map<String,Integer> typemap, String user_name, Map<String,Integer> cmp_typemap, String cmp_name) {
	       
	       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	       Iterator<String> itertype = typemap.keySet().iterator();
	       while(itertype.hasNext()) {
	            String ss = itertype.next();
	            dataset.setValue(typemap.get(ss),user_name,ss);
	       }
	       Iterator<String> itercmptype = cmp_typemap.keySet().iterator();
	       while(itercmptype.hasNext()) {
	            String ss = itercmptype.next();
	            dataset.setValue(cmp_typemap.get(ss),cmp_name,ss);
	       }
	       return dataset;
	   }
	   
	public static CategoryDataset typeCreateDataset(Map<String,Integer> typemap, String user_name) {
	       
	       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	       Iterator<String> itertype = typemap.keySet().iterator();
	       int index = 0;
	       while(itertype.hasNext()) {
	            String ss = itertype.next();
	            dataset.setValue(typemap.get(ss),user_name,ss);
	            index++;
	       }
	       return dataset;
	   }

		public static JFreeChart typeCreateChart(CategoryDataset dataset) //用数据集创建一个图表
	   {
	   	JFreeChart chart=ChartFactory.createBarChart("hi", "类别", 
	               "题数", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
	       chart.setTitle(new TextTitle("按分类题数",new Font("宋体",Font.BOLD+Font.ITALIC,20)));//可以重新设置标题，替换“hi”标题
	       //chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
	       CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
	       CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
	       categoryAxis.setLabelFont(new Font("黑体",Font.BOLD,16));//设置横坐标字体
	       //设置横坐标Label倾斜角度
	       categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
	       BarRenderer render = (BarRenderer) plot.getRenderer();
	       render.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值 
	       render.setBaseItemLabelsVisible(true); 
	       //设置每组柱子间的间隔
	       //render.setItemMargin(0.0);
	      // plot.setBackgroundPaint(Color.lightGray);

	       
	       return chart;
	   }
	   
		public static CategoryDataset timeCreateDataset3(int num, Map<String,Integer> timemap, String timekey[], String user_name, 
			   int cmp_num, String cmp_timekey[], Map<String,Integer> cmp_timemap, String cmp_name) //创建柱状图数据集
	   {	
	       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	       for(int i=0; i<num; i++) {
	       	dataset.setValue(timemap.get(timekey[i]),user_name,timekey[i]);
	       }
	       for(int i=0; i<cmp_num; i++) {
	          	dataset.setValue(cmp_timemap.get(cmp_timekey[i]),cmp_name,cmp_timekey[i]);
	          }
	       return dataset;
	   }
	   
		public static CategoryDataset timeCreateDataset2(String t0, String t1, String t2, String t3, Map<String,Integer> timemap, String user_name)
	   {
	       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	       //System.out.println(t0+t1+t2+t3);
	       int a0 = Integer.parseInt(t0);
	       int a1 = Integer.parseInt(t1);
	       int a2 = Integer.parseInt(t2);
	       int a3 = Integer.parseInt(t3);
	       int index = 0;
	       for(int i=a0; i<=a2; i++)
	       {
	       	int l=1, r=12;
	       	if(i==a0) l = a1;
	       	if(i==a2) r = a3;
	       	for(int j=l; j<=r; j++)
	       	{
	       		String ss = "";
	       		ss = ss + String.valueOf(i);
	       		if(j<10) ss = ss + "0" + String.valueOf(j);
	       		else ss = ss + String.valueOf(j);
	       		if(timemap.containsKey(ss)) {
	       			dataset.setValue(timemap.get(ss), user_name, ss);
	       			index++;
	       		}
	       	}
	       }
	       return dataset;
	   }
	   
		public static CategoryDataset timeCreateDataset(int num, Map<String,Integer> timemap, String timekey[], String user_name) //创建柱状图数据集
	   {	
	       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	       for(int i=0; i<num; i++) {
	       	dataset.setValue(timemap.get(timekey[i]),user_name,timekey[i]);
	       }
	       return dataset;
	   }
	   
		public static JFreeChart timeCreateChart(CategoryDataset dataset) //用数据集创建一个图表
	   {
	   	JFreeChart chart = ChartFactory.createLineChart(
	               "按时间题数",   // chart title
	               null,                       // domain axis label
	               "题数",                   // range axis label
	               dataset,                         // data
	               PlotOrientation.VERTICAL,        // orientation
	               true,                           // include legend
	               true,                            // tooltips
	               false                            // urls
	           );
	   	
	           //chart.setBackgroundPaint(Color.white);

	           CategoryPlot plot = (CategoryPlot) chart.getPlot();
	           
	           //plot.setBackgroundPaint(Color.lightGray);
	           
	           plot.setRangeGridlinesVisible(false);
	           // customise the range axis...
	           NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	           rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	           // customise the renderer...
	           LineAndShapeRenderer renderer 
	                   = (LineAndShapeRenderer) plot.getRenderer();
	           renderer.setBaseShapesVisible(true);
	           renderer.setDrawOutlines(true);
	           renderer.setUseFillPaint(true);
	           renderer.setBaseFillPaint(Color.white);
	           renderer.setSeriesStroke(0, new BasicStroke(3.0f));
	           renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
	           renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
	           CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
	         //设置横坐标Label倾斜角度
	           categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
	           renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值 
	           renderer.setBaseItemLabelsVisible(true); 
	           return chart;
	   }
}
