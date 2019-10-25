public class ObserverPatternTest 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		EyeOfSauron eye = new EyeOfSauron();
		int hobCount, dwarfCount, elfCount, manCount;
		BadGuy saruman = new BadGuy(eye, "Saruman");
		BadGuy witchKing = new BadGuy(eye, "Witch King");
		
		System.out.println("\t\tEye Of Sauron Reports");
		System.out.println("Current number of members: " + eye.countObservers());
		
		hobCount = 10;
		dwarfCount = 20;
		elfCount = 50;
		manCount = 100;
		eye.setEnemies(hobCount, dwarfCount, elfCount, manCount);
		eye.setEnemies(hobCount, dwarfCount, elfCount, manCount);
		hobCount = 3;
		dwarfCount = 8;
		elfCount = 37;
		manCount = 98;
		eye.setEnemies(hobCount, dwarfCount, elfCount, manCount);
		
		saruman.defeated();
		
		hobCount = 1;
		dwarfCount = 3;
		elfCount = 12;
		manCount = 67;
		eye.setEnemies(hobCount, dwarfCount, elfCount, manCount);
		
		hobCount = 1;
		dwarfCount = 2;
		elfCount = 1;
		manCount = 5;
		eye.setEnemies(hobCount, dwarfCount, elfCount, manCount);
		
		witchKing.defeated();
	
		System.out.println("Current number of members: " + eye.countObservers());
	}
}
