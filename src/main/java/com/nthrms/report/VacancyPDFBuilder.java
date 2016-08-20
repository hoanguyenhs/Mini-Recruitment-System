/**
 * 
 */
package com.nthrms.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nthrms.model.VacancyModel;
import com.nthrms.pojo.Phase;

/**
 * @author Hoa Nguyen
 * 
 */
public class VacancyPDFBuilder extends AbstractITextPdfView {

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
	    Font.BOLD);
    private static Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
	    Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
	    Font.NORMAL);
    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
	    Font.ITALIC);

    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
	    PdfWriter writer, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	VacancyModel vacancyModel = (VacancyModel) model.get("vacancyModel");
	List<Phase> phaseList = (List<Phase>) model.get("phaseList");

	doc.add(new Paragraph("Information of vacancy id "
		+ vacancyModel.getId().toString(), titleFont));
	Paragraph paragraph = new Paragraph();
	paragraph.add(new Chunk("Name: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getName(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Amount: ", boldFont));
	paragraph
		.add(new Chunk(vacancyModel.getAmount().toString(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Position: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getPositionName(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Start Date: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getStartDate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("End Date: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getEndDate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Status: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getStatus(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Description: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getDescription(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Create Date: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getCreateDate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Last Update: ", boldFont));
	paragraph.add(new Chunk(vacancyModel.getLastUpdate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Phase detail: ", boldFont));
	doc.add(paragraph);

	PdfPTable table = new PdfPTable(5);
	table.setWidthPercentage(100.0f);
	table.setWidths(new float[] { 2f, 2f, 2f, 2f, 2f });
	table.setSpacingBefore(10);

	PdfPCell cell = new PdfPCell();
	cell.setBackgroundColor(BaseColor.WHITE);
	cell.setPadding(5);

	cell.setPhrase(new Phrase("Name", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Total", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Waiting", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Pass", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Reject", boldFont));
	table.addCell(cell);

	for (Phase phase : phaseList) {
	    cell.setPhrase(new Phrase(phase.getName()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(phase.getTotal().toString()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(phase.getWaiting().toString()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(phase.getPass().toString()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(phase.getReject().toString()));
	    table.addCell(cell);
	}
	doc.add(table);
	doc.add(new Paragraph("Report generated at " + new Date(), smallFont));
    }

}
