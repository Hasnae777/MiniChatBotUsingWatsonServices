package visualReco;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.*;
import java.io.File;
public class Test2 {



		public static void main(String[] args) {
			/*String filename=new String();
			filename="C:/Users/AnjarLahcen/Desktop/5.jpg";
			File image=new File(filename);
		  //credentiels service 
		  		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		  	    //service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
		  	    service.setApiKey("bd51815fdd63721309a2fdfd48780e0bf84373ff");
		  	    
		  	    // call detectFaces of the VisualRecognitionservice
		  	    VisualRecognitionOptions detectFaces = new VisualRecognitionOptions.Builder().images(image).build();
		  	    DetectedFaces result = service.detectFaces(detectFaces).execute();
		  	    System.out.println(result);
		  	    */
				/*
				 * 
				 * 
				 * { "classifiers":[
	{
	    "classifier_id": "dogs_1001283839",
	    "name": "dogs",
	    "owner": "54c9885f-903c-43a1-aab4-fd8af8267771",
	    "status": "ready",
	    "created": "2017-04-14T01:02:40.851Z",
	    "classes": [
	        {"class": "husky"},
	        {"class": "goldenRetriever"},
	        {"class": "beagle"}
	    ]
	}]
	}*/
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

		ClassifierOptions classifierOptions = new ClassifierOptions.Builder().classifierName("dogs")
				.addClass("husky", new File("C:/Users/hp/Desktop/husky.zip"))
				.negativeExamples(new File("C:/Users/hp/Desktop/cats.zip")).build();

		VisualClassifier dogsClassifier = service.createClassifier(classifierOptions).execute();

		ClassifyImagesOptions classifyOptionsDogs = new ClassifyImagesOptions.Builder().classifierIds("dogs_1001283839")
				.images(new File("C:/Users/hp/Desktop/dog.jpg"))// le fichier
																// dog.jpg
																// seulement
																// pour le test
				.threshold(0.0).build();

		VisualClassification resultDogs = service.classify(classifyOptionsDogs).execute();
		System.out.println(resultDogs);
		  	
		  	
		  	
			/*VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		  	service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");
	
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
		  	    .classifierIds("homme_721818373")
		  	    .images(new File ("C:/Users/hp/Desktop/Corpus/obama.jpg"))// le fichier dog.jpg seulement pour le test
		  	    .threshold(0.0)
		  	    .build();

		  	VisualClassification resultMen = service.classify(classifyOptionsMen).execute();
		  	System.out.println(resultMen);*/
			
			
			
		
		/*String filename = new String();
		filename = "C:/Users/hp/Desktop/Corpus/decaprio.jpg";
		File image = new File(filename);
		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
		service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

		System.out.println("Classify an image");
		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().images(image).build();
		VisualClassification result = service.classify(options).execute();
		System.out.println(result);*/

		}

	}


