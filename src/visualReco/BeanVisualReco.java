package visualReco;

	import java.io.Serializable;

	public class BeanVisualReco implements Serializable{
	private String age_min;
	private String age_max;
	private String gender;
	private String name;
	//3ad zednaha
	private String domaine;

	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	private String image;
	public String getAge_min() {
		return age_min;
	}
	public void setAge_min(String age_min) {
		this.age_min = age_min;
	}
	public String getAge_max() {
		return age_max;
	}
	public void setAge_max(String age_max) {
		this.age_max = age_max;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BeanVisualReco(String age_min, String age_max, String gender, String name,String image,String domaine) {
		super();
		this.age_min = age_min;
		this.age_max = age_max;
		this.gender = gender;
		this.name = name;
		this.image=image;
		this.domaine=domaine;
	}
	public BeanVisualReco() {
		super();
	}

	}
