package model;

public class QualityChecker implements Worker {
	private int stressLevel = 1;

	private void sleep() {
		System.out.println("Zzzzz");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stressLevel = 1;
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		if (stressLevel >= 5) {
			sleep();
		}
		System.out.println("Checking a product");
	}

	public void increaseStress() {
		stressLevel+=1;
	}

	public int getStressLevel() {
		return stressLevel;
	}

}
