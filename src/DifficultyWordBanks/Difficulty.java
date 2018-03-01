package DifficultyWordBanks;

import java.util.HashMap;

public class Difficulty {

	protected HashMap<String, String[]> easyWordBank = new HashMap<>();
	protected HashMap<String, String[]> mediumWordBank = new HashMap<>();
	protected HashMap<String, String[]> hardWordBank = new HashMap<>();
	
	private void createEasyWordBank() {
		
	}
	
	private void createMediumWordBank() {
		
	}
	
	private void createHardWordBank() {
		
	}
	
	public HashMap<String, String> getMediumWordBank() {
		return mediumWordBank;
	}

	public void setMediumWordBank(HashMap<String, String> mediumWordBank) {
		this.mediumWordBank = mediumWordBank;
	}

	public HashMap<String, String> getHardWordBank() {
		return hardWordBank;
	}

	public void setHardWordBank(HashMap<String, String> hardWordBank) {
		this.hardWordBank = hardWordBank;
	}


	public HashMap<String, String> getEasyWordBank() {
		return easyWordBank;
	}

	private void setEasyWordBank(HashMap<String, String> easyWordBank) {
		this.easyWordBank = easyWordBank;
	}
	
	
}
