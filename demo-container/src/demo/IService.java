package demo;

import container.Composant;
import container.Log;

public interface IService {
	@Log
	int add(int...is);
}
