package com.me.onlinejobsearch.business;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.me.onlinejobsearch.pojo.Job;

public class CreatePDF {

	public void createPDFDoc(List<Job> jobList) {
		Document document = new Document();

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\JobListing.pdf"));
			document.open();
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			Chunk chunk = new Chunk("Job Listing as per your selection");
			Font font = new Font();
			font.setStyle(Font.UNDERLINE);
			font.setStyle(Font.ITALIC);
			chunk.setFont(font);

			Paragraph heading = new Paragraph(chunk);
			heading.setAlignment(Element.ALIGN_CENTER);

			document.add(heading);

			Paragraph p = new Paragraph();
			// add 3 empty line
			addEmptyLine(p, 1);
			document.add(p);

			PdfPTable table = new PdfPTable(6); // 3 columns.

			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Job Id"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Job Title"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Job Details"));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Organization Name"));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Job Type"));
			PdfPCell cell6 = new PdfPCell(new Paragraph("Job Location"));

			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			for (Job job : jobList) {

				PdfPCell row1 = new PdfPCell(new Paragraph(String.valueOf(job.getJobID())));
				PdfPCell row2 = new PdfPCell(new Paragraph(job.getJobTitle()));
				PdfPCell row3 = new PdfPCell(new Paragraph(job.getJobRole()));
				PdfPCell row4 = new PdfPCell(new Paragraph(job.getOrganization().getOrganizationName()));
				PdfPCell row5 = new PdfPCell(new Paragraph(job.getJobCategory()));
				PdfPCell row6 = new PdfPCell(new Paragraph(job.getJobLocation()));

				row1.setHorizontalAlignment(Element.ALIGN_CENTER);
				row2.setHorizontalAlignment(Element.ALIGN_CENTER);
				row3.setHorizontalAlignment(Element.ALIGN_CENTER);
				row4.setHorizontalAlignment(Element.ALIGN_CENTER);
				row5.setHorizontalAlignment(Element.ALIGN_CENTER);
				row6.setHorizontalAlignment(Element.ALIGN_CENTER);

				table.addCell(row1);
				table.addCell(row2);
				table.addCell(row3);
				table.addCell(row4);
				table.addCell(row5);
				table.addCell(row6);

			}

			document.add(table);

			document.close();
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	public void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
