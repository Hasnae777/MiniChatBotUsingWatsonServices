package visualReco;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageLink;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class Test {
	public static void main(String[] arg) throws IOException {

	/*
		 ***************** classification
		 
			String filename = new String();
			filename = "C:/Users/hp/Desktop/voiture.jpeg";
			File image = new File(filename);
		  VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		  service.setEndPoint( "https://gateway-a.watsonplatform.net/visual-recognition/api");
		  service.setApiKey("145c9649a9c70bc9e1d2bf7212c83ba3f2d8720f");
		 		  
		  
		  System.out.println("Classify an image"); 
		  ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(image).build(); 
		  VisualClassification result = service.classify(options).execute(); 
		  System.out.println(result);*/
		  
		  /* *****************Faces recognition local picture
		 * 
		 * 
		 */
		String filename = new String();
		filename = "C:/Users/hp/Desktop/Corpus/decaprio.jpg";
		File image = new File(filename);
		// credentiels service
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		// service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
		service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

		// call detectFaces of the VisualRecognitionservice
		VisualRecognitionOptions detectFaces = new VisualRecognitionOptions.Builder().images(image).build();
		DetectedFaces result = service.detectFaces(detectFaces).execute();
		System.out.println(result);

		/** extract from json
		try{
			 
			String age_min=result.getImages().get(0).getFaces().get(0).getAge().getMin().toString();

		
		}catch(NullPointerException e){
			System.out.println("annonymous");

		}
		
		 /* *****************Faces recognition url
		 * 
		 
		
		try {
			URL url = new URL("http://jis.gov.jm/media/Obama-640x425.jpg");
		
			
			BufferedImage img = ImageIO.read(url);
			File file = new File("kim1.png");
			ImageIO.write(img, "png", file);
		
			// credentiels service
			VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
			// service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
			service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

			// call detectFaces of the VisualRecognitionservice
			VisualRecognitionOptions detectFaces = new VisualRecognitionOptions.Builder().images(file).build();
			DetectedFaces result = service.detectFaces(detectFaces).execute();
			System.out.println(result);
			
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		*************** Create classifier
		
		 VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		  	service.setApiKey("abae185de0cef662aa1681131d8dc4af954ceb1f");
	/* le bout de code qui vient juste après est à exécuter une seule fois pour que les fichiers .zip soient enregistrés dans votre compte bluemix référencier ici par l'APIKEY
	
		  	ClassifierOptions classifierOptions = new ClassifierOptions.Builder()
		  	    .classifierName("adult")
		  	    .addClass("men", new File("C:/Users/hp/Desktop/homme.zip"))
		  	    .addClass("femme", new File("C:/Users/hp/Desktop/femme.zip"))
		  	    .addClass("lunettes", new File("C:/Users/hp/Desktop/lunettes.zip"))
		  	    .addClass("smiling", new File("C:/Users/hp/Desktop/smiling.zip"))
		  	    .negativeExamples(new File("C:/Users/hp/Desktop/enfant.zip"))
		  	    .build();

		  	VisualClassifier adultClassifier = service.createClassifier(classifierOptions).execute();

		  	ClassifyImagesOptions classifyOptionsMen = new ClassifyImagesOptions.Builder()
		  	    .classifierIds("homme_721818373")/* pour récupéer l'id de votre classifier créé au-dessus, consulez-vous la page suivante
		  	     "https://watson-api-explorer.mybluemix.net/apis/visual-recognition-v3#!/visual45recognition/get_v3_classifiers" et cherchez-vous parmi
		  	      les geters(couleur blue) celui qui a le titre "Retrieve a list of custom classifiers" puis saisissez-vous votre Apikey. voir l'image en annexe
		  	    .images(new File ("C:/Users/hp/Desktop/obama.jpg"))// le fichier dog.jpg seulement pour le test
		  	    .threshold(0.0)
		  	    .build();

		  	VisualClassification resultMen = service.classify(classifyOptionsMen).execute();
		  	System.out.println(resultMen);*/
		
	}
}