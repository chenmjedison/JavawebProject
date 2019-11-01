package com.lanhai.utils;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtil {

	/**
	 *
	 * @param session
	 * @param pw
	 * @return 返回图片的文件名
	 */
	public static String createBarChart(HttpSession session, PrintWriter pw) {
		String filename = null;

		try {

			// { 1310, 1220, 1110, 1000 } 猪肉的值

			// 4行4列的二维数组
			double[][] data = new double[][] { { 1310, 1220, 1110, 1000 }, { 720, 700, 680, 640 },
					{ 1130, 1020, 980, 800 }, { 440, 400, 360, 300 } };

			// 统计不同地区的肉类的销售情况
			String[] rowKeys = { "pig", "beef", "chicken", "fish" }; // 行的关键字
			String[] columnKeys = { "A", "B", "C", "D" };// 列的关键字

			// 数据源
			CategoryDataset dataset = DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);

			// 调用ChartFactory的方法，创建图表 JFreeChart
			// 大标题 水平方向的标题 type 垂直方向的标题 amount 需要显示的数据 图形的方向（水平和垂直）
			JFreeChart chart = ChartFactory.createBarChart3D("肉类销量统计图", "type", "amount", dataset,
					PlotOrientation.HORIZONTAL, true, true, false);

			// 设置背景颜色
			chart.setBackgroundPaint(Color.GREEN);

			// 设置大标题的字体
			chart.getTitle().setFont(new Font("黑体", Font.BOLD, 18));

			// 将图表保存成一张png图片
			filename = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, session);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return filename;// jfreechart-3278084056632649744.png
	}

	// 创建饼状图
	public static String createPieDataset(HttpSession session, PrintWriter pw) {
		String filename = null;

		try {

			// 数据源
			DefaultPieDataset dataset = new DefaultPieDataset();

			dataset.setValue("男", 55);

			dataset.setValue("女", 45);

			PiePlot3D plot = new PiePlot3D(dataset);

			plot.setBackgroundPaint(Color.gray);
			plot.setForegroundAlpha(0.1f);

			JFreeChart chart = new JFreeChart("男女统计图", new Font("黑体", Font.BOLD, 18), plot, true);

			// 将图表保存成一张png图片
			filename = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, session);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return filename;
	}

}
