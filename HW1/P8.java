package elice;

public class Country {
	private String code;//Use this variable
	private String name; //Use this variable
	private String capital; //Use this variable
	private int life_expectancy; //Use this variable
	
	public Country(String code_, String name_, String capital_, int life_expectancy_) {
		//implement here
	    code = code_;
        name = name_;
        capital = capital_;
        life_expectancy = life_expectancy_;
    }
	
	public String getCode() {
		//implement here
        return code;
	}
	public String getName() {
		//implement here
        return name;
	}
	
	public String getCapital() {
		//implement here
        return capital;
	}
	
	public int getLifeExp() {
		//implement here
        return life_expectancy;
	}
}
