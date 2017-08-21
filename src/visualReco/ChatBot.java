package visualReco;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;

import java.lang.Math;
import java.net.URL;

public class ChatBot extends JFrame implements KeyListener {
	
	
	
	
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	
	String[][] chatBot={
		//standard greetings
		{"hi","hello","hola","ola","howdy"},
		{"hi","hello","hey"},
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		//default
		{"shut up","you're bad","noob","stop talking",
		"(michael is unavailable, due to LOL)"},
		//image processing file
		{"process image file"},
		{"give me path or URL"},
		//image processing url
		{"process image url"},
		{"give me path or URL"}
		
		
	};
	
	public static void main(String[] args){
		
		new ChatBot();
	}
	
	public ChatBot(){
		super("Chat Bot");
		setSize(600,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(77, 121, 255));
		add(p);
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
			input.setEditable(false);
			
			
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;
			
			
			
			if(quote.startsWith("url:")){
				Services services=new Services();
				quote=quote.replace("url:", "");
				try {
					BeanVisualReco result=services.getVisualRecoBeanURL(quote);
					addText("\n-->Hasnae&Asmae Chatbot\t"+ System.lineSeparator() +"Name: "+result.getName()+ System.lineSeparator() +" Gender: "+ result.getGender()+ System.lineSeparator() +" Age min : "+result.getAge_min()+ System.lineSeparator() +" Age max: "+result.getAge_max()+ System.lineSeparator() +" Domaine: "+result.getDomaine());

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}		
					
			
			
			if(quote.startsWith("file:")){
				BeanVisualReco result=new BeanVisualReco();

				quote=quote.replace("file:", "");
				File image = new File(quote);
				// credentiels service
				VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
				// service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
				service.setApiKey("1f8d933c93d328ac4226d436e5b50663f254fba0");

				// call detectFaces of the VisualRecognitionservice
				VisualRecognitionOptions detectFaces = new VisualRecognitionOptions.Builder().images(image).build();
				DetectedFaces resultat = service.detectFaces(detectFaces).execute();
				

				String age_min=resultat.getImages().get(0).getFaces().get(0).getAge().getMin().toString();
				result.setAge_min(age_min);
				
				String age_max=resultat.getImages().get(0).getFaces().get(0).getAge().getMax().toString();
				result.setAge_max(age_max);
				
				String gender=resultat.getImages().get(0).getFaces().get(0).getGender().getGender();
				result.setGender(gender);
			try{
				String name=resultat.getImages().get(0).getFaces().get(0).getIdentity().getName();
				result.setName(name);
			
			}catch(NullPointerException e1){
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
				
			}catch(NullPointerException e2){
				result.setDomaine("annonymous");

			}
			
				addText("\n-->The bitch\t"+ System.lineSeparator() +"Name: "+result.getName()+ System.lineSeparator() +" Gender: "+ result.getGender()+ System.lineSeparator() +" Age min : "+result.getAge_min()+ System.lineSeparator() +" Age max: "+result.getAge_max()+ System.lineSeparator() +" Domaine: "+result.getDomaine());

			}
			
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			while(response==0){										
				
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n-->The bitch\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && response==0){
					response=1;
				}
			}
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->The bitch\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
	
}