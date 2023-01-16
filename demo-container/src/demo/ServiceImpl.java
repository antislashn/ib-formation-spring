package demo;

import container.Composant;
import container.Log;

@Composant("service")
public class ServiceImpl implements IService{

	@Override @Log
	public int add(int... is) {
		int total = 0;
		for(int i : is)
			total += i;
		return total;
	}

}
