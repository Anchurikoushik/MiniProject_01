package com.ashokit.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashokit.entity.CitizenPlan;
import com.ashokit.repo.CitizenPlanRepo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class pdfGenerator {
	
	@Autowired
	private CitizenPlanRepo repo;
	
	public void generate (HttpServletResponse Response,List<CitizenPlan> Plans,File f) throws Exception {
	
	
		
	Document document=new Document(PageSize.A4);
	 PdfWriter.getInstance(document, Response.getOutputStream());
	PdfWriter.getInstance(document, new FileOutputStream(f));
	
	document.open();
	
	Font fonttitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	fonttitle.setSize(25);
	
	Paragraph paragraph=new Paragraph("Citizen plans",fonttitle);
	paragraph.setAlignment(Paragraph.ALIGN_CENTER);
	document.add(paragraph);
	PdfPTable table= new PdfPTable(6);
	table.addCell("ID");
	table.addCell("citizenName");
	table.addCell("planName");
	table.addCell("planStatus");
	table.addCell("planStartDate");
	table.addCell("planEndDate");
	
	List<CitizenPlan> plans = repo.findAll();
	for(CitizenPlan plan:plans) {
		table.addCell(String.valueOf(plan.getCitizenId()));
		table.addCell(plan.getCitizenName());
		table.addCell(plan.getPlanName());
		table.addCell(plan.getPlanStatus());
	   table.addCell(plan.getPlanStartDate()+"");
	   table.addCell(plan.getPlanEndDate()+"");
	}
	document.add(table);
	document.close();
	
	
}

}



