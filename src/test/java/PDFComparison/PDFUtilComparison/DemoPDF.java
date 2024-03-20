package PDFComparison.PDFUtilComparison;

import java.io.FileWriter;
import java.io.IOException;

import com.raktimtech1989.utility.PDFUtil;


public class DemoPDF {
	
	
	public static boolean fileMatches(String file1 , String file2) throws IOException
	{
		PDFUtil pdfUtil = new PDFUtil();
		return pdfUtil.compare(file1, file2);

	}

	public static void main(String[] args) throws IOException {
		PDFUtil pdfUtil = new PDFUtil();
		 int count = pdfUtil.getPageCount("/Users/raktimsarkar/Downloads/ITC Infotech_Service Letter.pdf"); 
		 System.out.println("PAGE COUNT OF PDF IS  "  +  count);
		 
		 
		String text =  pdfUtil.getText("/Users/raktimsarkar/Downloads/ITC Infotech_Service Letter.pdf" , 1) ;
		FileWriter fWriter = new FileWriter(
                "/Users/raktimsarkar/Downloads/demo.docx");
		fWriter.write(text);
				
				System.out.println(text);
				 fWriter.close();
					
		//to extract attched images from PDF -
		//pdfUtil.setImageDestinationPath("/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/imgpath");
		//pdfUtil.extractImages("/Users/raktimsarkar/Downloads/DevOps+Project.pdf",2,2);
		
		String file1 = "/Users/raktimsarkar/Downloads/ITC Infotech_Service Letter.pdf" ;
		String file2 = "/Users/raktimsarkar/eclipse-workspace/PDFUtilComparison/ITC Infotech_Service Letter.pdf" ;
		
		System.out.println(pdfUtil.compare(file1, file2));
		
		
		
		

	}

}
