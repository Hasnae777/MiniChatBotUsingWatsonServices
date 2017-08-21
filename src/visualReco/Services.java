package visualReco;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

public class Services {

	
	public BeanVisualReco getVisualRecoBeanURL(String URL) throws IOException{
		BeanVisualReco result=new BeanVisualReco();
		
		URL url = new URL(URL);
		
		
		BufferedImage img = ImageIO.read(url);
		File file = new File("transformed.jpg");
		ImageIO.write(img, "jpg", file);
	
		// credentiels service
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		// service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
		service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

		// call detectFaces of the VisualRecognitionservice
		VisualRecognitionOptions detectFaces = new VisualRecognitionOptions.Builder().images(file).build();
		DetectedFaces resultat = service.detectFaces(detectFaces).execute();
		//System.out.println(result);

		/** Extract from json*/
			
			String picture= resultat.getImages().get(0).getImage(); 
			result.setImage(URL);
		
			String age_min=resultat.getImages().get(0).getFaces().get(0).getAge().getMin().toString();
			result.setAge_min(age_min);
			
			String age_max=resultat.getImages().get(0).getFaces().get(0).getAge().getMax().toString();
			result.setAge_max(age_max);
			
			String gender=resultat.getImages().get(0).getFaces().get(0).getGender().getGender();
			result.setGender(gender);
		try{
			String name=resultat.getImages().get(0).getFaces().get(0).getIdentity().getName();
			result.setName(name);
			
		}catch(NullPointerException e){
			result.setName("annonymous");

		}
		try{
			String hierarchy=resultat.getImages().get(0).getFaces().get(0).getIdentity().getTypeHierarchy();
			String[] parts = hierarchy.split("/");
			int l=parts.length;
			/*String domaine="";
			int k=0;
			while( k< l-1){
				domaine=domaine+parts[k]+" / ";
				k++;
			}*/
			result.setDomaine(parts[l-2]);
			
		}catch(NullPointerException e){
			result.setDomaine("annonymous");

		}
		
		return result;
	}
	
	
}
