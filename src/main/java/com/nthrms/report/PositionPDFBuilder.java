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
import com.nthrms.model.PositionModel;
import com.nthrms.model.SkillModel;

/**
 * @author Hoa Nguyen
 * 
 */
public class PositionPDFBuilder extends AbstractITextPdfView {

    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
	    Font.BOLD);
    private static Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
	    Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
	    Font.NORMAL);
    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
	    Font.ITALIC);

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
	    PdfWriter writer, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	@SuppressWarnings("unchecked")
	List<SkillModel> skillModelList = (List<SkillModel>) model
		.get("skillModelList");
	PositionModel positionModel = (PositionModel) model
		.get("positionModel");

	doc.add(new Paragraph("Information of position id "
		+ positionModel.getId().toString(), titleFont));
	Paragraph paragraph = new Paragraph();
	paragraph.add(new Chunk("Name: ", boldFont));
	paragraph.add(new Chunk(positionModel.getName(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Year of Experience: ", boldFont));
	paragraph
		.add(new Chunk(positionModel.getYearOfExperience(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Division: ", boldFont));
	paragraph.add(new Chunk(positionModel.getDivision(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Status: ", boldFont));
	paragraph.add(new Chunk(positionModel.getStatus(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Description: ", boldFont));
	paragraph.add(new Chunk(positionModel.getDescription(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Create Date: ", boldFont));
	paragraph.add(new Chunk(positionModel.getCreateDate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Last Update: ", boldFont));
	paragraph.add(new Chunk(positionModel.getLastUpdate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Skill table: ", boldFont));
	doc.add(paragraph);

	PdfPTable table = new PdfPTable(4);
	table.setWidthPercentage(100.0f);
	table.setWidths(new float[] { 0.5f, 2.4f, 1.2f, 3.0f });
	table.setSpacingBefore(10);

	PdfPCell cell = new PdfPCell();
	cell.setBackgroundColor(BaseColor.WHITE);
	cell.setPadding(5);

	cell.setPhrase(new Phrase("Id", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Name", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Type", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Level", boldFont));
	table.addCell(cell);

	for (SkillModel skillModel : skillModelList) {
	    cell.setPhrase(new Phrase(skillModel.getId().toString()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(skillModel.getName()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(skillModel.getType()));
	    table.addCell(cell);
	    if (skillModel.getType().equals("Language")) {
		switch (skillModel.getLevel()) {
		case 1:
		    cell.setPhrase(new Phrase("Beginner"));
		    table.addCell(cell);
		    break;
		case 2:
		    cell.setPhrase(new Phrase("Elementary"));
		    table.addCell(cell);
		    break;
		case 3:
		    cell.setPhrase(new Phrase("Intermediate"));
		    table.addCell(cell);
		    break;
		case 4:
		    cell.setPhrase(new Phrase("Advance"));
		    table.addCell(cell);
		    break;
		case 5:
		    cell.setPhrase(new Phrase("Expert"));
		    table.addCell(cell);
		    break;
		}
	    } else if (skillModel.getType().equals("Domain")) {
		switch (skillModel.getLevel()) {
		case 1:
		    cell.setPhrase(new Phrase("Very bad"));
		    table.addCell(cell);
		    break;
		case 2:
		    cell.setPhrase(new Phrase("Bad"));
		    table.addCell(cell);
		    break;
		case 3:
		    cell.setPhrase(new Phrase("Normal"));
		    table.addCell(cell);
		    break;
		case 4:
		    cell.setPhrase(new Phrase("Good"));
		    table.addCell(cell);
		    break;
		case 5:
		    cell.setPhrase(new Phrase("Very good"));
		    table.addCell(cell);
		    break;
		}
	    } else {
		switch (skillModel.getLevel()) {
		case 1:
		    cell.setPhrase(new Phrase("Limit knowledge"));
		    table.addCell(cell);
		    break;
		case 2:
		    cell.setPhrase(new Phrase("Relative knowledge"));
		    table.addCell(cell);
		    break;
		case 3:
		    cell.setPhrase(new Phrase(
			    "Can perform well with assistance"));
		    table.addCell(cell);
		    break;
		case 4:
		    cell.setPhrase(new Phrase(
			    "Can perform well without assistance"));
		    table.addCell(cell);
		    break;
		case 5:
		    cell.setPhrase(new Phrase(
			    "Expert knowledge and can lead a team"));
		    table.addCell(cell);
		    break;
		}
	    }
	}
	doc.add(table);
	doc.add(new Paragraph("Report generated at " + new Date(), smallFont));
    }
}
