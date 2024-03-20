package PDFComparison.PDFUtilComparison;

import java.io.IOException;

import org.testng.annotations.Test;

import com.raktimtech1989.utility.CompareMode;
import com.raktimtech1989.utility.PDFUtil;



public class DemoPDFTest {
	
	PDFUtil pdfUtil = new PDFUtil() ;
	
	//To get page count
	
	@Test
	public  void getPageCount() throws IOException
	{
	   int count =  pdfUtil.getPageCount("/PDFUtilComparison/src/test/resources/image-compare-same/sample1.pdf") ;  
	   System.out.println("PAGE CPUNT OF THE SAMPLE PDF IS  "  + count);
		
	}
	
	//To get page content as plain text from page 3 - 4
	
	@Test
	public  void getPageContentForPages() throws IOException
	{
	   String text =  pdfUtil.getText("/PDFUtilComparison/src/test/resources/image-compare-same/sample1.pdf" , 3 ,4) ;  
	   System.out.println(text);
		
	}
	
	//To get page content as plain text for page 3
	
		@Test
		public  void getPageContentForPage() throws IOException
		{
		   String text =  pdfUtil.getText("/PDFUtilComparison/src/test/resources/image-compare-same/sample1.pdf" , 3 ) ;  
		   System.out.println(text);
		   
			
		}
		
		//To extract attached images from PDF for page-2 & 3
		@Test
		public  void extractImages() throws IOException
		{
		    //set the path where we need to store the images
			pdfUtil.setImageDestinationPath("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/imgpath");
			pdfUtil.extractImages("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/image-extract/sample.pdf" , 2,3) ;			
		}
		
		
		//To store PDF pages as images for page 2 & 3
		@Test
		public  void storeImagesAsPDF() throws IOException
		{
		    //set the path where we need to store the images
			pdfUtil.setImageDestinationPath("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/imgpath");
			pdfUtil.savePdfAsImage("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/image-extract/sample.pdf" , 2,3) ;			
		}
		
		//To compare PDF files in text mode (faster – But it does not compare the format, images etc in the PDF)
		@Test
		public  void comparePDF() throws IOException
		{
			// compares the pdf documents and returns a boolean
			// true if both files have same content. false otherwise.
			
			String file1 = "/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/text-compare/sample1.pdf" ;
			String file2 = "/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/text-compare/sample2.pdf" ;
			pdfUtil.compare(file1, file2) ;
			
			// compare the 3rd page alone
			pdfUtil.compare(file1, file2 , 3) ;
			
			//To exclude certain text while comparing PDF files in text mode
			pdfUtil.excludeText("1998", "testautomation");
			
			//pass regex patterns to be removed before comparing
			// \\d+ removes all the numbers in the pdf before comparing
			pdfUtil.excludeText("\\d+");
			pdfUtil.compare(file1, file2) ;
			
		}
		
		//To extract attached images from PDF for page-2 & 3To compare PDF files in Visual mode (slower – compares PDF documents pixel by pixel – highlights pdf difference & store the result as image)	@Test
		@Test		
		public  void comparePDFvisualMode() throws IOException
		 {
			String file1 = "/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/text-compare/sample1.pdf" ;
			String file2 = "/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/src/test/resources/text-compare/sample2.pdf" ;
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
			boolean flag =pdfUtil.compare(file1, file2) ;
			System.out.println(flag);
			
			//if you need to store the result
			pdfUtil.highlightPdfDifference(true);
			pdfUtil.setImageDestinationPath("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/imgpath");
			pdfUtil.compare(file1, file2);
			
		 }
		
}
