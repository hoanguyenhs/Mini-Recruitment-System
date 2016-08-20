/**
 * 
 */
package com.nthrms.report;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.nthrms.model.VacancyModel;
import com.nthrms.pojo.Phase;

/**
 * @author Hoa Nguyen
 * 
 */
public class VacancyGraphPDFBuilder extends AbstractITextPdfView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
	    PdfWriter writer, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	VacancyModel vacancyModel = (VacancyModel) model.get("vacancyModel");
	List<Phase> phaseList = (List<Phase>) model.get("phaseList");

	doc.open();
	for (Phase phase : phaseList) {
	    DefaultPieDataset dataSet = new DefaultPieDataset();
	    dataSet.setValue("Waiting", phase.getWaiting());
	    dataSet.setValue("Pass", phase.getPass());
	    dataSet.setValue("Reject", phase.getReject());

	    JFreeChart chart = ChartFactory.createPieChart(
		    "Statistic number candidate in " + phase.getName()
			    + " phase of vacancy id " + vacancyModel.getId(),
		    dataSet, true, true, false);

	    PdfContentByte cb = writer.getDirectContent();
	    float width = PageSize.A4.getWidth();
	    float height = PageSize.A4.getHeight() / 2;

	    PdfTemplate pie = cb.createTemplate(width, height);
	    Graphics2D g2d1 = new PdfGraphics2D(pie, width, height);
	    Rectangle2D r2d1 = new Rectangle2D.Double(0, 0, width, height);
	    chart.draw(g2d1, r2d1);
	    g2d1.dispose();
	    cb.addTemplate(pie, 0, height);

	    DefaultCategoryDataset dataSet2 = new DefaultCategoryDataset();
	    dataSet2.setValue(phase.getTotal(), "Number candidate", "Total");
	    dataSet2.setValue(phase.getWaiting(), "Number candidate", "Waiting");
	    dataSet2.setValue(phase.getPass(), "Number candidate", "Pass");
	    dataSet2.setValue(phase.getReject(), "Number candidate", "Reject");

	    JFreeChart chart2 = ChartFactory.createBarChart(
		    "Number of candidate in " + phase.getName()
			    + " phase of vacancy id " + vacancyModel.getId(),
		    "Name", "Number", dataSet2,
		    PlotOrientation.VERTICAL, false, true, false);

	    PdfTemplate bar = cb.createTemplate(width, height);
	    Graphics2D g2d2 = new PdfGraphics2D(bar, width, height);
	    Rectangle2D r2d2 = new Rectangle2D.Double(0, 0, width, height);
	    chart2.draw(g2d2, r2d2);
	    g2d2.dispose();
	    cb.addTemplate(bar, 0, 0);
	    doc.newPage();
	}
    }

}
