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
import com.nthrms.model.CandidateModel;
import com.nthrms.model.CertificateModel;
import com.nthrms.model.ExperienceModel;
import com.nthrms.model.SkillModel;

/**
 * @author Hoa Nguyen
 * 
 */
public class CandidatePDFBuilder extends AbstractITextPdfView {

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
	CandidateModel candidateModel = (CandidateModel) model
		.get("candidateModel");
	List<SkillModel> skillModelList = (List<SkillModel>) model
		.get("skillModelList");
	List<CertificateModel> certificateModelList = (List<CertificateModel>) model
		.get("certificateModelList");
	List<ExperienceModel> experienceModelList = (List<ExperienceModel>) model
		.get("experienceModelList");

	doc.add(new Paragraph("Information of candidate id "
		+ candidateModel.getId().toString(), titleFont));
	Paragraph paragraph = new Paragraph();
	paragraph.add(new Chunk("First Name: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getFirstName(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Last Name: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getLastName(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Phone: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getPhone(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Email: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getEmail(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Address: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getAddress(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Link: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getLink(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Staus: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getStatus(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Description: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getDescription(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Create Date: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getCreateDate(), normalFont));
	doc.add(paragraph);
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Last Update: ", boldFont));
	paragraph.add(new Chunk(candidateModel.getLastUpdate(), normalFont));
	doc.add(paragraph);
	//Certificate table
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Certificate table: ", boldFont));
	doc.add(paragraph);
	
	PdfPTable table = new PdfPTable(5);
	table.setWidthPercentage(100.0f);
	table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
	table.setSpacingBefore(10);
	
	PdfPCell cell = new PdfPCell();
	cell.setBackgroundColor(BaseColor.WHITE);
	cell.setPadding(5);
	
	cell.setPhrase(new Phrase("Name", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("School", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Score", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Start Date", boldFont));
	table.addCell(cell);
	
	cell.setPhrase(new Phrase("End Date", boldFont));
	table.addCell(cell);
	
	for (CertificateModel certificateModel : certificateModelList){
	    cell.setPhrase(new Phrase(certificateModel.getName()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(certificateModel.getSchool()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(certificateModel.getScore()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(certificateModel.getStartDate()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(certificateModel.getEndDate()));
	    table.addCell(cell);
	}
	doc.add(table);
	//Experience table
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Experience table: ", boldFont));
	doc.add(paragraph);
	
	table = new PdfPTable(5);
	table.setWidthPercentage(100.0f);
	table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
	table.setSpacingBefore(10);
	
	cell = new PdfPCell();
	cell.setBackgroundColor(BaseColor.WHITE);
	cell.setPadding(5);
	
	cell.setPhrase(new Phrase("Position", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Company", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Salary", boldFont));
	table.addCell(cell);

	cell.setPhrase(new Phrase("Start Date", boldFont));
	table.addCell(cell);
	
	cell.setPhrase(new Phrase("End Date", boldFont));
	table.addCell(cell);
	
	for (ExperienceModel experienceModel : experienceModelList){
	    cell.setPhrase(new Phrase(experienceModel.getPosition()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(experienceModel.getCompany()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(experienceModel.getSalary()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(experienceModel.getStartDate()));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase(experienceModel.getEndDate()));
	    table.addCell(cell);
	}
	doc.add(table);
	//Skill table
	paragraph = new Paragraph();
	paragraph.add(new Chunk("Skill table: ", boldFont));
	doc.add(paragraph);

	table = new PdfPTable(4);
	table.setWidthPercentage(100.0f);
	table.setWidths(new float[] { 0.5f, 2.4f, 1.2f, 3.0f });
	table.setSpacingBefore(10);

	cell = new PdfPCell();
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
